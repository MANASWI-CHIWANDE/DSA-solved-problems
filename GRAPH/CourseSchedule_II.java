package com.company.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/course-schedule-ii/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adj.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            order[index++] = course;

            for (int prerequisiteCourse : adj.get(course)) {
                indegree[prerequisiteCourse]--;
                if (indegree[prerequisiteCourse] == 0) {
                    q.offer(prerequisiteCourse);
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }
}
