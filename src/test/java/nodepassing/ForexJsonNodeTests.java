package nodepassing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;

import configmanagement.ConfigManager;

public class ForexJsonNodeTests {
	private static ForexJsonNodeParsing forexJsonNodeParsing;

	@BeforeAll
	private static void setup(){
		forexJsonNodeParsing = new ForexJsonNodeParsing( new File( ConfigManager.ratesTestFileLocation() ) );
	}

	@Test
	public void getSuccessTest(){
		assertTrue( forexJsonNodeParsing.getSuccess() );
	}

	@Test
	public void getDateTest(){
		assertEquals( "2018-10-10", forexJsonNodeParsing.getDate() );
	}

	@Test
	public void getTimestampTest(){
		assertEquals( 1539182646, forexJsonNodeParsing.getTimestamp() );
	}

	@Test
	public void getBaseTest(){
		assertEquals( "EUR", forexJsonNodeParsing.getBase() );
	}

	@Test
	public void getRatesTest(){
		try {
			System.out.println(forexJsonNodeParsing.getRates());
		} catch ( JsonProcessingException e ) {
			e.printStackTrace();
		}
	}

	@Test
	public void dateMatchesTimestampTest(){
		long epoch = Long.parseLong( Long.toString( forexJsonNodeParsing.getTimestamp() ));
		Date date = new Date( epoch * 1000 );
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormatter.format( date );
		assertEquals( formattedDate, forexJsonNodeParsing.getDate());
	}


}
