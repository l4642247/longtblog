package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.BlogUser;
import cn.nicecoder.longtblog.service.BlogUserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: longt
 * @Date: 2019/3/29 16:21
 * @Description:
 */
@RestController
@RequestMapping("/blogUser")
public class BlogUserController {
    @Autowired
    BlogUserService blogUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestParam(value = "username",required = true) String username,
                         @RequestParam(value = "password",required = true) String password){
        return blogUserService.login(username, password);
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    @JsonView(BlogUser.UserDetailView.class)
    public BlogUser info(@PathVariable Long id){
        return blogUserService.userInfo(id);
    }
}
