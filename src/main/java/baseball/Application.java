package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        boolean flag = true;
        while (flag) {
            int[] ans = new int[3];
            int[] input = new int[3];
            getNumbeFromComputer(ans); // 1. user 가 맞춰야 할 난수를 생성 한 뒤 길이간 3인 int형 array에 보관
            while(true){
                getInputFromUser(input); // 2. user에게 인풋 받아오기
                if(compareAnswerAndFinish(ans, input) == 1) { // 3. user의 input 정합성 맞추기
                    if(!restartGame())// 4. 다시 게임을 이어나갈지 종료할 것인지 받아오기 - 2를 눌렀을 경우 false 가 return 됨.
                        flag = false;
                    break;
                }
            }
        }
        System.out.println("게임 끝");
    }

    static void getNumbeFromComputer(int[] input) {
        boolean[] visit = new boolean[9];
        int i = 0;
        while( i < input.length){
            int num = Randoms.pickNumberInRange(1, 9);
            if ( !visit[num-1] ) {
                input[i] = num;
                visit[num-1] = true;
                i++;
            }
        }
    }

    static void getInputFromUser(int[] input) {
        boolean flag = true;
        while(flag) {
            flag = false;
            System.out.print("숫자를 입력해 주세요 : ");
            char[] in = Console.readLine().toCharArray();
            if(in.length != 3) System.out.println("[ERROR]");
            for (int i = 0; i < input.length; i++) {
                input[i] = in[i]-'0';
                if(input[i] < 1 || 9 < input[i]) {
                    System.out.println("[ERROR]");
                    flag = true;
                    break;
                }
            }
        }
    }

    private static int compareAnswerAndFinish(int[] ans, int[] input) {
        int balls = 0;
        int strikes = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (input[i] == ans[j]) {
                    if (i == j ) strikes++;
                    else balls++;
                }
            }
        }
        printResult(balls, strikes);
        if(strikes == 3) return 1;
        return 0;
    }
    private static void printResult(int balls, int strikes){
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            if (strikes > 0) System.out.print(strikes + "스트라이크 ");
            if (balls > 0) System.out.print(balls + "볼");
            System.out.println();
            if (strikes == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
    }
    private static boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while(true) {
            int res = Integer.parseInt(Console.readLine());
            if(res == 1) return true;
            else if (res == 2) return false;
            else {
                System.out.println("[ERROR]");
            }
        }
    }

}
