
public class Practical1{

    public static int RussianMultiply(int n, int m) {
        int result = 0;

        while(m != 0) {
            if((m%2) == 1) {
                result += n;
            }

            n *= 2;
            m /= 2;
        }
        
        return result;
    }

    private static void testRussianMultiply(int n, int m) {
        final long start = System.nanoTime();   
        RussianMultiply(n, m);
        final long total = System.nanoTime() - start;
        System.out.println("Time taken for: "+n+"x"+
                            m+" was " + total+" nanoseconds");
    }

    public static void main(String args[]) {
        System.out.println(RussianMultiply(238,13));

        testRussianMultiply(1000000, 1000000);

    }
}