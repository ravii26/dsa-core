/*
========================================================
FILE: 17_FastIO.java
SECTION 17: FAST INPUT / OUTPUT (JAVA SURVIVAL)
========================================================

Scope:
- Why System.out / Scanner are slow
- BufferedReader + StringTokenizer
- Fast output with StringBuilder
- Custom fast input pattern
- DSA-ready templates

If you ignore this section, Java will TLE on large inputs.
*/

import java.io.*;
import java.util.StringTokenizer;

public class FastIO {

    /*
    ----------------------------------------------------
    17.1 Why Scanner is BAD for DSA
    ----------------------------------------------------

    Scanner:
    - Uses regex internally
    - Very slow
    - Causes TLE for large input

    Rule:
    - NEVER use Scanner in competitive DSA
    */

    /*
    ----------------------------------------------------
    17.2 BufferedReader (FAST INPUT)
    ----------------------------------------------------

    BufferedReader:
    - Reads chunks of input
    - Much faster than Scanner
    */

    /*
    Runnable example:
    */

    /*
    static void bufferedReaderExample() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(line);
    }
    */

    /*
    ----------------------------------------------------
    17.3 StringTokenizer (FAST TOKENIZATION)
    ----------------------------------------------------

    Used to split input by spaces efficiently.
    */

    /*
    Runnable example:
    */

    /*
    static void tokenizerExample() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a + b);
    }
    */

    /*
    DSA rule:
    - Use StringTokenizer for space-separated input
    */

    /*
    ----------------------------------------------------
    17.4 Reading Multiple Lines (DSA STANDARD)
    ----------------------------------------------------
    */

    /*
    static void multiLineInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
        }
    }
    */

    /*
    ----------------------------------------------------
    17.5 Fast Output (StringBuilder)
    ----------------------------------------------------

    Printing line-by-line using System.out.println is slow.

    Use StringBuilder and print once.
    */

    /*
    Runnable example:
    */

    /*
    static void fastOutputExample() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i).append('\n');
        }
        System.out.print(sb.toString());
    }
    */

    /*
    ----------------------------------------------------
    17.6 BufferedWriter (EVEN FASTER OUTPUT)
    ----------------------------------------------------
    */

    /*
    static void bufferedWriterExample() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("Hello\n");
        bw.write("World\n");
        bw.flush();
    }
    */

    /*
    ----------------------------------------------------
    17.7 Complete Fast IO Template (COPY THIS)
    ----------------------------------------------------

    This is the safest template for contests.
    */

    /*
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
    */

    /*
    ----------------------------------------------------
    17.8 DSA RULES FOR FAST IO
    ----------------------------------------------------

    - Never use Scanner
    - Prefer BufferedReader + StringTokenizer
    - Batch output using StringBuilder
    - Use BufferedWriter if output is huge
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
