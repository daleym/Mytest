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
 * 注册自定义拦截器
 * 注意：需要添加  spring-beans-4.3.2.RELEASE.jar，否则会报错！
 * @author Administrator
 *
 */
@Configuration
@ComponentScan(basePackages={"com.ym.springInterceptor"})
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {                    
                                                                                   
	/**日志*/                                                                      
    private static final Log loger = LogFactory.getLog(WebConfiguration.class);    
                                                                                   
    /**                                                                            
     *                                                                             
     * 描述：构造函数                                                              
     * @author mao2080@sina.com                                                    
     * @created 2017年5月3日 下午4:48:41                                           
     * @since                                                                      
     */                                                                            
    public WebConfiguration() {                                                    
        loger.info("开启系统登录拦截");                                            
    }                                                                              
                                                                                   
    /**                                                                            
     *                                                                             
     * 描述：添加拦截器                                                            
     * @author mao2080@sina.com                                                    
     * @created 2017年4月25日 下午8:50:54                                          
     * @since                                                                      
     * @param registry                                                             
     */                                                                            
    @Override                                                                      
    public void addInterceptors(InterceptorRegistry registry) {                    
        this.excludeUserLogin(registry.addInterceptor(new UserLoginInterceptor()));
    }                                                                              
                                                                                   
    /**                                                                            
     *                                                                             
     * 描述：拦截请求                                                              
     * @author mao2080@sina.com                                                    
     * @created 2017年5月9日 下午8:55:28                                           
     * @since                                                                      
     * @param registration                                                         
     */                                                                            
    public void excludeUserLogin(InterceptorRegistration registration){            
        registration.addPathPatterns("/userController/*");                         
    }                                                                              
                                                                                   
}                                                                                  
