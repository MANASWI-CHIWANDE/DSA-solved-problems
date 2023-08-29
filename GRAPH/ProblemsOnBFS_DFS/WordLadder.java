
import java.util.*;

/*
https://leetcode.com/problems/word-ladder/
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {
    class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create a set to store the words from the wordList
        Set<String> wordSet = new HashSet<>(wordList);

        // Create a queue for BFS traversal
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        // Perform BFS
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            String currWord = curr.word;
            int count = curr.count;

            // Check if the current word is equal to the endWord
            if (currWord.equals(endWord)) {
                return count;
            }

            // Iterate over each character of the current word
            for (int i = 0; i < currWord.length(); i++) {
                char[] charArray = currWord.toCharArray();

                // Try replacing the current character with all possible lowercase letters
                for (char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c;
                    String transformedWord = new String(charArray);

                    // Check if the transformedWord exists in the wordSet
                    if (wordSet.contains(transformedWord)) {
                        // Remove the word from the wordSet to avoid revisiting
                        wordSet.remove(transformedWord);
                        // Add the transformedWord to the queue for further exploration
                        queue.add(new Pair(transformedWord, count + 1));
                    }
                }
            }
        }

        // If the endWord is not found, return 0
        return 0;
    }

}
