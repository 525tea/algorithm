# next permutation

C++ STL의 순열 생성 함수를 자바 버전으로 응용함
자바에서는 직접 구현해야 함

## 1. 개념

next_permutation은 현재 배열(순열)을 사전순으로 다음 순열로 바꿔주는 함수이다

즉,
현재 순열이 [1, 2, 3]이라면

다음 순열은 [1, 3, 2],

그다음은 [2, 1, 3], …

이렇게 쭉 오름차순 사전순 순열을 만들어준다

<br>

## 2. 작동 원리

next_permutation은 다음 순열이 존재하면 true, 없으면 false를 반환하고,

배열 자체를 다음 순열로 바꿔버린다

### 알고리즘 절차 (핵심 3단계)

1. 뒤에서부터 **감소하는 지점** 찾기
- 오른쪽 끝부터 보면서 arr[i-1] < arr[i]인 지점(i-1) 찾기
- 이 지점이 바꿔야 할 피벗(pivot)

2. 다시 뒤에서부터 피벗보다 큰 수 찾기
- arr[j] > arr[i-1] 인 지점(j) 찾기
- 이걸 바꿔치기

3. 피벗 뒤쪽을 오름차순으로 정렬(뒤집기)
- arr[i ... end] 구간을 뒤집으면 바로 다음 순열 완성


**동작 과정 예시** 

단계	현재 배열	설명
1. [1, 2, 3]	현재 순열
2. i-1 = 1 (arr[1]=2) → arr[1] < arr[2]=3	감소 지점 찾음
3. j = 2 (arr[2]=3) → arr[1]과 arr[2] swap	[1, 3, 2]
4. arr[2...] 뒤집기 (사실 하나라 그대로)	[1, 3, 2] 완성

다음 순열: [1, 3, 2]

<br>

## 3. 구현(자바)

```java
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        do {
            System.out.println(Arrays.toString(arr));
        } while (nextPermutation(arr));
    }

    static boolean nextPermutation(int[] arr) {
        int N = arr.length;

        // 1. 뒤에서부터 감소하는 지점 찾기
        int i = N - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;

        // 마지막 순열이면 false 반환
        if (i <= 0) return false;

        // 2.  뒤에서 arr[i-1]보다 큰 수 찾기
        int j = N - 1;
        while (arr[j] <= arr[i - 1]) j--;

        // swap
        swap(arr, i - 1, j);

        // 3. i부터 끝까지 뒤집기
        j = N - 1;
        while (i < j) swap(arr, i++, j--);

        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
```


**출력 결과**

    [1, 2, 3]
    [1, 3, 2]
    [2, 1, 3]
    [2, 3, 1]
    [3, 1, 2]
    [3, 2, 1]


### 시간 복잡도
- O(N) (한 번의 순열 변경에 대해)
- 모든 순열을 구하면 O(N! × N)

→ 즉, DFS 백트래킹보다 조금 더 효율적이지만
역시 순열 개수가 많으면 커짐
