package com.car.utils;







import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPublicKey;

/**
 * @author 孙磊 on 2018/7/22
 * @version 1.0
 * @apiNote 加密工具
 */
public class RSAUtils {


    //KeyPair is a simple holder for a key pair.
    private static final KeyPair keyPair = initKey();
    /**
     * 初始化方法，产生key pair，提供provider和random
     * @return KeyPair instance
     */
    private static KeyPair initKey() {

        try {
            //添加provider
            Provider provider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
            Security.addProvider(provider);
            //产生用于安全加密的随机数
            SecureRandom random = new SecureRandom();

            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", provider);
            generator.initialize(1024, random);
            return generator.generateKeyPair();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 产生public key
     * @return public key字符串
     */
    public static String generateBase64PublicKey() {
        PublicKey publicKey = (RSAPublicKey)keyPair.getPublic();

        //encodeBase64(): Encodes binary data using the base64
        //algorithm but does not chunk the output.
        //getEncoded():返回key的原始编码形式
        return new String(Base64.encode(publicKey.getEncoded()));
    }
    /**
     * 解密数据
     * @param string 需要解密的字符串
     * @return  破解之后的字符串
     */
    public static String decryptBase64(String string) {
        //decodeBase64():将Base64数据解码为"八位字节”数据
        return new String(decrypt(Base64.decode(string.getBytes())));
    }

    private static byte[] decrypt(byte[] byteArray) {
        try {
            Provider provider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
            Security.addProvider(provider);
            //Cipher: 提供加密和解密功能的实例
            //transformation: "algorithm/mode/padding"
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", provider);
            PrivateKey privateKey = keyPair.getPrivate();
            //初始化
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            //doFinal(): 加密或者解密数据
            byte[] plainText = cipher.doFinal(byteArray);
            return plainText;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
