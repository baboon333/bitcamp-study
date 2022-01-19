package com.eomcs.mylist.domain;

public class Contact implements java.io.Serializable {
  String name;
  String email;
  String tel;
  String company;

  public Contact() {
    System.out.println("Contact() 호출됨!");
  }

  public Contact(String csvStr){  // 생성자 이러라고 만드는 거임!!
    // csvStr의 예 => "홍길동,hong@test.com,010-1111-2222,비트캠프"

    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com","010-1111-2222","비트캠프"]
    this.setName(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    this.setEmail(values[1]);
    this.setTel(values[2]);
    this.setCompany(values[3]);
  }


  // 적용기술
  // => 스태틱 메서드 : 특정 인스턴스에 종속되지 않고 사용하는 메서드.
  // => GoF의 'Factory Method' 패턴
  //    객체 생성 과정이 복작할 경우 new 명령을 통해 직접 객체를 생성하는 대신에
  //    메서드를 통해 객체를 리턴 받는다.
  //    이렇게 객체를 만들어 주는 메서드를 "공장 메서드(factory method)"라 부른다.
  //    보통 스태틱 메서드로 정의한다.
  //
  // valueof라는 메서드를 만나면 factory method라고 생각해!!! valueof라는 메서드 안에 캡슐화 시키는 것! 3시 58분! 캡슐화: 복잡한 메서드를 감추는 것!!
  //
  // 위에 생성자랑 비교해서 더 편한거로 쓰면된다!!!
  public static Contact valueOf(String csvStr){  // contact 객체를 리턴한다  // 이 메서드는 인스턴스를 쓰지 않으니 static으로!
    // csvStr의 예) "홍길동,hong@test.com,010-1111-2222,비트캠프"

    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com","010-1111-2222","비트캠프"]

    Contact contact = new Contact(); // 파일에서 읽은 데이터를 담을 객체를 준비한다.
    contact.setName(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    contact.setEmail(values[1]);
    contact.setTel(values[2]);
    contact.setCompany(values[3]);

    return contact;
  }

  // 적용 기술
  // => 인스턴스 메서드 : 특정 인스턴스를 사용한다면 인스턴스 메서드로 만들라!
  // => GRASP의 Information Expert 패턴: 
  //    데이터를 가공하는 기능은 그 데이터를 갖고 있는 클래스에 둬야 한다. (그러니 ContactController가 아닌 Contact에 있어야!)
  // 왜 이런 식으로, 여기에 코드를 짠거다! 이런걸 설명할 수 있어야 한다. 이런게 이 수업에서 진짜 배워가야 할 것!!
  public String toCsvString() {  //현재 연락처 정보를 csv 형식으로 뽑을 꺼니 static 붙이면 안된다!
    return String.format("%s,%s,%s,%s",
        this.getName(),
        this.getEmail(),
        this.getTel(),
        this.getCompany());
  } //csv(comma-separated values) : 몇 가지 필드를 쉼표(,)로 구분한 텍스트 데이터 및 텍스트 파일

  @Override
  public String toString() {  // 스트링으로 줘
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", company=" + company
        + "]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }


}
