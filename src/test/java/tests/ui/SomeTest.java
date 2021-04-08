
package tests.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static helpers.FileHelper.readFile;
import static helpers.FileHelper.writeFileAndGet;

@RunWith(Parameterized.class)
public class SomeTest {

    private String username;
    private String password;

    public SomeTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Parameterized.Parameters
    public static List<String[]> data(){
        List<String[]> result = new ArrayList<>();
        result.add(new String[]{"adminUser", "adminPassword"});
        result.add(new String[]{"testUser", "testPassword"});
        return result;
    }

    @Test
    public void showUsernameAndPassword(){
        System.out.println("Login: " + this.username);
        System.out.println("Password: " + this.password);
    }

    @Test
    public void some(){
        System.out.println(readFile("/Users/dmytromyrhorodchenko/IdeaProjects/G48Automation/src/main/resources/test"));
        List<String> data = new ArrayList<>();
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");

        readFile(String.valueOf(writeFileAndGet(data, "our_test.txt"))).forEach(System.out::println);
    }

//    @Test
//    public void someExcel(){
//        readDataFromExcelFile(
//                writeToExcelFileAndGet(
//                        "/Users/dmytromyrhorodchenko/IdeaProjects/G48Automation/src/main/resources/testData/exel_out.xls",
//                        readDataFromExcelFile(
//                                "src/test/resources/testData/excel_out.xls",
//                                "Sheet1")).getPath(), "Automated Sheet")
//                .forEach(System.out::println);
//    }

//    @Test
//    public void someExelnew(){
//        readDataFromExelFIle(writeFileAndGet(
//                "/Users/dmytromyrhorodchenko/IdeaProjects/G48Automation/target/generated-test-sources/test-annotations/outputExel.xls",
//                readDataFromExelFIle(
//                        "/Users/dmytromyrhorodchenko/IdeaProjects/G48Automation/src/main/resources/testData/exel_out.xls",
//                "Sheet1")).getPath(),"Automate Sheet").forEach(System.out::println);
//        ;
//    }





}