package programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//        Input string: codereview is awesome
//        Output string: awesome is codereview

public class Reversewords {
    private static String reverseWords(String input) {
        String[] splitted = input.split(" ");
        List<String> list = Arrays.asList(splitted);
        Collections.reverse(list);
      //  return String.join(" ", list); //java 1.8
        return input;
    }
    public static String reverseWords1(String sentence) {
        String[] parts = sentence.split(" ");

        StringBuilder builder = new StringBuilder();
        builder.append(parts[parts.length - 1]);

        for (int i = parts.length - 2; i >= 0; --i) {
            builder.append(" ").append(parts[i]);
        }

        return builder.toString();
    }
}
