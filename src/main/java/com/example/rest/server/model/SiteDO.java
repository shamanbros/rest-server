package com.example.rest.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Entidad de la tabla K_SITE
 * 
 * @author gsegura
 */
@Entity
@Table(name = "K_SITE")
public class SiteDO extends AbstractEntity<SiteDO>
{

  /**
   * 
   */
  private static final long serialVersionUID = 9173980048104482989L;

  @Id
  @Column(name = "ID_SITE")
  private Long id;

  @Column(name = "DS_SITE")
  private String site;

  @Column(name = "DS_REST_URL")
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

  @Override
  public int compareTo( SiteDO that )
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
      SiteDO that = (SiteDO) object;
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
    return new ToStringBuilder( this ).append( "id", this.id ).append( "site", this.site ).append( "url", this.url )
        .toString();
  }
}
