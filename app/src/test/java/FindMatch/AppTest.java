/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package FindMatch;

import org.junit.*;
import static org.junit.Assert.*;
import FindMatch.controller.GameController;
import FindMatch.view.GameView;
import FindMatch.model.MatchValidator;

public class AppTest {
    private GameController controller;
    private GameView game;

    //Initiate objects required for testing
    @Before
    public void setUp() {
        controller = new GameController();
        game = new GameView(controller);
    }

    //Test the Easy Button functionality
    @Test 
    public void testEasyButton() {
        game.easyButton.doClick();
        int gridSize = controller.getGridSize();
        assertEquals(gridSize,4);
    }

    //Test the Medium Button functionality
    @Test 
    public void testMediumButton() {
        game.mediumButton.doClick();
        int gridSize = controller.getGridSize();
        assertEquals(gridSize,16);
    }

    //Test the Hard Button functionality
    @Test 
    public void testHardButton() {
        game.hardButton.doClick();
        int gridSize = controller.getGridSize();
        assertEquals(gridSize,36);
    }

    //Test the match not found message displayed correctly on GUI
    @Test 
    public void testNoMatch() {
        MatchValidator matchval = new MatchValidator(4);
        matchval.buttons[0].doClick();
        matchval.buttons[1].doClick();
        if (matchval.buttons[0].getText() == " " &&
            matchval.buttons[1].getText() == " ") {
                String msg = matchval.status.getText();
                assertEquals("Incorrect Match \uD83D\uDC4E",msg);
            }
    }

    //Test the allFound method in negative case
    @Test 
    public void testNotAllFound() {
        MatchValidator matchval = new MatchValidator(4);
        matchval.buttons[0].doClick();
        matchval.buttons[1].doClick();
        matchval.buttons[2].doClick();
        boolean found = matchval.allFound();
        assertEquals(false,found);
    }

    //Test the score decrementing functionality
    @Test 
    public void testScoreDecrement() {
        MatchValidator matchval = new MatchValidator(4);
        int oldScore = matchval.score_val;
        matchval.buttons[0].doClick();
        matchval.buttons[1].doClick();
        if (matchval.buttons[0].getText() == " " &&
            matchval.buttons[1].getText() == " ") {
                int newScore = matchval.score_val;
                assertEquals(oldScore-1,newScore);
            }
    }
}
