1.�����ַ �� http://bug.zyxr.com/browse/TM-30

2.����˸Ķ���ַ��
	dev-ym-����ع�-����   TrusteeSchedual         prj-����ع�-1.2
	dev-ym-����ع�-����   TrusteeInterface				 prj-����ع�-1.2
	dev-ym-����ع�-����   TrusteeApp              prj-����ع�-1.2
	
3.����
  ɾ����֧


4.zk�Ķ���TrusteeSchedule��
	a.��ʼ����ѯʱ������/YunWei/withDraw/queryRetryInterval  -15
	b.��ʱ����ִ��Ƶ��  ��/YunWei/withDraw/executeFrequency    0/50 * * * * ?
	
5.Ͷ���Ķ��㣺
	a.�������Ŀ
	b.zk����
	c.	
	
6.ע��㣺
	1.ͬ��֪ͨ��	"fuyou withdraw"              YunWei/fyCallbackUrl
	2.�첽֪ͨ��  "withdrawNotify orderId="	    YunWei/fyNotifyUrl
	3.��ѯ�����洢���ƣ�
		---��ֵ�ԣ�Trustee:Withdraw:��orderId��  ������Ϣ
		---��ϣ��Trustee:Withdraw:WithdrawOrderQueryRetryKey  ��orderId�� : ����������ʱ�䡿
		---����ʱ�䣺5d(��ֵ��)
		---ɾ��redis��������ϣ������ֵ�Թ��ڡ���ѯ����״̬�ɹ�/ʧ�ܡ�������״̬�ɹ�/ʧ��
	
	4.