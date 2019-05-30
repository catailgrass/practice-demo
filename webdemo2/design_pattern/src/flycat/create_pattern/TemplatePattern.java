package flycat.create_pattern;

/**
 *Template模板模式定义: 定义一个操作中算法的骨架,将一些步骤的执行延迟到其子类中.
 * 使用Java的抽象类时，就经常会使用到Template模式,因此Template模式使用很普遍.
 * 而且很容易理解和使用。
 */
public class TemplatePattern {
    /**
     * 让一些具体算法延后执行 具体细节也不表示，以后更改 也只需要重新实现 抽象类即可
     */
    public static abstract class AbstractTemplate{

        public abstract void sthDoLaterly();

        public Long request(int count) {

            if (count <= 0) {
                return 0L;
            }else {
                Long startTime = System.currentTimeMillis();
                for (int i = 0; i < count; i++) {
                    sthDoLaterly();
                }
                return System.currentTimeMillis() - startTime;
            }
        }
    }

    public static class SayHello extends AbstractTemplate{

        @Override
        public void sthDoLaterly() {
            for (int i = 0; i < 6; i++) {
                System.out.println("i = "+i);
            }
        }

    }

    public static void main(String[] args) {
        AbstractTemplate abstractTemplate = new SayHello();
        System.out.println(abstractTemplate.request(3));
    }
}
