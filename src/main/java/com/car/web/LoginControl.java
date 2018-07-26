package com.car.web;

import com.car.biz.*;
import com.car.dto.ServiceResult;
import com.car.entity.Car;
import com.car.entity.Manager;
import com.car.entity.Order;
import com.car.entity.User;
import com.car.service.ManagerService;
import com.car.service.UserServiceIml;
import com.car.utils.CodeUtil;
import com.car.utils.RSAUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.car.utils.LoginMag.managerLoginMagMap;


/**
 * @author 孙磊 on 2018/7/14
 * @version 1.0
 * @apiNote 登陆 servlet
 */
@Controller
@RequestMapping(value = "/sellCar/login",method = RequestMethod.GET)
public class LoginControl extends BaseControl{
    Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserServiceIml userService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CarBizIml carBizIml;
    @Autowired
    private OrderBizIml orderBizIml;
    @Autowired
    private UserBizIml userBizIml;
    @Autowired
    private ManagerBizIml managerBiz;
    /**
     * @author 孙磊 on 2018/7/22
     * @apiNote 生成公钥
     * @param
     * @return
     */
    @RequestMapping(value = "/getKey",method = RequestMethod.GET)
    @ResponseBody
    public void getKey() throws Exception{
        HttpServletResponse response=getResponse();
        PrintWriter writer=response.getWriter();
        String publicKey=RSAUtils.generateBase64PublicKey();
        writer.write(publicKey);
    }
    /**
     * @author 孙磊 on 2018/7/22
     * @apiNote 获取验证码图片
     * @return  验证码
     */
    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    @ResponseBody
    public Result getCode(){
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> codeMap=CodeUtil.generateCodeAndPic();
        logger.info("getCode="+codeMap.get("code"));
        HttpServletRequest req=getRequest();
        HttpSession session=req.getSession();
        session.setAttribute("code",codeMap.get("code").toString());
        HttpServletResponse resp=getResponse();
        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);

        resp.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
            map.put("result","success");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("result","fail");
        }
        return successResponse(map);
    }
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 用户登陆
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public ModelAndView userLogin(ModelAndView mv) {
        mv.setViewName("userLogin");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 用户登陆提交
     */
    @RequestMapping(value = "/userLogin/submit",method = RequestMethod.GET)
    public ModelAndView userLoginSubmit(ModelAndView mv, HttpServletResponse response,@RequestParam("code")String code, @RequestParam("name") String name, @RequestParam("password") String password) throws Exception{
        String sessionCode=getRequest().getSession().getAttribute("code").toString();
//        logger.info("login code="+code);
//        logger.info("tPassword="+password);
//        password=RSAUtils.decryptBase64(password);
//        logger.info("password="+password);
        if(!code.equalsIgnoreCase(sessionCode)){
            logger.info("验证码错误!");
            mv.setViewName("codeFailture");
        }
        else if(userService.userLogin(name,password)){
            List<Car> carList=carBizIml.getAllCar();
            mv.addObject("cars",carList);
            //用户id传递
            User user=userBizIml.getUserByNameAndPassword(name,password);
            mv.addObject("user",user);
            mv.addObject("uId",user.getuId());
            mv.setViewName("redirect:/sell/home");
        }
        else{
           logger.info("登陆失败!");
           mv.setViewName("loginFailture");
        }
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 管理员登陆
     */
    @RequestMapping(value = "/managerLogin",method = RequestMethod.GET)
    public ModelAndView managerLogin(ModelAndView mv) {
        mv.setViewName("managerLogin");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 管理员登陆提交
     */
    @RequestMapping(value = "/managerLogin/submit",method = RequestMethod.GET)
    public ModelAndView managerLoginSubmit(ModelAndView mv, @RequestParam("name") String name, @RequestParam("password") String password) {
        if(managerService.managerLogin(name,password)){
            Car car=carBizIml.getCarById(1000);
            mv.addObject("car",car);
            logger.info(""+car.getcId());
            List<Order> order=orderBizIml.getAllOrder();
            Manager manager=managerBiz.getManagerByNameAndPassword(name,password);
            mv.addObject("order",order);
            mv.addObject("mId",manager.getmId());
            mv.addObject("manager",manager);
            mv.setViewName("redirect:/managerCar/managerHome");
        }
        else{
            mv.setViewName("loginFailture");
        }
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 用户注册页面
     * @param
     * @return
     */
    @RequestMapping(value = "/userRegister",method=RequestMethod.GET)
    public ModelAndView userRegister(ModelAndView mv){
        mv.setViewName("userRegister");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 用户注册提交
     */
    @RequestMapping(value = "/userRegister/submit",method=RequestMethod.GET)
    public ModelAndView userRegisterSubmit(ModelAndView mv,@RequestParam("username") String name,@RequestParam("password") String password,@RequestParam("phone") String phone,@RequestParam("address")String address,@RequestParam("check")String check){
        if(password!=check){
            mv.setViewName("operateFail");
            return mv;
        }
         ServiceResult serviceResult=userService.userRegister(name,password,phone,address);
         if(serviceResult.isResult()){
             mv.setViewName("userLogin");
         }
         else{
             mv.setViewName("operateFail");
         }
         return mv;
     }

}
