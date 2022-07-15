import java.util.ArrayList;
import java.util.Arrays;

public class Decoder {

    /*
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * the 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
     * to your decode method, you should return : [ "*HX", "bco/7" ]
     *
     * You should NEVER return null or an array containing null
     */
    public static String [] decode(int[] forbidden, String[][] sentences){
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (String[] sentence: sentences) {
            for (String word: sentence) {
                boolean isForbidden = false;
                if (forbidden != null){
                    for (int forbid:forbidden) {
                        if (forbid == Integer.parseInt(word)){
                            isForbidden = true;
                        }
                    }
                }
                if (!isForbidden){
                    builder.append((char) Integer.parseInt(word));
                }
            }
            list.add(builder);
            builder = new StringBuilder();
        }

        String[] output = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            output[i] = String.valueOf(list.get(i));
        }

        return output;


    }

}