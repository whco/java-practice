package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        int mulResult = lcm / gcd;
        int a = 1, b = mulResult;
        int resultA = a * gcd, resultB = b * gcd;

//        HashMap<Integer, Integer> divisor = new HashMap<>();
//        while(mulResult != 1){
//            for (int i = 2; i <= mulResult; i++) {
//                if(mulResult % i == 0){
//                    divisor.put(i, divisor.getOrDefault(i, 0) + 1);
//                    mulResult /= i;
//                    break;
//                }
//            }
//        }

//        for (Integer key : divisor.keySet()) {
//            System.out.println(key + ", " + divisor.get(key));
//        }

        for (int i = 2; i * i <= mulResult; i++) {
            if(mulResult % i == 0){
                a = i;
                b = mulResult / i;
                boolean hasCommon = false;
                for (int j = 2; j * j<= b; j++) {
                    if(a % j == 0 && b % j ==0){
                        hasCommon = true;
                        break;
                    }
                }
                if(!hasCommon){
                    resultA = a * gcd;
                    resultB = b * gcd;
                }
            }
        }


        System.out.println(resultA + " " + resultB);

    }
}
