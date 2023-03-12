package rao_codefest;
import java.io.*;
import java.util.*;
class Math_Wizard{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		int idx,i=1;
		boolean matches = false;
		double result=0;
			//Read the input file
			try{
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/ISHA/Desktop/TMW_small.txt"));
			String line ="";
			double result_given=0;
			line = br.readLine();
		
			 //read the number of test cases;
			int T = Integer.parseInt(line);
			while(T >0){
				matches = false;
				line = br.readLine();
				// System.out.println(line);
				String st = line;
				st = st.replaceAll("plus","+");
				st = st.replaceAll("substract","-");
				st = st.replaceAll("multiple","*");
				st = st.replaceAll("division","/");
				st = st.replaceAll("equals","=");
				st = st.replaceAll("one","1");
				st = st.replaceAll("two","2");
				st = st.replaceAll("three","3");
				st = st.replaceAll("four","4");
				st = st.replaceAll("five","5");
			    	st = st.replaceAll("six","6");
				st = st.replaceAll("seven","7");
				st = st.replaceAll("eight","8");
				st = st.replaceAll("nine","9");
				// st = st.replaceAll(" ","");
				idx = st.indexOf("=");
				// System.out.println(st);
				// result = Double.parseDouble(evaluate(st.substring(0,idx)));
                		result = Double.parseDouble(evaluate(st.substring(0,idx))); 				
				result_given = Double.parseDouble(st.substring(idx+1));
				// System.out.println("result = "+result+"		given result = "+result_given);
				// System.out.println(result);
                		// System.out.println(result_given);
				if(result == result_given){
					matches = true;
				}
				System.out.println("Case #"+i+": "+matches);
				i++;
				T--;
			}
			}
			catch(Exception e){
				System.out.println(e);
			}
        }
    
    public static int findIndex(Boolean increment, String[] expressionArray, int index) {
        
        while(0 < index && index < expressionArray.length) {
            if(increment) {
                index += 1;
            }
            else {
                index -= 1;
            }
            if(expressionArray[index] != ""){
                return index;
            }
        }
        return 0;
    }    

    public static String evaluate(String expression){
        String[] expressionArray = expression.split(" ");
		double a,b;
		double result;
        for(int j = 0 ; j < expressionArray.length ; j++){
            if(expressionArray[j].equals("/")){
                int left_index = findIndex(false, expressionArray, j);
                int right_index = findIndex(true, expressionArray, j);
                a = Double.parseDouble(String.valueOf(expressionArray[left_index]));
                b = Double.parseDouble(String.valueOf(expressionArray[right_index]));
                result = (double)a/b;
                expressionArray[j] = Double.toString(result);
                expressionArray[left_index] = "";
                expressionArray[right_index] = "";
            }
            else if (expressionArray[j].equals("*")){
                int left_index = findIndex(false, expressionArray, j);
                int right_index = findIndex(true, expressionArray, j);
                a = Double.parseDouble(String.valueOf(expressionArray[left_index]));
                b = Double.parseDouble(String.valueOf(expressionArray[right_index]));
                result = (double)a*b;
                expressionArray[j] = Double.toString(result);
                expressionArray[left_index] = "";
                expressionArray[right_index] = "";
            }
		}
		
        for(int j = 0 ; j < expressionArray.length ; j++){
            if(expressionArray[j].equals("+")){
                int left_index = findIndex(false, expressionArray, j);
                int right_index = findIndex(true, expressionArray, j);               
                a= Double.parseDouble(String.valueOf(expressionArray[left_index]));
                b= Double.parseDouble(String.valueOf(expressionArray[right_index]));
                result = (double)a+b;
                expressionArray[j] = Double.toString(result);
                expressionArray[left_index] = "";
                expressionArray[right_index] = "";
            }
            else if (expressionArray[j].equals("-")){
                int left_index = findIndex(false, expressionArray, j);
                int right_index = findIndex(true, expressionArray, j);
                a= Double.parseDouble(String.valueOf(expressionArray[left_index]));
                b= Double.parseDouble(String.valueOf(expressionArray[right_index]));
                result = (double)a-b;
                expressionArray[j] = Double.toString(result);
                expressionArray[left_index] = "";
                expressionArray[right_index] = "";
            }
		}
        
        for (String element: expressionArray) {
            if(!element.equals(""))
            {
                return element;
            }
        }
        return "";
	}
}
