package com.example.rest.server.service;

import java.util.List;

import com.example.rest.server.commons.to.SiteTO;

/**
 * @author gsegura
 */
public interface SiteService
{

  /**
   * Busca los sitios configurados
   * 
   * @return
   */
  List<SiteTO> findAll();

  /**
   * Busca un sitio por ids
   * 
   * @return
   */
  SiteTO findById( Long id );

  /**
   * Guarda un sitio
   * 
   * @param site
   */
  void save( SiteTO site );

  /**
   * Actualiza la información de un sitio
   * 
   * @param site
   */
  void update( SiteTO site );

}
