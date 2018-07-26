--@author ����
--@time 2018/7/12
--@apiNote ����sql server���ݿ�Ľű��ļ�
if exists (select 1
            from  sysobjects
           where  id = object_id('"user"')
            and   type = 'U')
   drop table "user"
go

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" (
   u_id                 bigint               not null           identity(1000,1),
   u_name               varchar(20)          not null,
   u_password           varchar(20)          not null,
   u_phone              varchar(20)          not null,
   u_address            varchar(20)          null,
   u_state              int                  null                default 1,
   constraint PK_USER primary key (u_id)
)
go
if exists (select 1
            from  sysobjects
           where  id = object_id('manager')
            and   type = 'U')
   drop table manager
go

/*==============================================================*/
/* Table: manager                                               */
/*==============================================================*/
create table manager (
   m_id                 bigint               not null           identity(1000,1),
   m_name               varchar(20)          not null,
   m_password           varchar(20)          not null,
   m_authority          int                  not null,
   constraint PK_MANAGER primary key (m_id)
)
go

if exists (select 1
            from  sysobjects
           where  id = object_id('car')
            and   type = 'U')
   drop table car
go

/*==============================================================*/
/* Table: car                                                   */
/*==============================================================*/
create table car (
   c_id                 bigint               not null           identity(1000,1),
   c_brand              varchar(20)          null,
   c_color              varchar(20)          null,
   c_price              varchar(20)          null,
   c_num                int                  null,
   c_catalog            varchar(20)          null,
   c_type               varchar(20)          null,
   c_energy             varchar(20)          null,
   c_style              varchar(20)          null,
   c_url                varchar(100)         null,
   c_state              int                  not null,
   constraint PK_CAR primary key (c_id)
)
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"order"') and o.name = 'FK_ORDER_REFERENCE_USER')
alter table "order"
   drop constraint FK_ORDER_REFERENCE_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"order"') and o.name = 'FK_ORDER_REFERENCE_CAR')
alter table "order"
   drop constraint FK_ORDER_REFERENCE_CAR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"order"')
            and   type = 'U')
   drop table "order"
go

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table "order" (
   o_id                 bigint               not null           identity(1000,1),
   c_id                 bigint               not null,
   u_id                 bigint               not null,
   o_time               datetime             not null           default getdate(),
   o_state              int                  not null,
   constraint PK_ORDER primary key (o_id)
)
go

alter table "order"
   add constraint FK_ORDER_REFERENCE_USER foreign key (u_id)
      references "user" (u_id)
go

alter table "order"
   add constraint FK_ORDER_REFERENCE_CAR foreign key (c_id)
      references car (c_id)
go
if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('collection') and o.name = 'FK_COLLECTI_REFERENCE_USER')
alter table collection
   drop constraint FK_COLLECTI_REFERENCE_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('collection') and o.name = 'FK_COLLECTI_REFERENCE_CAR')
alter table collection
   drop constraint FK_COLLECTI_REFERENCE_CAR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('collect')
            and   type = 'U')
   drop table collect
go

/*==============================================================*/
/* Table: collect                                               */
/*==============================================================*/
create table collect (
   u_id                 bigint               not null,
   c_id                 bigint               null
)
go

alter table collect
   add constraint FK_COLLECTI_REFERENCE_USER foreign key (u_id)
      references "user" (u_id)
go

alter table collect
   add constraint FK_COLLECTI_REFERENCE_CAR foreign key (c_id)
      references car (c_id)
go
--@author ���˰�
--@time 2018/7/12
--@apiNote �������ݿ��ʼ����
insert INTO dbo.[user](u_name,u_password,u_phone,u_address) VALUES 
('Tom','123456','13911112222','������'),
('Jerry','234567','13933334444','������'),
('Sam','345678','13955556666','�Ϻ���');
insert INTO dbo.manager(m_name,m_password,m_authority) VALUES
('Tim','456789',1),
('Jack','567890',2),
('Selina','678901',3);
insert INTO dbo.car(car.c_brand,car.c_color,car.c_price,car.c_num,c_url,c_state,car.c_catalog,car.c_type,car.c_energy,car.c_style) VALUES
('��������','��ɫ','14��Ԫ',1,'http://img1.gtimg.com/datalib_img//18-05-11/4/3f42992c6627f22fb4ec3701f3b1d6f1.jpg',1,'SUV','����',null,null),
('���ǵ�S7','��ɫ','18��Ԫ',2,'http://img1.gtimg.com/datalib_img//16-10-24/1/e1fa8f083fae1705874b754dc07a646910.jpg',1,'SUV','����',null,null),
('Urus','��ɫ','12��Ԫ',6,'http://img1.gtimg.com/datalib_img//12-04-26/f/f10655d7d4ed4cc235ba79aec0bb1fc510.jpg',1,'SUV','����',null,null),
('����W5','��ɫ','20��Ԫ',3,'http://img1.gtimg.com/datalib_img//15-05-06/3/a4dd9320b495e5f692961fa0163c373010.jpg',1,'NEV',null,'���綯',null),
('����S2','��ɫ','10��Ԫ',4,'http://img1.gtimg.com/datalib_img//14-06-16/4/9baae1b92e2a11ae91fd31fa35c120cd10.jpg',1,'NEV',null,'�͵���',null),
('���װ�','��ɫ','19��Ԫ',7,'https://c2.xinstatic.com/f3/20180514/0930/5af8e6c4249e2641329_27.jpg',1,'NEV',null,'�͵���',null),
('����M��','��ɫ','11��Ԫ',5,'http://img1.gtimg.com/datalib_img//15-05-06/5/dfb426e9069e32d182b6f4f5938e35eb10.jpg',1,'sportCar',null,null,'����'),
('���׵�','��ɫ','21��Ԫ',8,'http://img1.gtimg.com/datalib_img//15-06-11/2/c21b3c8f139b213c7616888a5f64bc5810.jpg',1,'sportCar',null,null,'�ǳ���'),
('ȫ��ʤ��','��ɫ','5��Ԫ',9,'http://img1.gtimg.com/datalib_img//15-07-08/8/9c445d9b26fc788394f6a779bd2a42ae10.jpg',1,'sportCar',null,null,'����'),
('������','��ɫ','50��Ԫ',10,'http://img1.gtimg.com/datalib_img//16-09-26/d/f840f650793183e82cda31791de9ea5110.jpg',1,'sportCar',null,null,'�ǳ���');
--@author ����
--@time 2018/7/12
--@apiNote ���Ƕ�������Ĵ洢����,����ֵresult��(1.�����ɹ���0.����ʧ��)
drop proc p_order;
create proc p_order
@u_id bigint,
@c_id bigint
as 
declare @result int;
--�������
if((select car.c_num from dbo.car where car.c_id=@c_id)>0)
    --�޸Ŀ����Ϣ
	begin
	update dbo.car set c_num=c_num-1 where c_id=@c_id;
	--�洢������Ϣ
	insert INTO dbo.[order](c_id,u_id,o_state) VALUES (@c_id,@u_id,1);
	set @result=1;
	end
else
    set @result=0;
SELECT @result;
go
--����p_order OK
exec p_order 1000,1005
select * from dbo.[order];
select * from dbo.car;
select * from dbo.manager;
select * from dbo.[user];
select * from dbo.collect;
update dbo.[user] set u_state=1 WHERE [user].u_id=1000;
select * from dbo.car where car.c_catalog='sportCar';
insert into collect values(1000,1005);
insert into collect values(1000,1006);
update car set c_num=5 where c_id=1000;
