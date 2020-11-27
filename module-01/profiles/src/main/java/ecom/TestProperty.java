package ecom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperty {

    @Value("${db.host}")
    private String dbPassword;

    public String getDbPassword(){
        return this.dbPassword;
    }
}
