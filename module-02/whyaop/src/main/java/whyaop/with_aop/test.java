package whyaop.with_aop;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class CurrenciesRepositoryAspect {
    @Before("this(com.spring.professional.exam.tutorial.module02.question02.bls.CurrenciesRepositoryImpl)")
    public void beforeThisCurrenciesRepository() {
        System.out.println("Before - this(CurrenciesRepositoryImpl)");
    }
}