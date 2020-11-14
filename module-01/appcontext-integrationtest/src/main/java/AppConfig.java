import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration -- commented since we are not configuring beans here. We are just scanning for annotated(@service, @component) classes in packages

@ComponentScan("services")
public class AppConfig {

}
