package com.example.test1;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerTest
 */
@WebListener
public class ListenerTest implements ServletContextListener, HttpSessionListener, ServletRequestListener {

    public ListenerTest() {
    }

    public void sessionCreated(HttpSessionEvent arg0)  {
    	System.out.println("sessionCreated");
    }

    public void requestDestroyed(ServletRequestEvent arg0)  {
    }

    public void requestInitialized(ServletRequestEvent arg0)  {
    	System.out.println("requestInitialized");
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  {
    }

    public void contextDestroyed(ServletContextEvent arg0)  {
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    }
}
