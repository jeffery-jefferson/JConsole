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
        console.TryRegisterCommand(command);
        command.ExpectedOutputForTest = "TESTED";

        var result = console.RunCommand("TEST");

        assertEquals(command.ExpectedOutputForTest, result);
    }

    @Test
    @DisplayName("Prompt should execute command including arguments with proper return type.")
    void TestPromptWithArgs() {
        var command = new JCommandForTest("TEST");
        console.TryRegisterCommand(command);
        command.ExpectedOutputForTest = "ONED";

        var result = console.RunCommand("TEST ONE");

        assertEquals(command.ExpectedOutputForTest, result);
    }

    @Test
    @DisplayName("Prompt should return a false result when running a non-existent command.")
    void TestPromptWithUnrecognisedCommand() {
        var result = console.RunCommand("This doesn't exist");

        assertEquals(false, result);
    }

    @Test
    void TestPredefinedCommand_Help() {
        var result = console.RunCommand("help");

        assertEquals(true, result);
    }

    @Test
    void TestPredefinedCommand_List() {
        var result = console.RunCommand("commands");

        assertEquals(true, result);
    }
}
