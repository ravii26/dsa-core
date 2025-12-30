/*
========================================================
SECTION 0: HOW JAVA ACTUALLY RUNS (DSA FOUNDATION)
========================================================

This section explains HOW Java code executes in reality.
If you misunderstand this, you WILL make DSA mistakes
(memory bugs, recursion bugs, TLEs, wrong assumptions).

*/

public class JavaBasics {

    /*
    ----------------------------------------------------
    0.1 Java is NOT interpreted, NOT fully compiled
    ----------------------------------------------------

    Flow of execution:

        Java Source Code (.java)
                |
                |  (javac compiler)
                v
        Bytecode (.class)
                |
                |  (JVM)
                v
        Native Machine Instructions

    Key idea:
    - Java code is compiled ONCE into bytecode
    - Bytecode runs on JVM, not directly on hardware
    - JVM translates bytecode to machine code at runtime

    DSA relevance:
    - JVM adds overhead compared to C++
    - But algorithmic complexity still dominates
    - Poor Java usage (Scanner, recursion abuse) causes TLE (Time Limit Exceed)
    */

    /*
    ----------------------------------------------------
    0.2 JDK vs JRE vs JVM (DO NOT CONFUSE)
    ----------------------------------------------------

    JVM (Java Virtual Machine)
    - Executes bytecode
    - Manages memory (stack, heap)
    - Handles garbage collection
    - Platform-dependent

    JRE (Java Runtime Environment)
    - JVM + core libraries
    - Needed to RUN Java programs
    - Cannot compile code

    JDK (Java Development Kit)
    - JRE + compiler (javac) + tools
    - Needed to WRITE and RUN Java code

    DSA relevance:
    - Online judges already provide JRE/JVM
    - You only care about runtime behavior
    */

    /*
    ----------------------------------------------------
    0.3 Stack vs Heap (MEMORY THAT ACTUALLY MATTERS)
    ----------------------------------------------------

    Java uses two main memory areas that you MUST understand
    to write correct DSA code.

    ----------------
    STACK MEMORY
    ----------------
    - Stores method calls (function execution)
    - Stores local variables inside methods
    - Stores references to objects (not the objects themselves)
    - Each method call gets its own stack frame
    - Memory is allocated and freed automatically when methods enter/exit
    - Very FAST but LIMITED in size

    Example:
        void solve() {
            int x = 10;
            int y = 20;
        }

    Here:
    - x and y are stored directly in the stack
    - When solve() returns, x and y are destroyed immediately

    ----------------
    HEAP MEMORY
    ----------------
    - Stores objects and arrays
    - Shared across all methods
    - Larger than stack but slower
    - Memory is NOT freed immediately
    - Managed by Garbage Collector

    Example:
        int[] arr = new int[5];

    Here:
    - 'arr' (reference) is stored in stack
    - Actual int[5] array is stored in heap

    Key idea:
    STACK stores "where the object is"
    HEAP stores "what the object is"

    DSA implication:
    - Recursion uses stack → deep recursion can crash
    - Large arrays live in heap → safer for big data

    ----------------
    Runnable Example: Stack vs Heap
    ----------------

    static void exampleStackHeap() {
        int x = 10;
        int[] arr = new int[2];

        arr[0] = x;
        modify(arr, x);

        System.out.println(x);       // 10
        System.out.println(arr[0]);  // 99
    }

    static void modify(int[] arr, int x) {
        x = 99;
        arr[0] = 99;
    }

    Execution explanation:
    - x is a primitive → copied into modify() stack frame
    - Changing x inside modify() does NOT affect original x
    - arr is a reference → copied value points to SAME heap array
    - Changing arr[0] affects original array

    This single example explains:
    - Stack variable isolation
    - Heap object sharing
    - Why array mutation works across methods
    */

    /*
    ----------------------------------------------------
    0.4 Object References (MOST COMMON SOURCE OF BUGS)
    ----------------------------------------------------

    Example:
        int[] a = new int[3];

    Memory:
    - 'a' is a reference stored in stack
    - new int[3] is an object stored in heap

    Now:
        int[] b = a;

    What happens:
    - NO new array is created
    - 'b' copies the reference value from 'a'
    - a and b point to the SAME heap array

    Result:
        b[0] = 100;

    Now:
        a[0] == 100  // true

    Because:
    - There is only ONE array in heap
    - Both references point to it

    DSA implication:
    - Passing arrays to methods does NOT copy them
    - Modifying array inside a method affects original array
    - This is intentional and heavily used in DSA

    ----------------
    Runnable Example: Reference Copy
    ----------------

    static void referenceCopyExample() {
        int[] a = {1, 2, 3};
        int[] b = a;

        b[1] = 100;

        System.out.println(a[1]); // 100
    }

    Explanation:
    - a and b store separate references
    - BOTH references point to the SAME heap array
    - No deep copy happens unless explicitly created

    DSA relevance:
    - Always be careful when assigning arrays or lists
    - Accidental shared references cause subtle bugs

    */

    /*
    ----------------------------------------------------
    0.5 Why Java is Slower than C++ (But Still Works)
    ----------------------------------------------------

    Reasons:
    - JVM abstraction
    - Garbage Collection
    - Bounds checking on arrays
    - Autoboxing overhead
    - No pointer arithmetic

    Why it still works for DSA:
    - O(N log N) beats O(N^2) regardless of language
    - Correct data structures + fast I/O = safe
    - Java is accepted in most competitive environments

    DSA rule:
    - Algorithm > language
    - BUT careless Java usage causes TLE
    */

    /*
    ----------------------------------------------------
    0.6 Garbage Collection (WHAT IT REALLY DOES)
    ----------------------------------------------------

    Garbage Collection (GC) frees heap memory automatically.

    An object becomes ELIGIBLE for garbage collection when:
    - No active reference points to it

    Example:
        int[] arr = new int[1000];
        arr = null;

    After this:
    - The array has no references
    - JVM MAY free it later
    - Memory is NOT freed immediately

    Important facts:
    - GC timing is unpredictable
    - You CANNOT force garbage collection reliably
    - finalize() is deprecated and should not be used
    - GC runs when JVM decides memory pressure exists

    What GC does NOT do:
    - It does NOT manage stack memory
    - It does NOT guarantee immediate cleanup

    DSA implication:
    - Avoid creating objects repeatedly inside loops
    - Prefer primitive arrays over wrapper objects
    - Excessive allocations cause GC overhead and slow execution

    ----------------
    Runnable Example: GC Eligibility
    ----------------

    static void gcEligibilityExample() {
        int[] arr = new int[1000];  // heap allocation
        arr[0] = 42;

        arr = null; // object becomes eligible for GC
    }

    Important:
    - Memory is NOT freed at arr = null
    - JVM decides WHEN to reclaim memory
    - You cannot observe GC directly here

    DSA relevance:
    - Do not rely on GC behavior
    - Control memory by reducing allocations

    ----------------
    Runnable Example: Stack Cleanup vs GC
    ----------------

    static void stackVsGc() {
        helper();
        // after helper() returns:
        // stack frame is destroyed immediately
    }

    static void helper() {
        int x = 10;              // stack
        int[] arr = new int[5];  // heap
    }

    Explanation:
    - x is destroyed as soon as helper() returns
    - arr stays in heap until GC runs
    - Stack cleanup is deterministic
    - Heap cleanup is NOT

    DSA relevance:
    - Recursion depth is predictable
    - Heap memory pressure is not
    */

    /*
    ----------------------------------------------------
    0.7 Key DSA Takeaways from Runtime Model
    ----------------------------------------------------

    1. Stack is limited → recursion depth matters
    2. Heap is shared → reference bugs are common
    3. Arrays & objects are NOT copied by default
    4. Java overhead exists → write efficient code
    5. Understanding memory prevents logic bugs

    */

   /*
    ----------------
    Runnable Example: Stack Overflow
    ----------------

    static void stackOverflowExample() {
        recurse(1);
    }

    static void recurse(int depth) {
        // Each call consumes stack memory
        recurse(depth + 1);
    }

    What happens:
    - Each recursive call creates a new stack frame
    - Stack memory is limited
    - JVM throws StackOverflowError

    Important:
    - This is NOT a heap issue
    - Garbage Collection does NOT help
    - Stack memory is fixed per thread

    DSA relevance:
    - Deep recursion on skewed trees can crash Java
    - Convert recursion to iteration when depth is large
    - Prefer iterative DFS/BFS in Java for safety
    */

    public static void main(String[] args) {
    }
}
