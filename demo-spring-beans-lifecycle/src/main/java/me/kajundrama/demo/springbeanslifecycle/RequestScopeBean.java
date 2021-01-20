package me.kajundrama.demo.springbeanslifecycle;

import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Component
@RequestScope
public class RequestScopeBean {

  private LocalTime localDateTime;

  public RequestScopeBean() {
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
    return "RequestScopeBean{" +
        "localDateTime=" + localDateTime +
        '}';
  }
}
