package Practice_2;

public class ArrayStat {

    public static int findMin(int[] array) {
        validateArray(array);
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)     min = array[i];
        }
        return min;
    }

    public static int findMax(int[] array) {
        validateArray(array);
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)    max = array[i];
        }
        return max;
    }

    public static double findAvg(int[] array) {
        validateArray(array);
        double sum = 0;
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    private static void validateArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
    }
}
