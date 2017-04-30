/**
 * Measuring.java
 * PSP Program 7
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.model;

import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 * Measuring.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 23/04/2017 04:58:29 PM 2017
 */

public final class Measuring {
	
	/**
	 * Method to calculate the linear regression of a dataset.
	 * @param data directory of file
	 */
	public static void calculateLinearRegression(Data data){
		SimpleRegression s = getSimpleRegression(data);
		data.setLinearRegressionParam1(s.getIntercept());
		data.setLinearRegressionParam2(s.getSlope());
	}
	
	/**
	 * Method to calculate the correlation coefficients of a data set.
	 * @param data object that contains the values of the x and y axes
	 */
	public static void calculateCorrelationCoefficients(Data data){
		SimpleRegression s = getSimpleRegression(data);
		data.setCorrelationCoefficient1(s.getR());
		data.setCorrelationCoefficient2(s.getRSquare());
	}

	/**
	 * Method to calculate the improved prediction of a data set.
	 * @param data object that contains the values of the x and y axes
	 */
	public static void calculateImprovedPrediction(Data data){
		data.setImprovedPrediction(data.getLinearRegressionParam1() + data.getLinearRegressionParam2() 
		    * data.getEstimatedProxy());
	}
	
	/**
	 * Method to get Simple Regression object for data set.
	 * @param data object that contains the values of the x and y axes
	 * @return simpleRegression object containing the values to make the calculations 
	 */
	public static SimpleRegression getSimpleRegression(Data data){
		SimpleRegression simpleRegression= new SimpleRegression();
		
		for (int i = 0; i < data.getDataXList().size(); i++) {
			simpleRegression.addData(data.getDataXList().get(i), data.getDataYList().get(i));
		}
		return simpleRegression;
	}
	
	/**
	 * Calculate the gamma function for any value
	 * @param x the number to find the value of gamma function
	 * @return the value of gamma function
	 */
	public static double calculateGammaFunction(double x){
		double tmp = (x - 0.5) * Math.log(x + 4.5)-(x + 4.5);
	    double ser = 1.0+76.18009173/(x + 0)-86.50532033/(x + 1)
	                  +24.01409822/(x + 2)-1.231739516/(x + 3)
	                  +0.00120858003/(x + 4)-0.00000536382/(x + 5);
	    
	    return Math.exp(tmp + Math.log(ser*Math.sqrt(2*Math.PI)));
	}
	
	/**
	 * Calculate the t distribution with  Simpson's rule
	 * @param dof value of degrees of freedom
	 * @param w value of the w
	 */
	public static double calculateIntegrationTDistWithSimpsRuleValue(double x, double dof){
		double w = x/30;
		double xi = 0.0;
		double integralVal = 0;
		for (int i = 0; i <= 30; i++) {
			double xiTemp = xi;
			double fXiTemp = (Measuring.calculateGammaFunction((dof+1)/2)) / (Math.pow(dof*Math.PI,0.5) 
				* Measuring.calculateGammaFunction(dof/2)) * (Math.pow(1+(Math.pow(xiTemp,2)/dof),-((dof+1)/2)));
			double integralValTemp = (w/3) * calculateMultiplier(i) * fXiTemp ;
			integralVal += integralValTemp;
			xi += w;
		}
		return integralVal;
	}
	
	/**
	 * Calculate of multiplier for each value of interval
	 * @param number the number of the iteration
	 * @return the value of multiplier
	 */
	public static double calculateMultiplier(double number){
		if(number==0 || number == 30){
			return 1;
		} else if (number%2 == 0){
			return 2;
		} else {
			return 4;
		}
	}
	
	/**
	 * Calculate of x value
	 * @param data the object containing the values to make the calculations
	 * @return x value for the values of dof and p
	 */
	public static double calculateX(double dof, double p){
		double pTemp = 0.0;
		double x = 1.0;
		double d = 0.5;
		double xForData = 0;
		
		main:
		while(p != pTemp){
			double xTemp = x;
			double dTemp = d;
			pTemp =calculateIntegrationTDistWithSimpsRuleValue(x, dof);
			if (pTemp < p){
				xTemp += d;
			} else {
				xTemp -= d;
			}
			
			pTemp =calculateIntegrationTDistWithSimpsRuleValue(xTemp, dof);
			if((pTemp-p <= Data.ERROR && pTemp-p > 0)
					|| (p-pTemp <=Data.ERROR && p-pTemp > 0)){
				x = xTemp;
				break main;
			} else {
				while (dTemp > Data.ERROR){
					dTemp /=2;
					if (pTemp < p){
						xTemp += dTemp;
					} else {
						xTemp -= dTemp;
					}
					xForData = xTemp;
					pTemp =calculateIntegrationTDistWithSimpsRuleValue(xTemp, dof);
					if ((pTemp-p <= Data.ERROR && pTemp-p > 0)
							|| (p-pTemp <=Data.ERROR && p-pTemp > 0)){
						x = xTemp;
						break main;
					}
				}
			}
			x = xForData;
		}
		return x;
	}
	
	/**
	 * Calculate of value of the significance
	 * @param data the object containing the values to make the calculations
	 */
	public static void calculateSignificance(Data data){
		int n = data.getDataXList().size();
		double rxy = data.getCorrelationCoefficient1();
		double x = (rxy * Math.sqrt(n-2)) / (Math.sqrt(1-Math.pow(rxy, 2)));
		double p = calculateIntegrationTDistWithSimpsRuleValue(x, n-2);
		double significance = 1 - 2 * p;
		data.setSignificance(significance);
	}
	
	/**
	 * Calculate of value of range
	 * @param data the object containing the values to make the calculations
	 */
	public static void calculateRange(Data data){
		double ep = data.getEstimatedProxy();
		double n = data.getDataXList().size();
		double yk = data.getImprovedPrediction();
		double xavg = 0.0;
		double val1 = 0.0;
		double val2 = 0.0;
		
		for (int i = 0; i < data.getDataXList().size(); i++) {
			double x = data.getDataXList().get(i);
			xavg += x;
		}
		xavg /= n;
		
		for (int i = 0; i < data.getDataXList().size(); i++) {
			double x = data.getDataXList().get(i);
			double y = data.getDataYList().get(i);
			val1 += Math.pow(y - data.getLinearRegressionParam1() 
					- (data.getLinearRegressionParam2() * x), 2);
			val2 += Math.pow(x-xavg,2);
		}
		double ds = Math.sqrt(1/(n-2) * val1);		
		double x = calculateX(n-2, 0.35);		
		double range = x * ds *  Math.sqrt(1 + (1/n)  + (Math.pow(ep - xavg , 2)/val2)); 		
		double UPI = yk + range;
		double LPI = yk - range;
		
		data.setRange(range);
		data.setUpi(UPI);
		data.setLpi(LPI);
	}
}