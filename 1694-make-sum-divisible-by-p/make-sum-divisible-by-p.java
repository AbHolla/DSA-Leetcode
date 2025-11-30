import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;

        int target = (int)(total % p);
        if (target == 0) return 0; // already divisible

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix before starting

        long prefix = 0;
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int need = (int)((prefix - target + p) % p);

            if (map.containsKey(need)) {
                result = Math.min(result, i - map.get(need));
            }

            map.put((int)prefix, i);
        }

        return result == nums.length ? -1 : result;
    }
}
