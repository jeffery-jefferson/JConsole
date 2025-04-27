import com.greg.console.JCommand;

public class JCommandForTest extends JCommand<String> {

    public String ExpectedOutputForTest;

    public JCommandForTest(String commandName) {
        super(commandName);
        this.ExpectedOutputForTest = "TESTED";
    }
    
    @Override
    public String Invoke(String[] params) {
        if (params.length == 0) {
            return "TESTED";
        } else if (params.length == 1) {
            switch (params[0]) {
                case "ONE": return "ONED";
                case "TWO": return "TWOD";
                case "THREE": return "THREED";
                default: return "DEFAULTED";
            }
        }
        return "...";
    }
}
