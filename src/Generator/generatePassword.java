package Generator;

import java.util.Random;

public class generatePassword {
    private static String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String lowerCaseAlphabet = upperCaseAlphabet.toLowerCase();
    private static String numbers = "1234567890";
    private static String specialValues = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String[] array = {upperCaseAlphabet, lowerCaseAlphabet, numbers, specialValues};

    public static StringBuilder createPassword (int length){
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++){
            String temporary = array[random.nextInt(4)];
            password.append(temporary.charAt(random.nextInt(temporary.length())));
        }
        return password;
    }
}
