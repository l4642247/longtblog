package cn.nicecoder.longtblog.Dao;

import cn.nicecoder.longtblog.entity.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogUserDao extends JpaRepository<BlogUser, Long> {
    BlogUser findByUsername(String username);
}
