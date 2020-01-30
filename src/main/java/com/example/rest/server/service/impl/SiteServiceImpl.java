package com.example.rest.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.rest.server.commons.to.SiteTO;
import com.example.rest.server.dao.SiteDAO;
import com.example.rest.server.model.SiteDO;
import com.example.rest.server.service.SiteService;

/**
 * Implementación de la interface {@link com.example.rest.server.service.SiteService}
 * 
 * @author gsegura
 */
@Service
public class SiteServiceImpl implements SiteService
{

  @Autowired
  private SiteDAO siteDAO;
  /**
   * {@inheritDoc}
   */
  @Override
  public List<SiteTO> findAll()
  {
    List<SiteDO> sites = siteDAO.findAll( Sort.by( Direction.DESC, "id" ) );
    List<SiteTO> response = new ArrayList<>();
    sites.stream().forEach( s -> {
      response.add( transform( s ) );
    } );
    return response;
  }

  private SiteTO transform( SiteDO s )
  {
    SiteTO site = new SiteTO();
    site.setId( s.getId() );
    site.setSite( s.getSite() );
    site.setUrl( s.getUrl() );
    return site;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SiteTO findById( Long id )
  {
    
    
    Optional<SiteDO> site = this.siteDAO.findById( id );
    SiteTO result = null;
    if( site.isPresent())
    {
      result = transform( site.get() );
    }
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void save( SiteTO site )
  {
    SiteDO entity = new SiteDO();
    entity.setId( site.getId() );
    entity.setSite( site.getSite() );
    entity.setUrl( site.getUrl() );
    this.siteDAO.saveAndFlush( entity );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update( SiteTO site )
  {
    SiteDO entity = this.siteDAO.getOne( site.getId() );
    if( entity != null )
    {
      entity.setSite( site.getSite() );
      entity.setUrl( site.getUrl() );
      this.siteDAO.save( entity );
    }

  }

}
