package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assert {

    @Test
    public void test01() {
        String fullName = "Automation FC";
        Assert.assertEquals(fullName,"Automation DC", "Fullname not equal");
    }
}
