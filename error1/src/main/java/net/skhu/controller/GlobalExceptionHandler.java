package net.skhu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception exception) {
        log.error("전역 에러", exception);
        return "error";
    }
    /**
     * 입력 화면에서 에러가 발생했을 때, 입력 화면이 다시 출력되도록 try catch 블럭을 구현을 하였다.

	입력 화면이 아닌 곳에서 에러가 발생하면,
	즉 try catch 블럭이 아닌 곳에서 에러가 발생하면

	이 GlobalExceptionHandler 클래스의 exceptionHandler 액션 메소드가 호출된다.
	줄14에서 자세한 에러 메시지를 로그에 기록하고
	줄15에서 뷰의 이름을 출력한다.

     * 
     * 
     */

}
