package com.flycat.common_practice.thread.business_to_class;

/**
 * @Author Gramo
 * @Time 2019/3/15
 * @DES
 */
public class DogDoJob extends AnimalJob{
    public DogDoJob() {
    }

    @Override
    public String execute() {
        return "I bike to keep stranger from me";
    }
}
