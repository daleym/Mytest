package com.ym.springIntercepter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller                                                                          
@RequestMapping("/userController")                                                   
public class UserController {                                                        
                                                                                     
    /**��־*/                                                                        
    @SuppressWarnings("unused")                                                      
    private static final Log loger = LogFactory.getLog(UserController.class);        
                                                                                     
     /**                                                                             
      *                                                                              
      * �����������û�                                                               
      * @author mao2080@sina.com                                                     
      * @created 2017��5��9�� ����8:16:41                                            
      * @since                                                                       
      * @param request                                                               
      * @return                                                                      
      * @throws BusinessException                                                    
      */                                                                             
    @RequestMapping(value = "/createUser" , method = RequestMethod.POST)                                                   
    @ResponseBody                                                                    
    @AuthValidate(AuthCode.AU0001)                                                   
    public ResObject createUser(HttpServletRequest request) throws Exception{
        //ҵ�����                                                                   
        return new ResObject();                                                      
    }                                                                                
                                                                                     
    /**                                                                              
      *                                                                              
      * �����������û�                                                               
      * @author mao2080@sina.com                                                     
      * @created 2017��5��9�� ����8:16:41                                            
      * @since                                                                       
      * @param request                                                               
      * @return                                                                      
      * @throws BusinessException                                                    
      */                                                                             
    @RequestMapping("/deleteUser")                                                   
    @ResponseBody                                                                    
    @AuthValidate(AuthCode.AU0002)                                                   
    public ResObject deleteUser(HttpServletRequest request) throws Exception{
        //ҵ�����                                                                   
        return new ResObject();                                                      
    }                                                                                
}                                                                                    

