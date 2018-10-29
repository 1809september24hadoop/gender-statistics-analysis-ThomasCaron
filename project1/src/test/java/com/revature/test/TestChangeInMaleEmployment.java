package com.revature.test;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

import com.revature.map.changeInMaleEmployment;

public class TestChangeInMaleEmployment {

	private static final int Iterable = 0;
	/*
	 * Declare harnesses that let you test a mapper, a reducer, and
	 * a mapper and a reducer working together.
	 */
	private MapDriver<LongWritable, Text, Text, DoubleWritable> mapDriver;

	
	
//	static String lineIn = "\"Arab World\",\"ARB\",\"Credit card used in the past year, female (% age 15+) [w2]\",\"WP14892.3\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",";
	static String lineIn = ("\"Australia\",\"AUS\",\"Employment in agriculture, male (% of male employment)\",\"SL.AGR.EMPL.MA.ZS\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"9.84000015258789\",\"9.78999996185303\",\"9.14999961853027\",\"9.75\",\"8.97000026702881\",\"8.64999961853027\",\"8.39999961853027\",\"7.8600001335144\",\"8.02000045776367\",\"7.6100001335144\",\"8.03999996185303\",\"7.82999992370605\",\"7.63000011444092\",\"7.65999984741211\",\"7.94999980926514\",\"7.51999998092651\",\"7.28000020980835\",\"7.17000007629395\",\"6.90000009536743\",\"6.8899998664856\",\"6.63000011444092\",\"6.67999982833862\",\"6.44000005722046\",\"6.07999992370605\",\"6.19000005722046\",\"5.90000009536743\",\"5.73000001907349\",\"5.92999982833862\",\"5.98000001907349\",\"5.8899998664856\",\"6.01000022888184\",\"5.94999980926514\",\"5.76999998092651\",\"5.44000005722046\",\"4.94000005722046\",\"4.55999994277954\",\"4.48000001907349\",\"4.26000022888184\",\"4.17000007629395\",\"4.05999994277954\",\"4.07000017166138\",\"4\",\"3.57999992370605\",\"3.52999997138977\",\"3.41000008583069\",\"3.63000011444092\",\"3.3199999332428\",\"3.46000003814697\",");
//	static Text mapOut = new Text ("Armenia#ARM#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#SE.TER.HIAT.BA.FE.ZS##########################################19.49775###############");		
	static Text mapOut = new Text ("Australia"+"    "+"Employment in agriculture, male (% of male employment)SL.AGR.EMPL.MA.ZS"+"    ");
	//	static Text expectedOut = new Text("\n\t"+"Inflation rate of consumer prices (annual %):  "+ "1.85979151317848" + "\n\t"+ "Percentage of people who used a credit card last year:  " +"No data for this field"+"\n");	
//	static List<Text> values = new ArrayList<Text>();
	
	/*
	 * Set up the test. This method will be called before every test.
	 */
	@Before
	public void setUp() {


		/*
		 * Set up the mapper test harness.
		 */
		changeInMaleEmployment mapper = new changeInMaleEmployment();
		mapDriver = new MapDriver<LongWritable, Text, Text, DoubleWritable>();
		mapDriver.setMapper(mapper);


		
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
		mapDriver.withOutput(mapOut, new DoubleWritable(71.96531051056603));
//		//		mapDriver.withOutput(new Text("cat"), new IntWritable(1));
//		//		mapDriver.withOutput(new Text("dog"), new IntWritable(1));
//
//		/*
//		 * Run the test.
//		 */
		mapDriver.runTest();
	}

	
	
}

