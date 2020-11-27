package spelexamples.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringBean1 {
    @Value("#{'Wall Street'.toUpperCase()}")
    private String streetName;

    @Value("#{5000 * 0.9}")
    private float accountBalance;

    @Value("#{'${app.department.id}'.toUpperCase()}")
    private String departmentName;

    @Value("#{${app.cases.map}}")
    private Map<String, Integer> casesMap;

    @Value("#{springBean2.taxId}")  // object reference
    private int taxId;

    // $ vs #  --> $ uses env abstraction to read value from property file while # begins SpEL expression
    @Value("${app.tax.value}")
    private int taxIdUsingEnvAbstraction;

    public String getStreetName() {
        return streetName;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Map<String, Integer> getCasesMap() {
        return casesMap;
    }

    public int getTaxId() {
        return taxId;
    }

    public int getTaxIdUsingEnvAbstraction(){ return taxIdUsingEnvAbstraction;}

}
