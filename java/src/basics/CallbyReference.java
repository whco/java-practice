package basics;

public class CallbyReference {


    public static void main(String[] args) {
        A a1 = new A(1);
        A a2 = new A(2);

        a1.run(a1, a2);

        System.out.println(a1.value + " " + a2.value);
    }




}


class A {
    public int value;

    A(int i) {
        this.value = i;
    }

    void run(A arg1, A arg2) {
        arg1.value = 111;
        arg2 = arg1;
    }
}
