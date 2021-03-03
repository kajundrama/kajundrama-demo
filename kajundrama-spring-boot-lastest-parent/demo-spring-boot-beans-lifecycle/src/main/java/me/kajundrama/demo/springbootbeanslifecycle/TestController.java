package me.kajundrama.demo.springbootbeanslifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  ApplicationContext applicationContext;
  @Autowired
  private DefaultScopeBean defaultScopeBean;
  @Autowired
  private SingletonScopeBean singletonScopeBean;
  @Autowired
  private RequestScopeBean requestScopeBean;
  @Autowired
  private PrototypeScopeBean prototypeScopeBean;
  @Autowired
  private ScopeBeanWrapper scopeBeanWrapper;

  @GetMapping("/")
  public void test() {

    log.info("#################### REQUEST 요청 ############################");
    log.info(defaultScopeBean.toString());
    log.info(singletonScopeBean.toString());
    log.info(requestScopeBean.toString());
    log.info(prototypeScopeBean.toString());
    log.info(scopeBeanWrapper.toString());
    log.info(applicationContext.getBean("prototypeScopeBean").toString());

    log.info(defaultScopeBean.toString());
    log.info(singletonScopeBean.toString());
    log.info(requestScopeBean.toString());
    log.info(prototypeScopeBean.toString());
    log.info(scopeBeanWrapper.toString());
    log.info(applicationContext.getBean("prototypeScopeBean").toString());

  }

}
