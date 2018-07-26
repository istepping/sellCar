package com.car.entity;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote Nev类 新能源汽车
 */
public class Nev extends Car {
    /** 能源类型 */
    public String cEnergy;
    public  Nev(){}
    public  Nev(long cId, String cBrand, String cColor, String cPrice, int cNum, String cUrl, int cState,String cCatalog,String cEnergy){
        super(cId, cBrand, cColor, cPrice, cNum, cUrl, cState,cCatalog);
        this.cEnergy = cEnergy;
    }
    public Nev( String cBrand, String cColor, String cPrice, int cNum,int cState,String cCatalog,String cEnergy){
        super( cBrand, cColor, cPrice, cNum ,cCatalog,cState);
        this.cEnergy = cEnergy;
    }

    public String getcEnergy() {
        return cEnergy;
    }
    public void setcEnergy(String cEnergy) {
        this.cEnergy = cEnergy;
    }
    public String toString(){
        return "com.car.entity.Nev{"+super.toString()+
                " 汽车型号:"+this.cEnergy+
                "}\n";
    }
}
