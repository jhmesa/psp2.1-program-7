/**
 * MeasuringTest.java
 * PSP Program 7
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.uniandes.ecos.csof5101.psp2.model.Measuring;
import co.edu.uniandes.ecos.csof5101.psp2.view.ConsoleUI;

/**
 * MeasuringTest.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 23/04/2017 04:58:29 PM 2017
 */

public class MeasuringTest{
	
	/**
	 * Method to test the method calculateLinearRegression.
	 */
	@Test
	public void calculateLinearRegressionTest(){
		ConsoleUI face = new ConsoleUI();
		face.readFile("./src/test/resources/test_1.txt");
		Measuring.calculateLinearRegression(face.getData());
		assertEquals(-22.552532752034132, face.getData().getLinearRegressionParam1(), 0.0);
	}
	
	/**
	 * Method to test the method calculateCorrelationCoefficients.
	 */
	@Test
	public void calculateCorrelationCoefficientsTest(){
		ConsoleUI face = new ConsoleUI();
		face.readFile("./src/test/resources/test_1.txt");
		Measuring.calculateCorrelationCoefficients(face.getData());
		assertEquals(0.9544965741046826, face.getData().getCorrelationCoefficient1(), 0.0);
	}
	
	/**
	 * Method to test the method calculateImprovedPrediction.
	 */
	@Test
	public void calculateImprovedPredictionTest(){
		ConsoleUI face = new ConsoleUI();
		face.readFile("./src/test/resources/test_1.txt");
		face.getData().setEstimatedProxy(386.0);
		Measuring.calculateLinearRegression(face.getData());
		Measuring.calculateCorrelationCoefficients(face.getData());
		Measuring.calculateImprovedPrediction(face.getData());
		assertEquals(644.4293837638623, face.getData().getImprovedPrediction(), 0.0);
	}
	
	/**
	 * Method to test the method calculateGammaFunction.
	 */
	@Test
	public void calculateGammaFunctionTest(){
		double value = Measuring.calculateGammaFunction(1);
		
		assertEquals(0.999999999958284, value, 0.0);
	}
	
	/**
	 * Method to test the method calculateIntegrationTDistWithSimpsRuleValue.
	 */
	@Test
	public void calculateIntegrationTDistWithSimpsRuleValueTest(){
		double x = 1.1;
		double dof = 9.0;
		double value = Measuring.calculateIntegrationTDistWithSimpsRuleValue(x, dof);
		
		assertEquals(0.35005862258953385, value, 0.0);
	}
	
	/**
	 * Method to test the method calculateMultiplier.
	 */
	@Test
	public void calculateMultiplierTest(){
		double value = Measuring.calculateMultiplier(1);
		assertEquals(4.0, value, 0.0);
	}
	
	/**
	 * Method to test the method calculateX.
	 */
	@Test
	public void calculateXTest(){
		double x = Measuring.calculateX(9.0, 0.3500589042834335);
		assertEquals(1.100006103515625, x, 0.0);
	}
	
	/**
	 * Method to test the method calculateSignificance.
	 */
	@Test
	public void calculateSignificanceTest(){
		ConsoleUI face = new ConsoleUI();
		face.readFile("./src/test/resources/test_1.txt");
		face.getData().setEstimatedProxy(386.0);
		Measuring.calculateLinearRegression(face.getData());
		Measuring.calculateCorrelationCoefficients(face.getData());
		Measuring.calculateImprovedPrediction(face.getData());
		Measuring.calculateSignificance(face.getData());
		assertEquals(1.7752879453825088E-5, face.getData().getSignificance(), 0.0);
	}
	
	/**
	 * Method to test the method calculateRange.
	 */
	@Test
	public void calculateRangeTest(){
		ConsoleUI face = new ConsoleUI();
		face.readFile("./src/test/resources/test_1.txt");
		face.getData().setEstimatedProxy(386.0);
		Measuring.calculateLinearRegression(face.getData());
		Measuring.calculateCorrelationCoefficients(face.getData());
		Measuring.calculateImprovedPrediction(face.getData());
		Measuring.calculateSignificance(face.getData());
		Measuring.calculateRange(face.getData());
		assertEquals(230.0019735266218, face.getData().getRange(), 0.0);
	}
}
