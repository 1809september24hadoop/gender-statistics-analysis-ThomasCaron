package com.revature.reduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * For the combiner example, the MaxReducer will be our last reducing function.
 * 
 * The SumReducer will work as a Combiner, which would be like an intermediate reduce.
 * 
 * This helps us reuse the same code and use it in a different way.
 *
 */
public class MaxReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	public static volatile String CURRENT_MAX_WORD = null;
	public static volatile int CURRENT_MAX_COUNT = Integer.MIN_VALUE;
	
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		for (IntWritable value : values) {
			//If the value we are getting is more than our current max, replace it
			CURRENT_MAX_COUNT = (value.get() > CURRENT_MAX_COUNT) ? value.get():CURRENT_MAX_COUNT;
			
			//Set the word string if this was the MAX
			CURRENT_MAX_WORD = (value.get() == CURRENT_MAX_COUNT) ? key.toString():CURRENT_MAX_WORD;
		}
		
		context.write(new Text(CURRENT_MAX_WORD), new IntWritable(CURRENT_MAX_COUNT));
	}
}
