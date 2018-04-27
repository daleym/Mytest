package com.ym.springIntercepter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ע���Զ���������
 * ע�⣺��Ҫ���  spring-beans-4.3.2.RELEASE.jar������ᱨ��
 * @author Administrator
 *
 */
@Configuration
@ComponentScan(basePackages={"com.ym.springInterceptor"})
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {                    
                                                                                   
	/**��־*/                                                                      
    private static final Log loger = LogFactory.getLog(WebConfiguration.class);    
                                                                                   
    /**                                                                            
     *                                                                             
     * ���������캯��                                                              
     * @author mao2080@sina.com                                                    
     * @created 2017��5��3�� ����4:48:41                                           
     * @since                                                                      
     */                                                                            
    public WebConfiguration() {                                                    
        loger.info("����ϵͳ��¼����");                                            
    }                                                                              
                                                                                   
    /**                                                                            
     *                                                                             
     * ���������������                                                            
     * @author mao2080@sina.com                                                    
     * @created 2017��4��25�� ����8:50:54                                          
     * @since                                                                      
     * @param registry                                                             
     */                                                                            
    @Override                                                                      
    public void addInterceptors(InterceptorRegistry registry) {                    
        this.excludeUserLogin(registry.addInterceptor(new UserLoginInterceptor()));
    }                                                                              
                                                                                   
    /**                                                                            
     *                                                                             
     * ��������������                                                              
     * @author mao2080@sina.com                                                    
     * @created 2017��5��9�� ����8:55:28                                           
     * @since                                                                      
     * @param registration                                                         
     */                                                                            
    public void excludeUserLogin(InterceptorRegistration registration){            
        registration.addPathPatterns("/userController/*");                         
    }                                                                              
                                                                                   
}                                                                                  
