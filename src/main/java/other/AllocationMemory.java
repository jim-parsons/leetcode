package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : tom
 * @date : 2019-03-14 20:48
 **/
public class AllocationMemory {
    /**
     * 请写一段程序，让其运行时的表现为触发5次ygc，然后3次fgc，然后3次ygc，然后1次fgc，请给出代码以及启动参数。
     *
     * -Xms8m -Xmx8m -XX:+PrintGCDetails -XX:+UseSerialGC -Xmn3m -XX:SurvivorRatio=2
     */
    private final static int xmb = 1024*1024;

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<byte[]>();

        for (int i = 0; i < 5; i++) {
            byte[] alloc = new byte[xmb];
            list.add(alloc);
        }
        list = null;
        for (int i = 0; i < 3; i++) {
            byte[] alloc = new byte[3 *1024 *1024];
            alloc= null;
        }
        for (int i = 0; i < 4; i++) {
            byte[] alloc = new byte[xmb];
        }
        byte[] alloc = new byte[3*xmb];
    }
}
