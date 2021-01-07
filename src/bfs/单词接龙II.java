package bfs;

import java.util.*;

public class 单词接龙II {


    int size;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        if (wordList.contains(beginWord)) visited[wordList.indexOf(beginWord)]=true;
        HashMap<String, List<String>> hashMap = bfs(visited, beginWord, endWord, wordList);
        backtracking(path,hashMap,endWord);

        return res;
    }

    void backtracking(List<String> path,HashMap<String,List<String>> hashMap,String endWord){
        if (path.get(path.size()-1).equals(endWord) && path.size()==size){
            res.add(new ArrayList<>(path));
        }
        if (path.size()>=size) return;

        List<String> list = hashMap.getOrDefault(path.get(path.size() - 1),new ArrayList<>());
        for (String s : list){
                path.add(s);
                backtracking(path,hashMap,endWord);
                path.remove(path.get(path.size()-1));
        }
    }

    HashMap<String,List<String>> bfs(boolean[] visited,String beginWord,String endWord,List<String> wordList){
        HashMap<String,List<String>> hashMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        size = 0;
        boolean findEndWord = false;
        while (!queue.isEmpty()){
            size++;
            String remove = queue.remove();
            List<Integer> visitedInthisTimes =new ArrayList<>();
            for (int i = 0;i<wordList.size();i++){
                if (!visited[i] && canToword2(remove,wordList.get(i))){
                    List<String> list = hashMap.getOrDefault(remove, new ArrayList<>());
                    if (wordList.get(i).equals(endWord)) {
                        findEndWord = true;
                    }
                    queue.add(wordList.get(i));

                    visitedInthisTimes.add(i);

                    list.add(wordList.get(i));
                    hashMap.put(remove,list);
                }
            }
            for (int i : visitedInthisTimes){
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
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        new 单词接龙II().findLadders("hit","cog",list);
    }
}
