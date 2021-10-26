package basics;

public class PrimeNumber {
    public static int eratos(long n) {
        int cnt = 0;
        boolean[] isPrime = new boolean[(int)n + 1];
        for(int i = 2; i <= n; ++i)
            isPrime[i] = true;

        for(int i = 2; i <= n; ++i){
            if(isPrime[i]){
                ++cnt;
                for(int j = i; (long) j * i <= n; ++j)
                    isPrime[j * i] = false;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(eratos((long)1e6));
    }
}
