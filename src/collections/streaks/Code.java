package collections.streaks;

import com.sun.source.tree.BreakTree;

import java.util.*;

public class Code {

    public static List<List<String>> getStreakList(String input) {
        LinkedList<List<String>> answer = new LinkedList<>();
        for (char cha: input.toCharArray()){
            String stringCharacter = String.valueOf(cha);
            if(answer.size() == 0){
                answer.add(new ArrayList<>(Arrays.asList(stringCharacter)));
            } else if (answer.getLast().contains(stringCharacter)){
                answer.getLast().add(stringCharacter);
            } else {
                answer.add(new ArrayList<>(Arrays.asList(stringCharacter)));
            }
        }
        return answer;
    }
}
