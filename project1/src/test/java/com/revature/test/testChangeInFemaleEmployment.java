package com.revature.test;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

import com.revature.map.changeInFemaleEmployment;
import com.revature.map.changeInMaleEmployment;



public class testChangeInFemaleEmployment {

private MapDriver<LongWritable, Text, Text, DoubleWritable> mapDriver;

	
	
//	static String lineIn = "\"Arab World\",\"ARB\",\"Credit card used in the past year, female (% age 15+) [w2]\",\"WP14892.3\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",";
	static String lineIn = ("\"Australia\",\"AUS\",\"Employment in agriculture, female (% of female employment)\",\"SL.AGR.EMPL.FE.ZS\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"4.03000020980835\",\"4.3899998664856\",\"3.9300000667572\",\"4.05000019073486\",\"4.15000009536743\",\"3.52999997138977\",\"3.78999996185303\",\"4.01999998092651\",\"4.19000005722046\",\"3.79999995231628\",\"3.88000011444092\",\"4.11999988555908\",\"4.48000001907349\",\"4.28999996185303\",\"4.32999992370605\",\"4.03000020980835\",\"4.32999992370605\",\"4.40000009536743\",\"4.05999994277954\",\"4.23000001907349\",\"3.88000011444092\",\"3.95000004768372\",\"3.84999990463257\",\"3.60999989509583\",\"3.61999988555908\",\"3.50999999046326\",\"3.48000001907349\",\"3.39000010490417\",\"3.47000002861023\",\"3.44000005722046\",\"3.49000000953674\",\"3.4300000667572\",\"3.45000004768372\",\"3.03999996185303\",\"2.63000011444092\",\"2.6800000667572\",\"2.46000003814697\",\"2.35999989509583\",\"2.26999998092651\",\"2.1800000667572\",\"2.22000002861023\",\"2.27999997138977\",\"1.88999998569489\",\"1.91999995708466\",\"1.66999995708466\",\"1.83000004291534\",\"1.87000000476837\",\"1.70000004768372\",");
//	static Text mapOut = new Text ("Armenia#ARM#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#Educational attainment completed Bachelor's or equivalent population 25+ years female (%)#SE.TER.HIAT.BA.FE.ZS##########################################19.49775###############");		
	static Text mapOut = new Text ("Australia    Employment in agriculture, female (% of female employment)SL.AGR.EMPL.FE.ZS    ");
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
		changeInFemaleEmployment mapper = new changeInFemaleEmployment();
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
		mapDriver.withOutput(mapOut, new DoubleWritable(101.76470414989902));
//		//		mapDriver.withOutput(new Text("cat"), new IntWritable(1));
//		//		mapDriver.withOutput(new Text("dog"), new IntWritable(1));
//
//		/*
//		 * Run the test.
//		 */
		mapDriver.runTest();
	}

	
	
}

