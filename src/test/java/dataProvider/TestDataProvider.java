import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider
    public Object[][] wrongPasswords() {
        return new Object[][]{
                {"qwerty1234$"},
                {"QWERTY1234$"},
                {"Qwerty1234"},
                {"Qwerty$"}};
    }

    @DataProvider
    public Object[][] invalidEmails() {
        return new Object[][]{
                {"example.com"},
                {"A@b@c@domain.com"},
                {"ab(c)d,e:f;gij\\k]l@domain.com"}};
    }

    @DataProvider
    public Object[][] invalidPasswords() {
        return new Object[][]{
                {"Qwert1!"},
                {"QWERTY1234$"},
                {"qwerty1234%"},
                {"Qwerty!@$"},
                {"Qwerty1234"}};
    }
}