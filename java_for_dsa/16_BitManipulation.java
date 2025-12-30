/*
========================================================
FILE: 16_BitManipulation.java
SECTION 16: BIT MANIPULATION (INTERVIEW FILTER)
========================================================

Scope:
- Binary representation
- Bitwise operators
- Bit masking
- Common DSA tricks
- Power of two checks
- Java-specific bit behavior

Bit manipulation gives O(1) solutions where others use loops.
*/

public class BitManipulation {

    /*
    ----------------------------------------------------
    16.1 Binary Representation (FOUNDATION)
    ----------------------------------------------------

    Integers are stored in binary (two's complement).

    Example:
        5  -> 0101
        -5 -> two's complement representation

    Java uses two's complement for signed integers.
    */

    /*
    ----------------------------------------------------
    16.2 Bitwise Operators
    ----------------------------------------------------

    &  (AND)
    |  (OR)
    ^  (XOR)
    ~  (NOT)
    << (Left shift)
    >> (Right shift, sign-propagating)
    >>>(Unsigned right shift)
    */

    /*
    Runnable example:
    */

    /*
    static void bitwiseBasics() {
        int a = 5;  // 0101
        int b = 3;  // 0011

        System.out.println(a & b); // 1  (0001)
        System.out.println(a | b); // 7  (0111)
        System.out.println(a ^ b); // 6  (0110)
    }
    */

    /*
    ----------------------------------------------------
    16.3 Left Shift and Right Shift
    ----------------------------------------------------

    Left shift (<<):
    - Multiplies by 2^k

    Right shift (>>):
    - Divides by 2^k (keeps sign bit)

    Runnable example:
    */

    /*
    static void shiftExample() {
        int x = 5;

        System.out.println(x << 1); // 10
        System.out.println(x >> 1); // 2
    }
    */

    /*
    ----------------------------------------------------
    16.4 Unsigned Right Shift (>>>)
    ----------------------------------------------------

    >>> shifts in zeros regardless of sign.

    Runnable example:
    */

    /*
    static void unsignedShiftExample() {
        int x = -1;
        System.out.println(x >>> 1); // large positive number
    }
    */

    /*
    ----------------------------------------------------
    16.5 Checking if a Number is Power of Two
    ----------------------------------------------------

    Trick:
        n & (n - 1) == 0

    Runnable example:
    */

    /*
    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    */

    /*
    ----------------------------------------------------
    16.6 Set, Clear, Toggle a Bit
    ----------------------------------------------------
    */

    /*
    static void bitOperations() {
        int x = 5; // 0101

        // set bit at position 1
        x = x | (1 << 1);   // 0111

        // clear bit at position 0
        x = x & ~(1 << 0);  // 0110

        // toggle bit at position 2
        x = x ^ (1 << 2);   // 0010
    }
    */

    /*
    ----------------------------------------------------
    16.7 XOR Trick (DSA GOLD)
    ----------------------------------------------------

    Properties:
    - a ^ a = 0
    - a ^ 0 = a
    - XOR is commutative and associative

    Use case:
    - Find unique element where others appear twice
    */

    /*
    static int findUnique(int[] arr) {
        int res = 0;
        for (int x : arr) {
            res ^= x;
        }
        return res;
    }
    */

    /*
    ----------------------------------------------------
    16.8 Counting Set Bits
    ----------------------------------------------------

    Brian Kernighan’s algorithm:
    */

    /*
    static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    */

    /*
    ----------------------------------------------------
    16.9 Bit Masking (STATE REPRESENTATION)
    ----------------------------------------------------

    Use bits to represent states.

    Example:
    - Subsets
    - Visited flags
    */

    /*
    static void bitMaskExample() {
        int mask = 0;

        // mark 2nd element visited
        mask |= (1 << 2);

        // check if visited
        boolean visited = (mask & (1 << 2)) != 0;

        System.out.println(visited); // true
    }
    */

    /*
    ----------------------------------------------------
    16.10 DSA RULES FOR BIT MANIPULATION
    ----------------------------------------------------

    - Use bits for O(1) state checks
    - XOR simplifies duplicate problems
    - Shifts are faster than multiplication/division
    - Be careful with signed shifts
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
