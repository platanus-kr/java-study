package board;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardApplicationTests {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Test
	public void contextLoads() {
		
	}
	

	@Test
	public void testSqlSession() throws Exception{
		System.out.println(sqlSession.toString());
	}

}

//
//CREATE TABLE t_table(
//		board_idx INT(11) NOT NULL AUTO_INCREMENT COMMENT '글 번호',
//		title VARCHAR(300) NOT NULL COMMENT '제목',
//		contents TEXT NOT NULL COMMENT '내용',
//		hit_cnt SMALLINT(10) NOT NULL DEFAULT '0' COMMENT '조회수',
//		created_datetime DATETIME NOT NULL COMMENT '작성시간',
//		creator_id VARCHAR(50) NOT NULL COMMENT '작성자',
//		updated_datetime DATETIME DEFAULT NULL COMMENT '수정자',
//		deleted_yn CHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부',
//		PRIMARY KEY (board_idx)
//	);