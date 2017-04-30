/**
 * LaunchProgram7.java
 * PSP Program 7
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.controller;

import java.util.HashMap;
import java.util.Map;

import co.edu.uniandes.ecos.csof5101.psp2.view.ConsoleUI;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

/**
 * LaunchProgram6.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 23/04/2017 04:58:29 PM 2017
 */

public class LaunchProgram7 {

	/**
	 * Launch the application.
	 * @param args inputs arguments for the application
	 */
	public static void main(String[] args) {
		port(Integer.valueOf(System.getenv("PORT")));
	    staticFileLocation("/public");
		
		get("/", (request, response) -> {
			return new ModelAndView(null, "index.ftl");
		}, new FreeMarkerEngine());
		
		get("/calculation", (req, res) -> {
			ConsoleUI face = new ConsoleUI();
			face.readValuesFromURL(req);
			face.calculateMeasurings();
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("results", face.printMeasurings());
			return new ModelAndView(attributes, "calculation.ftl");
		}, new FreeMarkerEngine());
	}
}
