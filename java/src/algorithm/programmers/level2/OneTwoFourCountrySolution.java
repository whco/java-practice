package algorithm.programmers.level2;

class OneTwoFourCountrySolution {
    public String solution(int n) {
        char[] oneTwoFour = {'1', '2', '4'};
        StringBuffer sb = new StringBuffer();
        while(n != 0){
            sb.append(oneTwoFour[(n - 1) % 3]);
            n = (n - 1) / 3;
        }
        return sb.reverse().toString();
    }
}
