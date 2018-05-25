-----------------------------
				月月兴
-----------------------------    start
1.annotation: 理财计划管理/理财计划配置 && 发布理财计划			

2.需求地址：  http://bug.zyxr.com/browse/PM-779	

3.项目分支：
	dev-ym-月月兴                  AssetAdminWeb     -> prj-月月升和投资流程优化      保证prj-月月兴上  =<  个人分支  >=  综合分支
	dev-ym-月月兴                  AssetInterface    -> prj-月月升和投资流程优化      保证prj-月月兴上  =<  个人分支  >=  综合分支
	dev-ym-月月兴                  AssetApp          -> prj-月月升和投资流程优化      保证prj-月月兴上  =<  个人分支  >=  综合分支
	
	dev-ym-月月兴                  ProductApp				 -> prj-月月升和投资流程优化      保证prj-月月兴上  =<  个人分支  >=  综合分支
	dev-ym-月月兴                  ProductInterface  -> prj-月月升和投资流程优化      保证prj-月月兴上  =<  个人分支  >=  综合分支
	
	dev-ym-月月兴									 MessageInterface  -> prj-月月兴		保证个人分支  <= pri-月月兴
	dev-ym-月月兴									 MessageApp        -> prj-月月兴		保证个人分支  <= pri-月月兴
	dev-ym-月月兴									 MessageSchedual   -> prj-月月兴		保证个人分支  <= pri-月月兴
	
4.注意点：
	a.月月兴配置页面，没有期限类型（默认值：月）
	b.asset_type在t_plan_base、asset.t_asset、product.t_asset三表中编号不一致，但是含义是一致的！！！
		分别是：asset.t_plan_base、asset.t_asset(7-兴融计划、8-月月兴)，product.t_asset(1-兴融计划、4-月月兴)

5.数据库改动
		#理财计划模板
	ALTER TABLE asset.`t_plan_base`
	ADD COLUMN `asset_type`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '标的类型,7-理财计划,8-月月兴' ;
	ALTER TABLE asset.`t_plan_base`
	ADD COLUMN `single_tender`  bigint(20) NOT NULL DEFAULT 0 COMMENT '单笔限投金额' AFTER `asset_type`;
	ALTER TABLE asset.`t_asset`
	ADD COLUMN `single_tender`  bigint(20) NOT NULL DEFAULT 0 COMMENT '单笔限投金额' ;
	ALTER TABLE product.t_assets
	ADD COLUMN `single_tender`  bigint(20) NOT NULL DEFAULT 0 COMMENT '单笔限投金额' ;

	#【短信模板表 】增加数据
	INSERT INTO `message`.`t_sms_template` (`type`, `content`, `status`, `create_time`, `modify_time`, `creator`, `modifier`, `type_name`) VALUES ('yueYueXingPayOffFinished', '【中业兴融】尊敬的客户，您好！您于【${createTime}$】加入的【${projectNumberAndProject}$】项目已成功回款，回款总额【${actualTotalAmount}$】元(本金【${actualPrincipal}$】元,利息【${actualInterest}$】元,加息【${actualAddInterest}$】元)，实际到账【${actualToalAmountToAccount}$】元。如有疑问请致电客服热线：400-658-9898。立即下载中业兴融APP，http://t.cn/RxFnblV随时掌握最新动态！', '0', NOW(), NOW(), 'system', '', '（月月兴）正常回款 -通知投资人');
	INSERT INTO `message`.`t_sms_template` (`type`, `content`, `status`, `create_time`, `modify_time`, `creator`, `modifier`, `type_name`) VALUES ('yueYueXingEarlyPayOffFinished', '【中业兴融】亲爱的用户，您已于【${createTime}$】成功退出【${projectNameAndNumber}$】中业智选项目。实际到账金额【${actualTotalAmount}$】元（本金【${actualPrinciple}$】元，利息【${actualInterest}$】元，加息【${actualAddInterest}$】元，提前退出手续费【${actualPlatFormFee}$】元）。如有疑问请致电客服热线：400-658-9898。', '0', NOW(), NOW(), 'system', '', '月月兴-提前退出回款-通知投资人');
	INSERT INTO `message`.`t_sms_template` (`type`, `content`, `status`, `create_time`, `modify_time`, `creator`, `modifier`, `type_name`) VALUES ('investFullBidInformInvestorByYueYueXing', '【中业兴融】尊敬的客户，您好！您于【${createTime}$】已经成功加入【${projectNameAndNumber}$】，项目已满标，次日开始计息。项目期限为【${financialRegularProjectPeriod}$】投标金额：【${investMoney}$】元如有任何问题，欢迎来电咨询：400-658-9898立即下载中业兴融APP，http://t.cn/RxFnblV随时掌握最新动态！', '0', NOW(), NOW(), 'system', '', '（月月兴）投资人投资项目满标放款');

	######删除上述字段######
	alter table asset.t_plan_base
	drop COLUMN asset_type,
	drop COLUMN single_tender;
	ALTER table asset.t_asset
	drop COLUMN single_tender;
	alter table product.t_assets
	drop COLUMN  single_tender;

	#删除数据
	delete from message.t_sms_template where type in('yueYueXingPayOffFinished','yueYueXingEarlyPayOffFinished','investFullBidInformInvestorByYueYueXing');
	




6.zk改动
	a.结点路径： /AppConfig/ZYXR/Common/YunWei/PlanConfig
	b.结点值：   ##月月兴退出费用(万分之x)
								 yyxExitFee=0
	c.功能：    后台运营系统/产品管理/理财计划管理/通用设置（配置提前退出费用... ...）



7.待确认点：
	~~~兴融计划配置时，业务类型名称是否过滤！！！
	~~~注意金额！！！
	~~~合项目分支！！！
	~~~加单笔限投金额！！！
	补充接口文档到wiki
	~~~月月兴对兴融计划发标的影响确认！！！
		
------------------------------------------------		
-------------月月兴--------------------------------          end		
------------------------------------------------	