package com.revature.reduce;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class avgIncreaseInFemaleEducationReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable>{

		@Override
		protected void reduce(
				Text key, Iterable<DoubleWritable> arg1, Context context)
						throws IOException, InterruptedException {
			
			String line = (key.toString());

			if(line.contains("TER") && line.contains("CUAT") && line.contains("FE")){				
				String line2 = line.replaceAll(", ", " ");
				line2= line.replaceAll("\",\"", "#");
				line2=line2.replaceAll("\",", "");
				String[] words = line2.split("#");
				
				
				/*
				 * now that all lines that are not about the USA are filtered out,
				 * 			--> make an average aggregate function 
				 * 			--> make an output formatter ((optional)
				 */



				double avg = Double.MIN_NORMAL;
//		add this once requirements are met			int index=0, avgCount=0;
				
				String strout="";
//		add this once requirements are met			ArrayList<Integer> yeararr = new ArrayList<>();
//				strarr.add("United States    ");
//				strarr.add(words[2]+":    ");
				
				int year2000loc = 44;
//				double year2000num = Double.MIN_NORMAL;
//				double mostRecentYear = Double.MIN_NORMAL;
				
				int firstnumLoc=-1, lastnumLoc=-1;
				
				
				
				for(int i=year2000loc; i<words.length; i++){
					if(firstnumLoc==-1){
						
						try {
							double curNum = Double.parseDouble(words[i]);
							firstnumLoc=i;
							}						

						catch (NumberFormatException ex){
						}
					}
					else if(firstnumLoc!=-1 && lastnumLoc==-1){
						
						try {
							double curNum = Double.parseDouble(words[i]);
							lastnumLoc=i;
							}						

						catch (NumberFormatException ex){
						}
					}
					
				}
				if(firstnumLoc!=-1 && lastnumLoc!=-1){
					double firstNum = Double.parseDouble(words[firstnumLoc]);
					double lastNum = Double.parseDouble(words[lastnumLoc]);
					
					System.out.println("text part\n"+(words[0]+"   Average Increase in: "+ words[2]+":  "));
					System.out.println("dw part\n"+((firstNum+lastNum)/2));
					context.write(new Text(words[0]+"   Average Increase in: "+ words[2]+":  "), new DoubleWritable((firstNum+lastNum)/2));

				}
			
			







		}
		}
}

	






















