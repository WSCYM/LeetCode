package bfs;

import java.util.*;

public class 单词接龙II {

    //dfs+bfs超时
    int size;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return res;
        boolean[] visited = new boolean[wordList.size()];
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        if (wordList.contains(beginWord)) visited[wordList.indexOf(beginWord)]=true;
        HashMap<String, Set<String>> hashMap = bfs(visited, beginWord, endWord, wordList);
        backtracking(path,hashMap,endWord);

        return res;
    }

    void backtracking(List<String> path,HashMap<String,Set<String>> hashMap,String endWord){
        if (path.get(path.size()-1).equals(endWord) && path.size()==size){
            res.add(new ArrayList<>(path));
        }
        if (path.size()>=size) return;

        Set<String> set = hashMap.getOrDefault(path.get(path.size() - 1),new HashSet<>());
        for (String s : set){
                path.add(s);
                backtracking(path,hashMap,endWord);
                path.remove(path.get(path.size()-1));
        }
    }

    HashMap<String,Set<String>> bfs(boolean[] visited,String beginWord,String endWord,List<String> wordList){
        HashMap<String,Set<String>> hashMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        size = 1;
        boolean findEndWord = false;
        while (!queue.isEmpty()){
            List<Integer> visitedInThisTimes =new ArrayList<>();
            int curSize = queue.size();
            size++;
            for (int t =0;t<curSize;t++){
                String remove = queue.remove();
                for (int i = 0;i<wordList.size();i++){
                    if (!visited[i] && canToword2(remove,wordList.get(i))){
                        Set<String> set = hashMap.getOrDefault(remove, new HashSet<>());
                        if (wordList.get(i).equals(endWord)) {
                            findEndWord = true;
                        }
                        queue.add(wordList.get(i));
                        visitedInThisTimes.add(i);
                        set.add(wordList.get(i));
                        hashMap.put(remove,set);
                    }
                }
            }
            for (int i : visitedInThisTimes){
                visited[i] = true;
            }
            if (findEndWord) break;
        }
        return hashMap;
    }

    boolean canToword2(String word1,String word2){
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int cnt = 0;
        for (int i = 0;i<chars1.length;i++){
            if (chars1[i]!=chars2[i]){
                cnt++;
            }
            if (cnt>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ted");
        list.add("tex");
        list.add("red");
        list.add("tax");
        list.add("tad");
        list.add("den");
        list.add("rex");
        list.add("pee");
        new 单词接龙II().findLadders("red","tax",list);
    }
}
