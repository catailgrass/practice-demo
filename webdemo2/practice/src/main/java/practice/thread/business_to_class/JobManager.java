package practice.thread.business_to_class;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author Gramo
 * @Time 2019/3/15
 * @DES
 */
public class JobManager {
    private static JobManager ourInstance = new JobManager();
    private Map<String, AnimalJob> map = new ConcurrentHashMap<>();
    public static JobManager getInstance() {
        return ourInstance;
    }

    public void putJonb(String className,AnimalJob animalJob) {
        map.put(className, animalJob);
    }
    public AnimalJob getJob(String className) {
        return map.get(className);
    }
    private JobManager() {
    }
}
