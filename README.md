# 자바로 배우는 리팩토링 입문 정리
## 리팩토링이란
1. 리팩토링이란
- 리팩토링 정의
  - 리팩토링은 외부에서 보는 프로그램 동작은 변화되지 않아야하고 프로그램의 내부가 개선된다.
- 리팩토링과 유닛 테스트
  - 동작이 변하지 않은 걸 확인하려고 테스트를 한다. 
  - 테스트는 다양하지만 적어도 유닛 테스트는 필요하다. 
- 리팩토링의 목적
  - 버그를 발견하기 쉽게 만든다.
  - 기능을 추가하기 쉽게 만든다.
  - 리뷰하기 쉽게 만든다. 
- 리팩토링의 한계
  - 프로그램이 아직 동작하지 않을 때
    - 아직 동작하지 않은 프로그램은 리팩토링이 불가하다. 
    - 버그 투성이인 프로그램도 리팩토링이 불가하다.
  - 시간이 너무 촉박할 때
    - 납 품 직전 대규모 리팩토링하는 것도 하지 말아야 한다.

2. 리팩토링과 악취
- 악취란
  - 프로그램에서 리팩토링이 필요한 부분을 '악취'가 난다고 표현한다.
  - 악취란 다음 부분이다.
    - 이해하기 어려운 부분
    - 수정하기 어려운 부분
    - 확장하기 어려운 부분
    
3. 리팩토링 카탈로그
- 리팩토링 카탈로그란
  - 리팩토링 목적과 절차를 카탈로그 형식으로 정리한 것이다.
- 체계적 수정
  - 리팩토링할 때는 생각이 떠올랐다고 해서 바로 수정하지 않는다.
  - 카탈로그에 따라 체계적으로 코드를 변경해야 한다. 
  
4. 리팩토링 에센스
- 스텝 바이 스텝: 두 가지 수정을 한꺼번에 하지 않기
  - A와 B작업을 한다면 두 종류 작업을 섞어서 진행하면 안된다. 
- 스텝 바이 스텝: 되돌리기 쉽게 하기
  - 리팩토링했지만 문제가 생겨 수정을 되돌려야 할지 모른다.
  - 스텝바이스텝으로 했다면 되돌리기 쉽다. 
- 스텝 바이 스텝: 단계마다 확인
  - 컴파일 먼저 해보고 다음 테스트를 진행해 본다. 
- 스텝 바이 스텝: 오래된 걸 새로운 걸로 바꿈
  - 동작하는 상태를 유지하면서 새로운 코드를 추가해서 오래된 것이 모두 새로워지면 오래된 것을 제거하는 절차를 택한다. 
  
---
## 소스 코드에 100이라고 적힌 경우 매직 넘버를 기호 상수로 치환
1. 리팩토링
- 매직 넘버를 기호 상수로 치환
  - 소스 코드에 특정한 숫자를 직접 적는 건 좋지 않은 코딩 스타일이다.
  - 쓰면 안되는 이유1: 매직 넘버의 의미를 알기 어렵다
  - 쓰면 안되는 이유2: 매직 넘버는 수정하기 어려움
    - 100이라는 숫자가 소스 이곳 저곳에 박혀있을지 몰라 수정이 어렵다. 

2. 예제 프로그램
- 리팩토링 실행
  - 기호 상수 선언
    - public static final 클래스 필드사용 하는 방법
      - 어떤 클래스 안에서만 사용할 기호 상수인 경우 private도 가능.
    - enum 사용하는 방법
    - 매직 넘버를 가호상수로 치환
    - 기호 상수에 의존하는 다른 매직 넘버 찾아 변환
    - 컴파일
  - 테스트
    - 모든 기호 상수 치환이 끝나면 컴파일해서 테스트
    - 가능하다면 기호 상숫값을 변경한 후 컴파일해서 테스트

3. 한 걸음 더 나아가기
- 분류 코드를 클래스로 치환하기
  - 분류코드를 만들었는데 누군가 실수로 그냥 상수를 쓸 실수를 할 수 있다. 
- 기호 상수가 적합하지 않은 경우
  - for 반복에서 배열 길이를 나타내는 데 기호 상수를 쓰는 건 적절하지 않다. lengh를 쓰자.

---
## 제어 플래그 때문에 코드가 읽기 어려운 경우 제어플래그 삭제
1. 리팩토링
- 제어 플래그 삭제
  - 플래그란 프로그래밍에선 '상태를 기록하고 처리 흐름을 제어하기 위한 boolean 타입 변수'를 의미하낟. 
  - 제어플래그를 지나치게 사용하면 처리 흐름을 파악하기 어려워져 때론 프로그램 전체를 파악하는 데 어려움을 겪는다. 
  - 제어 플래그 대신 break, continue, return 등을 써 처리 흐름을 제어한다.
  
2. 예제 프로그램
- 리팩토링 전
  ```java
  public class FindInt {
      public static boolean find(int[] data, int target) {
          boolean flag = false;
  
          for(int i = 0; i < data.length && !flag; i++) {
              if(data[i] == target) {
                  flag = true;
              }
          }
          return flag;
      }
  }
  ```
- 리팩토링 실행(break 사용)
  - 위에서 flag 라는 변수명을 썻는데, 제어플래그에는 true일 때 뭘 의미하는지 나타내는 이름을 붙이는게 좋아 found라고 바꿨다.
