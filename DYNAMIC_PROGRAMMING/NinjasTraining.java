package com.company.dynamicProgramming;

import java.util.Arrays;

/*
https://www.codingninjas.com/studio/problems/ninja%E2%80%99s-training_3621003?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
 A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated with performing an activity each day. The same activity can’t be performed on two consecutive days. We need to find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that particular day. Our task is to calculate the maximum number of merit points that the ninja can earn.
 */
public class NinjasTraining {
    private static int spaceOptimization(int points[][],int n){
        int[] previous =new int[4];
        previous[0]=Math.max(points[0][1],points[0][2]);
        previous[1]=Math.max(points[0][0],points[0][2]);
        previous[2]=Math.max(points[0][1],points[0][0]);
        previous[3]=Math.max(points[0][1],Math.max(points[0][0],points[0][2]));

        for(int day = 1;day<n;day++){
            int[] temp = new int[4];
            for(int lastTaskDone = 0;lastTaskDone<4;lastTaskDone++){
                temp[lastTaskDone]=0;
                for(int currTask=0;currTask<3;currTask++){
                    if(currTask!=lastTaskDone){
                        int ptsEarned = points[day][currTask]+previous[currTask];
                        temp[lastTaskDone]=Math.max(temp[lastTaskDone],ptsEarned);
                    }
                }
            }
            previous=temp;
        }
        return previous[3];
    }
    private static int tabulation(int points[][],int n){
        int[][] dp = new int[n][4];
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][1],points[0][0]);
        dp[0][3]=Math.max(points[0][1],Math.max(points[0][0],points[0][2]));

        for(int day = 1;day<n;day++){
            for(int lastTaskDone = 0;lastTaskDone<4;lastTaskDone++){
                dp[day][lastTaskDone]=0;
                for(int currTask=0;currTask<3;currTask++){
                    if(currTask!=lastTaskDone){
                        int ptsEarned = points[day][currTask]+dp[day-1][currTask];
                        dp[day][lastTaskDone]=Math.max(dp[day][lastTaskDone],ptsEarned);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    private static int recursion(int[][] dp,int points[][],int day, int lastTaskDone){
        if(dp[day][lastTaskDone]!=-1)return dp[day][lastTaskDone];
        if(day==0){
            int maxi =0;
            for(int i=0;i<3;i++){
                if(i!=lastTaskDone){
                    maxi = Math.max(maxi,points[0][i]);
                }
            }
            return dp[day][lastTaskDone]=maxi;
        }
        int maxi =0;
        for(int i=0;i<=2;i++){
            if(i!=lastTaskDone){
                int ptsEarned = points[day][i]+recursion(dp,points,day-1,i);
                maxi=Math.max(ptsEarned,maxi);
            }
        }
        return dp[day][lastTaskDone]=maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp = new int[n][4];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return recursion(dp,points,n-1,3);
    }

    public static void main(String[] args) {
        int[][] points = {{10,40,70},
                          {20,50,80},
                          {30,60,90}};

        int n = points.length;
        //System.out.println(ninjaTraining(n, points));
        //System.out.println(tabulation(points,n));
        System.out.println(spaceOptimization(points,n));
    }

}
