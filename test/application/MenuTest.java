package application;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobotException;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


class MenuTest extends MainTest{

	String SCORE_PANE_ID="#scorePane";
	Stage menuStage;
	 
	 
	 @BeforeEach
	    void setup() throws Exception {
	        ApplicationTest.launch(Main.class);
	        
	    }

	    @AfterEach
	    void cleanup() throws Exception {
	        FxToolkit.cleanupStages();
	    }
	@Test
	public void checkIfFindWorks(){
		Assertions.assertThrows(FxRobotException.class, () ->clickOn(".nothing") );
	}
	
	@Test
	public void checkForButtonScore() {
		 verifyThat(".button", hasText("Score"));
	}
	@Test
	public void checkForButtonExit() {
		lookup(hasText("Exit"));
		
		 
	}
	@Test
	public void checkForButtonHelp() {
		 
		lookup(hasText("Help"))   ;
		 
	}
	@Test
	public void checkForButtonPlay() {
		lookup(hasText("Play"))   ;
		 
	}
//	@Test 
//	public void checkIfExitButtonWorks() {
//		String EXIT_BUTTON="Exit";
//		clickOn(EXIT_BUTTON);
//		verifyThat("#mainPane",(Pane pane)-> {
//			return pane.isVisible();
//		});
//	}
	@Test
	public void ensureScorePaneFilled(){
		clickOn("Score");
		verifyThat("#scorePane", NodeMatchers.isNotNull());
	}
//	@Test
//	public void checkIfCircleChoosen() {
//		clickOn("Play");
//		sleep(3000);
//		clickOn("#circle1");
//		
//		sleep(3000);
//		verifyThat("#circle1",(ImageView im)-> {
//			return im.contains();
//		});
//	}
	
	@Test
	public void checkIfScorePaneShownOnButtonClick() {
		String SCORE_BUTTON="Score";
		clickOn(SCORE_BUTTON);
		verifyThat(SCORE_PANE_ID,(Pane pane)-> {
			return pane.isVisible();
		});
		
	}
	
}
