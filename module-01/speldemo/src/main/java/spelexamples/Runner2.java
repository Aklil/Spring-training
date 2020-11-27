package spelexamples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import spelexamples.beans.SpringBean1;

public class Runner2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setBeanResolver(new BeanFactoryResolver(context));

        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(
                parser.parseExpression("@springBean1.streetName").getValue(evaluationContext)
        );
        System.out.println(
                parser.parseExpression("@springBean1.accountBalance + 1000").getValue(evaluationContext)
        );
        System.out.println(
                parser.parseExpression("@springBean1.casesMap.get('caseA')").getValue(evaluationContext)
        );

        var bean1 = context.getBean(SpringBean1.class);
        System.out.println("Using property abstraction: " + bean1.getTaxIdUsingEnvAbstraction());

    }
}
