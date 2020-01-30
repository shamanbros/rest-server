package com.example.rest.server.commons.exception;

/**
 * Wrapper de excepciones de negocio
 * 
 * @author gsegura
 */
public class BusinessException extends RuntimeException
{

  private static final long serialVersionUID = -7473903162290335730L;
  private int code;
  private String description;

  /**
   * Constructor por defecto
   */
  public BusinessException()
  {
    super();
  }

  /**
   * Constructor con detalle del mensaje
   * 
   * @param message
   */
  public BusinessException( String message )
  {
    super( message );
  }

  /**
   * Constructor con detalle del mensaje y excepción
   * 
   * @param message
   */
  public BusinessException( String message, Throwable t )
  {
    super( message, t );
  }

  /**
   * Constructor con la excepción
   * 
   * @param message
   */
  public BusinessException( Throwable t )
  {
    super( t );
  }

  /**
   * @return the code
   */
  public int getCode()
  {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode( int code )
  {
    this.code = code;
  }

  /**
   * @return the description
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription( String description )
  {
    this.description = description;
  }

}
