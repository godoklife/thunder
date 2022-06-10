create table `thunder`.`product`(
	productno int unsigned primary key auto_increment not null,		-- pk
    productactive tinyint(1) not null default 1,					-- 1: 판매중, 2: 예약중, 3: 판매완료
    productqulity varchar(30) not null,								-- 제품 상태
    productprice int unsigned not null,								-- 제품 가격
    productcoordinate varchar(50),									-- 좌표
    boardpkno int unsigned not null,								-- FK, 게시판 프리머리키
    foreign key(boardpkno) references board(boardpkno) on delete cascade
);