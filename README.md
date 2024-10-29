public class sum_and_average {
    public static void main(String[] args) {
        int[] num = { 252, 348, 944, 4664, 452, 754, 5642, 67724, 43647, 537};

        int i = 0;
        int sum = 0;
        while (i < num.length){
            sum += num[i];
            i++;
        }

        float avg = (float) sum / num.length;

        System.out.println("your sum = " + sum);
        System.out.println("your average = " + Math.round(avg * 100.0) / 100);
    }
}
