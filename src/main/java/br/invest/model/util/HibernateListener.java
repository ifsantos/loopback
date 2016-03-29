package br.invest.model.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateListener implements ServletContextListener {  
	  
	private static final SessionFactory sessionFactory;  
	  
    static {  
        try {  
            // Create the SessionFactory from hibernate.cfg.xml  
            sessionFactory = new Configuration().configure().buildSessionFactory();  
        } catch (Throwable ex) {  
            // Make sure you log the exception, as it might be swallowed  
            System.err.println("Initial SessionFactory creation failed." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
  
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
	
    public void contextInitialized(ServletContextEvent event) {  
    	getSessionFactory(); // Just call the static initializer of that class      
    }  
  
    public void contextDestroyed(ServletContextEvent event) {  
        getSessionFactory().close(); // Free all resources  
    }  
}  
