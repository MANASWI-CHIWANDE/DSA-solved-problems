
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/course-schedule/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> topSort = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // for getting indegree
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        // adding initial nodes having indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            topSort.add(course);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == course) {
                    int dependentCourse = prerequisites[i][0];
                    indegree[dependentCourse]--;
                    if (indegree[dependentCourse] == 0) {
                        q.add(dependentCourse);
                    }
                }
            }
        }

        return topSort.size() == numCourses;
    }

}
