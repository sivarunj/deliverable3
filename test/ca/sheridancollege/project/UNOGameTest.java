package ca.sheridancollege.project;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UNOGameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testUNOGameInitialization() {
        UNOGame unoGame = new UNOGame("UNO Test");
        assertNotNull(unoGame);
        assertEquals("UNO Test", unoGame.getName());
    }


    @Test(expected = NoSuchElementException.class)
    public void testUNOGamePlayWithInvalidInput() {
        // Prepare mock user input with no input
        InputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);

        // Create an instance of UNOGame and play
        UNOGame unoGame = new UNOGame("UNO Test");
        unoGame.play();
    }


}