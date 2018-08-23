package BFS;

import java.util.*;

/**广度优先搜索：http://blog.csdn.net/raphealguo/article/details/7523411
 * 单向广度优先搜索，时间复杂度很高
 * Created by andy on 2017/10/2.
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        //HashSet的作用是在O(1)的时间复杂度内取出某个值，或者判断某个值是否存在
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        int length=1;
        int count=1;
        while (!queue.isEmpty()) {
            String word=queue.poll();
            count--;
            visited.add(word);
            char[] wordchar = word.toCharArray();
            for (int j=0;j<word.length();j++) {
                char ex = wordchar[j];
                for (char i='a';i<='z';i++) {
                    wordchar[j]=i;
                    String newWord = new String(wordchar);
                    if (newWord.equals(endWord)) {
                        length++;
                        return length;
                    }
                    if (wordList.contains(newWord)&&!visited.contains(newWord)&&!queue.contains(newWord)) {
                        queue.add(newWord);
                    }
                }
                wordchar[j]=ex;
            }
            //每当count=0的时候，表明当前步数图的所有分支已经走完。搜索层数（length）加一，然后记录当前的queue的长度，
            // 代表当前图的分支数
            if (count == 0) {
                count=queue.size();
                length++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String [] array={"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(array);
        int num = wordLadder.ladderLength("hit", "cog", list);
        System.out.println(num);
    }
}
