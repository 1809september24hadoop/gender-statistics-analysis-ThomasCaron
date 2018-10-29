package com.revature.reduce;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class inflationAndCreditcarduseReducer extends Reducer<Text, Text, Text, Text>{

	@Override
	protected void reduce(
			Text key, Iterable<Text> lines, Context context)
					throws IOException, InterruptedException {

		final int arrStartLoc=4;
		int infLoc; //do i need?
		Double inf = null;
		Double Fcreditcard = null;
		Double Mcreditcard = null;
		Double totalCreditcardUse = null;
		String [] words;
		
		ArrayList<String> str2=new ArrayList<>();
		for(Text t : lines){ // for each country, set the three values according to that countrys lines
			 str2.add(t.toString());
			 String l = t.toString();
			 if(t.toString().contains("Arab World")){
				 System.out.println(l);
			 }
		
//			String line=t.toString();
			String line=t.toString();

			words = line.split("#");
			

			if(line.contains("WP14892.2")){	//for setting WP14892.2
				for(int i=arrStartLoc; i<words.length; i++){
					try{
						double val = Double.parseDouble(words[i]);
						Mcreditcard=val;
					}
					catch(NumberFormatException e){

					}
				}
			}
			else if(line.contains("WP14892.3")){	//for setting WP14892.3
				for(int i=arrStartLoc; i<words.length; i++){
					try{
						double val = Double.parseDouble(words[i]);
						Fcreditcard=val;
					}
					catch(NumberFormatException e){

					}
				}
			}
			else{	//for setting fp.cpi 
				for(int i=arrStartLoc; i<words.length; i++){
					try{
						double val = Double.parseDouble(words[i]);
						inf=val;
					}
					catch(NumberFormatException e){

					}
				}
			}
		}//wp14892  data is only in 2014
		
		//			now selected variables are all set

		//green = C.C used in the past year
		//blue = Coming up with emergency funds: very possible,
		//yellow = has a C.C

		
		if(Mcreditcard==null && Fcreditcard==null){
			String spaces ="\n\t";
			String output;		
			
			output =  spaces+
					"Inflation rate of consumer prices (annual %):  "+ inf + spaces
					+ "Percentage of people who used a credit card last year:  " +"No data for this field"
					+"\n";
			
//			if(str2.get(0).contains("Arab World")){
//				System.out.println(output.equals("\n\t"+"Inflation rate of consumer prices (annual %):  "+ "1.85979151317848" + "\n\t"
//						+ "Percentage of people who used a credit card last year:  " +"No data for this field"
//						+"\n"));
//			}
			
//			System.out.println("\n\n\n"+output);
			context.write(new Text(key), new Text(output));
		}
		else if (Mcreditcard==null) {
			totalCreditcardUse=Fcreditcard;
		}
		else if(Fcreditcard==null){
			totalCreditcardUse=Mcreditcard;
		}
		else{
			totalCreditcardUse = (Mcreditcard+Fcreditcard)/2;
			
		


		//now i need to format output
		String spaces ="\n\t";
		String output;		
		
		output =  spaces+
				"Inflation rate of consumer prices (annual %):  "+ inf + spaces
				+ "Percentage of people who used a credit card last year:  " +totalCreditcardUse
				+"\n";
		
		
//		if(str2.get(0).contains("Arab World")){
//			System.out.println(output.equals("\n"+"Inflation rate of consumer prices (annual %):  "+ "1.85979151317848" + "\n"
//					+ "Percentage of people who used a credit card last year:  " +"No data for this field"
//					+"\n"));
//		}
//		System.out.println("\n\n\n"+output);
		context.write(new Text(key), new Text(output));
		
		}
		
		

	}
}
