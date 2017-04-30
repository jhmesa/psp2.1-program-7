/**
 * ConsoleUITest.java
 * PSP Program 7
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import co.edu.uniandes.ecos.csof5101.psp2.model.Data;
import co.edu.uniandes.ecos.csof5101.psp2.view.ConsoleUI;

/**
 * ConsoleUITest.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 23/04/2017 04:58:29 PM 2017
 */

public class ConsoleUITest {
	
	/**
	 * Method to test the method readFile.
	 */
	@Test
	public void readFileTest(){
		ConsoleUI face = new ConsoleUI();
		face.readFile("./src/test/resources/test_1.txt");
		Data dataTest = new Data();
		dataTest.getDataXList().add(130.0);
		dataTest.getDataYList().add(186.0);
		
		assertEquals(dataTest.getDataXList().get(0),face.getData().getDataXList().get(0),0.0);
	}
	
	/**
	 * Method to test the method calculateMeasurings.
	 */
	@Test
	public void calculateMeasuringsTest(){
		ConsoleUI face = new ConsoleUI();
		face.readFile("./src/test/resources/test_1.txt");
		face.getData().setEstimatedProxy(386.0);
		face.calculateMeasurings();
		
		assertEquals(230.0019735266218, face.getData().getRange(), 0.0);
	}
	
	/**
	 * Method to test the method printMeasurings.
	 */
	@Test
	public void printMeasuringsTest(){
		ConsoleUI face = new ConsoleUI();
		face.readFile("./src/test/resources/test_1.txt");
		face.getData().setEstimatedProxy(386.0);
		face.calculateMeasurings();
		ArrayList<String> output = new ArrayList<String>();
		output.add("r(x,y) is = 0.9544965741046826");
		face.printMeasurings();
		
		assertEquals(output.get(0), face.printMeasurings().get(12));
	}
}
