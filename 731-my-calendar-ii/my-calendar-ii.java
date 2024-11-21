class MyCalendarTwo {

    private List<int[]> overlappingRegion;
    private List<int[]> bookings;
    public MyCalendarTwo() {
        overlappingRegion = new ArrayList<>();
        bookings = new ArrayList<>();
    }
    public boolean book(int start, int end){
        for(int[] region : overlappingRegion){
            if(checkOverlap(region[0], region[1], start, end)){
                return false;
            }
        }
        for(int[] booking : bookings){
            if(checkOverlap(booking[0], booking[1], start, end)){
                overlappingRegion.add(overlappedRegion(booking[0], booking[1], start, end));
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }
    private boolean checkOverlap(int start1, int end1, int start2, int end2){
        return Math.max(start1, start2) < Math.min(end1, end2);
    }
    private int[] overlappedRegion(int start1, int end1, int start2, int end2){
        return new int[]{Math.max(start1, start2), Math.min(end1, end2)};
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */