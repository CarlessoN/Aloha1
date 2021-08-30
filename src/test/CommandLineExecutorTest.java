import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommandLineExecutorTest {
    CommandLineExecutor executor = new CommandLineExecutor();

    @Test
    public void testRunInstall() throws Exception {
        Command command = new Command();
        List<String> descriptions = new ArrayList<>();
        descriptions.add("TCP");
        command.setType(CommandType.INSTALL);
        command.setDescription(descriptions);
        executor.run(command);
        assertEquals("[INSTALL [TCP]]",executor.getResponse());
    }

    @Test
    public void testDependencies() throws Exception {
        Command command = new Command();
        List<String> descriptions1 = new ArrayList<>();
        descriptions1.add("TELNET");
        descriptions1.add("TCPIP");
        descriptions1.add("NETCARD");
        List<String> descriptions2 = new ArrayList<>();
        descriptions2.add("NETCARD");
        descriptions2.add("DNS");
        command.setType(CommandType.DEPEND);
        command.setDescription(descriptions2);
        //executor.setDependencies(descriptions1);
        executor.run(command);
        //assertEquals("[TELNET, TCPIP, NETCARD, DNS]",executor.getDependencies().toString());
        assertEquals("[DEPEND [NETCARD, DNS]]",executor.getResponse());
    }
}
