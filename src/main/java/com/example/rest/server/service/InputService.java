package com.example.rest.server.service;

import com.example.rest.server.commons.to.ProcessRequestTO;

/**
 * Interface para el servicio de procesamiento de entradas
 * 
 * @author gsegura
 */
public interface InputService
{

  /**
   * Servicio para procesar mensajes
   * 
   * @param process
   */
  void processInput( ProcessRequestTO process );

}
