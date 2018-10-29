package com.revature.test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.revature.map.countriesFemaleGradLessThan30Mapper;
import com.revature.reduce.femaleGradLessThan30Reducer;

public class testCountriesFemaleGradLessThan30 {

	private static final int Iterable = 0;
	/*
	 * Declare harnesses that let you test a mapper, a reducer, and
	 * a mapper and a reducer working together.
	 */
	private MapDriver<LongWritable, Text, Text, DoubleWritable> mapDriver;
	private ReduceDriver<Text, DoubleWritable, Text, DoubleWritable> reduceDriver;
	private MapReduceDriver<LongWritable, Text, Text, DoubleWritable, Text, DoubleWritable> mapReduceDriver;

	
	
//	static String lineIn = "\"Arab World\",\"ARB\",\"Credit card used in the past year, female (% age 15+) [w2]\",\"WP14892.3\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",";
	static String lineIn = ("\"Armenia\",\"ARM\",\"Educational attainment, completed Bachelor's or equivalent, population 25+ years, female (%)\",\"SE.TER.HIAT.BA.FE.ZS\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"19.49775\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",");

//	static Text mapOut = new Text ("Armenia#ARM#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#SE.TER.HIAT.BA.FE.ZS##########################################19.49775###############");		
	static Text mapOut = new Text ("Armenia#ARM#Educational attainment, completed Bachelor's or equivalent, population 25+ years, female (%)#SE.TER.HIAT.BA.FE.ZS##########################################19.49775###############");
	//	static Text expectedOut = new Text("\n\t"+"Inflation rate of consumer prices (annual %):  "+ "1.85979151317848" + "\n\t"+ "Percentage of people who used a credit card last year:  " +"No data for this field"+"\n");	
//	static List<Text> values = new ArrayList<Text>();
	
	/*
	 * Set up the test. This method will be called before every test.
	 */
	@Before
	public void setUp() {
//		values.add(lineOut);
//		values.add(new Text("Arab World#ARB#Credit card used in the past year, male (% age 15+) [w2]#WP14892.2#########################################################"));
//		values.add(new Text("Arab World#ARB#Inflation, consumer prices (annual %)#FP.CPI.TOTL.ZG##############8.26666666599999#15.5282817502668#9.66969548151245#10.3174158877413#11.9892833221051#9.71603274954298##9.62605664613174#10.7585034160146#8.33125575581145#5.4936655143209#8.11639795517108#7.25436179981633#6.7988584474884#4.22241666240771#5.91154496373498#7.74088603961335#8.45146240803874#9.00000000000004#9.3597515895313#9.37034415971454#5.11259890444309#6.54379068524171#4.68130623916414#3.55029585798816#3.12536579655858#2.64862252295795#1.81294613887087#1.87776885342176#1.62564790673542#2.48857875931906#3.79704017606909#3.29932587383915#3.98696025613607#5.17640028869535#11.2706652380848#3.52481380429233#3.98984146401508#4.8292497585421#4.72812072165807#3.27958455105929#2.89156626506023#1.85979151317848#"));




/**
 * 
 * 
 * 
 * 
 * 					START BACK UP HERE
 * 
 * 
 * 
 * 
 */



		/*
		 * Set up the mapper test harness.
		 */
		countriesFemaleGradLessThan30Mapper mapper = new countriesFemaleGradLessThan30Mapper();
		mapDriver = new MapDriver<LongWritable, Text, Text, DoubleWritable>();
		mapDriver.setMapper(mapper);


		/*
		 * Set up the reducer test harness.
		 */
		femaleGradLessThan30Reducer reducer = new femaleGradLessThan30Reducer();
		reduceDriver = new ReduceDriver<Text, DoubleWritable, Text, DoubleWritable>();
		reduceDriver.setReducer(reducer);

		/*
		 * Set up the mapper/reducer test harness.
		 */
		mapReduceDriver = new MapReduceDriver<LongWritable, Text, Text, DoubleWritable, Text, DoubleWritable>();
		mapReduceDriver.setMapper(mapper);
		mapReduceDriver.setReducer(reducer);
	}

	/*
	 * Test the mapper.
	 */
	@Test
	public void testMapper() {

		/*
		 * For this test, the mapper's input will be "1 cat cat dog" 
		 */
//		String str = "\"Arab World\",\"ARB\",\"Credit card used in the past year, female (% age 15+) [w2]\",\"WP14892.3\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",";
//		str
//		String lineOut = ("Armenia#ARM#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#SE.TER.HIAT.BA.FE.ZS##########################################19.49775###############");		
		
		
		mapDriver.withInput(new LongWritable(0), new Text(lineIn));
//
//		/*
//		 * The expected output is "cat 1", "cat 1", and "dog 1".
//		 */
		mapDriver.withOutput(mapOut, new DoubleWritable(-1.0));
//		//		mapDriver.withOutput(new Text("cat"), new IntWritable(1));
//		//		mapDriver.withOutput(new Text("dog"), new IntWritable(1));
//
//		/*
//		 * Run the test.
//		 */
		mapDriver.runTest();
	}

	/*
	 * Test the reducer.
	 */
	@Test
	public void testReducer() {

				List<DoubleWritable> values = new ArrayList<DoubleWritable>();
				values.add(new DoubleWritable(-1.0));
//				values.add(new Text("Arab World#ARB#Credit card used in the past year, male (% age 15+) [w2]#WP14892.2#########################################################"));
//				values.add(new Text("Arab World#ARB#Inflation, consumer prices (annual %)#FP.CPI.TOTL.ZG##############8.26666666599999#15.5282817502668#9.66969548151245#10.3174158877413#11.9892833221051#9.71603274954298##9.62605664613174#10.7585034160146#8.33125575581145#5.4936655143209#8.11639795517108#7.25436179981633#6.7988584474884#4.22241666240771#5.91154496373498#7.74088603961335#8.45146240803874#9.00000000000004#9.3597515895313#9.37034415971454#5.11259890444309#6.54379068524171#4.68130623916414#3.55029585798816#3.12536579655858#2.64862252295795#1.81294613887087#1.87776885342176#1.62564790673542#2.48857875931906#3.79704017606909#3.29932587383915#3.98696025613607#5.17640028869535#11.2706652380848#3.52481380429233#3.98984146401508#4.8292497585421#4.72812072165807#3.27958455105929#2.89156626506023#1.85979151317848#"));
				/*
				 * For this test, the reducer's input will be "cat 1 1".
				 */
//				t1 = Iterable<lineOut>;
				reduceDriver.withInput(mapOut, values);
		
				/*
				 * The expected output is "cat 2"
				 */
				
//				String s = "\n"+"Inflation rate of consumer prices (annual %):  "+ "1.85979151317848" + "\n"
//				+ "Percentage of people who used a credit card last year:  " +"No data for this field"
//				+"\n";
				
				StringWriter sw = new StringWriter();
				sw.write("Armenia"+"\t"+"Educational attainment, completed Bachelor's or equivalent, population 25+ years, female (%)");
//				sw.write("Armenia\\tEducational attainment completed Bachelor's or equivalent population 25+ years female (%)");
				
				reduceDriver.withOutput(new Text(sw.toString()), new DoubleWritable(19.49775));//new Text("cat"), new IntWritable(2));
		
				/*
				 * Run the test.
				 */
				reduceDriver.runTest();
	}

	/*
	 * Test the mapper and reducer working together.
	 */
	@Test
	public void testMapReduce() {
//		
//				/*
//				 * For this test, the mapper's input will be "1 cat cat dog" 
////				 */
				mapReduceDriver.withInput(new LongWritable(0),new Text(lineIn));
//				Text t = new Text("\n\t"+"Inflation rate of consumer prices (annual %):  "+ "1.85979151317848" + "\n\t"+ "Percentage of people who used a credit card last year:  " +"No data for this field"+"\n");	
//
////		
////				/*
////				 * The expected output (from the reducer) is "cat 2", "dog 1". 
////				 */
				
				
				StringWriter sw = new StringWriter();
				sw.write("Armenia"+"\t"+"Educational attainment, completed Bachelor's or equivalent, population 25+ years, female (%)");
//				sw.write("Armenia\\tEducational attainment completed Bachelor's or equivalent population 25+ years female (%)");

				mapReduceDriver.addOutput(new Text(sw.toString()), new DoubleWritable(19.49775));//new Text("cat"), new IntWritable(2));
////		
////				/*
////				 * Run the test.
////				 */
				mapReduceDriver.runTest();
	}
}

