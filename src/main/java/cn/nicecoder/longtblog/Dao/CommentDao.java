package cn.nicecoder.longtblog.Dao;

import cn.nicecoder.longtblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentDao extends JpaRepository<Comment, Long>, JpaSpecificationExecutor {
}
