import java.io.*; 
import java.util.Scanner;
class European_Township{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		int T=0; //Townships
		int N;	//Houses
		int Total_walls = 0;
		int R=0, H = 0 , S=0;
		float Total_hours =0,acc_qty=0 , reg_qty =0;
		
		String line="";
		String splitBy=","; // TO read comma separated values  
		String [] houses = new String[4];	// To store comma separated values 
		int i =1;
		try{
		// read input text file
		BufferedReader br = new BufferedReader(new FileReader("ET_large.txt"));  
		
		//Read number of townships T
		line = br.readLine();
		T = Integer.parseInt(line);
		
		
		while(T-->0){
			//For each township read number of houses N
			line = br.readLine();
			N = Integer.parseInt(line);
	
			//for each number of houses (N) read 1) total bedrooms 2) R = Roof bed rooms 3) S = Standard rooms 4)H = Victorian style halls
				while(N-->0){
					line = br.readLine();
					houses = line.split(splitBy);
					R = Integer.parseInt(houses[1]);
					S = Integer.parseInt(houses[2]);
					H = Integer.parseInt(houses[3]);
					Total_walls = 3*R + 4*S + 6*H;
					Total_hours = (float)3*Total_walls;
					acc_qty = (float)(0.5)*Total_walls;
					reg_qty = (float)(1.5)*Total_walls;
					
					/**It takes 3 hours to paint 1 wall with (1/3) of accent color and (2/3) of normal color
					for accent color : requires 1.5 litres and  takes 2.5 hours to paint 1 wall.
									   so (1/3) of wall requires 0.5 litres and 5/6 hours
					for regular color : requires 2.25 litres and takes 3.25 hours to paint 1 wall.
									   so (2/3) of wall requires 1.5 litres and 13/6 hours
					total hours = 5/6 + 13/6 = 3 hours;
					accent quantity = 0.5 litres
					normal quantity = 1.5 litres
					**/
	
				}
				System.out.println("Case #"+i+": "+String.format("%.2f",Total_hours)+", "+String.format("%.2f",acc_qty)+", "+String.format("%.2f",reg_qty));
				i++;
			}
		}
		
		catch(Exception e){
			System.out.println(e);
		}
	}
}