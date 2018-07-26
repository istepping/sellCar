package com.car.web;

import com.car.biz.CarBizIml;
import com.car.biz.ImageBizIml;
import com.car.entity.Car;
import com.car.entity.Image;
import com.car.entity.User;
import com.car.enums.CarSortEnum;
import com.car.utils.UserMag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.car.utils.StaticMethod.logger;
/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 销售控制器
 */
@Controller
@RequestMapping(value = "/sell")
public class SellCarControl {
    @Autowired
    private CarBizIml carBiz;
    @Autowired
    private ImageBizIml imageBiz;
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 车主页面
     */
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mv, @RequestParam("uId") long uId) {
        mv.addObject("uId",uId);
        List<Car> carList=carBiz.getAllCar();
        mv.addObject("cars",carList);
        mv.setViewName("/sellCar/userHome");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/15
     * @apiNote 车详情页面
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ModelAndView carDetail(ModelAndView mv, @RequestParam("id") long id,@RequestParam("uId") long uId) {
        Car car=carBiz.getCarById(id);
        if(car!=null){
            logger.info(this.getClass()+""+car.getcId());
            mv.addObject("car",car);
        }
        Image image=imageBiz.getImageById(car.getcId());
        mv.addObject("uId",uId);
        mv.addObject("image",image);
        mv.setViewName("/sellCar/carDetail");
        return mv;
    }
    /**
     * @author 孙磊 on 2018/7/17
     * @apiNote 车分类页面
     */
    @RequestMapping(value = "/sort",method = RequestMethod.GET)
    public ModelAndView carSort(ModelAndView mv,@RequestParam("cCatalog") String cCatalog,@RequestParam("uId")long uId){
        List<Car> cars=carBiz.getCarByCatalog(cCatalog);
        logger.info("cars"+cars.size());
        mv.addObject("cars",cars);
        mv.addObject("cCatalog",cCatalog);
        mv.addObject("uId",uId);
        mv.setViewName("/sellCar/sort");
        return mv;
    }
    //@RequestMapping(value = "/detail/collect",method = RequestMethod.GET)

}
