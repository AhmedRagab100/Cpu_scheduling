import java.util.Scanner;

public class SRTF {
	
	String name;
	int arrival_time;
	int burst_time;	
	
	//this function displays all about sjf scheduling
	public void Display_menu() {
        Scanner sc = new Scanner(System.in);
       /* System.out.println("enter number of processes: ");
        int n=sc.nextInt();
        process processlist[] = new process[n];
        for(int i=0; i<n; i++) {
        	 
        	   System.out.println("Enter name of process " + (i+1));
               name = sc.next();
               System.out.println("Enter arival time of process" + (i+1));
               arrival_time = sc.nextInt();
               System.out.println("Enter brust time of process" + (i+1));
               burst_time = sc.nextInt();
               processlist[i] = new process(name, arrival_time, burst_time);
        }
       */
        //(Name,arrive,burst)
        process processlist[] = new process[4];  
        processlist[0] = new process("p1", 0, 8);
        processlist[1] = new process("p2", 1, 4);
        processlist[2] = new process("p3", 2, 9);
        processlist[3] = new process("p4", 3, 5);
         
        
        int index = 0;
        int cur_time=0;
        int TotalBurstTime=0;
        for(int j=0;j<processlist.length;j++) {
        	
        	TotalBurstTime=TotalBurstTime+processlist[j].getBurst_time();
        }
        for (int i = 0; i < TotalBurstTime; i++) {
            index = get_shortest(processlist, cur_time); //get shortest burst time
            processlist[index].setStart(cur_time);
            processlist[index].setEnd(1  + processlist[index].getStart());
            System.out.println(processlist[index].view());
          
            if (processlist[index].getBurst_time()<=1) {
            processlist[index].setState(false);
            
            }
            else {
            	
            	processlist[index].setBurst_time(processlist[index].getBurst_time()-1);
            	
            }
         
            cur_time = cur_time + 1 ;
           
        
        }
      
  }
	
	//return shortest burst time
	  public int get_shortest(process processlist[],int cur_time) {
		  int shortest = 1000;
	       int index = 0 ;
	       
	       for(int i=0; i<processlist.length;i++) {
	    	   if(processlist[i].getArrival_time()<=cur_time && processlist[i].isState()==true) {
	    		   if(processlist[i].getBurst_time()<shortest) {
	    			   index=i;
	    			   shortest = processlist[i].getBurst_time();
	    		   }
	    		   else if(processlist[i].getBurst_time()==shortest) {
	    			   if(processlist[i].getArrival_time()<processlist[index].getArrival_time()) {
	    				   index=i;
	    				   shortest = processlist[i].getBurst_time();
	    			   }
	    		   }
	    	   }
	       }
	       
	    /*
	      //solve starvation
	       int max_burst=0;
	       int max_index=0;
	      
	        for (int i = 0; i < processlist.length; i++) { //get max burst time
	        		if (processlist[i].getBurst_time()>max_burst && processlist[i].isState()==true) {
	        			
	        			max_burst = processlist[i].getBurst_time();
	        			max_index =i;
	                    
	                }
	        	
	        }
	        if (processlist[max_index].getBurst_time()>20 && processlist[max_index].isState()==true) {
	       processlist[max_index].setBurst_time(processlist[max_index].getBurst_time() - 1);//burst-1
	        }
	        */
		  return index;
	  }  
}