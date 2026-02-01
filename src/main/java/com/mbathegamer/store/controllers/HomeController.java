package com.mbathegamer.store.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @Value("${spring.application.name}")
  private String appName;

  @Value("${app.page-size}")
  private Integer pageSize;

  @GetMapping("/")
  public String index() {
    System.out.println("Application name is " + appName + "!");
    System.out.println("Page size is " + pageSize + "!");
    return "index.html";
  }
}
