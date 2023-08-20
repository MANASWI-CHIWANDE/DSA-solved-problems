
import java.util.Arrays;

public class FibonnacciNumber {
    //memoisation  TC : O(n)  SC = O(n)+O(n)
    private static int fibMemo(int n,int[] dpMemo ){
        if(n<=1)return n;
        if(dpMemo[n]!=-1)return dpMemo[n];
        return dpMemo[n] = fibMemo(n-1,dpMemo)+fibMemo(n-2,dpMemo);
    }



    public static void main(String[] args) {
        int n=5;
        int[] dpMemo = new int[n+1];
        Arrays.fill(dpMemo,-1);
        System.out.println("using memoisation : " + fibMemo(n,dpMemo));

        //tabulation  TC : O(n)  SC = O(n)
        int[] dpTab = new int[n+1];
        dpTab[0]=0;
        dpTab[1]=1;
        for(int i=2;i<=n;i++){
            dpTab[i]=dpTab[i-1]+dpTab[i-2];
        }
        System.out.println("using Tabulation : " + dpTab[n]);

        //TC : O(n) , SC =O(1)
        int prev2=0;
        int prev=1;
        for(int i=2;i<=n;i++){
            int cur = prev+prev2;
            prev2=prev;
            prev=cur;
        }
        System.out.println("using 2 var : " + prev);
    }
}
