import com.greg.console.JCommand;

public class JCommandForTest extends JCommand<String> {

    public String ExpectedOutputForTest;

    public JCommandForTest(String commandName) {
        super(commandName);
        this.ExpectedOutputForTest = "TESTED";
    }
    
    @Override
    public String Invoke(String[] params) {
        return "TESTED";
    }
}
