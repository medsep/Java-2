package client;

import java.io.IOException;
import java.util.ArrayList;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MinAggregator;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {

		/**
		 * You'll need to uncomment the below code. You'll notice it does not compile!
		 * 
		 * There are 2 objectives in this assignment.
		 * 
		 * 1). Make sure the code compiles correctly after you uncomment it below. 2).
		 * Make sure it runs as explained in the assignment video!
		 * 
		 * -->> YOUR WORK SHOULD BE DONE IN THE AggregatorProcessor CLASS.
		 **/

		MinAggregator agg = new MinAggregator(new ArrayList<Double>());
		AggregatorProcessor<MinAggregator> aggsProcessor = new AggregatorProcessor<MinAggregator>(agg, "table.csv");
		double value = aggsProcessor.runAggregator("Open");
		System.out.println(value);

		MaxAggregator agg_1 = new MaxAggregator(new ArrayList<Double>());
		AggregatorProcessor<MaxAggregator> aggsProcessor_1 = new AggregatorProcessor<MaxAggregator>(agg_1, "table.csv");
		double value_1 = aggsProcessor_1.runAggregator("Open");
		System.out.println(value_1);

	}

}
