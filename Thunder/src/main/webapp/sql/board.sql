CREATE TABLE `thunder`.`board`(
	boardpkno int unsigned primary key auto_increment not null,	-- 내부에서 사용할 PK
    boardcategory int1 not null,				-- 0~255
    boardcategoryno int unsigned not null,		-- 실제 게시판에서 표시하는 게시글 번호, 글 저장 직전 아작스에서 비동기식으로 마지막 글 번호 조회 후 +1 해서 저장할것
    boardtitle varchar(500) not null,			-- 한글 기준 최대 125자
    boardcontenttype varchar(50) not null,		-- 게시글 분류
    boardcontent text not null,		-- 게시글 내용
	boardviewcount int unsigned default 0,		-- 게시글 조회수, 기본값 0
    boarddatetime datetime default now(),		-- 게시글 작성 일시
    memberno int unsigned,								-- [ FK ]
    foreign key(memberno) references member(memberno)
);

