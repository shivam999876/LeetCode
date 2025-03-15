class DisjointSet
{
    int *parent;
    int *treeSize;
    int n;

public:
    DisjointSet(int n)
    {
        this->n = n;
        parent = new int[n];
        treeSize = new int[n];

        for (int i = 0; i < n; i++)
        {
            parent[i] = i;
            treeSize[i] = 1;
        }
    }

    //*returns root of the tree containing x (returns the identifier of the set containing x)
    //*Path compression: make the root of the tree parent of all nodes in the path from root to x

    int find(int x)
    {
        // doesnt exist
        if (x < 0 || x >= this->n)
            return -1;

        if (x == parent[x])
            return x;

        int root = find(parent[x]);

        //*for path compression: make the root of the tree parent of x
        parent[x] = root;

        return root;
    }

    bool connected(int x, int y)
    {
        return find(x) == find(y);
    }

    void doUnion(int x, int y)
    {
        int root1 = find(x);
        int root2 = find(y);

        if (root1 == root2)
            return;

        if (this->treeSize[root1] <= this->treeSize[root2])
        {
            parent[root1] = root2;
            this->treeSize[root2] += this->treeSize[root1];
        }
        else
        {
            parent[root2] = root1;
            this->treeSize[root1] += this->treeSize[root2];
        }
    }
};


class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {

        /*
        Intuition: 
        For a directed tree(according to the question) every node has indegree 1 (except root has indegree 0).
        After adding an extra edge, indegree of a node will increase, and there will be an undirected cycle.

        case1: the extra edge falls on root
            After this case all nodes will have indegree 1
            For any edge <e> in the undirected cycle, if we remove that edge e, then
            the remaining edges will still form a directed tree rooted at e.target

        case2: the extra edge falls on non-root node
            After this case one node(say <u>) will have indegree 2
            Now there are two edges <e1> and <e2> which falls on <u>. Atleast one of them must be on the undirected cycle.
            If only one edge is on the directed cycle, then that edge is the answer.
            Otherwise, if both the edges are on the directed cycle, then removing any of them
                 will convert the graph to directed tree. so any of them can be answer.      
        



        ====================================================
                        Pseudo Algorithm:
        ====================================================
        1. Count the indegress of all ndoes
        2. if no node has indegree 2 (i.e, all nodes have indegree 1)
        3.      find an edge, adding which creates cycle --> it is the answer (dynamic connectivity)
        4. else
        5.      find the 2 edges e1 and e2 for which the "to"/"incident" node has indegree 2 (e2 is after e1 in the list here)
        6.      if e2 is on undirected cycle (determine by dynamically adding edges except e2, then add e2 at last and check
                                                                            --> similar to dynamic connectivity using disjoint set)
        7.          e2 is the answer here
        8.      else //e1 must be in undirected cycle if e2 is not in
        9.          e1 is the answer    

        */

        int n = 0;
        for(const auto &e : edges)
        {
            n = max(n, e[0]);
            n = max(n, e[1]);
        }    
        DisjointSet ds(n);
        
        vector<int> indeg(n, 0);
        int maxIndeg = 0;
        for(const auto &e: edges)
        {
            int v = e[1] - 1;

            indeg[v]++;
            maxIndeg = max(maxIndeg, indeg[v]);
        }



        //CASE1: 
        if(maxIndeg == 1)
        {
            vector<int> res = {-1,-1};

            //find the last edge in the list that causes bicycle in the dynamically growing graph
            for(const auto &e : edges)
            {
                int u = e[0] - 1;
                int v = e[1] - 1;

                if(ds.connected(u, v))
                    res = {u+1, v+1};

                ds.doUnion(u, v);    
            }

            return res;
        }
        //CASE2:
        else
        {
            //let e1 and e2 be the 2 edges which have incident node with indegree == 2
            //let e2 be after e1 in the given list
            vector<int> e1 = {-1, -1};
            vector<int> e2 = {-1, -1};
            for(const auto &e : edges)
            {
                int u = e[0] - 1;
                int v = e[1] - 1;

                if(indeg[v] == 2)
                {
                    if(e1 == vector<int>({-1,-1}) )
                        e1 = {u,v};
                    else
                        e2 = {u,v};    
                }
            }


            
            //now check if e2 causes bicycle in the graph

            //add all edges in a graph except e2
            for(const auto &e : edges)
            {
                int u = e[0] - 1;
                int v = e[1] - 1;

                if(e2 != vector<int>({u,v}) )
                    ds.doUnion(u, v);
            } 

            //now check if adding the edge e2 causes bicycle or not
            if(ds.connected(e2[0], e2[1]))
                return {e2[0] + 1, e2[1] + 1};
            else
                return {e1[0] + 1, e1[1] + 1};     

        }

    }
};




/*
[[2,1],[3,1],[4,2],[1,4]]

*/