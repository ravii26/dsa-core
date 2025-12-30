/*
========================================================
FILE: 07_Arrays.java
SECTION 7: ARRAYS (FASTEST DSA STRUCTURE)
========================================================

Scope:
- What arrays really are in Java
- Memory layout
- Indexing cost
- Passing arrays to methods
- 1D, 2D, jagged arrays
- Common DSA patterns and bugs

Arrays are objects, but they behave very differently
from collections. This section makes that precise.
*/

import java.util.Arrays;

public class ArraysDSA {

    /*
    ----------------------------------------------------
    7.1 What an Array Is in Java
    ----------------------------------------------------

    An array:
    - Is an OBJECT stored in heap
    - Stores elements of SAME type
    - Has FIXED size
    - Provides O(1) indexed access

    The reference to the array lives in stack.
    */

    /*
    Runnable example: basic array
    */

    /*
    static void basicArrayExample() {
        int[] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        System.out.println(arr[1]); // 20
    }
    */

    /*
    ----------------------------------------------------
    7.2 Memory Layout (WHY ARRAYS ARE FAST)
    ----------------------------------------------------

    - Array elements are stored contiguously in memory
    - Index calculation is constant time

    arr[i] access:
        base_address + (i * element_size)

    DSA implication:
    - Arrays are cache-friendly
    - Faster than ArrayList for raw computation
    */

    /*
    ----------------------------------------------------
    7.3 Array Length (NOT A METHOD)
    ----------------------------------------------------

    length is a FIELD, not a method.

    Correct:
        arr.length

    Wrong:
        arr.length()

    Runnable example:
    */

    /*
    static void lengthExample() {
        int[] arr = {1, 2, 3};
        System.out.println(arr.length); // 3
    }
    */

    /*
    ----------------------------------------------------
    7.4 Passing Arrays to Methods
    ----------------------------------------------------

    Arrays are passed by VALUE of REFERENCE.

    - Mutating elements works
    - Reassigning reference does NOT
    */

    /*
    Runnable example:
    */

    /*
    static void modifyArray(int[] arr) {
        arr[0] = 99;
    }

    static void arrayPassExample() {
        int[] a = {1, 2, 3};
        modifyArray(a);
        System.out.println(a[0]); // 99
    }
    */

    /*
    ----------------------------------------------------
    7.5 Iterating Over Arrays (DSA STANDARD)
    ----------------------------------------------------

    Index-based loop is preferred when:
    - You need index
    - You need to modify elements
    */

    /*
    static void iterationExample() {
        int[] arr = {1, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
        System.out.println(Arrays.toString(arr)); // [2, 4, 6]
    }
    */

    /*
    Enhanced for loop:
    - Read-only for primitives
    - Cannot modify original values
    */

    /*
    static void enhancedForPitfall() {
        int[] arr = {1, 2, 3};
        for (int x : arr) {
            x = x * 2; // modifies copy
        }
        System.out.println(Arrays.toString(arr)); // [1, 2, 3]
    }
    */

    /*
    ----------------------------------------------------
    7.6 2D Arrays (MATRICES)
    ----------------------------------------------------

    A 2D array in Java is:
    - An array of arrays

    Memory is NOT a single contiguous block.
    */

    /*
    Runnable example:
    */

    /*
    static void twoDArrayExample() {
        int[][] matrix = new int[2][3];
        matrix[0][0] = 1;
        matrix[1][2] = 5;

        System.out.println(matrix[1][2]); // 5
    }
    */

    /*
    ----------------------------------------------------
    7.7 Jagged Arrays (IMPORTANT DETAIL)
    ----------------------------------------------------

    Rows can have different lengths.
    Very common in Java.

    Runnable example:
    */

    /*
    static void jaggedArrayExample() {
        int[][] arr = new int[3][];
        arr[0] = new int[2];
        arr[1] = new int[4];
        arr[2] = new int[1];

        System.out.println(arr[1].length); // 4
    }
    */

    /*
    DSA relevance:
    - Tree-like matrix structures
    - Adjacency lists
    */

    /*
    ----------------------------------------------------
    7.8 Common DSA Patterns Using Arrays
    ----------------------------------------------------

    1. Prefix Sum
    */

    /*
    static void prefixSumExample() {
        int[] arr = {1, 2, 3, 4};
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        System.out.println(Arrays.toString(prefix)); // [1, 3, 6, 10]
    }
    */

    /*
    2. Sliding Window (fixed size)
    */

    /*
    static void slidingWindowExample() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int sum = 0;

        for (int i = 0; i < k; i++) sum += arr[i];

        int maxSum = sum;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum); // 12
    }
    */

    /*
    ----------------------------------------------------
    7.9 Array Copying (SHALLOW vs REAL COPY)
    ----------------------------------------------------
    */

    /*
    static void arrayCopyExample() {
        int[] a = {1, 2, 3};

        int[] shallow = a; // reference copy
        int[] deep = Arrays.copyOf(a, a.length);

        deep[0] = 99;

        System.out.println(a[0]);    // 1
        System.out.println(deep[0]); // 99
    }
    */

    /*
    DSA rule:
    - Deep copy when state isolation is required
    - Shallow copy when mutation is intentional
    */

    /*
    ----------------------------------------------------
    7.10 DSA RULES FOR ARRAYS
    ----------------------------------------------------

    - Arrays are FAST
    - Fixed size → plan capacity
    - Use int[] / long[] over wrapper collections
    - Prefer arrays for performance-critical code
    - Understand reference behavior to avoid bugs
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
