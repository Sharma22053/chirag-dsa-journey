class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[] { t, y });
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[] { t, x });
        }
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[] { 0, 0 });
        queue.offer(new int[] { firstPerson, 0 });

        while (!queue.isEmpty()) {
            int[] personTime = queue.poll();
            int person = personTime[0], time = personTime[1];
            if (time > earliest[person]) continue;
            for (int[] nextpersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextpersonTime[0], nextperson = nextpersonTime[1];
                if (t >= time && earliest[nextperson] > t) {
                    earliest[nextperson] = t;
                    queue.offer(new int[] { nextperson, t });
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliest[i] != Integer.MAX_VALUE) {
                answer.add(i);
            }
        }
        return answer;

    }
}
