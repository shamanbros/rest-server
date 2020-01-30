package com.example.rest.server.commons.to;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que procesa la petición
 * 
 * @author gsegura
 */
public class ProcessRequestTO implements Serializable
{

  private static final long serialVersionUID = 2168139622275182940L;
  private String uuid;
  private String ip;
  private Date timestamp;
  private RequestTO request;
  /**
   * @return the uuid
   */
  public String getUuid()
  {
    return uuid;
  }

  /**
   * @param uuid the uuid to set
   */
  public void setUuid( String uuid )
  {
    this.uuid = uuid;
  }

  /**
   * @return the ip
   */
  public String getIp()
  {
    return ip;
  }

  /**
   * @param ip the ip to set
   */
  public void setIp( String ip )
  {
    this.ip = ip;
  }

  /**
   * @return the timestamp
   */
  public Date getTimestamp()
  {
    return timestamp;
  }

  /**
   * @param timestamp the timestamp to set
   */
  public void setTimestamp( Date timestamp )
  {
    this.timestamp = timestamp;
  }

  /**
   * @return the request
   */
  public RequestTO getRequest()
  {
    return request;
  }

  /**
   * @param request the request to set
   */
  public void setRequest( RequestTO request )
  {
    this.request = request;
  }

}
