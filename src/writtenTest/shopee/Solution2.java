package writtenTest.shopee;


public class Solution2 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param param string字符串
     * @return string字符串
     */
    public String compressString(String param) {
        StringBuilder ret = new StringBuilder();
        char[] chars = param.toCharArray();
        int cnt = 1;
        for (int i = 1;i<chars.length;i++){
            if (chars[i]!=chars[i-1]){
                ret.append(chars[i-1]);
                if (cnt!=1){
                    ret.append(cnt);
                }
                cnt = 1;
            } else {
                cnt++;
            }
        }
        ret.append(chars[chars.length-1]);
        if (cnt!=1){
            ret.append(cnt);
        }
        return ret.toString();
    }
}
