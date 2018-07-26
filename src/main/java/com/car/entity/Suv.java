package com.car.entity;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote Suv类 多功能越野车
 */
public class Suv extends Car {
    /** 汽车型号*/
    public String cType;
    public  Suv(){}
    public  Suv(long cId, String cBrand, String cColor, String cPrice, int cNum, String cUrl, int cState,String cCatalog, String cType){
        super(cId, cBrand, cColor, cPrice, cNum, cUrl, cState,cCatalog);
        this.cType = cType;
    }
    public Suv( String cBrand, String cColor, String cPrice, int cNum,int cState,String cCatalog,String cType){
        super( cBrand, cColor, cPrice, cNum ,cCatalog,cState);
        this. cType= cType;
    }
    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }
    public String toString(){
        return "com.car.entity.Suv{"+super.toString()+
                " 汽车型号:"+this.cType+
                "}\n";
    }
}

