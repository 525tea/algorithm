### ✏️ 정렬 이론
- [선택 정렬 Selection Sort](/topics/09_sorting/selection_sort.md)
- [버블 정렬 Bubble Sort](/topics/09_sorting/bubble_sort.md)
- [삽입 정렬 Insertion Sort](/topics/09_sorting/insertion_sort.md)
- [퀵 정렬 Quick Sort](/topics/09_sorting/quick_sort.md)
- [병합 정렬 Merge Sort](/topics/09_sorting/merge_sort.md)
- [힙 정렬 Heap Sort](/topics/09_sorting/heap_sort.md)
- [계수 정렬 Counting Sort](/topics/09_sorting/counting_sort.md)
### [📁 정렬 문제 리스트](/topics/09_sorting/09_sorting.md)

# 정렬


## 0. 정렬 알고리즘 개요

정렬은 **비교 정렬(Comparison Sort)** 과 **비비교 정렬(Non-Comparison Sort)** 로 나뉜다.

비비고 아님!!

| 분류 | 알고리즘 | 평균 복잡도 | 특징 |
|------|-----------|--------------|------|
| 비교 정렬 | 선택, 삽입, 버블, 퀵, 병합, 힙 | O(N log N) 이하 불가능 | 두 원소를 비교하며 정렬 |
| 비비교 정렬 | 계수, 기수, 버킷 | O(N+K) 가능 | 값의 ‘특성’을 이용 |


## 1. 선택 정렬 Selection Sort
[선택 정렬 Selection Sort](/topics/09_sorting/selection_sort.md)

타겟과 타겟 이후 배열의 요소들을 비교해서 최솟값을 판단 후 그 최솟값을 타겟의 자리와 swap

최솟값으로 확정된 요소는 다음 라운드에서 비교가 제외됨

### 시간 복잡도
- `평균` $(n-1) + (n-2) + (n-3) … + 1 = n(n+1)/2 = O(n^2)$

<br>

## 2. 버블 정렬 Bubble sort
[버블 정렬 Bubble Sort](/topics/09_sorting/bubble_sort.md)

라운드마다 처음부터 끝까지(전 라운드에서 결정된 값들은 제외) 순회하며 인접한 두 요소를 비교.(배열의 크기 - 라운드 회차) 큰 값을 뒤로 보냄. 이걸 (배열의 크기 - 1) 만큼 반복

### 시간 복잡도
- `평균` $(n-1) + (n-2) + (n-3) + … + 1 = n(n-1)/2 = O(n^2)$
- `최선` swap 여부를 판단할 수 있는 변수를 둔 경우 $O(n)$

<br>

## 3. 삽입 정렬 Insertion sort
[삽입 정렬 Insertion Sort](/topics/09_sorting/insertion_sort.md)

타겟 앞의 배열을 검사하며 타겟보다 큰 수가 있으면 뒤로 밀기. 큰 수가 있는 동안 뒤로 밀기를 반복. 더 이상 타겟 앞에 타겟보다 큰 수가 없으면 그 자리에 주차.

타겟 앞에 하나를 둔 상태로 시작.

### 시간 복잡도
- `평균` $1+2+3+…+n=n(n+1)/2=O(n^2)$
- `최악` 이미 역순 정렬이 되어있는 경우 → $O(n^2)$
- `최선` 이미 정렬이 되어있는 경우 → $O(n)$

<br>

## 4. 퀵 정렬 Quick sort
[퀵 정렬 Quick Sort](/topics/09_sorting/quick_sort.md)

> 코테에선 직접 구현보단 `분할 정복의 기본 원리`나 `K번째 수` 문제에 자주 등장

pivot을 기준값으로 정하고, hi(pivot보다 작은 값을 찾는 인덱스)는 오른쪽에서 왼쪽으로, lo(pivot보다 큰 값을 찾는 인덱스)는 왼쪽에서 오른쪽으로 밀며 검사.

lo < hi일 동안 hi가 pivot보다 작은 값의 인덱스가 되고, lo가 pivot보다 큰 값의 인덱스가 되면 두 값을 swap

위 과정을 반복하다가 lo와 hi가 겹치거나 크로스 되면(lo ≥ hi)

→ lo와 hi를 제자리 swap, pivot과 lo(왼쪽quick)/hi(오른쪽quick)를 swap

위 과정의 결과인 pivot의 새 인덱스를 받아 재귀를 돌림

### 시간 복잡도
- `평균` $O(n logn)$
    - 깊이  = $log_2n$
        - n개의 데이터를 **반씩 나누면  $n/2^k = 1$**
        - 양변에 log를 취하면  $log_2n=k$
- `최악` 피벗을 항상 제일 크거나 작은 값으로만 잡는 경우 → $O(n^2)$

<br>

## 5. 병합 정렬 Merge sort
[병합 정렬 Merge Sort](/topics/09_sorting/merge_sort.md)

리스트를 절반으로 분할해 분할 리스트로 나눈다 → 이걸 부분리스트의 길이가 1이 될 때까지 반복

쪼개진 부분리스트끼리 정렬하여 합친다 → 이걸 반복

### 시간 복잡도

- `평균` ⇒  $O(log_2n * n) = O(nlogn)$

        8개는 4+4, 2+2+2+2, 1+1+1+1+1+1+1+1 총 3번으로 쪼개진다 → 총 단계 수 = 깊이 =  $log_2n$
        
        단계 별 비교 작업량 : ~= 8번 → 대략 n

<br>

## 6. 힙 정렬 Heap sort
[힙 정렬 Heap Sort](/topics/09_sorting/heap_sort.md)

1. 주어진 배열을 Max Heap으로 만든다 (heapify)
2. 루트(최댓값)을 끝으로 보낸다
3. 남은 구간에 대해 다시 heapify, 반복

- `heapify(array, i, size)` : i를 꼭대기 노드로 하는 서브트리에 대해서 heapify

- `sort` - max heap 만들기 : 가장 마지막 부모 노드부터 시작해서 0에 닿을 때까지 heapify를 호출

- `sort` -  오름차순 정렬 : 최댓값을 맨 뒤로 보내고 이를 제외한 뒤 heapify하는 과정을 아무것도 안 남을 때까지 반복

<br>

## 7. 계수 정렬 Counting sort
[계수 정렬 Counting Sort](/topics/09_sorting/counting_sort.md)

> 값의 범위가 제한된 정수 데이터(예: 점수, 나이, 등수)에 자주 사용됨


- 크기를 기준으로 갯수를 배열에 담아 정렬
-  값 자체를 인덱스로 쓰는 배열을 만들어 빈도(count)를 저장해서 정렬하는 방식
- 비교 연산 없이 정렬함 → 매우 빠름 (O(n))
- 조건
  - 정수만 다룸
  - 값의 범위가 좁아야 함 (예: 1~10,000)


**예시**

[1, 3, 0, 3, 4, 3, 2, 1]

배열

| 0 | 1 | 2 | 3 | 4 |
| --- | --- | --- | --- | --- |
| 1 | 2 | 1 | 3 | 1 |

누적합 배열(counting 배열)

| 0 | 1 | 2 | 3 | 4 |
| --- | --- | --- | --- | --- |
| 1 | 3 | 4 | 7 | 8 |

<br>

## 정렬 알고리즘 비교 및 요약

| **알고리즘** | **평균 시간** | **최악 시간** | **안정성** | 제자리 정렬? | 비교 정렬 |
| --- | --- | --- | --- | --- | --- |
| **`선택 정렬`** | O(N²) | O(N²) | ❌ | ✅ | ✅ |
| **`삽입 정렬`** | O(N²) | O(N²) | ✅ | ✅ | ✅ |
| **`퀵 정렬`** | **O(N log N)** | O(N²) | ❌ | ✅ | ✅ |
| **`병합 정렬`** | **O(N log N)** | O(N log N) | ✅ | ❌ | ✅ |
| **`힙 정렬`** | **O(N log N)** | O(N log N) | ❌ | ✅ | ✅ |
| **`계수 정렬`** | O(N+K) | O(N+K) | ✅ | ❌ | ❌ |
| **`Tim sort`** | O(N) | O(NlogN) | ✅ | ✅ | ✅ |

<br>

---
# 자바의 정렬 

    직접 구현을 요하는 문제가 아니라면
    
    알고리즘의 직접 구현보다 내장 정렬 메서드를 사용하는 경우가 대부분이다
    
    핵심은 자료형(기본형 / 객체형) 에 따라 내부 알고리즘이 다르다는 것

## 1. 배열의 정렬 `Arrays.sort()`

- 기본 정렬(오름차순) : **`Arrays.sort(arr);`**
- 내림차순 정렬 : **`Arrays.sort(arr, Collections.reverseOrder());`**
    - `Collections.reverseOrder()` : 기본형은 사용 불가 ⇒ 래퍼 클래스를 사용

### 기본형 배열- int[], long[], double[], char[]

- 사용: **`Arrays.sort(arr);`**
- 내부 알고리즘: **Dual-Pivot QuickSort**
- 특징:
    - 불안정 정렬 (같은 값의 순서 유지 안 됨)
    - 평균 시간복잡도 `O(n log n)`, 최악 `O(n²)`
    - **빠르고 가벼움**, 대부분 문제에 적합

### 객체 배열 - int[][], Integer[], Long[], Double[], Character[], Class[]

- 사용: **`Arrays.sort(arr);`**
- 내부 알고리즘: **TimSort**
- 특징:
    - 안정 정렬 (같은 값의 순서 유지)
    - 병합 정렬 + 삽입 정렬 기반
- 객체 배열은 객체가 **Comparable 인터페이스를 구현한 클래스**일 때만 기본 정렬이 가능하다.
  - ex. String, Integer, Double 등은 이미 Comparable 구현 완료

<br>

**(1) `Arrays.sort(arr)` 기본 정렬**

자바에서 객체에 Comparable 인터페이스를 구현해놨을을 경우 자동으로 정렬 가능하다

```java
String[] arr = {"banana", "apple", "cherry"};
Arrays.sort(arr); // 알파벳순 정렬 (Comparable<String>에 정의된 기준)
```

<br>

**(2) 사용자 정의 정렬: `Comparator` 사용**

객체 배열이 Comparable을 구현하지 않았거나,

정렬 기준을 커스터마이징하려면 Comparator를 명시적으로 전달해야 한다


- 기본형 배열은 불가능. Collections.reverseOrder()는 객체 타입 전용 (ex. Integer[])
    ```java
    int[] arr = {3, 1, 2};
    // Arrays.sort(arr, Collections.reverseOrder()); // ❌ Error
    ```

- 객체형 배열 (ex. Integer[])
    ```java
    Integer[] arr = {3, 1, 2};
    
    // 오름차순
    Arrays.sort(arr); 
    
    // 내림차순
    Arrays.sort(arr, Collections.reverseOrder());
    
    // 사용자 정의 Comparator
    Arrays.sort(arr, (a, b) -> b - a); // 람다식으로도 가능
    ```

- 2차원 배열 (ex. int[][])
  
    int[][]은 내부적으로 int[] 객체의 배열이기 때문에
  
    Comparator<int[]> 를 명시해야 정렬 가능
  - ⚠️ int[][]은 Comparable을 구현하지 않았기 때문에 Arrays.sort(arr); 단독으로 호출 시 컴파일 에러가 발생함
    ```java
    int[][] arr = {
        {3, 2},
        {1, 4},
        {2, 1}
    };
    
    // ① 첫 번째 원소 기준 오름차순
    Arrays.sort(arr, (a, b) -> a[0] - b[0]);
    
    // ② 두 번째 원소 기준 오름차순
    Arrays.sort(arr, (a, b) -> a[1] - b[1]);
    
    // ③ 첫 번째 원소 오름차순, 같으면 두 번째 원소 오름차순
    Arrays.sort(arr, (a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });
    ```

- 사용자 정의 클래스 (ex. User[])

    ```java
    class User {
        String name;
        int age;
    
        User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        public String toString() {
            return name + "(" + age + ")";
        }
    }
    
    User[] users = {
        new User("Amy", 25),
        new User("Peter", 20),
        new User("Paul", 30)
    };
    
    // ① Comparator 사용 (나이 오름차순)
    Arrays.sort(users, (a, b) -> a.age - b.age);
    
    // ② 이름 오름차순
    Arrays.sort(users, (a, b) -> a.name.compareTo(b.name));
    
    // ③ 이름 오름차순 → 같으면 나이 내림차순
    Arrays.sort(users, (a, b) -> {
        if (a.name.equals(b.name)) return b.age - a.age;
        return a.name.compareTo(b.name);
    });
    ```

- `Comparator.comparing` 메서드 체이닝

    ```java
    Arrays.sort(users, Comparator.comparing((User u) -> u.name));
    Arrays.sort(users, Comparator.comparingInt((User u) -> u.age).reversed());
    
    // 복합 정렬
    Arrays.sort(users, Comparator
            .comparing((User u) -> u.name)
            .thenComparingInt(u -> u.age)
    );
    ```

<br>

### 정리

| 메서드 | 대상                   | 내부 알고리즘 | 평균     | 최악            | 안정성 | 특징            |
|--------|----------------------|--------------|--------|---------------|----|---------------|
| **`Arrays.sort(기본형)`** | int[], double[] 등    | Dual-Pivot QuickSort | O(NlogN) | O(N^2) | ❌  | 빠르지만 불안정      |
| **`Arrays.sort(객체형)`** | Integer[], String[] 등 | TimSort | O(NlogN) | O(N^2) | ✅  | 안정적, 병합+삽입 기반 |


### 사용 예시
```java
int[] arr = {5, 3, 2, 4, 1};
Arrays.sort(arr); // 오름차순
```
```java
Integer[] nums = {5, 3, 2, 4, 1};
Arrays.sort(nums, Collections.reverseOrder()); // 내림차순
```

<br>

## 2. 리스트의 정렬 `Collections.sort()`

- 사용: **`Collections.sort(list);`**
  - 기본 정렬(오름차순) : **`Collections.sort(list);`**
  - 역 정렬(내림차순)
    - `list.sort(Collections.reverseOrder());`
    - **`Collections.sort(list, Comparator.reverseOrder());`**
- List<T>에 사용
- 내부 알고리즘: **TimSort**
    - **Merge Sort + Insertion Sort** 혼합
- 안정 정렬이기 때문에 순서 유지됨
- 비교 기준 변경도 가능


### 요약

| 메서드 | 대상                   | 내부 알고리즘 | 평균       | 최악            | 안정성 | 특징                       |
|--------|----------------------|--------------|----------|---------------|----|--------------------------|
| **`Collections.sort(List)`** | List< T >            | TimSort | O(NlogN) | O(NlogN) | ✅  | 안정적, Comparator 오버라이딩 가능 |



### 사용 예시
```java
List<Integer> list = Arrays.asList(5, 3, 2, 4, 1);
Collections.sort(list); // 오름차순
Collections.sort(list, Comparator.reverseOrder()); // 내림차순
```

<br>

## 3. 자동 정렬되는 컬렉션

| 자료구조 | 내부 구조 | 특징 |
|---|---|---|
| PriorityQueue | Heap | 자동 오름차순 정렬, 최소/최대값 빠르게 추출 |
| TreeSet, TreeMap | Red-Black Tree | 삽입 시 자동 정렬, 중복 허용 X |

<br>

## 자바 내장 정렬 요약

| **타입** | **정렬 방법** | **내부 정렬 알고리즘** | **비고** |
| --- | --- | --- | --- |
| `int[]` 배열 | `Arrays.sort(arr)` | Dual-Pivot QuickSort | 빠르고 일반적 |
| `Integer[]` 배열 | `Arrays.sort(arr)` | TimSort | 객체 타입이라 다름 |
| `List<Integer>` | `Collections.sort(list)` | TimSort | 안정 정렬 |
| `PriorityQueue`, `TreeSet` 등 | 자동 정렬 | 힙, BST | 자동정렬 자료구조 |

<br>

## 결론 : 언제 무엇을 사용할까?
| **상황**                  | **추천 정렬 방식**                                              |
|-------------------------|-----------------------------------------------------------|
| 숫자 배열의 정렬 `int[]`       | **`Arrays.sort(arr)`**  arr = int[]                       |
| 객체 배열의 정렬 `Integer[]`   | **`Arrays.sort(arr)`**  arr = Integer[]                   |
| 리스트의 정렬 `List<Integer>` | **`Collections.sort(list)`**   list = List                |
| 커스텀된 정렬 기준이 필요          | **`Collections.sort(list, comparator)`**, `Comparator` 구현 |
| 데이터가 정수 && 범위 제한 있음     | 계수 정렬 **`Counting Sort`**, **`Radix Sort`**               |
| K번째 원소 찾기               | `QuickSelect`, `PriorityQueue`                            |
| 빈도/등수 정렬                | `Map → List → sort by value`                              |

<br>

## 💡 Comparable vs Comparator

Comparable은 객체 자신이 “기본 정렬 기준(자연 순서)”을 갖도록 하는 인터페이스이고, (정렬의 기본값)

Comparator는 외부에서 “비교 기준(임시 정렬 방식)”을 주입하는 인터페이스이다 (정렬의 옵션값)


    Comparable ⟶ compareTo(T other)
    │
    │   (내부 기준)
    │
    └── Student.compareTo(Student o) {
    return Integer.compare(this.score, o.score);
    }
    
    Comparator ⟶ compare(T a, T b)
    │
    │   (외부 기준)
    │
    └── Comparator<Student> byScore = (a,b) -> Integer.compare(a.score, b.score);


| 비교 방식                   | 인터페이스                    | 설명                                                          | 구현 위치                                                            | 사용 상황              | 메서드               | 예시                                  |
|-------------------------|--------------------------|-------------------------------------------------------------|------------------------------------------------------------------|--------------------|-------------------|-------------------------------------|
| **Comparable**          | java.lang.Comparable<T>  | 객체 자체가 정렬 기준을 가짐                                            | 클래스 내부 (`implements Comparable<T>`)                              | 기본 정렬이 필요          | `compareTo(T o)`    | `Arrays.sort(arr)`                  |
| **Comparator**          | java.util.Comparator<T>  | 외부에서 정렬 기준을 지정                                              | 외부, sort 메서드의 인자(익명 클래스 or 람다)  (`Arrays.sort(arr, comparator)`) | 상황별/복합적인 정렬 기준이 필요 | `compare(T a, T b)` |  `Arrays.sort(arr, (a,b)->a.x-b.x)` |
| `Integer.compare(a, b)` | java.lang.Integer        | 인터페이스❌❌ 정적 메서드(static)로, 두 정수값을 단순 비교하는 헬퍼 메서드(기본 비교 유틸 함수) |                                                                  | |

> 기본 정렬 기준이 클래스 내부에 이미 정의돼 있으면 `Comparable`,  
> 실행 시점마다 정렬 기준을 바꾸고 싶을 땐 `Comparator`를 사용한다.

`Integer.compare(a, b)`는 Comparable, Comparator 인터페이스와는 무관하며, 

compareTo() 내부에서 자주 쓰이는 단순히 두 숫자를 비교해주는 함수로 기본형의 비교 메서드이다 (내가 헷갈려서 넣음)


```java
// java.lang.Integer 내부
public static int compare(int x, int y) {
    return (x < y) ? -1 : ((x == y) ? 0 : 1);
}
```

<br>

### Comparable

> 클래스 내부의 “자연 순서”

**1. 특징**
- 메서드는 `int compareTo(T other)` 하나
- `compareTo(T other)`를 오버라이딩해서 Comparable을 구현(implement)한다
- 자신 < other → 음수, 자신 = other → 0, 자신 > other → 양수를 반환
- 클래스가 내부적으로 Comparable<T>를 구현하고 있다면 기본으로 구현된 기준이 내장되어 있는 것으로, 그냥 그대로 쓸 수 있다
- 다른 정렬 기준을 원하면 오버라이딩해서 사용할 수 있다
- 한 클래스에 하나의 기준(자연 순서)만 가질 수 있다
- 보통 기본 정렬(오름차순 등)을 여기에 넣는다


**2. 핵심 규약**

- 반대칭성: a.compareTo(b)의 부호는 -b.compareTo(a)와 같아야 함
- 추이성: a>b이고 b>c면 a>c
- 일관성: 비교 결과가 변하지 않는 한 같은 입력엔 같은 결과
- equals와의 일관성 권장: compareTo()==0이면 equals()도 true가 되게 만드는 것이 좋음(권장)
  - BigDecimal의 경우 compareTo() 값이 0이지만 equals()의 결과는 false

- 위 규약들을 모두 지키며 만들어야 하기 때문에 인텔리제이 단축키를 유용하게 활용하는 것이 좋다..


**3. 메서드**

`compareTo()`

- Comparable 인터페이스 소속으로, Comparable 인터페이스의 유일한 메서드이며

  원소 자신과 비교 원소를 비교하는 메서드이다

- 클래스가 “implements Comparable”로 구현하면,

  클래스 안에서 그 클래스의 기본(자연) 정렬 기준이 설정된다


```java
int compareTo(T other) // 시그니처
a.compareTo(b) // 호출 
```


사용 예시 1
```java
public class User implements Comparable<User> {
    String name;
    int age;

    @Override
    public int compareTo(User other) {
        return this.age - other.age; // 나이 오름차순
    }
}
```

```java
User[] users = { new User("A", 25), new User("B", 20) };
Arrays.sort(users); // 내부 compareTo() 기준으로 정렬됨
```

<br>

사용 예시 2
```java
public class User implements Comparable<User> {
    String name;
    int age;
    public User(String name, int age) { this.name = name; this.age = age; }

    @Override
    public int compareTo(User o) {
        // 나이 오름차순 → 같으면 이름 사전순
        int c1 = Integer.compare(this.age, o.age); // 뺄셈보다 이 방법을 권장(오버플로 방지)
        if (c1 != 0) return c1;
        return this.name.compareTo(o.name);
    }
}
```


### Comparator

상황에 따라 그때그때 기준을 정해서 정렬에 사용하기 위래 만들어 쓰는 정렬 방식의 주입용 객체의 인터페이스이다

즉, 정렬 기준을 외부에서 따로 주입하는 방식이다

Arrays.sort(arr, comparator)의 내부적인 동작은 comparator에 구현해 놓은

comparator.compare(a, b)의 반환값에 따라 정렬 순서를 결정하도록 동작한다

- 두 객체(o1, o2)를 비교하는 정렬 기준을 주는 방법
- Comparator를 사용하면 즉석에서 기준을 줄 수 있다
- 클래스 외부에서 따로 정의 가능
- 하나의 클래스에 여러 기준을 주입할 수 있다
  - 여러 개의 기준을 만들 수 있음
  - 정렬 시점마다 기준을 주입할 수 있음
- Comparator는 **람다식이나 익명 클래스**로 즉시 구현 가능하며,
  <br> 이는 compare() 메서드를 오버라이딩한 것과 동일한 효과를 가진다

**메서드**

- `int compare(T a, T b)`
- 자바 8+에서 유틸 메서드가 아주 많다
  - Comparator.comparing(...), comparingInt/Long/Double
  - thenComparing(...), reversed()
  - naturalOrder(), reverseOrder()
  - nullsFirst(...), nullsLast(...)

**메서드 체이닝** 
- Comparator.comparing()은 “객체형 기준”
- comparingInt/Long/Double()은 “기본형 기준”
- 
```java
Comparator<User> byNameThenAge =
    Comparator.comparing((User u) -> u.name)
              .thenComparingInt(u -> u.age);

// 내림차순은 reversed()
Comparator<User> byAgeDesc =
    Comparator.comparingInt((User u) -> u.age).reversed();
```

<br>

문자열/숫자/널 혼합 예시
```java
// 문자열 길이 → 같은 길이면 사전순
Comparator<String> byLenThenLex =
    Comparator.comparingInt(String::length)
              .thenComparing(Comparator.naturalOrder());

// null 안전: null 먼저
Comparator<String> nullSafe =
    Comparator.nullsFirst(Comparator.naturalOrder());
```

```java
Arrays.sort(users, (u1, u2) -> u1.name.compareTo(u2.name)); // 이름 기준
Arrays.sort(users, (u1, u2) -> u2.age - u1.age); // 나이 내림차순
```

<br>

### 정렬 시 반환값의 의미 (Comparable/Comparator 공통)

| 반환값 | 의미 | 결과 |
|---|---|---|
| 음수(< 0) | a가 b보다 작다 | a가 앞에 온다 |
| 0 | a와 b가 같다 | 순서 그대로 유지 (안정 정렬이면 순서 보존) |
| 양수(> 0)    | a가 b보다 크다   | b가 앞에 온다   |

<br>

### Arrays.sort() / Collections.sort() 에 적용 ✅

| 메서드                                          | 비교 기준 | 설명 |
|----------------------------------------------|---|---|
| Arrays.sort(기본형) int[], double[] 등 | Comparable, Comparator 적용 불가 | 그냥 오름차순(기본 정렬)만 가능 |
| Arrays.sort(객체형) arr = 객체형                   | Comparable | 배열 요소가 Comparable 구현 시 내부 compareTo() 사용 |
| Arrays.sort(객체형, comparator) arr = 객체형       | Comparator | 전달된 compare() 기준으로 정렬 |
| Collections.sort(list)                       | Comparable | List 요소가 Comparable 구현 시 사용 |
| Collections.sort(list, comparator)           | Comparator | 전달된 compare() 기준으로 정렬 |

🚨 기본형 배열(int[], double[])은 Comparator 불가, 오름차순 정렬로 정렬 기준이 고정

-> 정렬 기준을 커스터마이징하고 싶다면 래퍼 클래스를 사용 


**예시**


```java
// 1. 기본형 배열
int[] arr = {5, 2, 3};
Arrays.sort(arr); // ✅ (오름차순 고정)
Arrays.sort(arr, Collections.reverseOrder()); // ❌ 에러 — 기본형엔 Comparator 적용 불가

// 2. 객체 배열
Integer[] nums = {5, 2, 3};
Arrays.sort(nums); // ✅ Comparable<Integer>의 compareTo() 사용
Arrays.sort(nums, (a,b) -> b - a); // ✅ Comparator 사용 (람다식 compare 오버라이딩)

// 3. 사용자 정의 클래스
User[] users = {...};
Arrays.sort(users); // ✅ User가 Comparable 구현했을 때만 가능
Arrays.sort(users, (a,b)->a.name.compareTo(b.name)); // ✅ Comparator 주입 가능

// 4. 리스트
List<User> list = new ArrayList<>(List.of(users));
Collections.sort(list); // ✅ Comparable 구현 시
Collections.sort(list, Comparator.comparing(u->u.age)); // ✅ Comparator 주입 시
```

<br>
