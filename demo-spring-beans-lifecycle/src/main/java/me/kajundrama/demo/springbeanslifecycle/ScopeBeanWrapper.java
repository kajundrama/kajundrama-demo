package me.kajundrama.demo.springbeanslifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScopeBeanWrapper {

  @Autowired
  private DefaultScopeBean defaultScopeBean;
  @Autowired
  private SingletonScopeBean singletonScopeBean;
  @Autowired
  private RequestScopeBean requestScopeBean;
  @Autowired
  private PrototypeScopeBean prototypeScopeBean;

  @Override
  public String toString() {
    return "ScopeBeanWrapper{" +
        "defaultScopeBean=" + defaultScopeBean +
        ", singletonScopeBean=" + singletonScopeBean +
        ", requestScopeBean=" + requestScopeBean +
        ", prototypeScopeBean=" + prototypeScopeBean +
        '}';
  }
}
