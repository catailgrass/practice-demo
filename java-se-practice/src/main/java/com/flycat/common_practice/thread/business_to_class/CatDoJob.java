package com.flycat.common_practice.thread.business_to_class;

/**
 * @Author Gramo
 * @Time 2019/3/15
 * @DES
 */
public class CatDoJob extends AnimalJob{
    public CatDoJob() {
    }

    @Override
    public String execute() {
        return "I eat and sleep";
    }
}
