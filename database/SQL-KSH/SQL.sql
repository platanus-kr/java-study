SQL 정복 쿼리 예제 모음집 
최초 작성일 : 2021년 1월 11일


-------------------------------------------------
-- 2장

CREATE TABLE tCity
(
	name CHAR(10) PRIMARY KEY,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL
);

INSERT INTO tCity VALUES ('서울',605,974,'y','경기');
INSERT INTO tCity VALUES ('부산',765,342,'y','경상');
INSERT INTO tCity VALUES ('오산',42,21,'n','경기');
INSERT INTO tCity VALUES ('청주',940,83,'n','충청');
INSERT INTO tCity VALUES ('전주',205,65,'n','전라');
INSERT INTO tCity VALUES ('순천',910,27,'n','전라');
INSERT INTO tCity VALUES ('춘천',1116,27,'n','강원');
INSERT INTO tCity VALUES ('홍천',1819,7,'n','강원');

SELECT * FROM tCity;

CREATE TABLE tStaff
(
	name CHAR (15) PRIMARY KEY,
	depart CHAR (10) NOT NULL,
	gender CHAR(3) NOT NULL,
	joindate DATE NOT NULL,
	grade CHAR(10) NOT NULL,
	salary INT NOT NULL,
	score DECIMAL(5,2) NULL
);

INSERT INTO tStaff VALUES ('김유신','총무부','남','2000-2-3','이사',420,88.8);
INSERT INTO tStaff VALUES ('유관순','영업부','여','2009-3-1','과장',380,NULL);
INSERT INTO tStaff VALUES ('안중근','인사과','남','2012-5-5','대리',256,76.5);
INSERT INTO tStaff VALUES ('윤봉길','영업부','남','2015-8-15','과장',350,71.25);
INSERT INTO tStaff VALUES ('강감찬','영업부','남','2018-10-9','사원',320,56.0);
INSERT INTO tStaff VALUES ('정몽주','총무부','남','2010-9-16','대리',370,89.5);
INSERT INTO tStaff VALUES ('허난설헌','인사과','여','2020-1-5','사원',285,44.5);
INSERT INTO tStaff VALUES ('신사임당','영업부','여','2013-6-19','부장',400,92.0);
INSERT INTO tStaff VALUES ('성삼문','영업부','남','2014-6-8','대리',285,87.75);
INSERT INTO tStaff VALUES ('논개','인사과','여','2010-9-16','대리',340,46.2);
INSERT INTO tStaff VALUES ('황진이','인사과','여','2012-5-5','사원',275,52.5);
INSERT INTO tStaff VALUES ('이율곡','총무부','남','2016-3-8','과장',385,65.4);
INSERT INTO tStaff VALUES ('이사부','총무부','남','2000-2-3','대리',375,50);
INSERT INTO tStaff VALUES ('안창호','영업부','남','2015-8-15','사원',370,74.2);
INSERT INTO tStaff VALUES ('을지문덕','영업부','남','2019-6-29','사원',330,NULL);
INSERT INTO tStaff VALUES ('정약용','총무부','남','2020-3-14','과장',380,69.8);
INSERT INTO tStaff VALUES ('홍길동','인사과','남','2019-8-8','차장',380,77.7);
INSERT INTO tStaff VALUES ('대조영','총무부','남','2020-7-7','차장',290,49.9);
INSERT INTO tStaff VALUES ('장보고','인사과','남','2005-4-1','부장',440,58.3);
INSERT INTO tStaff VALUES ('선덕여왕','인사과','여','2017-8-3','사원',315,45.1);

SELECT * FROM tStaff;

-------------------------------------------------
-- 4장

SELECT name, area, popu, metro, region FROM tCity;
SELECT * FROM tCity;

SELECT name AS 도시명, area AS "면적(제곱Km)", popu AS "인구(만명)" FROM tCity;

SELECT 도시명 = name, area '면적(제곱Km)', popu [인구(만명)] FROM tCity;

SELECT name, popu * 10000 AS "인구(명)" FROM tCity;

SELECT name, area, popu, popu * 10000 / area AS "인구밀도" FROM tCity;

SELECT 60 * 60 * 24 AS "하루" FROM dual;

SELECT 60 * 60 * 24;

SELECT * FROM tCity WHERE area > 1000;

SELECT name, area FROM tCity WHERE area > 1000;

SELECT * FROM tCity WHERE name = '서울'			-- 맞음
SELECT * FROM tCity WHERE name = 서울				-- 틀림
SELECT * FROM tCity WHERE name = "서울"			-- 틀림. 단, 마리아는 인정한다.

SELECT * FROM tStaff WHERE score = NULL;

SELECT * FROM tStaff WHERE score IS NULL;

SELECT * FROM tStaff WHERE score IS NOT NULL;

SELECT * FROM tCity WHERE popu >= 100 AND area >= 700;

SELECT * FROM tCity WHERE region = '경기' AND popu >= 50 OR area >= 500;
SELECT * FROM tCity WHERE region = '경기' AND (popu >= 50 OR area >= 500);

SELECT * FROM tCity WHERE region != '경기';
SELECT * FROM tCity WHERE NOT(region = '경기');

SELECT * FROM tCity WHERE region = '전라' OR metro = 'y';

SELECT * FROM tCity WHERE region != '전라' AND metro != 'y';

SELECT * FROM tCity WHERE NOT(region = '전라' OR metro = 'y');

SELECT * FROM tCity WHERE name LIKE '%천%';

SELECT * FROM tCity WHERE name NOT LIKE '%천%';

SELECT * FROM tCity WHERE name LIKE '천%';
SELECT * FROM tCity WHERE name LIKE '%천';

SELECT * FROM tCity WHERE TRIM(name) LIKE '%천';

SELECT * FROM tCity WHERE popu BETWEEN 50 AND 100;

SELECT * FROM tCity WHERE popu >= 50 AND popu <= 100;

SELECT * FROM tStaff WHERE name BETWEEN '가' AND '사';
SELECT * FROM tStaff WHERE joindate BETWEEN '20150101' AND '20180101';

SELECT * FROM tCity WHERE region IN ('경상', '전라');

SELECT * FROM tCity WHERE region = '경상' OR region = '전라';

SELECT * FROM tCity WHERE region NOT IN ('경상', '전라');

SELECT * FROM tStaff WHERE name LIKE IN ('이%', '안%');

SELECT * FROM tStaff WHERE name LIKE '이%' OR name LIKE '안%';

SELECT * FROM tCity ORDER BY popu;
SELECT * FROM tCity ORDER BY popu DESC;

SELECT region, name, area, popu FROM tCity ORDER BY region, name DESC;

SELECT * FROM tCity ORDER BY area;
SELECT * FROM tCity ORDER BY 2;

SELECT name FROM tCity ORDER BY popu;

SELECT name, popu * 10000 / area FROM tCity ORDER BY popu * 10000 / area;

SELECT * FROM tCity WHERE region = '경기' ORDER BY area;

SELECT * FROM tCity ORDER BY area WHERE region = '경기';

SELECT region FROM tCity;
SELECT DISTINCT region FROM tCity;
SELECT DISTINCT region FROM tCity ORDER BY region;

SELECT ALL depart FROM tStaff;
SELECT DISTINCT depart FROM tStaff;

SELECT name, rowid, rownum FROM tCity;

SELECT * FROM tCity WHERE rownum <= 4;

SELECT * FROM tCity ORDER BY area DESC WHERE rownum <= 4;

SELECT * FROM tCity WHERE rownum <= 4 ORDER BY area DESC;

SELECT * FROM (SELECT * FROM tCity ORDER BY area DESC) WHERE rownum <= 4;

SELECT TOP 4 * FROM tCity ORDER BY area DESC;

SELECT TOP 20 PERCENT * FROM tCity ORDER BY popu DESC;

SELECT * FROM tExam ORDER BY Score DESC;

SELECT TOP 100 * FROM tExam ORDER BY Score DESC;

SELECT TOP 1 PERCENT WITH TIES * FROM tExam ORDER BY Score DESC;

SELECT * FROM tCity ORDER BY area DESC LIMIT 4;

SELECT * FROM tCity ORDER BY area DESC LIMIT 2, 3;

SELECT * FROM tCity ORDER BY area DESC OFFSET 0 ROWS FETCH NEXT 4 ROWS ONLY;

SELECT * FROM tCity ORDER BY area DESC OFFSET 2 ROWS FETCH NEXT 3 ROWS ONLY;

SELECT * FROM tCity WHERE metro = 'n' ORDER BY area DESC OFFSET 2 ROWS FETCH NEXT 3 ROWS ONLY;

-------------------------------------------------
-- 5장

SELECT COUNT(*) FROM tStaff;

SELECT COUNT(*) AS "총 직원수" FROM tStaff;

SELECT COUNT(*) FROM tStaff WHERE salary >= 400;

SELECT COUNT(*) FROM tStaff WHERE salary >= 10000;

SELECT name FROM tStaff WHERE salary >= 400;

SELECT COUNT(name) FROM tStaff;
SELECT COUNT(depart) FROM tStaff;

SELECT COUNT(DISTINCT depart) FROM tStaff;

SELECT COUNT(score) FROM tStaff;

SELECT COUNT(*) - COUNT(score) FROM tStaff;
SELECT COUNT(*) FROM tStaff WHERE score IS NULL;

SELECT SUM(popu), AVG(popu) FROM tCity;

SELECT MIN(area), MAX(area) FROM tCity;

SELECT SUM(score), AVG(score) FROM tStaff WHERE depart = '인사과';
SELECT MIN(salary), MAX(salary) FROM tStaff WHERE depart = '영업부';

SELECT SUM(name) FROM tStaff;		-- 에러

SELECT MIN(name) FROM tStaff;

SELECT MAX(popu), name FROM tCity;

SELECT AVG(salary) FROM tStaff;
SELECT SUM(salary)/COUNT(*) FROM tStaff;

SELECT AVG(score) FROM tStaff;
SELECT SUM(score)/COUNT(*) FROM tStaff;

SELECT COUNT(*) FROM tStaff WHERE depart = '비서실';
SELECT MAX(salary) FROM tStaff WHERE depart = '비서실';

SELECT '영업부', AVG(salary) FROM tStaff WHERE depart='영업부';
SELECT '총무부', AVG(salary) FROM tStaff WHERE depart='총무부';
SELECT '인사과', AVG(salary) FROM tStaff WHERE depart='인사과';

SELECT depart, AVG(salary) FROM tStaff GROUP BY depart;

SELECT depart, COUNT(*), MAX(joindate), AVG(score) FROM tStaff GROUP BY depart; 

SELECT gender, AVG(salary) FROM tStaff GROUP BY gender;

SELECT name, SUM(salary) FROM tStaff GROUP BY name;

SELECT depart, gender, COUNT(*) FROM tStaff GROUP BY depart, gender;

SELECT gender, depart, COUNT(*) FROM tStaff GROUP BY gender, depart;

SELECT depart, gender, COUNT(*) FROM tStaff GROUP BY depart, gender 
ORDER BY depart, gender;

SELECT depart, salary FROM tStaff GROUP BY depart;

SELECT SUM(salary) FROM tStaff GROUP BY depart;

SELECT depart, SUM(salary) FROM tStaff;

SELECT depart, SUM(salary) FROM tStaff GROUP BY depart;
SELECT SUM(salary) FROM tStaff;

SELECT depart, AVG(salary) FROM tStaff GROUP BY depart HAVING AVG(salary) >= 340;

SELECT depart, AVG(salary) FROM tStaff GROUP BY depart HAVING AVG(salary) >= 340 
ORDER BY AVG(salary);

SELECT depart, AVG(salary) FROM tStaff WHERE salary > 300 GROUP BY depart ;

SELECT depart, AVG(salary) FROM tStaff WHERE salary > 300 
GROUP BY depart HAVING AVG(salary) >= 360 ORDER BY depart;

SELECT depart, MAX(salary) FROM tStaff WHERE depart IN ('인사과', '영업부') GROUP BY depart;
SELECT depart, MAX(salary) FROM tStaff GROUP BY depart HAVING depart IN ('인사과', '영업부');

-------------------------------------------------
-- 6장

INSERT INTO tCity (name, area, popu, metro, region) 
VALUES ('서울', 605, 974, 'y', '경기');

INSERT INTO tCity VALUES ('서울', 605, 974, 'y', '경기');

INSERT INTO tCity VALUES ('평택', 453, 51, 'n', '경기');

INSERT INTO tCity VALUES ('평택', 51, 453, 'n', '경기');		// area와 popu가 바뀜
INSERT INTO tCity VALUES ('평택', 453, 'n', 51, '경기');		// popu와 metro 순서가 바뀜
INSERT INTO tCity VALUES ('평택', 453, 'n', '경기');		// popu 필드값 누락

INSERT INTO tCity (area, popu, metro, region, name) 
VALUES (453, 51, 'n', '경기', '평택');

TRUNCATE TABLE tCity;

INSERT INTO tCity (name, area, popu, metro, region) VALUES 
('서울',605,974,'y','경기'), 
('부산',765,342,'y','경상'),
('오산',42,21,'n','경기'),
('청주',940,83,'n','충청'),
('전주',205,65,'n','전라'),
('순천',910,27,'n','전라'),
('춘천',1116,27,'n','강원'),
('홍천',1819,7,'n','강원');

INSERT INTO tStaff(name, depart, gender, joindate, grade, salary, score)
SELECT name, region, metro, '20210629', '신입', area, popu FROM tCity WHERE region = '경기';

INSERT INTO tStaff(name, depart, gender, joindate, grade, salary, score)
SELECT name, 지원부서, gender, 오늘, '수습', 230, score * 0.1 FROM tCandidate 
WHERE result = '합격';

CREATE TABLE tSudo AS SELECT name, area, popu FROM tCity WHERE region = '경기';
SELECT * FROM tSudo;

SELECT * INTO tCityCopy FROM tCity;

CREATE TABLE tStaff_8월20일 AS SELECT * FROM tStaff;

DELETE FROM tCity WHERE name = '부산';

DELETE FROM tCity WHERE region = '경기';

DELETE FROM tCity;

SELECT * FROM tCity WHERE popu > 50;

-- DELETE
-- SELECT *
FROM tStaff WHERE grade = '과장';

UPDATE tCity SET popu = 1000, region = '충청' WHERE name = '서울';

UPDATE tCity SET popu = 1000, region = '충청';

UPDATE tCity SET popu = popu * 2 WHERE name = '오산';

-------------------------------------------------
-- 7장

INSERT INTO tCity VALUES ('평양','엄청 넓음','꽤 많을걸','n','조선인민민주주의공화국');

INSERT INTO tCity (name, popu, metro, region) VALUES ('울산', 114, 'y', '경상');
INSERT INTO tCity (name, metro, region) VALUES ('삼척', 'n', '강원');

INSERT INTO tCity (area, popu, metro, region) VALUES (456, 123, 'n', '충청');
INSERT INTO tCity (name, area, popu) VALUES ('의정부', 456,123);

CREATE TABLE tNullable
(
    name CHAR(10) NOT NULL,
    age INT
);

CREATE TABLE tCityDefault
(
	name CHAR(10) PRIMARY KEY,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) DEFAULT 'n' NOT NULL,
	region CHAR(6) NOT NULL
);

INSERT INTO tCityDefault (name, area, popu, region) VALUES ('진주', 712, 34, '경상');
INSERT INTO tCityDefault (name, area, popu, metro, region) VALUES ('인천', 1063, 295, 'y', '경기');

INSERT INTO tCityDefault VALUES ('강릉', 1111, 22, '강원');			-- 에러
INSERT INTO tCityDefault VALUES ('강릉', 1111, 22, DEFAULT, '강원');	-- 정상 실행

UPDATE tCity_Default SET metro = DEFAULT WHERE name = '인천'

CREATE TABLE tCheckTest
(
	gender CHAR(3) NULL CHECK(gender = '남' OR gender = '여'),
	grade INT NULL CHECK (grade >= 1 AND grade <= 3),
	origin CHAR(3) NULL CHECK(origin IN ('동','서','남','북')),
	name CHAR(10) NULL CHECK(name LIKE '김%')
);

INSERT INTO tCheckTest (gender) VALUES ('여');
INSERT INTO tCheckTest (grade) VALUES (1);
INSERT INTO tCheckTest (origin) VALUES ('동');
INSERT INTO tCheckTest (name) VALUES ('김좌진');

INSERT INTO tCheckTest (gender) VALUES ('노');
INSERT INTO tCheckTest (grade) VALUES (0);
INSERT INTO tCheckTest (origin) VALUES ('중');
INSERT INTO tCheckTest (name) VALUES ('청산리');

UPDATE tCheckTest SET grade = 4 WHERE grade IS NOT NULL;

region CHAR(6) NOT NULL CHECK (region IN ('경기', '충청', '강원', '경상', '전라', '제주'))
INSERT INTO tCity3 VALUES ('울릉',72,1,'n','우산');

INSERT INTO tCity VALUES ('춘천',1116,27,'n','강원');

CREATE TABLE tCity
(
	name CHAR(10),
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL,
	CONSTRAINT PK_tCity_name PRIMARY KEY(name)
); 

CREATE TABLE tCity
(
	name CHAR(10) PRIMARY KEY,
	region CHAR(6) PRIMARY KEY,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL
);

CREATE TABLE tCityCompoKey
(
	name CHAR(10) NOT NULL,
	region CHAR(6) NOT NULL,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL,
	CONSTRAINT PK_tCity_name_region PRIMARY KEY (name, region)
);

INSERT INTO tCityCompoKey VALUES ('광주', '전라', 123, 456, 'y');
INSERT INTO tCityCompoKey VALUES ('광주', '경기', 123, 456, 'n');

CREATE TABLE tCityUnique
(
	name CHAR(10) PRIMARY KEY,
	area INT NULL ,
	popu INT UNIQUE NULL,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL
);

CREATE TABLE tCityUnique
(
	name CHAR(10) PRIMARY KEY,
	area INT NULL ,
	popu INT NULL,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL,
	CONSTRAINT Unique_tCity_area_popu UNIQUE(area, popu)
);

CREATE SEQUENCE seqSale START WITH 1 INCREMENT BY 1;

CREATE TABLE tSale
(
	saleno INT PRIMARY KEY,
	customer VARCHAR(20),
	product VARCHAR(30)
);

INSERT INTO tSale VALUES (seqSale.NEXTVAL, '단군', '지팡이');
INSERT INTO tSale VALUES (seqSale.NEXTVAL, '고주몽', '고등어');

INSERT INTO tSale VALUES (NEXT VALUE FOR seqSale, '단군', '지팡이');
INSERT INTO tSale VALUES (NEXT VALUE FOR seqSale, '고주몽', '고등어');

DELETE FROM tSale WHERE saleno = 2;

오라클 : INSERT INTO tSale VALUES (seqSale.NEXTVAL, '박혁거세', '계란');
MSSQL : INSERT INTO tSale VALUES (NEXT VALUE FOR seqSale, '박혁거세', '계란');

INSERT INTO tSale VALUES (2, '고주몽', '고등어');

CREATE TABLE tSaleSeq
(
	saleno INT GENERATED AS IDENTITY PRIMARY KEY,
	customer VARCHAR(20),
	product VARCHAR(30)
);

INSERT INTO tSaleSeq (customer, product) VALUES ('단군', '지팡이');
INSERT INTO tSaleSeq (customer, product) VALUES ('고주몽', '고등어');

saleno INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
saleno INT GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,

INSERT INTO tSale (saleno, customer, product) VALUES (5, '단군', '지팡이');	-- 가능
INSERT INTO tSale (saleno, customer, product) VALUES (NULL, '고주몽', '고등어');	-- 에러

CREATE TABLE tSaleId
(
	saleno INT IDENTITY PRIMARY KEY,
	customer VARCHAR(20),
	product VARCHAR(30)
);

INSERT INTO tSaleId (customer, product) VALUES ('단군', '지팡이');
INSERT INTO tSaleId (customer, product) VALUES ('고주몽', '고등어');

DELETE FROM tSaleId WHERE saleno = 2;
INSERT INTO tSaleId (customer, product) VALUES ('박혁거세', '계란');

INSERT INTO tSaleId (saleno, customer, product) VALUES (2, '고주몽', '고등어');

SET IDENTITY_INSERT tSaleId ON;
INSERT INTO tSaleId (saleno, customer, product) VALUES (2, '고주몽', '고등어');
SET IDENTITY_INSERT tSaleId OFF;

INSERT INTO tSaleId VALUES ('왕건', '너구리');

UPDATE tSaleId SET product = '짜파게티' WHERE saleno = @@IDENTITY;

CREATE TABLE tSale
(
	saleno INT AUTO_INCREMENT PRIMARY KEY,
	customer NCHAR(10),
	product NCHAR(30)
);

INSERT INTO tSale (customer, product) VALUES ('단군', '지팡이');
INSERT INTO tSale (customer, product) VALUES ('고주몽', '고등어');

DELETE FROM tSale WHERE saleno = 2;
INSERT INTO tSale (customer, product) VALUES ('박혁거세', '계란');

INSERT INTO tSale (saleno, customer, product) VALUES (2, '고주몽', '고등어');

ALTER TABLE tSale AUTO_INCREMENT = 100;

INSERT INTO tSale (customer, product) VALUES ('왕건', '너구리');
UPDATE tSale SET product = '짜파게티' WHERE saleno = LAST_INSERT_ID();

-------------------------------------------------
-- 8장

UPDATE tProject SET 담당자='문종민' WHERE 프로젝트='TV 광고건';

SELECT 프로젝트명 FROM tProject WHERE 담당자 = '김상형';

CREATE TABLE tEmployee
(
	name CHAR(10) PRIMARY KEY,
	salary INT NOT NULL,
	addr VARCHAR(30) NOT NULL
);

INSERT INTO tEmployee VALUES ('김상형', 650, '이천시');
INSERT INTO tEmployee VALUES ('문종민', 480, '대구시');
INSERT INTO tEmployee VALUES ('권성직', 625, '안동시');

CREATE TABLE tProject
(
	projectID INT PRIMARY KEY,
	employee CHAR(10) NOT NULL,
	project VARCHAR(30) NOT NULL,
	cost INT
);

INSERT INTO tProject VALUES (1, '김상형', '홍콩 수출건', 800);
INSERT INTO tProject VALUES (2, '김상형', 'TV 광고건', 3400);
INSERT INTO tProject VALUES (3, '김상형', '매출분석건', 200);
INSERT INTO tProject VALUES (4, '문종민', '경영 혁신안 작성', 120);
INSERT INTO tProject VALUES (5, '문종민', '대리점 계획', 85);
INSERT INTO tProject VALUES (6, '권성직', '노조 협상건', 24);

INSERT INTO tProject VALUES (7, '홍길동', '원자재 매입', 900);

DELETE FROM tEmployee WHERE name = '김상형';

CREATE TABLE tProject
(
	projectID ... ,
	employee ... ,
	project ... ,
	cost ... ,
	CONSTRAINT FK_emp FOREIGN KEY(employee) REFERENCES tEmployee(name)
);

INSERT INTO tEmployee VALUES ('홍길동', 330, '장성');
INSERT INTO tProject VALUES (7, '홍길동', '원자재 매입', 900);

DELETE FROM tProject WHERE employee = '김상형';
DELETE FROM tEmployee WHERE name = '김상형';

DROP TABLE tEmployee;

CREATE TABLE tProject
(
	....
	CONSTRAINT FK_emp FOREIGN KEY(employee) REFERENCES tEmployee(name)
	ON DELETE CASCADE
);

DELETE FROM tEmployee WHERE name = '김상형';

CREATE TABLE tProject
(
	....
	CONSTRAINT FK_emp FOREIGN KEY(employee) REFERENCES tEmployee(name)
	ON DELETE CASCADE ON UPDATE CASCADE
);

UPDATE tEmployee SET name = '문사장' WHERE Name = '문종민';

-- 회원 테이블
CREATE TABLE tMember
(
    member VARCHAR(20) PRIMARY KEY, 	-- 아이디
    age INT NOT NULL,                      	-- 나이 
    email VARCHAR(30) NOT NULL,           	-- 이메일
    addr VARCHAR(50) NOT NULL,            	-- 주소
    money INT DEFAULT 1000 NOT NULL,     	-- 예치금
    grade INT DEFAULT 1 NOT NULL,         	-- 고객등급. 1=준회원, 2=정회원, 3=우수회원
    remark VARCHAR(100) NULL             	-- 메모 사항
);

-- 회원 데이터
INSERT INTO tMember VALUES ('춘향',16,'1004@naver.com','전남 남원시',20000, 2, '');
INSERT INTO tMember VALUES ('이도령',18,'wolf@gmail.com','서울 신사동',150000, 3, '');
INSERT INTO tMember VALUES ('향단',25,'candy@daum.net','전남 남원시',5000, 2, '');
INSERT INTO tMember VALUES ('방자',28,'devlin@ssang.co.kr','서울 개포동',1000, 1, '요주의 고객');

-- 상품 분류 테이블
CREATE TABLE tCategory
(
   category VARCHAR(10) PRIMARY KEY,	-- 분류명
   discount INT NOT NULL,			-- 할인율
   delivery INT NOT NULL,                   	-- 배송비
   takeback CHAR(1)                         	-- 반품 가능성
);

-- 분류 데이터
INSERT INTO tCategory (category, discount, delivery, takeback) VALUES ('식품', 0, 3000, 'n');
INSERT INTO tCategory (category, discount, delivery, takeback) VALUES ('패션', 10, 2000, 'y');
INSERT INTO tCategory (category, discount, delivery, takeback) VALUES ('가전', 20, 2500, 'y');
INSERT INTO tCategory (category, discount, delivery, takeback) VALUES ('성인', 5, 1000, 'n');

-- 상품 테이블
CREATE TABLE tItem
(
    item VARCHAR(20) PRIMARY KEY,   	-- 상품명
    company VARCHAR(20) NULL,            	-- 제조사
    num INT NOT NULL,                      	-- 재고
    price INT NOT NULL,                     	-- 정가
    category VARCHAR(10) NOT NULL,       	-- 분류
    CONSTRAINT item_fk FOREIGN KEY(category) REFERENCES tCategory(category)
);

-- 상품 데이터
INSERT INTO tItem (item,company,num,price,category) VALUES ('노트북', '샘성', 3, 820000, '가전');
INSERT INTO tItem (item,company,num,price,category) VALUES ('청바지', '방방', 80, 32000, '패션');
INSERT INTO tItem (item,company,num,price,category) VALUES ('사과', '문경농원', 24, 16000, '식품');
INSERT INTO tItem (item,company,num,price,category) VALUES ('대추', '보은농원', 19, 15000, '식품');
INSERT INTO tItem (item,company,num,price,category) VALUES ('전자담배', 'TNG', 4, 70000, '성인');
INSERT INTO tItem (item,company,num,price,category) VALUES ('마우스', '논리텍', 3, 90000, '가전');

-- 주문 테이블
MSSQL :
CREATE TABLE tOrder
(
  orderID INT IDENTITY PRIMARY KEY,		-- 주문 번호
  member VARCHAR(20) NOT NULL,   		-- 주문자
  item VARCHAR(20) NOT NULL,			-- 상품
  orderDate DATE DEFAULT GETDATE() NOT NULL,	-- 주문 날자
  num INT NOT NULL,				-- 개수
  status INT DEFAULT 1 NOT NULL,			-- 1:주문, 2:배송중, 3:배송완료, 4:반품
  remark VARCHAR(1000) NULL			-- 메모 사항
);

오라클 :
CREATE TABLE tOrder
(
  orderID INT GENERATED AS IDENTITY PRIMARY KEY,	-- 주문 번호
  member VARCHAR(20) NOT NULL,   		-- 주문자
  item VARCHAR(20) NOT NULL,			-- 상품
  orderDate DATE DEFAULT SYSDATE NOT NULL,	-- 주문 날자
  num INT NOT NULL,				-- 개수
  status INT DEFAULT 1 NOT NULL,			-- 1:주문, 2:배송중, 3:배송완료, 4:반품
  remark VARCHAR2(1000) NULL			-- 메모 사항
);

마리아 :
CREATE TABLE tOrder
(
  orderID INT AUTO_INCREMENT PRIMARY KEY,	-- 주문 번호
  member VARCHAR(20) NOT NULL,   		-- 주문자
  item VARCHAR(20) NOT NULL,			-- 상품
  orderDate DATE DEFAULT CURDATE() NOT NULL,	-- 주문 날자
  num INT NOT NULL,				-- 개수
  status INT DEFAULT 1 NOT NULL,			-- 1:주문, 2:배송중, 3:배송완료, 4:반품
  remark VARCHAR(1000) NULL			-- 메모 사항
);

-- 주문 데이터
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('춘향','청바지','2019-12-3',3,2);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('향단','대추','2019-12-4',10,1);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('방자','전자담배','2019-12-2',4,1);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('향단','사과','2019-12-5',5,2);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('흥부','노트북','2019-12-5',2,1);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('방자','핸드폰','2019-11-1',1,3);

member VARCHAR(20) NOT NULL REFERENCES tMember(member),   	-- 주문자
item VARCHAR(20) NOT NULL REFERENCES tItem(item),			-- 상품

DROP TABLE tOrder, tItem, tCategory, tMember;

-------------------------------------------------
-- 9장

SELECT MAX(popu), name FROM tCity;

SELECT name FROM tCity WHERE popu = MAX(popu);

SELECT MAX(popu) FROM tCity;

SELECT name FROM tCity WHERE popu = 974;

SELECT name FROM tCity WHERE popu = (SELECT MAX(popu) FROM tCity);

SELECT MAX(num) FROM tItem;

SELECT item FROM tItem WHERE num = 80;

SELECT item FROM tItem WHERE num = (SELECT MAX(num) FROM tItem);

SELECT category FROM tItem WHERE item= '청바지';

SELECT delivery FROM tCategory WHERE category = '패션';

SELECT delivery FROM tCategory WHERE category = (SELECT category FROM tItem 
WHERE item = '청바지');

SELECT item FROM tItem WHERE price = 70000;

SELECT member FROM tOrder WHERE item = 
(SELECT item FROM tItem WHERE price = 70000);

SELECT age FROM tMember WHERE member = 
(SELECT member FROM tOrder WHERE item = 
(SELECT item FROM tItem WHERE price = 70000));

SELECT price FROM tItem WHERE item = 
(SELECT item FROM tOrder WHERE member = '향단');

SELECT price FROM tItem WHERE item = 
(SELECT item FROM tOrder WHERE member = '향단' 
ORDER BY item OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY);

SELECT item, price FROM tItem WHERE item IN 
(SELECT item FROM tOrder WHERE member = '향단');

SELECT item, price FROM tItem WHERE item IN ('대추', '사과');

SELECT price FROM tItem WHERE item = (SELECT item FROM tOrder WHERE member = '이도령');

SELECT depart, gender FROM tStaff WHERE name = '윤봉길';

SELECT * FROM tStaff WHERE depart = '영업부' AND gender = '남';

SELECT * FROM tStaff WHERE depart = 
(SELECT depart FROM tStaff WHERE name = '안중근')
AND gender = (SELECT gender FROM tStaff WHERE name = '안중근');

SELECT * FROM tStaff WHERE (depart, gender) = 
(SELECT depart, gender FROM tStaff WHERE name = '안중근');

SELECT * FROM tStaff WHERE (depart, salary) IN 
(SELECT depart, MAX(salary) FROM tStaff GROUP BY depart);

SELECT * FROM tStaff S WHERE salary = 
(SELECT MAX(salary) FROM tStaff WHERE depart = S.depart);

SELECT T.* FROM tStaff T
INNER JOIN (SELECT depart, MAX(salary) ms FROM tStaff GROUP BY depart) M
ON T.depart = M.depart AND T.salary = M.ms;

UPDATE tCity SET (area, popu) = (SELECT area, popu FROM tCity WHERE name='부산') 
WHERE name = '서울';

SELECT name FROM tStaff WHERE salary > ANY 
(SELECT salary FROM tStaff WHERE depart = '영업부');
SELECT name FROM tStaff WHERE salary > ALL 
(SELECT salary FROM tStaff WHERE depart = '영업부');

SELECT name FROM tStaff WHERE salary > 
(SELECT MIN(salary) FROM tStaff WHERE depart = '영업부');
SELECT name FROM tStaff WHERE salary > 
(SELECT MAX(salary) FROM tStaff WHERE depart = '영업부');

SELECT item, price FROM tItem WHERE item = ANY 
(SELECT item FROM tOrder WHERE member = '향단');

SELECT member, item, (SELECT price FROM tItem WHERE tItem.item = tOrder.item) price 
FROM tOrder;

SELECT O.member, O.item, (SELECT price FROM tItem I WHERE I.item = O.item) price 
FROM tOrder O;

SELECT O.member, O.item, I.price FROM tOrder O JOIN tItem I ON I.item = O.item; 

EXISTS (SELECT * FROM tCity WHERE area > 1000)

SELECT name FROM tCity WHERE EXISTS (SELECT * FROM tCity WHERE area > 1000);

SELECT name FROM tCity C WHERE EXISTS (SELECT * FROM tCity WHERE C.area > 1000);

SELECT * FROM tMember M WHERE EXISTS 
(SELECT * FROM tOrder O WHERE O.member = M.member);

SELECT * FROM tMember M WHERE NOT EXISTS 
(SELECT * FROM tOrder O WHERE O.member = M.member);

SELECT * FROM tMember WHERE member IN (SELECT DISTINCT member FROM tOrder);

....EXISTS (SELECT item FROM tOrder O WHERE O.member = M.member);
....EXISTS (SELECT member FROM tOrder O WHERE O.member = M.member);
....EXISTS (SELECT '얼씨구' FROM tOrder O WHERE O.member = M.member);

SELECT * FROM (SELECT * FROM tCity) A;

SELECT * FROM (SELECT name, popu, area FROM tCity) A;
SELECT * FROM (SELECT * FROM tCity WHERE metro = 'y') B;

SELECT member, addr FROM (SELECT * FROM tMember WHERE age < 19) A 
WHERE A.money >= 100000;

SELECT member, addr FROM tMember WHERE age < 19 AND money >= 100000;

SELECT * FROM (SELECT * FROM tStaff WHERE grade = '과장' OR grade = '부장') A 
WHERE A.score >= 70;

SELECT * FROM tStaff WHERE grade = '과장' OR grade = '부장' AND score >= 70;

SELECT member, addr FROM (SELECT * FROM tMember WHERE age < 19) A 
WHERE A.money >= 100000;

SELECT * FROM (SELECT * FROM tCity WHERE metro = 'y') A;

SELECT * FROM (SELECT * FROM tCity WHERE metro = 'y') AS A;

SELECT name, popu * 10000 AS ingu FROM tCity;

SELECT name, popu * 10000 AS ingu FROM tCity WHERE ingu > 1000000;

SELECT * FROM (
	SELECT name, popu * 10000 AS ingu FROM tCity
) A
WHERE A.ingu > 1000000;

SELECT * FROM (
	SELECT name, popu * 10000 AS ingu FROM tCity
)
WHERE ingu > 1000000;

SELECT name, (popu * 10000 / area) AS dens FROM tCity;

SELECT name, (popu * 10000 / area) AS dens 
	,CASE 
		WHEN (popu * 10000 / area) > 1000 THEN '고밀도'
		WHEN (popu * 10000 / area) > 100 THEN '중밀도'
		ELSE '저밀도'
	END densgrade
FROM tCity;

SELECT name, (popu * 10000 / area) AS dens 
	,CASE 
		WHEN dens > 1000 THEN '고밀도'
		WHEN dens > 100 THEN '중밀도'
		ELSE '저밀도'
	END densgrade
FROM tCity;

SELECT name, dens 
	,CASE 
		WHEN dens > 1000 THEN '고밀도'
		WHEN dens > 100 THEN '중밀도'
		ELSE '저밀도'
	END densgrade
FROM
(
	SELECT name, (popu * 10000 / area) AS dens FROM tCity
) CD;

SELECT name, dens 
	,CASE 
		WHEN dens > 1000 THEN '고밀도'
		WHEN dens > 100 THEN '중밀도'
		ELSE '저밀도'
	END densgrade
	,
    CASE
    WHEN
        CASE 
            WHEN dens > 1000 THEN '고밀도'
            WHEN dens > 100 THEN '중밀도'
            ELSE '저밀도'
        END = '고밀도' THEN '8차로'
    WHEN
        CASE 
            WHEN dens > 1000 THEN '고밀도'
            WHEN dens > 100 THEN '중밀도'
            ELSE '저밀도'
        END = '중밀도' THEN '4차로'
    ELSE '2차로' 
    END roadplan
FROM
(
	SELECT name, (popu * 10000 / area) AS dens FROM tCity
) CD;

SELECT name, dens, densgrade,
CASE
    WHEN densgrade = '고밀도' THEN '8차로'
    WHEN densgrade = '중밀도' THEN '4차로'
    ELSE '2차로' 
END roadplan
FROM
(
    SELECT name, dens 
        ,CASE 
            WHEN dens > 1000 THEN '고밀도'
            WHEN dens > 100 THEN '중밀도'
            ELSE '저밀도'
        END densgrade
    FROM
    (
        SELECT name, (popu * 10000 / area) AS dens FROM tCity
    ) CD
) CR;

SELECT * FROM tItem WHERE category = '식품' 
UNION 
SELECT * FROM tItem WHERE category = '가전';

SELECT DISTINCT depart FROM tStaff WHERE salary > 400 
UNION ALL
SELECT DISTINCT depart FROM tStaff WHERE score > 80;

SELECT * FROM tItem WHERE category = '식품' OR category = '가전';

SELECT * FROM tMember UNION SELECT * FROM tItem;

SELECT member FROM tMember 
UNION
SELECT name FROM tStaff 
UNION
SELECT name FROM tEmployee;

SELECT * FROM 부산대리점 UNION SELECT * FROM 서울대리점;

SELECT name FROM tStaff WHERE depart = '영업부'
INTERSECT 
SELECT name FROM tStaff WHERE gender = '여';

SELECT name FROM tStaff
INTERSECT
SELECT member FROM tMember;

SELECT name FROM tStaff WHERE depart = '영업부'
MINUS 
SELECT name FROM tStaff WHERE gender = '여';

SELECT name FROM tStaff WHERE gender = '여'
MINUS
SELECT name FROM tStaff WHERE depart = '영업부';

오라클, 마리아 : CREATE TABLE tStaff2 AS SELECT * FROM tStaff;
MSSQL : SELECT * INTO tStaff2 FROM tStaff;

UPDATE tStaff2 SET salary = 500 WHERE name = '안창호';
UPDATE tStaff2 SET depart = '인사과' WHERE name = '성삼문';
DELETE FROM tStaff2 WHERE name = '홍길동';
INSERT INTO tStaff2 VALUES ('어우동', '총무부', '여', '20220401', '신입', 450, 0);

SELECT * FROM tStaff2
MINUS 
SELECT * FROM tStaff;

오라클, 마리아 : CREATE TABLE tCityNew AS SELECT * FROM tCity;
MSSQL : SELECT * INTO tCityNew FROM tCity;

UPDATE tCityNew SET popu = 1000 WHERE name = '서울';
UPDATE tCityNew SET area = 900 WHERE name = '부산';
DELETE FROM tCityNew WHERE name = '춘천';
INSERT INTO tCityNew VALUES ('이천',461,21,'n','경기');

MERGE INTO tCity T USING tCityNew S ON (S.name = T.name)
WHEN MATCHED THEN
	UPDATE SET T.area = S.area, T.popu = S.popu
WHEN NOT MATCHED THEN
	INSERT VALUES (S.name, S.area, S.popu, S.metro, S.region);

MERGE INTO tCity T USING (SELECT * FROM tCityNew WHERE region = '경기') S ON (S.name = T.name)
....

MERGE INTO tCity T USING tCityNew S ON (S.name = T.name AND S.region = '경기')
....

CREATE TABLE tCityPopu
(
	name CHAR(10) PRIMARY KEY,
	popu INT NULL
);

INSERT INTO tCityPopu VALUES ('서울',1000);
INSERT INTO tCityPopu VALUES ('부산',500);
INSERT INTO tCityPopu VALUES ('춘천',100);

MERGE INTO tCity C USING tCityPopu P ON (C.name = P.name)
WHEN MATCHED THEN UPDATE SET C.popu = P.popu;

UPDATE tCity SET popu = tCityPopu.popu FROM tCityPopu WHERE tCity.name = tCityPopu.name;

UPDATE tCity SET popu = S.popu FROM tCityPopu AS S WHERE tCity.name = S.name;

UPDATE tCity AS T SET T.popu = S.popu FROM tCityPopu AS S WHERE T.name = S.name;

UPDATE tCity SET popu = (SELECT popu FROM tCityPopu P WHERE P.name = tCity.name)
WHERE name IN (SELECT name FROM tCityPopu)

-------------------------------------------------
-- 10장

CREATE TABLE tCar
(
	car VARCHAR(30) NOT NULL,		-- 이름
	capacity INT NOT NULL,			-- 배기량
	price INT NOT NULL,			-- 가격
	maker VARCHAR(30) NOT NULL		-- 제조사
);

INSERT INTO tCar (car, capacity, price, maker) VALUES ('소나타', 2000, 2500, '현대');
INSERT INTO tCar (car, capacity, price, maker) VALUES ('티볼리', 1600, 2300, '쌍용');
INSERT INTO tCar (car, capacity, price, maker) VALUES ('A8', 3000, 4800, 'Audi');
INSERT INTO tCar (car, capacity, price, maker) VALUES ('SM5', 2000, 2600, '삼성');

CREATE TABLE tMaker
(
	maker VARCHAR(30) NOT NULL,		-- 회사
	factory CHAR(10) NOT NULL,	    	-- 공장
	domestic CHAR(1) NOT NULL		-- 국산 여부. Y/N
);

INSERT INTO tMaker (maker, factory, domestic) VALUES ('현대', '부산', 'y');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('쌍용', '청주', 'y');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('Audi', '독일', 'n');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('기아', '서울', 'y');

SELECT * FROM tCar, tMaker;

SELECT * FROM tCar CROSS JOIN tMaker;

SELECT * FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT tCar.car, tCar.price, tMaker.maker, tMaker.factory FROM tCar, tMaker 
WHERE tCar.maker = tMaker.maker;

SELECT tCar.*, tMaker.factory FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT car, price, tMaker.maker, factory FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT car, price, maker, factory FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tCar C, tMaker M WHERE C.maker = M.maker;

SELECT A.car, A.price, B.maker, B.factory FROM tCar A, tMaker B WHERE A.maker = B.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tCar C INNER JOIN tMaker M 
ON C.maker = M.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tMaker M INNER JOIN tCar C 
ON M.maker = C.maker;

SELECT C.car, C.price, maker, M.factory FROM tCar C INNER JOIN tMaker M USING(maker);

SELECT C.car, C.price, M.maker, M.factory FROM tCar C LEFT OUTER JOIN tMaker M 
ON C.maker = M.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tCar C RIGHT OUTER JOIN tMaker M 
ON C.maker = M.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tMaker M LEFT OUTER JOIN tCar C 
ON C.maker = M.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tCar C FULL OUTER JOIN tMaker M 
ON C.maker = M.maker;

SELECT * FROM tCar C 
INNER JOIN tMaker M ON C.maker = M.maker 
INNER JOIN tCity T ON M.factory = T.name;

SELECT C.car, M.factory, T.area FROM tCar C 
INNER JOIN tMaker M ON C.maker = M.maker 
INNER JOIN tCity T ON M.factory = T.name;

SELECT * FROM tCar C 
LEFT OUTER JOIN tMaker M ON C.maker = M.maker 
LEFT OUTER JOIN tCity T ON M.factory = T.name;

SELECT * FROM tMaker M 
INNER JOIN tCity T ON M.factory = T.name 
INNER JOIN tCar C ON M.maker = C.maker;

SELECT * FROM tMaker M 
LEFT OUTER JOIN tCity T ON M.factory = T.name 
LEFT OUTER JOIN tCar C ON M.maker = C.maker;

SELECT maker FROM tCar WHERE car = '티볼리';
SELECT factory FROM tMaker WHERE maker = '쌍용';

SELECT factory FROM tMaker WHERE maker = 
(SELECT maker FROM tCar WHERE car = '티볼리');

SELECT * FROM tCar C INNER JOIN tMaker M ON M.maker = C.maker;

SELECT * FROM tCar C INNER JOIN tMaker M ON M.maker = C.maker AND C.car = '티볼리';

SELECT M.factory FROM tCar C INNER JOIN tMaker M 
ON M.maker = C.maker AND C.car = '티볼리';

SELECT M.factory, C.price FROM tCar C INNER JOIN tMaker M 
ON M.maker = C.maker AND C.car = '티볼리';

SELECT factory, price FROM tMaker WHERE maker = 
(SELECT maker FROM tCar WHERE car = '티볼리');

SELECT factory, (SELECT price FROM tCar WHERE car = '티볼리') AS price 
FROM tMaker WHERE maker = (SELECT maker FROM tCar WHERE car = '티볼리');

SELECT C.*, M.factory, M.domestic FROM tCar C INNER JOIN tMaker M 
ON M.maker = C.maker AND C.car = '티볼리';

INSERT INTO tCar (car, capacity, price, maker) VALUES ('티볼리', 1800, 2600, '쌍용');

SELECT C.*, M.factory, M.domestic FROM tCar C LEFT OUTER JOIN tMaker M 
ON C.maker = M.maker;

INSERT INTO tCar (car, capacity, price, maker) VALUES ('소나타', 2400, 2900, '현대');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('현대', '울산', 'y');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('현대', '마산', 'y');

SELECT * FROM tCar C INNER JOIN tMaker M ON C.maker = M.maker;

SELECT * FROM tCar C INNER JOIN tMaker M ON C.maker = M.maker WHERE C.capacity = 2000;

SELECT * FROM tCar C INNER JOIN tMaker M ON C.maker = M.maker AND C.capacity = 2000;

SELECT * FROM tCar C LEFT OUTER JOIN tMaker M ON C.maker = M.maker 
WHERE C.capacity = 2000;

SELECT * FROM tCar C LEFT OUTER JOIN tMaker M 
ON C.maker = M.maker AND C.capacity = 2000;

SELECT * FROM tCar C LEFT OUTER JOIN tMaker M 
ON C.maker = M.maker AND C.capacity = 2000 WHERE C.price > 2800 ORDER BY price DESC;

SELECT * FROM tCar WHERE capacity > 2000 C LEFT JOIN tMaker M ON C.maker = M.maker;

SELECT * FROM (SELECT * FROM tCar WHERE capacity > 2000) C 
LEFT JOIN tMaker M ON C.maker = M.maker;

SELECT * FROM tCar C LEFT JOIN tMaker M ON C.maker = M.maker WHERE C.capacity > 2000;

SELECT * FROM (SELECT * FROM tCar WHERE capacity > 2000) C LEFT JOIN 
(SELECT * FROM tMaker WHERE factory = '울산') M ON C.maker = M.maker;

SELECT * FROM (SELECT * FROM tCar WHERE capacity > 2000) C LEFT JOIN 
tMaker M ON C.maker = M.maker WHERE M.factory = '울산';

SELECT * FROM tMember, tOrder;

SELECT * FROM tMember M, tOrder O WHERE M.member = O.member;
SELECT * FROM tMember M INNER JOIN tOrder O ON M.member = O.member;

SELECT M.addr, M.member, O.item, O.num, O.orderDate FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member;

SELECT M.addr, M.member, O.item, O.num, O.orderDate FROM tMember M 
LEFT OUTER JOIN tOrder O ON M.member = O.member;

SELECT M.addr, O.member, O.item, O.num, O.orderDate FROM tMember M 
RIGHT OUTER JOIN tOrder O ON M.member = O.member;

SELECT M.addr, M.member, O.member, O.item, O.num, O.orderDate FROM tMember M 
FULL OUTER JOIN tOrder O ON M.member = O.member;

SELECT item, price FROM tItem WHERE item = 
(SELECT item FROM tOrder WHERE member='춘향');

SELECT * FROM tItem I INNER JOIN tOrder O ON O.item = I.item;

SELECT * FROM tItem I INNER JOIN tOrder O ON O.item = I.item WHERE O.member = '춘향';
SELECT * FROM tItem I INNER JOIN tOrder O ON O.item = I.item AND O.member = '춘향';

SELECT O.item, I.price FROM tItem I 
INNER JOIN tOrder O ON O.item = I.item WHERE O.member = '춘향';

SELECT O.item, I.price, O.num FROM tItem I 
INNER JOIN tOrder O ON O.item = I.item WHERE O.member = '향단';

SELECT item, price, num FROM tItem WHERE item IN 
(SELECT item FROM tOrder WHERE member='향단');

SELECT item, price, (SELECT num FROM tOrder O WHERE O.item = I.item) 
FROM tItem I WHERE item IN (SELECT item FROM tOrder WHERE member='향단');

SELECT * FROM tMember;

SELECT * FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member; 

SELECT * FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member 
INNER JOIN tItem I ON I.item = O.item;

SELECT * FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member 
INNER JOIN tItem I ON I.item = O.item
INNER JOIN tCategory C ON I.category = C.category;

SELECT M.member, O.item, O.num, O.orderDate, I.price, C.delivery FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member 
INNER JOIN tItem I ON I.item = O.item
INNER JOIN tCategory C ON I.category = C.category;

SELECT M.member, O.item, O.num, O.orderDate, I.price, C.delivery 
FROM (SELECT * FROM tMember WHERE age > 19) M 
INNER JOIN tOrder O ON M.member = O.member 
INNER JOIN tItem I ON I.item = O.item
LEFT OUTER JOIN tCategory C ON I.category = C.category AND C.category != '성인'
WHERE I.price * O.num > 100000 ORDER BY M.member;

SELECT M.member, O.item, O.num, I.price FROM tMember M 
INNER JOIN tOrder O ON M.member = O.MEMBER 
INNER JOIN tItem I ON I.item = O.item;

SELECT member, num * price AS total, item FROM
(
    SELECT M.member, O.item, O.num, I.price FROM tMember M 
    INNER JOIN tOrder O ON M.member = O.MEMBER 
    INNER JOIN tItem I ON I.item = O.item
) A;

SELECT * FROM
(
	SELECT M.member, M.addr, O.item, O.num, O.orderDate, I.price, C.delivery 
	FROM (SELECT * FROM tMember WHERE age > 19) M 
	INNER JOIN tOrder O ON M.member = O.member 
	INNER JOIN tItem I ON I.item = O.item
	LEFT OUTER JOIN tCategory C ON I.category = C.category AND C.category != '성인'
	WHERE I.price * O.num > 100000
) A
LEFT OUTER JOIN tCity T ON TRIM(T.name) = SUBSTR(A.addr, 0, 2);

MSSQL : LEFT OUTER JOIN tCity T ON T.name = SUBSTRING(A.addr, 0, 4);
마리아 : LEFT OUTER JOIN tCity T ON T.name = SUBSTRING(addr, 1, 2);

CREATE TABLE tDirectory
(
	id INT PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	parent INT NOT NULL
);

INSERT INTO tDirectory (id, Name, parent) VALUES (1, 'Root', 0);
INSERT INTO tDirectory (id, Name, parent) VALUES (2, 'Data', 1);
INSERT INTO tDirectory (id, Name, parent) VALUES (3, 'Program', 1);
INSERT INTO tDirectory (id, name, parent) VALUES (4, 'Sound', 2);
INSERT INTO tDirectory (id, name, parent) VALUES (5, 'Picture', 2);
INSERT INTO tDirectory (id, name, parent) VALUES (6, 'Game', 3);
INSERT INTO tDirectory (id, name, parent) VALUES (7, 'StartCraft', 6);

SELECT A.name 부모, B.name 자식 FROM tDirectory A 
INNER JOIN tDirectory B ON A.id = B.parent;

SELECT A.name 부모, A.id, B.name, B.parent 자식 FROM tDirectory A CROSS JOIN tDirectory B;

SELECT * FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT * FROM tCar INNER JOIN tMaker ON tCar.maker = tMaker.maker;

SELECT * FROM tCar LEFT OUTER JOIN tMaker ON tCar.maker = tMaker.maker;

SELECT * FROM tCar, tMaker WHERE tCar.maker = tMaker.maker(+);
SELECT * FROM tCar, tMaker WHERE tCar.maker(+) = tMaker.maker;

SELECT * FROM tCar, tMaker WHERE tCar.maker *= tMaker.maker;

-------------------------------------------------
-- 11장

SELECT AVG(score) FROM tStaff WHERE depart = '영업부';

SELECT ROUND(AVG(score), 2) FROM tStaff WHERE depart = '영업부';

SELECT name, REPLACE(depart, '부', '팀') FROM tStaff;

SELECT name, grade, salary FROM tStaff WHERE depart='인사과';

SELECT TRIM(name) || ' ' || grade, salary FROM tStaff WHERE depart='인사과';

MSSQL : SELECT TRIM(name) + ' ' + grade, salary FROM tStaff WHERE depart='인사과';
마리아 : SELECT CONCAT(name, ' ', grade), salary FROM tStaff WHERE depart='인사과';

SELECT ROUND(1234.5678, 0) FROM dual;	-- 1235
SELECT ROUND(1234.5678, 1) FROM dual;	-- 1234.6
SELECT ROUND(1234.5678, 2) FROM dual; 	-- 1234.57

SELECT name, area, ROUND(area, -2) FROM tCity;

SELECT LENGTH('korea대한민국') FROM dual;		-- 9
SELECT LENGTHB('korea대한민국') FROM dual;		-- 17

SELECT * FROM tItem WHERE LENGTH(item) = 2;

SELECT CONCAT(region, name) FROM tCity;

오라클 : SELECT region || name FROM tCity;
MSSQL : SELECT region + name FROM tCity;

SELECT region || '도의 ' || name FROM tCity;

SELECT CONCAT(CONCAT(region, '도의 '), name) FROM tCity;
MSSQL, 마리아 : SELECT CONCAT(region, '도의 ' , name) FROM tCity;

SELECT INSTR('우리나라 대한민국', '나라') FROM dual;      -- 3
SELECT INSTR('우리나라 대한민국', '민족') FROM dual;      -- 0

SELECT INSTR('국민에 의한 국민을 위한 국민의 국민당', '국민', 3) FROM dual;     -- 8
SELECT INSTR('국민에 의한 국민을 위한 국민의 국민당', '국민', 1, 3) FROM dual;  -- 15
SELECT INSTR('국민에 의한 국민을 위한 국민의 국민당', '국민', -1) FROM dual;    -- 19

MSSQL : SELECT CHARINDEX('국민', '국민에 의한 국민을 위한 국민의 국민당', 3);     -- 8
마리아 : SELECT POSITION('국민' IN '국민에 의한 국민을 위한 국민의 국민당');     -- 1

SELECT SUBSTR('아름다운 대한민국 금수강산', 6, 4) FROM dual;    -- 대한민국
SELECT SUBSTR('아름다운 대한민국 금수강산', -4, 2) FROM dual;   -- 금수

SELECT SUBSTR(name,1,1), COUNT(*) FROM tStaff GROUP BY SUBSTR(name,1,1) 
ORDER BY COUNT(*) DESC;

SELECT SUBSTR('...이름:홍길동,...', INSTR('...이름:홍길동,...','이름') + 3, 3) FROM dual;

SELECT LOWER('wonderful SQL') FROM dual; -- wonderful sql
SELECT UPPER('wonderful SQL') FROM dual; -- WONDERFUL SQL
SELECT INITCAP('wonderful SQL') FROM dual; -- Wonderful Sql

SELECT * FROM tCity WHERE metro = 'y';

SELECT * FROM tCity WHERE UPPER(metro) = 'Y';
SELECT * FROM tCity WHERE LOWER(metro) = 'y';

SELECT CONCAT(name, ' 사원님') FROM tStaff;

SELECT CONCAT(TRIM(name), ' 사원님') FROM tStaff;

SELECT LPAD('SQL', 10, '>') FROM dual;  -- >>>>>>>SQL
SELECT RPAD('SQL', 10, '<') FROM dual;  -- SQL<<<<<<<

SELECT LPAD(RPAD('SQL', 10, '<'), 17, '>') FROM dual;	-- >>>>>>>SQL<<<<<<<

SELECT name, LPAD(area, 4, '0') FROM tCity;

SELECT REPLACE('독도는 일본땅이다', '일본', '한국') FROM dual;

SELECT REPLACE('구글에서 구글링한다.', '구글', '네이버') FROM dual; 	
-- 네이버에서 네이버링한다.

SELECT REPLACE('Get_Total_Score', '_', '') FROM dual;   -- GetTotalScore

SELECT REPLACE('독도는 일본땅이다. 대마도는 일본땅이다.', '일본', '한국') FROM dual;

SELECT STUFF('독도는 일본땅이다. 대마도는 일본땅이다.', 5, 2, '한국');

SELECT SUBSTR('독도는 일본땅이다. 대마도는 일본땅이다.', 1, 
INSTR('독도는 일본땅이다. 대마도는 일본땅이다.', '일본') - 1) || '한국' ||
SUBSTR('독도는 일본땅이다. 대마도는 일본땅이다.', 
INSTR('독도는 일본땅이다. 대마도는 일본땅이다.', '일본') + 2) FROM dual;

SELECT SUBSTR(str, 1 , INSTR(str, '일본') - 1) || '한국' || SUBSTR(str, INSTR(str, '일본') + 2) 
FROM tTable;

pos = INSTR(str, '일본');
SELECT SUBSTR(str, 1 , pos - 1) || '한국' || SUBSTR(str, pos + 2) FROM tTable;

INSERT INTO tDate VALUES (TO_DATE('2021/12/25 12:34:56', 'yyyy/mm/dd hh24:mi:ss'));

SELECT AVG(popu) FROM tCity;

오라클 : SELECT CAST(AVG(popu) AS INT) FROM tCity;		-- 193
MSSQL : SELECT AVG(CAST(popu AS DECIMAL)) FROM tCity;	-- 193.25

SELECT '12' + 34 FROM dual;	-- 46
SELECT '12' || 34 FROM dual;	-- 1234

SELECT '12' + 34;					-- 46
SELECT '12' + CAST(34 AS VARCHAR(10));	-- 1234

SELECT '응답하라 ' + 1989;				-- 에러
SELECT '응답하라 ' + CAST(1989 AS VARCHAR(10));	-- 응답하라 1989

SELECT '응답하라 ' || 1989 FROM dual;

SELECT TO_CHAR(12345) FROM dual;		-- 12345
SELECT TO_CHAR(12345, '999,999') FROM dual;	--  12,345
SELECT TO_CHAR(12345, 'FM999,999') FROM dual; 	-- 12,345
SELECT TO_CHAR(12345, '000,999') FROM dual; 	-- 012,345

SELECT TO_NUMBER('12345') FROM dual;		-- 12345
SELECT TO_NUMBER('12,345') FROM dual;		-- 에러
SELECT TO_NUMBER('12,345', '999,999') FROM dual;	-- 12345

SELECT '응답하라 ' + CONVERT(VARCHAR(10), 1989);		-- 응답하라 1989

오라클 : SELECT name, NVL(score, 10) FROM tStaff;
MSSQL : SELECT name, ISNULL(score, 10) FROM tStaff;
마리아 : SELECT name, IFNULL(score, 10) FROM tStaff;

SELECT name, NULLIF(score, 0) FROM tStaff;

SELECT name, NVL(NULLIF(score, 0), 60) FROM tStaff;

SELECT name, NVL2(score, salary * score / 100, 50) FROM tStaff;

SELECT name, DECODE(gender, '남', '멋쟁이', '여', '예쁜이', '몬난이') FROM tStaff;

SELECT SYSDATE FROM dual;  -- 20/10/17 12:21:42

INSERT INTO tStaff VALUES ('김한슬', '기획실', '여', SYSDATE, '수습', 480, 50);

SELECT SYSDATE + 12 FROM dual;

SELECT SYSDATE + 5/24 FROM dual;
SELECT SYSDATE - 30/1440 FROM dual;
SELECT SYSDATE - 80/86400 FROM dual;

SELECT name, sysdate - joindate FROM tStaff;

SELECT TO_CHAR(SYSDATE, 'yyyy/mm/dd hh24:mi:ss') FROM dual;	  -- 2020/10/17 12:18:51
SELECT TO_CHAR(SYSDATE, 'yyyy/mm/dd AM hh:mi:ss') FROM dual; -- 2020/10/17 오후 12:20:35

SELECT TO_CHAR(SYSDATE, 'yyyy"년" mm"월" dd"일" hh24"시" mi"분" ss"초"') FROM dual;
-- 2020년 10월 17일 12시 24분 44초

SELECT name, TO_CHAR(joindate, 'yyyy') FROM tStaff;

SELECT TO_CHAR(joindate, 'yyyy') AS 년, TO_CHAR(joindate, 'mm') AS 월, 
TO_CHAR(joindate, 'dd') AS 일 FROM tStaff;

SELECT TO_DATE('1919/3/1', 'yyyy/mm/dd') FROM dual;

SELECT TO_DATE('1919-3-1', 'yyyy-mm-dd') FROM dual;
SELECT TO_DATE('19190301', 'yyyymmdd') FROM dual;

SELECT TO_DATE('1919/3/1') FROM dual;
SELECT TO_DATE('1919-3-1') FROM dual;
SELECT TO_DATE('19190301') FROM dual;

SELECT sysdate - '1919/3/1' FROM dual;	-- 에러

SELECT sysdate - TO_DATE('1919/3/1') FROM dual;

SELECT TO_CHAR(TO_DATE('2023/3/8', 'yyyy/mm/dd') + 99, 'yyyy"년" mm"월" dd"일"') FROM dual;

SELECT GETDATE();

SELECT name, YEAR(joindate) AS 년, MONTH(joindate) AS 월, DAY(joindate) AS 일 FROM tStaff;

SELECT YEAR(joindate), count(*) FROM tStaff GROUP BY YEAR(joindate) 
ORDER BY YEAR(joindate);

SELECT DATEPART(dw, GETDATE());
SELECT DATENAME(dw, GETDATE());

SELECT name, DATEDIFF(day,joindate,GETDATE()) FROM tStaff;

SELECT DATEDIFF(day, '1919/3/1', GETDATE());

SELECT CONVERT(VARCHAR(20), GETDATE(),0);		-- 06 29 2021 10:43PM
SELECT CONVERT(VARCHAR(20), GETDATE(),11);		-- 21/06/29
SELECT CONVERT(VARCHAR(20), GETDATE(),111); 		-- 2021/06/29
SELECT CONVERT(VARCHAR(20), GETDATE(),101); 		-- 06/29/2021
SELECT CONVERT(VARCHAR(20), GETDATE(),103); 		-- 29/06/2021

SELECT NOW();

SELECT DATE_FORMAT(NOW(), '%Y/%m/%d %H:%i:%s');

SELECT DATE_FORMAT(joindate, '%Y'), count(*) FROM tStaff 
GROUP BY DATE_FORMAT(joindate, '%Y') ORDER BY DATE_FORMAT(joindate, '%Y');

SELECT DATE_ADD(NOW(), INTERVAL 12 DAY);		-- 12일 후
SELECT DATE_ADD(NOW(), INTERVAL 5 HOUR);		-- 5시간 후
SELECT DATE_SUB(NOW(), INTERVAL 30 MINUTE);		-- 30분 전

SELECT name, DATEDIFF(NOW(), joindate) FROM tStaff;

-------------------------------------------------
-- 12장

SELECT member, age, addr FROM tMember;

CREATE VIEW vMember AS
SELECT member, age, addr FROM tMember;

SELECT * FROM vMember;

SELECT member, age FROM vMember;
SELECT * FROM vMember WHERE addr LIKE '%서울%';
SELECT * FROM vMember ORDER BY member;

SELECT name, email FROM vMember;

DROP VIEW vMember;

CREATE VIEW vMember AS SELECT member, age, addr, email FROM tMember;

오라클, 마리아 : CREATE OR REPLACE VIEW vMember AS SELECT member, age, addr, email FROM tMember;
MSSQL : ALTER VIEW vMember AS SELECT member, age, addr, email FROM tMember;

CREATE VIEW vMemberMirror AS SELECT * FROM tMember;

CREATE VIEW vStaffVirt AS SELECT depart, salary, name FROM tStaff;

CREATE VIEW vStaffHorz AS SELECT * FROM tStaff WHERE depart = '총무부';

CREATE VIEW vStaffPart AS SELECT name, salary FROM tStaff WHERE depart = '총무부';

CREATE VIEW vStaffAlias(n, d, s) AS SELECT name, depart, salary FROM tStaff;

CREATE OR REPLACE VIEW vStaffAlias AS SELECT name n, depart d , salary s FROM tStaff;

SELECT * FROM vStaffAlias ORDER BY s;           -- 맞음
SELECT * FROM vStaffAlias ORDER BY salary;      -- 에러

CREATE VIEW vStaffBonus AS SELECT name, salary * score / 100 AS bonus FROM tStaff;

SELECT * FROM vStaffBonus WHERE bonus > 300;

CREATE VIEW vShopping AS
SELECT M.member, M.addr, O.item, O.num, O.orderDate FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member;

CREATE VIEW vUnion AS
SELECT name, salary FROM tStaff WHERE depart = '인사과'
UNION
SELECT name, salary FROM tEmployee;

CREATE VIEW vvStaffHorz AS
SELECT name, joindate, salary FROM vStaffHorz;

CREATE VIEW vOriginal AS SELECT a, b, c FROM tOriginal;

CREATE VIEW vOriginal(a, b, c) AS SELECT x, y, c FROM tOriginal;

UPDATE vMember SET addr = '서울 신사동' WHERE member = '춘향';

UPDATE vStaffBonus SET bonus = 500 WHERE name = '유관순';

INSERT INTO vStaffHorz VALUES ('김한슬', '총무부', '여', '2022/08/14', '사원', 520, 55);

INSERT INTO vStaffHorz VALUES ('김한결', '영업부', '남', '2023/05/13', '사원', 490, 35);

CREATE VIEW vStaffHorzCheck AS 
SELECT * FROM tStaff WHERE depart = '총무부' WITH CHECK OPTION;

DELETE FROM tStaff WHERE name IN ('김한슬','김한결');
INSERT INTO vStaffHorzCheck VALUES ('김한결', '영업부', '남', '2023/05/13', '사원', 490, 35);

UPDATE vStaffHorzCheck SET depart = '기획팀' WHERE name = '김유신';

INSERT INTO vStaffVirt (name, depart, salary) VALUES ('이완용', '영업부', 99);

CREATE VIEW vNotExist AS SELECT * FROM tNotExist;		-- 에러
CREATE FORCE VIEW vNotExist AS SELECT * FROM tNotExist;	-- 가능

CREATE VIEW vStaffReadOnly AS SELECT * FROM tStaff 
WHERE depart = '인사과' WITH READ ONLY;

CREATE VIEW vMemberEnc WITH ENCRYPTION AS
SELECT member, age, addr FROM tMember;

CREATE GLOBAL TEMPORARY TABLE tGtt (
	name VARCHAR(20) PRIMARY KEY,
	score INT
);

INSERT INTO tGtt VALUES ('김한슬', 95);
INSERT INTO tGtt VALUES ('김한결', 80);
SELECT * FROM tGtt;

DROP TABLE tGtt;
CREATE GLOBAL TEMPORARY TABLE tGtt (
	name VARCHAR(20) PRIMARY KEY,
	score INT
) ON COMMIT PRESERVE ROWS;

INSERT INTO tGtt VALUES ('김규민', 70);
SELECT * FROM tGtt;

CREATE TABLE #tTemp (
	name VARCHAR(20) PRIMARY KEY,
	score INT
);

INSERT INTO #tTemp VALUES ('김한슬', 95);
INSERT INTO #tTemp VALUES ('김한결', 80);
INSERT INTO #tTemp VALUES ('김규민', 70);
SELECT * FROM #tTemp;

CREATE TEMPORARY TABLE tTemp (
	name VARCHAR(20) PRIMARY KEY,
	score INT
);

INSERT INTO tTemp VALUES ('김한슬', 95);
INSERT INTO tTemp VALUES ('김한결', 80);
INSERT INTO tTemp VALUES ('김규민', 70);
SELECT * FROM tTemp;

CREATE GLOBAL TEMPORARY TABLE tTaskForce AS SELECT * FROM tStaff;

INSERT INTO tTaskForce SELECT * FROM (SELECT * FROM tStaff 
WHERE joindate <= '20160101' ORDER BY salary DESC) WHERE rownum <= 10;

MSSQL : SELECT TOP 10 * INTO #tTaskForce FROM tStaff 
WHERE joindate <= '20160101' ORDER BY salary DESC;
마리아 : CREATE TEMPORARY TABLE tTaskForce AS SELECT * FROM tStaff 
WHERE joindate <= '20160101' ORDER BY salary DESC LIMIT 10;

DELETE FROM tTaskForce WHERE score < (SELECT AVG(score) FROM tTaskForce 
WHERE gender = '남') AND gender = '남';

DELETE FROM tTaskForce WHERE salary < 
(SELECT AVG(salary) FROM tStaff) AND gender = '여';

DELETE FROM tTaskForce WHERE salary > 300 AND grade = '대리';
INSERT INTO tTaskForce SELECT * FROM tStaff WHERE salary > 380 AND grade = '과장';

SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '남';

SELECT * FROM 
(
	SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '남'
) A
WHERE salary >= (
	SELECT avg(salary) FROM 
	(
		SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '남'
	) B
);

CREATE GLOBAL TEMPORARY TABLE tBusiMan AS SELECT name, salary, score FROM tStaff;
INSERT INTO tBusiMan SELECT name, salary, score FROM tStaff 
WHERE depart = '영업부' AND gender = '남';

MSSQL: SELECT name, salary, score INTO #tBusiMan FROM tStaff 
WHERE depart = '영업부' AND gender = '남';
마리아 : CREATE TEMPORARY TABLE tBusiMan AS 
SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '남';

SELECT * FROM tBusiMan WHERE salary >= (SELECT avg(salary) FROM tBusiMan);

CREATE VIEW vBusiMan AS SELECT name, salary, score FROM tStaff 
WHERE depart = '영업부' AND gender = '남';
SELECT * FROM vBusiMan WHERE salary >= (SELECT avg(salary) FROM vBusiMan);

WITH tBusiMan AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '남')
SELECT * FROM tBusiMan WHERE salary >= (SELECT avg(salary) FROM tBusiMan);

WITH tBusiMan(이름, 월급, 성취도) AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '남')
SELECT * FROM tBusiMan WHERE 월급 >= (SELECT avg(월급) FROM tBusiMan);

WITH tBusiMan AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '남'),
tBusiGirl AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '여')
SELECT * FROM tBusiGirl WHERE salary >= (SELECT avg(salary) FROM tBusiMan);

WITH tBusiMan AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '영업부' AND gender = '남'),
tBusiManGod AS 
(SELECT name, salary, score FROM tBusiMan WHERE score > 70)
SELECT * FROM tBusiManGod;

WITH Shopping AS
(SELECT M.member, M.addr, O.item, O.num, O.orderDate FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member)
SELECT * FROM Shopping WHERE num >= (SELECT AVG(num) FROM Shopping);

CREATE VIEW vTemp AS
(SELECT M.member, M.addr, O.item, O.num, O.orderDate FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member);

SELECT * FROM vTemp WHERE num >= (SELECT AVG(num) FROM vTemp);

WITH tFact(num, sum) AS (
	SELECT 1 AS num, 1 AS sum FROM dual
	UNION ALL
	SELECT num + 1, sum * (num + 1) FROM tFact T WHERE T.num < 10
)
SELECT * FROM tFact;

WITH tTree(id, name, parent, depth) AS
(
	SELECT id, name, parent, 0 FROM tDirectory WHERE parent = 0
	UNION ALL
	SELECT D.id, D.name, D.parent, T.depth + 1 FROM tDirectory D 
	INNER JOIN tTree T ON D.parent = T.id
)
SELECT * FROM tTree;

WITH tTree(id, name, parent, depth, fullpath) AS
(
	SELECT id, name, parent, 0, CAST(name AS VARCHAR(256)) 
	FROM tDirectory WHERE parent = 0
	UNION ALL
	SELECT D.id, D.name, D.parent, T.depth + 1, 
	CAST(CONCAT(CONCAT(T.fullpath, '/'), D.name) AS VARCHAR(256)) 
	FROM tDirectory D 
	INNER JOIN tTree T ON D.parent = T.id
)
SELECT * FROM tTree;

WITH tTree(id, name, parent, depth, fullpath) AS
(
	SELECT id, name, parent, 0, CAST(name AS VARCHAR(256)) 
	FROM tDirectory WHERE parent = 0
	UNION ALL
	SELECT D.id, D.name, D.parent, T.depth + 1, 
	LPAD('L ', (T.depth + 1) * 4) || D.name 
	FROM tDirectory D 
	INNER JOIN tTree T ON D.parent = T.id
)
SELECT fullpath FROM tTree;

CAST(SPACE((T.depth + 1) * 4) + 'L ' + D.name AS VARCHAR(256))

-------------------------------------------------
-- 13장

CREATE TABLE tMonthSale
(
	year INT,
	month INT,
	sales	INT
);

INSERT INTO tMonthSale VALUES(2021, 9, 3650);
INSERT INTO tMonthSale VALUES(2021, 10, 4120);
INSERT INTO tMonthSale VALUES(2021, 11, 5000);
INSERT INTO tMonthSale VALUES(2021, 12, 4420);
INSERT INTO tMonthSale VALUES(2022, 1, 3800);
INSERT INTO tMonthSale VALUES(2022, 2, 4200);
INSERT INTO tMonthSale VALUES(2022, 3, 4150);

SELECT gender, SUM(salary) FROM tStaff GROUP BY gender;
SELECT depart, SUM(salary) FROM tStaff GROUP BY depart;
SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY depart, gender;

SELECT depart, SUM(salary) FROM tStaff GROUP BY ROLLUP(depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY ROLLUP(depart, gender);

SELECT gender, depart, SUM(salary) FROM tStaff GROUP BY ROLLUP(gender, depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY depart, ROLLUP(gender);
SELECT gender, depart, SUM(salary) FROM tStaff GROUP BY gender, ROLLUP(depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY CUBE(depart, gender);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY ROLLUP(depart, gender)
UNION
SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY ROLLUP(gender, depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY CUBE(gender, depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY GROUPING SETS(depart, gender);

SELECT GROUPING(depart), depart, SUM(salary) FROM tStaff GROUP BY ROLLUP(depart);

SELECT CASE GROUPING(depart) WHEN 1 THEN '전체부서' ELSE depart END AS depart, 
SUM(salary) FROM tStaff GROUP BY ROLLUP(depart);

SELECT CASE GROUPING(depart) WHEN 1 THEN '전체부서' ELSE depart END AS depart,
	CASE GROUPING(gender) WHEN 1 THEN '전체성별' ELSE gender END AS gender, 
	SUM(salary) FROM tStaff GROUP BY CUBE(depart, gender)
	ORDER BY /*GROUPING(depart), GROUPING(gender),*/ depart, gender;

SELECT name, depart, salary, SUM(salary) FROM tStaff;

SELECT depart, SUM(salary) FROM tStaff GROUP BY depart;

SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff) AS 월급총합 FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER() AS 월급총합 FROM tStaff;

SELECT name, depart, salary, ROUND(salary * 100.0 / SUM(salary) OVER(), 2) 
AS 월급비율 FROM tStaff;

SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff GROUP BY depart) 
AS 부서월급총합 FROM tStaff;

SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff WHERE depart = A.depart) 
AS 부서월급총합 FROM tStaff A ORDER BY depart;

SELECT name, depart, salary, SUM(salary) OVER(PARTITION BY depart) 
AS 부서월급총합 FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY name) 
AS 누적월급 FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(PARTITION BY depart ORDER BY name) 
AS 부서누적월급 FROM tStaff;

SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff 
WHERE name <= A.name) AS 누적월급 FROM tStaff A ORDER BY name;
SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff 
WHERE name <= A.name AND depart = A.depart) AS 부서누적월급 
FROM tStaff A ORDER BY depart, name;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY name 
ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) AS 누적월급 FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY name 
ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) AS 누적월급 FROM tStaff;

SELECT name, depart, joindate, salary, 
SUM(salary) OVER(PARTITION BY depart ORDER BY joindate 
ROWS BETWEEN CURRENT ROW AND 2 FOLLOWING) AS 누적월급 FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY salary 
ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS 누적월급 FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY salary 
RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS 누적월급 FROM tStaff;

SELECT RANK() OVER (ORDER BY salary DESC), tStaff.* FROM tStaff;
MSSQL, 마리아 : SELECT RANK() OVER (ORDER BY salary DESC), * FROM tStaff;

SELECT RANK() OVER (ORDER BY salary DESC), tStaff.* FROM tStaff ORDER BY score;

SELECT RANK() OVER (ORDER BY salary DESC) AS 순위, tStaff.* FROM tStaff 
WHERE depart = '영업부';

SELECT RANK() OVER (PARTITION BY depart ORDER BY salary DESC) 
AS 순위, tStaff.* FROM tStaff;

SELECT DENSE_RANK() OVER (ORDER BY salary DESC), tStaff.* FROM tStaff;

SELECT ROW_NUMBER() OVER (ORDER BY name), tStaff.* FROM tStaff;

SELECT ROW_NUMBER() OVER (ORDER BY rownum) AS 순서, tStaff.* FROM tStaff;

SELECT ROW_NUMBER() OVER (ORDER BY name) AS 순서, tStaff.* FROM tStaff
ORDER BY 순서 OFFSET 2 * 5 ROWS FETCH NEXT 5 ROWS ONLY;

SELECT * FROM
(SELECT ROW_NUMBER() OVER (ORDER BY name) AS 순서, tStaff.* FROM tStaff) S
WHERE S.순서 > 2 * 5 AND rownum <= 5;

SELECT TOP(5) * FROM
(SELECT ROW_NUMBER() OVER (ORDER BY name) AS 순서, tStaff.* FROM tStaff) S
WHERE S.순서 > 2 * 5;

SELECT ROW_NUMBER() OVER (ORDER BY name) AS 순서, tStaff.* FROM tStaff LIMIT 11, 5;

SELECT NTILE(4) OVER (ORDER BY salary DESC) AS 구간, name, salary FROM tStaff;
SELECT NTILE(4) OVER (PARTITION BY gender ORDER BY salary DESC) 
AS 구간, name, gender, salary FROM tStaff;

SELECT name, score FROM 
(SELECT NTILE(5) OVER (ORDER BY score DESC) AS 구간, tStaff.* FROM tStaff) S 
WHERE S.구간 = 3;

SELECT year, month, sales,
	LAG(sales) OVER (ORDER BY year, month) AS priorMonth,
	LEAD(sales) OVER (ORDER BY year, month) AS nextMonth
FROM tMonthSale;

SELECT year, month, sales,
	sales - LAG(sales) OVER (ORDER BY year, month) AS incsales
FROM tMonthSale;

SELECT year, month, sales,
	LAG(sales) OVER (PARTITION BY year ORDER by year, month) AS priorMonth,
	LEAD(sales) OVER (PARTITION BY year ORDER by year, month) AS nextMonth
FROM tMonthSale;

SELECT year, month, sales,
	ROUND(CUME_DIST() OVER (ORDER BY year, month) * 100, 2) AS cume,
	ROUND(PERCENT_RANK() OVER (ORDER BY year, month) * 100, 2) AS rank
FROM tMonthSale;

SELECT name, salary,
	ROUND(CUME_DIST() OVER (ORDER BY salary) * 100, 2) AS cume,
	ROUND(PERCENT_RANK() OVER (ORDER BY salary) * 100, 2) AS rank
FROM tStaff;

SELECT depart, name, salary,
	ROUND(CUME_DIST() OVER (PARTITION BY depart ORDER BY salary) * 100, 2) AS cume,
	ROUND(PERCENT_RANK() OVER (PARTITION BY depart ORDER BY salary) * 100, 2) AS rank
FROM tStaff;

SELECT name, salary,
	FIRST_VALUE(salary) OVER (ORDER BY salary) AS first,
	LAST_VALUE(salary) OVER (ORDER BY salary) AS midlast,
	LAST_VALUE(salary) OVER (ORDER BY salary ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS last
FROM tStaff;

SELECT name, salary,
	salary - FIRST_VALUE(salary) OVER (ORDER BY salary) AS 최저월급기준,
	LAST_VALUE(salary) OVER (ORDER BY salary ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) - salary AS 최고월급기준
FROM tStaff ORDER BY name;

SELECT depart, name, salary,
	salary - FIRST_VALUE(salary) OVER (PARTITION BY depart ORDER BY salary) AS 최저월급기준,
	LAST_VALUE(salary) OVER (PARTITION BY depart ORDER BY salary ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) - salary AS 최고월급기준
FROM tStaff ORDER BY depart, salary;

SELECT year, month, sales,	
PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY sales) 
OVER (PARTITION BY year) AS cont,	
PERCENTILE_DISC(0.5) WITHIN GROUP (ORDER BY sales) 
OVER (PARTITION BY year) AS disc
FROM tMonthSale;

CREATE TABLE tSeason
(
	item VARCHAR(10),
	season VARCHAR(10),
	sale INT
);

INSERT INTO tSeason VALUES ('냉면', '봄', 20);
INSERT INTO tSeason VALUES ('냉면', '여름', 50);
INSERT INTO tSeason VALUES ('냉면', '가을', 30);
INSERT INTO tSeason VALUES ('냉면', '겨울', 10);
INSERT INTO tSeason VALUES ('짬뽕', '봄', 30);
INSERT INTO tSeason VALUES ('짬뽕', '여름', 10);
INSERT INTO tSeason VALUES ('짬뽕', '가을', 20);
INSERT INTO tSeason VALUES ('짬뽕', '겨울', 40);

SELECT * FROM tSeason
PIVOT (MAX(sale) FOR season IN ('봄', '여름', '가을', '겨울'));

SELECT * FROM tSeason
PIVOT (MAX(sale) FOR season IN ('여름', '봄', '가을'));

SELECT * FROM tSeason
PIVOT (MAX(sale) FOR item IN ('냉면', '짬뽕'))

SELECT * FROM tSeason
PIVOT (sale FOR season IN ('봄', '여름', '가을', '겨울')) pvt;

SELECT * FROM tSeason
PIVOT (SUM(sale) FOR season IN ('봄', '여름', '가을', '겨울')) pvt;

INSERT INTO tSeason2 VALUES ('냉면', '봄', 20);
INSERT INTO tSeason2 VALUES ('냉면', '여름', 50);
INSERT INTO tSeason2 VALUES ('냉면', '가을', 30);
INSERT INTO tSeason2 VALUES ('짬뽕', '봄', 30);
INSERT INTO tSeason2 VALUES ('짬뽕', '가을', 20);
INSERT INTO tSeason2 VALUES ('짬뽕', '겨울', 40);
INSERT INTO tSeason2 VALUES ('짬뽕', '겨울', 30);

SELECT * FROM tSeason2 PIVOT (MAX(sale) FOR season IN ('봄', '여름', '가을', '겨울')) pvt;
SELECT * FROM tSeason2 PIVOT (SUM(sale) FOR season IN ('봄', '여름', '가을', '겨울')) pvt;

CREATE TABLE tTraffic
(
	line VARCHAR(10),
	hour INT,
	car VARCHAR(20),
	traffic INT
);

INSERT INTO tTraffic VALUES ('경부', 1, '승용차', 40);
INSERT INTO tTraffic VALUES ('경부', 2, '승용차', 41);
INSERT INTO tTraffic VALUES ('경부', 3, '승용차', 42);
INSERT INTO tTraffic VALUES ('경부', 1, '트럭', 30);
INSERT INTO tTraffic VALUES ('경부', 3, '트럭', 32);
INSERT INTO tTraffic VALUES ('호남', 1, '승용차', 20);
INSERT INTO tTraffic VALUES ('호남', 2, '승용차', 10);
INSERT INTO tTraffic VALUES ('호남', 2, '승용차', 11);
INSERT INTO tTraffic VALUES ('호남', 3, '승용차', 22);
INSERT INTO tTraffic VALUES ('호남', 1, '트럭', 10);
INSERT INTO tTraffic VALUES ('호남', 2, '트럭', 11);
INSERT INTO tTraffic VALUES ('호남', 3, '트럭', 12);

SELECT * FROM tTraffic PIVOT (SUM(traffic) FOR line IN ('경부', '호남')) pvt;
SELECT * FROM tTraffic PIVOT (SUM(traffic) FOR hour IN ('1', '2', '3')) pvt;

SELECT line, car, traffic FROM tTraffic 
PIVOT (SUM(traffic) FOR car IN ('승용차', '트럭')) pvt;

SELECT * FROM
(
	SELECT line, car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('승용차', '트럭')) pvt;

SELECT line, SUM(승용차), SUM(트럭) FROM tTraffic
PIVOT (SUM(traffic) FOR car IN ('승용차' AS 승용차, '트럭' AS 트럭)) pvt
GROUP BY line;

SELECT * FROM
(
	SELECT hour, car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('승용차', '트럭')) pvt;

SELECT * FROM
(
	SELECT car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('승용차', '트럭')) pvt;

SELECT line, 트럭, 승용차 FROM
(
	SELECT line, hour, car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('승용차' AS 승용차, '트럭' AS 트럭)) pvt;

SELECT line || '선 ' || CAST(hour AS VARCHAR(10)) || '시' AS 구분, 트럭, 승용차 FROM
(
	SELECT line, hour, car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('승용차' AS 승용차, '트럭' AS 트럭)) pvt
ORDER BY line;

CREATE TABLE tCityStat
(
	name CHAR(10),
	attr CHAR(10),
	value INT
);

INSERT INTO tCityStat VALUES ('서울', 'area', 605);
INSERT INTO tCityStat VALUES ('서울', 'popu', 974);
INSERT INTO tCityStat VALUES ('서울', 'gu', 25);
INSERT INTO tCityStat VALUES ('인제', 'area', 1646);
INSERT INTO tCityStat VALUES ('인제', 'popu', 3);
INSERT INTO tCityStat VALUES ('인제', 'home', 15409);
INSERT INTO tCityStat VALUES ('홍천', 'area', 1819);

SELECT * FROM tCityStat
PIVOT (MAX(value) FOR attr IN ('area' AS area, 'popu' AS popu)) pvt;

SELECT name, ROUND(popu * 10000 / area, 2) AS 인구밀도 FROM
(
    SELECT * FROM tCityStat
    PIVOT (MAX(value) FOR attr IN ('area' AS area, 'popu' AS popu)) pvt
) A;

WHERE popu IS NOT NULL AND area IS NOT NULL

CREATE TABLE tSeasonPivot AS 
SELECT * FROM tSeason
PIVOT (SUM(sale) FOR season IN ('봄' AS 봄, '여름' AS 여름, '가을' AS 가을, '겨울' AS 겨울));

SELECT * INTO tSeasonPivot FROM tSeason
PIVOT (SUM(sale) FOR season IN (봄, 여름, 가을, 겨울)) pvt;

SELECT * FROM tSeasonPivot
UNPIVOT (sale FOR season IN (봄, 여름, 가을, 겨울)) unpvt;

SELECT * FROM
(
    SELECT * FROM tSeason
    PIVOT (SUM(sale) FOR season IN 
    ('봄' AS 봄, '여름' AS 여름, '가을' AS 가을, '겨울' AS 겨울)) pvt
) A
UNPIVOT (sale FOR season IN (봄, 여름, 가을, 겨울)) unpvt;

-------------------------------------------------
-- 14장

ALTER TABLE tCity ADD mayor CHAR(12) NULL;

UPDATE tCity SET mayor = '오륙도' WHERE name = '부산';

ALTER TABLE tCity ADD mayor CHAR(12) NOT NULL;

ALTER TABLE tCity DROP COLUMN mayor;

DROP TABLE tProject;
CREATE TABLE tProject
(
	projectID INT,
	employee CHAR(10),
	project VARCHAR(30),
	cost INT
);

INSERT INTO tProject VALUES (1, '김상형', '홍콩 수출건', 800);
INSERT INTO tProject VALUES (1, '김상형', 'TV 광고건', 3400);

TRUNCATE TABLE tProject;
ALTER TABLE tProject ADD CONSTRAINT PK_projectID PRIMARY KEY(projectID);

오라클, MSSQL : ALTER TABLE tProject DROP CONSTRAINT PK_projectID;
오라클, 마리아 : ALTER TABLE tProject DROP PRIMARY KEY;

DELETE FROM tProject WHERE employee='바이든';
ALTER TABLE tProject ADD CONSTRAINT FK_Project_Employee 
FOREIGN KEY(employee) REFERENCES tEmployee(name);

ALTER TABLE tProject DROP CONSTRAINT FK_Project_Employee;

오라클, 마리아 : ALTER TABLE tCity MODIFY region CHAR(30);
MSSQL : ALTER TABLE tCity ALTER COLUMN region CHAR(30);

INSERT INTO tCity VALUES ('제주',1849,67,'y','제주특별자치도');

오라클, 마리아 : ALTER TABLE tCity MODIFY region CHAR(1);
MSSQL : ALTER TABLE tCity ALTER COLUMN region CHAR(1);

오라클, 마리아 : ALTER TABLE tCity MODIFY popu DECIMAL(10,2);
MSSQL : ALTER TABLE tCity ALTER COLUMN popu DECIMAL(10,2);

UPDATE tCity SET popu = 21.2389 WHERE name = '오산';

CREATE TABLE tCityBackup AS SELECT * FROM tCity;		-- 백업
TRUNCATE TABLE tCity;					-- 원본 비움
ALTER TABLE tCity MODIFY popu DECIMAL(10,2);		-- 필드 타입 변경
INSERT INTO tCity SELECT * FROM tCityBackup;		-- 백업 복원
UPDATE tCity SET popu = 21.2389 WHERE name = '오산';		-- 필드값 변경
COMMIT;									-- 확정
DROP TABLE tCityBackup;					-- 백업 삭제

DELETE FROM tProject WHERE employee='트럼프';
오라클, 마리아 : ALTER TABLE tProject MODIFY project VARCHAR(30) NOT NULL;	
MSSQL : ALTER TABLE tProject ALTER COLUMN project VARCHAR(30) NOT NULL;

오라클 : ALTER TABLE tProject MODIFY cost DEFAULT 100;
마리아 : ALTER TABLE tProject MODIFY cost VARCHAR(30) DEFAULT 100;
MSSQL : ALTER TABLE tProject ALTER COLUMN project VARCHAR(30) DEFAULT 100 NOT NULL;

INSERT INTO tProject (projectid, employee, project) VALUES (4, '오바마', '기후 변화 회의 참석');

INSERT INTO tProject VALUES (5, '클린턴', '북핵 제거', -100);

DELETE FROM tProject WHERE employee='클린턴';
ALTER TABLE tProject ADD CONSTRAINT cost_check CHECK(cost > 0);

CREATE TABLE tCityBackup AS SELECT * FROM tCity;
DROP TABLE tCity;
CREATE TABLE tCity
(
	name CHAR(10) PRIMARY KEY,
	region CHAR(6) NOT NULL,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL
);
INSERT INTO tCity (name, region, area, popu, metro) 
    SELECT name, region, area, popu, metro FROM tCityBackup;
COMMIT;
DROP TABLE tCityBackup;

오라클 : ALTER TABLE tCity RENAME COLUMN popu TO ingu;
MSSQL : sp_rename 'tCity.popu', 'ingu';
마리아 : ALTER TABLE tCity CHANGE popu ingu INT NULL; 

오라클, 마리아 : ALTER TABLE tCity RENAME TO tDosi;
MSSQL : sp_rename 'tCity', 'tDosi';

COMMENT ON TABLE tCity IS '도시 목록';
COMMENT ON COLUMN tCity.popu IS '인구';

SELECT COMMENTS FROM user_tab_comments where table_name = 'TCITY';
SELECT * FROM user_col_comments where table_name = 'TCITY';

sp_addextendedproperty 'MS_Description', '도시목록', 'USER', DBO, 'TABLE', tCity;
sp_addextendedproperty 'MS_Description', '인구', 'USER', DBO, 'TABLE', tCity, 'COLUMN', popu;

-------------------------------------------------
-- 15장

SET SERVEROUTPUT ON;

BEGIN
	DBMS_OUTPUT.PUT_LINE('안녕하세요');
END;

BEGIN
	DBMS_OUTPUT.PUT_LINE('안녕하세요')
END

BEGIN
	DBMS_OUTPUT.PUT_LINE(2 + 3 * 4);
	DBMS_OUTPUT.PUT_LINE(POWER(2, 3));
END;

DECLARE
    v_price INT := 1000;
    v_num INT := 5;
    v_total INT;
BEGIN
    v_total := v_price * v_num;
    DBMS_OUTPUT.PUT_LINE(v_total);
END;

DECLARE v_price INT := 1000;v_num INT := 5;v_total INT;
BEGIN v_total := v_price * v_num;DBMS_OUTPUT.PUT_LINE(v_total);END;

DECLARE
    c_mile CONSTANT NUMBER := 1.609;
    v_kilo INT;
BEGIN
    v_kilo := 400;
    DBMS_OUTPUT.PUT_LINE(v_kilo * c_mile);
END;

DECLARE
    v_price tItem.price%TYPE := 1000;
    v_num v_price%TYPE := 5;
    v_total v_price%TYPE;
BEGIN
    v_total := v_price * v_num;
    DBMS_OUTPUT.PUT_LINE(v_total);
END;

DECLARE 
    v_isOk BOOLEAN;
BEGIN
    v_isOk := (1 = 1);
    IF v_isOK THEN
        DBMS_OUTPUT.PUT_LINE('OK');
    END IF;
END;

DECLARE 
    v_member tOrder.member%TYPE;
BEGIN
    SELECT member INTO v_member FROM tOrder WHERE orderID = 1;
    DBMS_OUTPUT.PUT_LINE(v_member);
END;

DECLARE 
    v_member tOrder.member%TYPE;
    v_item VARCHAR(20);
BEGIN
    SELECT member, item INTO v_member, v_item FROM tOrder WHERE orderID = 1;
    DBMS_OUTPUT.PUT_LINE(v_member || '의 ' || v_item || ' 주문');
END;

DECLARE
    v_row tCity%ROWTYPE;
BEGIN
    SELECT * INTO v_row FROM tCity WHERE name = '부산';
    DBMS_OUTPUT.PUT_LINE(TRIM(v_row.name) || ', ' || v_row.area || ', ' || v_row.popu);
END;

DECLARE
    v_row tCity%ROWTYPE;
BEGIN
    SELECT name, region INTO v_row.name, v_row.region FROM tCity WHERE name = '춘천';
    DBMS_OUTPUT.PUT_LINE(v_row.region || '도의 ' || v_row.name);
END;

DECLARE
    TYPE cap IS RECORD(area INT, popu INT);
    city cap;
BEGIN
    SELECT area, popu INTO city FROM tCity WHERE name = '부산';
    DBMS_OUTPUT.PUT_LINE(city.area || ',' || city.popu);
END;

TYPE cap IS RECORD(area tCity.area%TYPE, popu tCity.popu%TYPE);

DECLARE
    v_maxPopu INT;
    v_cityName VARCHAR(10);
BEGIN
    SELECT MAX(popu) INTO v_maxPopu FROM tCity;
    SELECT name INTO v_cityName FROM tCity WHERE popu = v_maxPopu;
    DBMS_OUTPUT.PUT_LINE(v_cityName);
END;

DECLARE
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = '서울';
    v_popu := v_popu * 2;
    UPDATE tCity SET popu = v_popu WHERE name = '서울';
END;

DECLARE
    TYPE int_array IS VARRAY(5) OF NUMBER;
    ar int_array;
BEGIN
    ar := int_array(8, 9, 0, 6, 2);
    FOR idx IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(ar(idx));
    END LOOP;
END;

DECLARE
    TYPE int_array IS VARRAY(3) OF NUMBER;
    TYPE int_array2 IS VARRAY(3) OF int_array;
    ar int_array2;
BEGIN
    ar := int_array2(int_array(1, 2, 3), int_array(4, 5, 6), int_array(7, 8, 9));
    DBMS_OUTPUT.PUT_LINE(ar(2)(3));
END;

DECLARE
    TYPE int_table IS TABLE OF NUMBER;
    ar int_table;
BEGIN
    ar := int_table(1, 2, 3, 4, 5, 6);
    DBMS_OUTPUT.PUT_LINE(ar(4));
END;

DECLARE
    TYPE string_int_map IS TABLE OF NUMBER INDEX BY STRING(20);
    score string_int_map;
BEGIN
    score('홍길동') := 80;
    score('황진이') := 90;
    score('어우동') := 90;
    score.DELETE('황진이');
    DBMS_OUTPUT.PUT_LINE(score.COUNT());
    DBMS_OUTPUT.PUT_LINE(score('홍길동'));
END;

DECLARE v_score INT := 12;
BEGIN
    IF v_score = 12 THEN
        DBMS_OUTPUT.PUT_LINE('12입니다');
    ELSE
        DBMS_OUTPUT.PUT_LINE('12가 아닙니다');
    END IF;
END;

DECLARE v_score INT := 12;
BEGIN
    IF v_score = 12 THEN
        DBMS_OUTPUT.PUT_LINE('12입니다');
        DBMS_OUTPUT.PUT_LINE('참 잘했어요.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('12가 아닙니다');
        DBMS_OUTPUT.PUT_LINE('좀 더 노력하세요.');
    END IF;
END;

DECLARE 
    v_popu INT;
    v_message VARCHAR(50);
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = '부산';
    IF v_popu > 100 THEN
        v_message := '100만이 넘습니다';
    ELSE
        v_message := '100만보다 적습니다';
    END IF;    
    DBMS_OUTPUT.PUT_LINE('부산의 인구는 ' || v_message);
END;

DECLARE 
    v_num INT := 1;
    v_total INT := 0;
BEGIN
    WHILE v_num <= 100
    LOOP
        v_total := v_total + v_num;
        v_num := v_num + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100까지의 합산 결과 = ' || v_total);
END;

DECLARE 
    v_total INT := 0;
BEGIN
    FOR v_num IN 1 .. 100
    LOOP
        v_total := v_total + v_num;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100까지의 합산 결과 = ' || v_total);
END;

BEGIN
    FOR v_cities IN (SELECT * FROM tCity WHERE region='경기')
    LOOP
        DBMS_OUTPUT.PUT_LINE(TRIM(v_cities.name) || ' : ' || v_cities.area || ',' || v_cities.popu);
    END LOOP;
END;

DECLARE 
    v_num INT := 1;
    v_total INT := 0;
BEGIN
    WHILE 1 = 1
    LOOP
        v_total := v_total + v_num;
        v_num := v_num + 1;
        IF v_num > 100 THEN
            EXIT;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100까지의 합산 결과 = ' || v_total);
END;

DECLARE 
    v_num INT := 1;
    v_total INT := 0;
BEGIN
    LOOP
        v_total := v_total + v_num;
        v_num := v_num + 1;
        EXIT WHEN v_num > 100;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100까지의 합산 결과 = ' || v_total);
END;

DECLARE 
    v_num INT := 1;
    v_total INT := 0;
BEGIN
    <<HERE>>    
    v_total := v_total + v_num;
    v_num := v_num + 1;
    IF v_num <= 100 THEN
        GOTO HERE;
    END IF;
   	DBMS_OUTPUT.PUT_LINE('1~100까지의 합산 결과 = ' || v_total);
END;

BEGIN
    DBMS_LOCK.SLEEP(5);
    DBMS_OUTPUT.PUT_LINE('대기종료');
END;

DECLARE 
    v_num INT := 2;
    v_numword CHAR(30);
BEGIN
    v_numword := 
    CASE v_num
        WHEN 1 THEN '하나'
        WHEN 2 THEN '둘'
        WHEN 3 THEN '셋'
        WHEN 4 THEN '넷'
        ELSE '그외'
    END;
    DBMS_OUTPUT.PUT_LINE(v_numword);
END;

DECLARE 
    v_num INT := 6;
    v_numword CHAR(30);
BEGIN
    v_numword := 
    CASE 
        WHEN v_num < 0 THEN '음수'
        WHEN v_num IN (1, 2, 3) THEN '하나, 둘, 셋'
        WHEN v_num > 4 THEN '넷보다 더 큼'
        ELSE '그외'
    END;
    DBMS_OUTPUT.PUT_LINE(v_numword);
END;

SELECT item, 
    CASE category 
        WHEN '패션' THEN '받자 마자 빨아서 입으세요.'
        WHEN '가전' THEN '충격을 주지 마세요.'
        WHEN '식품' THEN '냉장 보관하세요.'
        WHEN '성인' THEN '애들은 가라'
    END AS 주의사항
FROM tItem

SELECT member, item,
    CASE status
        WHEN 1 THEN '주문'
        WHEN 2 THEN '배송중'
        WHEN 3 THEN '배송완료'
        ELSE '기타'
    END AS 상태
FROM tOrder;

SELECT member, item, DECODE(status, 1, '주문', 2, '배송중', 3, '배송완료', '기타') 
AS 상태 FROM tOrder;

DECLARE 
    v_num INT := 2;
    v_popu INT;
BEGIN
    CASE 
        WHEN v_num = 1 THEN SELECT popu INTO v_popu FROM tCity WHERE name = '서울';
        WHEN v_num = 2 THEN DBMS_OUTPUT.PUT_LINE('둘');
        WHEN v_num = 3 THEN COMMIT;
        WHEN v_num > 4 THEN ROLLBACK;
        ELSE DBMS_OUTPUT.PUT_LINE('알 수 없는 명령');
    END CASE;
END;

DECLARE v_member CHAR(20);
BEGIN
    SELECT member INTO v_member FROM tOrder WHERE orderID = 100;
    DBMS_OUTPUT.PUT_LINE(v_member);
END;

DECLARE v_member CHAR(20);
BEGIN
    SELECT member INTO v_member FROM tOrder WHERE orderID = 100;
    DBMS_OUTPUT.PUT_LINE(v_member);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('주문 번호가 없습니다.');
END;

DECLARE v_member CHAR(20);
BEGIN
    SELECT member INTO v_member FROM tOrder WHERE orderID > 1;
    DBMS_OUTPUT.PUT_LINE(v_member);
    EXCEPTION
        WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('하나의 주문만 선택하십시오.');
END;

DECLARE 
    v_member CHAR(20);
    v_orderID INT := -1;
    negativeOrder EXCEPTION;
BEGIN
    IF (v_orderID < 0) THEN
        RAISE negativeOrder;
    END IF;
    SELECT member INTO v_member FROM tOrder WHERE orderID = v_orderID;
    DBMS_OUTPUT.PUT_LINE(v_member);
    EXCEPTION
        WHEN negativeOrder THEN
            DBMS_OUTPUT.PUT_LINE('주문 번호가 음수여서는 안됩니다.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('원인을 알 수 없는 예외가 발생했습니다.');
END;

DECLARE 
    v_member CHAR(20);
    v_orderID INT := -1;
BEGIN
    IF (v_orderID < 0) THEN
        RAISE_APPLICATION_ERROR(-20000, '주문 번호가 음수여서는 안됩니다.');
    END IF;
    SELECT member INTO v_member FROM tOrder WHERE orderID = v_orderID;
    DBMS_OUTPUT.PUT_LINE(v_member);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE(SQLCODE);
            DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;

SELECT '안녕하세요';
SELECT 2 + 3 * 4;
SELECT POWER(2, 3);

DECLARE @salary INT;			-- 정수형의 @salary 변수
DECLARE @a INT, @b INT = 100;		-- 두 개의 정수형 변수. b는 100으로 초기화
DECLARE @age INT, @name CHAR(5);	-- 정수형 변수와 문자열 변수 선언

DECLARE @price INT;
SET @price = 1000;
SELECT @price;

DECLARE @name CHAR(20);
SELECT @name = member FROM tOrder WHERE orderID=1;
SELECT @name;

SET @name = (SELECT member FROM tOrder WHERE orderID=1);

DECLARE @score INT = 12;
IF @score = 12
	PRINT '12입니다.';
ELSE
	PRINT '12가 아닙니다.';

DECLARE @message VARCHAR(50);
IF (SELECT popu FROM tCity WHERE name = '부산') > 100
BEGIN	
	SET @message='100만이 넘습니다';
	PRINT '많이도 낳았네요'
END
ELSE
BEGIN
	SET @message='100만보다 적습니다';
	PRINT '아직 더 많이 낳아야겠네요'
END
PRINT '부산의 인구는 ' + @message;

DECLARE @num INT = 1, @sum INT = 0;

WHILE @num <= 100
BEGIN
	SET @sum = @sum + @num;
	SET @num = @num + 1;
END
PRINT '1~100까지의 합산 결과 = ' + CONVERT(VARCHAR(10), @sum);

WHILE 1=1
BEGIN
	SET @sum = @sum + @num;
	SET @num = @num + 1;
	IF @num > 100
		BREAK;
END

HERE:
SET @sum = @sum + @num;
SET @num = @num + 1;
IF @num <= 100
	GOTO HERE;

WAITFOR DELAY '00:00:05';		-- 5초간 대기
WAITFOR TIME '02:20:00';			-- 2:20분까지 대기

BEGIN TRY
	INSERT INTO tCity VALUES ('서울',600,1000,'y','경기');
END TRY
BEGIN CATCH
    PRINT '기본키가 같은 레코드를 삽입할 수 없습니다.';
    PRINT '에러 번호 : ' + CAST(ERROR_NUMBER() AS VARCHAR(10))
    PRINT '메시지 : ' + ERROR_MESSAGE()
END CATCH

BEGIN TRY
    SELECT mayor FROM tCity;
END TRY
BEGIN CATCH
    PRINT '시장님에 대한 정보는 없습니다.'
END CATCH

DECLARE @popu INT = 12345;

BEGIN TRY
	IF @popu > 10000
		THROW 50001, '도시의 인구가 1억이 넘을 리가 없을텐데...', 1;
	ELSE
		INSERT INTO tCity VALUES ('광주',600,@popu,'y','전라');
END TRY
BEGIN CATCH
    PRINT '에러 번호 : ' + CAST(ERROR_NUMBER() AS VARCHAR(10))
    PRINT '메시지 : ' + ERROR_MESSAGE()
END CATCH

-------------------------------------------------
-- 16장

CREATE PROCEDURE SP_GetPopu
AS
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = '서울';
    DBMS_OUTPUT.PUT_LINE(v_popu);
END;

EXECUTE SP_GetPopu();

SELECT * FROM user_objects WHERE object_type = 'PROCEDURE';

SELECT * FROM user_source WHERE name = 'SP_GETPOPU';

CREATE PROCEDURE SP_GetPopu
...
    SELECT popu INTO v_popu FROM tCity WHERE name = '부산';

DROP PROCEDURE SP_GetPopu;

CREATE OR REPLACE PROCEDURE SP_GetPopu
AS
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = '부산';
    DBMS_OUTPUT.PUT_LINE(v_popu);
END;

CREATE OR REPLACE PROCEDURE SP_GetPopu
AS
    v_popu INT;
BEGIN
    SELECT population INTO v_popu FROM tCity WHERE name = '부산';
    DBMS_OUTPUT.PUT_LINE(v_popu);
END;

DROP TABLE tCity;

CREATE OR REPLACE PROCEDURE SP_GetCityPopu(p_name IN CHAR)
AS
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = p_name;
    DBMS_OUTPUT.PUT_LINE(p_name || '의 인구는 ' || v_popu || '만명입니다.');
END;

EXEC SP_GetCityPopu('오산');		-- 오산의 인구는 21만명입니다.
EXEC SP_GetCityPopu('청주');		-- 청주의 인구는 83만명입니다.

EXEC SP_GetCityPopu();      		-- 에러
EXEC SP_GetCityPopu('서울', '부산');    	-- 에러

CREATE OR REPLACE PROCEDURE SP_GetCityPopu(p_name IN tCity.name%TYPE := '서울')
....

CREATE OR REPLACE PROCEDURE SP_GrantBonus(p_member CHAR, p_bonus INT)
AS
BEGIN
    UPDATE tMember SET money = money + p_bonus WHERE member = p_member;
    COMMIT;
END;

EXEC SP_GrantBonus('춘향', 123);

EXEC SP_GrantBonus(p_member=>'춘향', p_bonus=>123);
EXEC SP_GrantBonus(p_bonus=>123, p_member=>'춘향');

CREATE OR REPLACE PROCEDURE SP_OutCityPopu(p_name IN CHAR, o_popu OUT INT)
AS
BEGIN
    SELECT popu INTO o_popu FROM tCity WHERE name = p_name;
END;

DECLARE 
    v_popu INT;
BEGIN
    SP_OutCityPopu('서울', v_popu);
    DBMS_OUTPUT.PUT_LINE(v_popu);
END; 

CREATE OR REPLACE PROCEDURE SP_OutCityAreaPopu(p_name IN CHAR, o_area OUT INT, o_popu OUT INT)
AS
BEGIN
    SELECT area, popu INTO o_area, o_popu FROM tCity WHERE name = p_name;
END;

DECLARE 
    v_area INT;
    v_popu INT;
BEGIN
    SP_OutCityAreaPopu('부산', v_area, v_popu);
    DBMS_OUTPUT.PUT_LINE(v_area || ' ,' || v_popu);
END;

CREATE OR REPLACE PROCEDURE SP_GetCityPopu(p_name IN tCity.name%TYPE := '서울')
AS
    v_popu INT;
BEGIN
    SP_OutCityPopu(p_name, v_popu);
    DBMS_OUTPUT.PUT_LINE(p_name || '의 인구는 ' || v_popu || '만명입니다.');
END;

EXECUTE SP_GetCityPopu('평양');

CREATE OR REPLACE PROCEDURE SP_GetCityPopu(p_name IN tCity.name%TYPE := '서울')
AS
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = p_name;
    DBMS_OUTPUT.PUT_LINE(p_name || '의 인구는 ' || v_popu || '만명입니다.');
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('없는 도시입니다.');
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('도시가 너무 많습니다.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('알 수 없는 예외입니다.');
END;

SELECT popu INTO v_popu FROM tCity WHERE name = p_name;
IF v_popu IS NULL THEN
    DBMS_OUTPUT.PUT_LINE('없는 도시입니다.');
END IF;

CREATE OR REPLACE FUNCTION FN_AddInt(a INT, b INT) 
RETURN INT
AS
BEGIN
	RETURN a + b;
END;

SELECT FN_AddInt(2, 3) FROM dual;
SELECT * FROM tCity WHERE popu > FN_AddInt(10, 20);

DECLARE v_sum INT;
BEGIN
    v_sum := FN_AddInt(2, 3);
    DBMS_OUTPUT.PUT_LINE(v_sum);
END;

CREATE OR REPLACE FUNCTION FN_GetSum(p_upBound INT)
RETURN INT
AS
    v_total INT := 0;
BEGIN
    FOR v_num IN 1 .. p_upBound
    LOOP
        v_total := v_total + v_num;
    END LOOP;
    RETURN v_total;
END;

SELECT FN_GetSum(10) FROM dual;

CREATE OR REPLACE TYPE gu_row AS OBJECT
(
    dan INT, 
    num INT, 
    multi INT
);

CREATE OR REPLACE TYPE gu_table AS TABLE OF gu_row;

CREATE OR REPLACE FUNCTION makeDan(p_dan INT)
RETURN gu_table PIPELINED
AS
    v_row gu_row;
BEGIN
    FOR v_num IN 1..9
    LOOP
        v_row := gu_row(p_dan, v_num, p_dan * v_num);
        PIPE ROW(v_row);
    END LOOP;
    RETURN;
END;

SELECT * FROM TABLE(makeDan(5));
SELECT * FROM TABLE(makeDan(7));

CREATE PROCEDURE PROC_GetCityPopu
	@p_name CHAR(10)
AS
BEGIN
	SELECT popu FROM tCity WHERE name = @p_name;
END

EXEC PROC_GetCityPopu @p_name = '서울';
EXEC PROC_GetCityPopu '서울';
PROC_GetCityPopu '서울';

ALTER PROCEDURE PROC_GetCityPopu
	@p_name CHAR(10)
AS
DECLARE
	@popu INT
BEGIN
	SELECT @popu = popu FROM tCity WHERE name = @p_name;
	PRINT @popu
END

ALTER PROCEDURE PROC_GetCityPopu
	@p_name CHAR(10)
AS
BEGIN
	SELECT popu FROM tCity2 WHERE name = @p_name;
END

CREATE PROCEDURE PROC_GrantBonus
	@p_member CHAR(20),
	@p_bonus INT = 100
AS
BEGIN
    UPDATE tMember SET money = money + @p_bonus WHERE member = @p_member;
END;

PROC_GrantBonus '춘향', 2000;
PROC_GrantBonus '춘향';

PROC_GrantBonus @p_member = '춘향', @p_bonus = 2000;
PROC_GrantBonus @p_bonus = 2000, @p_member = '춘향';

CREATE PROCEDURE PROC_OutCityPopu
	@p_name CHAR(10), 
	@o_popu INT OUTPUT
AS
BEGIN
    SELECT @o_popu = popu FROM tCity WHERE name = @p_name;
END;

DECLARE @popu INT;
EXECUTE PROC_OutCityPopu '서울', @popu OUTPUT;
PRINT '서울의 인구는 ' + CAST(@popu AS VARCHAR(10)) + '만명입니다.';

CREATE PROCEDURE PROC_RetCityPopu
	@p_name CHAR(10)
AS
DECLARE
	@popu INT;
BEGIN
    SELECT @popu = popu FROM tCity WHERE name = @p_name;
    RETURN @popu;
END;

DECLARE @popu INT;
EXECUTE @popu = PROC_RetCityPopu '서울';
PRINT '서울의 인구는 ' + CAST(@popu AS VARCHAR(10)) + '만명입니다.';

PRINT '서울의 인구는 ' + CAST(PROC_RetCityPopu '서울' AS VARCHAR(10)) + '만명입니다';
SELECT PROC_RetCityPopu '서울';

CREATE PROCEDURE PROC_InsertSeoul
AS
BEGIN
	INSERT INTO tCity VALUES ('서울',605,974,'y','경기');
END

ALTER PROCEDURE PROC_InsertSeoul
AS
BEGIN
	INSERT INTO tCity VALUES ('서울',605,974,'y','경기');
	IF @@ERROR != 0
	BEGIN
		PRINT('새 레코드를 삽입하지 못했습니다.');
	END
END

ALTER PROCEDURE PROC_InsertSeoul
AS
BEGIN
	BEGIN TRY
		INSERT INTO tCity VALUES ('서울',605,974,'y','경기');
	END TRY

	BEGIN CATCH
		PRINT '에러 번호 : ' + CAST(ERROR_NUMBER() AS VARCHAR(10));
		PRINT '에러 메시지 : ' + ERROR_MESSAGE();
	END CATCH
END

CREATE FUNCTION FN_AddInt(@a INT, @b INT) RETURNS INT
AS
BEGIN
	RETURN @a + @b;
END

SELECT Study.dbo.FN_AddInt(2, 3);

CREATE FUNCTION FN_GetCity(@region CHAR(10))
RETURNS TABLE
AS
RETURN SELECT * FROM tCity WHERE region = @region;

SELECT * FROM dbo.FN_GetCity('강원');

SELECT * FROM dbo.FN_GetCity('강원') WHERE popu > 10;

CREATE FUNCTION FN_GetCityTable(@region CHAR(10))
RETURNS @result TABLE
	(name VARCHAR(10),popu INT)
AS
BEGIN
	INSERT INTO @result SELECT name, popu FROM tCity WHERE region = @region;
	RETURN;
END

SELECT * FROM dbo.FN_GetCityTable('경기');

-------------------------------------------------
-- 17장

DECLARE
    CURSOR v_cursor IS SELECT name FROM tCity;
    v_name CHAR(10);
BEGIN
    OPEN v_cursor;
    LOOP
        FETCH v_cursor INTO v_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_name);
    END LOOP;
    CLOSE v_cursor;
END;

DECLARE
    CURSOR v_cursor IS SELECT * FROM tCity;
    v_city tCity%ROWTYPE;
BEGIN
    OPEN v_cursor;
    LOOP
        FETCH v_cursor INTO v_city;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_city.region || v_city.name || v_city.area);
    END LOOP;
    CLOSE v_cursor;
END;

DECLARE
BEGIN
    FOR v_cursor IN (SELECT name FROM tCity)
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_cursor.name);
    END LOOP;
END;

BEGIN
    UPDATE tCity SET popu = popu WHERE region = '강원';
    IF SQL%FOUND THEN DBMS_OUTPUT.PUT_LINE('결과셋이 있음'); END IF;
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || '개의 행이 바뀜');
END;

DECLARE
    v_cursor SYS_REFCURSOR;
    v_name CHAR(10);
BEGIN
    OPEN v_cursor FOR SELECT name FROM tCity;
    LOOP
        FETCH v_cursor INTO v_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_name);
    END LOOP;
    CLOSE v_cursor;
END;

CREATE OR REPLACE PROCEDURE SP_OutCityName(p_region IN CHAR, o_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN o_cursor FOR SELECT name FROM tCity WHERE region = p_region;
END;

DECLARE
    v_cursor SYS_REFCURSOR;
    v_name CHAR(10);
BEGIN
    SP_OutCityName('전라', v_cursor);
    LOOP
        FETCH v_cursor INTO v_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_name);
    END LOOP;
END;

DECLARE
    CURSOR v_cursor IS SELECT * FROM tCity FOR UPDATE;
    v_city tCity%ROWTYPE;
BEGIN
    OPEN v_cursor;
    LOOP
        FETCH v_cursor INTO v_city;
        EXIT WHEN v_cursor%NOTFOUND;
        IF v_city.metro = 'y' THEN
            UPDATE tCity SET area = area + 10 WHERE CURRENT OF v_cursor;
        END IF;
    END LOOP;
    CLOSE v_cursor;
END;

DECLARE @name CHAR(10)
DECLARE testcursor CURSOR FOR SELECT name FROM tCity
OPEN testcursor
FETCH NEXT FROM testcursor INTO @name
WHILE @@FETCH_STATUS = 0
BEGIN
	PRINT @name
	FETCH NEXT FROM testcursor INTO @name
END
CLOSE testcursor
DEALLOCATE testcursor

START:
FETCH NEXT FROM testcursor INTO @name
IF @@FETCH_STATUS = 0
BEGIN
	PRINT @name
	GOTO START
END

DECLARE @name CHAR(10)
DECLARE @varCur CURSOR
SET @varCur = CURSOR FOR SELECT name FROM tCity;
OPEN @varCur
FETCH NEXT FROM @varCur INTO @name
WHILE @@FETCH_STATUS = 0
BEGIN
	PRINT @name
	FETCH NEXT FROM @varCur INTO @name
END
CLOSE @varCur
DEALLOCATE @VarCur

DECLARE testcursor CURSOR LOCAL SCROLL FOR SELECT name FROM tCity;
OPEN testcursor;

FETCH NEXT FROM testcursor;
FETCH NEXT FROM testcursor;
FETCH PRIOR FROM testcursor;
FETCH LAST FROM testcursor;

DECLARE testcursor CURSOR LOCAL FOR SELECT * FROM tCity;
OPEN testcursor;

FETCH NEXT FROM testcursor;
UPDATE tCity SET popu=1234 WHERE CURRENT OF testcursor;

CLOSE testcursor;
DEALLOCATE testcursor;

DECLARE testcursor CURSOR LOCAL STATIC FOR SELECT name, popu FROM tCity;
OPEN testcursor;

DECLARE @name CHAR(10);
DECLARE @popu INT;
FETCH NEXT FROM testcursor INTO @name, @popu;
PRINT @name + ':' + CONVERT(VARCHAR(12), @popu);
WAITFOR DELAY '00:00:10';
FETCH NEXT FROM testcursor INTO @name, @popu;
PRINT @name + ':' + CONVERT(VARCHAR(12), @popu);

UPDATE tCity SET popu = 500 WHERE name = '부산';

DECLARE testcursor CURSOR LOCAL DYNAMIC FOR SELECT name, popu FROM tCity;
OPEN testcursor;

DECLARE @name CHAR(10);
DECLARE @popu INT;
FETCH NEXT FROM testcursor INTO @name, @popu;
WHILE @@FETCH_STATUS = 0
BEGIN
	PRINT @name + ':' + CONVERT(NVARCHAR(12), @popu);
	WAITFOR DELAY '00:00:01';
	FETCH NEXT FROM testcursor INTO @name, @popu;
END

INSERT INTO tCity VALUES ('평택',453,51,'n','경기');

DECLARE 
    v_orderID INT := 1;
    v_sql VARCHAR(100);
    v_member CHAR(20);
BEGIN
    v_sql := 'SELECT member FROM tOrder WHERE orderID = ' || v_orderID;
    EXECUTE IMMEDIATE v_sql INTO v_member;
    DBMS_OUTPUT.PUT_LINE(v_member);
END;

DECLARE
    v_area INT := 0;
    v_op CHAR(10) := '크다';
    v_sql VARCHAR(100);
    v_name CHAR(10);
BEGIN
    v_sql := 'SELECT name FROM tCity WHERE ';
    IF v_area != 0 THEN
        v_sql := v_sql || 'area ';
        IF v_op = '같다' THEN v_sql := v_sql || '= '; END IF;
        IF v_op = '크다' THEN v_sql := v_sql || '> '; END IF;
        IF v_op = '작다' THEN v_sql := v_sql || '< '; END IF;
        v_sql := v_sql || v_area || ' AND ';
    END IF;
    v_sql := v_sql || ' rownum = 1';
    EXECUTE IMMEDIATE v_sql INTO v_name;
    DBMS_OUTPUT.PUT_LINE(v_name);
END;

SELECT member INTO v_member FROM tOrder WHERE orderID = v_orderID;

v_table VARCHAR(10) := 'tCity';
SELECT name INTO v_name FROM v_table WHERE rownum = 1;

DECLARE 
    v_table VARCHAR(10) := 'tCity';
    v_sql VARCHAR(100);
    v_name CHAR(20);
BEGIN
    v_sql := 'SELECT name FROM ' || v_table || ' WHERE rownum = 1';
    EXECUTE IMMEDIATE v_sql INTO v_name;
    DBMS_OUTPUT.PUT_LINE(v_name);
END;

DECLARE @area INT = 1000;
DECLARE @op CHAR(10) = '크다';
DECLARE @sql VARCHAR(100);

SET @sql = 'SELECT TOP 1 name FROM tCity';
IF @area != 0
BEGIN
	SET @sql += ' WHERE area ';
	IF @op = '같다' SET @sql += '=';
	IF @op = '크다' SET @sql += '>';
	IF @op = '작다' SET @sql += '<';
	SET @sql = @sql + CAST(@area AS VARCHAR(10));
END
EXECUTE(@sql);

DECLARE 
    hour_begin INT := 1;
    hour_end INT := 2;
    hour_now INT := hour_begin;
    v_sql VARCHAR(1000);
    v_cursor SYS_REFCURSOR;
    TYPE linecar IS RECORD(line VARCHAR(100), car VARCHAR(100), t1 VARCHAR(100), t2 VARCHAR(100));
    v_lc linecar;
BEGIN
    v_sql := 'SELECT * FROM tTraffic PIVOT (SUM(traffic) FOR hour IN (';
    WHILE hour_now <= hour_end
    LOOP
        v_sql := v_sql || hour_now;
        IF hour_now != hour_end THEN v_sql := v_sql || ', '; END IF;
        hour_now := hour_now + 1;
    END LOOP;
    v_sql := v_sql || '))'; 
    
    OPEN v_cursor FOR v_sql;
    LOOP
        -- INTO 절에 레코드 타입을 적으면 되는데 타입을 미리 결정할 수 없다.
        FETCH v_cursor INTO v_lc;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_lc.line || v_lc.car || v_lc.t1 || ',' || v_lc.t2);
    END LOOP;
END;

DECLARE @hour_begin INT = 1;
DECLARE @hour_end INT = 2;
DECLARE @hour INT = @hour_begin;
DECLARE @sql VARCHAR(1000);

SET @sql = 'SELECT * FROM tTraffic PIVOT (SUM(traffic) FOR hour IN (';
WHILE @hour <= @hour_end
BEGIN
	SET @sql += '[' + CAST(@hour AS VARCHAR) + ']';
	IF @hour != @hour_end SET @sql += ', ';
	SET @hour += 1;
END
SET @sql += ')) as pvt';

EXEC(@sql);

-------------------------------------------------
-- 18장

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity
BEGIN
    DBMS_OUTPUT.PUT_LINE('도시 정보를 갱신하였습니다.');
END;

UPDATE tCity SET popu = popu + 1 WHERE name = '서울';


CREATE OR REPLACE TRIGGER TR_Message
AFTER INSERT OR UPDATE OR DELETE ON tCity
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('새로운 도시를 삽입하였습니다.');
    END IF;
    IF UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('도시 정보를 갱신하였습니다.');
    END IF;
    IF DELETING THEN
        DBMS_OUTPUT.PUT_LINE('도시를 삭제하였습니다.');
    END IF;
END;

INSERT INTO tCity VALUES ('여주',608,11,'n','경기');
UPDATE tCity SET popu = 12 WHERE name = '여주';
DELETE FROM tCity WHERE NAME = '여주';

UPDATE tCity SET popu = popu + 1 WHERE region = '경기';

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || ':' || :OLD.popu || '->' || :NEW.popu);
END;

REFERENCING OLD AS pre_rec NEW AS post_rec

UPDATE tCity SET area = area + 1 WHERE name = '서울';

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE OF popu ON tCity 
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || ':' || :OLD.popu || '->' || :NEW.popu);
END;

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity 
FOR EACH ROW
WHEN (NEW.popu > 10)
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || ':' || :OLD.popu || '->' || :NEW.popu);
END;

UPDATE tCity SET popu = popu + 1 WHERE region = '강원';

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
    IF :NEW.popu > 10000 THEN
        RAISE_APPLICATION_ERROR(-20000, '인구가 1억을 넘을 수는 없습니다.');
    END IF;
    DBMS_OUTPUT.PUT_LINE(:OLD.name || ':' || :OLD.popu || '->' || :NEW.popu);
END;

UPDATE tCity SET popu = 12345 WHERE name = '서울';

CREATE OR REPLACE TRIGGER TR_PreventChoi
AFTER INSERT ON tStaff
FOR EACH ROW
BEGIN
    IF SUBSTR(:NEW.name,1,1) = '최' THEN
        RAISE_APPLICATION_ERROR(-20000, '최가는 안되!');
    END IF;
END;

INSERT INTO tStaff VALUES ('최무선','총무부','남','2021-6-25','사원',280,0);

CREATE OR REPLACE TRIGGER TR_PreventChoi
BEFORE INSERT ON tStaff
FOR EACH ROW
BEGIN
    IF SUBSTR(:NEW.name,1,1) = '최' THEN
        DBMS_OUTPUT.PUT_LINE('최가는 안되');
        :NEW.name := '김' || SUBSTR(:NEW.name, 2);
    END IF;
END;

CREATE OR REPLACE TRIGGER TR_DoubleMoney
BEFORE INSERT ON tMember
FOR EACH ROW
BEGIN
    IF :NEW.age = 18 THEN
        :NEW.money := :NEW.money * 2;
    END IF;
END;

INSERT INTO tMember (member, age, email, addr, money) VALUES 
('신입생', 18, 'fresher@kyunghee.ac.kr', '서울 회기동', 8000);

CREATE VIEW vCarMaker AS
SELECT tCar.*, factory, domestic FROM tCar INNER JOIN tMaker ON
tCar.maker = tMaker.maker;

INSERT INTO vCarMaker VALUES('티코', 800, 900, '대우', '울릉', 'y');

CREATE OR REPLACE TRIGGER TR_AddNewCar
INSTEAD OF INSERT ON vCarMaker
FOR EACH ROW
BEGIN
	INSERT INTO tCar (car, capacity, price, maker) VALUES 
        (:NEW.car, :NEW.capacity, :NEW.price, :NEW.maker);
	INSERT INTO tMaker (maker, factory, domestic) VALUES 
        (:NEW.maker, :NEW.factory, :NEW.domestic);
END;

CREATE OR REPLACE TRIGGER TR_Message2
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || '면적:' || :OLD.area || '->' || :NEW.area);
END;

CREATE OR REPLACE TRIGGER TR_Message3
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || '지역:' || :OLD.region || '->' || :NEW.region);
END;

CREATE OR REPLACE TRIGGER TR_Message3
AFTER UPDATE ON tCity
FOR EACH ROW
FOLLOWS TR_Message
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || '지역:' || :OLD.region || '->' || :NEW.region);
END;

UPDATE tCity SET area = 1000, popu = 12345 WHERE name = '서울';

CREATE OR REPLACE TRIGGER TR_OnNewCar
AFTER INSERT ON tCar
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('신차가 출시되었습니다.');
END;

INSERT INTO vCarMaker VALUES('티코', 800, 900, '대우', '울릉', 'y');

CREATE OR REPLACE TRIGGER TR_Change
AFTER DDL ON DATABASE
BEGIN
    DBMS_OUTPUT.PUT_LINE('명령 : ' || ora_sysevent);
    DBMS_OUTPUT.PUT_LINE('타입 : ' || ora_dict_obj_type);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ora_dict_obj_name);
END;

CREATE TABLE tTemp ( id INT );
DROP TABLE tTemp;

CREATE TABLE tCityHistory
(
    dt DATE,
    suser VARCHAR(20),
    ip VARCHAR(20),
    action VARCHAR(10),
    name CHAR(10),
    area VARCHAR(30) NULL,
    popu VARCHAR(30) NULL
);

CREATE OR REPLACE TRIGGER TR_History
AFTER INSERT OR UPDATE OR DELETE ON tCity
FOR EACH ROW
DECLARE
    areaChange VARCHAR(30);
    popuChange VARCHAR(30);
    suser VARCHAR(20);
    ip VARCHAR(20);
BEGIN
    SELECT SYS_CONTEXT('USERENV', 'SESSION_USER') INTO suser FROM DUAL;
    SELECT SYS_CONTEXT('USERENV', 'IP_ADDRESS') INTO ip FROM DUAL;
    
    IF INSERTING THEN
        INSERT INTO tCityHistory VALUES 
            (SYSDATE, suser, ip, 'INSERT', :NEW.name, :NEW.area, :NEW.popu);
    END IF;
    IF UPDATING THEN
        IF :OLD.area = :NEW.area THEN
            areaChange := :OLD.area;
        ELSE
            areaChange := :OLD.area || '->' || :NEW.area;
        END IF;
        IF :OLD.popu = :NEW.popu THEN
            popuChange := :OLD.popu;
        ELSE
            popuChange := :OLD.popu || '->' || :NEW.popu;
        END IF;
        INSERT INTO tCityHistory VALUES 
            (SYSDATE, suser, ip, 'UPDATE', :NEW.name, areaChange, popuChange);
    END IF;
    IF DELETING THEN
        INSERT INTO tCityHistory VALUES 
            (SYSDATE, suser, ip, 'DELETE', :OLD.name, :OLD.area, :OLD.popu);
    END IF;
END;

CREATE TRIGGER TR_Message
ON tCity AFTER UPDATE 
AS
BEGIN
    PRINT('도시 정보를 갱신하였습니다.');
END;

UPDATE tCity SET popu = popu + 1 WHERE name = '서울';
UPDATE tCity SET popu = popu + 1 WHERE region = '경기';

ALTER TRIGGER TR_Message
ON tCity AFTER UPDATE 
AS
BEGIN
	SELECT * FROM deleted;
	SELECT * FROM inserted;
END;

ALTER TRIGGER TR_Message
ON tCity AFTER UPDATE 
AS
BEGIN
	SELECT name, popu, ' => ', (SELECT popu FROM inserted WHERE name = D.name) FROM deleted D;
END;

ALTER TABLE tCity DISABLE TRIGGER TR_Message;

ALTER TRIGGER TR_Message
ON tCity AFTER UPDATE 
AS
BEGIN
	IF (SELECT popu FROM inserted) > 10000
	BEGIN
		PRINT('인구가 1억을 넘을 수는 없습니다.');
		ROLLBACK;
	END
END;

CREATE TRIGGER TR_PreventChoi
ON tStaff AFTER INSERT
AS
IF EXISTS (SELECT * FROM inserted WHERE name LIKE '최%')
BEGIN
	PRINT '최가는 안되!';
	ROLLBACK TRANSACTION;
END

CREATE TRIGGER TR_AddNewCar
ON vCarMaker INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO tCar (car, capacity, price, maker) SELECT car, capacity, price, maker FROM inserted;
	INSERT INTO tMaker (maker, factory, domestic) SELECT maker, factory, domestic FROM inserted;
END

CREATE TRIGGER TR_DoubleMoney
ON tMember AFTER INSERT
AS
DECLARE @name CHAR(20)
DECLARE @age INT
SELECT @name = member, @age = age FROM inserted;
IF @age = 18
	UPDATE tMember SET money = money * 2 WHERE member = @name;

CREATE TRIGGER TR_MoneyChange
ON tMember
AFTER UPDATE
AS
DECLARE @name CHAR(20)
IF UPDATE(money)
BEGIN
	SELECT @name = member FROM inserted;
	PRINT @name + '의 예치금이 갱신되었습니다. 부정이 아닌지 확인해 보십시오';
END;

CREATE TRIGGER NewDataBase
ON ALL SERVER
AFTER CREATE_DATABASE, DROP_DATABASE
AS
PRINT '새로운 DB가 생성 또는 파괴되었습니다.';

CREATE DATABASE NewDB
DROP DATABASE NewDB

DROP TRIGGER NewDataBase ON ALL SERVER

-------------------------------------------------
-- 19장

INSERT INTO tCity VALUES ('평택',453,51,'n','경기');
SELECT * FROM tCity;

SELECT * FROM v$transaction;

DELETE FROM tCity WHERE metro = 'n';
SELECT * FROM tCity;

UPDATE tMember SET money = money + 100 WHERE member='춘향';
APDATE tMember SET money = money - 100 WHERE member='이도령';

UPDATE tMember SET money = money + 100 WHERE member='춘향';
UPDATE tMember2 SET money = money - 100 WHERE member='이도령';

BEGIN TRANSACTION
UPDATE tMember SET money = money + 100 WHERE member='춘향';
UPDATE tMember SET money = money - 100 WHERE member='이도령';
ROLLBACK;

BEGIN TRAN
UPDATE tMember SET money = money + 10000 WHERE member = '춘향';
DECLARE @remain INT
SELECT @remain = money FROM tMember WHERE member = '이도령';
IF @remain < 10000 
BEGIN
	ROLLBACK
END
ELSE
BEGIN
	UPDATE tMember SET money = money - 10000 WHERE member = '이도령';
	COMMIT
END
SELECT * FROM tMember WHERE member IN ('춘향', '이도령');

UPDATE tCity SET popu = 1000 WHERE name = '서울';
SAVEPOINT p1000;
UPDATE tCity SET popu = 1100 WHERE name = '서울';
SAVEPOINT p1100;
UPDATE tCity SET popu = 1200 WHERE name = '서울';
SAVEPOINT p1200;
ROLLBACK TO SAVEPOINT p1100;

SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

오라클 : ALTER PROFILE DEFAULT LIMIT IDLE_TIME 1;
MSSQL : SET LOCK_TIMEOUT 60000

UPDATE tMember SET age=25 WHERE member='향단';
UPDATE tItem SET num=10 WHERE item='두부';
COMMIT

UPDATE tItem SET num=5 WHERE item='두부';
UPDATE tMember SET age=18 WHERE member='향단';
COMMIT

-------------------------------------------------
-- 부록

SET @score = 123;
SELECT @score;

SELECT @maxnum := MAX(num) FROM tItem;
SELECT item FROM tItem WHERE num = @maxnum;

DELIMITER $$
CREATE [OR REPLACE] PROCEDURE 프로시저 이름()
BEGIN
	여기에 코드를 작성한다.
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE score INT DEFAULT 123;
	SELECT score;
	SET score = score + 1;
	SELECT score;
END $$
DELIMITER ;

CALL SP_proc();

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE score INT;
	SET score = 12;
	IF score = 12 THEN
		SELECT '12입니다';
	ELSE
		SELECT '12가 아닙니다.';
	END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE score INT DEFAULT 86;
	CASE
		WHEN score > 95 THEN SELECT 'A+';
		WHEN score > 90 THEN SELECT 'A';
		WHEN score > 85 THEN SELECT 'B+';
		WHEN score > 80 THEN SELECT 'B';
		ELSE SELECT 'C';
	END CASE;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE score INT DEFAULT 86;
	DECLARE grade CHAR(2);
	SET grade = CASE
		WHEN score > 95 THEN 'A+'
		WHEN score > 90 THEN 'A'
		WHEN score > 85 THEN 'B+'
		WHEN score > 80 THEN 'B'
		ELSE 'C'
	END;
	SELECT grade;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE num INT DEFAULT 1;
	DECLARE sum INT DEFAULT 0;
	WHILE (num <= 100) DO
		SET sum = sum + num;
		SET num = num + 1;
	END WHILE;

	SELECT sum;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE num INT DEFAULT 1;
	DECLARE sum INT DEFAULT 0;
	REPEAT
		SET sum = sum + num;
		SET num = num + 1;
		UNTIL num > 100
	END REPEAT;

	SELECT sum;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE num INT DEFAULT 1;
	DECLARE sum INT DEFAULT 0;
	sumloop: LOOP
		SET sum = sum + num;
		SET num = num + 1;
		IF num > 100 THEN
			LEAVE sumloop;
		END IF;
	END LOOP;

	SELECT sum;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_GrantBonus(IN p_member CHAR(20))
BEGIN
	UPDATE tMember SET money = money + 1000 WHERE member = p_member;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_GetMemberNum(OUT o_member_num INT)
BEGIN
	SELECT COUNT(*) INTO o_member_num FROM tMember;
END $$
DELIMITER ;

CALL SP_GetMemberNum(@num);
SELECT @num;

DELIMITER $$
CREATE OR REPLACE FUNCTION FN_AddInt(a INT, b INT) RETURNS INT
BEGIN
	RETURN a + b;
END $$
DELIMITER ;

SELECT FN_AddInt(2, 3);

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_dumpCity()
BEGIN
	DECLARE city_name CHAR(10);
	DECLARE eof INT DEFAULT 0;

	DECLARE testcursor CURSOR FOR SELECT name FROM tCity;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET eof = 1; 
	OPEN testcursor;

	fetch_loop: LOOP
		FETCH testcursor INTO city_name;
		IF eof THEN 
			LEAVE fetch_loop;
		END IF;
		SELECT city_name;
	END LOOP;
	CLOSE testcursor;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
	SET @result = CONCAT(OLD.popu, '->', NEW.popu);
END $$
DELIMITER ;

UPDATE tCity SET popu = popu + 1 WHERE name = '서울';

SELECT @result;

