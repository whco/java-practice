package etc;

import java.util.ArrayList;

public class FightClub {
    static ArrayList<Match> matches = new ArrayList<>();
    static class Match {
        int winner;
        int loser;
        int day;

        public Match(int winner, int loser, int day) {
            this.winner = winner;
            this.loser = loser;
            this.day = day;
        }

        public void printMatch() {
            System.out.println("Day " + day + " winner : " + winner + ", loser : " + loser);
        }
    }

    public static void main(String[] args) {
        //day1
        addMatch(14, 13, 1);
        //day2
        addMatch(11, 5, 2);
        addMatch(6, 10, 2);
        addMatch(1, 4, 2);
        addMatch(8, 9, 2);
        addMatch(12, 3, 2);
        addMatch(7, 2, 2);
        //day3
        addMatch(5, 14, 3);
        addMatch(11, 14, 3);
        addMatch(1, 3, 3);
        addMatch(12, 4, 3);
        addMatch(9, 10, 3);
        addMatch(8, 2, 3);
        //print
        printAllMatches();
    }

    static void addMatch(int w, int l, int d) {
        matches.add(new Match(w, l, d));
    }

    static void printAllMatches() {
        for (Match m : matches) {
            m.printMatch();
        }
    }

}
