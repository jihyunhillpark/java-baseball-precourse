package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        while (true) {
            int ans[] = new int[3];
            int input[] = new int[3];
            getNumbeFromComputer(ans); // 1. user 가 맞춰야 할 난수를 생성 한 뒤 길이간 3인 int형 array에 보관
            getInputFromUser(input); // 2. user에게 인풋 받아오기
            // 3. user의 input 정합성 맞추기
            // 4. 다시 게임을 이어나갈지 종료할 것인지 받아옹기
        }
    }
    static void getNumbeFromComputer(int[] input){
        for (int i = 0; i < 3; i++) {
            input[i] = Randoms.pickNumberInRange(1, 9);
        }
    }
    static void getInputFromUser(int[] input) {
        System.out.println("숫자를 입력해 주세요 : ");
        char in[] = Console.readLine().toCharArray();
        for(int i = 0 ; i < 3 ; i++)
            input[i] = in[i];
    }
}
