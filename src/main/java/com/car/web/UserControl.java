package com.car.web;

import com.car.biz.UserBiz;
import com.car.biz.UserBizIml;
import com.car.dto.OrderInfo;
import com.car.dto.ServiceResult;
import com.car.entity.Car;
import com.car.entity.User;
import com.car.service.UserServiceIml;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.car.utils.LoginMag.checkUserLogin;
import static com.car.utils.LoginMag.userLoginMagMap;
import static com.car.utils.StaticMethod.logger;

/**
 * @author 孙磊 on 2018/7/19
 * @version 1.0
 * @apiNote 用户信息操作控制器
 */
@Controller
@RequestMapping(value = "/sell/userCentral")
public class UserControl extends BaseControl{
    @Autowired
    private UserServiceIml userService;
    @Autowired
    private UserBizIml userBizIml;
    /**
     * @author 孙磊 on 2018/7/16
     * @apiNote 个人中心信息
     */
    @RequestMapping(value = "/me",method = RequestMethod.GET)
    public ModelAndView userCentral(ModelAndView mv, @RequestParam("uId") long uId){
        if(checkUserLogin(uId)){
            //获取数据
            logger.info("/me:userLogin");
            User user=userBizIml.getUserById(uId);
            mv.addObject("user",user);
            //订单
            List<OrderInfo> orders=new ArrayList<>();
            ServiceResult serviceResult=userService.lookOrder(uId,orders);
            if(serviceResult.isResult()){
                logger.info("/me:getOrders");
                mv.addObject("orders",orders);
            }
            //收藏
            List<Car> cars=new ArrayList<>();
            ServiceResult serviceResult1=userService.lookCollection(uId,cars);
            if(serviceResult1.isResult()){
                mv.addObject("cars",cars);
            }
            mv.setViewName("/user/userCentral");
        }
        else{
            //跳转登陆
            logger.info("/me:userNotLogin");
            mv.setViewName("userLogin");
        }
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 用户退出登陆
     * @param  uId 用户id
     */
    @RequestMapping(value = "/logOut",method = RequestMethod.GET)
    public ModelAndView userLogOut(ModelAndView mv, @RequestParam("uId") long uId){
        userService.userLoginOut(uId);
        mv.setViewName("/userLogOut/userLogOut");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 改变用户信息,ajax请求,返回用result封装成json.
     * @param uId 用户id
     * @param  phone 手机号
     * @param address 地址
     * @return  返回信息
     */
    @RequestMapping(value = "/changeUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public Result changeUserInfo(@Param("uId")long uId,@Param("phone")String phone,@Param("address")String address){
        logger.info("changeUserInfo");
        Map<String,Object> map=new HashMap<>();
        //do service
        if(phone.length()!=11){
            map.put("result","fail");
            map.put("msg","手机号格式不正确!");
            return successResponse(map);
        }
        ServiceResult serviceResult=userService.changeUserPhone(uId,phone);
        ServiceResult serviceResult1=userService.changeUserAddress(uId,address);
        if(serviceResult.isResult() && serviceResult1.isResult()){
            logger.info("修改信息成功");
            map.put("result","success");
        }
        else{
            logger.info("修改信息失败");
            map.put("result","fail");
        }
        return successResponse(map);
    }
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 改变用户密码,ajax请求,返回用result封装成json.
     * @param uId 用户id
     * @param  password 原密码
     * @param  newPassword 新密码
     * @return  返回信息
     */
    @RequestMapping(value = "/changeUserPassword",method = RequestMethod.GET)
    @ResponseBody
    public Result changeUserPassword(@Param("uId")long uId,@Param("password")String password,@Param("newPassword")String newPassword){
        Map<String,Object> map=new HashMap<>();
        ServiceResult serviceResult=userService.changeUserPassword(uId,password,newPassword);
        //do service
        if(serviceResult.isResult()){
            map.put("result","success");
        }
        else{
            map.put("result","fail");
        }
        return successResponse(map);
    }
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote  收藏
     */
    @RequestMapping(value = "/collect",method = RequestMethod.GET)
    @ResponseBody
    public Result collect(@Param("uId")long uId,@Param("cId") long cId){
        Map<String,Object> map=new HashMap<>();
        ServiceResult serviceResult=userService.addCollection(uId,cId);
        //do service
        if(serviceResult.isResult()){
            map.put("result","success");
        }
        else{
            map.put("result","fail");
        }
        return successResponse(map);
    }
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote  下单
     */
    @RequestMapping(value = "/buy",method = RequestMethod.GET)
    @ResponseBody
    public Result buy(@Param("uId")long uId,@Param("cId") long cId){
        Map<String,Object> map=new HashMap<>();
        ServiceResult serviceResult=userService.addOrder(uId,cId);
        //do service
        if(serviceResult.isResult()){
            map.put("result","success");
        }
        else{
            map.put("result","fail");
        }
        return successResponse(map);
    }
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote  取消收藏
     */
    @RequestMapping(value = "/cancelCollect",method = RequestMethod.GET)
    @ResponseBody
    public Result cancelCollect(@Param("uId")long uId,@Param("cId") long cId){
        Map<String,Object> map=new HashMap<>();
        ServiceResult serviceResult=userService.cancelCollection(uId,cId);
        //do service
        if(serviceResult.isResult()){
            map.put("result","success");
        }
        else{
            map.put("result","fail");
        }
        return successResponse(map);
    }
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote  取消订单
     */
    @RequestMapping(value = "/cancelBuy",method = RequestMethod.GET)
    @ResponseBody
    public Result cancelBuy(@Param("uId")long uId,@Param("cId") long oId){
        Map<String,Object> map=new HashMap<>();
        ServiceResult serviceResult=userService.cancelOrder(uId,oId);
        //do service
        if(serviceResult.isResult()){
            map.put("result","success");
        }
        else{
            map.put("result","fail");
        }
        return successResponse(map);
    }
    @RequestMapping(value = "/payForOrder",method = RequestMethod.GET)
    @ResponseBody
    public Result payForOrder(@Param("uId")long uId,@Param("oId") long oId){
        Map<String,Object> map=new HashMap<>();
        ServiceResult serviceResult=userService.payForOrder(oId,uId);
        //do service
        if(serviceResult.isResult()){
            map.put("result","success");
        }
        else{
            map.put("result","fail");
        }
        return successResponse(map);
    }
}
