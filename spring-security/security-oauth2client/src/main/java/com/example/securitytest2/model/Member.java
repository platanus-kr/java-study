package com.example.securitytest2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members",
        indexes = {@Index(columnList = "providerId")}
)
public class Member extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String providerId;
    private String provider;
    private String username;
    private String password;
    private String profileImage;
    private String htmlUrl;
    private String name;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private MemberRole role;
    public Member update(Member m) {
        this.name = m.getName();
        this.profileImage = m.getProfileImage();
        this.username = m.getUsername();
        this.htmlUrl = m.getHtmlUrl();
        return this;
    }
}
