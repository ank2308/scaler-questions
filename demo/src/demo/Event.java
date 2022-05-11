package demo;

class Event{
    
    //Fill your code here
    protected String name;
    protected String type;
	protected Double costPerDay;
	protected Integer noOfDays;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getCostPerDay() {
		return costPerDay;
	}
	public void setCostPerDay(Double costPerDay) {
		this.costPerDay = costPerDay;
	}
	public Integer getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}
    
    public Event(String name, String type, Double costPerDay, Integer noOfDays){
        this.name = name;
        this.type = type;
        this.costPerDay = costPerDay;
        this.noOfDays = noOfDays;
    }
}