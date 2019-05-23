package cn.nicecoder.longtblog.dao;

import cn.nicecoder.longtblog.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CatalogDao extends JpaRepository<Catalog, Long>, JpaSpecificationExecutor {
    @Transactional
    @Modifying
    @Query(value="update catalog set count = count + 1 where id = ?1", nativeQuery = true)
    void updateCatalogCount(Long id);
}
