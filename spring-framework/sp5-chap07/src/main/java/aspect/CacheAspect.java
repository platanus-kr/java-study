package aspect;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class CacheAspect {

    private Map<Long, Object> cache = new HashMap<>();

//    @Pointcut("execution(public * chap07..*(long))")
//    public void cacheTarget() {
//    }

    @Around("CommonPointcut.commonTarget()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        Long number = (Long) joinPoint.getArgs()[0];
        if (cache.containsKey(number)) {
            System.out.printf("CacheAspect: Get the item from Cache [%d]\n", number);
            return cache.get(number);
        }

        Object result = joinPoint.proceed();
        cache.put(number, result);
        System.out.printf("CacheAspect: Put the item in Cache [%d]\n", number);
        return result;
    }

}
