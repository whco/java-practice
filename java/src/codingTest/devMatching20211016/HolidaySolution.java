package codingTest.devMatching20211016;

public class HolidaySolution {
    public int solution(int leave, String day, int[] holidays) {
        boolean[] hd = new boolean[31];
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        for (int holiday : holidays) {
            hd[holiday] = true;
        }
        int dayStart = 0;
        for (int i = 0; i < 7; i++) {
            if (days[i].equals(day)) {
                dayStart = i;
                break;
            }
        }

        for (int i = 1; i <= 30; i++) {
            int d = (dayStart + i - 1) % 7;
            if(d == 5 || d == 6)
                hd[i] = true;
        }


        int max = leave;
        for (int i = 1; i <= 30; i++) {
            if(hd[i])
                continue;
            //복사 후 채워넣기
            boolean[] hdCopy = new boolean[31];
            for (int j = 0; j < 31; j++) {
                hdCopy[j] = hd[j];
            }
            int fillIter = i;
            int left = leave;
            while (left > 0 && fillIter <= 30) {
                if (hdCopy[fillIter]) {
                    ++fillIter;
                    continue;
                } else {
                    hdCopy[fillIter++] = true;
                    --left;
                }
            }


            //연속휴가계산
            int subMax = 0;
            int cnt = 0;
            for (int j = 1; j <= 30; j++) {

                if(hdCopy[j] && j != 30)
                    ++cnt;
                else{
                    if(j == 30 && hdCopy[j])
                        ++cnt;
                    if(cnt > subMax) {
                        subMax = cnt;
//                        System.out.println("subMax changed at day " + i);
//                        System.out.println("j : " + j + ", cnt : " + cnt);
                    }
                    cnt = 0;
                }
            }

            //max랑 비교
            if(subMax > max)
                max = subMax;

        }

        return max;
    }

    public static void main(String[] args) {
        int leave = 4;
        String day = "FRI";
        int[] holidays = {6, 21, 23, 27, 28};
        HolidaySolution hs = new HolidaySolution();
        System.out.println(hs.solution(leave, day, holidays));
    }
}
