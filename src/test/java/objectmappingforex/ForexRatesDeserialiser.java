package objectmappingforex;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ForexRatesDeserialiser {
	public ForexJsonDTO forexJsonDTO;

	public ForexRatesDeserialiser( File jsonFileLocation) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			forexJsonDTO = objectMapper.readValue( jsonFileLocation , ForexJsonDTO.class);
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
