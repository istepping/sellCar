package com.car.entity;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote SportCar类 跑车
 */
public class SportCar extends Car {
    /** 跑车风格 */
    public String cStyle;
    public SportCar(){}
    public  SportCar(long cId, String cBrand, String cColor, String cPrice, int cNum, String cUrl, int cState,String cCatalog,String cStyle){
        super(cId, cBrand, cColor, cPrice, cNum, cUrl, cState,cCatalog);
        this.cStyle = cStyle;
    }
    public SportCar( String cBrand, String cColor, String cPrice, int cNum,int cState,String cCatalog,String cStyle){
        super( cBrand, cColor, cPrice, cNum ,cCatalog,cState);
        this.cStyle = cStyle;
    }

    public String getcStyle() {
        return cStyle;
    }

    public void setcStyle(String cStyle) {
        this.cStyle = cStyle;
    }
    public String toString(){
        return "com.car.entity.SportCar{"+super.toString()+
                " 汽车型号:"+this.cStyle+
                "}\n";
    }
}

