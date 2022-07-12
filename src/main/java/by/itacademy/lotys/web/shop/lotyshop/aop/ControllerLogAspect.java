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
public class ControllerLogAspect extends BaseAspect {

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    @Pointcut("execution(* by.itacademy.lotys.web.shop.lotyshop.controllers..*(..))" +
            "&& !@annotation(by.itacademy.lotys.web.shop.lotyshop.aop.ExcludeLog)")
    public void before() {

    }

    @Pointcut("execution(* by.itacademy.lotys.web.shop.lotyshop.controllers..*(..))" +
            "&& !@annotation(by.itacademy.lotys.web.shop.lotyshop.aop.ExcludeLog)")
    public void after() {

    }


    @Before("before()")
    public void logControllersBefore(JoinPoint joinPoint) {

        var request = getRequest();

        log.info(BEFORE_PATTERN_CONTROLLER,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                getArgsWithName(joinPoint));
    }

    @AfterReturning(pointcut = "after()",returning = "result")
    public void logControllersAfter(JoinPoint joinPoint,Object result){

        var request = getRequest();

        log.info(AFTER_PATTERN_CONTROLLER,
                getRequest().getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                getStringInstanceOf(Optional.ofNullable(result).orElse("")),
                getArgsWithName(joinPoint));

    }


}
