package BFS;

import java.util.*;

/**
 * 双向广度优先搜索算法是对广度优先算法的一种扩展。广度优先算法从起始节点以广度优先的顺序不断扩展，直到遇到目的节点；
 * 而双向广度优先算法从两个方向以广度优先的顺序同时扩展，一个是从起始节点开始扩展，另一个是从目的节点扩展，
 * 直到一个扩展队列中出现另外一个队列中已经扩展的节点，也就相当于两个扩展方向出现了交点，那么可以认为我们找到了一条路径。
 * 双向广度优先算法相对于广度优先算法来说，由于采用了从两个跟开始扩展的方式，搜索树的深度得到了明显的减少，
 * 所以在算法的时间复杂度和空间复杂度上都有较大的优势！
 * */
public class TwoWayBFS {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int level=0;
        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();

        beginQueue.add(beginWord);
        endQueue.add(endWord);

        Set<String>[] visited=new HashSet[2];
        visited[0] = new HashSet<>();
        visited[1] = new HashSet<>();

        while (true) {
            Queue<String> beginNextQueue = new LinkedList<>();
            while (!beginQueue.isEmpty()) {
                String word=beginQueue.poll();
                visited[0].add(word);
                beginNextQueue.addAll(nextNodes(word,wordList,visited[0]));
            }
            beginQueue.addAll(new HashSet<>(beginNextQueue));
            Queue<String> endNextQueue = new LinkedList<>();
            while (!endQueue.isEmpty()) {
                String word=endQueue.poll();
                visited[1].add(word);
                endNextQueue.addAll(nextNodes(word,wordList,visited[1]));
            }
            endQueue.addAll(new HashSet<>(endNextQueue));

            level++;
            for (String node : visited[0]) {
                if (endQueue.contains(node)) {
                    return 2*level;
                }
            }
            for (String node:beginNextQueue) {
                if (endNextQueue.contains(node)) {
                    //find it!
                    return 2*level+1;
                }
            }

        }

    }

    public Queue<String> nextNodes(String word, List<String> wordList,Set<String> visited) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited1 = new HashSet<>(visited);
        //queue.add(word);
        for (int i=0;i<word.length();i++) {
            char[] wordChar = word.toCharArray();
            char now=wordChar[i];
            for (char j='a';j<='z';j++) {
                if (now==j) continue;
                wordChar[i]=j;
                String newWord = new String(wordChar);
                if (wordList.contains(newWord)&&!visited1.contains(newWord) && !queue.contains(newWord)) {
                    queue.add(newWord);
                    visited1.add(newWord);
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        TwoWayBFS wordLadder = new TwoWayBFS();
        String [] array={"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(array);
        int num = wordLadder.ladderLength("hit", "log", list);
        System.out.println(num);
    }
}
