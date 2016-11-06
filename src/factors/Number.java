package factors;

import static java.lang.Math.sqrt;
import java.util.ArrayList;

public class Number {
    int size = 10000000;
    ArrayList<Integer> primes = Eratosthenes.getPrimes((int) size/2);
    
    public class number{
        int serialNumber;
        int numberOfFactors;
        
        public boolean lessOrEquals(number that) {
            return ((this.numberOfFactors - that.numberOfFactors) <= 0);          
        }
        
        public number(int num){
            serialNumber = num;
            numberOfFactors = findFactors();
        }
      
        private int findFactors(){
            int N = serialNumber;
            int n = 0;
            int sqrt = (int) sqrt(N) + 1;
            ArrayList<Integer[]> factors = new ArrayList<>();
            do{
                int applicant = primes.get(n);
                if (N % applicant == 0){
                        N /= applicant;
                        Integer[] pair = new Integer[2];
                        
                        try{
                            if (applicant != factors.get(factors.size()-1)[0]){
                                
                                pair[0] = applicant;
                                pair[1] = 1;
                                factors.add(pair);
                            }
                            else{
                                factors.get(factors.size()-1)[1]++;
                            }
                        } catch (Exception e) {
                            pair[0] = applicant;
                            pair[1] = 1;
                            factors.add(pair);
                        }
                }
                else n++;
                try {if (primes.get(n) > sqrt) return 2;}
                catch(Exception e) {}
            }while((N > 1)); //(Atkin.PRIMES.get(n) < sqrt) && 
            int allFactors = 1;
            for(Integer[] i : factors) allFactors *= i[1]+1;
            
            return allFactors;
        }
    }
    
    public static void main(String[] args){
        Number N = new Number();
        number[] list = new number[N.size];
        for (int i = 2; i <= N.size+1; i++){
            list[i-2] = N.new number(i);
        }
        System.out.println("All factors of numbers from 2 to " + N.size + " was found.");
        Sort.mergeSort(list);
        //for (number n : list) System.out.println(n.serialNumber + " " + 
        //                                                    n.numberOfFactors);
    }
}
