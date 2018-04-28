package com.ym.spring.interceptor;

public enum AuthCode {                                                                                                                     
    
    Allow("00000", "00000", "�������"),                                                                                                   
                                                                                                                                           
    /******************�ͻ�Ȩ��******************/                                                                                         
                                                                                                                                           
    AU0001("100001", "AU0001", "�����û�", "�����û�"),                                                                                    
                                                                                                                                           
    AU0002("100002", "AU0002", "ɾ���û�", "����ɾ���û�");                                                                                
                                                                                                                                           
    /**Ȩ�ޱ�ʶ */                                                                                                                         
    private String authId;                                                                                                                 
                                                                                                                                           
    /**Ȩ�ޱ��� */                                                                                                                         
    private String authCode;                                                                                                               
                                                                                                                                           
    /**Ȩ������ */                                                                                                                         
    private String authName;                                                                                                               
                                                                                                                                           
    /**Ȩ������ */                                                                                                                         
    private String authDesc;                                                                                                               
                                                                                                                                           
    /**                                                                                                                                    
     *                                                                                                                                     
     * �����������豸����                                                                                                                  
     * @author mao2080@sina.com                                                                                                            
     * @created 2017��3��22�� ����13:50:58                                                                                                 
     * @since                                                                                                                              
     * @param authId Ȩ�ޱ�ʶ                                                                                                              
     * @param authCode Ȩ�ޱ���                                                                                                            
     * @param authName Ȩ������                                                                                                            
     * @return                                                                                                                             
     */                                                                                                                                    
    private AuthCode(String authId, String authCode, String authName) {                                                                    
        this.authId = authId;                                                                                                              
        this.authCode = authCode;                                                                                                          
        this.authName = authName;                                                                                                          
    }                                                                                                                                      
                                                                                                                                           
    /**                                                                                                                                    
     *                                                                                                                                     
     * �����������豸����                                                                                                                  
     * @author mao2080@sina.com                                                                                                            
     * @created 2017��3��22�� ����13:50:58                                                                                                 
     * @since                                                                                                                              
     * @param authId Ȩ�ޱ�ʶ                                                                                                              
     * @param authCode Ȩ�ޱ���                                                                                                            
     * @param authName Ȩ������                                                                                                            
     * @param authDesc Ȩ������                                                                                                            
     * @return                                                                                                                             
     */                                                                                                                                    
    private AuthCode(String authId, String authCode, String authName, String authDesc) {                                                   
        this.authId = authId;                                                                                                              
        this.authCode = authCode;                                                                                                          
        this.authName = authName;                                                                                                          
        this.authDesc = authDesc;                                                                                                          
    }                                                                                                                                      
                                                                                                                                           
    public String getAuthId() {                                                                                                            
        return authId;                                                                                                                     
    }                                                                                                                                      
                                                                                                                                           
    public void setAuthId(String authId) {                                                                                                 
        this.authId = authId;                                                                                                              
    }                                                                                                                                      
                                                                                                                                           
    public String getAuthCode() {                                                                                                          
        return authCode;                                                                                                                   
    }                                                                                                                                      
                                                                                                                                           
    public void setAuthCode(String authCode) {                                                                                             
        this.authCode = authCode;                                                                                                          
    }                                                                                                                                      
                                                                                                                                           
    public String getAuthDesc() {                                                                                                          
        return authDesc;                                                                                                                   
    }                                                                                                                                      
                                                                                                                                           
    public void setAuthDesc(String authDesc) {                                                                                             
        this.authDesc = authDesc;                                                                                                          
    }                                                                                                                                      
                                                                                                                                           
    public String getAuthName() {                                                                                                          
        return authName;                                                                                                                   
    }                                                                                                                                      
                                                                                                                                           
    public void setAuthName(String authName) {                                                                                             
        this.authName = authName;                                                                                                          
    }                                                                                                                                      
                                                                                                                                           
    @Override                                                                                                                              
    public String toString() {                                                                                                             
        return String.format("authId:%s, authCode:%s, authName:%s, authDesc:%s", this.authId, this.authCode, this.authName, this.authDesc);
    }                                                                                                                                      
                                                                                                                                           
}                                                                                                                                          

