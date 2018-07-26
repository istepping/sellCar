package com.car.dto;

import java.util.List;

/**
 * @author 孙磊 on 2018/7/16
 * @version 1.0
 * @apiNote 服务返回的数据对象
 */
public class ServiceResult {
    /**服务结果*/
    private boolean result;
    /**结果标志码*/
    private int state;
    /**信息*/
    private String info;
    /**返回的数据对象*/
    private List<Object> data;
    public ServiceResult(){}
    public ServiceResult(boolean result,int state,String info){
        this.result=result;
        this.state=state;
        this.info=info;
    }
    public ServiceResult(boolean result,int state,String info,List<Object> data){
        this.result=result;
        this.state=state;
        this.info=info;
        this.data=data;
    }
    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    /**
     * @author 张兴邦 on 2018/7/16
     * @apiNote toString
     * @return  String
     */
    @Override
    public String toString() {
        return "result:"+this.result+
                " state:"+this.state+
                " info:"+this.info+"\n";
    }

}
