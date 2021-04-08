public class Recepie {
    private String level;
    private String name;
    private String steps;
    private String time;
    public Recepie(String level, String name, String Steps, String time)
    {
        this.level = level;
        this.name = name;
        this.steps = Steps;
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getSteps() {
        return steps;
    }

    public String getTime() {
        return time;
    }
}
