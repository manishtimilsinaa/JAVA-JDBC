package com.example.SpringJDBCDemo;

import com.example.SpringJDBCDemo.model.man;
import com.example.SpringJDBCDemo.repo.manRep0;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringJdbcDemoApplication.class, args);
man man1=context.getBean(man.class);
man1.setId(10);
man1.setName("mannish");
man1.setTech("it");

		manRep0 rep=context.getBean(manRep0.class);
		rep.save(man1);

		System.out.println(rep.findAll());
	}

}
