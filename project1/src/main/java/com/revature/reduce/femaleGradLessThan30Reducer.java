package com.revature.reduce;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class femaleGradLessThan30Reducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable>{

	@Override
	protected void reduce(
			Text key, Iterable<DoubleWritable> arg1, Context context)
					throws IOException, InterruptedException {

		String line=key.toString();
		String [] words = line.split("#");

		//		System.out.println("line = "+line);
		//		System.out.println("words[0] = "+words[0]);
		//		System.out.println("words[2] = "+words[2]);

		int mostRecentYear = Integer.MIN_VALUE;

		if(words[0].contains("Korea")){
			System.out.println();
		}
		int i=4;
		//		if(words.length>3 && words[3].contains("HIAT")) i=3;
		////		else i=7;
		for(; i<words.length; i++){
			//			System.out.println("enter a proper start val for i");

			if(i<words.length && words[i].equals("\"\"")==false && words[i].length()>2){
				mostRecentYear=i;
			}
		}
		if(mostRecentYear!=Integer.MIN_VALUE && words[mostRecentYear].equals("HIAT")==false){

			try{
				double d = Double.parseDouble(words[mostRecentYear]);
				if(d<30.0){
					//			System.out.println("does it work");
					StringWriter sw=new StringWriter();
					sw.write(words[0]+"\t"+words[2]);
					//				System.out.println(sw+"\n"+d);
					context.write(new Text(sw.toString()), new DoubleWritable(d));
				}
			}
			catch(NumberFormatException e){

			}
		}



	}
}