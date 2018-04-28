1.需求地址： http://bug.zyxr.com/browse/TM-35

2.服务端改动（dev-ym-存管重构-资金交互）：
	a.TrusteeInterface     prj-存管重构-1.3
	b.TrusteeApp		   prj-存管重构-1.3	
	c.TrusteeSchedule      prj-存管重构-1.3

3.待做：

 
4.zk配置
	a./AppConfig/ZYXR/TrusteeSchedule/YunWei/amount/queryRetryInterval  -15
	b./AppConfig/ZYXR/TrusteeSchedule/YunWei/amount/executeFrequency    0/50 * * * * ?
																																	    0 0/10 * * * ? 
	
5.注意
	a.
	b.与富有交互时，订单ID不能重复；请求地址不能写错
	c.uid和toUid的区别：在转账-收取个人资金、转账-派发个人资金、转账预冻结（3个场景）时，uid代表个人，toUid代表平台；
											在划拨、冻结到冻结时，uid代表出账人，toUid代表入账人。
											在解冻、冻结时，uid代表个人，toUid代表0。
  
  d.校验金额
  	－－－派送资金时，检查平台可用余额＜要派送资金　　
  	－－－平台收取资金时，检查个人可用余额＜要收取资金
  	－－－转账预冻结时，检查平台可用余额＜要转账预冻结金额
  	
  	－－－冻结到冻结，检查出账人冻结余额＜冻结金额
  	－－－解冻，检查个人冻结余额＜解冻金额
  	－－－冻结，检查个人可用余额 < 冻结金额
  	------划拨（个人余额之间），检查出账人可用余额 < 划拨金额
  	
  e.校验是否开户
  	---在请求富友前，校验个人用户是否开户。若没有，则直接终止流程。（避免不必要的报文请求）
  
  f.校验出账人和入账人是否是同一个
  	---若是，则立即终止！
  
  g.兴融计划/中业智选测试流程：
  	---资产管理/借款录入
  	---资产管理/借款初审
  	---资产管理/借款终审
  	
  	---资产管理/未分配债券池->分配债权->计划池置顶
  	---产品管理/理财计划管理/发布理财计划
  	---投资人首页投资理财计划->满标
  	
  	---产品管理/理财计划管理/手工匹配（与新资产）
  	---改动product.t_asset的结束时间为当天
  	---执行定时任务：
  		      /AppConfig/ZYXR/ProductSchedule/YunYing/Schedule/planCheckExpireOutTask
  		      /AppConfig/ZYXR/ProductSchedule/YunYing/Schedule/planCheckSettlementIngTask
  	
  	---产品管理/理财计划管理/手工反匹配（退出资产）
  	---执行定时任务（重复上述步骤）
  	---
	
6.上线准备：
	a.zk配置
	b.服务端jar包：TrusteeSchedule-0.0.1-SNAPSHOT.jar  、 TrusteeApp-0.0.1-SNAPSHOT.jar
	c.
	
7.资源：
	a.
	
	