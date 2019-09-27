class TrieNode{
    String word;
    Map<Character, TrieNode> child;
    public TrieNode(){
        word = null;
        child = new HashMap<>();
    }
}
class TrieTree{
    TrieNode root;
    public TrieTree(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.child.containsKey(word.charAt(i))){
                node.child.put(word.charAt(i), new TrieNode());
            }
            node = node.child.get(word.charAt(i));
        }
        node.word = word;
    }
}
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public boolean isValid(char [][]board,int x, int y){
        return x >=0 && x < board.length && y >=0 && y < board[0].length && board[x][y] != '0';  
    } 
    public void search(char[][]board, int i, int j, TrieNode node, List<String> res){
        int []dx = {1, -1, 0, 0};
        int []dy = {0,  0, 1, -1};
        if(!node.child.containsKey(board[i][j])) return;
        TrieNode child = node.child.get(board[i][j]);
        if(child.word != null){
            if(!res.contains(child.word)){
                res.add(child.word);
            }
        }
        char tmp = board[i][j];
        board[i][j] = '0';
        for(int idx = 0; idx < 4; idx++){
            int newX = i + dx[idx];
            int newY = j + dy[idx];
            if(isValid(board, newX, newY)){
                search(board, newX, newY, child, res);
            }
        }
        board[i][j] = tmp;
    }
    public List<String> findWords(char[][] board, String [] words) {
        // write your code here
        List<String> res = new ArrayList<>();
        TrieTree tree = new TrieTree();
        for(String word: words){
            tree.insert(word);
        }
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[0].length ; j++){
                search(board, i, j, tree.root, res);
            }
        }
        return res;
    }
}
