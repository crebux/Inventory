package org.example.inventorysystem.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerLoggingAspect {

    // 컨트롤러 패키지 내부 모든 클래스의 모든 메서드
    @Pointcut("execution(* org.example.inventorysystem.controller.*.*(..))")
    public void controllerMethods() {}

    // 메서드 실행 전 (Before advice)
    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        log.info("컨트롤러 메서드 시작: {}", methodName);
    }

    // 메서드 정상 실행 종료 후 (After Returning advice)
    @AfterReturning("controllerMethods()")
    public void logAfterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        log.info("컨트롤러 메서드 정상 종료: {}", methodName);
    }

    // 메서드 실행 중 예외 발생 시 (After Throwing advice)
    @AfterThrowing(value = "controllerMethods()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().toShortString();
        log.error("컨트롤러 메서드 예외 발생: {} - 예외: {}", methodName, ex.getMessage(), ex);
    }
}
