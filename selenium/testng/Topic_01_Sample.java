package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_01_Sample {
    
    private int getRandomNumber(){
        return new Random().nextInt(1000000);
    }

    @Test
    public void testGetRandomNumber_shouldReturnValidRandomNumber() {
        Topic_01_Sample topic01Sample = new Topic_01_Sample();
        int randomNumber = topic01Sample.getRandomNumber();
        System.out.println(randomNumber);
        Assert.assertTrue(randomNumber >= 0 && randomNumber < 1000000);
    }

            
}
