package flycat.create_pattern;

public class PrototypePattern {

    public static class AbstractSpoon implements Cloneable{

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
            this.setSpoonName(name);
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
