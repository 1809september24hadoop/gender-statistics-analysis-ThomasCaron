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


	public class avgIncreaseInFemaleEducationMapper extends Mapper<LongWritable, Text, Text, DoubleWritable>{

		/*
		 * The map method runs once for each line of text in the input file.
		 * The method receives a key of type LongWritable, a value of type
		 * Text, and a Context object.
		 */
		@Override
		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {

			String line = (value.toString());
			

			
			if(line.contains("United States") && (line.contains("HIAT") || line.contains("CUAT"))&& line.contains("FE")){
//				if(line.contains("BA.FE")){		//For debugging
//					System.out.println("\n\n\n"+line.replaceAll("\"", "\\\\\""));
//				}
				String line2 = line.replaceAll(", ", " ");
				line2= line.replaceAll("\",\"", "#");
				line2=line2.replaceAll("\",", "");
				line2 = line2.substring(1);
				String[] words = line2.split("#");
				
				
				
				context.write(new Text(line2), new DoubleWritable(-1.0));
			}

		}
	}