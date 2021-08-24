package com.flycat.design_pattern.create_pattern;

/**
 * 是为了将构建复杂对象的过程和它的部件解耦.注意: 是解耦过程和部件.
 * 因为一个复杂的对象,不但有很多大量组成部分,如汽车,有很多部件:车轮方向盘
 * 发动机还有各种小零件等等,部件很多,但远不止这些,如何将这些部件装配成一辆汽车,
 * 这个装配过程也很复杂(需要很好的组装技术),
 * Builder模式就是为了将部件和组装过程分开.
 */
public class BuilderPattern {
    /**
     * 上层 抽象 Builder
     */
    private interface Builder{
        void buildPartA();

        void buildPartB();

        void buildPartC();

        Object getResult();
    }

    /**
     * 分离组装过程 和 组件
     */
    public static class CarBuilder implements Builder{
        private String result = "";
        @Override
        public void buildPartA() {
            result += "A|";
        }

        @Override
        public void buildPartB() {
            result += "B|";
        }

        @Override
        public void buildPartC() {
            result += "C";
        }

        @Override
        public Object getResult() {
            return result;
        }
    }
    public static class Director {

        private Builder builder;

        public Director(Builder builder){
            this.builder = builder;
        }
        public void construct() {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
        }
    }

    public static void main(String[] args) {
        Builder builder = new CarBuilder();
        Director director = new Director(builder);
        director.construct();
        System.out.println(builder.getResult());
    }
}