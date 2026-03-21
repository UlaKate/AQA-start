package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class TestRandomData {
    Faker faker = new Faker();

    String [] arrayGenders = {"Male", "Female", "Other"},
            arrayHobbies = {"Sports", "Reading", "Music"},
            arraySubjects = {"Maths", "Art","Physics", "English", "Computer Science", "Hindi", "Commerce"},
            arrayMonth = {"January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"},
            arrayPictures = {"002.jpeg", "001.png", "003.bmp"},
            arrayState = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public String firstName = faker.name().firstName(),
                  lastName = faker.name().lastName(),
                  emai = faker.internet().emailAddress(),
                  phoneNumber = faker.phoneNumber().subscriberNumber(10),
                  currentAddress = faker.address().fullAddress(),
                  gender = getRandomItemFromArray(arrayGenders),
                  hobbie = getRandomItemFromArray(arrayHobbies),
                  subject = getRandomItemFromArray(arraySubjects),
                  picture = getRandomItemFromArray(arrayPictures),
                  day = String.format("%02d",faker.number().numberBetween(1,29)),
                  month = getRandomItemFromArray(arrayMonth),
                  year = String.valueOf(getRandomInt( 1900, 2020)),
                  state = getRandomItemFromArray(arrayState),
                  city = getCity();


    public  String getCity(){
        if (state.equals("NCR"))
           city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh"))
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana"))
            city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan"))
            city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
        }


    public static String getRandomItemFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min,max + 1);
    }
}
