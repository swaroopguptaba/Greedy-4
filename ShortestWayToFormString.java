// Time Complexity : O(m logn);  m - length of target, n - source length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        int sl = source.length();
        int tl = target.length();

        int i = 0; // ptr on target string
        int pos = 0; // ptr on source string

        Map<Character, List<Integer>> map = new HashMap<>();
        int count = 1;

        for(int j = 0 ; j < source.length(); j++){
            char c = source.charAt(j);

            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(j);
        }

        while(i < tl){
            char c = target.charAt(i);
            if(!map.containsKey(c)) return -1;

            if(pos < sl && source.charAt(pos) == c){
                pos++;
                i++;
                continue;
            }

            List<Integer> li = map.get(c);

            //find prev occurence of char pointing in source string
            int k = Collections.binarySearch(li, pos);

            //if ele is present, index is returned, else returns a -ve index
            //where element would have been inserted
            if(k < 0){
                k = Math.abs(k) - 1;
            }

            if (k == li.size()){
                count++;
                pos = 0;
            }
            else{
                i++;
                pos = li.get(k) + 1; //move ahead for next iteration
            }

        }
        return count;
    }
}
