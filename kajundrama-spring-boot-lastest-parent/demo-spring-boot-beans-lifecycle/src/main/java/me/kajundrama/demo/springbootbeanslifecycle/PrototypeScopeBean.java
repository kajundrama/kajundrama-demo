package me.kajundrama.demo.springbootbeanslifecycle;

import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
public class PrototypeScopeBean {

  private LocalTime localDateTime;

  public PrototypeScopeBean() {
    log.info("생성자 호출");
    localDateTime = LocalTime.now();
  }

  public LocalTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  @Override
  public String toString() {
    return "PrototypeScopeBean{" +
        "localDateTime=" + localDateTime +
        '}';
  }
}
