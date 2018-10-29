
package com.revature.map;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

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



	public class inflationAndCreditcarduseMapper extends Mapper<LongWritable, Text, Text, Text>{

		/*
		 * The map method runs once for each line of text in the input file.
		 * The method receives a key of type LongWritable, a value of type
		 * Text, and a Context object.
		 */
		@Override
		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {

			String line = (value.toString());
			

			
			if( line.contains("FP.CPI") || line.contains("WP14892.2") || line.contains("WP14892.3") ){				
//				System.out.println(line);
//				System.out.println("\n\n\n"+line.replaceAll("\"", "\\\\\""));
				String line2 = line.replaceAll(", ", " ");
				line2= line.replaceAll("\",\"", "#");
				line2=line2.replaceAll("\",", "");
				line2 = line2.substring(1);
				String[] words = line2.split("#");
				
//				System.out.println(line2);
				


				
				
				
				context.write(new Text(words[0]), new Text(line2));
			}

		}
	}