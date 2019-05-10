package cn.nicecoder.longtblog.Dao;

import cn.nicecoder.longtblog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TagDao extends JpaRepository<Tag, Long>, JpaSpecificationExecutor {
    Tag findByName(String name);
}
