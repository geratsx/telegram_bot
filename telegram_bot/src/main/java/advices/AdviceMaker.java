package advices;

import java.util.Random;



public class AdviceMaker {

    public static String getRandomAdvice() {
        Random random = new Random();
        int result = random.nextInt(Advices.values().length);
        String message = Advices.values()[result].getAdvice();
//       System.out.println(Advices2.values()[0].getAdvice());
// о
// System.out.println(Advices.values()[result].getAdvice());

        return message;
    }
}
