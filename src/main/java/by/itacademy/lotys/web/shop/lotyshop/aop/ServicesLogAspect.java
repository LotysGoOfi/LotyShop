package by.itacademy.lotys.web.shop.lotyshop.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@Aspect
@Component
public class ServicesLogAspect extends BaseAspect {

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    @Pointcut("execution(* by.itacademy.lotys.web.shop.lotyshop.services..*(..))" +
            "&& !@annotation(by.itacademy.lotys.web.shop.lotyshop.aop.ExcludeLog)")
    public void before() {

    }

    @Pointcut("execution(* by.itacademy.lotys.web.shop.lotyshop.services..*(..))" +
            "&& !@annotation(by.itacademy.lotys.web.shop.lotyshop.aop.ExcludeLog)")
    public void after() {

    }


    @Before("before()")
    public void logServicesBefore(JoinPoint joinPoint) {

        var request = getRequest();

        log.info(BEFORE_PATTERN_SERVICE,
                request.getMethod(),
                getArgsWithName(joinPoint));
    }

    @AfterReturning(pointcut = "after()",returning = "result")
    public void logServicesAfter(JoinPoint joinPoint, Object result){

        var request = getRequest();
        log.info(AFTER_PATTERN_SERVICE,
                getRequest().getMethod(),
                getStringInstanceOf(Optional.ofNullable(result).orElse("")),
                getArgsWithName(joinPoint));

    }
}
