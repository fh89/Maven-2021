package Action_Items;

import java.util.jar.JarEntry;

public class ActionItem1 {

    public static void main(String[] args) {
        String[] zipCode = new String[5];

        zipCode[0] = "08816";
        zipCode[1] = "08817";
        zipCode[2] = "08818";
        zipCode[3] = "08819";
        zipCode[4] = "08820";

        int[] streetNumber = new int[]{1,2,3,4,5};


        for (int i = 0; i < zipCode.length; i++){

            System.out.println("My zip code is " + zipCode[i] + " and my street number is " + streetNumber[i]);
        }
    }
}
