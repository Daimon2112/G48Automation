
package tests.ui;

import dbModels.Users;
import org.javalite.activejdbc.DB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static helpers.FileHelper.readFile;
import static helpers.FileHelper.writeFileAndGet;

//import static helpers.DbHelper.executeQuery;
//import static helpers.DbHelper.executeQueryWithResult;
//import static helpers.ExcelHelper.*;
import static helpers.FileHelper.readFile;
import static helpers.FileHelper.writeFileAndGet;
import static org.junit.Assert.assertTrue;

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
        //result.add(new String[]{"testUser", "testPassword"});
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
        data.add("Я буду хорошим автоматизатором на 1");
        data.add("Я буду хорошим автоматизатором на 2");
        data.add("Я буду хорошим автоматизатором на 3");
        data.add("Я буду хорошим автоматизатором на 4");
        data.add("Я буду хорошим автоматизатором на 5");
        data.add("Я буду хорошим автоматизатором на 6");
        data.add("Я буду хорошим автоматизатором на 7");

        readFile(String.valueOf(writeFileAndGet(data, "our_test.txt"))).forEach(System.out::println);
    }
    @Test
    public void checkDbTest(){
        new DB("dmitrybase")
                .open(
                        "org.postgresql.Driver",
                        "jdbc:postgresql://localhost:5432/dmitrybase",
                        "postgres",
                        "postgres");
        //create
        new Users()
                .set("username", "test")
                .set("password", "test")
                .saveIt();
        //read
        System.out.println(
                Users.findFirst("username = ?", "admin"));
        //update
//        Users.findFirst("username = ?", "admin")
//                .set("password", String.valueOf(new Date().getTime()))
//                .saveIt();

        //delete
        Users.findFirst("username = ?", "test").delete();


        //delete from users where id = 3
        // System.out.println(Users.findById(1));

        new DB("dmitrybase").close();
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