package com.car.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @author 孙磊 on 2018/7/20
 * @version 1.0
 * @apiNote 基本控制器
 */
public abstract class BaseControl {

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        return request;
    }

    public HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getResponse();
        return response;
    }

    public Result successResponse() {
        return successResponse(null);
    }

    public Result successResponse(Map<String, Object> model) {
        Result result = new Result();
        result.setRet(200);
        result.setMsg("success");
        result.setModel(model);
        return result;
    }

    public Result successResponse(Map<String, Object> model, String msg) {
        Result result = new Result();
        result.setRet(200);
        result.setMsg(msg);
        result.setModel(model);
        return result;
    }

    public ModelAndView createMav(String viewName, Map<String, ?> model) {
        return new ModelAndView(viewName, model);
    }
    public int getStart(Integer start){
        return start == null? 0 : start.intValue();
    }
    public int getLimit(Integer limit){
        return limit == null? 10 : limit.intValue();
    }

    @JsonInclude(Include.NON_NULL)
    public static class Result {
        private int ret;

        private String msg;

        private Map<String, Object> model;

        public int getRet() {
            return ret;
        }

        public void setRet(int ret) {
            this.ret = ret;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Map<String, Object> getModel() {
            return model;
        }

        public void setModel(Map<String, Object> model) {
            this.model = model;
        }

        public void addModel(String key, Object object) {
            if (model == null) {
                model = new HashMap<>();
            }
            model.put(key, object);
        }

    }
}

