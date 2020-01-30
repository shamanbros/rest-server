package com.example.rest.server.commons.to;

import java.io.Serializable;

/**
 * Clase de petición inicial
 * 
 * @author gsegura
 */
public class RequestTO implements Serializable
{

  private static final long serialVersionUID = 6413577511318407513L;
  private String id;
  private int siteId;
  private String payload;
  /**
   * @return the id
   */
  public String getId()
  {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId( String id )
  {
    this.id = id;
  }

  /**
   * @return the siteId
   */
  public int getSiteId()
  {
    return siteId;
  }

  /**
   * @param siteId the siteId to set
   */
  public void setSiteId( int siteId )
  {
    this.siteId = siteId;
  }

  /**
   * @return the payload
   */
  public String getPayload()
  {
    return payload;
  }

  /**
   * @param payload the payload to set
   */
  public void setPayload( String payload )
  {
    this.payload = payload;
  }

}
