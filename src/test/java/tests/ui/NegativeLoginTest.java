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

@RunWith(Parameterized.class)
public class NegativeLoginTest extends BaseTest{

    private LoginPage loginPage;
    private String username;
    private String password;

    public NegativeLoginTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Parameterized.Parameters
    public static List<String[]> data(){
        List<String[]> result = new ArrayList<>();
        result.add(new String[]{"BkuSo", "h23kjhr"});
        result.add(new String[]{"admin", "admin"});
        result.add(new String[]{"user", "user"});
        result.add(new String[]{"<script>alert(\"Error!\")</script>", "123qweqwe"});
        result.add(new String[]{"jklwg", "<script>alert(\"Error!\")</script>"});
        result.add(new String[]{"admin", "#"});
        result.add(new String[]{"admin", " OR 1=1"});
        return result;
    }



//    public static List<Object[]> data(){
//        List<Object[]> result = new ArrayList<>();
//        readFile(getProperty("user.dir") + "/src/test/resources/testData/negative_login_data.txt").forEach(line -> result.add(line.split(", ")));
//        return result;
//    }

    @Test
    public void checkNegativeLogin(){
        loginPage.login(this.username,this.password);
        loginPage.validateErrorMessage("Incorrect username or password.");
    }


}