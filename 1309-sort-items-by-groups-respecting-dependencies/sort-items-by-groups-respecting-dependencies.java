
import java.util.*;

class Solution {
    List<List<Integer>> groupItemsGraph; 
    List<List<Integer>> itemsGraph;      
    int[] itemInDegree;
    int[] groupInDegree;

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
       
        int newGroupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = newGroupId++;
            }
        }

       
        buildGroupItemsGraph(newGroupId, group, n);
        buildItemsGraph(n, beforeItems, group, newGroupId);

      
        Queue<Integer> groupQueue = new LinkedList<>();
        for (int i = 0; i < newGroupId; i++) {
            if (groupInDegree[i] == 0) {
                groupQueue.offer(i);
            }
        }

        int[] result = new int[n];
        int index = 0;

        while (!groupQueue.isEmpty()) {
            int groupId = groupQueue.poll();
            List<Integer> itemsInGroup = groupItemsGraph.get(groupId);

            if (itemsInGroup != null && !itemsInGroup.isEmpty()) {
                // Item-level topological sort inside this group
                Queue<Integer> itemQueue = new LinkedList<>();
                for (int item : itemsInGroup) {
                    if (itemInDegree[item] == 0) {
                        itemQueue.offer(item);
                    }
                }

                while (!itemQueue.isEmpty()) {
                    int item = itemQueue.poll();
                    result[index++] = item;

                    for (int neighbor : itemsGraph.get(item)) {
                        itemInDegree[neighbor]--;
                        if (group[neighbor] == groupId) {
                            if (itemInDegree[neighbor] == 0) {
                                itemQueue.offer(neighbor);
                            }
                        } else {
                            // Cross-group dependency
                            if (--groupInDegree[group[neighbor]] == 0) {
                                groupQueue.offer(group[neighbor]);
                            }
                        }
                    }
                }
            }
        }

        return index == n ? result : new int[0];
    }

    private void buildItemsGraph(int n, List<List<Integer>> beforeItems, int[] group, int totalGroups) {
        itemsGraph = new ArrayList<>();
        itemInDegree = new int[n];
        groupInDegree = new int[totalGroups];

        for (int i = 0; i < n; i++) {
            itemsGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j : beforeItems.get(i)) {
                itemsGraph.get(j).add(i);
                itemInDegree[i]++;
                if (group[i] != group[j]) {
                    groupInDegree[group[i]]++;
                }
            }
        }
    }

    private void buildGroupItemsGraph(int totalGroups, int[] group, int n) {
        groupItemsGraph = new ArrayList<>();
        for (int i = 0; i < totalGroups; i++) {
            groupItemsGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            groupItemsGraph.get(group[i]).add(i);
        }
    }
}
