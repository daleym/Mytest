###投资、回款发短信中，添加加息 && 加息管理费 
1.项目分支：
	MessageSchedual   dev-pm-1089-短信加息回款

2.需求地址：  http://bug.zyxr.com/browse/PM-1089



#######################################################################

-------------------------------------------------------
					 提前结清发短信（添加加息和加息管理费）
-------------------------------------------------------
1.改动项目分支
	ProductInterface  dev-短信添加回款加息和加息管理费
	ProductApp        dev-短信添加回款加息和加息管理费
	MessageSchedual   dev-短信添加回款加息和加息管理费
	MessageApp        dev-短信添加回款加息和加息管理费
	
	如下为依赖项目（都在master分支）：
									MessageInterface
									
								
		
2.数据库改动：
	update message.t_sms_template set create_time = NOW(),content = '尊敬的用户，您好！您投资的${projectNameAndNumber}$第${refundTimes}$期已于${createTime}$提前结清，当期回款利息${repayInterestWithoutExtra}$元,回款加息${repayAddInterest}$元，应回款本金合计${refundInvestMoney}$元，谢谢，如有疑问，请致电客服热线：400-658-9898'
	WHERE type = 'refundInAdvanceToInvestor';
	
	
	
################################################################################

-----------------中业金服-------------
1.需求地址			http://bug.zyxr.com/browse/PM-957
								http://bug.zyxr.com/browse/ZYXRNEW-1923

2.项目分支：
	dev-ym-中业金服短信      MessageInterface
	dev-ym-中业金服短信      MessageApp
	dev-ym-中业金服短信      UserWeb
	dev-ym-中业金服短信      MobileWeb
	
3.注意点
	a.本地测试发短信，需切换wsdl地址：http://sdk999in.eucp.b2m.cn:8080/sdk/SDKService?wsdl  （避开IP黑名单限制）
	b.PC、WAP端，改动场景：忘记密码、注册、注册成功； APP端，改动场景：登录、忘记密码、修改密码、注册
	c.注册成功发短信不会影响到 回款等发短信逻辑（请确认此用例点，都是监听Mq，发短信）
	
4.中业金服门户地址： http://jf.zfax.com/index.html	
	
	
------------------------------	
	
	
	
	

3.需求地址：PM-1091