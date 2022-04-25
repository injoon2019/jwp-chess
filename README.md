# 웹 체스

체스 미션 저장소

## 기능 구현 목록 🛠

- [x] Spring Framework를 활용하여 애플리케이션을 구동한다.
- [x] Spark를 대체하여 Spring MVC를 활용하여 요청을 받고 응답을 한다.
- [x] Spring JDBC를 활용하여 DB 접근하던 기존 로직을 대체한다.
- [x] 스프링 애플리케이션으로 체스가 실행 가능 해야한다.
- [x] @Controller나 @RestController를 활용하여 요청을 받아야 한다.
- [x] Spring JDBC에서 제공하는 JdbcTemplate를 이용하여 Connection을 직접 만들어 주는 로직을 대체한다.
- [x] JdbcTemplate는 매번 새로 생성하지 않고 빈 주입을 받아서 사용한다.

---

> Web

### 프로그램 실행 방법 🏃

1. docker, docker-compose를 설치해주세요. (DB를 도커로 띄웁니다 🐳)
2. 프로젝트의 `docker/db/mysql` 안에 `data` 디랙토리가 있다면 삭제해주세요!

   (`data` 디랙토리가 있으면 테이블 생성 쿼리가 실행되지 않아요)
3. 로컬에서 `3306`포트가 사용중인지 체크해주세요.

   만약 `3306`포트가 사용중 이라면 `docker-compose.yml`파일에 `ports`를 변경해주세요.

    ```dockerfile
   # AS-IS
       ports:
      - "3306:3306"
   
   # TO-BE
       ports:
      - "13306:3306"
   # OR
       ports:
      - "23306:3306"
   ```


4. 터미널을 켠 후, 아래 명령어를 실행해서 DB를 도커로 띄웁니다! 🐳

    ```shell
    cd docker;
    docker-compose -p chess -up
    ```

5. `WebApplication`을 실행한 후, <a href="http://localhost:8080" target="_blank">http://localhost:8080 </a>로 접속합니다 🤗
6. 프로그램을 종료했다면 아래 명령어로 도커 컨테이너를 내려주세요 👋
    ```shell
    docker-compose -p chess down
    ```

---

| Method |           Url           |         Description         |
|--------|-------------------------|-----------------------------|
|GET     |/                        |메인 페이지                     |
|GET     |/rooms/{name}            |이름이 {name}인 방 조회          |
|POST    |/rooms/{name}            |새로운 방 생성                  |
|DELETE  |/rooms/{name}            |방 삭제                        |
|GET     |/rooms/{name}/pieces     |{name} 방이 소유한 모든 기물 조회  |
|POST    |/rooms/{name}/pieces     |{name} 방의 기물 등록           |
|PUT     |/rooms/{name}/pieces     |{name} 방의 기물 위치 변경       |
|GET     |/rooms/{name}/scores     |{name} 방의 점수 조회           |
|GET     |/rooms/{name}/turn       |{name} 방 현재 턴 조회          |
|GET     |/rooms/{name}/result     |{name} 방의 result 조회        |

## Wiki 📚

### 기물 점수

|     기물     |     점수     |
| ----------- | ----------- |
| 킹(King)     |  0         |
| 퀸(Queen)    |  9         |
| 록(Rook)     |  5         |
| 비숍(Bishop) |  3         |
| 나이트(Knight)|  2.5       |
| 폰(Pawn)     |  1         |

### 용어

- 랭크(Rank) : 체스판의 가로줄, `A ~ H` 표기
- 파일(File) : 체스판의 세로줄, `1 ~ 8` 표기

## About 폰 ♟

| 이동하려는 위치에 | 이동 가능 여부 |
|--------------|-------------|
|비어있는 칸      | 직진 (초기 위치라면 2칸까지)|
|적 기물         | 대각선       |
|아군 기물       | 이동 불가     |

---

## 페어 규칙 🧨

- 교대 시간은 20분을 기준으로 한다.
- 일일 회고를 진행한다.
- [코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)
- 커밋 작성 방법(한글)
- github과 구글 미트를 활용하여 진행한다.
- 최대한 `final` 키워드를 활용한다.
- 동작하는 코드를 최우선으로 작성한다.
- 토요일 23시 59분 자체 마감

## 회고 🤗

<details>
<summary>2022-04-19</summary>

### 느낀점

`엘리`: 이렇게 회고를 하고 있다는 것이 신기하다. 체계적으로 앞으로 어떻게 할지 정하고 나니 출발이 좋다고 생각한다.

`릭(릭냥이)`: 3인 페어라 조금 걱정 스러웠지만 느낌이 괜찮다.

`매트`: 내 체스 코드가 쓰레기라 걱정했는데 다행히 3인 페어라 고를 수 있는 선택지가 많아서 좋았다.

### 페어에게 좋았던 점

`엘리`: 포키한테 매트 칭찬을 듣고, 애쉬한테는 릭이 귀엽다는 이야기를 듣고 앞으로 기대가 된다.

`릭(릭냥이)`:  생각하는 방향이 비슷한 것 같아서 싱크를 맞추는데 편했다.

`매트`: 다들 자신의 의견을 적극적으로 표현하여 규칙이나 코드를 선택하는데 빠르게 진행될 수 있었다.

### 아쉬웠던 점

`엘리`: 레벨 로그가 아직 미완성되어 조금 미안한 마음이 든다.

`릭(릭냥이)`:  스프링 학습과 레벨 로그로 인해 바로 시작을 못해서 아쉬웠다.

`매트`: 다 좋은데 선릉 환경이 생각보다 쾌적하지 않아서 조금 아쉽다.
</details>


<details>
<summary>2022-04-22</summary>

### 느낀점

`엘리`: 생각보다 빨리 끝났다. 근데 선릉 공기가 너무 안좋아서 머리가 아파서 슬프다.

`릭(릭냥이)`: 생각대로 빨리 끝났다.

`매트`: 페어와 함께하는 건 좋지만 선릉 시설이 생각보다 너무 열약하다. ㅠㅜ

### 페어에게 좋았던 점

`엘리`: 다들 준비를 잘 해와서 빨리 빨리 잘 한 것 같아서 좋았다. 릭 코드가 생각보다 계층이 잘 나눠져 있어서 스프링을 적용하는데 변경 사항이 적었다.

`릭(릭냥이)`: 한게 없었는데 버스를 탄거 같다. 하지만 나는 코드 제공을 했다.

`매트`: 다들 열의을 다해 참여하여 빠르게 예외들을 캐치할 수 있었다. 덕분에 아주 빠르게 미션의 초안을 마무리할 수 있었다.

### 아쉬웠던 점

`엘리`: 릭이 js쪽을 조금 이상하게 작성하여 생각보다 많은 변경 사항이 생겼다. 덕분에 클린 코드의 중요성에 대해 알게 되었다.

`릭(릭냥이)`: 상태 코드를 분리해서 처리하지 못한 점이 아쉽다.

`매트`: Spring에 대한 배경지식은 풍부했지만 js가 우리의 발목을 잡았다. 또한 릭의 레거시 코드를 변경하는 작업이 약간의 반복 작업 위주여서 토론 거리가 많지 않았다.
</details>

<details>
<summary>2022-04-23</summary>

## 느낀점

`엘리`: 생각보다 페어 프로그래밍이 일찍 끝나서 찝찝하면서도 좋다.

`릭(릭냥이)`: 1단계에서 해야할 것들이 별로 없어서 이게 맞나 싶으면서도 일찍 끝나서 좋다.

`매트`: 1단계 요구사항이 크지 않아서 빨리 끝난 건 좋지만 2단계 요구사항을 살짝 보니 앞날이 캄캄하다.

### 페어에게 좋았던 점

`엘리`: 대화를 하면서 소통이 원할 하게 되서 좋았다. 새롭게 페어 프로그래밍 규칙들을 도입 했는데 모두 잘 참여해서 유익하고 재밌었다.

`릭(릭냥이)`: 혼자 했으면 요구사항을 초월하는 부분까지 구현 했을 것 같은데 페어 덕분에 적절한 선을 지킬 수 있어서 좋았다.

`매트`: 조금은 도전적일 수 있지만 평소 안해본 방법을 권했을 때 모두 빠르게 이해하고 진행할 수 있어서 좋았다. 다들 건전한 토론을 통해 기술적인 이야기를 나눌 수 있어서 좋았다.

### 아쉬웠던 점

`엘리`: 생각 보다 토론할 거리가와 이야기 나눌 거리가 적어서 아쉬웠다. 2단계를 진행하며 많이 괴롭힐 예정이다.

`릭(릭냥이)`: 확실히 2명보다 3명이 힘들다. 이야기를 더 많이 들어주고 더 많은 의견을 받아야 하니깐 힘들었다.

`매트`: 미션에 관련된 이야기를 많이 하지 못해 아쉬웠고 선릉을 통학하며 컨디션 조절에 실패해서 다른 크루들에게 피해가 가지 않을까 걱정이 된 점이 아쉬웠다.

</details>