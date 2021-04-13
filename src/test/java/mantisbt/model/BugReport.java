package mantisbt.model;

import java.io.File;

public class BugReport {

    private String Title;
    private String Description;
    private File file;

    public String getTitle() {
        return Title;
    }

    public BugReport withTitle(String title) {
        Title = title;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public BugReport withDescription(String description) {
        Description = description;
        return this;
    }

    public File getFile() {
        return file;
    }

    public BugReport withFile(File file) {
        this.file = file;
        return this;
    }

    @Override
    public String toString() {
        return "BugReport{" +
                "Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", file=" + file +
                '}';
    }
}
