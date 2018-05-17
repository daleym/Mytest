package com.ym.designMode.decorator;

/**
 * 抽象装饰者 的 子类
 * @author Administrator
 *
 */
public class MaoDu extends PeiCai {

    public MaoDu(GuoDi guodi) {
        super(guodi);
    }
    @Override
    public float cost() {
        return super.cost()+30f;
    }
    @Override
    public String name() {
        return super.name()+"+大刀毛肚";
    }
}

