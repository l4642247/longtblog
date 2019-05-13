package cn.nicecoder.longtblog.Dao;

import cn.nicecoder.longtblog.entity.Agree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AgreeDao extends JpaRepository<Agree, Long>, JpaSpecificationExecutor {
}
