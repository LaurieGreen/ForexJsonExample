package objectmappingforex;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import configmanagement.ConfigManager;

public class ForezDeserialiserTests {

	private static ForexRatesDeserialiser forexRatesDeserialiser;

	@BeforeAll
	private static void setup(){
		forexRatesDeserialiser = new ForexRatesDeserialiser( new File( ConfigManager.ratesTestFileLocation() ) );
	}

	@Test
	public void test(){
		System.out.println(forexRatesDeserialiser.forexJsonDTO.getRates());
	}

}
