package com.ym.tryCatchException;

/**
 * @description �쳣����
 * 				���쳣�������Ҳ��ٴ��׳��µ��쳣����������̹��ܽ�����Ӱ��
 * 				eg:������ӡ17�д��룬��22�л����ִ�У����׳��µ��쳣����18�У���22�д��벻��õ�ִ�У�����
 * @description ռλ����ʹ�� %% ת��Ϊ %
 * @author ming.yang
 */
public class TestDemoAnother {
		
	public static void main(String[] args) throws Exception {
		try{
			System.out.println(TestDemoAnother.class.getSimpleName());
			
			throw new Exception("��ָ��");
		}catch(Exception e){
			System.out.println(String.format("e.getMessage()��%s��", e.getMessage()));
			e.printStackTrace();
//			throw new Exception(String.format("�����쳣���������쳣Ϊ����%s��", e.getMessage()));
		}finally{
			System.out.println("�쳣����ʱ��finally�� ������ִ����...");
		}
		String tmp = "��test-���0002���ȶϢ6����9%��-��2���ڡ�4���ڻؿ���%sԪ��";
		tmp        = tmp.replaceAll("%", "%%");
		tmp       = tmp.replaceAll("%%s", "%s");
		
		System.out.println(String.format("tmp:%s" , tmp ));
		System.out.println(String.format(tmp ,33586));
		System.out.println(String.format("��test-���0002���ȶϢ6����9%%��-��2���ڡ�4���ڻؿ���%sԪ��" , 1000));
	}
	
}
