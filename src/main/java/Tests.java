
/**
 * @author : tom
 * @date : 2019-02-16 10:18
 **/


public class Tests {

    public static void main(String[] args) {
        String s1 = new String("aaaaaaaaaaaaaaaaaaa");
        System.out.println(s1.intern() == s1);
    }

}
