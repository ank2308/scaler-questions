import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRank {
	
	public String[] findRelativeRanks(int[] score) {
        int [] dup = score;
        Arrays.sort(dup);
        Map<Integer, String> rankMap = new HashMap<>();
        for(int i=0;i<dup.length-3;i++){
            rankMap.put(dup(i),""+i+1);
        }
        rankMap.put(dup(dup.length-3),"Bronze Medal");
        rankMap.put(dup(dup.length-2),"Silver Medal");
        rankMap.put(dup(dup.length-1),"Gold Medal");
        String [] ans = new String[score.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = rankMap.get(score[i]);
        }
        return ans;
    }
}
