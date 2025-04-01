class Solution {
    private long findMaxPoints(int[][] questions, int pos, long[] mem) {
        if (pos >= questions.length) {
            return 0;
        }
        if (mem[pos] != -1) {
            return mem[pos];
        }
        
        long exclude = findMaxPoints(questions, pos + 1, mem);
        long include = questions[pos][0] + findMaxPoints(questions, pos + questions[pos][1] + 1, mem);
        mem[pos] = Math.max(exclude, include);
        return mem[pos];
    }
    
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] mem = new long[n];
        Arrays.fill(mem, -1);
        return findMaxPoints(questions, 0, mem);
    }
}