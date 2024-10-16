package models;

public class InstallationOptions {
    private int id;
    private String pathProgram;
    private String nameProgram;
    private AdditionalFile additionalFile;
    private Documentation documentation;

    // Конструктор
    public InstallationOptions(int id, String pathProgram, String nameProgram, AdditionalFile additionalFile, Documentation documentation) {
        this.id = id;
        this.pathProgram = pathProgram;
        this.nameProgram = nameProgram;
        this.additionalFile = additionalFile;
        this.documentation = documentation;
    }

    // Getters і Setters
    public int getId() {
        return id;
    }

    public String getPathProgram() {
        return pathProgram;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public AdditionalFile getAdditionalFile() {
        return additionalFile;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPathProgram(String pathProgram) {
        this.pathProgram = pathProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    public void setAdditionalFile(AdditionalFile additionalFile) {
        this.additionalFile = additionalFile;
    }

    public void setDocumentation(Documentation documentation) {
        this.documentation = documentation;
    }
}
