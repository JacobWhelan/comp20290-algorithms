import java.lang.System;

public class Practical3 {

    public static int fibonacciIterative(int n){
        if (n<=1)
            return 1; 
      
        int fib = 1;
        int prevFib =  1;
      
        for (int i = 2; i < n; i++) {
         int temp = fib;
         fib = fib + prevFib;
         prevFib = temp;
        }
        return fib;
    }
      
    public static int fibonacciRecursive(int n) {
        if(n<=2) return 1;

        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    private static void fibonacciTimeCompare(int n) {
        long start1 = System.nanoTime();
        fibonacciIterative(n);
        long total1 = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        fibonacciRecursive(n);
        long total2 = System.nanoTime() - start2;

        System.out.println("Iterative time: " +total1+ " nanoseconds  " + 
                            "Recursive time: " +total2+ " nanoseconds");
    }

    public static void towersOfHanoi(int n, char source, char destination, char aux) {
        if (n==1) {
            System.out.println("Move disk 1 from " +source+ " to " +destination);
        }
        else {
            towersOfHanoi(n-1, source, aux, destination);
            System.out.println("Move disk " +n+ " from " +source+ " to " +destination);
            towersOfHanoi(n-1, aux, destination, source);
        }
    }

    private static void testHanoi(int n, char s, char d, char aux) {
        long start = System.currentTimeMillis();
        towersOfHanoi(n, s, d, aux);
        long total = System.currentTimeMillis() - start;
        System.out.println("\n\tTime taken: " +total+ " miliseconds for " +n+ " rings");
        
    }
       public static void main (String args[]) { 
          
          int n = 30; 

          //fibonacciTimeCompare(n);
          
          for(int i = 2;i<=7;i++) {
            testHanoi(i, 'a', 'b', 'c');
          }
          

        } 
}