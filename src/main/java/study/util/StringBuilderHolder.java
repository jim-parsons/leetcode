package study.util;

/**
 * @author : tom
 * @date : 2019-02-23 16:02
 **/
public class StringBuilderHolder {

    private final StringBuilder sb;

    public StringBuilderHolder(int cap) {
        this.sb = new StringBuilder(cap);
    }

    public StringBuilder resetAndGet() {
        sb.setLength(0);
        return sb;
    }

    private static final ThreadLocal<StringBuilderHolder> stringBuilder = new ThreadLocal<StringBuilderHolder>(){
        @Override
        protected StringBuilderHolder initialValue() {
            return new StringBuilderHolder(256);
        }
    };
}
