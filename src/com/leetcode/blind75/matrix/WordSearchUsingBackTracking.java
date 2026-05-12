package com.leetcode.blind75.matrix;

public class WordSearchUsingBackTracking {

    static boolean[][] visited;

    public static void main(String[] args) {

        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}};
        String word = "oath";
        String word1 = "rain";

        System.out.println(isWordExist(board, word));
        System.out.println(isWordExist(board, word1));

    }

    public static boolean isWordExist(char[][] wordBoard, String word) {

        visited = new boolean[wordBoard.length][wordBoard[0].length];

        for (int i = 0; i < wordBoard.length; i++) {
            for (int j = 0; j < wordBoard.length; j++) {
                if (word.charAt(0) == wordBoard[i][j]) {
                    if (searchWord(wordBoard, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private static boolean searchWord(char[][] wordBoard, String word, int i, int j, int index, boolean[][] visited) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= wordBoard.length || j < 0 || j >= wordBoard[i].length
                || word.charAt(index) != wordBoard[i][j] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if ((searchWord(wordBoard, word, i + 1, j, index + 1, visited))
                || (searchWord(wordBoard, word, i - 1, j, index + 1, visited))
                || (searchWord(wordBoard, word, i, j + 1, index + 1, visited))
                || (searchWord(wordBoard, word, i, j - 1, index + 1, visited))) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

}
