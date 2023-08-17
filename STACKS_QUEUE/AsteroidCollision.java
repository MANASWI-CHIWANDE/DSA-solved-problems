package com.company.stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/asteroid-collision/
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];

            // Handle the case when the current asteroid is positive or 0 (moving to the right)
            if (current >= 0) {
                stack.push(current);
            } else {
                // Handle the case when the current asteroid is negative (moving to the left)
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -current) {
                    // If the asteroid on the stack is destroyed by the current asteroid, remove it
                    stack.pop();
                }

                // Check if the current asteroid is destroyed or added to the stack
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(current);
                } else if (stack.peek() == -current) {
                    // If the current asteroid and the asteroid on the stack are of equal size, destroy both
                    stack.pop();
                }
            }
        }

        // Convert the stack to the final int[]
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
