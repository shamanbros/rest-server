package com.example.rest.server.web.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.server.commons.to.ProcessRequestTO;
import com.example.rest.server.commons.to.ProcessResponseTO;

@RestController
@RequestMapping("/server")
public class ProcessController
{
  @GetMapping("/")
  public ResponseEntity<String> get()
  {
    String msg = "OK";
    return ResponseEntity.ok().body( msg );
  }

  @PostMapping("/process{id}")
  public ResponseEntity<ProcessResponseTO> process( @PathVariable Long id, @RequestBody ProcessRequestTO process )
  {
    ProcessResponseTO response = new ProcessResponseTO();
    response.setCode( "OK" );
    response.setRequest( process );
    return ResponseEntity.ok().body( response );
  }
}
