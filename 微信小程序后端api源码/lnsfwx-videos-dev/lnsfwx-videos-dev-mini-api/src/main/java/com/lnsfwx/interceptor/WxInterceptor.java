package com.lnsfwx.interceptor;

import com.lnsfwx.utils.JsonUtils;
import com.lnsfwx.utils.LnsfwxJSONResult;
import com.lnsfwx.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.proto.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @Auther 刘瑞涛
 * @Date 2020-04-02 3:29
 **/
public class WxInterceptor implements HandlerInterceptor {

    @Autowired
    public RedisOperator redis;
    //redis文件夹的名称
    public static final String USER_REDIS_SESSION = "user_redis_session";

    /**
     * controller调用之前进行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String userId =  request.getHeader("userId");
        String uniqueKey = request.getHeader("uniqueKey");
        String getUniqueKey =  redis.get(USER_REDIS_SESSION+":"+userId);
        if(StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(uniqueKey)){
            if (StringUtils.isBlank(getUniqueKey) && StringUtils.isEmpty(getUniqueKey)){
                System.out.println(1);
                returnErrorResponse(response,new LnsfwxJSONResult().errorTokenMsg("请登录..."));
                return false;
            }else {
                if(!uniqueKey.equals(getUniqueKey)){
              //      System.out.println("2"+uniqueKey);
              //      System.out.println("2"+getUniqueKey);
                    returnErrorResponse(response,new LnsfwxJSONResult().errorTokenMsg("账号已登录..."));
                    return  false;
                }else {
                    //System.out.println(3);
                    //System.out.println("2"+uniqueKey);
                   // System.out.println("2"+getUniqueKey);
                    return true;
                }
            }
        }else {
           // System.out.println(4);
           // System.out.println("4"+uniqueKey);
          //  System.out.println("4"+getUniqueKey);
            returnErrorResponse(response,new LnsfwxJSONResult().errorTokenMsg("请登录..."));
            return false;
        }

    }

    /**
     * 错误抛出
     * @param response
     * @param result
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public void  returnErrorResponse(HttpServletResponse response, LnsfwxJSONResult result)
    throws IOException, UnsupportedEncodingException{
        OutputStream outputStream =null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            outputStream = response.getOutputStream();
            outputStream.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
            outputStream.flush();
        }finally {
            if (outputStream!=null){
                outputStream.close();
            }
        }
    }

    /**
     * 渲染页面之前的handle
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
