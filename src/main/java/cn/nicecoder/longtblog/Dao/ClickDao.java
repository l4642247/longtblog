package cn.nicecoder.longtblog.dao;

import cn.nicecoder.longtblog.entity.Click;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClickDao extends JpaRepository<Click, Long>, JpaSpecificationExecutor {

}
