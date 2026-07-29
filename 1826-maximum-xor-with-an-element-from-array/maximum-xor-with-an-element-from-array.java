class Node{
    Node link[]=new Node[2];

    boolean containsKey(int ind){
        return (link[ind]!=null);
    }

    void put(int ind,Node node){
        link[ind]=node;
    }

    Node get(int ind){
        return link[ind];
    }
}

class Trie{
    Node root;
    Trie(){
        root=new Node();
    }
    void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int set=((num>>i)&1);
            if(!node.containsKey(set)){
                node.put(set,new Node());
            }
            node=node.get(set);
        }
    }

        int getMax(int num){
            Node node=root;
            int maxNum=0;
            for(int i=31;i>=0;i--){
                int set=((num>>i)&1);
                if(node.containsKey(1-set)){
                    maxNum=(maxNum|1<<i);
                    node=node.get(1-set);
                }
                else node=node.get(set);
            }
            return maxNum;
        }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {

        Trie trie=new Trie();
        int ans[]=new int[queries.length];
        Arrays.sort(nums);
        int [][]q2=new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            q2[i][0]=queries[i][0];
            q2[i][1]=queries[i][1];
            q2[i][2]=i;
        }
        Arrays.sort(q2,(a,b)->(a[1]-b[1]));

        int ind=0;
        for(int i=0;i<q2.length;i++){
            while(ind<nums.length && nums[ind]<=q2[i][1]){
                trie.insert(nums[ind]);
                ind++;
            }
            int aind=q2[i][2];
            if(ind==0)ans[aind]=-1;
            else ans[aind]=trie.getMax(q2[i][0]);
        }

        return ans;
    }
}