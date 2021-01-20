package me.kajundrama.demo.springbeanslifecycle;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Abean {

  public Abean() {
    log.info("생성자 실행");
  }

  @PostConstruct
  public void postConstruct() {
    log.info("postConstruct 실행");
  }
}
