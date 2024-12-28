class Node{
    Node[] links = new Node[2];
    Node(){}
    public boolean containsKey(int bit){
        return links[bit]!=null;
    }
    public void put(int bit,Node node){
        links[bit]=node;
    }
    public Node get(int bit){
        return links[bit];
    }
}
public class Trie{

    private static Node root;

    public Trie(){
        root = new Node();
    }

    public static  void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = ((num>>i) & 1);
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }

    public  static int find_max(int num){
        int maxi=0;
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = ((num>>i) & 1);
            if(node.containsKey(1-bit)){
                maxi = (maxi | (1<<i));
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return maxi;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();
        for(int i=0;i<nums.length;i++){
            trie.insert(nums[i]);
        }

        int answer=0;
        for(int i=0;i<nums.length;i++){

            answer = Math.max(answer,trie.find_max(nums[i]));
        }

        return answer;
        
    }
}