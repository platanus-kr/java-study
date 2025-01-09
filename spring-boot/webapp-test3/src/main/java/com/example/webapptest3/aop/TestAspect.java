package com.example.webapptest3.aop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestAspect {

    public static final List<RunServiceStatus> statusList = new ArrayList<>();

    @Pointcut("execution(* com.example.webapptest3.aop.*Service.execute())")
    private void aopTarget() {
    }

    @Around("aopTarget()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        String serviceName = joinPoint.getTarget().getClass().getSimpleName();
        Optional<RunServiceStatus> serviceOpt = statusList.stream().filter(v -> serviceName.equals(v.getServiceName())).findAny();
        RunServiceStatus runService;
        if (serviceOpt.isPresent()) {
            runService = serviceOpt.get();
            runService.setRunning(true);
        } else {
            runService = new RunServiceStatus();
            runService.setServiceName(serviceName);
            runService.setRunning(true);
            statusList.add(runService);
        }
        Object result = joinPoint.proceed();
        runService.setRunning(false);
        runService.setLastServiceRuntime(LocalDateTime.now());

        return result;
    }

}

@Data
class RunServiceStatus {
    private String serviceName;
    private boolean isRunning;
    private LocalDateTime lastServiceRuntime;
}
