package com.example.rest.server.web.server;

import java.util.Calendar;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.server.commons.to.ProcessRequestTO;
import com.example.rest.server.commons.to.RequestTO;
import com.example.rest.server.service.InputService;

@RestController
@RequestMapping("/server")
public class InputController
{

  @Autowired
  private InputService inputService;

  @GetMapping("/input")
  public ResponseEntity<String> get(
      )
  {
    String msg = "OK input";


    return ResponseEntity.ok().body( msg );
  }

  @PostMapping("/input")
  public ResponseEntity<RequestTO> processInput( @RequestBody RequestTO request, 
      HttpServletRequest httpServletRequest)
  {
    ProcessRequestTO process = new ProcessRequestTO();
    process.setRequest( request );
    process.setIp( httpServletRequest.getRemoteAddr() );
    process.setTimestamp( Calendar.getInstance().getTime() );
    process.setUuid( UUID.randomUUID().toString() );

    inputService.processInput( process );
    return ResponseEntity.ok().body( request );
  }

}
