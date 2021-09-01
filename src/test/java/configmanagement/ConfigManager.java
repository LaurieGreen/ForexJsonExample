package configmanagement;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.Properties;

public class ConfigManager {
	// preparing our private variable for our properties object initialisation
	private static final Properties config;

	/*
	We are using a static block to initialise our static propertise instantiation and set our reader

	It is very similar to what you do when initialising a normal class i.e. public Config(){}

	Using a static block means that when we run/build our program this block is immidately loaded referred to as "eager loading"
	 */
	static { //TODO: read more about static block
		// Instantiation of our Properties object - Properties object is there to work with .properties files
		config = new Properties();
		try {
			// loading our config file using a newly instantiaded FileReader
			config.load( new FileReader( "src/test/config.properties" ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static String ratesTestFileLocation(){
		return config.getProperty( "rates_test_file_location" );
	}

	public static void main( String[] args ) {
		System.out.println( ConfigManager.ratesTestFileLocation() );
	}
}
