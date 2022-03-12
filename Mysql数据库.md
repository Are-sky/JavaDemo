# Mysql数据库基本操作

## 1.查看数据库 

show databases;

+---------------------------------+
| Database                       |
+---------------------------------+
| information_schema   |  主要存储系统中的一些数据库对象信息。比如用户表，列，字符集等等；
| mysql                             |  主要存储系统的用户权限信息；
| performance_schema |  主要存储的数据库服务器性能参数；
| sys                                  |  主要存储系统的元数据信息；
+---------------------------------+

注意：SQL语句不区分大小写；

## 2.创建数据库

create database 数据库名；

create database if not exists 数据库名；

数据库命名规则：

1.不能和已经存在的数据库重名；

2.由字母，数字，下划线，@，$符号组成；

3.标识符不能是Mysql的保留字；

4.不允许数据库中有空格以及特殊字符；

5.长度小于128位；

6.数据库一定要有实际意义，见名知意；

## 3.选择数据库

use 数据库名；

## 4.删除数据库

drop database 数据库名；

注意：

1.要删除数据库不存在，会报错；

安全删除方式：

drop database if exists 数据库名;

2.使用要谨慎，数据不能恢复！



# 存储引擎

提高MySQL数据库管理系统的使用灵活性以及使用效率

指定了表的类型，存储方式，索引数据，是否支持事务；

## 1.查看MySQL支持的存储引擎

show engines;

show variables;

show variables like 'have_%';

## 2.修改查看MySQL默认存储引擎

建立一个.ini文件，写入以下字符：

[mysqld]
#MySQL服务器的存储引擎
default-storage-engine = MyISAM



# 数据类型

## 数值类型

整数类型，浮点小数类型，定点小数类型；

1.整数类型	

名称					说明							字节				 	有符号				无符号

tinyint 				很小的整数				1字节				-128->127		 	0-255

smallint 			小的整数					2字节				-32768->32767	 0->65535

mediumint         中等整数					3字节				-2^23->2^23-1	0->2^24-1

int 						普通整数					4字节				-2^31->2^31-1	0->2^32-1

bigint 					大整数						8字节				-2^63->2^63-1	0-2^64-1



2.浮点型和定点型

floot(单精度浮点型)				4字节				一般精确到7位小数

-3.402823466E+38 -> -1.175494351E-38->0->1.175494351E-38->3.402823466E+38.

double(双精度浮点型)			8字节				一般精确到15位小数

-1.7976931348623157E+308->-2.2250738585072014E-308->0->2.2250738585072014E-308->1.7976931348623157E+308

浮点型和定点型 可以使用(m,n)的方式，M：精度(总共表示的位数)，N：标度(小数的位数)

float(5,2)；五位数，其中两位小数及 000.00；m,n可以省略，若省略，则值将存储到硬件允许的范围；

定点型：

dec或者decimal类型

dec(M,N)或decimal(M,N)    占M+2个字节以字符串存储 				M最大为65，N最大为30； 如果省略M，精度默认为10，省略N，标度默认为0；

如果要表示金额货币，有限选择decimal数据类型；

如果是float或double类型，存储数据的时候是近似值；



3.字符串类型

char(M) 		固定长度（声明多少是多少）0->255(长度)

varchar(M)	可变长度（用多少就是多少）0->65535(长度)

char(4),长度为4；

varchar(4),如果字符串长度为2，所占字节：2+1=3；类似与c语言的字符串；

节省空间: valchar

查询速度: char



4.text字符串类型

tinytext				0-255

text					   0-65535

mediumtext		0-2^24

longtext			   0-2^32



5.binary类型

binary(M)

valbinary(M)

只适合少量的二进制数据；



6.blob类型(二进制数据)

tinyblob					0->255

blob						   0->65535

mediumblob			0->2^24	

longblob					0->2^32

在数据库中几乎很少存储二进制类型数据，一般用于存储二进制文件的路径用char或valchar类型



7.日期和时间类型；

date 							4字节        1000-01-01 -> 9999-12-31

datetime 					8字节 		1000-01-01 00:00:00.000000 -> 9999-12-31 23:59:59.999999

timestamp				  4字节		1970-01-01 00:00:01.000000' UTC -> 2038-01-19 03:14:07.999999

time							 3字节		-838:59:59.000000 -> 838:59:59.000000

year							 1字节	    1000 -> 9999

## 数据表

``` sql
//create table 数据表名(内容)；
create table test_int(num1 tinyint,

num2 smallint,

num3 mediumint,

num4 int,

num5 bigint);

//默认为有符号型，若创建为无符号型则要在类型后面田间unsigned；

//查看数据库的表
show tables;

//查看表的结构
desc 数据表名;

//插入数据
insert into 数据表名
(num1,num2,num3,num4)
value
(数值1，数值2……);

//查询所有数据
select * from 数据表名;
```

## 表的操作

### 1.什么是表

数据在表中的组织方式是按照行和列的方式组织的

每一行表示一条的唯一记录，每一列表示记录中的一个字段；

### 2.使用数据库

use 数据库名;

![image-20220215182116526](C:\Users\77238\AppData\Roaming\Typora\typora-user-images\image-20220215182116526.png)

### 3.显示表

show tables;

![image-20220215182714691](C:\Users\77238\AppData\Roaming\Typora\typora-user-images\image-20220215182714691.png)

### 4.创建表

create table 表名(

字段名 数据类型,

字段名 数据类型

);

注意： 表名不能和已经存在的表同名；命名规则与数据库的名称的命名规则一样；



创建一个学生表：

create table student(

id int,

name varchar(10),

sex char(1),

age tinyint unsigned,

score float(4,1)

);



### 5.查看表的结构

desc 表名;

describe 表名;

![image-20220215183725553](C:\Users\77238\AppData\Roaming\Typora\typora-user-images\image-20220215183725553.png)

show create table 表名;

![image-20220215184025501](C:\Users\77238\AppData\Roaming\Typora\typora-user-images\image-20220215184025501.png)



### 6.删除表

drop table 表名;        drop table if exists 表名;

如果删除的表不存在则会报错；

删除多张表：

drop table 表名1,表名2;