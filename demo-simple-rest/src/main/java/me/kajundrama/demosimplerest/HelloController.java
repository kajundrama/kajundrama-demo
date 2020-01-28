package me.kajundrama.demosimplerest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

  @GetMapping("/{name}")
  public String hello(@PathVariable String name) {
    log.info("hello {}", name);
    return "Hello " + name;
  }


}
