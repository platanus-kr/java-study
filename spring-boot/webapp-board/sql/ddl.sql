CREATE TABLE t_file(
                       idx int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '일련번호',
                       board_idx int(10) unsigned NOT NULL COMMENT '게시글 번호',
                       original_file_name varchar(255) NOT NULL COMMENT '원본 파일 이름',
                       stored_file_path varchar(500) NOT NULL COMMENT '파일 저장 경로',
                       file_size int(15) unsigned NOT NULL COMMENT '파일 크기',
                       creator_id varchar(50) NOT NULL COMMENT '작성자 아이디',
                       created_datetime datetime NOT NULL COMMENT '작성 시간',
                       updator_id varchar(50) DEFAULT NULL COMMENT '수정자 아이디',
                       updated_datetime datetime DEFAULT NULL COMMENT '수정 시간',
                       deleted_yn char(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부',
                       PRIMARY KEY(idx)
);


CREATE TABLE t_board(
                        board_idx INT(11) NOT NULL AUTO_INCREMENT COMMENT '글 번호',
                        title varchar(300) NOT NULL COMMENT '제목',
                        contents text not null COMMENT '내용',
                        hit_cnt smallint(10) not null default '0' comment '조회수',
                        created_datetime datetime not null comment '작성시간',
                        creator_id varchar(50) not null comment '작성자',
                        updated_datetime datetime DEFAULT null comment '수정시간',
                        updater_id varchar(50) default null comment '수정자',
                        delete_yn char(1) not null default 'n' comment '삭제 여부',
                        PRIMARY key (board_idx)
);