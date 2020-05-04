# comp20290-algorithms

From my testing I observed the following from my implementations of algorithms:

- Russian Peasant Multiplication ran surprisingly well, with 0logN worst case time.

- Fibonacci calculator with recursion was exponential, so beyond small n-values, iterative was far superior.

- Towers of hanoi ran in exponential time due to the exponential amount of moves needed to solve the puzzle.

- for sorting algorithms, Insertion and selection sort were (as expected) very time-expensive at greater n values. Merge sort vs enhanced 
    merge sort we comparable but this could come down to hardware. With nanosecond timing the enhanced merge sort performed better.
    
- for substring searches there were very varied times. Results depended on the text used, however for longer texts KMP was far more efficient than brute force
    
