package org.platanus.webappboard.app.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_jpa_board")
@NoArgsConstructor
@Data
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardIdx;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private int hitCnt = 0;

    @Column(nullable = false)
    private String creatorId;

    @Column(nullable = false)
    private LocalDateTime createDatetime = LocalDateTime.now();

    private String updaterId;

    private LocalDateTime updatedDatetime;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "board_idx")
    private Collection<BoardFileEntity> fileList;
}
