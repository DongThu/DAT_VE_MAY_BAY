create database ariline_data character set='utf8';
use ariline_data;

show tables;

create table ql_chuyenbay(
	CB_id int(10) primary key,
	CB_noidi varchar(20) not null,
    CB_noiden varchar(20) not null,
    CB_ngaybay varchar(50) not null,
    CB_soGhengoi int(10) not null
);

create table ql_hanhkhach(
	HK_id int(10) primary key,
	HK_ten varchar(20) not null,
    HK_gioitinh varchar(10) not null,
    HK_sohochieu varchar(20) not null,
    HK_sdt varchar(10) not null,
    HK_diachi varchar(50) not null,
    HK_quoctich varchar(15) not null
);

create table ql_loaive(
	LV_loai varchar(15) primary key,
    LV_gia int(20) not null,
    LV_phipv int(20) not null,
    LV_phuthu int(20) not null
);

create table ql_datve(
	DV_id int(10) primary key,
    HK_id int(10) not null,
	HK_ten varchar(20) not null,
    CB_id int(10) not null,
 --    HK_gioitinh varchar(10) not null,
    HK_sohochieu varchar(20) not null,
	HK_quoctich varchar(20) not null,
    DV_soluong int(10) not null,
    DV_ngaydat varchar(20) not null,
	LV_loai varchar(15) not null,
	foreign key (CB_id) references ql_chuyenbay(CB_id),
	foreign key (HK_id) references ql_hanhkhach(HK_id),
    foreign key (LV_loai) references ql_loaive(LV_loai)
);
describe ql_datve;

insert into ql_chuyenbay values
	('101','SB Cần Thơ','SB Tân Sơn Nhất','2022-05-03',100),
    ('102','SB Cần Thơ','SB Vân Đồn','2022-05-04',75),
    ('103','SB Đà Nẵng','SB Vinh','2022-05-03',100),
    ('104','SB Vinh','SB Đà Nẵng','2022-05-03',100),
    ('105','SB Phú Quốc','SB Cát Bi','2022-05-02',150),
    ('106','SB Nội Bài','SB Tân Sơn Nhất','2022-05-04',150);
select * from ql_chuyenbay;

insert into ql_hanhkhach values
	(100,'Trương Thị Cẩm Tiên','Nữ','111111','012345671','Cần Thơ','Việt Nam'),
    (200,'Đồng Thị Anh Thư','Nữ','222222','012345672','Bạc Liêu','Việt Nam'),
    (300,'Đặng Hoài An','Nam','333333','012345673','Hà Nội','Việt Nam'),
    (400,'Akira','Nam','444444','012345674','Tokyo','Nhật Bản'),
    (500,'Emma','Nữ','555555','012345675','Luân Đôn','Anh');
select * from ql_hanhkhach;

insert into ql_loaive values
	('TN_t',500000,200000,100000),
	('TN_vip',700000,300000,100000),
	('NN_t',1000000,200000,100000),
	('NN_vip',1500000,300000,100000);
select * from ql_loaive;

insert into ql_datve values
	(111,100,'Trương Thị Cẩm Tiên','103','111111','Việt Nam',1,'2022-04-28','TN_t'),
    (222,200,'Đồng Thị Anh Thư','101','222222','Việt Nam',1,'2022-04-30','TN_t'),
    (333,300,'Đặng Hoài An','102','333333','Việt Nam',2,'2022-04-28','TN_vip'),
    (444,400,'Akira','104','444444','Nhật Bản',1,'2022-05-01','NN_vip'),
    (555,500,'Emma','105','555555','Anh',2,'2022-04-28','NN_t');
select * from ql_datve;

/*1. Thêm chuyến bay*/
delimiter $
create procedure themCB(CB_id int(10),CB_noidi varchar(20), CB_noiden varchar(20), CB_ngaybay varchar(50), CB_soGhengoi int(10))
begin
	insert into ql_chuyenbay values (CB_id, CB_noidi, CB_noiden, CB_ngaybay, CB_soGhengoi);
end $
delimiter ;
call themCB('107','SB Tân Sơn Nhất','SB Vinh','2022-05-05',120);
call themCB('108','SB Tân Sơn Nhất','SB Nhật Bản','2022-05-06',100);
call themCB('109','SB Cần Thơ','SB Anh','2022-05-02',150);
select * from ql_chuyenbay;

/*2. Xoá chuyến bay*/
delimiter $
create procedure xoaCB(CB_id int(10))
begin 
	if exists (select CB_id from ql_chuyenbay cb where cb.CB_id=CB_id)
	then 
		delete from ql_datve where ql_datve.CB_id=CB_id;
		DELETE FROM ql_chuyenbay WHERE ql_chuyenbay.CB_id = CB_id;
	end if;
end $
delimiter ;
call xoaCB('107');
select * from ql_chuyenbay;
select * from ql_datve;

/*3. Cập nhật chuyến bay*/
/*Theo số ghế*/
delimiter $
create procedure ud_soghe(CB_id varchar(10),CB_soGhengoi int(10))
begin 
	if exists (select CB_id from ql_chuyenbay cb where cb.CB_id=CB_id)
	then 
		update ql_chuyenbay
		set ql_chuyenbay.CB_soGhengoi=CB_soGhengoi
		WHERE ql_chuyenbay.CB_id = CB_id;
	end if;
end $
delimiter ;
call ud_soghe('CB006',120);
select * from ql_chuyenbay;

/*Theo ngày bay*/
delimiter $
create procedure ud_ngaybay(CB_id int(10),CB_ngaybay varchar(10))
begin 
	if exists (select CB_id from ql_chuyenbay cb where cb.CB_id=CB_id)
	then 
		update ql_chuyenbay
		set ql_chuyenbay.CB_ngaybay=CB_ngaybay
		WHERE ql_chuyenbay.CB_id = CB_id;
	end if;
end $
delimiter ;
call ud_ngaybay('106','2022-05-04');
select * from ql_chuyenbay;

/*4. Tìm kiếm chuyến bay*/
delimiter $
create procedure tim_CB(CB_id int(10))
begin
	if exists (select CB_id from ql_chuyenbay cb where cb.CB_id=CB_id)
	then 
		select * from ql_chuyenbay where ql_chuyenbay.CB_id=CB_id;
	end if;
end $
delimiter ;
call tim_CB('108');

/*5. Thêm hành khách*/
delimiter $
create procedure themHK(HK_id int(10), HK_ten varchar(20), HK_gioitinh varchar(10), HK_sohochieu varchar(20), HK_sdt varchar(10), HK_diachi varchar(50), HK_quoctich varchar(15))
begin
	insert into ql_hanhkhach values (HK_id, HK_ten, HK_gioitinh, HK_sohochieu, HK_sdt, HK_diachi, HK_quoctich);
end $
delimiter ;
call themHK(600,'Chey','Nam','666666','012345676','Phnom Penh','Campuchia');
call themHK(700,'Camille','Nữ','777777','012345677','Paris','Pháp');
select * from ql_hanhkhach;

/*6. Xoá hành khách*/
delimiter $
create procedure xoaHK(HK_id int(10))
begin 
	if exists (select HK_id from ql_hanhkhach hk where hk.HK_id=HK_id)
	then 
		delete from ql_datve where ql_datve.HK_id=HK_id;
		DELETE FROM ql_hanhkhach WHERE ql_hanhkhach.HK_id = HK_id;
	end if;
end $
delimiter ;
call xoaHK(900);
select * from ql_hanhkhach;
select * from ql_datve;

/*7. Cập nhật hành khách*/

/*Theo tên*/
delimiter $
create procedure ud_ten(HK_id int(10), HK_ten varchar(20))
begin 
	if exists (select HK_id from ql_hanhkhach where ql_hanhkhach.HK_id=HK_id)
	then 
		update ql_hanhkhach
		set ql_hanhkhach.HK_ten=HK_ten
		WHERE ql_hanhkhach.HK_id = HK_id;
	end if;
end $
delimiter ;
call ud_ten(300,'Đặng Hoài An');
select * from ql_hanhkhach;

/*Giới tính*/
delimiter $
create procedure ud_gt(HK_id int(10), HK_gioitinh varchar(10))
begin 
	if exists (select HK_id from ql_hanhkhach where ql_hanhkhach.HK_id=HK_id)
	then 
		update ql_hanhkhach
		set ql_hanhkhach.HK_gioitinh=HK_gioitinh
		WHERE ql_hanhkhach.HK_id = HK_id;
	end if;
end $
delimiter ;
call ud_gt(300,'Nam');
select * from ql_hanhkhach;

/*Theo số điện thoại*/
delimiter $
create procedure ud_sdt(HK_id int(10), HK_sdt varchar(20))
begin 
	if exists (select HK_id from ql_hanhkhach where ql_hanhkhach.HK_id=HK_id)
	then 
		update ql_hanhkhach
		set ql_hanhkhach.HK_sdt=HK_sdt
		WHERE ql_hanhkhach.HK_id = HK_id;
	end if;
end $
delimiter ;
call ud_sdt(400,'012345674');
select * from ql_hanhkhach;

/*Theo địa chỉ*/
delimiter $
create procedure ud_diachi(HK_id int(10), HK_diachi varchar(20))
begin 
	if exists (select HK_id from ql_hanhkhach where ql_hanhkhach.HK_id=HK_id)
	then 
		update ql_hanhkhach
		set ql_hanhkhach.HK_diachi=HK_diachi
		WHERE ql_hanhkhach.HK_id = HK_id;
	end if;
end $
delimiter ;
call ud_diachi(100,'Cần Thơ');
select * from ql_hanhkhach;


/*Theo số hộ chiếu*/
delimiter $
create procedure ud_sohochieu(HK_id int(10), HK_sohochieu varchar(20))
begin 
	if exists (select HK_id from ql_hanhkhach where ql_hanhkhach.HK_id=HK_id)
	then 
		update ql_hanhkhach
		set ql_hanhkhach.HK_sohochieu=HK_sohochieu
		WHERE ql_hanhkhach.HK_id = HK_id;
	end if;
end $
delimiter ;
call ud_sohochieu(100,'111111');
select * from ql_hanhkhach;

/*Theo quốc tịch*/
delimiter $
create procedure ud_quoctich(HK_id varchar(10), HK_quoctich varchar(15))
begin 
	if exists (select HK_id from ql_hanhkhach where ql_hanhkhach.HK_id=HK_id)
	then 
		update ql_hanhkhach
		set ql_hanhkhach.HK_quoctich=HK_quoctich
		WHERE ql_hanhkhach.HK_id = HK_id;
	end if;
end $
delimiter ;
call ud_quoctich('100','Việt Nam');
select * from ql_hanhkhach;


/*8. Tìm kiếm hành khách*/
delimiter $
create procedure tim_HK(HK_id int(10))
begin
	if exists (select HK_id from ql_hanhkhach hk where hk.HK_id=HK_id)
	then 
		select * from ql_hanhkhach where ql_hanhkhach.HK_id=HK_id;
	end if;
end $
delimiter ;
call tim_HK(100);

/*9.Đặt vé*/
delimiter $
create procedure datve(DV_id int(10), HK_id int(10), HK_ten varchar(20), CB_id int(10), HK_sohochieu varchar(20), HK_quoctich varchar(20), DV_soluong int(10), DV_ngaydat varchar(20), LV_loai varchar(15))
begin
	insert into ql_datve values (DV_id, HK_id, HK_ten, CB_id, HK_sohochieu, HK_quoctich, DV_soluong, DV_ngaydat, LV_loai);
end $
delimiter ;
call datve(666,600,'Chey','106','666666','Campuchia',2,'2022-04-28','NN_vip');
select * from ql_datve;

/*10. Huỷ vé*/
delimiter $
create procedure huyve(DV_id int(10))
begin 
	if exists (select DV_id from  ql_datve dv where dv.DV_id=DV_id)
	then 
		delete from ql_datve where ql_datve.DV_id=DV_id;
	end if;
end $
delimiter ;
call huyve(666);
select * from ql_datve;

/*11.Lọc hành khách theo giới tính*/
select * from ql_hanhkhach;
delimiter $
create procedure tim_theogt(HK_gioitinh varchar(10))
begin
	if exists (select HK_gioitinh from ql_hanhkhach hk where hk.HK_gioitinh=HK_gioitinh)
	then 
		select * from ql_hanhkhach where ql_hanhkhach.HK_gioitinh=HK_gioitinh;
	end if;
end $
delimiter ;
call tim_theogt('Nữ');

/*11.2. Lọc hành khách theo loại vé*/
delimiter $
create procedure tim_hkloaive(LV_loai varchar(15))
begin 
	if exists (select DV_id from  ql_datve dv where dv.LV_loai=LV_loai)
	then 
		select * from ql_datve where ql_datve.LV_loai=LV_loai;
	end if;
end $
delimiter ;
call tim_hkloaive('TN_vip');

/*them loai*/
delimiter $
create procedure themloai(LV_loai varchar(15), LV_gia int(20), LV_phipv int(20), LV_phuthu int(20))
begin
	insert into ql_loaive values (LV_loai, LV_gia, LV_phipv , LV_phuthu);
end $
delimiter ;

/*12. Lọc chuyến bay theo ngày*/
select * from ql_chuyenbay;
delimiter $
create procedure tim_cbtheongay(CB_ngaybay varchar(10))
begin
	if exists (select CB_ngaybay from ql_chuyenbay cb where cb.CB_ngaybay=CB_ngaybay)
	then 
		select * from ql_chuyenbay where ql_chuyenbay.CB_ngaybay=CB_ngaybay;
	end if;
end $
delimiter ;
call tim_cbtheongay('2022-05-03');

/*13.Tính giá tiền mỗi hành khách phải trả*/
delimiter $
create procedure tinhtien(IN DV_id int(10), OUT tien double)
begin 
	set tien=-1;
    select DV_soluong*(LV_gia+LV_phipv+LV_phuthu+((LV_gia+LV_phipv+LV_phuthu)*0.1)) INTO tien
		from ql_datve inner join ql_loaive on ql_datve.LV_loai=ql_loaive.LV_loai
        where ql_datve.DV_id=DV_id;
end $

delimiter $
create function tinh_tien(DV_id int(10))
returns double
begin
	declare kq double;
	if exists (select DV_id from ql_datve where ql_datve.DV_id=DV_id)
	then 
		select DV_soluong*(LV_gia+LV_phipv+LV_phuthu+((LV_gia+LV_phipv+LV_phuthu)*0.1)) INTO kq
		from ql_datve inner join ql_loaive on ql_datve.LV_loai=ql_loaive.LV_loai
						where ql_datve.DV_id=DV_id;
	else set kq=-1;
    end if;
    return kq;
end$
delimiter ;

set @tien=0;
call tinhtien('333',@tien);
select @tien;
select tinh_tien('111');
select DV_id,HK_id,HK_ten,CB_id, DV_soluong, LV_loai,tinh_tien(DV_id) as doanhthu from ql_datve;


/*14. danh sách chưa có vé*/
select * from ql_datve;
delimiter $
create procedure ds_chuacove()
begin
	if exists (select DV_id from ql_datve dv where dv.DV_id=DV_id)
	then 
		select * from ql_hanhkhach 
		where HK_id NOT IN (select distinct HK_id from ql_datve);
	end if;
end $
delimiter ;
call ds_chuacove();

/*15. tính doanh thu đặt vé trong ngày*/
delimiter $
create function doanhthu_ngay(DV_ngaydat varchar(20))
returns double
begin
	declare dt double;
	if exists (select distinct DV_ngaydat from ql_datve where ql_datve.DV_ngaydat=DV_ngaydat)
	then 
		select sum(tinh_tien(DV_id)) INTO dt
		from ql_datve where ql_datve.DV_ngaydat=DV_ngaydat;
	else set dt=-1;
    end if;
    return dt;
end$
delimiter ;

set @dt=0;
select @dt;
select doanhthu_ngay('2022-04-28');
select distinct DV_ngaydat,doanhthu_ngay(DV_ngaydat) from ql_datve;

/*15.2. Ngày có doanh thu cao nhất*/
select distinct DV_ngaydat,max(doanhthu_ngay(DV_ngaydat)) from ql_datve;


