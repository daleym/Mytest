package com.ym.generics.biz;


public class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory implements com.ym.generics.biz.Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter {
    public static class Factory implements com.ym.generics.biz.Factory<AirFilter> {
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class Belt extends Part {}
class FanBelt extends Belt {
    public static class Factory implements com.ym.generics.biz.Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
class GeneratorBelt extends Belt {
    public static class Factory implements com.ym.generics.biz.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}
