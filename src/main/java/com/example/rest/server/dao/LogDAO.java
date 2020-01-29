package com.example.rest.server.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.server.model.LogDO;

/**
 * Interface DAO para la entidad LogDO
 * 
 * @author gsegura
 */
@Repository
public interface LogDAO extends JpaRepository<LogDO, Long>
{

  /**
   * Busca los registros por id de sitio y permite paginación
   * 
   * @param siteId id de sitio
   * @param pageable criterio de paginación y ordenamiento
   * @return una página con los registros que cumplan el criterio
   */
  @Query("SELECT o FROM LogDO o WHERE o.site.id = :siteId")
  Page<LogDO> findBySiteId( @Param("siteId") Long siteId, Pageable pageable );

  @Query("SELECT o FROM LogDO o WHERE o.uuid = :uuid")
  LogDO findByUuid( @Param("uuid") String uuid );
}
