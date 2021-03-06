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
  
---
## 분류 코드마다 동작이 다른경우 분류 코드를 하위 클래스로 치환
1. 리팩토링
- 분류 코드를 하위 클래스로 치환
  - 단순히 객체를 식별하는 것뿐만 아니라 분류 코드 종류에 따라 객체가 다른 동작을 한다면 분퓨 코드를 클래스로 치환만으로 쉽게 해결할 수 없다.
  - 분류 코드마다 하위 클래스를 준비해서 하위 클래스 내부에 동작을 서술하면 코드를 깔끔하게 정리할 수 있다. 
  - 상위 클래스에 선언한 메서드를 오버라이드해서 다혀적으로 메서드로 만드는게 핵심이다. 
  - 분류코드마다 switch 문을 쓰는건 악취가 난다. 
- 구조와 동작
  - 구조는 프로그램의 정적인 성질이다. 
    - 예를 들어 상위 클래스와 하위 클래스 관계는 클래스 사이의 구조를 나타낸다. 
  - 동작은 프로그램의 동적인 설질이다.
    - 예를 들어 메서드가 어떤 계산을 하는지, 어떤 갓을 넘길때 반환값은 무엇인가라는 건 메서드 동작이된다. 
    
2. 예제
- 리팩토링 실행
  - 분류코드를 바탕으로 인스턴스를 작성하고 있다면 팩토리 메서드 작성
    - 팩토리 메서드는 만들 인스턴스 클래스명을 은폐하려고 사용한다. 
    
3. 한 걸음 더 나아가기
- switch 문과 instanceof 연산자가 풍기는 악취
  - 객체 종류에 따라 동작이 분기하는 switch 문을 발견하면 이를 다형적 메서드로 해결할 수 있을지 검토해 보자. 
- 객체 생성 switch 문 삭제
  - 예제에서 swtich문이 하나뿐이고 객체 생성에서만 사용하므로 허용하고자 한다고 한다. 
  - 지나친 리팩토링은 필요 이상으로 코드가 복잡해진다. 

---
## 분류 코드마다 동작이 다른 경우 분류 코드를 상태/전략 패턴으로 치환
1. 래팩토링
- 분퓨 코드를 상태/전략 패턴으로 치환
  - 분퓨 코드는 객체 종류를 나타내는 값이다. 
  - 분류 코드를 상태 객체라고 부르는 객체를 사용해 치환한다. 
  - 분류 코드가 동적으로 변환하는 상황에서 쓸 수 있다. 
  
3. 한 걸음 더 나아가기
- 분류 코드를 치환하는 세가지 방법 비교
  - 분류 코드를 클래스로 치환은 가장 간단한 리팩토링이다. 
  - 분류 코드를 하위 클래스로 치환은 분류 코드에 따라 클래스 동작이 다를 때 사용하는 리팩토링이다. 
  - 분류 코드를 상태/전략 패턴이르 치환은 분류 코드에 따라 클래스 동작도 다르고 분류 코드를 하위 클래스로 표현할 수 없을 때 사용한다. 
    - 분큐 코드를 하위 클래스로 치환하는 방법과 같지만, 이용하는 클래스 외부에 상태 객체를 두는 점이 다르다. 
- 상태 패턴과 전략 패턴의 차이
  - 상태 패턴은 프로그램 상태를 객체로 표현하고 상태에 의존하는 코드를 하위 클래스 메서드에 작성하는 것이다. 
    - 상태에 따른 switch 문이 없어져 상태 전이도 깔끔하게 작성할 수 있다. 
  - 전략 패턴은 하나로 정리된 처리를 하는 알고리즘을 조용히 전환할 때 사용하는 패턴이다. 
    - 알고리즘 입출력을 인터페이스로 규정해 두고 그 인터페이스를 만족하는 구체적인 클래스를 선언한다. 
    - 알고리즘을 바꿔 재계산하는 일이 편해진다. 
- 다형적 해결로 default 제거
  - 분류 코드를 사용할 때 프로그램 실수로 받는 값 이외의 값을 전달받을 때를 대비해 switch 문에 defalut를 준비해야 한다. 
  - 하지만 상태 패턴을 사용해 다형적 해결을 적용한 후 이상한 값이 전달 될 수 없다. 그래서 default가 제거 된다. 
  
---
## 에러 처리가 흩어져 있는 경우 에러 코드를 예외로 치환
1. 리팩토링
- 에러 코드를 예외로 치환
  - 한 메서드 안에 정상 처리와 에러 처리가 혼재하면 프로그램의 흐름을 파악하기 어렵다. 
  - 에러 코드 대신 예외라는 도구를 사용해 에러 처리를 정리한다. 
- 리팩터링 실행
  - 복구 가능한 에러라면 검사 예외 선택 
    - 검사 예외는 보통 Exception의 하위 클래스로 만든다. 
    - 자바에서 예외를 나타내는 클래스의 생성자는 일반적으로 예외가 일어났을 때 표시할 부가 정보 문자열을 매개변수로 받는다. 
  - 복구 불가능한 에러 또는 프로그래머 실수로 인한 에러라면 비검사 예외 선택
    - 비검사 예외를 만든다면 RuntimeException 하위 클래스로 만든다. 
    - Error의 하위 클래스로도 가능하지만, Error는 가상 머신 내부 에러라는 치명적인 에러용으로 준비된 것으로 하지 않는게 좋다. 
- 메서드 호출하는 쪽 변경
  - 호출하는 쪽에서 에러를 처리한다면 try~catch 추가
  - 호출하는 쪽에서 에러를 처리하지 않는다면 throws 절 추가
  
4. 한 걸음 더 나아가기
- 검사 예외와 비검사 예외
  - 자바에는 다음과 같은 두 가지 종류의 예외가 있다
    - 검사 예외
    - 비검사 예외
  - 검사예외는 보통 Exception의 하위 클래스로 선언한다. 
  - 비검사 예외는 보통 RuntimeException의 하위 클래스로 선언한다. 
- EOFException에 대해
  - 데이터를 읽어려고 했지만 더는 데이터가 없을 때 발생하는 예외이다. 
  
---
## 클래스 이름이 new로 하드 코딩된 경우 생성자 팩토리 메서드로 치환
1. 리팩토링
- 생성자를 팩토리 메서드로 치환
  - new 연산자를 사용해 인스턴스를 적으면 생성되는 건 반드시 특별한 클래스의 인스턴스로 고정된다. 
  - 일반적으로 생성할 인스턴스의 클래스를 실행 중에 결정하려고 할 때는 new 연산자를 직접 사용하는 건 적절하지 않다. 
  - 인스턴스를 생성하는 팩토리 메서드를 사용하면 생성되는 인스턴스의 클래스를 팩토리 메서드 내부에서 실행 시에 결정할 수 있다. 
  
---
## 모델과 뷰가 뒤섞여 있는 경우 관측 데이터 복제
1. 리팩토링
- 관측 데이터 복제
  - GUI와 관련 부분은 사용자가 보는 부분으로, 프리젠테이션 또는 뷰라고 부른다. 
  - GUI와 관련 없는 부분은 사용자가 보지 못하는 부분으로, 도메인이나 비즈니스 로직 또는 모델 등이 있다. 
  - GUI와 관련 있는 부분과 그렇지 않은 부분이 모두 한 클래스에 섞여 있으면 수정이 어려워진다. 
  - 이 리팩토링은 혼재하는 모델과 뷰를 분리한다. 
  - 관찰자 패턴이나 이벤트 리스너를 사용해 모델 내용이 변하면 그 사실을 뷰에 알리고 모델과 뷰를 동기화 하는게 관측 데이터 복제이다. 
  
---
## IS-A 관계가 아닌데 상속하고 있는 경우 상속을 위임으로 치환
1. 상속과 위임
- 상속과 위임 비교
  - 상속은 클래스 사이의 관계고, 위임은 인스턴스 사이의 관계다. 
  - 상속은 정적인 관계고, 위임은 동적인 관계다. 
  
2. 리팩토링
- 상속을 사용해야 할 곳이 아닌 곳까지 상속을 사용하면 프로그램이 더러워지고 재사용하기 어려워진다. 
- 부적절한 상속을 위임으로 치환하면 클래스의 역할이 명확해지고 재사용도 쉬워진다. 

3. 한 걸음 더 나아가기
- 상속은 최수의 무기
  - 상속을 사용하면 클래스와 클래스가 정적으로 결합한다. 그러므로 잘 생각해서 쓰자.
- 리스코프 치환 원칙
  - 상속을 사용하는 게 좋을지 안 좋을지를 판단하는 데 리스코프 치환 원칙이 편리하다. 
  - Parent 타입의 변수에 Child 클래스의 인스턴스를 할당해도 문제없이 사용가능 하게 만드는 원칙이다. 
  - 예제의 Dice 인스턴스가 Random 클래스의 하위 클래스로 사용한다면 리스코프 치환 원칙을 위반하게 된다. 

---
## 위임 대상까지 노출되어 있는 경우 대리자 은폐
1. 리팩토링
- 대리자 은폐
  - 관계가 복잡해지는 원인 중 하나는, 각 클래스가 상세 구현을 다른 클래스에 지나치게 공개하기 때문이다. 
  - 클래스 사이의 관계를 단순화하려면 정보 은폐가 필요하다. 
  
2. 한 걸음 더 나아가기
- 숨기기의 중요성
  - 상세 구현을 숨기지 않으면 클래스끼리 의존 관계가 너무 깊어질 위험이 있다. 
- 다양한 은폐
  - 접근 제어를 사용한 은폐
  - 패키지를 사용한 은폐
  - 중첩 클래스를 사용한 은폐
    - 중첩 클래스는 클래스 내부에 선언한 클래스를 의미하고, 클래스끼리 관계가 있다는 걸 코드로 명시하는 효과가 있다. 
- 중계자 제거
  - 대리자 은폐와 반대되는 성질이다. 
  
