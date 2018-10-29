
package com.revature.map;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.PatternLayout;

/* 
 * To define a map function for your MapReduce job, subclass 
 * the Mapper class and override the map method.
 * The class definition requires four parameters: 
 *   The data type of the input key
 *   The data type of the input value
 *   The data type of the output key (which is the input key type 
 *   for the reducer)
 *   The data type of the output value (which is the input value 
 *   type for the reducer)
 */


//public class WordMapper extends Mapper<LongWritable, Text, Text/*ArrayWritable*/, IntWritable> {
	
	
public class changeInMaleEmployment extends Mapper<LongWritable, Text, Text, DoubleWritable>{// Text, String []>{

	public static AtomicInteger lineNum=new AtomicInteger(0);
	/*
	 * The map method runs once for each line of text in the input file.
	 * The method receives a key of type LongWritable, a value of type
	 * Text, and a Context object.
	 */
	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		
String line = (value.toString());
		




		if(line.contains("EMPL.MA.ZS")){
			
//			if(line.contains("Australia")){
//			System.out.println("\n\n\n"+line.replaceAll("\"", "\\\\\""));
//		}
		
		String line2 = line.replaceAll(", ", " ");
		line2= line.replaceAll("\",\"", "#");
		line2=line2.replaceAll("\",", "");
		line2 = line2.substring(1);
		String[] words = line2.split("#");			
			
			
			
			
			
			
			
//			context.write(new Text("in line contains EMPL.FE.ZS"), (new DoubleWritable(888.0)));
			//
			//			
			//			double maxJ=0;
			//			for(int j=0; j<words.length; j++){
			//				maxJ ++;
			if(words.length>44){
//				context.write(new Text("words.length > 44"), (new DoubleWritable(-1.0)));

				double year2000=Integer.MIN_VALUE;;
				int locOfLastNum=Integer.MIN_VALUE;
				double mostRecent=Integer.MIN_VALUE;
				for(int i=45; i<words.length; i++){

					if(words[44].length()>4){
						year2000 =  Double.parseDouble(words[44]);
					}
					else{
						while(i<words.length && words[i].length()<4 ){//&& words[i].equals("\"\"")==false){
							i++;
						}
						
//						year2000=Double.parseDouble(words[i]);
						if(i<words.length){
//							ztest = words[i];
//							if(ztest.equals("")){
//								System.out.println();
//							}
							year2000=Double.parseDouble(words[i]);
						}
						else break;
					}
					//year2000 must be set
					
//					

					//						int locOfLastNum=Integer.MIN_VALUE;
					for(int j=i; j<words.length; j++){
						if(j<words.length && words[j].length()>4){
							locOfLastNum=j;
						}
					}
					if(locOfLastNum==-2147483648 || words[locOfLastNum].equals("")){
//						System.out.println();
					}
					else mostRecent = Double.parseDouble(words[locOfLastNum]);
					i=words.length;
				}
				if(year2000>Integer.MIN_VALUE && mostRecent>Integer.MIN_VALUE){
				double percentage = ((year2000/mostRecent)-1)*100;
				DoubleWritable dw= new DoubleWritable(new Double(percentage));
				if(words[3].contains("Employment")==false){
					words[3] = words[2].concat(words[3]);
				}
				String out = words[0] + "    "+words[3]+"    ";
//				System.out.println("out = "+out);
				
				if(line.contains("Australia")){
//					System.out.println("\n\n\nout=:\n"+out.replaceAll("\"", "\\\\\"").replaceAll("\\t", "\\\\t"));
				}
				
				context.write(new Text(out), dw);
				}
			}

		}
		else{
//			String s = words[0] +"\t"+ words[1] +"\t"+ words[2] +"\t"+ words[3];
//			context.write(new Text("words.length < 44"+ "\t "+s), (new DoubleWritable(new Double(words.length))));

		}
//	}//lineNum statement
		
	}

	
}