package com.ym.designMode.decorator;

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
        return super.name()+"+ÂéÀ±Å£Èâ";
    }
}

