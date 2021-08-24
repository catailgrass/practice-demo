package com.flycat.common_practice.proxy;

/**
 * 代理 将一个类的功能 交由另一个类来完成
 * 代理，最通用的形式是一个类作为其他东西的接口。 代理是由客户端调用来访问幕后真实服务对象的包装器或代理对象。
 * 使用代理可以简单地转发到真实的对象，或者可以提供额外的逻辑。 在代理中，可以提供额外的功能，
 * 例如当真实对象上的操作是资源密集型时的缓存，或者在调用真实对象的操作之前检查前提条件。
 */
public class WizardProxy implements WizardTower{
    private static int NUM_LIMIT = 3;
    private int enterNum ;
    private WizardTower tower;

    public WizardProxy(WizardTower tower) {
        this.tower = tower;
    }
    @Override
    public void enter(Wizard wizard) {
        if (enterNum < NUM_LIMIT) {
            tower.enter(wizard);
            enterNum ++;
        }else {
            System.out.println(wizard.getName()+" is not allowed.");
        }
    }

    public static void main(String[] args) {
        WizardProxy wizardProxy = new WizardProxy(new IvoryTower());
        wizardProxy.enter(new Wizard("A"));
        wizardProxy.enter(new Wizard("B"));
        wizardProxy.enter(new Wizard("C"));
        wizardProxy.enter(new Wizard("D"));
    }
}
