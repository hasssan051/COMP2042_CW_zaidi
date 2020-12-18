package view;

import static org.junit.Assume.assumeThat;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ScoreHandlerTest {
	
	ScoreHandler scoreHandler;
//	String fileUrl;
//	Path fileDir;
	
	@BeforeEach
	void init(@TempDir Path fileDir) {
		scoreHandler =new ScoreHandler();		
	}
	
	
	@Test
	void testInitializeFile(@TempDir Path fileDir) {
		Path file =fileDir.resolve("testingfile.txt");
		String str = String.valueOf(file);
		scoreHandler.initializeFile(str);
		List<String> actualData=Collections.emptyList();
		try {
			 actualData= (ArrayList<String>)Files.readAllLines(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> expectedData= new ArrayList<String>();
		expectedData.add("Nobody:0");
		expectedData.add("Nobody:0");
		expectedData.add("Nobody:0");
		
		assertEquals(expectedData,actualData, "The File is not being initialized properly");		
	}
	
	@Test
	void testIsNewHighScoreMethod() {
		ArrayList<String> testingData= new ArrayList<String>();
		testingData.add("Nobody:0");
		testingData.add("Hassan:0");
		testingData.add("Nobody:0");
		
		assertTrue(scoreHandler.isNewHighScore(60, 2,testingData),"New high score is not being identified");
		
	}
	
	@Test
	void testReplaceLineMethod() {
		
	}
//	@Test
//	void testIOException() {
//		assertThrows(IOException.class, 
//			()->{
//					//.scoreHandler.initializeFile(fileUrl);
//					ScoreHandler.readFileIntoList(fileUrl);
//					scoreHandler.replaceLine(null,1,fileUrl);
//					//ScoreHandler.readFileIntoList(fileUrl);
//					scoreHandler.readHighScores(fileUrl);
//		});
//	}

}
