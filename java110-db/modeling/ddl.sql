-- 강의
DROP TABLE IF EXISTS p2_lect RESTRICT;

-- 강의실
DROP TABLE IF EXISTS p2_cls_room RESTRICT;

-- 학생
DROP TABLE IF EXISTS p2_stud RESTRICT;

-- 강사
DROP TABLE IF EXISTS p2_tchr RESTRICT;

-- 매니저
DROP TABLE IF EXISTS p2_mgr RESTRICT;

-- 강의실사진
DROP TABLE IF EXISTS p2_cr_phot RESTRICT;

-- 과목
DROP TABLE IF EXISTS p2_subj RESTRICT;

-- 강사배정
DROP TABLE IF EXISTS p2_tchr_lect RESTRICT;

-- 강의과목
DROP TABLE IF EXISTS p2_tchr_subj RESTRICT;

-- 회원
DROP TABLE IF EXISTS p2_memb RESTRICT;

-- 강의
CREATE TABLE p2_lect (
    lno   INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
    titl  VARCHAR(255) NOT NULL COMMENT '강의명', -- 강의명
    conts TEXT         NOT NULL COMMENT '내용', -- 내용
    sdt   DATE         NOT NULL COMMENT '시작일', -- 시작일
    edt   DATE         NOT NULL COMMENT '종료일', -- 종료일
    capa  INTEGER      NOT NULL COMMENT '모집인원', -- 모집인원
    pric  INTEGER      NOT NULL COMMENT '수강료', -- 수강료
    supp  CHAR(1)      NOT NULL COMMENT '정부지원여부', -- 정부지원여부
    crno  INTEGER      NULL     COMMENT '강의실번호', -- 강의실번호
    mno   INTEGER      NULL     COMMENT '매니저번호' -- 매니저번호
)
COMMENT '강의';

-- 강의
ALTER TABLE p2_lect
    ADD CONSTRAINT PK_p2_lect -- 강의 기본키
        PRIMARY KEY (
            lno -- 강의번호
        );

-- 강의 인덱스
CREATE INDEX IX_p2_lect
    ON p2_lect( -- 강의
        titl ASC -- 강의명
    );

ALTER TABLE p2_lect
    MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의번호';

-- 강의실
CREATE TABLE p2_cls_room (
    crno INTEGER     NOT NULL COMMENT '강의실번호', -- 강의실번호
    loc  VARCHAR(50) NOT NULL COMMENT '지점명', -- 지점명
    room VARCHAR(50) NOT NULL COMMENT '강의실명', -- 강의실명
    capa INTEGER     NOT NULL COMMENT '최대수용가능인원' -- 최대수용가능인원
)
COMMENT '강의실';

-- 강의실
ALTER TABLE p2_cls_room
    ADD CONSTRAINT PK_p2_cls_room -- 강의실 기본키
        PRIMARY KEY (
            crno -- 강의실번호
        );

-- 강의실 유니크 인덱스
CREATE UNIQUE INDEX UIX_p2_cls_room
    ON p2_cls_room ( -- 강의실
        loc ASC,  -- 지점명
        room ASC  -- 강의실명
    );

ALTER TABLE p2_cls_room
    MODIFY COLUMN crno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의실번호';

-- 학생
CREATE TABLE p2_stud (
    sno   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
    work  CHAR(1)      NOT NULL COMMENT '재직여부', -- 재직여부
    birth DATE         NULL     COMMENT '생년월일', -- 생년월일
    phot  VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '학생';

-- 학생
ALTER TABLE p2_stud
    ADD CONSTRAINT PK_p2_stud -- 학생 기본키
        PRIMARY KEY (
            sno -- 회원번호
        );

-- 강사
CREATE TABLE p2_tchr (
    tno  INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
    phot VARCHAR(255) NOT NULL COMMENT '사진', -- 사진
    pay  INTEGER      NULL     COMMENT '강의료' -- 강의료
)
COMMENT '강사';

-- 강사
ALTER TABLE p2_tchr
    ADD CONSTRAINT PK_p2_tchr -- 강사 기본키
        PRIMARY KEY (
            tno -- 회원번호
        );

-- 매니저
CREATE TABLE p2_mgr (
    mno  INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
    posi VARCHAR(50) NOT NULL COMMENT '직위' -- 직위
)
COMMENT '매니저';

-- 매니저
ALTER TABLE p2_mgr
    ADD CONSTRAINT PK_p2_mgr -- 매니저 기본키
        PRIMARY KEY (
            mno -- 회원번호
        );

-- 강의실사진
CREATE TABLE p2_cr_phot (
    cpno INTEGER      NOT NULL COMMENT '강의실사진번호', -- 강의실사진번호
    phot VARCHAR(255) NOT NULL COMMENT '사진파일명', -- 사진파일명
    crno INTEGER      NOT NULL COMMENT '강의실번호' -- 강의실번호
)
COMMENT '강의실사진';

-- 강의실사진
ALTER TABLE p2_cr_phot
    ADD CONSTRAINT PK_p2_cr_phot -- 강의실사진 기본키
        PRIMARY KEY (
            cpno -- 강의실사진번호
        );

ALTER TABLE p2_cr_phot
    MODIFY COLUMN cpno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의실사진번호';

-- 과목
CREATE TABLE p2_subj (
    sjno INTEGER      NOT NULL COMMENT '과목번호', -- 과목번호
    titl VARCHAR(255) NOT NULL COMMENT '강의과목' -- 강의과목
)
COMMENT '과목';

-- 과목
ALTER TABLE p2_subj
    ADD CONSTRAINT PK_p2_subj -- 과목 기본키
        PRIMARY KEY (
            sjno -- 과목번호
        );

-- 과목 유니크 인덱스
CREATE UNIQUE INDEX UIX_p2_subj
    ON p2_subj ( -- 과목
        titl ASC -- 강의과목
    );

ALTER TABLE p2_subj
    MODIFY COLUMN sjno INTEGER NOT NULL AUTO_INCREMENT COMMENT '과목번호';

-- 강사배정
CREATE TABLE p2_tchr_lect (
    lno INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
    tno INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '강사배정';

-- 강사배정
ALTER TABLE p2_tchr_lect
    ADD CONSTRAINT PK_p2_tchr_lect -- 강사배정 기본키
        PRIMARY KEY (
            lno, -- 강의번호
            tno  -- 회원번호
        );

-- 강의과목
CREATE TABLE p2_tchr_subj (
    sjno INTEGER NOT NULL COMMENT '과목번호', -- 과목번호
    tno  INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '강의과목';

-- 강의과목
ALTER TABLE p2_tchr_subj
    ADD CONSTRAINT PK_p2_tchr_subj -- 강의과목 기본키
        PRIMARY KEY (
            sjno, -- 과목번호
            tno   -- 회원번호
        );

-- 회원
CREATE TABLE p2_memb (
    uno      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
    name     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
    tel      VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
    email    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
    edu      VARCHAR(50)  NOT NULL COMMENT '최종학력', -- 최종학력
    schl     VARCHAR(50)  NOT NULL COMMENT '최종학교', -- 최종학교
    maj      VARCHAR(50)  NOT NULL COMMENT '전공', -- 전공
    pstno    VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
    bas_addr VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
    det_addr VARCHAR(255) NULL     COMMENT '상세주소' -- 상세주소
)
COMMENT '회원';

-- 회원
ALTER TABLE p2_memb
    ADD CONSTRAINT PK_p2_memb -- 회원 기본키
        PRIMARY KEY (
            uno -- 회원번호
        );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_p2_memb
    ON p2_memb ( -- 회원
        email ASC -- 이메일
    );

-- 회원 인덱스
CREATE INDEX IX_p2_memb
    ON p2_memb( -- 회원
        name ASC -- 이름
    );

-- 회원 인덱스2
CREATE INDEX IX_p2_memb2
    ON p2_memb( -- 회원
        tel ASC -- 전화
    );

ALTER TABLE p2_memb
    MODIFY COLUMN uno INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 강의
ALTER TABLE p2_lect
    ADD CONSTRAINT FK_p2_mgr_TO_p2_lect -- 매니저 -> 강의
        FOREIGN KEY (
            mno -- 매니저번호
        )
        REFERENCES p2_mgr ( -- 매니저
            mno -- 회원번호
        );

-- 강의
ALTER TABLE p2_lect
    ADD CONSTRAINT FK_p2_cls_room_TO_p2_lect -- 강의실 -> 강의
        FOREIGN KEY (
            crno -- 강의실번호
        )
        REFERENCES p2_cls_room ( -- 강의실
            crno -- 강의실번호
        );

-- 학생
ALTER TABLE p2_stud
    ADD CONSTRAINT FK_p2_memb_TO_p2_stud -- 회원 -> 학생
        FOREIGN KEY (
            sno -- 회원번호
        )
        REFERENCES p2_memb ( -- 회원
            uno -- 회원번호
        );

-- 강사
ALTER TABLE p2_tchr
    ADD CONSTRAINT FK_p2_memb_TO_p2_tchr -- 회원 -> 강사
        FOREIGN KEY (
            tno -- 회원번호
        )
        REFERENCES p2_memb ( -- 회원
            uno -- 회원번호
        );

-- 매니저
ALTER TABLE p2_mgr
    ADD CONSTRAINT FK_p2_memb_TO_p2_mgr -- 회원 -> 매니저
        FOREIGN KEY (
            mno -- 회원번호
        )
        REFERENCES p2_memb ( -- 회원
            uno -- 회원번호
        );

-- 강의실사진
ALTER TABLE p2_cr_phot
    ADD CONSTRAINT FK_p2_cls_room_TO_p2_cr_phot -- 강의실 -> 강의실사진
        FOREIGN KEY (
            crno -- 강의실번호
        )
        REFERENCES p2_cls_room ( -- 강의실
            crno -- 강의실번호
        );

-- 강사배정
ALTER TABLE p2_tchr_lect
    ADD CONSTRAINT FK_p2_tchr_TO_p2_tchr_lect -- 강사 -> 강사배정
        FOREIGN KEY (
            tno -- 회원번호
        )
        REFERENCES p2_tchr ( -- 강사
            tno -- 회원번호
        );

-- 강사배정
ALTER TABLE p2_tchr_lect
    ADD CONSTRAINT FK_p2_lect_TO_p2_tchr_lect -- 강의 -> 강사배정
        FOREIGN KEY (
            lno -- 강의번호
        )
        REFERENCES p2_lect ( -- 강의
            lno -- 강의번호
        );

-- 강의과목
ALTER TABLE p2_tchr_subj
    ADD CONSTRAINT FK_p2_tchr_TO_p2_tchr_subj -- 강사 -> 강의과목
        FOREIGN KEY (
            tno -- 회원번호
        )
        REFERENCES p2_tchr ( -- 강사
            tno -- 회원번호
        );

-- 강의과목
ALTER TABLE p2_tchr_subj
    ADD CONSTRAINT FK_p2_subj_TO_p2_tchr_subj -- 과목 -> 강의과목
        FOREIGN KEY (
            sjno -- 과목번호
        )
        REFERENCES p2_subj ( -- 과목
            sjno -- 과목번호
        );