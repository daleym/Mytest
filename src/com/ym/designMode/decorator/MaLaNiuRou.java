package com.ym.designMode.decorator;

/**
 * 抽象装饰者的子类
 * @author Administrator
 *
 */
public class MaLaNiuRou extends PeiCai {
    public MaLaNiuRou(GuoDi guodi) {
        super(guodi);
    }
    @Override
    public float cost() {
        return super.cost()+46f;
    }
    @Override
    public String name() {
        return super.name()+"+麻辣牛肉";
    }
}

