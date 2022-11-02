public class BaekJoon8958 {

    public int getScore(String quizAnswer) {
        int score = 0;
        int count = 0;

        for (int i = 0; i < quizAnswer.length(); i++) {
            if (quizAnswer.charAt(i) == 'O') {
                count++;
                score += count;
                continue;
            }

            count = 0;
        }

        return score;
    }
}
