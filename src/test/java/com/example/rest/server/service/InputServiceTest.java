package com.example.rest.server.service;

import java.util.Calendar;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.rest.server.Dummy;
import com.example.rest.server.commons.to.ProcessRequestTO;
import com.example.rest.server.commons.to.RequestTO;
import com.example.rest.server.dao.SiteDAO;
import com.example.rest.server.model.SiteDO;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class InputServiceTest
{

  @Autowired
  private Environment environment;

  @Autowired
  private InputService inputService;

  @Autowired
  private SiteDAO siteDAO;

  @Test
  public void testProcessInput()
  {
    String port = environment.getProperty( "local.server.port" );
    SiteDO site = siteDAO.getOne( 1L );
    String urlOriginal = site.getUrl();

    StringBuilder url = new StringBuilder();
    url.append( "http://localhost:" );
    url.append( port );
    url.append( "/server/process1" );
    site.setUrl( url.toString() );
    siteDAO.save( site );

    RequestTO request = new RequestTO();
    String dummyId = Base64.encodeBase64String( UUID.randomUUID().toString().getBytes() );
    request.setId( dummyId );
    request.setSiteId( 1 );

    Gson gson = new Gson();
    String payload = gson.toJson( new Dummy() );
    request.setPayload( payload );

    ProcessRequestTO process = new ProcessRequestTO();
    process.setRequest( request );
    process.setIp( "127.0.0.1" );
    process.setTimestamp( Calendar.getInstance().getTime() );
    process.setUuid( UUID.randomUUID().toString() );

    inputService.processInput( process );

    site.setUrl( urlOriginal );
    siteDAO.save( site );
  }

}
