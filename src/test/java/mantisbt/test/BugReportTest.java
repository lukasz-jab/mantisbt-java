package mantisbt.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import mantisbt.model.BugReport;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BugReportTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> xmlValidBugs() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/bugReports.xml"));
        String line = reader.readLine();
        String xml = "";
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        reader.close();
        XStream xstream = new XStream();
        xstream.alias("BugReport", BugReport.class);
        List<BugReport> bugs = (ArrayList<BugReport>)xstream.fromXML(xml);
        return bugs.stream().map((g) -> new Object[] {g} ).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> jsonValidBugs() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/bugReports.json"));
        String line = reader.readLine();
        String json = "";
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        reader.close();
        Gson gson = new Gson();
        List<BugReport> bugs = gson.fromJson(json, new TypeToken<List<BugReport>>() {}.getType());
        return bugs.stream().map((g) -> new Object[] {g} ).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validBugs() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/bugReports.csv"));
        String line = reader.readLine();
        String csv = "";
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[] {new BugReport().withTitle(split[0]).withDescription(split[1]).withFile(new File(split[2]))});
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @Test(dataProvider = "jsonValidBugs")
    public void testBugReport(BugReport bugReport) {
        app.session().login(properties.getProperty("web.userLogin"), properties.getProperty("web.userPassword"));
//        File photo = new File("src/test/resources/ok.jpeg");
//        BugReport bugReport = new BugReport().withTitle("Title " + Instant.now().getEpochSecond())
//                .withDescription("Description " + Instant.now()).withFile(photo);
        app.navigation().openBugReportPage();
        app.bugReport().createBugReport(bugReport);
        app.session().logout();
    }
}
