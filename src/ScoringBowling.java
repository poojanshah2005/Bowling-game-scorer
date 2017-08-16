
public class ScoringBowling {
	public static void main(String[] args){
        System.out.println(scoreBowling("X -/ X 5- 8/ 9- X 81 1- 4/X"));
        System.out.println(scoreBowling("62 71  X 9- 8/  X  X 35 72 5/8"));
        System.out.println(scoreBowling("X X X X X X X X X XXX"));
    }

    private static int scoreBowling(String currentScore)
    {
        String scoreZeroed = currentScore.replace('-','0');
        String scoreWhitespace = scoreZeroed.replaceAll("  "," ");
        String[] scoreSplit = scoreWhitespace.split(" ");

        int totalScore = 0;
        Integer[] scores = new Integer[10];
        Integer[] ballOne = new Integer[10];
        Integer[] ballTwo = new Integer[10];
        boolean[] strikes = new boolean[10];
        boolean[] spares = new boolean[10];

        for (int i = 0; i < scoreSplit.length; i++)
        {
            if (scoreSplit[i].equals("X")) {
                ballOne[i] = 10;
                scores[i] = 10;
                strikes[i] = true;
            } else if (scoreSplit[i].matches("[0-9][0-9]")) {
                ballOne[i] = Integer.parseInt(scoreSplit[i].substring(0,1));
                ballTwo[i] = Integer.parseInt(scoreSplit[i].substring(1,2));
                scores[i] = ballOne[i] + ballTwo[i];
            } else if (scoreSplit[i].matches("[0-9]/")) {
                ballOne[i] = Integer.parseInt(scoreSplit[i].substring(0,1));
                ballTwo[i] = 10 - ballOne[i];
                scores[i] = 10;
                spares[i] = true;
            } else if (scoreSplit[i].matches("[0-9]/X")) {
                ballOne[i] = Integer.parseInt(scoreSplit[i].substring(0,1));
                ballTwo[i] = 10 - ballOne[i];
                scores[i] = 20;
            } else if (scoreSplit[i].matches("[0-9]/[0-9]")) {
                ballOne[i] = Integer.parseInt(scoreSplit[i].substring(0,1));
                ballTwo[i] = 10 - ballOne[i];
                scores[i] = 10 + Integer.parseInt(scoreSplit[i].substring(2,3));
            } else if (scoreSplit[i].matches("X[0-9][0-9]")) {
                ballOne[i] = 10;
                ballTwo[i] = Integer.parseInt(scoreSplit[i].substring(1,2));
                scores[i] = ballOne[i] + ballTwo[i] + Integer.parseInt(scoreSplit[i].substring(2,3));
            } else if (scoreSplit[i].matches("X[0-9]/")) {
                ballOne[i] = 10;
                ballTwo[i] = Integer.parseInt(scoreSplit[i].substring(1,2));
                scores[i] = 20;
            } else if (scoreSplit[i].equals("XXX")) {
                ballOne[i] = 10;
                ballTwo[i] = 10;
                scores[i] = 30;
            } else {
                scores[i] = 0;
            }
        }

        for (int i = 0; i < scores.length; i++)
        {
            if (i == scores.length - 1) {
                totalScore += scores[i];
            } else {
                if (strikes[i]) {
                    if (ballTwo[i + 1] != null) {
                        totalScore += scores[i] + ballOne[i + 1] + ballTwo[i + 1];
                    } else {
                        totalScore += scores[i] + ballOne[i + 1] + ballOne[i + 2];
                    }
                } else if (spares[i]) {
                    totalScore += scores[i] + ballOne[i + 1];
                } else {
                    totalScore += scores[i];
                }
            }
        }

        return totalScore;
    }
}

