-- 회원
DROP TABLE IF EXISTS p1_memb RESTRICT;

-- 게시판
DROP TABLE IF EXISTS p1_board RESTRICT;

-- 첨부파일
DROP TABLE IF EXISTS p1_att_file RESTRICT;

-- 학생
DROP TABLE IF EXISTS p1_stud RESTRICT;

-- 매니저
DROP TABLE IF EXISTS p1_mgr RESTRICT;

-- 강사
DROP TABLE IF EXISTS p1_tchr RESTRICT;

-- 강의
DROP TABLE IF EXISTS p1_lect RESTRICT;

-- 강의배정
DROP TABLE IF EXISTS p1_lect_tchr RESTRICT;

-- 수강생
DROP TABLE IF EXISTS p1_lect_stud RESTRICT;

-- 회원
CREATE TABLE p1_memb (
    mno   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
    name  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
    email VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
    pwd   VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
    tel   VARCHAR(30)  NULL     COMMENT '전화', -- 전화
    cdt   DATETIME     NOT NULL COMMENT '등록일' -- 등록일
)
COMMENT '회원';

-- 회원
ALTER TABLE p1_memb
    ADD CONSTRAINT PK_p1_memb -- 회원 기본키
        PRIMARY KEY (
            mno -- 회원번호
        );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_p1_memb
    ON p1_memb ( -- 회원
        email ASC -- 이메일
    );

ALTER TABLE p1_memb
    MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 게시판
CREATE TABLE p1_board (
    bno  INTEGER      NOT NULL COMMENT '게시물번호', -- 게시물번호
    titl VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
    cont TEXT         NOT NULL COMMENT '내용', -- 내용
    cnt  INTEGER      NULL     COMMENT '조회수', -- 조회수
    cdt  DATETIME     NOT NULL COMMENT '등록일', -- 등록일
    mno  INTEGER      NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '게시판';

-- 게시판
ALTER TABLE p1_board
    ADD CONSTRAINT PK_p1_board -- 게시판 기본키
        PRIMARY KEY (
            bno -- 게시물번호
        );

ALTER TABLE p1_board
    MODIFY COLUMN bno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시물번호';

-- 첨부파일
CREATE TABLE p1_att_file (
    afno  INTEGER      NOT NULL COMMENT '파일번호', -- 파일번호
    fi_nm VARCHAR(255) NOT NULL COMMENT '파일명', -- 파일명
    bno   INTEGER      NOT NULL COMMENT '게시물번호' -- 게시물번호
)
COMMENT '첨부파일';

-- 첨부파일
ALTER TABLE p1_att_file
    ADD CONSTRAINT PK_p1_att_file -- 첨부파일 기본키
        PRIMARY KEY (
            afno -- 파일번호
        );

ALTER TABLE p1_att_file
    MODIFY COLUMN afno INTEGER NOT NULL AUTO_INCREMENT COMMENT '파일번호';

-- 학생
CREATE TABLE p1_stud (
    sno  INTEGER     NOT NULL COMMENT '학생번호', -- 학생번호
    schl VARCHAR(50) NOT NULL COMMENT '최종학력', -- 최종학력
    work CHAR(1)     NOT NULL COMMENT '재직자' -- 재직자
)
COMMENT '학생';

-- 학생
ALTER TABLE p1_stud
    ADD CONSTRAINT PK_p1_stud -- 학생 기본키
        PRIMARY KEY (
            sno -- 학생번호
        );

-- 매니저
CREATE TABLE p1_mgr (
    mrno INTEGER     NOT NULL COMMENT '매니저번호', -- 매니저번호
    posi VARCHAR(50) NOT NULL COMMENT '직위' -- 직위
)
COMMENT '매니저';

-- 매니저
ALTER TABLE p1_mgr
    ADD CONSTRAINT PK_p1_mgr -- 매니저 기본키
        PRIMARY KEY (
            mrno -- 매니저번호
        );

-- 강사
CREATE TABLE p1_tchr (
    tno   INTEGER      NOT NULL COMMENT '강사번호', -- 강사번호
    hrpay INTEGER      NOT NULL COMMENT '시급', -- 시급
    subj  VARCHAR(255) NOT NULL COMMENT '강의과목' -- 강의과목
)
COMMENT '강사';

-- 강사
ALTER TABLE p1_tchr
    ADD CONSTRAINT PK_p1_tchr -- 강사 기본키
        PRIMARY KEY (
            tno -- 강사번호
        );

-- 강의
CREATE TABLE p1_lect (
    lno    INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
    titl   VARCHAR(255) NOT NULL COMMENT '강의명', -- 강의명
    disct  TEXT         NOT NULL COMMENT '설명', -- 설명
    sdt    DATETIME     NOT NULL COMMENT '시작일', -- 시작일
    edt    DATETIME     NOT NULL COMMENT '종료일', -- 종료일
    tot_hr INTEGER      NOT NULL COMMENT '총강의시간', -- 총강의시간
    day_hr INTEGER      NOT NULL COMMENT '일강의시간', -- 일강의시간
    capa   INTEGER      NOT NULL COMMENT '모집인원', -- 모집인원
    mrno   INTEGER      NULL     COMMENT '매니저번호' -- 매니저번호
)
COMMENT '강의';

-- 강의
ALTER TABLE p1_lect
    ADD CONSTRAINT PK_p1_lect -- 강의 기본키
        PRIMARY KEY (
            lno -- 강의번호
        );

ALTER TABLE p1_lect
    MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의번호';

-- 강의배정
CREATE TABLE p1_lect_tchr (
    tno INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
    lno INTEGER NOT NULL COMMENT '강의번호' -- 강의번호
)
COMMENT '강의배정';

-- 강의배정
ALTER TABLE p1_lect_tchr
    ADD CONSTRAINT PK_p1_lect_tchr -- 강의배정 기본키
        PRIMARY KEY (
            tno, -- 강사번호
            lno  -- 강의번호
        );

-- 수강생
CREATE TABLE p1_lect_stud (
    sno INTEGER NOT NULL COMMENT '학생번호', -- 학생번호
    lno INTEGER NOT NULL COMMENT '강의번호' -- 강의번호
)
COMMENT '수강생';

-- 수강생
ALTER TABLE p1_lect_stud
    ADD CONSTRAINT PK_p1_lect_stud -- 수강생 기본키
        PRIMARY KEY (
            sno, -- 학생번호
            lno  -- 강의번호
        );

-- 게시판
ALTER TABLE p1_board
    ADD CONSTRAINT FK_p1_memb_TO_p1_board -- 회원 -> 게시판
        FOREIGN KEY (
            mno -- 회원번호
        )
        REFERENCES p1_memb ( -- 회원
            mno -- 회원번호
        );

-- 첨부파일
ALTER TABLE p1_att_file
    ADD CONSTRAINT FK_p1_board_TO_p1_att_file -- 게시판 -> 첨부파일
        FOREIGN KEY (
            bno -- 게시물번호
        )
        REFERENCES p1_board ( -- 게시판
            bno -- 게시물번호
        );

-- 학생
ALTER TABLE p1_stud
    ADD CONSTRAINT FK_p1_memb_TO_p1_stud -- 회원 -> 학생
        FOREIGN KEY (
            sno -- 학생번호
        )
        REFERENCES p1_memb ( -- 회원
            mno -- 회원번호
        );

-- 매니저
ALTER TABLE p1_mgr
    ADD CONSTRAINT FK_p1_memb_TO_p1_mgr -- 회원 -> 매니저
        FOREIGN KEY (
            mrno -- 매니저번호
        )
        REFERENCES p1_memb ( -- 회원
            mno -- 회원번호
        );

-- 강사
ALTER TABLE p1_tchr
    ADD CONSTRAINT FK_p1_memb_TO_p1_tchr -- 회원 -> 강사
        FOREIGN KEY (
            tno -- 강사번호
        )
        REFERENCES p1_memb ( -- 회원
            mno -- 회원번호
        );

-- 강의
ALTER TABLE p1_lect
    ADD CONSTRAINT FK_p1_mgr_TO_p1_lect -- 매니저 -> 강의
        FOREIGN KEY (
            mrno -- 매니저번호
        )
        REFERENCES p1_mgr ( -- 매니저
            mrno -- 매니저번호
        );

-- 강의배정
ALTER TABLE p1_lect_tchr
    ADD CONSTRAINT FK_p1_tchr_TO_p1_lect_tchr -- 강사 -> 강의배정
        FOREIGN KEY (
            tno -- 강사번호
        )
        REFERENCES p1_tchr ( -- 강사
            tno -- 강사번호
        );

-- 강의배정
ALTER TABLE p1_lect_tchr
    ADD CONSTRAINT FK_p1_lect_TO_p1_lect_tchr -- 강의 -> 강의배정
        FOREIGN KEY (
            lno -- 강의번호
        )
        REFERENCES p1_lect ( -- 강의
            lno -- 강의번호
        );

-- 수강생
ALTER TABLE p1_lect_stud
    ADD CONSTRAINT FK_p1_stud_TO_p1_lect_stud -- 학생 -> 수강생
        FOREIGN KEY (
            sno -- 학생번호
        )
        REFERENCES p1_stud ( -- 학생
            sno -- 학생번호
        );

-- 수강생
ALTER TABLE p1_lect_stud
    ADD CONSTRAINT FK_p1_lect_TO_p1_lect_stud -- 강의 -> 수강생
        FOREIGN KEY (
            lno -- 강의번호
        )
        REFERENCES p1_lect ( -- 강의
            lno -- 강의번호
        );