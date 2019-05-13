package cn.nicecoder.longtblog.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.nicecoder.longtblog.entity.Comment;
import cn.nicecoder.longtblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.DateUtils;

import java.util.Date;

/**
 * @Author: longt
 * @Date: 2019/5/13 16:21
 * @Description:
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Comment create(@RequestParam(value = "discussid",required = true) String discussid,
                          @RequestParam(value = "uid",required = true) String uid,
                          @RequestParam(value = "touid",required = false) String touid,
                          @RequestParam(value = "type",required = false) String type,
                          @RequestParam(value = "content",required = true) String content){
        Comment comment = new Comment(type, discussid, uid, touid, new Date(), 0, "1", content);
        return commentService.createComment(comment);
    }

}
