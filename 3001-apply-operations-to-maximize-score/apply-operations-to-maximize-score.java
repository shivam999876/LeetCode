import java.util.*;

class Solution {
    private static final long MOD = 1000000007;

    private void calculateScore(int[] nums, List<Long> score) {
        for (int ele : nums) {
            long count = 0;
            int num = ele;
            for (int i = 2; i * i <= num; ++i) {
                if (num % i == 0) {
                    count++;
                    while (num % i == 0) {
                        num /= i;
                    }
                }
            }
            if (num > 1) count++;
            score.add(count);
        }
    }

    private void calculateSubarrayCountPerScore(List<Long> score, long[] subarrayCount) {
        int n = score.size();
        int[] pge = new int[n];
        Arrays.fill(pge, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && score.get(stack.peek()) < score.get(i)) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pge[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && score.get(stack.peek()) <= score.get(i)) {
                stack.pop();
            }
            int nge = stack.isEmpty() ? n : stack.peek();
            long count = (long) (nge - i) * (i - pge[i]);
            subarrayCount[i] = count;
            stack.push(i);
        }
    }

    private long binaryExponentiation(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        List<Long> score = new ArrayList<>();
        int[] numArray = nums.stream().mapToInt(i -> i).toArray();
        calculateScore(numArray, score);

        long[] subarrayCount = new long[n];
        calculateSubarrayCountPerScore(score, subarrayCount);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < n; ++i) {
            maxHeap.offer(new int[]{numArray[i], i});
        }

        long res = 1;
        while (k > 0 && !maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int num = curr[0];
            int idx = curr[1];
            long cnt = Math.min(k, subarrayCount[idx]);
            res = (res * binaryExponentiation(num, cnt)) % MOD;
            k -= cnt;
            if (k == 0) break;
        }
        return (int) res;
    }
}