package main;
import grader.basics.execution.BasicProjectExecution;
 import gradingTools.comp301ss21.assignment4.SS21Assignment4Suite;
// import gradingTools.comp301ss21.assignment2.SS21Assignment2Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class RunTests {

	public static final int PRINTED_TRACES_VAL = 600;
	public static final int MAX_TRACES_VAL = 2000;
	public static final int PROCESS_TIMEOUT = 5;
	
public static void main(String[] args) {
	// if you want to step through local checks calls to your code 
	// set this to false
			BasicProjectExecution.setUseMethodAndConstructorTimeOut(true);
			// if you set this to false, grader steps will not be traced
			GraderBasicsTraceUtility.setTracerShowInfo(true);	
			// i changed this from true to false
			// if you set this to false, all grader steps will be traced,
			// not just the ones that failed		
			GraderBasicsTraceUtility.setBufferTracedMessages(true);
			// Change this number if a test trace gets longer than 600 and is clipped
			GraderBasicsTraceUtility.setMaxPrintedTraces(PRINTED_TRACES_VAL);
			// Change this number if all traces together are longer than 2000
			GraderBasicsTraceUtility.setMaxTraces(MAX_TRACES_VAL);
			// Change this number if your process times out prematurely
			BasicProjectExecution.setProcessTimeOut(PROCESS_TIMEOUT);
			// You need to always call such a method
			SS21Assignment4Suite.main(args);
}
}
