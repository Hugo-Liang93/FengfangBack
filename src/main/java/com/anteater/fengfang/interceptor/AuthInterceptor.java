package com.anteater.fengfang.interceptor;

import com.anteater.fengfang.controller.UserController;
import com.anteater.fengfang.domains.auth.CheckResult;
import com.anteater.fengfang.utils.JwtTokenUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;

public class AuthInterceptor implements HandlerInterceptor {
    private static org.apache.log4j.Logger logger= Logger.getLogger(AuthInterceptor.class);
    //不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getHeader("Authorization") == null){
            logger.info("not login");
            return false;
        }else {
            String accessToken = request.getHeader("Authorization").split(" ")[1];
            CheckResult checkResult = JwtTokenUtils.validateJWT(accessToken);
            // 需要对准备超时对象renew token
            if(!checkResult.getSuccess()) response.sendError(HttpServletResponse.SC_UNAUTHORIZED,checkResult.getErrCode());
            return checkResult.getSuccess();
        }
    }

    //当上述方法放行且处理方法执行之后调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
