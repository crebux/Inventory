package org.example.inventorysystem.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        // 예외 발생 시 전체 스택 트레이스를 포함하여 로깅
        log.error("An exception occurred:", e);

        // 사용자에게 보여줄 에러 페이지 반환
        // "error-page"는 에러를 안내하는 템플릿(view) 이름
        return "error-page";
    }
}