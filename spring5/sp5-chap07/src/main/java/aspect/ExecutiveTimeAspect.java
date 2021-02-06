package aspect;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExecutiveTimeAspect {

    @Pointcut(value = "execution(public * chap07..*(..))")
    private void publicTarget() {
    }

    @Around("publicTarget()")
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
