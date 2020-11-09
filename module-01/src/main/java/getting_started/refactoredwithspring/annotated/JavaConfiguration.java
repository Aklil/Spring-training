package getting_started.refactoredwithspring.annotated;

import getting_started.without.flexible.MessageProvider;
import getting_started.without.flexible.MessageRenderer;
import getting_started.without.flexible.SimpleMessageProvider;
import getting_started.without.flexible.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configuration classes are Java classes annotated with @Configuratino that contain bean definition (Methods annotated with @Bean)
 */
@Configuration   //Equivalent to app-context.xml
public class JavaConfiguration {

    @Bean  // equivalent to <bean id="provider" class="..."/>
    public MessageProvider provider(){
        return new SimpleMessageProvider();
    }

    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
