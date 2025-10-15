# In/Out


## EOF
"End of File"

1. 한 줄 단위로 입력 받을 때

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String input = "";

while((input = br.readLine()) != null) {
  // 이후 로직 전개.
}
```

2. 줄바꿈으로 

관련 문제 -> 
- [백준 #5648](https://www.acmicpc.net/problem/5648) [풀이](/solutions/09/S5648.java)
- [백준 #4779](https://www.acmicpc.net/problem/4779) [풀이](/solutions/11/S4779.java)

```java
String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                list.add(Long.parseLong(st.nextToken()));
            }
        }
```