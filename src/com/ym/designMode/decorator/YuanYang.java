package com.ym.designMode.decorator;

/**
 * ��װ�νӿڵ�ʵ����
 * @author Administrator
 *
 */
public class YuanYang implements GuoDi {
    @Override
    public float cost() {
        return 48.0f;
    }
    @Override
    public String name() {
        return "ԧ�����";
    }
}

