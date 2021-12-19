## Java-study Generic
[참조1](https://st-lab.tistory.com/153)
[참조2](https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Java#generic)
다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에서 사용
### 예시코드
```java
public class ClassName <T> { ... }
public Interface InterfaceName <T> { ... }
```
```java
public class ClassName <T, K> { ... }
public Interface InterfaceName <T, K> { ... }
 
// HashMap의 경우 아래와 같이 선언되어있을 것이다.
public class HashMap <K, V> { ... }
```
```java
ArrayList<Integer> list1 = new ArrayList<Integer>();
```
### 사용하는 상황
String 타입도 지원하고싶고 Integer타입도 지원하고 싶고 많은 타입을 지원하고 싶을 때<br>
제네릭(Generic)은 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것을 의미한다. <br>
한마디로 특정(Specific) 타입을 미리 지정해주는 것이 아닌 필요에 의해 지정할 수 있도록 하는 일반(Generic) 타입

### 장점
- 제네릭은 자바의 타입 안정성을 높여 줌.
- 컴파일 과정에서 타입체크를 해주는 기능
  - 객체의 타입을 컴파일 시에 체크
    - 객체의 타입 안정성을 높임
    - 형변환의 번거로움을 줄여줌
    - collection 내부에서 들어온 값이 내가 원하는 값인지 별도의 로직처리를 구현할 필요가 없어진다
- 비슷한 기능을 지원하는 경우 코드의 재사용성이 높아진다.

### 사용 방법
보통 다음과 같이 주로 사용한다.

|타입|설명|
|------|---|
|<T |Type|
|<E |Element|
|<K |Key|
|<V |Value|
|<N |Number|
  
물론 반드시 한 글자일 필요는 없다. 또한 설명과 반드시 일치해야 할 필요도 없다. <br>
예로들어 <Ele>라고 해도 전혀 무방하다. 다만 대중적으로 통하는 통상적인 선언이 가장 편하기 때문에 위와같은 암묵적(?)인 규칙이 있을 뿐이다.

1. 클래스 및 인터페이스 선언
```java
public class ClassName <T> { ... }
public Interface InterfaceName <T> { ... }
```
  T 타입은 해당 블럭 { ... } 안에서까지 유효하다.
2. 제네릭 클래스 작성
```java
 // 제네릭 클래스
class ClassName<E> {
	
	private E element;	// 제네릭 타입 변수
	
	void set(E element) {	// 제네릭 파라미터 메소드
		this.element = element;
	}
	
	E get() {	// 제네릭 타입 반환 메소드
		return element;
	}
	
}
```
3. 사용
```java
 public class Main {
	public static void main(String[] args) {
		
		ClassName<String> a = new ClassName<String>();
  }
 }
```

