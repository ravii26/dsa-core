/*
========================================================
FILE: 02_PrimitiveTypes.java
SECTION 2: PRIMITIVE DATA TYPES (DSA CRITICAL)
========================================================

Scope:
- Only Java primitive types
- Sizes, ranges, signed behavior
- Overflow / underflow
- int vs long decisions
- char as integer
- boolean behavior
- DSA traps and correct usage

No objects. No wrappers. No collections.
*/

public class PrimitiveTypes {

    /*
    ----------------------------------------------------
    2.1 What Primitive Types Are
    ----------------------------------------------------

    Primitive types store ACTUAL VALUES, not references.
    They live in the stack (when local), are fast, and
    have fixed sizes.

    Java primitives:
    - byte
    - short
    - int
    - long
    - float
    - double
    - char
    - boolean
    */

    /*
    ----------------------------------------------------
    2.2 Sizes & Ranges (MEMORIZE FOR DSA)
    ----------------------------------------------------

    byte    : 1 byte  (8 bits)   -> -128 to 127
    short   : 2 bytes (16 bits)  -> -32,768 to 32,767
    int     : 4 bytes (32 bits)  -> -2^31 to (2^31 - 1)
    long    : 8 bytes (64 bits)  -> -2^63 to (2^63 - 1)

    char    : 2 bytes (16 bits)  -> 0 to 65,535 (UNSIGNED)
    boolean : JVM dependent      -> true / false

    DSA rule:
    - Use int by default
    - Use long when:
        * sums
        * products
        * counts
        * constraints can exceed 2^31 - 1
    */

    /*
    ----------------------------------------------------
    2.3 Signed Nature & Overflow (MOST COMMON WA BUG)
    ----------------------------------------------------

    Java integers are SIGNED.
    Overflow does NOT throw error.
    Value wraps around silently.

    Runnable example:
    */

    /*
    static void overflowExample() {
        int x = Integer.MAX_VALUE; // 2147483647
        x = x + 1;
        System.out.println(x); // -2147483648 (overflow)
    }
    */

    /*
    Explanation:
    - int uses 32 bits
    - When max value is exceeded, bits wrap
    - Java does NOT warn you

    DSA implication:
    - Prefix sums must often be long
    - Multiplying two ints can overflow even if result fits in long
    */

    /*
    ----------------------------------------------------
    2.4 int vs long (WHEN int IS NOT ENOUGH)
    ----------------------------------------------------

    int is faster and preferred, BUT unsafe for large math.

    Runnable example:
    */

    /*
    static void intVsLongExample() {
        int a = 1_000_000_000;
        int b = 2;

        int wrong = a * b;        // overflow
        long correct = (long) a * b;

        System.out.println(wrong);   // negative or incorrect
        System.out.println(correct); // 2000000000
    }
    */

    /*
    DSA rule:
    - Cast BEFORE multiplication
    - (long)a * b, not (long)(a * b)
    */

    /*
    ----------------------------------------------------
    2.5 float vs double (WHY FLOAT IS RARELY USED)
    ----------------------------------------------------

    float  : 4 bytes  (~6-7 decimal precision)
    double : 8 bytes  (~15 decimal precision)

    Java uses double as default for decimals.

    Runnable example:
    */

    /*
    static void floatingPointExample() {
        double x = 0.1 + 0.2;
        System.out.println(x); // 0.30000000000000004
    }
    */

    /*
    Explanation:
    - Floating point uses binary representation
    - Some decimals cannot be represented exactly

    DSA rule:
    - Avoid floating point when possible
    - Prefer integer math
    - Use double only when explicitly required
    */

    /*
    ----------------------------------------------------
    2.6 char IS AN INTEGER (IMPORTANT TRICK)
    ----------------------------------------------------

    char is an UNSIGNED 16-bit integer.
    It stores numeric Unicode value.

    Runnable example:
    */

    /*
    static void charAsIntExample() {
        char c = 'a';
        System.out.println(c);        // a
        System.out.println(c + 1);    // 98
        System.out.println((char)(c + 1)); // b
    }
    */

    /*
    DSA usage:
    - Character frequency arrays
    - 'a' to 'z' mapping using (c - 'a')
    */

    /*
    ----------------------------------------------------
    2.7 boolean (WHY IT IS SPECIAL)
    ----------------------------------------------------

    boolean has ONLY two values:
    - true
    - false

    - No numeric conversion
    - Cannot cast to int
    - JVM decides actual memory size

    Runnable example (compile-time error shown conceptually):
    */

    /*
    static void booleanExample() {
        boolean b = true;
        // int x = (int) b; // COMPILATION ERROR
    }
    */

    /*
    DSA usage:
    - visited arrays
    - flags
    - condition tracking

    DSA rule:
    - Do NOT assume boolean size
    - Use boolean[] for visited
    */

    /*
    ----------------------------------------------------
    2.8 Default Values (ONLY FOR FIELDS)
    ----------------------------------------------------

    Instance / static fields get default values:
    - int     -> 0
    - long    -> 0
    - double  -> 0.0
    - boolean -> false
    - char    -> '\u0000'

    Local variables DO NOT get defaults.

    Runnable example:
    */

    /*
    static int defaultInt;

    static void defaultValueExample() {
        System.out.println(defaultInt); // 0

        int x;
        // System.out.println(x); // COMPILATION ERROR
    }
    */

    /*
    DSA implication:
    - Always initialize local variables
    - Never rely on default values in logic
    */

    /*
    ----------------------------------------------------
    2.9 Primitive Arrays (DSA FAVORITE)
    ----------------------------------------------------

    Primitive arrays:
    - Store actual values
    - No autoboxing
    - Faster than wrapper collections

    Runnable example:
    */

    /*
    static void primitiveArrayExample() {
        int[] freq = new int[26];
        char c = 'c';
        freq[c - 'a']++;
        System.out.println(freq[2]); // 1
    }
    */

    /*
    DSA rule:
    - Prefer int[] over List<Integer>
    - Prefer long[] for large sums
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
