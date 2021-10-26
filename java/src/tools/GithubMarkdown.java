package tools;

public class GithubMarkdown {
    public static void headerNamesTransform(String s) {
        String[] names = s.split("\n");
        for(String name : names) headerNameTransform(name);
    }

    public static String headerNameTransform(String s) {
        StringBuffer sb = new StringBuffer();
        sb.append('#');
        for(char c : s.toCharArray()){
            if(c == ' ') {
                if(sb.length() != 1) sb.append('-');
                else continue;
            }
            else if("!#$%&'()*+,-./:;<=>?@[]^_`{|}~".contains(c + "")) continue;
            else sb.append(c);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        headerNamesTransform("## 1 ~ 2 장 : 컴퓨터 시스템과 운영체제 개요\n" +
                "## 3 ~ 6 장 : 프로세스 관리\n" +
                "## 7 ~ 8 장 : 메모리 관리\n" +
                "## 9 ~ 10 장 : 장치 관리 및 파일 관리\n" +
                "## 11 ~ 12 장 : 분산 및 보호\n" +
                "## 13장 : 유닉스 운영체제");
    }
}
