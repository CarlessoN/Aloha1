import java.util.List;

public class Command {
    private CommandType type;
    private List<String> description;

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return type +
                " " + description.toString();
    }
}
