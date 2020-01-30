package com.example.rest.server;

import java.util.UUID;

/**
 * Dummy class
 * 
 * @author gsegura
 */
public class Dummy
{

  private int id;
  private String uuid;

  public Dummy()
  {

    this.id = (int) (Math.random() * Integer.MAX_VALUE);
    this.uuid = UUID.randomUUID().toString();
  }

  public Dummy( int id, String uuid )
  {
    this.id = id;
    this.uuid = uuid;
  }

  /**
   * @return the id
   */
  public int getId()
  {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId( int id )
  {
    this.id = id;
  }

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

}
