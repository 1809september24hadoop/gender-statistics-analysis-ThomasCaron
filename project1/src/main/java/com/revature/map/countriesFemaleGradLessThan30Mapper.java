

package com.revature.map;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

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


public class countriesFemaleGradLessThan30Mapper extends Mapper<LongWritable, Text, Text, DoubleWritable>{

	/*
	 * The map method runs once for each line of text in the input file.
	 * The method receives a key of type LongWritable, a value of type
	 * Text, and a Context object.
	 */
	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String line = (value.toString());
		


//		if(line.contains("HIAT") && line.contains("FE") && line.contains("BA")){
		if(line.contains("HIAT.BA.FE")){
//			if(line.contains("Armenia")){
//				System.out.println("\n\n\n"+line.replaceAll("\"", "\\\\\""));
//			}
			
			String line2 = line.replaceAll(", ", " ");
			line2= line.replaceAll("\",\"", "#");
			line2=line2.replaceAll("\",", "");
			line2 = line2.substring(1);
			String[] words = line2.split("#");

			
			
//			System.out.println(line2);
			context.write(new Text(line2), new DoubleWritable(-1.0));
			/**context.write(txtOut, new DoubleWritable(0.0));**/
		}

	}
}