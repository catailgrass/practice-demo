package practice.thread.business_to_class;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author Gramo
 * @Time 2019/3/15
 * @DES
 */
public class JobExecuteService {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        String[] whoDoJobs = new String[]{"DogDoJob","HumanDoJob","CatDoJob"};
        for (int i = 0; i < whoDoJobs.length; i++) {
            String realClassName = "practice.thread.business_to_class." + whoDoJobs[i];
            try {
                Class clazz = Class.forName(realClassName);
                clazz.getConstructor().newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        List<JobThread> jobList = new ArrayList<>();
        for (int i = 0; i < whoDoJobs.length; i++) {
            JobThread jobThread = new JobThread();
            jobThread.setClassName(whoDoJobs[i]);
            jobList.add(jobThread);
        }
        try {
            List<Future<String>> resultList = executorService.invokeAll(jobList);
            for (int i = 0;i<resultList.size();i++){
                System.out.println(resultList.get(i).get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static class JobThread implements Callable<String> {
        private String className;

        public JobThread() {

        }

        @Override
        public String call() throws Exception {

            AnimalJob animalJob = JobManager.getInstance().getJob("practice.thread.business_to_class."+className);
            return animalJob.execute();
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }
    }
}
