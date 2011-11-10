package org.universAAL.ontology.safetyDevices;

import org.universAAL.middleware.owl.ManagedIndividual;
import org.universAAL.middleware.owl.OrderingRestriction;
import org.universAAL.middleware.owl.Restriction;
import org.universAAL.middleware.rdf.TypeMapper;
import org.universAAL.ontology.location.Location;
import org.universAAL.ontology.phThing.Device;


/**
 * @author dimokas
 *
 * Door is similar to LightSource
 */
public class Door extends Device {
	public static final String SAFETY_NAMESPACE = "http://ontology.universaal.org/Safety.owl#";
	public static final String MY_URI; 
	public static final String PROP_DEVICE_LOCATION;
	public static final String PROP_DEVICE_STATUS;
	
	
	static{
		MY_URI = SAFETY_NAMESPACE + "Door";
		PROP_DEVICE_LOCATION = SAFETY_NAMESPACE + "deviceLocation";		
		PROP_DEVICE_STATUS = SAFETY_NAMESPACE + "deviceStatus";
		register(Door.class);		
	}
	
	public static Restriction getClassRestrictionsOnProperty(String propURI) {
		if (PROP_DEVICE_LOCATION.equals(propURI))
			return Restriction.getAllValuesRestrictionWithCardinality(propURI,
					Location.MY_URI, 1, 1);
		if (PROP_DEVICE_STATUS.equals(propURI))
			return OrderingRestriction.newOrderingRestriction(new Integer(100),
				    new Integer(0), true, true, Restriction
					    .getAllValuesRestrictionWithCardinality(propURI,
						    TypeMapper.getDatatypeURI(Integer.class),
						    1, 1));
		return ManagedIndividual.getClassRestrictionsOnProperty(propURI);
	}

	public static String[] getStandardPropertyURIs() {
		return new String[] {PROP_DEVICE_LOCATION, PROP_DEVICE_STATUS};
	}
	
	public static String getRDFSComment() {
		return "The class of all Doors";
	}
	
	public static String getRDFSLabel() {
		return "Door";
	}
		
	public Door(){
		super();
	}
	
	public Door(String uri) {
		super(uri);				
	}
		
	public Door(String uri, Location loc) {
		super(uri);
		if (loc == null)
			   throw new IllegalArgumentException();
	
		props.put(PROP_DEVICE_STATUS, new Integer(0));
		props.put(PROP_DEVICE_LOCATION, loc);
	}
	
	public int getStatus() {
		Integer i = (Integer) props.get(PROP_DEVICE_STATUS);
		return (i == null) ? -1 : i.intValue();
	    }
	
	public Location getDeviceLocation() {
		return (Location) props.get(PROP_DEVICE_LOCATION);
	}
	public void setStatus(int state) {
		if (state > -1 && state < 101)
		    props.put(PROP_DEVICE_STATUS, new Integer(state));
	}
	
	public void setDeviceLocation(Location l) {
		if (l != null)
		    props.put(PROP_DEVICE_LOCATION, l);
	    }
	
	public int getPropSerializationType(String propURI) {
		return (PROP_DEVICE_LOCATION.equals(propURI)) ? PROP_SERIALIZATION_REDUCED
			: PROP_SERIALIZATION_FULL;
	}
		
	public boolean isWellFormed() {
		return props.containsKey(PROP_DEVICE_STATUS)
		&& props.containsKey(PROP_DEVICE_LOCATION);
	}
	
	
}
