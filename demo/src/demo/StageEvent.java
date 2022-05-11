package demo;

class StageEvent extends Event{

    //Fill your code here
	
	private static Integer 	gst = 15;
	
	private Integer noOfSeats;

    public StageEvent(String name, String type, Double costPerDay, Integer noOfDays, Integer noOfSeats) {
		super(name, type, costPerDay, noOfDays);
		this.noOfSeats = noOfSeats;
	}

	public Double totalCost() {

       //Fill your code here
		Double totalCost = costPerDay * noOfDays;
		Double finalGst = (gst * totalCost) / 100;
		return (totalCost + finalGst) ;
    }
    
    public String toString() {
    	return String.format("Event Details"+"\n"+"Name:"+name+"\n"+"Type:"+type+"\n"+"Number of seats:"+noOfSeats+"\n"+"Total amount:"+totalCost());
   	 
       //Fill your code here
    }
}
