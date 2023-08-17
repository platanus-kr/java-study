package aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {

    @Pointcut(value = "execution(public * chap07..*(..))")
    public void commonTarget() {
        
    }

}
