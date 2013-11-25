/*
	Copyright 2012 CERTH, http://www.certh.gr
	
	See the NOTICE file distributed with this work for additional 
	information regarding copyright ownership
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	  http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */package org.universAAL.ontology;

import org.universAAL.middleware.rdf.Resource;
import org.universAAL.middleware.rdf.impl.ResourceFactoryImpl;
import org.universAAL.ontology.biomedicalsensors.BiomedicalSensorService;
import org.universAAL.ontology.biomedicalsensors.CompositeBiomedicalSensor;
import org.universAAL.ontology.biomedicalsensors.MeasuredEntity;

/**
 * The factory for instantiating objects of the ontology classes.
 * 
 * @author joemoul
 */

public class BiomedicalSensorsFactory extends ResourceFactoryImpl {

	public Resource createInstance(String classURI, String instanceURI,
			int factoryIndex) {

		switch (factoryIndex) {
		case 0:
			return new CompositeBiomedicalSensor(instanceURI);
		case 1:
			return new BiomedicalSensorService(instanceURI);
		case 2:
			return new MeasuredEntity(instanceURI);
		}

		return null;
	}
}
