import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        Arrays.sort(points,new Comparator<int[]>() {
            public int compare(int[] o1,int[]o2){
                return o1[1] - o2[1];
            }
        });
        int cnt = 1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>end){
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }
}