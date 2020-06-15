package org.spring.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * @Api 用于类上,说明该类的作用
 * Created by bysocket on 07/02/2017.
 */
@RestController
@Api(value = "城市 Controller 实现 增删改查 接口api")
public class CityRestController {

    @Autowired
    private CityService cityService;

    /**
     *
     * @ApiOperation 给对应API(增加)方法说明
     * @ApiImplicitParams 用在方法上包含一组参数说明
     * @ApiImplicitParam 用来注解来给方法入参增加说明
     * @ApiImplicitParam参数说明:
     * paramType 指定参数放在哪个地方{
     * header：请求参数放置于Request Header，使用@RequestHeader获取;
     * query：请求参数放置于请求地址，使用@RequestParam获取;
     * path：(用于restful接口)-->请求参数的获取：@PathVariable;
     * body：(不常用);
     * form(不常用)}
     * @param id 城市id(唯一)
     * @return
     */
    @ApiOperation(value = "根据城市id查询城市信息", notes = "查询唯一城市接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value = "城市id",required = true,dataType = "Integer")
    })
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }
    @ApiOperation(value = "查询所有城市信息",notes = "查询所有城市接口")
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }
    @ApiOperation(value = "新增城市",notes = "新增城市接口")
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @ApiOperation(value = "更新城市",notes = "更新城市接口")
    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @ApiOperation(value = "根据id删除城市信息", notes = "删除城市接口")
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
