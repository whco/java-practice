class test{
    void increase(HelloWorld h){
        ++h.count;
    }
}
class HelloWorld {
    int count = 0;
    public static void main(String[] args){
        HelloWorld hello = new HelloWorld();
        int i = 0;
        test t = new test();
        t.increase(hello);
        System.out.println(hello.count);


        //System.out.printf("%f", f);
    }
}
