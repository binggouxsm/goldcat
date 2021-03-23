import com.eden.finance.goldcat.entity.enums.TypeCode;

public class Test {

    public static void main(String[] args) {
        TypeCode e = TypeCode.valueOf("IN_OUT_TYPE");
        System.out.println(e.getValue());

    }
}
