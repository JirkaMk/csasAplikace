package tasks;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


//spousti se s incializaci serveru 
@WebListener
public class InitializeListner implements ServletContextListener {

    @Override
    public final void contextInitialized(final ServletContextEvent sce) {
    	
    	// spusti pri incialiazaci Spring context, ktery spousti tasky typu Scheduller  
    	AbstractApplicationContext  context = new AnnotationConfigApplicationContext(SpringSchedullerConfig.class);
    	System.out.println("Initialization has been successfully loaded.");
    }

    @Override
    public final void contextDestroyed(final ServletContextEvent sce) {

    }
}
