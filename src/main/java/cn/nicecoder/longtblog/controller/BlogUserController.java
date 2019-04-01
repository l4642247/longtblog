package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.BlogUser;
import cn.nicecoder.longtblog.service.BlogUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: longt
 * @Date: 2019/3/29 16:21
 * @Description:
 */
@RestController
@RequestMapping("/blogUser")
public class BlogUserController {
    private static final Logger logger = Logger.getLogger(BlogUserController.class);

    @Autowired
    BlogUserService blogUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestParam(value = "username",required = true) String username,
                         @RequestParam(value = "password",required = true) String password){
        return blogUserService.login(username, password);
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public BlogUser info(@PathVariable Long id){
        BlogUser blogUser = blogUserService.userInfo(id);
        return blogUser;
    }

    @RequestMapping(value = "/info/all", method = RequestMethod.GET)
    public List<BlogUser> infoAll(){
        return blogUserService.AllUserInfo();
    }
}
