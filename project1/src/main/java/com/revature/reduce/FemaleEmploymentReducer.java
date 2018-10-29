package com.revature.reduce;
//package com.revature.femaleEmployment;
//
//import java.io.IOException;
//
//import org.apache.hadoop.io.ArrayWritable;
//import org.apache.hadoop.io.DoubleWritable;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.Reducer;
//import org.apache.hadoop.mapreduce.Reducer.Context;
//
//public class FemaleEmploymentReducer extends Reducer<ArrayWritable /*Text*/, IntWritable, Text, IntWritable> {
//
//
//
//
//	/*
//	 * The reduce method runs once for each key received from
//	 * the shuffle and sort phase of the MapReduce framework.
//	 * The method receives a key of type Text, a set of values of type
//	 * IntWritable, and a Context object.
//	 */
//	@Override
//	public void reduce(ArrayWritable key, Iterable<IntWritable> values, Context context)
//			throws IOException, InterruptedException {
//		int wordCount = 0;
//
//		/*
//		 * For each value in the set of values passed to us by the mapper:
//		 */
//		
//		// column 44 == year 2000
//		////60
//		String[] str =  (String[]) key.toArray();
//		
//		if(str[44].length()>4){
//			double year2000 = Double.parseDouble(str[44]);
//			
//			int locOfLastNum=Integer.MIN_VALUE;
//			for(int i=45; i<str.length; i++){
//				if(str[i].length()>4) locOfLastNum=i;
//			}
//			double mostRecent = Double.parseDouble(str[locOfLastNum]);
//			
//			double percentage = (year2000/mostRecent)*100;
//		
//			/*
//			 * Call the write method on the Context object to emit a key
//			 * and a value from the reduce method. 
//			 */
//			context.write(key, new DoubleWritable(percentage));
//		}
//		
//		
//		
//
//		
//	}
//}