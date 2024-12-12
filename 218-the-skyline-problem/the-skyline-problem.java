class TopNode {
    int x;
    int h;
    TopNode next;
    TopNode() {
    }
    TopNode(int x, int h) {
        this.x = x;
        this.h = h;
    }

    void insert(TopNode n) {
        n.next = next;
        next = n;
    }

}
class Solution {
    static final int LEFT=0, RIGHT=1, HEIGHT=2;
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TopNode head = new TopNode(0,0);
        head.insert(new TopNode(Integer.MAX_VALUE, 0));
        TopNode start = head;
        
        for (int i = 0; i<buildings.length; i++) {
            int[] b = buildings[i];
            int bL = buildings[i][LEFT];
            int bR = buildings[i][RIGHT];
            int bH = buildings[i][HEIGHT];
            while (bL >= start.next.x) { start = start.next;
             } 
            for (TopNode t = start ; bR > t.x; t = t.next) {
                if (bH <= t.h) {
                    continue;
                }

                TopNode stop = t;
                while (stop.next != null && stop.next.x < bR && stop.next.h <= bH ) {
                    stop = stop.next;
                }
                
                if (bL <= t.x) {
                    if (bR >= stop.next.x) {
                        t.next = stop.next;
                        t.h = bH;
                    }
                    else if (t == stop) {
                        t.insert(new TopNode(bR,t.h));
                        t.h = bH;
                        break;
                    }
                    else {
                        stop.x = bR;
                        t.h = bH;
                        t.next = stop;
                        break;
                    }
                }
                else {
                    if (bR >= stop.next.x) {
                        if (t == stop) {
                            t.insert(new TopNode(bL, bH));
                        }
                        else {
                            t.next = stop;
                            stop.x = bL;
                            stop.h = bH;
                        }
                        break;
                    }
                    else if (t == stop) {
                        t.insert(new TopNode(bL,bH));
                        t.next.insert(new TopNode(bR,t.h));
                        break;
                    }
                    else {
                        t.next = stop;
                        t.insert(new TopNode(bL,bH));
                        stop.x = bR;
                        break;
                    }
                }
                t = stop;

            }
        }

        List<List<Integer>> skyline = new ArrayList<>();

        if (head.h == 0)
            head = head.next;
        while (head != null) {
            int height = head.h;
            skyline.add(List.of(head.x, height));
            while ( (head = head.next) != null && head.h == height) {}
        }

        return skyline;
    }

}