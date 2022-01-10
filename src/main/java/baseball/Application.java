package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        boolean go = true;
        while (go) {
            go = startUserTurn();
        }
        System.out.println("게임 끝");
    }

    private static boolean startUserTurn() {
        int[] ans = new int[3];
        int[] input = new int[3];
        getNumberFromComputer(ans); // 1. user 가 맞춰야 할 난수를 생성 한 뒤 길이간 3인 int형 array에 보관
        do {
            getInputFromUser(input); // 2. user에게 인풋 받아오기
        } while (!compareAnswer(ans, input)); // 3 strike가 나오면 게임이 끝남
        return restartGame();
    }

    private static void getNumberFromComputer(int[] input) {
        boolean[] visit = new boolean[9];
        int i = 0;
        while (i < input.length) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!visit[num - 1]) {
                input[i] = num;
                visit[num - 1] = true;
                i++;
            }
        }
    }

    private static void getInputFromUser(int[] input) {
        boolean isValid = false;
        while (!isValid) {
            System.out.print("숫자를 입력해 주세요 : ");
            isValid = isDigitsValid(input);
        }
    }

    private static boolean isDigitsValid(int[] input) {
        boolean[] visit = new boolean[9];
        char[] in = Console.readLine().toCharArray();
        if (in.length != 3) {
            System.out.println("[ERROR]"); // 인풋 길이가 잘못된 경우
            return false;
        }
        for (int i = 0; i < input.length; i++) {
            input[i] = in[i] - '0';
            if (input[i] < 1 || 9 < input[i] || visit[input[i] - 1]) {
                System.out.println("[ERROR]"); // 범위의 값을 입력하지 않거나 중복 숫자가 나온 경우
                return false;
            } else {
                visit[input[i] - 1] = true;
            }
        }
        return true;
    }

    private static boolean compareAnswer(int[] ans, int[] input) {
        int[] result = new int[2]; // 0 - strikes, 1 - balls
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                markResult(i, input[i], j, ans[j], result);
            }
        }
        printResult(result);
        return result[0] == 3;
    }

    private static void markResult(int idx, int input, int ansIdx, int ans, int[] result) {
        if (input == ans) {
            if (idx == ansIdx) {
                result[0]++;
            } else {
                result[1]++;
            }
        }
    }

    private static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            if (result[0] > 0) {
                System.out.print(result[0] + "스트라이크 ");
            }
            if (result[1] > 0) {
                System.out.print(result[1] + "볼");
            }
            System.out.println();
            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            }
        }
    }

    private static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            int res = Integer.parseInt(Console.readLine());
            if (res == 1) {
                return true;
            } else if (res == 2) {
                return false;
            } else {
                System.out.println("[ERROR]");
            }
        }
    }
}