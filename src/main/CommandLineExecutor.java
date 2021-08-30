import java.util.*;

public class CommandLineExecutor {

    private final Map<String, Program> programs = new HashMap<>();
    private final List<String> response = new ArrayList<>();

    /**
     * Process each command line
     * @param command
     */
    public void run(Command command){
        response.add(command.toString());
        switch (command.getType()){
            case DEPEND:
                addPrograms(command.getDescription());
                break;
            case INSTALL:
                setInstalled(command, true);
                break;
            case REMOVE:
                setInstalled(command, false);
                break;
            case LIST:
                break;
            case END:
                break;
        }

    }

    private void setInstalled(Command command, boolean install){
        if (programs.containsKey(command.getDescription().get(0))){
            Program program = programs.get(command.getDescription().get(0));
            program.setInstalled(install);
            response.add("Installing "+ program.getName());
        }
    }

    private void addPrograms(List<String> elements){
        for(String element: elements) {
            if (!programs.containsKey(element)) {
                Program program = new Program(element);
                programs.put(element, program);
            }
        }
        addDependencies(elements);
    }

    /**
     * Add dependency into new program added
     * @param elements
     */
    private void addDependencies(List<String> elements){
        Program root = programs.get(elements.get(0));
        int i =1;
        while (i<elements.size()){
            root.setDependencies(programs.get(elements.get(i)));
            i++;
        }
    }

    public Map<String,Program> getPrograms() {
        return programs;
    }

    public String getResponse() {
        //TODO acomodar para que muestre bien
        return response.toString();
    }

}
