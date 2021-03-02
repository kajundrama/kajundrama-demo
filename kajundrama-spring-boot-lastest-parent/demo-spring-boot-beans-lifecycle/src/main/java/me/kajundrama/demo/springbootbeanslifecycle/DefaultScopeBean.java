package me.kajundrama.demo.springbootbeanslifecycle;

import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultScopeBean {

  private LocalTime localDateTime;

  public DefaultScopeBean() {
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
    return "DefaultScopeBean{" +
        "localDateTime=" + localDateTime +
        '}';
  }
}
