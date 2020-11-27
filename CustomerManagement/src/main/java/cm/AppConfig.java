package cm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.Retention;

@EnableAspectJAutoProxy // Enables support for handling components marked with AspectJ's @Aspect annotation
@ComponentScan
public class AppConfig {
}
