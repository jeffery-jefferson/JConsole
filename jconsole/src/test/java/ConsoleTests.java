import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.greg.console.JConsole;

public class ConsoleTests {

    JConsole console;

    @BeforeEach
    void setUp() {
        console = new JConsole();
    }

    @Test
    @DisplayName("Prompt should execute command with proper return type.")
    void TestPrompt() {
        var command = new JCommandForTest("TEST");
        console.TryAddCommand(command);
        command.ExpectedOutputForTest = "TESTED";

        var result = console.Prompt("TEST");
        
        assertEquals(command.ExpectedOutputForTest, result);
    }
}
