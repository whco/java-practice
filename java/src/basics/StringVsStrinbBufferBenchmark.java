package basics;

public class StringVsStrinbBufferBenchmark {
    public static void main(String[] args) {
        long size = (long) 1e5;
        long bt = System.nanoTime();
        String s = "";
        for (int i = 0; i < size; i++) {
            s  += (char) (i % 10 + '0');
        }
        long at = System.nanoTime();
        System.out.println("String : " + (at - bt) / (long) 1e6 + "ms");

        long bt2 = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append((char) (i % 10 + '0'));
        }
        long at2 = System.nanoTime();
        System.out.println("StringBuffer : " + (at2 - bt2) / (long) 1e6 + "ms");
    }

}
