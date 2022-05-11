package demo;

class Exhibition extends Event {
	
    public Exhibition(String name, String type, Double costPerDay, Integer noOfDays, Integer noOfStalls) {
		super(name, type, costPerDay, noOfDays);
		this.noOfStalls = noOfStalls;
	}


	@Override
	 public String toString() {
	       //Fill your code here
	    return String.format("Event Details"+"\n"+"Name:"+name+"\n"+"Type:"+type+"\n"+"Number of stalls:"+noOfStalls+"\n"+"Total amount:"+totalCost());
	 }


	//Fill your code here
    private static int gst=5;
    private int noOfStalls;
    
    
   
    public int getNoOfStalls() {
		return noOfStalls;
	}


	public void setNoOfStalls(int noOfStalls) {
		this.noOfStalls = noOfStalls;
	}


	public Double totalCost() {

       //Fill your code here
	   Double totalCost = costPerDay * noOfDays;
	   Double finalGst = (gst * totalCost) / 100;
	   return (totalCost + finalGst) ;
    }


	public static int getGst() {
		return gst;
	}


	public static void setGst(int gst) {
		Exhibition.gst = gst;
	}
    
    
    
}