package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtilsNew {

    public static void main(String[] args) {
        String name = getRandomStringNewzz(6);
        System.out.println(name);

        System.out.println(getRandomEmail(10));

        System.out.println(getRandomInt(10,15));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());


    }
    public static String getRandomStringNewzz(int length) {
            String AB = "ABdfhjhhFHGHGHgfhgjdhgLLLLLL";
            SecureRandom rnd = new SecureRandom();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
        }

        public static String getRandomEmail(int i){
        return getRandomStringNewzz(i) + "@gmail.ru" ;
        }

        public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min , max + 1);
        }

        public static String getRandomPhone(){
        return String.format("+%s(%s)-%s-%s", getRandomInt(7,7), getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
        }

        public static String getRandomGender(){
        String[] arrayGender = {"Male", "Female", "Other"};

        return getRandomGenderFromArray(arrayGender);
        }

        public static String getRandomGenderFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);

        return array[index];
        }
    }