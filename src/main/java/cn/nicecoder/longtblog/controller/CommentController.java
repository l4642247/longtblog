package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.Comment;
import cn.nicecoder.longtblog.pojo.CommentResult;
import cn.nicecoder.longtblog.pojo.CommentStatistic;
import cn.nicecoder.longtblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    public Comment create(@RequestParam(value = "discussid",required = true) Long discussid,
                          @RequestParam(value = "uid",required = true) String uid,
                          @RequestParam(value = "touid",required = false) String touid,
                          @RequestParam(value = "type",required = false) String type,
                          @RequestParam(value = "content",required = true) String content){
        Comment comment = new Comment(type, discussid, uid, touid, new Date(), 0, "1", content);
        return commentService.createComment(comment);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<CommentResult> allTags(@RequestParam(value = "artId",required = true) Long artId,
                                       @RequestParam(value = "pageNumber",defaultValue = "0") int pageNumber,
                                       @RequestParam(value = "pageSize",defaultValue = "5") int pageSize){
        return commentService.commentPage(artId, pageNumber, pageSize);
    }

}
