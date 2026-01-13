class Solution {
    public double separateSquares(int[][] squares) {
        double L = 0.0, R = 1e9;
        double Ans = 0.0;
        for(int it = 0; it < 80; it++){
            double mid = L + (R - L) / 2.0;
            double LA = 0.0, UA = 0.0;
            for(int i = 0; i < squares.length; i++){
                double y = squares[i][1];
                double l = squares[i][2];
                double TA = l * l;
                if(y + l <= mid){
                    LA += TA;
                }else if(y >= mid){
                    UA += TA;
                }else{
                    double below = (mid - y) * l;
                    LA += below;
                    UA += TA - below;
                }
            }
            if(LA >= UA){
                Ans = mid;
                R = mid;
            }else{
                L = mid;
            }
        }
        return Ans;
    }
}