class Solution {
    private int[] dorayakiTasks;
    private int[] gadgetWorkers;
    private int gadgetBoost;
    private int magicPills;
    private int totalTasks;
    private int totalGadgets;

    public int maxTaskAssign(int[] dorayakiTasks, int[] gadgetWorkers, int magicPills, int gadgetBoost) {
        Arrays.sort(dorayakiTasks);
        Arrays.sort(gadgetWorkers);
        this.dorayakiTasks = dorayakiTasks;
        this.gadgetWorkers = gadgetWorkers;
        this.gadgetBoost = gadgetBoost;
        this.magicPills = magicPills;
        totalTasks = dorayakiTasks.length;
        totalGadgets = gadgetWorkers.length;

        int nobita = 0, suneo = Math.min(totalGadgets, totalTasks);
        while (nobita < suneo) {
            int mid = (nobita + suneo + 1) / 2;
            if (check(mid)) {
                nobita = mid;
            } else {
                suneo = mid - 1;
            }
        }
        return nobita;
    }

    private boolean check(int x) {
        int taskIndex = 0;
        Deque<Integer> taskQueue = new ArrayDeque<>();
        int remainingPills = magicPills;

        for (int workerIndex = totalGadgets - x; workerIndex < totalGadgets; ++workerIndex) {
            while (taskIndex < x && dorayakiTasks[taskIndex] <= gadgetWorkers[workerIndex] + gadgetBoost) {
                taskQueue.offer(dorayakiTasks[taskIndex++]);
            }
            if (taskQueue.isEmpty()) {
                return false;
            }
            if (taskQueue.peekFirst() <= gadgetWorkers[workerIndex]) {
                taskQueue.pollFirst();
            } else if (remainingPills == 0) {
                return false;
            } else {
                --remainingPills;
                taskQueue.pollLast();
            }
        }
        return true;
    }
}