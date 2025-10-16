# 문자열


## String 

    String은 불변 객체이다
    
    따라서 변경이 필요한 경우 기존 값을 변경하지 않고, 대신에 새로운 결과를 만들어서 반환해야한다.

    이를 위해 가변 문자열 StringBuilder를 사용할 수 있다

### 주요 메서드

1. `.valueOf(num)`

String 클래스, 숫자 num(long, int double 모두 가능)을 String으로 변환

2. `.indexOf(String str)` `.indexOf(Char ch)`

처음 등장하는 위치(int) 반환

3. `.split(String regex)`

문자열 분할, String[] 반환

ex. "java".split("") → ["j", "a", "v", "a"]

4. `trim()`

앞뒤의 공백을 제거, String 반환

ex. " java ".trim() → "java"


### String 클래스의 주요 메서드

| **메서드** | **설명** | **반환값** | **예시 / 결과** |
| --- | --- | --- | --- |
| **`length()`⭐️** | 문자열의 길이 반환 | int | "java".length() → 4 |
| **`isEmpty()`⭐️** | 빈 문자열인지 확인 | boolean | "".isEmpty() → true |
| **`charAt(int index)`⭐️** | 해당 인덱스의 문자 반환 | char | "java".charAt(0) → 'j' |
| **`indexOf(String str)`⭐️
`indexOf(Char ch)`** | 처음 등장하는 위치 반환 | int | "java".indexOf("a") → 1
없으면 `-1` 반환 (ㅆㅂ ㅋㅋㅋ) |
| **`indexOf(String str,int fromIndex)
indexOf(Char ch,int fromIndex)`** | fromIndex부터 시작해서 처음 나오는 위치 | int |  |
| **`lastIndexOf(String str)`** | 마지막 위치 반환 | int | "java".lastIndexOf("a") → 3 |
| **`substring(int beginIndex)`** | 인덱스부터 끝까지 자름 | String | "java".substring(2) → "va" |
| **`substring(int begin, int end)`⭐️** | begin 이상 end 미만 자름 | String | "java".substring(0, 2) → "ja" |
| **`replace(char old, char new)`
`replace(CharSequence target, CharSequence replacement)`** | 모든 문자를 치환 | String | "java".replace('a', 'i') → "jivi" |
| **`replaceAll(String regex, String replacement)`** | 정규표현식 기반 치환 | String | "java".replaceAll(".", "/") → "////" |
| **`replaceFirst(String regex, String replacement)`** | 첫 등장만 치환 | String | "java".replaceFirst("j", "a") → "aava" |
| **`equals(Object obj)`⭐️** | 문자열 비교 (값) | boolean | "java".equals("java") → true |
| **`compareTo(String anotherString)`⭐️** | 사전순 비교 | int | "java".compareTo("javc") → -2 |
| **`contains(CharSequence s)`⭐️** | 포함 여부 확인 | boolean | "java".contains("ja") → true |
| **`split(String regex)`⭐️** | 문자열 분할 | String[] | "java".split("") → ["j", "a", "v", "a"] |
| **`trim()`⭐️** | 앞뒤 공백 제거 | String | " java ".trim() → "java" |
| **`startsWith(String prefix)`** | 접두사 여부 | boolean | "java".startsWith("ja") → true |
| **`endsWith(String suffix)`** | 접미사 여부 | boolean | "java".endsWith("va") → true |
| **`.toUpperCase()`⭐️** | 대문자로 변환 | String |  |
| **`.toLowerCase()`⭐️** | 소문자로 변환 | String |  |

💡`CharSequence` ←  String, StringBuilder, StringBuffer 등이 모두 들어갈 수 있음!

- String, StringBuilder, StringBuffer는 `CharSequence`를 구현한 클래스.


## 자료형 간의 변환

### 문자를 문자열로 바꾸기 `+ ”“`

- **문자 + 문자**는 유니코드 정수로 처리 ⇒ sout 호출시 toString에서 유니코드(숫자)로 출력됨
- 문자를 문자로 출력하고 싶으면 +”” 해서 문자열로 바꿔줘야 함

그외 방법

- `Character.toString()`
- `String.valueOf()`


### `charAt()`

문자열(String)에서 특정 인덱스(0~n)의 문자 하나(char)를 꺼내는 메서드

```java
String s = "abcde";
for (int i = 0; i < s.length(); i++) {
    System.out.println(s.charAt(i));
}
```

`charAt()` 활용 - 문자열에서(365) 숫자를 자리수별로 하나씩 꺼내기 #2588

```java
String s = "365";
int digit = s.charAt(0) - '0'; // '3' → 3
```

ASCII 값의 차이를 이용

int → char로 만들기

```java
int n = 7;
char ch = (char)(n+'0'); // '7'
```

### String[] 문자열 배열

|  | 메서드 |  |
| --- | --- | --- |
| 문자열 | **`str.length()`** | 글자 수 (문자 수) |
| 문자열 배열 | **`arr.length`** | 문자열 개수 |

<br>

---

## StringBuilder

- 수정 가능한 가변 문자열을 다루는 문자열 버퍼 클래스
- 문자열 조작에 사용


### 핵심 메서드

1. `new StringBuilder(str)`

String str을 가변 버퍼로 감쌈.


2. `.reverse()`

StringBuilder 클래스의 내장 메서드, 문자열을 뒤집고 반환


3. `.toString()`

가변 문자열 StringBuilder sb를 불변 문자열 String으로 변환


### StringBuilder의 주요 메서드

| **메서드** | **설명**                                                                        |
| --- |-------------------------------------------------------------------------------|
| **`append(Object o)`** | 문자열 뒤에 `toString()`의 결과를 추가. 오버로딩✅ <br>문자, 문자열, int, double, boolean, 객체 모두 가능 |
| **`insert(int offset, s)`** | 특정 위치에 삽입                                                                     |
| **`delete(int start, end)`** | 지정한 범위 삭제                                                                     |
| **`reverse()`** | 문자열 뒤집기                                                                       |
| **`toString()`** | 최종 문자열을 String으로 반환                                                           |
| **`setCharAt(index, c)`** | 특정 위치의 문자 변경                                                                  |
| **`length()`** | 현재 문자열 길이 반환                                                                  |
| **`setLength(int newLength)`** | StringBuilder의 길이를 newLength로 강제로 자름 <br> 앞에서부터의 길이                           |

```java
sb.append(n).append("abc").append('A').append(true).append(123).append(3.14);
```

```java
String str = "hello";
String reversed = new StringBuilder(str).reverse().toString();
```

```java
StringBuilder sb = new StringBuilder();
sb.append("1 + 2 + 3 + ");  // 길이 = 10

sb.setLength(sb.length() - 3); // 마지막 " + " 제거
System.out.println(sb);  // 출력: 1 + 2 + 3
```
