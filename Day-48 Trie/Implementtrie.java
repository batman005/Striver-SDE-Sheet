public class Trie {


    //Initialize your data structure here
    public static final int ALPHABET_SIZE = 26;
     
    // trie node
    public static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
      
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
         
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
    public static TrieNode root;

    Trie() {
        //Write your code here
        root = new TrieNode();
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        //Write your code here
        int level;
        int length = word.length();
        int index;
      
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = word.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
        }
      
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        //Write your code here
        int level;
        int length = word.length();
        int index;
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = word.charAt(level) - 'a';
      
            if (pCrawl.children[index] == null)
                return false;
      
            pCrawl = pCrawl.children[index];
        }
      
        return (pCrawl.isEndOfWord);

    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        //Write your code here
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return true;
        
    }
}