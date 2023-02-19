package com.example.securitytest2.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String providerId;
    private String username;
    private String avatarUrl;
    private String htmlUrl;
    private String name;
    private String email;
    private MemberRole role;
    private LocalDateTime joinDate;
    private LocalDateTime updateDate;

    public Member update(Member m) {
        this.name = m.getName();
        this.avatarUrl = m.getAvatarUrl();
        this.username = m.getUsername();
        this.htmlUrl = m.getHtmlUrl();
        this.updateDate = LocalDateTime.now();
        return this;
    }
}
