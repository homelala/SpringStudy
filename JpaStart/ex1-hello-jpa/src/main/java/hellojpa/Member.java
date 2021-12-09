package hellojpa;
import javax.persistence.*;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name ="MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "TEAM_ID")
    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY) //지연로딩
    @JoinColumn
    private Team team;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}