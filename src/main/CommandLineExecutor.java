import java.util.ArrayList;
import java.util.List;

public class CommandLineExecutor {
    private List<String> dependencies = new ArrayList();
    private List<String> response = new ArrayList<>();
    public void run(Command command){
        switch (command.getType()){
            case DEPEND:
                if (dependencies.isEmpty()){
                    dependencies.addAll(command.getDescription());
                } else {
                    addDependence(command.getDescription());
                }
                response.add(command.toString());
                break;
            case INSTALL:
            case REMOVE:
            case LIST:
                response.add(command.toString());
                break;
            case END:
                break;
        }
    }

    private void addDependence(List<String> elements){
        List<String> temp = new ArrayList<>(elements);
        if (dependencies.stream().anyMatch(elements::contains)) {
            for (String element : elements) {
                if (dependencies.contains(element)) {
                    temp.remove(element);
                    if (dependencies.stream().noneMatch(temp::contains)) {
                        dependencies.addAll(temp);
                    } else {
                        //TODO
                    }
                }
            }
        } else {
            //TODO
            response.add(elements.get(0)+" does not exist");
        }
    }
    //Add to test
    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public String getResponse() {
        //TODO acomodar para que muestre bien
        return response.toString();
    }

}
