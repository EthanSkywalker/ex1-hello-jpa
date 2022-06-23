package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")    // 1 : N 매핑에서 뭐랑 연결이 돼있는지를 알려주는 것 (Member.java 의 Team 에 연결돼 있다!)
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        member.setTeam(this);
        members.add(member);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void setName(String name) {
        this.name = name;
    }
}
