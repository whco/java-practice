package basics;

public class TryCatch {
    public static void main(String[] args) {
//        throw new Error();
        int x = tryCatchFinally();
        System.out.println(x);

        try {
            throwCheckedException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        throwRunTimeException();
        System.out.println("here");
    }

    private static int tryCatchFinally() {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 2;
        }
    }


    private static void throwCheckedException() throws Exception {
        throw new Exception();
    }

    private static void throwRunTimeException() {
        throw new RuntimeException();
    }
}