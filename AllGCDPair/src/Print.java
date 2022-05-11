
public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintSeq printSeq1 = new PrintSeq(1);
		PrintSeq printSeq2 = new PrintSeq(2);
		PrintSeq printSeq3 = new PrintSeq(0);
		
		Thread t1 = new Thread(printSeq1);
		Thread t2 = new Thread(printSeq2);
		Thread t3 = new Thread(printSeq3);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
