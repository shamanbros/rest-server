package com.example.rest.server.commons.to;

import java.io.Serializable;

/**
 * Clase de transferencia para sitios
 * 
 * @author gsegura
 */
public class SiteTO implements Serializable
{
  private static final long serialVersionUID = -8432707403030546564L;

  private Long id;

  private String site;

  private String url;

  /**
   * @return the id
   */
  public Long getId()
  {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId( Long id )
  {
    this.id = id;
  }

  /**
   * @return the site
   */
  public String getSite()
  {
    return site;
  }

  /**
   * @param site the site to set
   */
  public void setSite( String site )
  {
    this.site = site;
  }

  /**
   * @return the url
   */
  public String getUrl()
  {
    return url;
  }

  /**
   * @param url the url to set
   */
  public void setUrl( String url )
  {
    this.url = url;
  }

}
