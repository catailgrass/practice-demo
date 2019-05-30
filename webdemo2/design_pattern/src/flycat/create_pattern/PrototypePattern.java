package flycat.create_pattern;

/**
 * 原型模式定义: 用原型实例指定创建对象的种类,并且通过拷贝这些原型创建新的对象.
 * Prototype模式允许一个对象再创建另外一个可定制的对象，
 * 根本无需知道任何如何创建的细节,工作原理是:通过将一个原型对象传给那个要发动创建的对象，
 * 这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建。
 */
public class PrototypePattern {


    public static class AbstractSpoon implements Cloneable{

        public AbstractSpoon(String spoonName) {
            this.spoonName = spoonName;
        }

        private String spoonName;

        public String getSpoonName() {
            return spoonName;
        }

        public void setSpoonName(String spoonName) {
            this.spoonName = spoonName;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class SoupSpoon extends AbstractSpoon{

        public SoupSpoon(String name) {
            super(name);
        }
    }

    public static void main(String[] args) {
        AbstractSpoon abstractSpoon = new SoupSpoon("this is a soup spoon");
        System.out.println(abstractSpoon.getSpoonName());
        System.out.println(abstractSpoon.hashCode());
        try {
            AbstractSpoon abstractSpoon1 = (AbstractSpoon)abstractSpoon.clone();
            System.out.println(abstractSpoon1.getSpoonName());
            System.out.println(abstractSpoon1.hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
