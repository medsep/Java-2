package aggregators;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import client.StockFileApplication;
import fileprocessors.StockFileReader;

public class AggregatorProcessor<E extends Aggregator> {

	E aggregator;
	private String tableName;

	public AggregatorProcessor(E agg, String tableName) {
		this.aggregator = agg;
		this.tableName = tableName;
	}

	public double runAggregator(String columnName) throws IOException {

		double result = 0.0;
		StockFileReader fr = new StockFileReader(tableName);
		List<HashMap<String, Double>> dataResult = StockFileApplication.populateStockFileData(fr.getHeaders(),
				fr.readFileData());

		for (HashMap<String, Double> map : dataResult) {
			for (Map.Entry<String, Double> entry : map.entrySet()) {
				String key = entry.getKey();
				Double value = entry.getValue();

				if (key.equals(columnName)) {
					aggregator.add(value);
				}
			}
		}
		result = aggregator.calculate();

		return result;
	}

}
