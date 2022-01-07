# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
1. getNumberFromComputer
   - 상대 플레이어가 중복없이 1-9까지의 수를 사용하여 서로 다른 수로 이루어진 3자리 수를 만든다.
2. getInputFromUser
   - 유저 플레이어로부터 세 자리의 수를 받아온다.
   - 조건1. 각 자리의 수는 1-9까지의 수여야 한다.
   - 조건2. 각 자리의 수는 서로 다른 수여야 한다.
   - 조건3. 조건 1,2를 포함하여 잘못된 값을 입력할 경우 "[ERROR]" 메시지를 출력한다. 
3. compareAnswerAndFinish
   - 유저 플레이어로부터 받아온 인풋 값이 상대 플레이어(컴퓨터)가 발생한 값과 같다면 1을 return
   - 유저 플레이어로부터 받아온 인풋 값이 상대 플레이어와 다르다면 ball과 strike를 파악하여 출력하고 0을 return
4. printResult
   - 유저에게 ball, strike에 대한 결과를 알려준다(ball과 strike가 없을 경우 "낫싱"이라고 알려준다.)
5. restartGame
   - 유저 플레이어로부터 게임 진행 여부에 대한 응답을 받아와, 1일 경우 새로운 게임을 실행한다.
   - 유저의 응답이 2라면 게임을 종료한다.
