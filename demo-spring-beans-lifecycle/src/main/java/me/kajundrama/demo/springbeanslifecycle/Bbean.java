package me.kajundrama.demo.springbeanslifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bbean implements ApplicationContextAware, BeanNameAware, BeanClassLoaderAware,
    InitializingBean, DisposableBean {

  Bbean() {
    log.info("생성자 호출");
  }

  @PostConstruct
  public void postCon() {
    log.info("PostConstruct 실행");
  }

  @PreDestroy
  public void preDestroy() {
    log.info("PreDestroy 실행");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    log.info("setApplicationContext 실행");
  }

  @Override
  public void setBeanName(String name) {
    log.info("setBeanName 실행");
  }

  @Override
  public void setBeanClassLoader(ClassLoader classLoader) {
    log.info("setBeanClassLoader 실행");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("afterPropertiesSet 실행");
  }

  @Override
  public void destroy() throws Exception {
    log.info("destroy 실행");
  }
}
