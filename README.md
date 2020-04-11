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

4. 한 걸음 더 나아가기
- break나 return을 쓰면 가독성이 좋아지는 이유
  - break나 return을 본 순간 이후에 오는 코드를 읽지 않아도 되는 경우가 많기 때문이다. 
- 인스턴스 필드로 만든 제어 플래그의 위험성
  - 지역 변수가 아닌 인스턴스 필드를 제어 플래그로 사용하는 경우 어떤 메서드가 종료한 다음에도 제어 플래그는 인스턴스 상태를 계속 유지한다. 
  - 전체 코드를 읽기 어려워진다. 
- 플래그명
  - 변수 이름을 flag라 지정하는건 좋지 않다. 

---
## '이렇게 될 것이다'라는 주석이 있는 경우 어서션 도입
1. 리팩토링
- 어서션 도입
  - 어서션이라는 기법으로 프로그래머의 의도를 확실히 밝히면서도 실행 시 조건이 반드시 성립함을 보장한다. 
  - assert value > 0;는 value > 0 임을 표명한다란 의도다.
  - value > 0이 아니라면 AssertionError 예외를 던진다. 
- 리팩토링 실행
  - 어서션 도입
    - 소스 코드에서 성립해야 할 조건 찾기
    - 조건을 포함한 어서션 작성
      - 어서션 조건 때문에 프로그램에 부수 효과가 생기면 안된다. 즉 개체 내부 상태가 변하면 안된다. 
    - 적혀있던 주석은 무의미하므로 주석 삭제
    - 컴파일 해서 테스트
  
---
## null 확인이 너무 많은 경우 널 객체 도입
1. 리팩토링
- 널 객체 도입
  - 널 객체는 아무것도 처리하지 않고, 이걸 사용하면 '이 변수는 현재 null인가' 라는 확인을 생학할 수 있다. 
  - 기존 클래스와 같은 인터페이스를 가지지만 '아무것도 안하는' 구현이다. 
  
3. 한 걸음 더 나아가기
- null 확인은 나쁜가?
  - null 확인이 너무 많아서 빠트리거나 실수할 것 같을 때 쓰인다. 

---
## 코드가 너무 길어서 읽기 어려운 경우 메서드 추출
1. 리팩토링
- 메서드 추출
  - 한 메서드 안에 이런저런 세세한 처리가 많ㄷ면 그런 처리를 묶어 나누고 독립된 메서드로 추출한다. 
- 리팩토링 실행
  - 새로운 메서드 작성
    - 메서드 이름은 '동사 + 명사' 순으로 짓는게 보통이다. 
    - 어떻게 하는가가 아닌 무엇을 하는가를 알 수 있게 짓는게 좋다. 
    - 이름이 떠오르지 않는 다는건 코드가 무엇을 하는지 파악하지 못했다는 증거다. 
  - 기존 메서드에서 새로운 메서드로 코드 복사
    - 새로운 메서드를 private로 지정하면 메서드가 다른 클래스에서 호출될 수 없으므로 나중에 수정하기 편하다. 
    
3. 한 걸음 더 나아가기
- 역 리팩토링
  - 메서드 추출은 메서드 인라인화라는 역 리팩토링이 있다. 
  - 메서드 인라인화는 너무 짧은 메서드가 리팩토링 대상이다. 
  - 메서드 갯수가 줄어든다. 
  - 단 오버라이드된 메서드는 인라인화하면 안된다. 
  
---
## 클래스의 책임이 너무 많은 경우 클래스 추출
1. 리팩토링
- 클래스 추출
  - 클래스 하나에 책임 하나가 이상적이지만 클래스 몸집이 늘어 한 클래스에 여러 책임을 지는 경우도 있다. 
  - 이럴 때 기본 클래스가 지는 책임 중 누군가에게 넘길 수 있는 것이 있는지 찾아본다. 
  - 기존 클래스에서 필드와 메서드를 추출해 새로운 클래스로 옮기는 것이 클래스 추출이다. 
  
3. 한 걸음 더 나아가기
- 양방향 링크는 피한다.
  - 예제에서 Book 클래스에서 Author 클래스를 추출한 다음 Book 클래스에서 Author 클래스를 링크로 걸었다.
  - 이는 메서드 위임하는데 필요한 링크다. 
  - 양방향 링크가 진짜 필요한지 잘 생각해봐야 한다. 
  - 양방향 링크는 초기화나 관리가 복잡하고 필드나 메서드를 정리하기 어렵기 때문이다. 
- 불변 인터페이스
  - 이를 사용하면 일반 인스턴스 내용을 읽기 전용으로 만들 수 있다. 
- 역 리팩토링: 클래스 인라인화
  - 지나치게 클래스 추출을 하는 것도 문제다. 
  - 클래스 인라인화는 작은 클래스 내부를 해당 클래스를 실제로 사용하는 클래스로 모두 옮기고 작은 클래스는 삭제한다. 
  
-- 
## int로 객체를 구분하는 경우 분류 코드를 클래스로 치환
1. 리팩토링
- 분류 코드를 클래스로 치환
  - 분류 코드가 int 같은 기본 타입으로 구현되어 있다면 분류 코드를 나타내는 새로운 클래스를 만들고 그 클래스를 사용하도록 한다. 
- 기본 타입을 사용한 분류 코드의 문제점
  - 이상한 값이 될 수도 있다. 
  - 다른 분류 코드와 혼동할 수도 있다. 

3. 한 걸음 더 나아가기
- 기본 타입을 사용한 분류 코드의 문제점
  - 이상한 값이 될 수 있음
  - 다른 분류 코드와 혼동할 수 있음
- enum
  - enum을 사용해 간단히 타입 세이프 상수를 작성할 수 있다. 