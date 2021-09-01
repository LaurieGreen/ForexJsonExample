package nodepassing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import configmanagement.ConfigManager;

public class ForexJsonNodeParsing {
	// JsonNode Object which is part of the Jackson databind library
	private JsonNode ratesNode;

	public ForexJsonNodeParsing(File jsonFile){
		/*
		ObjectMapper is the core object for Jackson databind
		this has multiple methods to help parse various data files

		We have initialised this below
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Pass in our JSON file
			ratesNode = objectMapper.readTree( jsonFile );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public boolean getSuccess(){
		return ratesNode.get( "success" ).asBoolean();
	}

	public long getTimestamp(){
		return ratesNode.get( "timestamp" ).asLong();
	}

	public String getDate(){
		return ratesNode.get( "date" ).asText();
	}

	public String getBase(){
		return ratesNode.get( "base" ).asText();
	}

	public double getRate(String rateIsoCode) throws Exception {
		JsonNode rates = ratesNode.get( "rates" );
		if (!rates.has(rateIsoCode)) {
			throw new Exception("Code not found.");
		}
		return rates.get( rateIsoCode ).asDouble();
	}

	// Not working yet
	public HashMap<String, Double> getRates() throws JsonProcessingException {
		HashMap<String, Double> rates = new HashMap<>();
		return rates;
	}

	public static void main( String[] args ) {
		ForexJsonNodeParsing parser = new ForexJsonNodeParsing( new File(ConfigManager.ratesTestFileLocation() ));
		System.out.println(parser.getSuccess());
	}
}
