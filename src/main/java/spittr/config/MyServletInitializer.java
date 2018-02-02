package spittr.config;

import org.springframework.web.WebApplicationInitializer;
import spittr.config.servlet.MyServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyServletInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic mySelvlet = servletContext.addServlet("myServlet", MyServlet.class);
        mySelvlet.addMapping("/my-servlet");
    }
}
