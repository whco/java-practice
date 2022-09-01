package study.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IO {
    final static String FILE_PATH = "C:\\Users\\heejae_shin\\dev\\practice\\personal\\java-pracice\\java-practice\\java\\src\\study\\io\\big.txt";
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        FileReader fileReader = new FileReader(FILE_PATH);

        while (fileReader.read() != -1) {

        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        long startTime2 = System.currentTimeMillis();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));

        while (bufferedReader.read() != -1) {

        }

        long endTime2 = System.currentTimeMillis();

        System.out.println(endTime2 - startTime2);
    }
}
