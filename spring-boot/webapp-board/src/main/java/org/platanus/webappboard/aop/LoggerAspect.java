package org.platanus.webappboard.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

//    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* org.platanus.webappboard..controller.*Controller.*(..)) or"
        + "execution(* org.platanus.webappboard..service.*Implement.*(..)) or"
        + "execution(* org.platanus.webappboard..dao.*Mapper.*(..))")
    public Object logPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();
        if (name.indexOf("Controller") > -1) {
            type = "Controller \t:";
        } else if (name.indexOf("Service") > -1) {
            type = "ServiceImplement \t:";
        } else if (name.indexOf("Mapper") > -1) {
            type = "Mapper \t\t:";
        }
        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }

}
