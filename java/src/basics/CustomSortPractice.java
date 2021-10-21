package basics;

import java.util.*;

public class CustomSortPractice {
    public static void printList(List<Integer> l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.printf("%d ", l.get(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        int min = 0;
//        int max = 10;
//        //random int generation
//        int randomNum = ThreadLocalRandom.current().nextInt(min, max);
//        System.out.println(randomNum);

        int[] num = {7, 8, 3, 1, 2, 8, 5, 2, 5, 2};
        //list init
        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
//            int rd = ThreadLocalRandom.current().nextInt(min, max);
//            lst.add(rd);
            lst.add(num[i]);
        }
        printList(lst);
        //collection sort basic
        Collections.sort(lst);
        printList(lst);

        //object sorting
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("a", 5));
        studentList.add(new Student("b", 10));
        studentList.add(new Student("c", 1));
        studentList.add(new Student("d", 52));
        studentList.add(new Student("e", 23));
        Collections.sort(studentList);
        for (Student s : studentList) {
            System.out.println(s.getScore());
        }
        // -> no suitable method found

        //map init
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, num[i]);
        }

    }

}

class Student implements Comparable<Student> {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student s) {
        if (this.score < s.getScore()) {
            return -1;
        } else if (this.score > s.getScore()) {
            return 1;
        }
        return 0;
    }
}
