//Time complexity : O(n)
//Space Complexity : O(1)
//Did it run on leetcode : yes

public class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length == 0) return 0;

        //pick tops[0] and check
        int result = check(tops, bottoms, tops[0]);

        if(result != -1) return result;
        //pick bottom[0] and check
        return check(tops, bottoms, bottoms[0]);

    }

    private int check(int[] tops, int[] bottoms, int target){
        int aRot = 0;
        int bRot = 0;

        for(int i = 0; i < tops.length; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) aRot++;
            if(bottoms[i] != target) bRot++;
        }
        return Math.min(aRot, bRot);
    }
}
