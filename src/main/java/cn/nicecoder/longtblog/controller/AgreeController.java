package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.Agree;
import cn.nicecoder.longtblog.service.AgreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: longt
 * @Date: 2019/5/16 11:13
 * @Description:
 */
@RestController
@RequestMapping("/agree")
public class AgreeController {

    @Autowired
    AgreeService agreeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Agree create(@RequestParam(value = "agreeId",required = true)Long agreeId,
                        @RequestParam(value = "type",required = true)String type,
                        @RequestParam(value = "userId",required = true)Long userId){
        return agreeService.create(agreeId, type, userId);
    }
}
