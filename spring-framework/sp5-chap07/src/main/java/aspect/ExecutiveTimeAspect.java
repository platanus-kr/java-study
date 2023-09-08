package aspect;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ExecutiveTimeAspect {

//    @Pointcut(value = "execution(public * chap07..*(..))")
//    public void publicTarget() {
//    }

    @Around("CommonPointcut.commonTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();
            Signature signature = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) runtime : %s ns\n",
                joinPoint.getTarget().getClass().getSimpleName(),
                signature.getName(), Arrays.toString(joinPoint.getArgs()),
                (finish - start));
        }
    }

}
