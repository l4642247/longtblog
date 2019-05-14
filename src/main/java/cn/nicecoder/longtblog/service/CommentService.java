package cn.nicecoder.longtblog.service;

import cn.nicecoder.longtblog.entity.Comment;

import java.util.List;

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
    public List<Comment> commentPage(Long artId, int pageNumber, int pageSize);
}
