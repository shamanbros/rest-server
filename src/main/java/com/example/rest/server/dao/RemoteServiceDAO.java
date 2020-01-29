package com.example.rest.server.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.server.model.LogDO;
import com.example.rest.server.model.RemoteServiceDO;

/**
 * Interface DAO para la entidad {@link com.example.rest.server.model.RemoteServiceDOs}
 * 
 * @author gsegura
 */
@Repository
public interface RemoteServiceDAO extends JpaRepository<RemoteServiceDO, Long>
{

  /**
   * Busca los registros por id de sitio y permite paginación
   * 
   * @param siteId id de sitio
   * @param pageable criterio de paginación y ordenamiento
   * @return una página con los registros que cumplan el criterio
   */
  @Query("SELECT o FROM RemoteServiceDO o WHERE o.site.id = :siteId")
  Page<RemoteServiceDO> findBySiteId( @Param("siteId") Long siteId, Pageable pageable );

  /**
   * Busca el registro por UUID
   * 
   * @param uuid
   * @return
   */
  @Query("SELECT o FROM RemoteServiceDO o WHERE o.uuid = :uuid")
  RemoteServiceDO findByUuid( @Param("uuid") String uuid );
}
