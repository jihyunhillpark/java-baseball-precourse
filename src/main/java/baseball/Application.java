package baseball;
import nextstep.utils.Console.*;
import nextstep.utils.Randoms;
import nextstep.utils.Randoms.*;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        // 1. user 가 맞춰야 할 난수를 생성 한 뒤 길이간 3인 int형 array에 보관
        int ans[] = new int[3];
        for(int i = 0 ; i < 3 ; i++)
            ans[i] = Randoms.pickNumberInRange(1,9);
        // 2.
    }
}
