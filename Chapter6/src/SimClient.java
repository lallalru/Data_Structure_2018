
public class SimClient implements Client {
	
	int id, arrivalTime = -1, startTime = -1, stoptime = -1;
	
	public SimClient(int id, int t) {
		this.id = id;
		arrivalTime = t;
		System.out.println(this + " arrived at time " + t);
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public int getStoptime() {
		return stoptime;
	}
	
	public void setStartTime(int t) {
		this.startTime = t;
	}

	public void setStopTime(int t) {
		this.stoptime = t;
	}
	
	public String toString() {
		return "Client " + id;
	}

}
