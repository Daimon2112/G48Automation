package tests.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helpers.FileHelper.readFile;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class IssueCreationTest extends BaseTest{

    private  LoginPage page;
//    private List<String> labels = new ArrayList<>();
    private String title;
    private String body;
    private List<String> labels;

    public IssueCreationTest(String title, String body, List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Before
    public void prepareData(){
        this.page = new LoginPage(this.driver);
//        labels.add("bug");
//        labels.add("invalid");
    }

    @Parameterized.Parameters
    public static List<Object[]> fileData(){
        List<Object[]> result = new ArrayList<>();
        List<String> dataFromFile = readFile("src/main/resources/issuesDZ");
        for (String line: dataFromFile){
            String[] temp = line.split(", ");
            result.add(new Object[]{temp[0], temp[1], Arrays.asList(temp[2].split("; "))});
        }
        return result;
    }

    @Test
    public void checkIssueCreationDz(){
        this.page.login(getProperty("username"), getProperty("password"))
                .openProjectG48()
                .openIssues()
                .openCreationPage()
                .createNewIssue(
                        title,
                        body, labels)
                .validateIssue(title,
                        body, labels)
                .logout();

    }



//    @Parameterized.Parameters
//    public static List<Object[]> tree(){
//        List<Object[]> result = new ArrayList<>();
//        List<String> dataFromFile =  readFile("src/main/resources/issuesDZ");
//        for (String line: dataFromFile){
//            String[] temp = line.split(", ");
//            result.add(new Object[]{temp[0], temp[1], Arrays.asList(temp[2].split("; "))});
//
//        }
//        //          .forEach(line -> result.add((line.split(", , "))))
//        //result.add(new String[]{"adminUser", "adminPassword"});
//        //result.add(new String[]{"testUser", "testPassword"});
//        return result;
//    }



    @Test
    public void homeworkCreateIssue(){
        this.page.login(getProperty("username"), getProperty("password"))
                .openProjectG48()
                .openIssues()
                .openCreationPage()
                .createNewIssue(
                        "Automated Issue Title",
                        "Test body. Please ignore me!", labels)
                .validateIssue("Automated Issue Title",
                        "Test body. Please ignore me!", labels)
                .logout();

    }


}
