package mantisbt.generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import mantisbt.model.BugReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class BugDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<BugReport> bugList = generateBugs(count);
        saveJson(bugList, file);
    }

    private static void saveXml(List<BugReport> bugList, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("BugReport", BugReport.class);
        String xml = xstream.toXML(bugList);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private static void saveJson(List<BugReport> bugList, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(bugList);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private static void saveCsv(List<BugReport> bugList, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (BugReport bug : bugList) {
            writer.write(String.format("%s, %s, %s\n", bug.getTitle(), bug.getDescription(), bug.getFile()));
        }
        writer.close();
    }

    private static List<BugReport> generateBugs(int count) {
        List bugReports = new ArrayList();
        File photo = new File("src/test/resources/ok.jpeg");
        for (int i=1; i < count + 1; i++) {
            bugReports.add(new BugReport().withTitle("Bug title "+ Instant.now().getEpochSecond() * i)
                    .withDescription("Description "+ Instant.now().getEpochSecond()).withFile(photo.getAbsoluteFile()));
        }
        return bugReports;
    }
}
