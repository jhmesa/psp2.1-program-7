/**
 * DataTest.java
 * PSP Program 7
 * Copyright (c) Universidad de los Andes.
 */

package co.edu.uniandes.ecos.csof5101.psp2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import co.edu.uniandes.ecos.csof5101.psp2.model.Data;

/**
 * DataTest.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 23/04/2017 04:58:29 PM 2017
 */
public class DataTest {
	
	/**
	 * Method to test the method setDataXList.
	 */
	@Test
	public void setDataXListTest(){
		Data data = new Data();
		List<Double> xListTemp = new ArrayList<Double>();
		xListTemp.add(130.0);
		data.setDataXList(xListTemp);
		assertEquals(130.0, data.getDataXList().get(0),0.0);
	}
	
	/**
	 * Method to test the method setDataYList.
	 */
	@Test
	public void setDataYListTest(){
		Data data = new Data();
		List<Double> yListTemp = new ArrayList<Double>();
		yListTemp.add(186.0);
		data.setDataYList(yListTemp);
		assertEquals(186.0, data.getDataYList().get(0),0.0);
	}
	
	/**
	 * Method to test the method setEstimatedProxy.
	 */
	@Test
	public void setEstimatedProxyTest(){
		Data data = new Data();
		data.setEstimatedProxy(386.0);
		assertEquals(386.0, data.getEstimatedProxy(),0.0);
	}
	
	/**
	 * Method to test the method setLinearRegressionParam1.
	 */
	@Test
	public void setLinearRegressionParam1Test(){
		Data data = new Data();
		data.setLinearRegressionParam1(100.0);
		assertEquals(100.0, data.getLinearRegressionParam1(),0.0);
	}
	
	/**
	 * Method to test the method setLinearRegressionParam2.
	 */
	@Test
	public void setLinearRegressionParam2Test(){
		Data data = new Data();
		data.setLinearRegressionParam2(200.0);
		assertEquals(200.0, data.getLinearRegressionParam2(),0.0);
	}
	
	/**
	 * Method to test the method setCorrelationCoefficient1.
	 */
	@Test
	public void setCorrelationCoefficient1Test(){
		Data data = new Data();
		data.setCorrelationCoefficient1(300.0);
		assertEquals(300.0, data.getCorrelationCoefficient1(),0.0);
	}
	
	/**
	 * Method to test the method setCorrelationCoefficient2.
	 */
	@Test
	public void setCorrelationCoefficient2Test(){
		Data data = new Data();
		data.setCorrelationCoefficient2(400.0);
		assertEquals(400.0, data.getCorrelationCoefficient2(),0.0);
	}
	
	/**
	 * Method to test the method setImprovedPrediction.
	 */
	@Test
	public void setImprovedPredictionTest(){
		Data data = new Data();
		data.setImprovedPrediction(500.0);
		assertEquals(500.0, data.getImprovedPrediction(),0.0);
	}
	
	/**
	 * Method to test the method setSignificance.
	 */
	@Test
	public void setSignificanceTest(){
		Data data = new Data();
		data.setSignificance(600.0);
		assertEquals(600.0, data.getSignificance(),0.0);
	}
	
	/**
	 * Method to test the method setRange.
	 */
	@Test
	public void setRangeTest(){
		Data data = new Data();
		data.setRange(700.0);
		assertEquals(700.0, data.getRange(),0.0);
	}
	
	/**
	 * Method to test the method setUpi.
	 */
	@Test
	public void setUpiTest(){
		Data data = new Data();
		data.setUpi(800.0);
		assertEquals(800.0, data.getUpi(),0.0);
	}
	
	/**
	 * Method to test the method setLpi.
	 */
	@Test
	public void setLpiTest(){
		Data data = new Data();
		data.setLpi(900.0);
		assertEquals(900.0, data.getLpi(),0.0);
	}
}
