package BFS;

import java.util.*;

/**广度优先搜索：
 * 双向广度优先搜索

 */
public class WordLadderII {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int level=1;
        beginQueue.add(beginWord);
        endQueue.add(endWord);
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginQueue.size() > endQueue.size()) {
                Queue<String> queue = new LinkedList<>();
                queue=beginQueue;
                beginQueue=endQueue;
                endQueue = queue;
            }

            Queue<String> temp = new LinkedList<>();
            while(!beginQueue.isEmpty()) {
                String node=beginQueue.poll();
                char[] wordchar = node.toCharArray();
                for (int i=0;i<wordchar.length;i++) {
                    char old = wordchar[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        wordchar[i]=j;
                        String newWord = new String(wordchar);
                        if (endQueue.contains(newWord)) {
                            return level+1;
                        }
                        if (wordList.contains(newWord)&&!visited.contains(newWord) && !beginQueue.contains(newWord)) {
                            temp.add(newWord);
                            visited.add(newWord);
                        }
                        wordchar[i] = old;
                    }
                }
            }
            beginQueue=temp;
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadderII wordLadder = new WordLadderII();
        String [] array={"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(array);
        int num = wordLadder.ladderLength("hit", "cog", list);
        System.out.println(num);
    }
}
