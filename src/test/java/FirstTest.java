import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    //КРАТНО 3, ВОЗВРАЩАТЬ 'T'
    //КРАТНО 5, ВОЗВРАЩАТЬ 'M'
    //КРАТНО 3 И 5, ВОЗВРАЩАТЬ 'S'
    //ВОЗВРАЩАТЬ 'FAIL'

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "S";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 3 == 0) {
            return "T";
        } else return "Fail";
    }

    @Test
    public void checkMetod1() {
        String actuelResult = trialCode(9);
        assertEquals(actuelResult, "T");
    }

    @Test
    public void checkMetod2() {
        String actuelResult = trialCode(25);
        assertEquals(actuelResult, "M");
    }

   @Test
   public void checkMetod3() {
       String actuelResult = trialCode(15);
       assertEquals(actuelResult, "S");
   }


   @Test
   public void checkMetod4() {
           String actuelResult = trialCode(17);
           assertEquals(actuelResult, "Fail");
    }
}