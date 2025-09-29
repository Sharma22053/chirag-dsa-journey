class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
       
        DisjoinSet djs = new DisjoinSet(n);
        Map<String,Integer> hmap = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(!hmap.containsKey(email)){
                    hmap.put(email,i);
                } else {
                    djs.unionBySize(i,hmap.get(email));
                }
            }
        }

        List<String>[] mergedMail = new ArrayList[n];
        for(int i=0;i<n;i++){ mergedMail[i] = new ArrayList<>(); }
            for(Map.Entry<String,Integer> it : hmap.entrySet()){
                String mail = it.getKey();
                int node = djs.findParent(it.getValue());
                mergedMail[node].add(mail);
            }
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail[i]);
            result.add(temp);
        }

        return result;
        

    }
}

class DisjoinSet {
    int[] size;
    int[] parent;
    public DisjoinSet(int n){
        size = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

    if(ulp_u == ulp_v){
        return;
    } else if(size[ulp_u] < size[ulp_v]){
        parent[ulp_u] = ulp_v;
        size[ulp_v] += size[ulp_u];
    } else{
        parent[ulp_v] = ulp_u;
        size[ulp_u] += size[ulp_v];
    }
    }
}
