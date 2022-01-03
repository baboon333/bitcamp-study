# 01 변수 및 배열 사용법

## 실습

### 1단계 - 연락처 목록 구현

- 화면 구현
  - /static/contact/index.html 생성
    - 0: 기본 화면
    - 1: 테이블 추가
    - 2: 연락처 배열 준비 및 각 항목 확인
    - 3: 문자열에서 이름, 이메일, 전화, 회사 정보 추출
    - 4: 테이블에 추가할 tr 태그 생성
    - 5: tr 태그를 테이블에 추가
- REST API 구현
  - com.eomcs.mylist.ContactController.list()
- 화면과 REST API 연동
  - /static/contact/index.html 변경
    - 6: AJAX를 이용하여 서버의 REST API와 연동하기

### 2단계 - 연락처 입력 구현

- REST API 구현
  - com.eomcs.mylist.ContactController.add()
- 화면 구현
  - /static/contact/form.html 생성
    - 0: 기본 화면
    - 1: 입력 폼 추가
    - 2: 버튼 클릭 리스너 등록
    - 3: 버튼을 클릭할 때 입력 폼의 값을 알아내기
    - 4: 입력된 값을 서버에 보내기
    - 5: 취소 버튼 추가
    - 6: 리팩토링 - replace temp with query
      - 함수의 리턴 값을 받는 변수를 한 번만 사용할 경우 변수 대신 함수 호출을 삽입하라!
      - 즉 임시 변수를 사용할 자리에 함수 호출을 그대로 집어 넣어라!
    - 7: 필수입력 항목 검사하기
    - 8: 최적화 - 태그 찾기를 리스너 밖에 둔다.
    - 9: 등록 후 목록 화면으로 이동

### 3단계 - 연락처 데이터 유지

- REST API 기능 변경
  - com.eomcs.mylist.ContactController  변경
    - 배열을 로컬 변수에서 인스턴스 변수로 전환한다.
    - list()와 add()는 인스턴스 배열 변수를 사용한다.
    - list(): 배열에 입력된 값을 별도의 배열에 담아 리턴한다.
    - add(): 인스턴스 배열에 값을 보관한다.

### 4단계 - 연락처 상세보기 구현

- 화면 구현
  - /static/contact/view.html 생성
    - 0: form.html 을 복사해 온다.
    - 1: URL에서 쿼리스트링을 추출한다.
    - 2: 쿼리스트링에서 이메일 값을 추출한다.
    - 3: 연락처 상세 정보를 출력한다.
  - /static/contact/index.html 변경
    - 연락처의 이름에 상세보기 링크를 추가한다.
- REST API 구현
  - com.eomcs.mylist.ContactController.get()
- 화면과 REST API 연동
  - /static/contact/view.html 변경
    - 4: 서버에서 데이터 가져온다.
    - 5: 쿼리스트링 분석기 URLSearchParams 객체를 사용해서 email 파라미터를 추출한다.

### 5단계 - 연락처 변경 구현

- 화면 구현
  - /static/contact/view.html 변경
    - 6: 이메일 항목을 readonly로 변경한다.
    - 7: 변경한 내용을 서버에 보낸다.
- REST API 구현
  - com.eomcs.mylist.ContactController.update()

### 6단계 - 연락처 삭제 구현

- REST API 구현
  - com.eomcs.mylist.ContactController.delete()
- 화면 구현
  - /static/contact/view.html 변경
    - 8: 삭제 버튼 추가 및 리스너를 등록한다.
    - 9: 서버에 삭제를 요청한다.





# 02 메서드 사용법

- 특정 기능을 수행하는 코드에 대해 메서드로 정의해두면 재사용이 쉽고 코드 유지보수가 쉽다.
- 코드를 메서드로 분리하는 경우
  - 유사한 코드가 여러 곳에서 중복 사용될 때
  - 코드의 기능을 명확하게 설명하고 싶을 때


## 백엔드 개발 실습

### 1단계 - 한 사람의 연락처 정보를 문자열로 만드는 코드를 메서드로 분리한다.

- ContactController.createCSV() 정의
  - add() 변경
  - update() 변경
  - 백업: ContactController.java.01

### 2단계 - 이메일로 연락처를 찾아 배열 인덱스를 알아내는 코드를 분리한다.

- ContactController.indexOf() 정의
  - get() 변경
  - update() 변경
  - 백업: ContactController.java.02

### 3단계 - 배열 항목 삭제 코드를 분리한다.

코드 기능을 명확하게 설명하고 싶을 때도 메서드를 활용하여 코드를 분리한다.

- ContactController.remove() 정의
  - delete() 변경
  - 백업: ContactController.java.03

### 4단계 - 배열 크기를 자동으로 늘린다.

- ContactController.add() 변경
  - 배열이 꽉차면 새 배열을 만들어 확장한다.
  - 백업: ContactController.java.04

### 5단계 - 배열 크기를 늘리는 코드를 별도의 메서드로 분리한다.

코드 기능을 명확하게 설명하고 싶을 때도 메서드를 활용하여 코드를 분리한다.

- ContactController.grow() 생성
  - add() 변경
  - 백업: ContactController.java.05

### 6단계 - 배열 크기를 계산하는 코드를 별도의 메서드로 분리한다.

코드 기능을 명확하게 설명하고 싶을 때도 메서드를 활용하여 코드를 분리한다.

- ContactController.newLength() 생성
  - grow() 변경
  - 백업: ContactController.java.06

### 7단계 - 배열을 복사하는 코드를 메서드로 분리한다.

코드 기능을 명확하게 설명하고 싶을 때도 메서드를 활용하여 코드를 분리한다.

- ContactController.copy() 생성
  - grow() 변경
  - 백업: ContactController.java.07
