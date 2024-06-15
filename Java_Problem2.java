import java.io.*;
import java.util.*;

public class Main {

    static void solve(Scanner sc) {
        long n = sc.nextLong();
        String s = sc.next();
        long ans = 0;
        int i = 0;
        boolean flag = true;
        while (i < n - 2) {
            if (s.charAt(i) == s.charAt(i + 2)) {
                ans++;
                while (i < n - 2 && s.charAt(i) == s.charAt(i + 2)) i++;
                if (i < n - 2) i++;
            } else {
                ans++;
                i++;
            }
        }
        if (i == n - 2 && s.charAt((int)n - 1) != s.charAt((int)n - 3)) ans++;
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(br);
        int t = 1;
        for (int i = 1; i <= t; i++) {
            solve(sc);
        }
    }
}
