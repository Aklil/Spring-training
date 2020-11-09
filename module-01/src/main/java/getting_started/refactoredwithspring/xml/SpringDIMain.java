package getting_started.refactoredwithspring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import getting_started.without.flexible.MessageRenderer;

/**
 * ApplicationContext interface -->
 *  Stores all the environmental information with regard to an application being managed by spring
 *  Acts as the provider of any spring-managed bean instance
 *      Bean- an object managed by spring
 */
public class SpringDIMain {
    public static void main(String[] args) {

        // read in the configuration file
        // spring initializes the context with configurations
        // the context instantiates beans and injects them where needed

        // No need for factory class
        // Loosely coupled

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/app-context.xml");  //reads configs from spring xml config

        // let spring get the object by providing its unique id to it
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();

    }
}
