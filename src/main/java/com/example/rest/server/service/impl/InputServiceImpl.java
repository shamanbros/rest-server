package com.example.rest.server.service.impl;

import java.util.Calendar;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.rest.server.commons.exception.BusinessExceptionBuilder;
import com.example.rest.server.commons.to.ProcessRequestTO;
import com.example.rest.server.dao.LogDAO;
import com.example.rest.server.dao.SiteDAO;
import com.example.rest.server.model.LogDO;
import com.example.rest.server.model.SiteDO;
import com.example.rest.server.service.InputService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Implementación de la interface {@link com.example.rest.server.service.InputService}
 * 
 * @author gsegura
 */
@Service
public class InputServiceImpl implements InputService
{
  private static final Logger LOGGER = LoggerFactory.getLogger( InputServiceImpl.class );

  @Autowired
  private SiteDAO siteDAO;

  @Autowired
  private LogDAO logDAO;

  @Override
  public void processInput( ProcessRequestTO process )
  {
    Gson gson = new Gson();
    String request = gson.toJson( process.getRequest() );

    LogDO entity = new LogDO();
    entity.setIp( process.getIp() );
    entity.setRequest( request );

    Optional<SiteDO> site = this.siteDAO.findById( Long.valueOf( process.getRequest().getSiteId() ) );
    if( site.isEmpty() )
    {
      throw BusinessExceptionBuilder.build( 1 );
    }
    entity.setSite( site.get() );

    entity.setUuid( process.getUuid() );
    entity.setTsRequest( process.getTimestamp() );
    logDAO.saveAndFlush( entity );

    ResponseEntity<String> response = sendPostRequest( process, site.get() );
    entity.setTsResponse( Calendar.getInstance().getTime() );
    entity.setResponse( response.getBody() );
    entity.setResponseCode( response.getStatusCodeValue() );
    logDAO.save( entity );

  }

  private ResponseEntity<String> sendPostRequest( ProcessRequestTO process, SiteDO site )
  {
    Gson gson = new GsonBuilder().setDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS" ).create();
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType( MediaType.APPLICATION_JSON );

    String json = gson.toJson( process );
    LOGGER.info( json );

    HttpEntity<String> request = new HttpEntity<String>( json, headers );
    ResponseEntity<String> response = restTemplate.postForEntity( site.getUrl(), request, String.class );
    LOGGER.info( "Código de respuesta:" + response.getStatusCodeValue() );
    LOGGER.info( "Respuesta:" + response.getBody() );
    return response;
  }

}
