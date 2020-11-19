package beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean2 {
    public SpringBean2() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    // JSR-250
    @PostConstruct
    public void afterInit() {

        System.out.println(getClass().getSimpleName() + "::init");
    }

    @PreDestroy
    public void beforeDestroy() {
        ///
        System.out.println(getClass().getSimpleName() + "::destroy");

    }
}
