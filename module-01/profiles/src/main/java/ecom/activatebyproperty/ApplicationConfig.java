package ecom.activatebyproperty;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

// @Configuration -- commented since we are not configuring beans here. We are just scanning for annotated(@service, @component) classes in packages

@ComponentScan(basePackages = {"ecom.services"})
@PropertySource("classpath:/app.properties")

public class ApplicationConfig {

}
