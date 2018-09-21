public class Test {
    @org.junit.Test
    public void test () {
        byte[] bytes = "ndfasdfa".getBytes();
        byte[] bytess = " ".getBytes();
        for (byte b: bytes
             ) {
//            System.out.println(b);
        }
        System.out.println(new String(bytes));
        System.out.println(new String(bytess));
    }
}
