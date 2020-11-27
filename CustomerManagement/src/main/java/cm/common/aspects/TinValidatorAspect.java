package cm.common.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TinValidatorAspect {


/*   @Before("@annotation(cm.common.TinValidator)")  // inline
   public void validateTinAdvice(){
       System.out.println("Trying to validate");
   }*/

   @Before("@annotation(cm.common.TinValidator)")
   public void validateTinAdvice(JoinPoint joinPoint) throws Exception {
      // first get method argument in this case a tin from the method
      // joinPoint.getArgs() returns all method arguments
      // the first index [0] returns the tin number in our case
      // since getCustomreByTin(String tin) has only one paramet

      String tin = joinPoint.getArgs()[0].toString();
      System.out.println("Tin: " + tin);

      if(tin.length() < 5)
         throw new Exception("Invalid tin number exception");

      System.out.println("Valid Tin");
   }
}
