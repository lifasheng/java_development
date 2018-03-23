package com.concretepage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.concretepage.config.AppConfig;
import com.concretepage.dao.IPersonDao;

public class Spring4Hibernate4Test {
  public static void main(String[] args) {
	  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
  	  ctx.register(AppConfig.class);
	  ctx.refresh();
	  IPersonDao pdao = ctx.getBean(IPersonDao.class);

	  pdao.savePerson("Jan");
	  pdao.savePerson("Mike");

	  System.out.println("Done");
  }
}
