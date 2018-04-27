package com.ym.springIntercepter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/***
 * 自定义拦截器
 * @author Administrator
 *
 */
public class UserLoginInterceptor implements HandlerInterceptor {                                                                                 
    
    /**                                                                                                                                           
     *                                                                                                                                            
     * 描述：构造函数                                                                                                                             
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017年4月28日 下午5:20:34                                                                                                         
     * @since                                                                                                                                     
     * @param accessService                                                                                                                       
     */                                                                                                                                           
    public UserLoginInterceptor() {                                                                                                               
                                                                                                                                                  
    }                                                                                                                                             
                                                                                                                                                  
    /**                                                                                                                                           
     *                                                                                                                                            
     * 描述：执行方法前                                                                                                                           
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017年4月25日 下午9:01:44                                                                                                         
     * @since                                                                                                                                     
     * @param request HttpServletRequest                                                                                                          
     * @param response HttpServletResponse                                                                                                        
     * @param handler handler                                                                                                                     
     * @return                                                                                                                                    
     * @throws Exception                                                                                                                          
     */                                                                                                                                           
    @Override                                                                                                                                     
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {                         
        try {                                                                                                                                     
            //校验登录                                                                                                                            
            this.userLoginValidate(request);                                                                                                      
            //校验权限                                                                                                                            
            this.userAuthValidate(request, handler);                                                                                              
        } catch (Exception e) {                                                                                                                   
            e.printStackTrace();                                                                                                                  
            printMessage(response, e);                                                                                                            
            return false;                                                                                                                         
        }                                                                                                                                         
        return true;                                                                                                                              
    }                                                                                                                                             
                                                                                                                                                  
    /**                                                                                                                                           
     *                                                                                                                                            
     * 描述：输出到前端                                                                                                                           
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017年4月28日 上午11:00:25                                                                                                        
     * @since                                                                                                                                     
     * @param response 响应                                                                                                                       
     * @param res 对象                                                                                                                            
     * @throws Exception                                                                                                                          
     */                                                                                                                                           
    public static void printMessage(HttpServletResponse response, Object res) throws Exception{                                                   
        PrintWriter writer = null;                                                                                                                
        response.setCharacterEncoding("UTF-8");                                                                                                   
        response.setContentType("text/html; charset=utf-8");                                                                                      
        try {                                                                                                                                     
            writer = response.getWriter();                                                                                                        
            writer.print(res); //FIXME json格式                                                                                              
        } catch (Exception e) {                                                                                                                   
            e.printStackTrace();                                                                                                                  
        } finally {                                                                                                                               
            if (writer != null){                                                                                                                  
                writer.close();                                                                                                                   
            }                                                                                                                                     
        }                                                                                                                                         
    }                                                                                                                                             
                                                                                                                                                  
    @Override                                                                                                                                     
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                                                                                                                                                  
    }                                                                                                                                             
                                                                                                                                                  
    @Override                                                                                                                                     
    public void afterCompletion(HttpServletRequest request,    HttpServletResponse response, Object handler, Exception ex)    throws Exception {  
                                                                                                                                                  
    }                                                                                                                                             
                                                                                                                                                  
    /**                                                                                                                                           
     *                                                                                                                                            
     * 描述：用户登录校验                                                                                                                         
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017年5月9日 下午8:27:25                                                                                                          
     * @since                                                                                                                                     
     * @param request                                                                                                                             
     * @throws BusinessException                                                                                                                  
     */                                                                                                                                           
    private void userLoginValidate(HttpServletRequest request) throws Exception {                                                         
        //校验代码                                                                                                                                
    }                                                                                                                                             
                                                                                                                                                  
    /**                                                                                                                                           
     *                                                                                                                                            
     * 描述：用户权限校验                                                                                                                         
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017年5月4日 下午8:34:09                                                                                                          
     * @since                                                                                                                                     
     * @param request HttpServletRequest                                                                                                          
     * @param handler                                                                                                                             
     * @return                                                                                                                                    
     * @throws BusinessException                                                                                                                  
     */                                                                                                                                           
    private void userAuthValidate(HttpServletRequest request, Object handler) throws Exception {                                          
        AuthValidate validate = ((HandlerMethod) handler).getMethodAnnotation(AuthValidate.class);                                                
        if(validate == null){                                                                                                                     
            throw new Exception("未配置自定义注解");                                                                                      
        }                                                                                                                                         
        String funcCode = validate.value().getAuthCode();                                                                                         
        if(funcCode.equals(AuthCode.Allow.getAuthCode())){                                                                                        
            return;                                                                                                                               
        }                                                                                                                                         
        String authId = validate.value().getAuthId();                                                                                             
        List<String> auths = new ArrayList<>();//模拟从缓存或者从数据库中查询出对应用户的权限                                                     
        if(!auths.contains(authId)){                                                                                                              
            throw new Exception("权限不足");                                                                                              
        }                                                                                                                                         
    }                                                                                                                                             
                                                                                                                                                  
}                                                                                                                                                 

