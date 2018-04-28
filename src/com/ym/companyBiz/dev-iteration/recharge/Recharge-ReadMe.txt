1.需求地址：http://bug.zyxr.com/browse/TM-17

2.项目分支
	a.TrustInterface    dev-ym-存管重构-充值
	b.TrustApp          dev-ym-存管重构-充值
	c.MobileWeb         dev-ym-存管重构-充值          prj-存管重构-1.1            [发短信]
	
	d.BusinessOpenWeb   dev-ym-存管重构-充值          prj-存管重构-1.1            [委托充值-提前签约]
	e.TrusteeWeb        dev-ym-存管重构-充值          prj-存管重构-1.1（已有）               [委托充值-提前签约]
	f.
	
3.待做：
	a.
	d.只是组装，可以抛异常么
	c.委托充值-提前签约-接收富友通知模拟
	
	
	
4.注意点
	a.了解负责的整个流程!!!
	b.注释写的见名之意！
	c.组装委托充值-提前签约报文接口->页面请求富友进行签约->---> 富友异步回调服务端接口->（确认签约结果）跳转到平台页面（callBack地址）
	
	d.短信充值默认验证码：0000
	e.短信充值：不区分PC端或app端，但是暴露到外层的入口，目前仅有MobileWeb项目-【app端短信充值】(发短信验证码和短信充值，都不涉及同步回调和异步回调！！！)
			  ---步骤：输入金额，下单  ->  发送验证码  ->  提交充值-提交订单
	f.PC网银充值步骤：组装报文->页面跳转至富友--->同步回调（跳转至页面）--->异步回调（确认订单）
	g.
	
5.测试资源地址：
	a.富友最新测试地址 : http://cg.zjcgxt.com/jzh/
	b.app测试包（android）地址 ： \\192.168.150.210\公司共享\APP\测试版\Android\4.1.0\20170801
	c.
	
	d.app、wap、pc充值方式分别为：
	  ---我方快捷充值原生页面 | 富友H5页面-短信充值（通过zk控制两个页面的切换 : /AppConfig/ZYXR/Common/YunWei/FastRecharge/isSupportFastRecharge）
	  ---富友h5页面-短信充值
	  ---网银充值
																
	
6.不足
	a.转测需要的材料 ，放到wiki中
	b.每天早上查看个人分支，并保持在prj分支同级或之上
	c.单元测试->dubbo层测试->controller层测试->App端 or PC端 or Wap端
	
	d.排除个人原因后，再寻求协助（比如没有fetch或refresh）
	e.确定自测后，再寻求协助！
	
7.组装充值方式:
	a.委托充值-提前签约   page_notify_url     fy-notify-URL
	b.app网银充值
	c.
	
8.直接与富有交互：
	a.委托充值
