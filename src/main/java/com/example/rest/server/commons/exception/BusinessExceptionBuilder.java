package com.example.rest.server.commons.exception;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.stereotype.Component;

/**
 * Clase builder de las excepciones
 * 
 * @author gsegura
 */
public final class BusinessExceptionBuilder extends PropertySourcesPlaceholderConfigurer
{
  private static final int DEFAULT_CODE_EXCEPTION = 0;

  /**
   * Constructor vacío
   * 
   * @return
   */
  public static BusinessException build()
  {
    return build( null, null, DEFAULT_CODE_EXCEPTION, null );
  }

  /**
   * Constructor por mensaje
   * 
   * @param message
   * @return
   */
  public static BusinessException build( String message )
  {
    return build( message, null, DEFAULT_CODE_EXCEPTION, null );
  }

  /**
   * Constructor por mensaje y excepción
   * 
   * @param message
   * @param t
   * @return
   */
  public static BusinessException build( String message, Throwable t )
  {
    return build( message, t, DEFAULT_CODE_EXCEPTION, null );
  }

  /**
   * Constructor por mensaje, excepción y código
   * 
   * @param message
   * @param t
   * @param code
   * @return
   */
  public static BusinessException build( String message, Throwable t, int code )
  {
    return build( message, t, code, null );
  }

  /**
   * Constructor por mensaje, excepción y descripción
   * 
   * @param message
   * @param t
   * @param description
   * @return
   */
  public static BusinessException build( String message, Throwable t, String description )
  {
    return build( message, t, DEFAULT_CODE_EXCEPTION, description );
  }

  public static BusinessException build( String message, Throwable t, int code, String description )
  {
    BusinessException businessException = new BusinessException( message, t );
    businessException.setCode( code );

    if( StringUtils.isBlank( description ) )
    {
      String key = new StringBuilder().append( "business.exception.code." ).append( code ).toString();
      businessException.setDescription( getProperty( key ) );
    }
    else
    {
      businessException.setDescription( description );
    }

    return businessException;
  }

  private static String getProperty( String key )
  {
    String mensaje = "";
    try
    {
      mensaje = ResourceBundle.getBundle( "business_exception" ).getString( key );
    }
    catch( Exception e )
    {
      mensaje = "";
    }
    return mensaje;
  }

}
