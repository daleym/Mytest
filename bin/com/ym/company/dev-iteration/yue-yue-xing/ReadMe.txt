-----------------------------
				������
-----------------------------    start
1.annotation: ��Ƽƻ�����/��Ƽƻ����� && ������Ƽƻ�			

2.�����ַ��  http://bug.zyxr.com/browse/PM-779	

3.��Ŀ��֧��
	dev-ym-������                  AssetAdminWeb     -> prj-��������Ͷ�������Ż�      ��֤prj-��������  =<  ���˷�֧  >=  �ۺϷ�֧
	dev-ym-������                  AssetInterface    -> prj-��������Ͷ�������Ż�      ��֤prj-��������  =<  ���˷�֧  >=  �ۺϷ�֧
	dev-ym-������                  AssetApp          -> prj-��������Ͷ�������Ż�      ��֤prj-��������  =<  ���˷�֧  >=  �ۺϷ�֧
	
	dev-ym-������                  ProductApp				 -> prj-��������Ͷ�������Ż�      ��֤prj-��������  =<  ���˷�֧  >=  �ۺϷ�֧
	dev-ym-������                  ProductInterface  -> prj-��������Ͷ�������Ż�      ��֤prj-��������  =<  ���˷�֧  >=  �ۺϷ�֧
	
	dev-ym-������									 MessageInterface  -> prj-������		��֤���˷�֧  <= pri-������
	dev-ym-������									 MessageApp        -> prj-������		��֤���˷�֧  <= pri-������
	dev-ym-������									 MessageSchedual   -> prj-������		��֤���˷�֧  <= pri-������
	
4.ע��㣺
	a.����������ҳ�棬û���������ͣ�Ĭ��ֵ���£�
	b.asset_type��t_plan_base��asset.t_asset��product.t_asset�����б�Ų�һ�£����Ǻ�����һ�µģ�����
		�ֱ��ǣ�asset.t_plan_base��asset.t_asset(7-���ڼƻ���8-������)��product.t_asset(1-���ڼƻ���4-������)

5.���ݿ�Ķ�
		#��Ƽƻ�ģ��
	ALTER TABLE asset.`t_plan_base`
	ADD COLUMN `asset_type`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '�������,7-��Ƽƻ�,8-������' ;
	ALTER TABLE asset.`t_plan_base`
	ADD COLUMN `single_tender`  bigint(20) NOT NULL DEFAULT 0 COMMENT '������Ͷ���' AFTER `asset_type`;
	ALTER TABLE asset.`t_asset`
	ADD COLUMN `single_tender`  bigint(20) NOT NULL DEFAULT 0 COMMENT '������Ͷ���' ;
	ALTER TABLE product.t_assets
	ADD COLUMN `single_tender`  bigint(20) NOT NULL DEFAULT 0 COMMENT '������Ͷ���' ;

	#������ģ��� ����������
	INSERT INTO `message`.`t_sms_template` (`type`, `content`, `status`, `create_time`, `modify_time`, `creator`, `modifier`, `type_name`) VALUES ('yueYueXingPayOffFinished', '����ҵ���ڡ��𾴵Ŀͻ������ã����ڡ�${createTime}$������ġ�${projectNumberAndProject}$����Ŀ�ѳɹ��ؿ�ؿ��ܶ${actualTotalAmount}$��Ԫ(����${actualPrincipal}$��Ԫ,��Ϣ��${actualInterest}$��Ԫ,��Ϣ��${actualAddInterest}$��Ԫ)��ʵ�ʵ��ˡ�${actualToalAmountToAccount}$��Ԫ�������������µ�ͷ����ߣ�400-658-9898������������ҵ����APP��http://t.cn/RxFnblV��ʱ�������¶�̬��', '0', NOW(), NOW(), 'system', '', '�������ˣ������ؿ� -֪ͨͶ����');
	INSERT INTO `message`.`t_sms_template` (`type`, `content`, `status`, `create_time`, `modify_time`, `creator`, `modifier`, `type_name`) VALUES ('yueYueXingEarlyPayOffFinished', '����ҵ���ڡ��װ����û��������ڡ�${createTime}$���ɹ��˳���${projectNameAndNumber}$����ҵ��ѡ��Ŀ��ʵ�ʵ��˽�${actualTotalAmount}$��Ԫ������${actualPrinciple}$��Ԫ����Ϣ��${actualInterest}$��Ԫ����Ϣ��${actualAddInterest}$��Ԫ����ǰ�˳������ѡ�${actualPlatFormFee}$��Ԫ���������������µ�ͷ����ߣ�400-658-9898��', '0', NOW(), NOW(), 'system', '', '������-��ǰ�˳��ؿ�-֪ͨͶ����');
	INSERT INTO `message`.`t_sms_template` (`type`, `content`, `status`, `create_time`, `modify_time`, `creator`, `modifier`, `type_name`) VALUES ('investFullBidInformInvestorByYueYueXing', '����ҵ���ڡ��𾴵Ŀͻ������ã����ڡ�${createTime}$���Ѿ��ɹ����롾${projectNameAndNumber}$������Ŀ�����꣬���տ�ʼ��Ϣ����Ŀ����Ϊ��${financialRegularProjectPeriod}$��Ͷ�����${investMoney}$��Ԫ�����κ����⣬��ӭ������ѯ��400-658-9898����������ҵ����APP��http://t.cn/RxFnblV��ʱ�������¶�̬��', '0', NOW(), NOW(), 'system', '', '�������ˣ�Ͷ����Ͷ����Ŀ����ſ�');

	######ɾ�������ֶ�######
	alter table asset.t_plan_base
	drop COLUMN asset_type,
	drop COLUMN single_tender;
	ALTER table asset.t_asset
	drop COLUMN single_tender;
	alter table product.t_assets
	drop COLUMN  single_tender;

	#ɾ������
	delete from message.t_sms_template where type in('yueYueXingPayOffFinished','yueYueXingEarlyPayOffFinished','investFullBidInformInvestorByYueYueXing');
	




6.zk�Ķ�
	a.���·���� /AppConfig/ZYXR/Common/YunWei/PlanConfig
	b.���ֵ��   ##�������˳�����(���֮x)
								 yyxExitFee=0
	c.���ܣ�    ��̨��Ӫϵͳ/��Ʒ����/��Ƽƻ�����/ͨ�����ã�������ǰ�˳�����... ...��



7.��ȷ�ϵ㣺
	~~~���ڼƻ�����ʱ��ҵ�����������Ƿ���ˣ�����
	~~~ע�������
	~~~����Ŀ��֧������
	~~~�ӵ�����Ͷ������
	����ӿ��ĵ���wiki
	~~~�����˶����ڼƻ������Ӱ��ȷ�ϣ�����
		
------------------------------------------------		
-------------������--------------------------------          end		
------------------------------------------------	