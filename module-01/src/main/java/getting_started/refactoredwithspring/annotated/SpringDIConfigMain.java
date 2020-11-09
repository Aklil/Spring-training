package getting_started.refactoredwithspring.annotated;

import getting_started.without.flexible.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDIConfigMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);  // reads configs from Java classes

        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);

        renderer.render();
    }
}
