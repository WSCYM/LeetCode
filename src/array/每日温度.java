package array;

public class 每日温度 {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j+= result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new 每日温度().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
