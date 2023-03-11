package hello.corespring.member;

// 회원 엔티티
public class Member {
    private Long id;        // 회원 번호
    private String name;    // 회원 이름
    private Grade grade;    // 회원 등급

    // Member 생성자
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // tip) getter, setter 단축키는 Alt + Insert
    // id, name, grade의 getter, setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
