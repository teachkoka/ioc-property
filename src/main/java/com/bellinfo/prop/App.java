package com.bellinfo.prop;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("prop-config.xml");
      /* PropertyLoader propObject = context.getBean("p",PropertyLoader.class);
       propObject.loadConnection();
       propObject.closeConnection();*/
       
       PropertyLoaderWithProps propsObject = context.getBean("pp",PropertyLoaderWithProps.class);
       propsObject.loadConnection();
       propsObject.closeConnection();
 
       PropertyLoaderWithPropFile propsfileObject = context.getBean("ppp",PropertyLoaderWithPropFile.class);
       propsfileObject.loadConnection();
       propsfileObject.closeConnection();
       
    }
}



