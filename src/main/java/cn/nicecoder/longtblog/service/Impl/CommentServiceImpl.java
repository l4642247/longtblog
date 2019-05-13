package cn.nicecoder.longtblog.service.Impl;

import cn.nicecoder.longtblog.Dao.CommentDao;
import cn.nicecoder.longtblog.entity.Comment;
import cn.nicecoder.longtblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public Page<Comment> commentPage(int pageNumber, int pageSize) {
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "agree");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, new Sort(order1, order2));
        return commentDao.findAll(pageable);
    }
}
