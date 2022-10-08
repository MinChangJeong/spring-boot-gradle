package backend.boot.common.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionIntercepter implements HandlerInterceptor {
 
    // Session 검사
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object obj) throws Exception {

        return false;
    }
}
