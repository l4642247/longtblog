package cn.nicecoder.longtblog.service.Impl;

import cn.nicecoder.longtblog.dao.CommentDao;
import cn.nicecoder.longtblog.entity.Comment;
import cn.nicecoder.longtblog.pojo.CommentResult;
import cn.nicecoder.longtblog.pojo.CommentStatistic;
import cn.nicecoder.longtblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: longt
 * @Date: 2019/5/13 16:30
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    @Override
    public Comment createComment(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public List<CommentResult> commentPage(Long artId, int pageNumber, int pageSize) {
        List<CommentResult> result = new ArrayList<CommentResult>();
        List<CommentStatistic> cstatic = commentDao.findByArtId(artId,pageNumber,pageSize,"1");
        cstatic.forEach(o -> {
            CommentResult comm = o.toComment();
            result.add(comm);
        });
        return result;
    }
}
