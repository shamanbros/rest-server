package com.example.rest.server.commons.to;

import java.io.Serializable;

public class ProcessResponseTO implements Serializable
{
  private ProcessRequestTO request;
  private String code;
  /**
   * @return the request
   */
  public ProcessRequestTO getRequest()
  {
    return request;
  }

  /**
   * @param request the request to set
   */
  public void setRequest( ProcessRequestTO request )
  {
    this.request = request;
  }

  /**
   * @return the code
   */
  public String getCode()
  {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode( String code )
  {
    this.code = code;
  }

}
