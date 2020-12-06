package match;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 设计Goal解析器
 * @Description TODO
 * @createTime 2020-12-06 10:30:00
 */
public class 设计Goal解析器 {
    public String interpret(String command) {
        String str1 = command.replace("()","o");
        String str2 = str1.replace("(al)","al");
        return str2;
    }
}
