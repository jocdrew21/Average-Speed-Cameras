package online.practice.averageSpeed;

public class Camera {
	
	//distance from each camera, cameraDistance[0] will not be used
	static int cameraDistance[]={0,0,580,900,1390,1885};
	
	int getDistance(int camera){
		
		if(camera==1){
			return cameraDistance[1];
		}
		else if(camera==2){
			return cameraDistance[2];
		}
		else if(camera==3){
			return cameraDistance[3];
		}
		else if(camera==4){
			return cameraDistance[4];
		}
		else if(camera==5){
			return cameraDistance[5];
		}
		else
			return 0;
		
		
	}
	
}
