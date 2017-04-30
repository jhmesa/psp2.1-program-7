/**
 * Data.java
 * PSP Program 7
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Data.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 23/04/2017 04:58:29 PM 2017
 */
public class Data {
	
	// Constants
	public static final double ERROR = 0.000001;
	
	//Instance variables
	private List<Double> dataXList = new ArrayList<Double>();
	private List<Double> dataYList = new ArrayList<Double>();
	private double estimatedProxy;
	private double linearRegressionParam1;
	private double linearRegressionParam2;
	private double correlationCoefficient1;
	private double correlationCoefficient2;
	private double improvedPrediction;
	private double significance;
	private double range;
	private double upi;
	private double lpi;
	
	/**
	 * @return the dataXList
	 */
	public List<Double> getDataXList() {
		return dataXList;
	}
	
	/**
	 * @param dataXList the dataXList to set
	 */
	public void setDataXList(List<Double> dataXList) {
		this.dataXList = dataXList;
	}
	
	/**
	 * @return the dataYList
	 */
	public List<Double> getDataYList() {
		return dataYList;
	}
	
	/**
	 * @param dataYList the dataYList to set
	 */
	public void setDataYList(List<Double> dataYList) {
		this.dataYList = dataYList;
	}
	
	/**
	 * @return the estimatedProxy
	 */
	public double getEstimatedProxy() {
		return estimatedProxy;
	}
	
	/**
	 * @param estimatedProxy the estimatedProxy to set
	 */
	public void setEstimatedProxy(double estimatedProxy) {
		this.estimatedProxy = estimatedProxy;
	}
	
	/**
	 * @return the linearRegressionParam1
	 */
	public double getLinearRegressionParam1() {
		return linearRegressionParam1;
	}
	
	/**
	 * @param linearRegressionParam1 the linearRegressionParam1 to set
	 */
	public void setLinearRegressionParam1(double linearRegressionParam1) {
		this.linearRegressionParam1 = linearRegressionParam1;
	}
	
	/**
	 * @return the linearRegressionParam2
	 */
	public double getLinearRegressionParam2() {
		return linearRegressionParam2;
	}
	
	/**
	 * @param linearRegressionParam2 the linearRegressionParam2 to set
	 */
	public void setLinearRegressionParam2(double linearRegressionParam2) {
		this.linearRegressionParam2 = linearRegressionParam2;
	}
	
	/**
	 * @return the correlationCoefficient1
	 */
	public double getCorrelationCoefficient1() {
		return correlationCoefficient1;
	}
	
	/**
	 * @param correlationCoefficient1 the correlationCoefficient1 to set
	 */
	public void setCorrelationCoefficient1(double correlationCoefficient1) {
		this.correlationCoefficient1 = correlationCoefficient1;
	}
	
	/**
	 * @return the correlationCoefficient2
	 */
	public double getCorrelationCoefficient2() {
		return correlationCoefficient2;
	}
	
	/**
	 * @param correlationCoefficient2 the correlationCoefficient2 to set
	 */
	public void setCorrelationCoefficient2(double correlationCoefficient2) {
		this.correlationCoefficient2 = correlationCoefficient2;
	}
	
	/**
	 * @return the improvedPrediction
	 */
	public double getImprovedPrediction() {
		return improvedPrediction;
	}
	
	/**
	 * @param improvedPrediction the improvedPrediction to set
	 */
	public void setImprovedPrediction(double improvedPrediction) {
		this.improvedPrediction = improvedPrediction;
	}
	
	/**
	 * @return the significance
	 */
	public double getSignificance() {
		return significance;
	}
	
	/**
	 * @param significance the significance to set
	 */
	public void setSignificance(double significance) {
		this.significance = significance;
	}
	
	/**
	 * @return the range
	 */
	public double getRange() {
		return range;
	}
	
	/**
	 * @param range the range to set
	 */
	public void setRange(double range) {
		this.range = range;
	}
	
	/**
	 * @return the upi
	 */
	public double getUpi() {
		return upi;
	}
	
	/**
	 * @param upi the upi to set
	 */
	public void setUpi(double upi) {
		this.upi = upi;
	}
	
	/**
	 * @return the lpi
	 */
	public double getLpi() {
		return lpi;
	}
	
	/**
	 * @param lpi the lpi to set
	 */
	public void setLpi(double lpi) {
		this.lpi = lpi;
	}
}
