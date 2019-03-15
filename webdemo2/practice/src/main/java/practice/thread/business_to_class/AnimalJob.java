package practice.thread.business_to_class;

/**
 * @Author Gramo
 * @Time 2019/3/15
 * @DES
 */
public abstract class AnimalJob {
    private String name;

    public AnimalJob(){
        JobManager.getInstance().putJonb(this.getClass().getName(),this);
    }
    public abstract String execute();
}
