package online.practice.averageSpeed;

public class Vehicle {

	Camera camera=new Camera();
	String licensePlates;
	int time;
	static int traveled;
	int cameraNumber;
	double KPH;
	
	public int getCameraNumber() {
		return cameraNumber;
	}

	public void setCameraNumber(String cameraNumber) {
		this.cameraNumber = Integer.parseInt(cameraNumber);
	}

	public int getTime() {
		return time;
	}
	//format of time look like 22:14:28, need to set time to seconds
	public void setTime(String time) {
		String infoSplit[] = time.split(":");
		int hour = Integer.parseInt(infoSplit[0]);
		int minutes = Integer.parseInt(infoSplit[1]);
		int seconds = Integer.parseInt(infoSplit[2]);
		this.time = (hour * 60 * 60) + (minutes * 60) + (seconds);
		
	}

	public String getLicensePlates() {
		return licensePlates;
	}

	public void setLicensePlates(String licensePlates) {
		this.licensePlates = licensePlates;
	}

	static public int distanceTraveled(){
		
		return traveled;
	}
	
	public void setDistanceTraveled(int cam1,int cam2){
		
		int distance = camera.getDistance(cam2) 
				- camera.getDistance(cam1);
		
		traveled = distance;
	}
	
	public boolean isSpeeding(int time1, int time2, int speedLimit){
		//speed is in KPH
		int metersPerSecond = (distanceTraveled()/(time2-time1));
		KPH = metersPerSecond / 0.2777;
		
		if(KPH > speedLimit)
		return true;
		else
		return false;
	}
	
}
