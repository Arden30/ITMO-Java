public class Lab1 {
    public static void main(String[] args) {
        final int ARR_SIZE1 = 11;
        final int MIN_VALUE = 5;

        long[] c = new long[ARR_SIZE1];

        System.out.println("First task");
        for (int i = 0, j = MIN_VALUE; i < ARR_SIZE1; i++, j++) {
            c[i] = j;
            System.out.print("  " + c[i] + "  ");
        }
        System.out.println();

        final int ARR_SIZE2 = 18;
        final float MINIMUM = -2.0f;
        final float MAXIMUM = 8.0f;

        float[] x = new float[ARR_SIZE2];

        System.out.println("Second task");
        for (int i = 0; i < ARR_SIZE2; i++) {
            x[i] = (float) Math.random() * (MAXIMUM - MINIMUM) + MINIMUM;
            System.out.printf("%8.4f", x[i]);
            if (i == ARR_SIZE2 / 2 - 1)
                System.out.println();
        }
        System.out.println();

        double[][] d = new double[ARR_SIZE1][ARR_SIZE2];

        System.out.println("Third task");
        for (int i = 0; i < ARR_SIZE1; i++) {
            for (int j = 0; j < ARR_SIZE2; j++) {
                if (c[i] == 5)
                    d[i][j] = Math.sin(Math.asin(Math.pow(Math.E, -Math.abs(x[j]))));
                else if (c[i] >= 11 && c[i] <= 15)
                    d[i][j] = Math.pow(Math.pow(Math.cbrt(x[j]) * (Math.asin((x[j] + 3) * Math.E + 1) + 1), 2), 4 - Math.pow(Math.E, Math.asin((x[j] + 3) * Math.E + 1)));
                else
                    d[i][j] = Math.pow(Math.PI + Math.asin(Math.pow(Math.E, -Math.cbrt(Math.pow(4 * Math.abs(x[j]),x[j])))),Math.cbrt(Math.atan(Math.pow((x[j] + 3) * Math.E + 1, 2))));
            }
        }
        for (int i = 0; i < ARR_SIZE1; i++) {
            if (i != 0)
                System.out.println();
            for (int j = 0; j < ARR_SIZE2; j++) {
                System.out.printf("%8.4f", d[i][j]);
            }
        }
    }
}