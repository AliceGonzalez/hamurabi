package hammurabi;

import hammurabi.docs.matuszek.Hammurabi;
import org.junit.Assert;
import org.junit.Test;

public class HammurabiTesting {
    @Test

    public final void starvationDeathsTest(){
        Integer population = 10;
        Integer bushels = 100;
        Hammurabi hammurabi = new Hammurabi();
        Integer expected = 5;

        Integer retrievedPopulation = hammurabi.starvationDeaths(population, bushels);


        Assert.assertEquals(expected,retrievedPopulation);
    }
@Test
    public final void plagueDeathsTest(){
        Integer population = 60;
        Hammurabi hammurabi = new Hammurabi();
        hammurabi.plague = true;
        Integer expected = 30;

        Integer retrievedPopulation = hammurabi.plagueDeaths(population);

        Assert.assertEquals(expected,retrievedPopulation);
    }

}
