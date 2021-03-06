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
 * Entidad de la tabla K_REMOTE_SERVICE
 * 
 * @author gsegura
 */
@Entity
@Table(name = "K_REMOTE_SERVICE")
public class RemoteServiceDO extends AbstractEntity<RemoteServiceDO>
{

  private static final long serialVersionUID = 6557217717718168351L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_REMOTE_SERVICE")
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
  private Date timestamp;

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

  @Override
  public int compareTo( RemoteServiceDO that )
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
      RemoteServiceDO that = (RemoteServiceDO) object;
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
        .append( "request", this.request ).append( "ip", this.ip ).append( "timestamp", this.timestamp ).toString();
  }

}
