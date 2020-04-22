package org.spring.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findCityById(id));
        return "city";
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList",cityList);
        return "cityList";
    }

    @RequestMapping("/")
    public String index(Model model){
        List<City> cities = cityService.findAllCity();
        model.addAttribute("cities", cities);
        Map map = new HashMap();
        for (int i = 0; i < 5; i++) {
            map.put("key"+i, "value"+i);
        }
        model.addAttribute("mapJson", map);
        model.addAttribute("map", map);
        model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
        model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
        model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "200");
        jsonObject.put("message", "成功");

        model.addAttribute("jsonObject", jsonObject);

        City city = cityService.findCityById(1L);
        String jsonString = JSON.toJSONString(city);
        System.out.println("对象转JSON:"+jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        System.out.println("JSON字符串转JSON对象"+object);
        model.addAttribute("jsonString", object);
        return "index";
    }
}
