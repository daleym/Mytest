###Ͷ�ʡ��ؿ�����У���Ӽ�Ϣ && ��Ϣ����� 
1.��Ŀ��֧��
	MessageSchedual   dev-pm-1089-���ż�Ϣ�ؿ�

2.�����ַ��  http://bug.zyxr.com/browse/PM-1089



#######################################################################

-------------------------------------------------------
					 ��ǰ���巢���ţ���Ӽ�Ϣ�ͼ�Ϣ����ѣ�
-------------------------------------------------------
1.�Ķ���Ŀ��֧
	ProductInterface  dev-������ӻؿ��Ϣ�ͼ�Ϣ�����
	ProductApp        dev-������ӻؿ��Ϣ�ͼ�Ϣ�����
	MessageSchedual   dev-������ӻؿ��Ϣ�ͼ�Ϣ�����
	MessageApp        dev-������ӻؿ��Ϣ�ͼ�Ϣ�����
	
	����Ϊ������Ŀ������master��֧����
									MessageInterface
									
								
		
2.���ݿ�Ķ���
	update message.t_sms_template set create_time = NOW(),content = '�𾴵��û������ã���Ͷ�ʵ�${projectNameAndNumber}$��${refundTimes}$������${createTime}$��ǰ���壬���ڻؿ���Ϣ${repayInterestWithoutExtra}$Ԫ,�ؿ��Ϣ${repayAddInterest}$Ԫ��Ӧ�ؿ��ϼ�${refundInvestMoney}$Ԫ��лл���������ʣ����µ�ͷ����ߣ�400-658-9898'
	WHERE type = 'refundInAdvanceToInvestor';
	
	
	
################################################################################

-----------------��ҵ���-------------
1.�����ַ			http://bug.zyxr.com/browse/PM-957
								http://bug.zyxr.com/browse/ZYXRNEW-1923

2.��Ŀ��֧��
	dev-ym-��ҵ�������      MessageInterface
	dev-ym-��ҵ�������      MessageApp
	dev-ym-��ҵ�������      UserWeb
	dev-ym-��ҵ�������      MobileWeb
	
3.ע���
	a.���ز��Է����ţ����л�wsdl��ַ��http://sdk999in.eucp.b2m.cn:8080/sdk/SDKService?wsdl  ���ܿ�IP���������ƣ�
	b.PC��WAP�ˣ��Ķ��������������롢ע�ᡢע��ɹ��� APP�ˣ��Ķ���������¼���������롢�޸����롢ע��
	c.ע��ɹ������Ų���Ӱ�쵽 �ؿ�ȷ������߼�����ȷ�ϴ������㣬���Ǽ���Mq�������ţ�
	
4.��ҵ����Ż���ַ�� http://jf.zfax.com/index.html	
	
	
------------------------------	
	
	
	
	

3.�����ַ��PM-1091