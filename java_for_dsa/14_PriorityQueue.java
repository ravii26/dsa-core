/*
========================================================
FILE: 14_PriorityQueue.java
SECTION 14: PRIORITY QUEUE (HEAP FOR DSA)
========================================================

Scope:
- What PriorityQueue really is
- Min-heap vs Max-heap
- Internal behavior & time complexity
- Comparator usage
- Common DSA patterns
- Java-specific pitfalls

PriorityQueue in Java is a BINARY HEAP.
*/

import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueDSA {

    /*
    ----------------------------------------------------
    14.1 What PriorityQueue Is
    ----------------------------------------------------

    PriorityQueue:
    - Implements a MIN-HEAP by default
    - The "smallest" element is always at the head
    - NOT sorted iteration
    - Backed by an array-based binary heap

    Head access:
        peek()  -> O(1)
        poll()  -> O(log n)
        add()   -> O(log n)
    */

    /*
    ----------------------------------------------------
    14.2 Min-Heap (DEFAULT)
    ----------------------------------------------------
    */

    /*
    Runnable example: min-heap
    */

    /*
    static void minHeapExample() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(1);
        pq.add(3);

        System.out.println(pq.peek()); // 1

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        // Output order: 1 3 5
    }
    */

    /*
    Important:
    - Iterating over pq DOES NOT give sorted order
    - Only poll() respects priority
    */

    /*
    ----------------------------------------------------
    14.3 Max-Heap (USING COMPARATOR)
    ----------------------------------------------------

    Java does NOT provide a max-heap directly.
    We reverse comparison using Comparator.
    */

    /*
    Runnable example: max-heap
    */

    /*
    static void maxHeapExample() {
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(5);
        pq.add(1);
        pq.add(3);

        System.out.println(pq.peek()); // 5
    }
    */

    /*
    DSA rule:
    - Always verify heap type explicitly
    */

    /*
    ----------------------------------------------------
    14.4 PriorityQueue with Custom Objects
    ----------------------------------------------------

    Very common in DSA (pairs, nodes, intervals).
    */

    /*
    static class Pair {
        int val;
        int freq;

        Pair(int v, int f) {
            val = v;
            freq = f;
        }
    }

    static void customObjectHeap() {
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> b.freq - a.freq);

        pq.add(new Pair(1, 3));
        pq.add(new Pair(2, 5));
        pq.add(new Pair(3, 1));

        System.out.println(pq.peek().val); // 2
    }
    */

    /*
    DSA pitfall:
    - Comparator overflow when subtracting
    - Prefer Integer.compare(b.freq, a.freq)
    */

    /*
    ----------------------------------------------------
    14.5 Comparator Overflow Bug (IMPORTANT)
    ----------------------------------------------------
    */

    /*
    BAD:
        (a, b) -> b - a

    GOOD:
        (a, b) -> Integer.compare(b, a)
    */

    /*
    ----------------------------------------------------
    14.6 Top-K Pattern (DSA CLASSIC)
    ----------------------------------------------------

    Keep heap size limited to K.
    */

    /*
    static void topKExample(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println(pq.peek()); // kth largest
    }
    */

    /*
    ----------------------------------------------------
    14.7 Why PriorityQueue Is NOT Sorted
    ----------------------------------------------------

    Heap property:
    - Only parent-child order guaranteed
    - No ordering between siblings

    Consequence:
    - for-each iteration is meaningless for order
    */

    /*
    ----------------------------------------------------
    14.8 Common DSA Uses
    ----------------------------------------------------

    - Top K elements
    - Kth largest / smallest
    - Merge K sorted lists
    - Greedy scheduling
    - Dijkstra (with comparator)

    Wrong heap choice = wrong answer.
    */

    /*
    ----------------------------------------------------
    14.9 DSA RULES FOR PRIORITYQUEUE
    ----------------------------------------------------

    - Default is min-heap
    - Use Comparator for max-heap
    - Never assume sorted iteration
    - Use Integer.compare to avoid overflow
    - Limit heap size for Top-K
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
