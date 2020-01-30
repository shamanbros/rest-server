package com.example.rest.server.web.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.server.commons.to.SiteTO;
import com.example.rest.server.service.SiteService;

/**
 * API para controlar los sitios
 * 
 * @author gsegura
 */
@RestController
@RequestMapping("/api/v1")
public class SiteController
{

  @Autowired
  private SiteService siteService;

  /**
   * Busca todos los sitios
   * 
   * @return
   */
  @GetMapping("/sites")
  public List<SiteTO> findAll()
  {
    return siteService.findAll();
  }

  /**
   * Busca lun sitio por id
   * 
   * @param id
   * @return
   */
  @SuppressWarnings("unchecked")
  @GetMapping("/sites/{id}")
  public ResponseEntity<SiteTO> findById( @PathVariable(value = "id") Long id )
  {
    SiteTO site = siteService.findById( id );

    ResponseEntity response = null;
    if( site == null )
    {
      response = ResponseEntity.noContent().build();
    }
    else
    {
      response = ResponseEntity.ok().body( site );
    }
    return response;
  }

  /**
   * Guarda la información de un sitio
   * 
   * @param site
   */
  @PostMapping("/sites")
  public ResponseEntity save( @RequestBody SiteTO site )
  {
    siteService.save( site );
    return ResponseEntity.ok().body( site );
  }

  /**
   * Actualiza la información de un sitio
   */
  @PutMapping("/sites/{id}")
  public ResponseEntity update( @RequestBody SiteTO site, @PathVariable Long id )
  {
    site.setId( id );
    siteService.update( site );
    return ResponseEntity.ok().body( site );
  }
}
