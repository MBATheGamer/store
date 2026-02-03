package com.mbathegamer.store.components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class HeavyResource {
  public HeavyResource() {
    System.out.println("HeavyResource created");
  }
}
