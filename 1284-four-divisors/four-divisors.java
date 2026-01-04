class Solution {
    public int sumFourDivisors(int[] nums) {
        int tSum=0;
        for(int n:nums){
            int sum=0;
            int count=0;

            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    int a=i;
                    int b=n/i;

                    if (a == b) break; // perfect square

                    // Case 2: p³ (example: 8 = 2³)
                    if (isPrime(a) && b == a * a) {
                        sum = 1 + a + b + n;
                        count = 1;
                        break;
                    }

                    // Case 1: p × q
                    if (!isPrime(a) || !isPrime(b)) break;
                    sum=1+a+b+n;
                    count=1;
                    break;
                }
            }
            if(count==1){
                tSum+=sum;
            }
        }
        return tSum;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}