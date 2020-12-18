package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * The class ScoreHandler is used in order to handle high scores that the user might reach to. It reads and writes from a file, that it can create 
 * if it were to not exist. 
 * @author HP
 *
 */

public class ScoreHandler {
	
	//private static final String HIGH_SCORE_FILE="src/view/highscore.txt";
	
	private ArrayList<String> highScoresList= new ArrayList<String>();
	/**
	 * This method is used in order to check for the existence of a file, create it and call the initialize method on it when it is created. 
	 * The method is also used to store whatever is read by the readFileIntoList method into the highScoresList ArrayList.
	 */
	
	public void readHighScores(String fileUrl) {
		    try {
		        File scoreFile = new File(fileUrl);
		        if (!scoreFile.exists()) {
		          scoreFile.createNewFile();
		          System.out.println("File created: " + scoreFile.getName());
		          initializeFile(fileUrl);
		        } else {
		          System.out.println("File already exists.");
		          
		        }
		      } catch (IOException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
		    highScoresList = (ArrayList<String>) readFileIntoList(fileUrl);
		    
		    if(highScoresList.isEmpty() || highScoresList.contains(null)) {
		    	initializeFile(fileUrl);
		    }
		    
		}
	/**
	 * This method is used to initialize the created file to an initial value with scores and names.  
	 */
	public void initializeFile(String fileUrl) {
		 try {
		      FileWriter myWriter = new FileWriter(fileUrl);
		      myWriter.write("Nobody:0\nNobody:0\nNobody:0");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

	/**
	 * This public method returns a boolean value after checking user's score and existing high score.
	 * @param score the score of the user that needs to be checked with the score according to the level in the highScoresList ArrayList
	 * @param numOfLevel level for which high score needs to be checked
	 * @return returns true if the high score is higher than the value stores in the highScoresList ArrayList else returns false 
	 */
	public boolean isNewHighScore(int score, int numOfLevel, ArrayList<String> highScoresList) throws NullPointerException{
		if(numOfLevel<0 || numOfLevel>3) {
			System.out.println("Level does not exist");
			return false;
		}
		if(score > Integer.parseInt((highScoresList.get(numOfLevel).split(":")[1]))){
			return true;
		}	
		else return false;
	}
	
	/**
	 *  This method is used to replace a high score from the file. It basically just removes a specific line(line with particular level's high score )
	 *  with a new one
	 * @param replaceWithHighScore the new high score that the user has scored with their name
	 * @param levelofHighScore Level in which the user has scored the high score
	 * @param fileUrl
	 */
	public void replaceLine(String replaceWithHighScore, int levelofHighScore, String fileUrl) {
		  List<String> listOfLines =Collections.emptyList();
		  listOfLines=readFileIntoList(fileUrl);

		  listOfLines.set(levelofHighScore,replaceWithHighScore);
		  
		  try {
		      FileWriter myWriter = new FileWriter(fileUrl);
		      myWriter.write(listOfLines.get(0)+"\n"+listOfLines.get(1)+"\n"+listOfLines.get(2));
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/**
	 * Reads whatever is inside the file into a List
	 * @param fileUrl
	 * @return returns the list containing whatever was in the file
	 */
	public static List<String> readFileIntoList(String fileUrl){
		List<String> lines= Collections.emptyList();
		try {
			lines= Files.readAllLines(Paths.get(fileUrl),StandardCharsets.UTF_8 );
		} catch (IOException e) {
			System.out.println("Can't read file into list");
		}
		return lines;
	}   
	
	/**
	 * Is a public method used to get the ArrayList highScoresList that contains high scores for each level
	 * @return returns the highScoresList ArrayList
	 */
	public ArrayList<String> getHighScoresList(){
		return highScoresList;
	}
	
	/**
	 * Is used to get the score without the name of the user for level specified by the parameter of the method
	 * @param numOfLevel level for which high score is need
	 * @return returns the high score of that particular level
	 */
	public int getHighScoreForLevel(int numOfLevel) {
		return Integer.parseInt((highScoresList.get(numOfLevel).split(":")[1])) ;
	}	
}
