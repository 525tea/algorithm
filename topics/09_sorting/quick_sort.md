### [✏️ 정렬 이론](/topics/09_sorting/sorting.md)
- [선택 정렬 Selection Sort](/topics/09_sorting/selection_sort.md)
- [버블 정렬 Bubble Sort](/topics/09_sorting/bubble_sort.md)
- [삽입 정렬 Insertion Sort](/topics/09_sorting/insertion_sort.md)
- [퀵 정렬 Quick Sort](/topics/09_sorting/quick_sort.md)
- [병합 정렬 Merge Sort](/topics/09_sorting/merge_sort.md)
- [힙 정렬 Heap Sort](/topics/09_sorting/heap_sort.md)
- [계수 정렬 Counting Sort](/topics/09_sorting/counting_sort.md)
### [📁 정렬 문제 리스트](/topics/09_sorting/09_sorting.md)


# 퀵 정렬 Quick Sort

[참고 블로그](https://st-lab.tistory.com/250)

> “분할 정복(Divide & Conquer)” 알고리즘의 대표 예  
> 하나의 **피벗(pivot)** 을 기준으로 작은 값과 큰 값을 양쪽으로 분할하고,  
> 각 구간을 재귀적으로 정렬한다


## 개념

- 임의의 **기준값(pivot)** 을 선택한다.
- pivot보다 **작은 값은 왼쪽**, **큰 값은 오른쪽**으로 분할한다
- 이 과정을 **분할 → 정복 → 합병 없이 완성** 구조로 재귀 반복한다
- 시간 복잡도는 평균적으로 **O(N log N)**, 최악의 경우(피벗이 한쪽으로 쏠릴 때) **O(N²)**


### 동작 과정
| 단계 | 설명 |
|------|------|
| ① | 피벗(pivot)을 선택 (왼쪽 / 오른쪽 / 중간 등) |
| ② | lo, hi 포인터로 왼→오·오→왼 탐색 |
| ③ | 잘못된 위치의 두 값을 swap |
| ④ | 포인터가 교차되면 피벗과 교환 |
| ⑤ | 피벗 기준 왼쪽·오른쪽 부분배열을 재귀 정렬 |


### 시간 복잡도
| 케이스 | 복잡도 | 설명 |
|---------|---------|------|
| 평균 | O(N log N) | 피벗이 중간쯤일 경우 |
| 최악 | O(N²) | 피벗이 항상 한쪽 끝일 때 (정렬된 데이터) |
| 최선 | O(N log N) | 균등 분할 |
| 공간복잡도 | O(log N) | 재귀 깊이 |

<br>

## 1. 왼쪽 피벗 버전 

    맨 왼쪽 원소를 pivot으로 잡음 pivot = 기준값, lo = 왼→오 포인터, hi = 오→왼 포인터
    
    왼 ← 오 : `hi` 포인터를 `lo`와 겹치기 전까지 감소시키며 `pivot`보다 작은 값이 처음 나오면 break
    
    - `while (a[hi] > pivot && lo < hi) hi--;`
        - a[hi]가 pivot보다 클 동안은 계속 hi를 감소시킴
        - a[hi]가 pivot보다 작은 값이 나오면, 그때 stop하고 hi의 인덱스 고정
    
    왼 → 오 : `lo` 포인터를 `hi`와 겹치기 전까지 증가시키며 `pivot`보다 작거나 같은 값이 나오면 break
    
    - `while (a[lo] <= pivot && lo < hi) lo++;`
        - a[lo]가 pivot보다 작거나 같을 동안은 계속 lo를 증가시킴
        - a[lo]가 pivot보다 큰 값이 나오면, 그때 stop하고 lo의 인덱스 고정
    
    `hi`, `lo`를 교환(swap)
    
    위 과정을 반복하다가 `lo`와 `hi`가 겹치면(`lo`<`hi`를 더 이상 만족x)
    
    → `lo`와 `hi` 제자리 swap, `pivot`과 `lo`를 swap
    
    pivot을 기준으로 부분리스트로 분할, 각 부분에 대해 위 과정을 반복

- 시간 복잡도 : O($Nlog_2N$)

### 구현

```java
public class QuickSort {
	
	public static void sort(int[] a) {
		l_pivot_sort(a, 0, a.length - 1);
	}
	
	/**
	 *  왼쪽 피벗 선택 방식
	 *  a	:	정렬할 배열, 
	 *  lo :	현재 부분리스트의 가장 왼쪽 인덱스, 
	 *  hi	: 현재 부분리스트의 가장 오른쪽 인덱스
	 */
	private static void l_pivot_sort(int[] a, int lo, int hi) {
		
		/*
		 *  lo가 hi보다 크거나 같다면 정렬 할 원소가 1개 이하이므로 정렬하지 않고 return한다.
		 *  lo와 hi가 크로스됨 = 큰 값이 오른쪽, 작은 값이 왼쪽에 있다는거니까
		 */
		if(lo >= hi) {
			return;
		}
		
		/*
		 * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로
		 * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
		 * 
		 * 그리고나서 해당 피벗을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어
		 * 분할 정복을 해준다.
		 * 
		 * [과정]
		 * 
		 * Partitioning:
		 *
		 *   a[left]          left part              right part
		 * +---------------------------------------------------------+
		 * |  pivot  |    element <= pivot    |    element > pivot   |
		 * +---------------------------------------------------------+
		 *    
		 *    
		 *  result After Partitioning:
		 *  
		 *         left part          a[lo]          right part
		 * +---------------------------------------------------------+
		 * |   element <= pivot    |  pivot  |    element > pivot    |
		 * +---------------------------------------------------------+
		 *       
		 *       
		 *  result : pivot = lo     
		 *       
		 *
		 *  Recursion:
		 *  
		 * l_pivot_sort(a, lo, pivot - 1)     l_pivot_sort(a, pivot + 1, hi)
		 *  
		 *         left part                           right part
		 * +-----------------------+             +-----------------------+
		 * |   element <= pivot    |    pivot    |    element > pivot    |
		 * +-----------------------+             +-----------------------+
		 * lo                pivot - 1        pivot + 1                 hi
		 * 
		 */
		int pivot = partition(a, lo, hi);	// partition 수행 후 결정된 pivot의 최종 인덱스
		// partition으로 받은 lo의 참조값(중간을 자르는 기준점)을
		// pivot에 대입. 이게 pivot의 새 참조값이 됨
		
		l_pivot_sort(a, lo, pivot - 1); // 
		l_pivot_sort(a, pivot + 1, hi);
	}
	
	
	
	/**
	 * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
	 * 
	 * @param a		정렬 할 배열 
	 * @param left	현재 배열의 가장 왼쪽 부분
	 * @param right	현재 배열의 가장 오른쪽 부분
	 * @return		최종적으로 위치한 피벗의 위치(lo)를 반환
	 */
	private static int partition(int[] a, int left, int right) {
		
		int lo = left; // 부분리스트(정렬할 구간)의 가장 왼쪽 인덱스
		int hi = right; // 부분리스트의 가장 오른쪽 인덱스
		int pivot = a[left];		// 부분리스트의 왼쪽 요소를 피벗으로 설정
		
		// lo가 hi보다 작을 때 까지만 반복한다.
		while(lo < hi) {
			
			/*
			 * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를
			 * 찾을 떄 까지 hi를 감소시킨다.
			 */
			while(a[hi] > pivot && lo < hi) {
				hi--;
			}
			
			/*
			 * hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를
			 * 찾을 떄 까지 lo를 증가시킨다.
			 */
			while(a[lo] <= pivot && lo < hi) {
				lo++;
			}
			
			// 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
			swap(a, lo, hi);
		}
		
		
		/*
		 * lo >= hi. lo와 hi가 겹치거나 크로스 되면
		 * 마지막으로 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와 
		 *  lo가 가리키는 원소를 바꾼다.
		 * => lo(인덱스)에는 pivot이, pivot의 인덱스([left])에는 lo에 있던 값이 저장됨
		 */
		swap(a, left, lo);
		
		// 두 요소가 교환되었다면 피벗이었던 요소는 lo에 위치하므로 pivot의 새 인덱스인 lo를 반환한다.
		return lo; // 즉, lo의 참조값이 파티션의 기준이 됨 
	}
 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
```

설명
- lo :	현재 부분리스트의 가장 왼쪽 인덱스,
- hi	: 현재 부분리스트의 가장 오른쪽 인덱스


- `int pivot = partition(a, lo, hi);`	: partition 수행 후 결정된 pivot의 최종 인덱스

partition에서는 마지막에 pivot이 위치하게 되는 인덱스인 lo(중간을 자르는 기준점)를 반환함. 이걸 받아서 int pivot에 대입. 이게 pivot의 새 참조값이 됨


- `l_pivot_sort(a, lo, pivot - 1);`
- `l_pivot_sort(a, pivot + 1, hi);`

이제 여기서 pivot 의 새 인덱스를 가지고 왼쪽 부분리스트와 오른쪽 부분리스트에 대해 다시 lo, hi를 지정하고 재귀를 돌린다


### 무주석 버전

```java
public class QuickSort {
	
	public static void sort(int[] a) {
		l_pivot_sort(a, 0, a.length - 1);
	}

	private static void l_pivot_sort(int[] a, int lo, int hi) {
		
		// lo가 hi보다 크거나 같다면 정렬 할 원소가 1개 이하이므로 정렬하지 않고 return
		if(lo >= hi) {
			return;
		}
		
		int pivot = partition(a, lo, hi);	// partition 수행 후 결정된 pivot의 최종 인덱스
		
		l_pivot_sort(a, lo, pivot - 1);
		l_pivot_sort(a, pivot + 1, hi);
	}
	
	
	
	// pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
	private static int partition(int[] a, int left, int right) {
		
		int lo = left; // 부분리스트(정렬할 구간)의 가장 왼쪽 인덱스
		int hi = right; // 부분리스트의 가장 오른쪽 인덱스
		int pivot = a[left];		// 부분리스트의 왼쪽 요소를 피벗으로 설정
		
		// lo가 hi보다 작을 때 까지만 반복
		while(lo < hi) {
			
			// hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를 찾을 때 까지
			while(a[hi] > pivot && lo < hi) {
				hi--;
			}
			
			// hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를 찾을 때 까지 lo를 증가			 
			while(a[lo] <= pivot && lo < hi) {
				lo++;
			}
			
			// 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
			swap(a, lo, hi);
		}
		
		
		// lo >= hi. lo와 hi가 겹치거나 크로스 되면 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와 lo가 가리키는 원소를 바꾼다.
		swap(a, left, lo);
		
		// 두 요소가 교환되었다면 피벗이었던 요소는 lo에 위치하므로 pivot의 새 인덱스인 lo를 반환한다.
		return lo; // 즉, lo의 참조값이 파티션의 기준이 됨 
	}
 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
```

<br>

## 2. 오른쪽 피벗 버전

### 구현

```java
public class QuickSort {
	
	public static void sort(int[] a) {
		r_pivot_sort(a, 0, a.length - 1);
	}
	
	/**
	 *  오른쪽 피벗 선택 방식
	 * @param a		정렬할 배열
	 * @param lo	현재 부분배열의 왼쪽
	 * @param hi	현재 부분배열의 오른쪽
	 */
	private static void r_pivot_sort(int[] a, int lo, int hi) {
		
		/*
		 *  lo가 hi보다 크거나 같다면 정렬 할 원소가 
		 *  1개 이하이므로 정렬하지 않고 return한다.
		 */
		if(lo >= hi) {
			return;
		}
		
		/*
		 * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로
		 * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
		 * 
		 * 그리고나서 해당 피벗을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어
		 * 분할 정복을 해준다.
		 * 
		 * [과정]
		 * 
		 * Partitioning:
		 *
		 *         left part                right part       a[right]   
		 * +---------------------------------------------------------+
		 * |    element < pivot    |    element >= pivot   |  pivot  |
		 * +---------------------------------------------------------+
		 *    
		 *    
		 *  result After Partitioning:
		 *  
		 *         left part         a[hi]          right part
		 * +---------------------------------------------------------+
		 * |   element < pivot    |  pivot  |    element >= pivot    |
		 * +---------------------------------------------------------+
		 *       
		 *       
		 *  result : pivot = hi     
		 *       
		 *
		 *  Recursion:
		 *  
		 * r_pivot_sort(a, lo, pivot - 1)     r_pivot_sort(a, pivot + 1, hi)
		 *  
		 *         left part                           right part
		 * +-----------------------+             +-----------------------+
		 * |   element <= pivot    |    pivot    |    element > pivot    |
		 * +-----------------------+             +-----------------------+
		 * lo                pivot - 1        pivot + 1                 hi
		 * 
		 */
		int pivot = partition(a, lo, hi);	//pivot의 새 인덱스 = hi를 반환받아 pivot에 저장	
		
		r_pivot_sort(a, lo, pivot - 1);
		r_pivot_sort(a, pivot + 1, hi);
	}
	
	
	
	/**
	 * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
	 * 
	 * @param a		정렬 할 배열 
	 * @param left	현재 배열의 가장 왼쪽 부분
	 * @param right	현재 배열의 가장 오른쪽 부분
	 * @return		최종적으로 위치한 피벗의 위치(lo)를 반환
	 */
	private static int partition(int[] a, int left, int right) {
		
		int lo = left;
		int hi = right;
		int pivot = a[right];		// 부분리스트의 오른쪽 요소를 피벗으로 설정
		
		// lo가 hi보다 작을 때 까지만 반복한다.
		while(lo < hi) {
			
			/*
			 * hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를
			 * 찾을 떄 까지 lo를 증가시킨다.
			 */
			while(a[lo] < pivot && lo < hi) {
				lo++;
			}
			
			/*
			 * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를
			 * 찾을 떄 까지 hi를 감소시킨다.
			 */
			while(a[hi] >= pivot && lo < hi) {
				hi--;
			}
			
			
			// 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
			swap(a, lo, hi);
		}
		
		
		/*
		 *  lo >= hi. lo와 hi가 겹치거나 크로스 되면
		 *  마지막으로 맨 처음 pivot으로 설정했던 위치(a[right])의 원소와 
		 *  hi가 가리키는 원소를 바꾼다.
		 *  => a[hi]에는 pivot이, pivot의 인덱스([hi])에는 hi에 있던 값이 저장됨
		 */
		swap(a, right, hi);
		
		// 두 요소가 교환되었다면 피벗이었던 요소는 hi에 위치하므로 hi를 반환한다.
		return hi; // pivot의 새 인덱스 = hi를 반환
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
```

<br>

## 3. 중간 피벗 버전

> `pivot = arr[(lo + hi)/2]` : 중간 인덱스를 pivot으로 설정

### 구현
```java
public class QuickSort {
	
	public static void sort(int[] a) {
		m_pivot_sort(a, 0, a.length - 1);
	}
	
	/**
	 *  중간 피벗 선택 방식
	 * @param a		정렬할 배열
	 * @param lo	현재 부분배열의 왼쪽
	 * @param hi	현재 부분배열의 오른쪽
	 */
	private static void m_pivot_sort(int[] a, int lo, int hi) {
		
		/*
		 *  lo가 hi보다 크거나 같다면 정렬 할 원소가 
		 *  1개 이하이므로 정렬하지 않고 return한다.
		 */
		if(lo >= hi) {
			return;
		}
		
		/*
		 * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로
		 * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
		 * 
		 * 그리고나서 해당 피벗을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어
		 * 분할 정복을 해준다.
		 * 
		 * [과정]
		 * 
		 * Partitioning:
		 *
		 *      left part      a[(right + left)/2]      right part      
		 * +---------------------------------------------------------+
		 * |    element < pivot    |  pivot  |    element >= pivot   |
		 * +---------------------------------------------------------+
		 *    
		 *    
		 *  result After Partitioning:
		 *  
		 *         left part         a[hi]          right part
		 * +---------------------------------------------------------+
		 * |   element < pivot    |  pivot  |    element >= pivot    |
		 * +---------------------------------------------------------+
		 *       
		 *       
		 *  result : pivot = hi     
		 *       
		 *
		 *  Recursion:
		 *  
		 * m_pivot_sort(a, lo, pivot)         m_pivot_sort(a, pivot + 1, hi)
		 *  
		 *         left part                           right part
		 * +-----------------------+             +-----------------------+
		 * |   element <= pivot    |             |    element > pivot    |
		 * +-----------------------+             +-----------------------+
		 * lo                pivot          pivot + 1                   hi
		 * 
		 */
		int pivot = partition(a, lo, hi);	
		
		m_pivot_sort(a, lo, pivot);
		m_pivot_sort(a, pivot + 1, hi);
	}
	
	
	
	/**
	 * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
	 * 
	 * @param a		정렬 할 배열 
	 * @param left	현재 배열의 가장 왼쪽 부분
	 * @param right	현재 배열의 가장 오른쪽 부분
	 * @return		최종적으로 위치한 피벗의 위치(hi)를 반환
	 */
	private static int partition(int[] a, int left, int right) {
		
		// lo와 hi는 각각 배열의 끝에서 1 벗어난 위치부터 시작한다.
		int lo = left - 1; // -1 // [left] [0][1][2][3]..[length-1] [right]
		int hi = right + 1; // a.length
		int pivot = a[(left + right) / 2];		// 부분리스트의 중간 요소를 피벗으로 설정
		
 
		while(true) {
			
			/*
			 * 1 증가시키고 난 뒤의 lo 위치의 요소가 pivot보다 큰 요소를
			 * 찾을 떄 까지 반복한다.
			 */
			do { 
				lo++; 
			} while(a[lo] < pivot);
 
			
			/*
			 * 1 감소시키고 난 뒤의 hi 위치가 lo보다 크거나 같은 위치이면서
			 * hi위치의 요소가 pivot보다 작은 요소를 찾을 떄 까지 반복한다.
			 */
			do {
				hi--;
			} while(a[hi] > pivot && lo <= hi);
			
			
			/*
			 * 만약 hi가 lo보다 크지 않다면(엇갈린다면) swap하지 않고 hi를 리턴한다.
			 */
			if(lo >= hi) {
				return hi;
			}
			
			
			// 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
			swap(a, lo, hi);
		}
		
	}
	
	
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
```

### 무주석 버전
```java
public class QuickSort {
	
	public static void sort(int[] a) {
		m_pivot_sort(a, 0, a.length - 1);
	}
	
	private static void m_pivot_sort(int[] a, int lo, int hi) {

		if(lo >= hi) {
			return;
		}

		int pivot = partition(a, lo, hi);	
		
		m_pivot_sort(a, lo, pivot);
		m_pivot_sort(a, pivot + 1, hi);
	}
	
	private static int partition(int[] a, int left, int right) {
		
		// lo와 hi는 각각 배열의 끝에서 1 벗어난 위치부터 시작한다.
		int lo = left - 1; // -1 // [left] [0][1][2][3]..[length-1] [right]
		int hi = right + 1; // a.length
		int pivot = a[(left + right) / 2];		// 부분리스트의 중간 요소를 피벗으로 설정
		
 
		while(true) {
			
			do { 
				lo++; 
			} while(a[lo] < pivot);
 
			do {
				hi--;
			} while(a[hi] > pivot && lo <= hi);
			
			if(lo >= hi) {
				return hi;
			}
			
			swap(a, lo, hi);
		}
		
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
```

<br>

## 피벗 비교 요약

| **방식**      | **피벗 위치** | **같은 값 처리**                         | **lo 조건** | **hi 조건** |
|-------------| --- |-------------------------------------| --- | --- |
| **왼쪽 피벗**   | a[lo] (맨 왼쪽) | **같은 값 → 오른쪽 그룹에 포함**               | arr[lo] <= pivot | arr[hi] > pivot |
| **오른쪽 피벗** | a[hi] (맨 오른쪽) | **같은 값 → 왼쪽 그룹에 포함**                       | arr[lo] < pivot | arr[hi] >= pivot |
| **중간 피벗**  | a[(lo+hi)/2] (중앙) | **기본적으로 분리 안 함, 위치 유지 또는 안정 정렬 고려** | arr[lo] < pivot | arr[hi] > pivot |

왼쪽 : lo만 같은 값일 때 멈춤 → swap. 즉, 같은 값은 오른쪽 그룹(큰 수 그룹)

- pivot을 lo와 swap해서 정렬된 자리에 보내는게 목적

오른쪽 : hi만 같은 값일 때 멈춤 → swap. 즉, 같은 값은 왼쪽 그룹(작은 수 그룹)

중간 : lo, hi 모두 같은 값일 때 멈춤


<br>

## 요약

| 항목 | 설명                         |
|---|----------------------------|
| 정렬 방식 | 비교 정렬                      |
| 안정성 | ❌ (동일 원소 순서 깨짐)            |
| 제자리 정렬 | ✅ 추가 공간 불필요                |
| 장점 | 평균 O(N log N), 매우 빠름       |
| 단점 | 피벗 선택이 나쁘면 O(N²)           |
| 개선 | 랜덤 피벗 / 3-Way QuickSort 등  |


### 코테 활용

K번째 수, Top-K, 정렬 구현 문제에 자주 등장
