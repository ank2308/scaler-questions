import java.util.Scanner;

public class NonEmptySubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int arLength = sc.nextInt();
        int [] ar = new int [arLength];
        int max = 0;
        for(int i=0; i<arLength;i++){
            ar[i] = sc.nextInt();
            if(ar[i] > max)
            max = ar[i];
        }
        int [] freqAr = new int [max+1];
        for(int i=0; i<arLength;i++){
            freqAr[ar[i]]++;
        }
        int queries = sc.nextInt();
        while(queries > 0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int temp = 0;
            for(int i=0; i<freqAr.length;i++){
                if(freqAr[i]>= start && freqAr[i]<=end)
                temp = temp + (freqAr[i] * i);
            }
            System.out.println(temp);
            queries--;
        }
	}

}
