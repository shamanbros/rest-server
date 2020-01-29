package com.example.rest.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.server.model.SiteDO;

/**
 * Interface DAO para la entidad SiteDO
 * 
 * @author gsegura
 */
@Repository
public interface SiteDAO extends JpaRepository<SiteDO, Long>
{

}
