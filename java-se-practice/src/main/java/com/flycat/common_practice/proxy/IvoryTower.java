package com.flycat.common_practice.proxy;

public class IvoryTower implements WizardTower {
    @Override
    public void enter(Wizard wizard) {
        System.out.println(wizard.getName()+" entered .");
    }
}
