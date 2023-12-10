package todo.app.configs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger log = LogManager.getLogger(AsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... args) {
        if(log.isErrorEnabled())log.error("Async Exception at >>>> {}  With Args  {}  Exception Message :{} "
                , method.getName() , Arrays.toString(args) , ex.getMessage() );
        
        log.error("Async Exception ", ex);
    }
}