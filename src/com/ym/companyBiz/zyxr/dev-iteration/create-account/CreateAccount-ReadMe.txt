------------------------------
				存管重构---开户  start
------------------------------
1.需求地址： TM-11

2.项目分支
	TrusteeInterface  dev-ym-存管重构(prj-存管重构-1.0)
	TrusteeApp        dev-ym-存管重构(prj-存管重构-1.0)
	UserApp           prj-存管重构-1.0
	
3.测试请求地址
	###http://192.168.9.156:8080/fuyou/jzh/（签名挡板）
		 http://192.168.9.108:8080/fuyou/jzh/
	###最新测试地址
	http://cg.zjcgxt.com/jzh/  测试环境的
	https://hrcg1.shrbank.com/ 线上的
	
4.操作入口
	a.企业开户：后台管理系统 / 合作机构管理 / 添加合作机构      addCooperation
					   / 会员管理     / 企业用户管理      addEnterpriseAccount
	b.个人开户：PC端注册->自动提示开户
	
5.注意点
	a.企业开户有两个入口的原因：区分普通企业用户，进件方（合作机构）也要进行企业开户，则新增了一个企业开户入口！
	b.上线后 --- 删除个人分支
	c.开户请求富友，做了挡板（默认返回成功 && sign签名），导致签名失败！
	
	d.开户行地区代码    city_id           市下拉框          必填               静态读取
	     开户行行别            parent_bank_id    银行名称         必填                动态读取
	     开户行支行名称    bank_nm                     留空！！！ 	     
	e.身份证已绑定在某用户名下校验：企业开户时（UserApp）  
	     身份证、银行卡格式校验：     个人开户（UserApp）---身份证：15或18位
	     							      ---银行卡：16~20位 
	     							      ---姓名    :10个字符内！！！

6.资源
	a.已开户的用户 ：17053000269、17053000260    ,   默认登录密码：zyxr132456(仅测试环境有效)
	b.平台用户UID（虚户账户）： 201607190000004045
	c.测试数据：
		---银行卡：6217002710004564177（建设银行-湖北-鄂州）
		---身份证：371721198205104032
	
	d.富友测试平台地址：https://jzh-test.fuiou.com/jzh/    jzh09 /  888888
	e.挡板切换配置： 
		---/AppConfig/ZYXR/Common/YunWei/fySignSwitch   （true则验签）	
		---/AppConfig/ZYXR/TrusteeApp/YunWei/fyUrl   http://192.168.9.108:8080/fuyou/jzh/
		---/AppConfig/ZYXR/TrusteeSchedule/YunWei/fyUrl   http://192.168.9.108:8080/fuyou/jzh/
		---确认tomcat服务器存在 ：fuyou.war  
----------------------------------------
				存管重构---开户  end	
----------------------------------------	