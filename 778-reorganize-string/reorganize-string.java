class Solution {
    public String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
        // max heap with char, freq
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                pq.offer(new int[] {i + 'a', charCounts[i]});
            }
        }
        
        StringBuilder str = new StringBuilder();
        int[] block = pq.poll();
        str.append((char) block[0]);
        block[1]--;
        
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            str.append((char) next[0]);
            next[1]--;
            
            if (block[1] > 0) {
                pq.offer(block); // Missing semicolon fixed
            }
            block = next;
        }
        
        if (block[1] > 0) {
            return "";
        } else {
            return str.toString();
        }
    }
}
