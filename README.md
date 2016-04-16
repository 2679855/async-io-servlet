# async-io-servlet

서블릿이 동기 방식과 비동기 방식으로 동작할 때의 성능차이를 테스트
* 요청 -> AsyncServlet -> WorkServlet
* 요청 -> BlockingServlet -> WorkServlet


# 성능차이 확인 결과

비동기 방식이 동기 방식에 비해 더 많은 요청을 처리할 수 있음
* n개의 요청 스레드까지는 두 가지 방식의 처리량이 비슷
* n개를 넘어서는 경우
    * 동기 방식은 처리량이 정체됨
    * 비동기 방식은 동기 방식보다 더 많은 동시 요청을 처리함
