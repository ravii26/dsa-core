/*
========================================================
FILE: 10_WrapperAutoboxing.java
SECTION 10: WRAPPER CLASSES & AUTOBOXING (HIDDEN COSTS)
========================================================

Scope:
- What wrapper classes are
- Autoboxing / unboxing
- Integer caching
- Performance penalties
- Why List<Integer> is slower than int[]
- Real DSA pitfalls

This section prevents silent TLEs.
*/

import java.util.ArrayList;
import java.util.List;

public class WrapperAutoboxing {

    /*
    ----------------------------------------------------
    10.1 What Wrapper Classes Are
    ----------------------------------------------------

    Wrapper classes:
    - Object representations of primitives

    Examples:
    - int     → Integer
    - long    → Long
    - double  → Double
    - boolean → Boolean

    They are immutable objects stored in heap.
    */

    /*
    ----------------------------------------------------
    10.2 Why Wrapper Classes Exist
    ----------------------------------------------------

    Reasons:
    - Collections cannot store primitives
    - Generics work only with objects
    - Need object semantics (null, methods)

    DSA reality:
    - Wrappers exist for API compatibility
    - Primitives are preferred for performance
    */

    /*
    ----------------------------------------------------
    10.3 Autoboxing & Unboxing
    ----------------------------------------------------

    Autoboxing:
        primitive → wrapper

    Unboxing:
        wrapper → primitive

    Happens automatically and invisibly.
    */

    /*
    Runnable example:
    */

    /*
    static void autoboxingExample() {
        Integer a = 10;   // autoboxing (int → Integer)
        int b = a;        // unboxing (Integer → int)

        System.out.println(b); // 10
    }
    */

    /*
    ----------------------------------------------------
    10.4 Performance Cost (DSA TRAP)
    ----------------------------------------------------

    Autoboxing:
    - Allocates objects
    - Adds GC pressure
    - Slower than primitives

    Example (DO NOT DO IN DSA):
    */

    /*
    static void boxingInLoop() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i); // boxing happens every iteration
        }
    }
    */

    /*
    DSA rule:
    - Avoid wrapper usage inside tight loops
    */

    /*
    ----------------------------------------------------
    10.5 Integer Caching (INTERVIEW TRAP)
    ----------------------------------------------------

    Java caches Integer objects for values:
        -128 to 127

    Runnable example:
    */

    /*
    static void integerCachingExample() {
        Integer a = 100;
        Integer b = 100;

        Integer x = 200;
        Integer y = 200;

        System.out.println(a == b); // true (cached)
        System.out.println(x == y); // false (new objects)
    }
    */

    /*
    DSA rule:
    - NEVER compare wrappers using ==
    - Always use equals()
    */

    /*
    ----------------------------------------------------
    10.6 Null Pointer Risk with Wrappers
    ----------------------------------------------------

    Wrappers can be null.
    Primitives cannot.

    Runnable example (runtime error):
    */

    /*
    static void nullUnboxingExample() {
        Integer x = null;
        int y = x; // NullPointerException
    }
    */

    /*
    DSA implication:
    - Avoid wrapper null checks
    - Prefer primitives when possible
    */

    /*
    ----------------------------------------------------
    10.7 List<Integer> vs int[] (DSA DECISION)
    ----------------------------------------------------

    int[]:
    - Stores primitives
    - Fast
    - No boxing

    List<Integer>:
    - Stores objects
    - Boxing/unboxing overhead
    - Slower

    Runnable comparison:
    */

    /*
    static void arrayVsListExample() {
        int[] arr = new int[1000];
        List<Integer> list = new ArrayList<>(1000);

        arr[0] = 1;
        list.add(1); // boxing
    }
    */

    /*
    DSA rule:
    - Use int[] / long[] for frequency, DP, prefix sums
    - Use List<Integer> only when resizing or API requires it
    */

    /*
    ----------------------------------------------------
    10.8 DSA RULES FOR WRAPPERS
    ----------------------------------------------------

    - Prefer primitives
    - Avoid autoboxing in loops
    - Never compare wrappers with ==
    - Beware of null unboxing
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
