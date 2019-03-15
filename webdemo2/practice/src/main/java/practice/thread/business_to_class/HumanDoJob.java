package practice.thread.business_to_class;

/**
 * @Author Gramo
 * @Time 2019/3/15
 * @DES
 */
public class HumanDoJob extends AnimalJob {
    public HumanDoJob() {
    }

    @Override
    public String execute() {
        return "I thinking to change the world";
    }
}
