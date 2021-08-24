package com.flycat.design_pattern.create_pattern;

/**
 * 创建sample实例时所做的初始化工作不是象赋值这样简单的事，
 * 可能是很长一段代码，如果也写入构造函数中，那你的代码很难看了（就需要Refactor重整）。
 * 为什么说代码很难看，初学者可能没有这种感觉，我们分析如下，
 * 初始化工作如果是很长一段代码，说明要做的工作很多，将很多工作装入一个方法中，
 * 相当于将很多鸡蛋放在一个篮子里，是很危险的，这也是有背于Java面向对象的原则，
 * 面向对象的封装(Encapsulation)和分派(Delegation)告诉我们，尽量将长的代码分派“切割”成每段，
 * 将每段再“封装”起来(减少段和段之间偶合联系性)，这样，就会将风险分散，
 * 以后如果需要修改，只要更改每段，不会再发生牵一动百的事情。
 */
public class FactoryPattern {

    private static Factory factory = new SimpleFactory();

    public static Factory getFactoryInstance(){
        return factory;
    }
    /**
     * 需要建造的 实体
     */
    private interface TargetObject{
        public abstract String say();
    }
    public static class TargetObjectA implements TargetObject{

        @Override
        public String say() {
            System.out.println(" I am A");
            return " I am A";
        }
    }

    public static class TargetObjectB implements TargetObject{

        @Override
        public String say() {
            System.out.println(" I am B");
            return " I am B";
        }
    }
    /**
     * 将上层工厂抽象出来
     * 避免 多个工厂的重复
     */
    public static abstract class Factory{

        public abstract TargetObject creatorA();

        public abstract TargetObject creatorB();

    }

    public static class SimpleFactory extends Factory
    {
        @Override
        public TargetObject creatorA() {
            return new TargetObjectA();
        }

        @Override
        public TargetObject creatorB() {
            return new TargetObjectB();
        }
    }

    public static void main(String[] args) {
        // 单例模式 保持工厂类只有一个实例
        Factory factory = FactoryPattern.getFactoryInstance();
        // 对象的创建 与对象的内容解耦
        TargetObject targetObjectA = factory.creatorA();
        targetObjectA.say();

        TargetObject targetObjectB = factory.creatorB();
        targetObjectB.say();
    }
}
