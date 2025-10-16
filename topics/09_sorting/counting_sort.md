### [✏️ 정렬 이론](/topics/09_sorting/sorting.md)
- [선택 정렬 Selection Sort](/topics/09_sorting/selection_sort.md)
- [버블 정렬 Bubble Sort](/topics/09_sorting/bubble_sort.md)
- [삽입 정렬 Insertion Sort](/topics/09_sorting/insertion_sort.md)
- [퀵 정렬 Quick Sort](/topics/09_sorting/quick_sort.md)
- [병합 정렬 Merge Sort](/topics/09_sorting/merge_sort.md)
- [힙 정렬 Heap Sort](/topics/09_sorting/heap_sort.md)
- [계수 정렬 Counting Sort](/topics/09_sorting/counting_sort.md)
### [📁 정렬 문제 리스트](/topics/09_sorting/09_sorting.md)


# 계수 정렬 Counting Sort

[참고 블로그](https://st-lab.tistory.com/104)

> 요소 간의 비교 없이, 각 원소의 빈도 수(개수)를 세어 정렬하는 알고리즘

## 개념

- 일반적인 비교 기반 정렬(퀵, 병합, 힙)은 모두 평균 O(N log N) 복잡도를 가진다
- 그런데 값의 범위(K) 가 제한되어 있다면, 비교 대신 카운트 배열을 써서 O(N + K) 로 더 빠르게 정렬 가능

즉,

값의 크기 관계를 비교하지 않고, 각 값이 몇 번 나왔는지만 세어서 순서대로 나열한다


### 동작 과정

1. 배열의 최댓값 max 찾기
2. count[max+1] 생성, 0으로 초기화
3. 각 값 등장 횟수 카운트
4. count[i]를 누적합 형태로 변환
5. 원본 배열을 뒤에서부터 순회하며 result[count[arr[i]]-1] 위치에 삽입
6. count[arr[i]] 감소


### 정렬 과정 예시

정렬할 배열:

[7, 4, 3, 7, 1, 3, 1, 1, 4]

1. 최댓값 찾기
- max = 7
- 카운트 배열 크기 = 8 (0~7)


2. 각 값의 등장 횟수 세기 (count 배열)

| 인덱스 | 0	 | 1	| 2	| 3	| 4	| 5 | 6 |	7 |
|--|----|--|--|--|--|--|--|--|
| 값	| 0	 | 3	| 0	| 2	| 2	| 0	| 0	| 2 |


3. 누적합 배열(prefix sum)

| 인덱스 | 0	 | 1	| 2	 | 3	 | 4	 | 5  | 6  | 	7 |
|--|----|--|----|----|----|----|----|----|
| 값	| 0	 | 3	| 3	 | 5	 | 7	 | 7	 | 7	 | 9  |

→ “값 ≤ i” 인 원소가 몇 개인지를 의미


4. 뒤에서부터 순회하며 count 기준으로 결과에 배치
- count[arr[i]]를 1 줄이고, 그 위치에 arr[i] 저장

결과

    [1, 1, 1, 3, 3, 4, 4, 7, 7]


### 시간 & 공간 복잡도

| 항목 | 복잡도     | 설명                      |
|--|---------|-------------------------|
| 시간 복잡도 | O(N + K) | N: 원소 개수, K: 값의 범위(최댓값) |
| 공간 복잡도 | O(N + K) | count 배열과 result 배열 필요 |
| 안정 정렬 | ✅       | 뒤에서부터 채워 넣기 때문에 동일값 순서 유지 |
| 제자리 정렬 | ❌       | 추가 배열 필요 |

**단점**
- 값의 범위(K) 가 너무 크면 비효율적
<br> 예: 0~1억 범위 정렬에 1억 크기 배열은 메모리 낭비
- 정수형에만 사용 가능 (정확히는 “범위가 작은 정수”에 적합)

<br>

## 구현 

```java
public class CountingSort {
public static void sort(int[] arr) {
int max = findMax(arr);
int[] count = new int[max + 1];
int[] result = new int[arr.length];

        // 1️⃣ 값 등장 횟수 세기
        for (int num : arr) count[num]++;

        // 2️⃣ 누적합 (prefix sum)
        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        // 3️⃣ 뒤에서부터 원소 채우기 (안정 정렬)
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            result[count[num] - 1] = num;
            count[num]--;
        }

        // 4️⃣ 결과 복사
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }
}
```


<br>

## 요약
| 항목     | 설명                 |
|--------|--------------------|
| 정렬 방식  | 비비교 정렬. 비교 ❌       |
| 안정성    | ✅ |
| 제자리 정렬 | ❌       |
| 시간 복잡도 | O(N + K) |
| 공간 복잡도 | O(N + K) |


### 적합한 상황

값의 범위가 좁고 정수로 표현 가능한 경우
