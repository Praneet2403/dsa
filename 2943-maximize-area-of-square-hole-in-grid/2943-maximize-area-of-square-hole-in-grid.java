class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int consecutiveHbars = 1;
        int consecutiveVbars = 1;


        int currH = 1;
        for(int i =1; i< hBars.length; i++) {
            if(hBars[i] == hBars[i-1] +1) {
                currH++;
            } else {
                currH = 1;
            }

            consecutiveHbars = Math.max(consecutiveHbars, currH);
        }

        int currV = 1;
        for(int i =1; i< vBars.length; i++) {
            if(vBars[i] == vBars[i-1] +1) {
                currV++;
            } else {
                currV = 1;
            }

            consecutiveVbars = Math.max(consecutiveVbars, currV);
        }


        int width = Math.min(consecutiveHbars + 1, consecutiveVbars + 1);
        return width*width;


    }
}