package midd;

public class 前缀树 {

}
class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children=new Trie[26];
        isEnd=false;
    }

    public void insert(String word) {
        Trie node=this;
        char[] chars=word.toCharArray();
        for(char ch : chars){
            int index=ch-'a';
            if(node.children[index]==null){
                node.children[index]=new Trie();
            }
            node=node.children[index];
        }
        node.isEnd=true;

    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
    //额外增加的函数。返回前缀的最后一个结点。或者无前缀返回null
    private Trie searchPrefix(String prefix){
        Trie node=this;
        char[] chars=prefix.toCharArray();
        for(char ch : chars){
            int index=ch-'a';
            if(node.children[index]==null){
                return null;
            }
            node=node.children[index];
        }
        return node;

    }
}
