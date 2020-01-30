package com.example.rest.server.web.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
