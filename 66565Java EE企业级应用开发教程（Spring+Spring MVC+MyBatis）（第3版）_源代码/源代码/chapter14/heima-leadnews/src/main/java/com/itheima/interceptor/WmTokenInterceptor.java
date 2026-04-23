package com.itheima.interceptor;


import com.itheima.entity.WmUser;
import com.itheima.utils.JWTUtil;
import com.itheima.utils.WmThreadLocalUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class WmTokenInterceptor implements HandlerInterceptor {
    /**
     * 获取请求头中的用户信息，并且存入到当前线程中
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.判断是否是登录
        if (request.getRequestURI().contains("/login")) {
            //放行
            return true;
        }
        //2.获取Token
        String token = request.getHeader("token");
        //3.判断Token是否存在
        if (StringUtils.isBlank(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        //4.判断Token是否有效
        try {
            Claims claimsBody = JWTUtil.getJws(token).getBody();
            //是否是过期
            int result = JWTUtil.verifyToken(claimsBody);
            if (result == 1 || result == 2) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
            //获取用户信息
            Integer userId =(Integer)claimsBody.get("id");
            //存入到当前线程中
            WmUser wmUser = new WmUser();
            wmUser.setId(userId);
            WmThreadLocalUtil.setUser(wmUser);
               } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 清理线程中的数据
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        WmThreadLocalUtil.clear();
    }
}
