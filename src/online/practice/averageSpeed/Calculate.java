package online.practice.averageSpeed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class Calculate 
{
	Vehicle vehicle;
	
	static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	File file = new File("carSpeeds.txt");
	Writer writer = null;
	
	Calculate(){
		
	}

	void readFile(){
		
	try{
		
		BufferedReader in = 
				new BufferedReader(new FileReader(file)); 
		
		String line,time,plates;
		String cam;
		String[] info;
		
		while((line=in.readLine()) != null){
			Vehicle vehicle=new Vehicle();
			//break up each space and place the input into a variable
			info = line.trim().split(" ");
			plates = info[0];
			cam = info[1];
			time = info[2];
		
			//send data to vehicle class
			vehicle.setLicensePlates(plates);
			vehicle.setTime(time);
			vehicle.setCameraNumber(cam);
					
			vehicleList.add(vehicle);
		}
		in.close();
		//sorts vehicles by license plates
		sortVehicles(vehicleList);
		//determines if vehicle is speeding
		calculateSpeed(vehicleList);
		
	}catch(IOException ex){
		System.out.println("There was an error "+ex);
    }
	}
	
	void sortVehicles(ArrayList<Vehicle> v){
		//sorts vehicles by license plates
		Collections.sort(v, new CustomComparator());
	}
	//sorts license Plates
		public class CustomComparator implements Comparator<Vehicle>{

			@Override
			public int compare(Vehicle o1, Vehicle o2) {
				return o1.getLicensePlates().compareTo(o2.getLicensePlates());
			}	
		}
	
	void calculateSpeed(ArrayList<Vehicle> v){
		int cam1,cam2;
		int speed1,speed2;
		int speedLimit= 100;
		
		//Set speedSet = new Set();
		for(int i=0;i<v.size();i++){
			
			//if license plates i and i+1 are equal
			if( i+1 < v.size() && 
					v.get(i).getLicensePlates().equals(v.get(i+1).getLicensePlates())){
				
				cam1 = v.get(i).cameraNumber;
				cam2= v.get(i+1).cameraNumber;
				//set distance traveled between cameras
				v.get(i).setDistanceTraveled(cam1,cam2);
				
				speed1 = v.get(i).getTime();
				speed2 = v.get(i+1).getTime();
				
				
				//calculate speed and if true print is speeding
				if(i+1 < v.size() &&
						v.get(i).isSpeeding(speed1,speed2,speedLimit)){
					System.out.println(v.get(i).getLicensePlates()+" "
						+"was going "+v.get(i).KPH);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Calculate cal = new Calculate();
		cal.readFile();
		
	}

}
