import java.util.ArrayList;

public class Permutation {

	private ArrayList<ArrayList<Integer>> permutations=new ArrayList<>();
	
	public static void main(String[] args) {
        
        Permutation pm = new Permutation();
        System.out.println(pm.solve(7));
        
    }
	
	public int solve(int A) {
		ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
        for (int i = 1; i < A; i++) {
			b.add(i);
		}
        permu(a, b);
        int req = (int) Math.pow(2, A) - 1;
        int sum = 0;
        for (ArrayList<Integer> numList : permutations) {
        	int efficiency = 0;
        	int temp = 0;
			for (Integer num : numList) {
				efficiency++;
				int tempVal1 = (int) Math.pow(2, num-1);
				int tempVal = tempVal1 + (1<<num);
				temp = temp ^ tempVal;
				temp = temp | tempVal;
				if((req^temp) == 0) {
					sum = sum + efficiency;
					break;
				}
			}
		}
        return sum;
	}

    public void permu(ArrayList<Integer> prefix,ArrayList<Integer> value) {
        if(value.size()==0) {
            permutations.add(prefix);
        } else {
            for(int i=0;i<value.size();i++) {
                ArrayList<Integer> a=new ArrayList<Integer>();
                a.addAll(prefix);
                a.add(value.get(i));

                ArrayList<Integer> b=new ArrayList<Integer>();

                b.addAll(value.subList(0, i));
                b.addAll(value.subList(i+1, value.size()));

                permu(a,b);
            }
        }
    }
}
