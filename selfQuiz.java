
public class selfQuiz {
    public static void main(String[] args) {

        // Quiz 1
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == j)
                    continue;
                System.out.print(i + j + " ");
            }
        }

        // Quiz 2
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + "-");
        }

        // Quiz 3
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2)
                    break;
                System.out.print(i + j + " ");

            }

        }

    }
}
