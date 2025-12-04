class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(n);
        vector<int> vis(n);
        vector<int> ans;
        vector<int> in(n);

        for(int i=0; i<prerequisites.size(); i++){
            graph[prerequisites[i][1]].push_back(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        
        queue<int> q;

        for(int i=0; i<n; i++){
            if(in[i]==0)q.push(i);
        }
        while(!q.empty()){
            int e = q.front();
            vis[e]=1;
            ans.push_back(e);
            q.pop();
            for(int x=0; x<graph[e].size(); x++){
                if(vis[graph[e][x]]==0){ 
                    in[graph[e][x]]--;
                    if(in[graph[e][x]]==0)q.push(graph[e][x]);
                }
            }
        }
        return ans.size() == n ? ans : vector<int>();
    }
};