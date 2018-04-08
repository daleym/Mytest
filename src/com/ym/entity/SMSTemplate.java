package com.ym.entity;

import java.util.Date;


/**
 * 短信模板�?
 * @author Administrator
 *
 */
public class SMSTemplate {

	/**
	 * @see com.zyxr.mobile.message.sms.data.SmsTemplateContants.typeAttrName
	 */
	public String type;//类型，register注册，updatepassword修改密码，resetpassword重置密码，withdraw提现
	
	public String content;//模板
	
	/**
	 * @see com.zyxr.mobile.message.sms.data.SmsTemplateContants.statusAttrName
	 */
	public String status;//状�??0正常 1不用
	
	public Date createTime;//创建时间
	
	public Date modifyTime;//�?后修改时�?
	
	public String creator;//创建�?
	
	public String modifier;//修改�?
	
	public String typeName;//类型名称
	
	
	
	public SMSTemplate(String type, String content, String status, Date createTime, Date modifyTime, String creator,
			String modifier,String typeName) {
		super();
		this.type = type;
		this.content = content;
		this.status = status;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.creator = creator;
		this.modifier = modifier;
		this.typeName = typeName;
	}

	public SMSTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SMSTemplate [type=" + type + ", content=" + content + ", status=" + status + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", creator=" + creator + ", modifier=" + modifier
				+ ", typeName=" + typeName + "]";
	}

	

}
