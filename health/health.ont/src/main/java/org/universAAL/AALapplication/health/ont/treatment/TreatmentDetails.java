/*	
	Copyright 2010-2014 UPM http://www.upm.es
	Universidad Politécnica de Madrdid
	
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
 */

package org.universAAL.AALapplication.health.ont.treatment;

import org.universAAL.middleware.owl.ManagedIndividual;
import org.universAAL.middleware.owl.Restriction;
import org.universAAL.middleware.rdf.TypeMapper;

public class TreatmentDetails extends Treatment {

	public static final String TREATMENT_NAMESPACE = Treatment.TREATMENT_NAMESPACE;
	public static final String MY_URI;
	
	public static final String PROP_PURPOSE;
	public static final String PROP_PROCEDURE;
	
	static {
		MY_URI = TREATMENT_NAMESPACE + "TreatmentDetails";
		PROP_PURPOSE = TREATMENT_NAMESPACE + "Purpose";
		PROP_PROCEDURE = TREATMENT_NAMESPACE + "Procedure";
				
		register(TreatmentDetails.class);
    }
       
    public static Restriction getClassRestrictionsOnProperty(String propURI) {
            	
    	if (PROP_PURPOSE.equals(propURI))
    		return Restriction.getAllValuesRestrictionWithCardinality(propURI, TypeMapper.getDatatypeURI(String.class), 1, 1);
		if (PROP_PROCEDURE.equals(propURI))
			return Restriction.getAllValuesRestrictionWithCardinality(propURI, TypeMapper.getDatatypeURI(String.class), 1, 1);
		
		return ManagedIndividual.getClassRestrictionsOnProperty(propURI);
	}

	public static String[] getStandardPropertyURIs() {
        String[] inherited = ManagedIndividual.getStandardPropertyURIs();
        String[] proper = {PROP_PURPOSE, PROP_PROCEDURE};
		String[] merged = new String[inherited.length + proper.length];
		System.arraycopy(inherited, 0, merged, 0, inherited.length);
		System.arraycopy(proper, 0, merged, inherited.length, proper.length);
		return merged;
	}

	public static String getRDFSComment() {
		return "Treatment details description";
	}

	public static String getRDFSLabel() {
		return "Treatment details";
	}

	public int getPropSerializationType(String propURI) {
		return ManagedIndividual.PROP_SERIALIZATION_FULL;
	}

	public boolean isWellFormed() {
		return true;
	}

	//Constructors
	
	public TreatmentDetails() {
		
	}

	public TreatmentDetails(String uri) {
		super(uri);
	}

	public TreatmentDetails(String uriPrefix, int numProps) {
		super(uriPrefix, numProps);
	}

	
	

}
