package codingTest.devMatching20211016;

import java.util.HashSet;

public class IdReferenceSolution {
    public String solution(String[] registered_list, String new_id) {
        HashSet<String> regId = new HashSet<>();
        for (String rl : registered_list) {
            regId.add(rl);
        }
        if(!regId.contains(new_id))
            return new_id;
        else{
            while (regId.contains(new_id)) {
                int i = 0;
                boolean numEmpty = true;
                for (; i < new_id.length(); i++) {
                    if (Character.isDigit(new_id.charAt(i))) {
                        numEmpty = false;
                        break;
                    }
                }
                String s = new_id.substring(0, i);
                String n = numEmpty ? "0" : new_id.substring(i);
                int nPlusOne = Integer.parseInt(n) + 1;
                String n1 = Integer.toString(nPlusOne);
                new_id = s + n1;
                if (regId.contains(new_id)) {
                    return new_id;
                }
            }
        }
        return "";
    }
}
