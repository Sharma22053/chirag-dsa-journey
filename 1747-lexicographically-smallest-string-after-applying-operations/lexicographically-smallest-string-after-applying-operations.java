class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visit = new HashSet<>();
        String small = s;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(s);
        visit.add(s);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.compareTo(small) < 0)
                small = current;

            StringBuilder sb = new StringBuilder(current);
            for (int i = 1; i < sb.length(); i+=2) {
                sb.setCharAt(i, (char) ((sb.charAt(i) - '0' + a) % 10 + '0'));

            }
            String newString = sb.toString();
            if (visit.add(newString))
                queue.offer(newString);

            String rotate = current.substring(current.length() - b) + current.substring(0, current.length() - b);

            if(visit.add(rotate)) queue.offer(rotate);
        }
        return small;
    }
}