package factors;

import java.util.ArrayList;

public class Eratosthenes {
    //static final ArrayList<Integer> PRIMES = getPrimes(1000);
    
    public static ArrayList<Integer> getPrimes(int n){
        ArrayList<Integer> primesList = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i; i*j <= n; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
            {
                primesList.add((Integer) i);
                //System.out.println(i);
            }        
        }
        isPrime = null;
        System.out.println(primesList.size() + " primes less then " + n + " was found");
        return primesList;
    }
} 