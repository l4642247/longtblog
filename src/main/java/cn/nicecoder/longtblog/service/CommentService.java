package cn.nicecoder.longtblog.service;

import cn.nicecoder.longtblog.entity.Catalog;
import cn.nicecoder.longtblog.entity.Comment;
import org.springframework.data.domain.Page;

/**
 *
 */
public interface CommentService {
    /**
     * 创建
     * @param comment
     * @return
     */
    public Comment createComment(Comment comment);

    /**
     * 查询评论
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public Page<Comment> commentPage(int pageNumber, int pageSize);
}
