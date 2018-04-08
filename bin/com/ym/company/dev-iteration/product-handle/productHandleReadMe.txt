###2017-08-17-修改中业智选发标费率

SELECT
	annual_per_month,
	t.*
FROM
	asset.t_plan_base t
WHERE
	1 = 1
AND business_name = '中业智选B';

UPDATE asset.t_plan_base t
SET t.annual_per_month = '["900","900","900","950","990","1070","1110","1145","1195","1235","1265","1310","1330","1350","1370","1390","1410","1430"]',
 update_time = now()
WHERE
	business_name = '中业智选B';
	
	
###################################################################################################	

-------------生产短信未收到问题-------------
http://bug.zyxr.com/browse/PM-977
----------------------------------	

#####################################################################################################

------------------------------------------------------
修复生产问题      首页定期理财详情页注册地址显示问题
-------------------------------------------------------
1.改动服务端项目
	dev-ym-修复首页定期理财详情页注册地址显示问题     AssetWeb
	
	
####################################################################################################

###至少持有可转天数（用于发布标的）
holdLimitDay2=9999
zk路径：/AppConfig/ZYXR/Common/YunWei/debtconfig

prj-lt-发标初始化持有天数       AdminZookeeperWeb 
查看入口：后台运营系统/产品管理/散标管理/未发布散标列表---发布（按钮）	

#########################################################################################################
dev-ym-中业智选发标期号重复修复     AssetAdminWeb
起因：若用户A在月月兴发标页面发标前，已有一个至少一个用户停留在月月兴发标页面，那么就会有得到重复的期号。此时后端未针对月月兴的标类型做期号重复检验，导致了有重复期号的标生成！！！
解决方案： 发标时，在服务端校验期号重复时，加上月月兴类型的期号，即可！
注意：当并发发标时，很大可能会出现期号重复。因为检查期号发生在期号入库之前了！！！（加并发控制，即可解决该状况！！！）

########################企业开户-影响提现 && 存储真实姓名超常问题####################################################################################
dev-fix-开户   TrusteeInterface
dev-fix-开户   TrusteeApp 

“企业开户-影响提现”：
背景：企业开户时,法人姓名和企业名称推送给富友时,值有误。当用户提现时,富友和真实银行交易时,校验法人姓名和企业名称等关键信息不通过,故导致提现失败！！！
解决：企业开户时,传递正确的值,即可！！！

”存储真实姓名超长问题“：
背景: 企业开户时，trustee.t_trustee_card_order_XXX分表（卡订单表）初始化存储real_name(真实姓名)时，存储的企业名称，太长导致数据库级异常。
解决：改为存储法人名称（长度偏小），不会轻易导致数据存储异常。
风险：目前数据库中real_name存储长度为10个字符-varchar（一个汉子对应几个字符？），若法人名称出现复杂姓氏导致超长，那么数据库也会发生存储异常，希望改变数据库存储长度！！！

#############################################################################################################

需求：  PM-1358
背景：  协助运营修改中业智选发标配置中，"中业智选A"标配置信息的锁定期，由30天变更为38天。从而达到国庆节缓解退出资金的压力！！！
方案：执行如下脚本即可
select * from asset.t_plan_base WHERE 1=1
and business_name  = '中业智选A'
and lock_day=30;

update asset.t_plan_base set lock_day = 38 ,update_time=NOW() WHERE 1=1
and business_name='中业智选A' 
and lock_day=30;


########################################################################
需求： PM-1436
背景： 在后台管理系统进行企业开户时，企业银行卡号才9位，不符合前端银行卡号校验规则， 导致不能开户！
方案： 校验规则变更为 数字 + 1~30位即可 （前端和后端）,对企业开户生效,个人开户保持16~20位。
     a.身份证、姓名校验：     个人开户（UserApp、TrusteeApp） 、企业开户（TrusteeApp）     ---身份证：15或18位          !!!!!!!!!!!!!!!!!!!
	     							                                     ---姓名    :10个字符内！！！
	 b.银行卡格式校验：         个人开户（UserApp、TrusteeApp）                                                         ---银行卡：16~20位
	 				       企业开户（TrusteeApp）                                                                              ---银行卡：1~30位
	 				       
#########################################################################
需求：修复数据
背景：开户发送报文到富友，并成功开户，响应报文未接收到，导致掉单，从而后续确认订单（落表等）操作未完成，需人工补数据；或做补单机制！！！
方案：脚本直接修复数据
风险：本地IDApp生成的流水号（如acc_id），以后可能会重复！！！
注意：银行卡需加密存储在DB中!!!
No1张学成:
select * from account.t_user_account_34 where acc_id = 20171013000000134;
insert into account.t_user_account_34(acc_id, uid, user_name, type, state, parent, update_time, create_time) 
values(20171013000000134,245345685103454034,'张学成',2,0,0,NOW(),NOW());

select * from account.t_user_account_flow_34 where flow_id = 20171013000000234;
insert into account.t_user_account_flow_34 (flow_id, acc_id, uid, operation,is_show, trans_id, remark, bus_type, type, create_time)
values(20171013000000234,20171013000000134,245345685103454034,7,1,267007,'create account',7,2,now());

select * from trustee.t_trustee_card_order_034 where user_id=245345685103454034 and channel=1;
update trustee.t_trustee_card_order_034 set  card_no ='B66A058BE812F18DB272A8AC8AC39313582C3D0091865C8A3EEF308DB5BC71EF' ,state = 1 ,card_property=1,hr_veryfied_time=NOW(),update_time=NOW() where user_id=245345685103454034 and channel=1;


#注意：以上三组sql,都附上了查询语句。其中，第1、2组sql,若查询无记录，则执行插入操作；第三组sql，查询出仅一条记录，则执行更新操作！

No2周锡英:
   	select * from account.t_user_account_31 where acc_id = 20171012000000031;
    insert into account.t_user_account_31(acc_id, uid, user_name, type, state, parent, update_time, create_time) 
    values(20171012000000031,245345136003183131,'周锡英',2,0,0,NOW(),NOW());

    select * from account.t_user_account_flow_31 where flow_id = 20171012000000131;
    insert into account.t_user_account_flow_31 (flow_id, acc_id, uid, operation,is_show, trans_id, remark, bus_type, type, create_time)
    values(20171012000000131,20171012000000031,245345136003183131,7,1,263268,'create account',7,2,now());
 
    select * from trustee.t_trustee_card_order_031 where user_id=245345136003183131 and channel=1;
    update trustee.t_trustee_card_order_031 set card_property=1,hr_veryfied_time=NOW(),update_time=NOW() where user_id=245345136003183131 and channel=1;
    #注意：以上三组sql,都附上了查询语句。其中，第1、2组sql,若查询无记录，则执行插入操作；第三组sql，查询有记录，则执行更新操作！
    select * from trustee.t_trustee_card_order_031 where user_id=245345136003183131 and channel=1;
    update trustee.t_trustee_card_order_031 set state = 1 ,update_time=NOW() where user_id=245345136003183131 and channel=1;
          注：请先执行第一条，若查询出有一条记录，则执行第二条更新操作！
    select * from trustee.t_trustee_card_order_031 where user_id=245345136003183131 and channel=1;
	update trustee.t_trustee_card_order_031 set card_bank = '0104' ,card_province = 330,card_city = 3320,card_no ='7CD8D5E499D796AE326BC3B28E24EBC4023FC8CA6ED616AB87E6A26766832825' ,update_time=NOW() where user_id=245345136003183131 and channel=1;
	注意：查询出，只有一条时，则执行更新操作	     							                

#########################################################################
需求：http://bug.zyxr.com/browse/PM-1980
背景：在优惠券派发管理(运营管理/卡券管理)中,点击优惠券详情,发现显示项中,优惠券面值、投资金额限制和创建该优惠券时的不一致。
方案：通过查询日志，发现编辑优惠券信息的操作发生过两次,纯属多人操作（或一人多次操作）,无需改动！
风险：在优惠券配置(运营管理/卡券管理)中，点击禁用/启用按钮,会更新当前全部优惠券信息！若前一刻，另一人编辑该优惠券信息成功,那么此结果会被覆盖掉！！！

#############################未开户用户-点击提现报错问题############################################
需求：http://bug.zyxr.com/browse/PM-2028
背景：由于VIP功能在改造查询提现信息时，未考虑卡订单表为空的情况，故未开户的用户,在点击首页提现时，报“系统异常”。
方案：由前端改造，未开户的用户，在首页点击充值/提现时，直接强制跳转到开户页面即可！！！


	