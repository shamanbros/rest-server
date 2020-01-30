package com.example.rest.server.commons.exception;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Clase builder de las excepciones
 * 
 * @author gsegura
 */
public final class BusinessExceptionBuilder extends PropertySourcesPlaceholderConfigurer
{

  private static final Logger LOGGER = LoggerFactory.getLogger( BusinessExceptionBuilder.class );
  private static final String BUSINESS_EXCEPTION_PROPERTIES = "business_exception";
  private static final String BUSINESS_EXCEPTION_CODE = "business.exception.code.";
  private static final int DEFAULT_CODE_EXCEPTION = 0;

  /**
   * Constructor vacío, código de error Default
   * 
   * @return
   */
  public static BusinessException build()
  {
    return build( null, null, DEFAULT_CODE_EXCEPTION, null );
  }

  /**
   * Constructor por mensaje y el código de error Default
   * 
   * @param message
   * @return
   */
  public static BusinessException build( String message )
  {
    return build( message, null, DEFAULT_CODE_EXCEPTION, null );
  }

  /**
   * Constructor por mensaje, excepción y el código de error Default
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
   * Constructor por mensaje, excepción y el código de error
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
   * Constructor por mensaje, excepción, descripción y el código de error
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

  /**
   * Construye la excepción con el código de error
   * 
   * @param code
   * @return
   */
  public static BusinessException build( int code )
  {
    return build( null, null, code, null );
  }

  /**
   * Construye la excepción con la excepción y el código de error
   * 
   * @param t
   * @param code
   * @return
   */
  public static BusinessException build( Throwable t, int code )
  {
    return build( null, t, code, null );
  }

  /**
   * Construye la excepción con la excepción y el código de error Default
   * 
   * @param t
   * @return
   */
  public static BusinessException build( Throwable t )
  {
    return build( null, t, DEFAULT_CODE_EXCEPTION, null );
  }

  /**
   * Constructor de la excepción de negocio, si la descripción es nula o vacía se busca en el archivo de propiedades
   * 
   * @param message
   * @param t
   * @param code
   * @param description
   * @return
   */
  public static BusinessException build( String message, Throwable t, int code, String description )
  {
    BusinessException businessException = new BusinessException( message, t );
    businessException.setCode( code );

    if( StringUtils.isBlank( description ) )
    {
      String key = new StringBuilder().append( BUSINESS_EXCEPTION_CODE ).append( code ).toString();
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
    String property = "";
    try
    {
      property = ResourceBundle.getBundle( BUSINESS_EXCEPTION_PROPERTIES ).getString( key );
    }
    catch( Exception e )
    {
      LOGGER.error( e.getMessage(), e );
    }
    return property;
  }

}
