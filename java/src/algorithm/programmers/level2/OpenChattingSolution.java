package algorithm.programmers.level2;

import java.util.*;
class OpenChattingSolution {
    //hashmap id, name
    static HashMap<String, String> idNameMap = new HashMap<>();
    public String[] solution(String[] record) {
        //id, in out
        ArrayList<Record> records = new ArrayList<>();
        for(String r : record){
            String[] rSplit = r.split(" ");
            for(String s : rSplit) System.out.printf("%s ",s);
            System.out.println();
            if(rSplit[0].equals("Enter")){
                records.add(new Record(rSplit[1], true));
                idNameMap.put(rSplit[1], rSplit[2]);
            } else if(rSplit[0].equals("Leave")) {
                records.add(new Record(rSplit[1], false));
            } else if(rSplit[0].equals("Change")){
                idNameMap.replace(rSplit[1], rSplit[2]);
            }
        }
        System.out.println(idNameMap);

        String[] answer = new String[records.size()];
        for(int i = 0; i < answer.length; ++i) {
            answer[i] = convertRecord(records.get(i));
            System.out.println(answer[i]);
        }

        return answer;
    }

    public class Record{
        String id;
        boolean in;

        public Record(String id, boolean in){
            this.id = id;
            this.in = in;
        }
    }

    public static String convertRecord(Record record) {
        if(record.in) return idNameMap.get(record.id) + "님이 들어왔습니다.";
        else return idNameMap.get(record.id) + "님이 나갔습니다.";
    }


    public static void main(String[] args) {
        String[] record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        OpenChattingSolution s = new OpenChattingSolution();
        s.solution(record);
    }
}
