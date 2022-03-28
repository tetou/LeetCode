/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    // エラトステネスのふるいを使う
    public int countPrimes(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;
        // prime[i] == 1 <-> iは素数である
        int[] prime = new int[n+1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        prime[2] = 1;
        // 0 1 2 3 4 5 6 7 8 9 10
        // 0 0 1 1 1 1 1 1 1 1 1 
        // 0 0 1 1 0 1 0 1 0 1 0
        // 0 0 1 1 0 1 0 1 0 0 0
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 0) {
                continue;
            } else {
                for (int j = 2*i; j <= n; j+= i) {
                    prime[j] = 0;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (prime[i] == 1) result++;
        }
        return result;
    }
}
// @lc code=end

