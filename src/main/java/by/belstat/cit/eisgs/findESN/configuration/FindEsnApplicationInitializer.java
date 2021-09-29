package by.belstat.cit.eisgs.findESN.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class FindEsnApplicationInitializer implements WebApplicationInitializer {
    private static final Logger LOGGER = LogManager.getLogger(FindEsnApplicationInitializer.class);
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.debug("start on startup");
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("by.belstat.cit.eisgs.findESN.configuration");
        context.setServletContext(servletContext);
        context.refresh();
        servletContext.addListener(new ContextLoaderListener(context));
     //   servletContext.addListener(context.getBean(ApplicationListener.class));
        registerSpringMVCDispatcherServlet(servletContext, context);
    }

    private  void registerSpringMVCDispatcherServlet(ServletContext container, WebApplicationContext ctx) {
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
