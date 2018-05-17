package com.ym.designMode.decorator;

/**
 * 被装饰接口的实现类
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
        return "鸳鸯锅底";
    }
}

