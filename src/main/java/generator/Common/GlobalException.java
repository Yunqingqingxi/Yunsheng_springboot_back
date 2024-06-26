package generator.Common;

import generator.Exception.UserExe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler
    public R exceptionHandler(UserExe ex) {
        log.error("异常信息：{}", ex.getMessage());
        return R.error(ex.getMessage());
    }





}
