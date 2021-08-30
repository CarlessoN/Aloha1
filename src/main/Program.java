import java.util.ArrayList;
import java.util.List;

public class Program {
    private String name;
    private boolean installed;
    private List<Program> dependencies;

    public Program() {
    }

    public Program(String name) {
        this.name = name;
        this.installed = false;
        this.dependencies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public List<Program> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Program program) {
        this.dependencies.add(program);
    }
}
