import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0L;
        int n = nums.length;

        Map<Integer, Long>[] maps = new HashMap[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<Integer, Long>();
        }
        maps[0].put(nums[0], 1L);
        if (nums[0] == k) {
            res++;
        }
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            Map<Integer, Long> prev = maps[i - 1];
            Map<Integer, Long> cur = maps[i];

            for (Map.Entry<Integer, Long> e : prev.entrySet()) {
                int key = e.getKey();
                long val = e.getValue();
                if ((key & x) == k) {
                    res += val;
                    long c = cur.getOrDefault(k, 0L);
                    c += val;
                    cur.put(k, c);
                } else {
                    if (check((x & key), k)) {
                        long c = cur.getOrDefault((x & key), 0L);
                        c += val;
                        cur.put((x & key), c);
                    }
                }
            }
            if(check(x , k)){
                long c = cur.getOrDefault(x, 0L);
                c++;
                cur.put(x, c);
                if (x == k) {
                    res++;
                }
            }
        }


        return res;
    }

    boolean check(int a, int k) {
        for (int i = 0; i < 32; i++) {
            if ((k & (1 << i)) != 0) {
                if ((a & (1 << i)) == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}


