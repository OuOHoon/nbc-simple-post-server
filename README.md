# 내일배움캠프 개인과제 익명 게시판 서버 만들기


## 1. 수정, 삭제 API의 request를 어떤 방식으로 사용 하셨나요? (param, query, body)
#### 수정 API는 PUT method를 사용하여 body에 json 형식의 request를 받기로 설계했습니다.
PUT과 PATCH 중에 고민했는데, 게시글 수정은 모든 데이터를 전송하는 것이 일반적인 상황이라고 생각했습니다.
QUERY는 REST API에서 URL이 리소스의 식별값으로 사용되기 때문에 적절하지 않고, PARAM은 postId를 식별하는데 사용했습니다. 게시글의 내용은 body를 사용합니다.
#### 삭제 API는 DELETE method를 사용하여 password 헤더를 받기로 설계했습니다.
DELETE method는 전송할 때 body 사용을 지양하기 때문에 헤더로 전송하기로 설계했습니다.
## 2. RESTful한 API를 설계하셨나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
RESTful한 API를 설계했습니다. 각 API마다 적절한 method, url, 상태 코드를 설계했습니다.
## 3. 적절한 관심사 분리를 적용하셨나요? (Controller, Service, Repository)
Controller, Service, Repository를 적절히 분리했습니다.
## 4. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
Postman을 사용해서 예외 상황들에 대한 예제를 보여주는 것과 표로 만들어서 보여주는 것 모두 장단점이 있다고 생각합니다. 예제는 어떤 값에 어떤 예외가 발생했는지 알 수 있어서 좋지만 한 눈에 확인하기 좋지 않습니다. 표로 만든 명세서는 한 눈에 알 수 있어서 좋지만 표의 특성상 어떤 값에 어떤 예외가 발생했는지 확인하기 불편합니다.
## Use Case Diagram
<img width="793" alt="image" src="https://github.com/OuOHoon/nbc-simple-post-server/assets/17760465/48008b37-0961-454a-adc3-e5dbae8bf750">
## API 명세서
https://documenter.getpostman.com/view/17745457/2s9YXfa2zW PostMan으로 생성한 API 명세서입니다.

## ERD
<img width="322" alt="image" src="https://github.com/OuOHoon/nbc-simple-post-server/assets/17760465/0eec8b1e-355e-48db-89bf-e84f2e25bcb7">

