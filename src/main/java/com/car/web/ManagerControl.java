package com.car.web;

import com.car.biz.CarBizIml;
import com.car.biz.ManagerBizIml;
import com.car.biz.OrderBiz;
import com.car.dto.OrderInfo;
import com.car.dto.ServiceResult;
import com.car.entity.*;
import com.car.enums.CarSortEnum;
import com.car.enums.CarStateEnum;
import com.car.service.ManagerServiceIml;
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
import static com.car.utils.StaticMethod.logger;
/**
 * @author 孙磊 on 2018/7/20
 * @version 1.0
 * @apiNote 管理员控制器
 */
@Controller
@RequestMapping(value = "/managerCar",method = RequestMethod.GET)
public class ManagerControl extends BaseControl{
    @Autowired
    private ManagerServiceIml managerService;
    @Autowired
    private OrderBiz orderBiz;
    @Autowired
    private CarBizIml carBizIml;
    @Autowired
    private ManagerBizIml managerBizIml;
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 管理员主界面
     * @param  mId
     * @return  车辆界面
     */
    @RequestMapping(value = "/managerHome",method = RequestMethod.GET)
    public ModelAndView managerHome(ModelAndView mv,@RequestParam("mId") long mId){
        List<Car> cars = carBizIml.getAllCar();
        Manager manager=managerBizIml.getManagerById(mId);
        mv.addObject("cars",cars);
        mv.addObject("mId",mId);
        mv.addObject("manager",manager);
        mv.setViewName("/manager/managerHome");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 查看全部订单
     * @param  mId 管理员
     * @return  订单界面
     */
    @RequestMapping(value = "/allOrder",method = RequestMethod.GET)
    public ModelAndView getAllOrder(ModelAndView mv, @RequestParam("mId") long mId){
        List<OrderInfo> orders=new ArrayList<>();
        ServiceResult serviceResult=managerService.getAllOrder(mId,orders);
        mv.addObject("orders",orders);
        mv.addObject("mId",mId);
        Manager manager=managerBizIml.getManagerById(mId);
        mv.addObject("manager",manager);
        mv.setViewName("/manager/allOrder");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 增加车辆
     */
    @RequestMapping(value = "/addCar",method = RequestMethod.GET)
    public ModelAndView addCar(ModelAndView mv, @RequestParam("mId") long mId){
        mv.addObject("mId",mId);
        List<Car> cars=carBizIml.getAllCar();
        Manager manager=managerBizIml.getManagerById(mId);
        mv.addObject("manager",manager);
        mv.addObject("cars",cars);
        mv.setViewName("/manager/addCar");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote 增加新车车辆
     */
    @RequestMapping(value = "/addCar/addNewCar",method = RequestMethod.GET)
    @ResponseBody
    public Result addNewCar(@Param("mId")long mId,@Param("cBrand") String cBrand,@Param("cColor") String cColor,@Param("cNum") int cNum,@Param("cCatalog")String cCatalog,@Param("cPrice")String cPrice,@Param("cType")String cType,@Param("cStyle")String cStyle,@Param("cEnergy")String cEnergy){
        Map<String,Object> map=new HashMap<>();
        Car car;
        logger.info("cCatalog="+cCatalog);
        if(cCatalog.equals(CarSortEnum.NEV)){
            car=new Nev(cBrand, cColor, cPrice, cNum ,CarStateEnum.beSell.getState(),cCatalog,cEnergy);
        }
        else if(cCatalog.equals(CarSortEnum.sportCar)){
            car=new SportCar(cBrand, cColor, cPrice, cNum ,CarStateEnum.beSell.getState(),cCatalog,cStyle);
        }
        else{
            car=new Suv(cBrand, cColor, cPrice, cNum ,CarStateEnum.beSell.getState(),cCatalog,cType);
        }
        ServiceResult serviceResult=managerService.addCar(mId,car);
        logger.info(serviceResult.toString());
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
     * @apiNote 删除出售车辆
     */
    @RequestMapping(value = "/addCar/deleteCar",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteCar(@Param("mId")long mId, @Param("cId") long cId){
        Map<String,Object> map=new HashMap<>();
        Manager manager=managerBizIml.getManagerById(mId);
        ServiceResult serviceResult=managerService.changeCarState(cId,manager.getmName(),manager.getmPassword(),CarStateEnum.beDelete.getState());
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
     * @apiNote 接单
     */
    @RequestMapping(value = "/orders/receiveOrder",method = RequestMethod.GET)
    @ResponseBody
    public Result receiveOrder(@Param("mId")long mId, @Param("oId") long oId){
        Map<String,Object> map=new HashMap<>();
        ServiceResult serviceResult=managerService.orderReceiving(oId);
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
     * @apiNote 不接单
     * @param
     * @return
     */
    @RequestMapping(value = "/orders/rejectOrder",method = RequestMethod.GET)
    @ResponseBody
    public Result rejectOrder(@Param("mId")long mId, @Param("oId") long oId){
        Map<String,Object> map=new HashMap<>();
        ServiceResult serviceResult=managerService.rejectOrderReceiving(oId);
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
     * @apiNote 增加管理员
     */
    @RequestMapping(value = "/manager/addManager",method = RequestMethod.GET)
    @ResponseBody
    public Result addManager(@Param("mId")long mId, @Param("mName") String mName,@Param("mPassword") String mPassword){
        Map<String,Object> map=new HashMap<>();
        Manager manager=new Manager(1000,mName,mPassword,1);
        Manager opManager=managerBizIml.getManagerById(mId);
        ServiceResult serviceResult=managerService.createManager(opManager,manager);
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
