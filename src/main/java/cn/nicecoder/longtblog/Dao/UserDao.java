package cn.nicecoder.longtblog.Dao;

import cn.nicecoder.longtblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
    User findByUsername(String username);
}
