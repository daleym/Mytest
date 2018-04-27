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
 * �Զ���������
 * @author Administrator
 *
 */
public class UserLoginInterceptor implements HandlerInterceptor {                                                                                 
    
    /**                                                                                                                                           
     *                                                                                                                                            
     * ���������캯��                                                                                                                             
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017��4��28�� ����5:20:34                                                                                                         
     * @since                                                                                                                                     
     * @param accessService                                                                                                                       
     */                                                                                                                                           
    public UserLoginInterceptor() {                                                                                                               
                                                                                                                                                  
    }                                                                                                                                             
                                                                                                                                                  
    /**                                                                                                                                           
     *                                                                                                                                            
     * ������ִ�з���ǰ                                                                                                                           
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017��4��25�� ����9:01:44                                                                                                         
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
            //У���¼                                                                                                                            
            this.userLoginValidate(request);                                                                                                      
            //У��Ȩ��                                                                                                                            
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
     * �����������ǰ��                                                                                                                           
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017��4��28�� ����11:00:25                                                                                                        
     * @since                                                                                                                                     
     * @param response ��Ӧ                                                                                                                       
     * @param res ����                                                                                                                            
     * @throws Exception                                                                                                                          
     */                                                                                                                                           
    public static void printMessage(HttpServletResponse response, Object res) throws Exception{                                                   
        PrintWriter writer = null;                                                                                                                
        response.setCharacterEncoding("UTF-8");                                                                                                   
        response.setContentType("text/html; charset=utf-8");                                                                                      
        try {                                                                                                                                     
            writer = response.getWriter();                                                                                                        
            writer.print(res); //FIXME json��ʽ                                                                                              
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
     * �������û���¼У��                                                                                                                         
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017��5��9�� ����8:27:25                                                                                                          
     * @since                                                                                                                                     
     * @param request                                                                                                                             
     * @throws BusinessException                                                                                                                  
     */                                                                                                                                           
    private void userLoginValidate(HttpServletRequest request) throws Exception {                                                         
        //У�����                                                                                                                                
    }                                                                                                                                             
                                                                                                                                                  
    /**                                                                                                                                           
     *                                                                                                                                            
     * �������û�Ȩ��У��                                                                                                                         
     * @author mao2080@sina.com                                                                                                                   
     * @created 2017��5��4�� ����8:34:09                                                                                                          
     * @since                                                                                                                                     
     * @param request HttpServletRequest                                                                                                          
     * @param handler                                                                                                                             
     * @return                                                                                                                                    
     * @throws BusinessException                                                                                                                  
     */                                                                                                                                           
    private void userAuthValidate(HttpServletRequest request, Object handler) throws Exception {                                          
        AuthValidate validate = ((HandlerMethod) handler).getMethodAnnotation(AuthValidate.class);                                                
        if(validate == null){                                                                                                                     
            throw new Exception("δ�����Զ���ע��");                                                                                      
        }                                                                                                                                         
        String funcCode = validate.value().getAuthCode();                                                                                         
        if(funcCode.equals(AuthCode.Allow.getAuthCode())){                                                                                        
            return;                                                                                                                               
        }                                                                                                                                         
        String authId = validate.value().getAuthId();                                                                                             
        List<String> auths = new ArrayList<>();//ģ��ӻ�����ߴ����ݿ��в�ѯ����Ӧ�û���Ȩ��                                                     
        if(!auths.contains(authId)){                                                                                                              
            throw new Exception("Ȩ�޲���");                                                                                              
        }                                                                                                                                         
    }                                                                                                                                             
                                                                                                                                                  
}                                                                                                                                                 

