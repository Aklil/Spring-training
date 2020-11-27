package whyaop.with_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.logging.Logger;

/**
 * An aspect class
 *  shows the join point
 *  and implements the advice i.e the logic that is done by the aspect
 */
@Aspect
@Component
public class PerformanceLoggerAspect {

    private Logger logger = Logger.getLogger("performance.logger");

    @Around("@annotation(com.spring.professional.exam.tutorial.module02.question01.with.aop.annotations.PerformanceLogger)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long finishTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishTime - startTime);

            logger.info(String.format("Duration of %s execution was %s", proceedingJoinPoint.getSignature(), duration));
        }
    }
}
