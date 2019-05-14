package cn.nicecoder.longtblog.dao;

import cn.nicecoder.longtblog.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CatalogDao extends JpaRepository<Catalog, Long>, JpaSpecificationExecutor {


}
