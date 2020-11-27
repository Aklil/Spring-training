package whyaop.no_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import whyaop.no_aop.actions.ComplexReportAction;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        ComplexReportAction complexReportAction = context.getBean(ComplexReportAction.class);

        complexReportAction.perform();
    }
}
