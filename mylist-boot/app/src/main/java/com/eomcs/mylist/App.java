package com.eomcs.mylist;

import javax.sql.DataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  // Spring 프레임워크(IoC = 객체풀)에서 객체를 생성한 후 보관하도록 만드는 방법
  @Bean // => 다음 메서드를 호출한 후 이 메서드가 리턴한 값을 스프링 부트에 보관하라고 지시하는 애노테이션
  public DataSource createDataSource() {
    System.out.println("createDataSource() 호출됨!!!");
    try {
      DriverManagerDataSource connectionPool = new DriverManagerDataSource();
      connectionPool.setDriverClassName("org.mariadb.jdbc.Driver"); // 어느 드라이버를 쓸건지
      connectionPool.setUrl("jdbc:mariadb://localhost:3306/studydb"); // jdbc url은 어떻게 되는지
      connectionPool.setUsername("study");
      connectionPool.setPassword("1111");

      return connectionPool;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);   // springApplication 클래스의 run 메서드를 호출하는 것! App.class에서 .class는 확장자가 아니라 APP이라는 클래스의(자바에서 제공하는) 내장변수임! class 변수에는 해당 클래스의 정보가 들어가있다. //App이라는 클래스는 SpringApplication이라는 외부 라이브러리를 사용하는 것! ctrl 누른채로 SpringApplication 클릭하면 이 위치로 간다! 
    // 스프링부트가 객체를 만든다! 따라서 App.java를 실행하면 ContactController.java에 있는 "ContactController() 호출됨!"이게 출력됨
  }

  // @Bean  주석으로 처리되면 일반클래스가 돼서 자동으로 동작안된다!!
  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
    return args -> {

      System.out.println("빈 컨테이너가 생성한 객체(빈 컨테이너에 들어 있는 객체):");

      String[] beanNames = beanContainer.getBeanDefinitionNames();  // 빈컨테이너에 등록한 이름 가져와
      for (int i = 0; i < beanNames.length; i++) {
        Object bean = beanContainer.getBean(beanNames[i]);
        System.out.printf("----> %03d: %s\n", i + 1, bean.getClass().getName());  // 우리가 만든거 말고도 스프링 부트가 직접 만들어준 객체까지 146개나 되는구나!
      }

    };
  }

  @RequestMapping("/hello") 
  String hello() {
    return "Hello World!";
  }
}