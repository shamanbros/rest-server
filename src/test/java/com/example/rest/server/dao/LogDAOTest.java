package com.example.rest.server.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.rest.server.model.LogDO;
import com.example.rest.server.model.SiteDO;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LogDAOTest
{

  @Autowired
  private SiteDAO siteDAO;

  @Autowired
  private LogDAO logDAO;

  @Before
  public void setUp()
  {
    Map<Long, SiteDO> map = new HashMap<>();

    List<SiteDO> sites = siteDAO.findAll();
    sites.stream().forEach( s -> map.put( s.getId(), s ) );

    LogDO log = null;
    Dummy dummy = null;
    Gson gson = new Gson();
    for( int i = 0; i < 1000; i++ )
    {
      log = new LogDO();
      log.setSite( map.get( Long.valueOf( i % 5 + 1 ) ) );

      UUID uuid = UUID.randomUUID();
      dummy = new Dummy( i, UUID.randomUUID().toString() );
      log.setRequest( gson.toJson( dummy ) );
      dummy = null;

      log.setUuid( uuid.toString() );
      log.setIp( "10.10.1.1" );
      log.setTimestamp( Calendar.getInstance().getTime() );

      logDAO.save( log );
    }
  }

  @Test
  public void testFindBySiteId()
  {

    Page<LogDO> paged = this.logDAO.findBySiteId( 1L, PageRequest.of( 0, 20, Sort.by( Direction.DESC, "timestamp" ) ) );
    Assert.assertNotNull( paged );
    Assert.assertTrue( paged.getSize() <= 20 );

    System.out.println( "pages:" + paged.getNumber() );
    System.out.println( "pages:" + paged.getTotalPages() );
    System.out.println( "elements" + paged.getTotalElements() );
    paged.get().forEach( log -> {
      System.out.println( log );
    } );

  }
  
  @Test
  public void testFindByUuid() {
    Page<LogDO> paged = this.logDAO.findAll(PageRequest.of( 0, 10, Sort.by( Direction.DESC, "id" ) ));
    paged.get().forEach( log -> {
      
      LogDO logByUuid = this.logDAO.findByUuid( log.getUuid() );
      
      Assert.assertEquals( log.getId(), logByUuid.getId() );
      
    } );
    
  }

  private static class Dummy
  {
    public Dummy()
    {
    }

    public Dummy( int id, String uddi )
    {
      this.id = id;
      this.uddi = uddi;
    }
    private int id;
    private String uddi;
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
     * @return the uddi
     */
    public String getUddi()
    {
      return uddi;
    }

    /**
     * @param uddi the uddi to set
     */
    public void setUddi( String uddi )
    {
      this.uddi = uddi;
    }

  }
}
