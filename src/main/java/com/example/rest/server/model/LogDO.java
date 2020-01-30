package com.example.rest.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Entidad de la tabla K_LOG
 * 
 * @author gsegura
 */
@Entity
@Table(name = "K_LOG")
public class LogDO extends AbstractEntity<LogDO>
{
 
  private static final long serialVersionUID = -3868661394792642385L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_LOG")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "ID_SITE", referencedColumnName = "ID_SITE")
  private SiteDO site;

  @Column(name = "DS_UUID")
  private String uuid;

  @Lob
  @Column(name = "DS_REQUEST")
  private String request;

  @Column(name = "DS_IP")
  private String ip;

  @Column(name = "DT_REQUEST")
  @Temporal(TemporalType.TIMESTAMP)
  private Date tsRequest;
  
  
  @Column(name = "ID_RESPONSE_CODE ")
  private Integer responseCode;

  @Lob
  @Column(name = "DS_RESPONSE ")
  private String response;

  @Column(name = "DT_RESPONSE ")
  @Temporal(TemporalType.TIMESTAMP)
  private Date tsResponse;

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
  public SiteDO getSite()
  {
    return site;
  }

  /**
   * @param site the site to set
   */
  public void setSite( SiteDO site )
  {
    this.site = site;
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

  /**
   * @return the request
   */
  public String getRequest()
  {
    return request;
  }

  /**
   * @param request the request to set
   */
  public void setRequest( String request )
  {
    this.request = request;
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
   * @return the tsRequest
   */
  public Date getTsRequest()
  {
    return tsRequest;
  }

  /**
   * @param tsRequest the tsRequest to set
   */
  public void setTsRequest( Date tsRequest )
  {
    this.tsRequest = tsRequest;
  }

  /**
   * @return the responseCode
   */
  public Integer getResponseCode()
  {
    return responseCode;
  }

  /**
   * @param responseCode the responseCode to set
   */
  public void setResponseCode( Integer responseCode )
  {
    this.responseCode = responseCode;
  }

  /**
   * @return the response
   */
  public String getResponse()
  {
    return response;
  }

  /**
   * @param response the response to set
   */
  public void setResponse( String response )
  {
    this.response = response;
  }

  /**
   * @return the tsResponse
   */
  public Date getTsResponse()
  {
    return tsResponse;
  }

  /**
   * @param tsResponse the tsResponse to set
   */
  public void setTsResponse( Date tsResponse )
  {
    this.tsResponse = tsResponse;
  }

  @Override
  public int compareTo( LogDO that )
  {
    return new CompareToBuilder().append( this.id, that.id ).toComparison();
  }

  @Override
  public boolean equals( Object object )
  {

    boolean isEquals = false;
    if( this == object )
    {
      isEquals = true;
    }
    else if( object != null && object.getClass().equals( this.getClass() ) )
    {
      LogDO that = (LogDO) object;
      isEquals = new EqualsBuilder().append( this.id, that.id ).isEquals();
    }
    return isEquals;
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder().append( this.id ).toHashCode();
  }

  @Override
  public String toString()
  {
    return new ToStringBuilder( this ).append( "id", this.id ).append( "site", this.site ).append( "uuid", this.uuid )
        .append( "ip", this.ip )
        .append( "request", this.request )
        .append( "tsRequest", this.tsRequest )
        .append( "responseCode",this.responseCode )
        .append( "response", this.response )
        .append( "tsResponse", this.tsResponse )
        .toString();
  }

}
