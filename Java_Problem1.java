import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1; 
        int n = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }

    public static int val(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += (s.charAt(i) - '0');
        }
        return ans;
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        long ans = n;
        Map<Integer, Integer> mpp1 = new HashMap<>();
        Map<Integer, Integer> mpp2 = new HashMap<>();
        Map<Integer, Integer> mpp3 = new HashMap<>();
        Map<Integer, Integer> mpp4 = new HashMap<>();
        Map<Integer, Integer> mpp5 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val1 = val(arr[i]);
            switch (arr[i].length()) {
                case 1:
                    mpp1.put(val1, mpp1.getOrDefault(val1, 0) + 1);
                    break;
                case 2:
                    mpp2.put(val1, mpp2.getOrDefault(val1, 0) + 1);
                    break;
                case 3:
                    mpp3.put(val1, mpp3.getOrDefault(val1, 0) + 1);
                    break;
                case 4:
                    mpp4.put(val1, mpp4.getOrDefault(val1, 0) + 1);
                    break;
                case 5:
                    mpp5.put(val1, mpp5.getOrDefault(val1, 0) + 1);
                    break;
            }
        }

        ans += countPairs(mpp1);
        ans += countPairs(mpp2);
        ans += countPairs(mpp3);
        ans += countPairs(mpp4);
        ans += countPairs(mpp5);

        for (int i = 0; i < n; i++) {
            int val1 = val(arr[i]);
            if (arr[i].length() == 3) {
                ans += findMatches(val1, arr[i], mpp1, 2);
            } else if (arr[i].length() == 4) {
                ans += findMatches(val1, arr[i], mpp2, 3);
            } else if (arr[i].length() == 5) {
                ans += findMatches(val1, arr[i], mpp3, 4);
                ans += findMatches(val1, arr[i], mpp1, 3, 4);
            }
        }

        System.out.println(ans);
    }

    public static long countPairs(Map<Integer, Integer> mpp) {
        long count = 0;
        for (int val : mpp.values()) {
            if (val > 1) {
                count += (long) val * (val - 1);
            }
        }
        return count;
    }

    public static long findMatches(int val1, String s, Map<Integer, Integer> mpp, int index) {
        long matches = 0;
        int ele1 = val1 - 2 * (s.charAt(index) - '0');
        if (mpp.containsKey(ele1)) {
            matches += mpp.get(ele1);
        }
        int ele2 = val1 - 2 * (s.charAt(0) - '0');
        if (mpp.containsKey(ele2)) {
            matches += mpp.get(ele2);
        }
        return matches;
    }

    public static long findMatches(int val1, String s, Map<Integer, Integer> mpp, int index1, int index2) {
        long matches = 0;
        int ele1 = val1 - 2 * ((s.charAt(index1) - '0') + (s.charAt(index2) - '0'));
        if (mpp.containsKey(ele1)) {
            matches += mpp.get(ele1);
        }
        int ele2 = val1 - 2 * ((s.charAt(0) - '0') + (s.charAt(1) - '0'));
        if (mpp.containsKey(ele2)) {
            matches += mpp.get(ele2);
        }
        return matches;
    }
}
