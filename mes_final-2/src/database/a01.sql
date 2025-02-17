SELECT * FROM BOARD;

SELECT * FROM BOARD2;

SELECT * FROM BOARDFILE;


DROP TABLE BOARD;


CREATE TABLE board(
	NO number(5) PRIMARY KEY,--  기본 키(글번호)
	refno number(5),  -- 답글번호
	eqnum number(5),    -- 설비번호
	subject varchar2(100), -- 제목
	content varchar2(1000), -- 내용
	writer varchar2(50), -- 작성자
	readcnt number(3), -- 조회수
	regdte DATE, -- 등록일
	uptdte date -- 수정일
);

INSERT INTO BOARD values(board2_seq.nextval,0,10,'두번째 게시판 첫번째글',
					'내용2','마길동',0,sysdate,sysdate);

SELECT * FROM BOARD b;
