/**
 * ConsoleUI.java
 * PSP Program 7
 * Copyright (c) Universidad de los Andes.
 */

package co.edu.uniandes.ecos.csof5101.psp2.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import spark.Request;
import co.edu.uniandes.ecos.csof5101.psp2.model.Data;
import co.edu.uniandes.ecos.csof5101.psp2.model.Measuring;

/**
 * ConsoleUI.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 23/04/2017 04:58:29 PM 2017
 */

public class ConsoleUI {
	
	//Instance Variables
	private Data data = new Data();

	/**
	 * Method to read the parameters from URL.
	 * @param req object that contains the request params
	 */
	public void readValuesFromURL(Request req) {
		String estimatedProxy = req.queryParams("estimatedProxy");
		String fileName = req.queryParams("fileName");
		double estimatedProxyNumber = estimatedProxy != null?Double.valueOf(estimatedProxy):0;
		data.setEstimatedProxy(estimatedProxyNumber);
		readFile(fileName);
	}

	/**
	 * Method to get the dataset of the file.
	 * @param path directory of file
	 */
	public void readFile(String path) {
		if(null == path || path.equalsIgnoreCase("")){
			System.out.println("Path is empty!!");
		} else {
			try {
				BufferedReader br =  new BufferedReader(new FileReader("./src/main/resources/" + path));
				String line = br.readLine();
				while (null != line) {
					String[]tokens = line.split(",");
					data.getDataXList().add(Double.valueOf(tokens[0]));
					data.getDataYList().add(Double.valueOf(tokens[1]));
					line = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				System.out.println("Failed to get file:" + path);
			}
		}
	}
	
	/**
	 * Method to print the metrics calculated on the page.
	 * @return output list that contains the strings for impressions in the web page
	 */
	public ArrayList<String> printMeasurings() {
		ArrayList<String> output = new ArrayList<String>();
		if(data != null){
			output.add("x       y");
			for (int i = 0; i < data.getDataXList().size(); i++) {
				output.add(data.getDataXList().get(i) + "    " + data.getDataYList().get(i));
			}
			output.add("-------------------------");
			output.add("r(x,y) is = " + getData().getCorrelationCoefficient1());
			output.add("r^2 is = " + getData().getCorrelationCoefficient2());
			output.add("significance is = " + data.getSignificance());
			output.add("B(0)is  = " + data.getLinearRegressionParam1());
			output.add("B(1) is = " + data.getLinearRegressionParam2());
			output.add("y(k) is = " + data.getImprovedPrediction());
			output.add("Range is = " + data.getRange());
			output.add("UPI(70%)- is = " + data.getUpi());
			output.add("LPI(70%)+ is = " + data.getLpi());
		}
		return output;
	}
	
	/**
	 * Method to calculate the measurings.
	 */
	public void calculateMeasurings(){
		Measuring.calculateLinearRegression(this.data);
		Measuring.calculateCorrelationCoefficients(this.data);
		Measuring.calculateImprovedPrediction(this.data);
		Measuring.calculateSignificance(this.data);
		Measuring.calculateRange(this.data);
	}
	
	/**
	 * @return the data
	 */
	public Data getData() {
		return data;
	}
}
