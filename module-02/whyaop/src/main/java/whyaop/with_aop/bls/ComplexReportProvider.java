package whyaop.with_aop.bls;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import whyaop.with_aop.annotations.PerformanceLogger;
import whyaop.with_aop.ds.Report;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportProvider {
    @PerformanceLogger
    @Cacheable
    public Report getReport() throws InterruptedException {
        System.out.println("Fetching the report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("Report created");

        return new Report();
    }
}
