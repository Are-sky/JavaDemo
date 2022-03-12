# Java学习！

##   第一天

###    Hello World

```java
// 第一行的第三个单词必和文件名一样
// public class 后面代表定义一个类的名称 类是Java当中所有源码的基本组织单位。
public class Main {
    //第二行代表main方法
    //执行程序的起点
    public static void main(String[] args) {
        //输入输出语句
        System.out.println("hello world");
    }
}
```

### 基本数据类型

整数型  byte short int long

浮点型 float double 

字符型 char 

布尔型 boolean

P.S float的数据范围比long大

自动类型转换：可以从小到大转（数据范围）

强制类型转换：可以大到小，也可以小到大；（一般不推荐使用，可能会发生数据精度缺失）

byte /shot/char运算时首先提升为int型；

```java
public class Main {
    public static void main(String[] args) {
        byte num1 = 40;
        byte num2 = 50;
        byte num3 = num1 + num2; //编译出错！
        //byte + byte -->int + int-->int
        //同理：
        //short + byte --> int + int-->int
        //解决方法：使用强制类型转换;
        //但必须注意保证逻辑上的数据范围！
    }
}
```

boolean型不能发生强制类型转换！

int + double --> double + double -->double



# 第二天

## 四则运算

###  +号

对于字符串来说“+”号代表着字符串连接操作！任何数据类型和字符串进行连接时，结果都会变成字符串；



### 自增 自减

前置：变量先自增（减），后使用；

后置：变量先使用，后自增（减）；

## 方法

### 定义方法

```java
/*
一个格式:
public static void 方法名 (){
	方法体；
}
不能嵌套定义；
*/
public class Demo{
    public static void main(String[] args){
        Prin();
    }
    
    public static void Prin(){
        System.out.println("方法");
    }
}
/*
完整格式：
修饰符 返回值类型 方法名(参数类型 参数名，.....){
	方法体；
	return 返回值；
}
*/
public class Demo1{
    public static void main(String[] args){
       System.out.println(Add(10,16));
    }
    
    public static int Add(int a,int b){
        return a+b;
    }
}
```

## 第三天

### 方法重载

多个方法的名称一样，但是参数列表不同；

与下列因素有关：

1.参数个数不同；

2.参数类型不同；

3.参数的多类型顺序不同；



与下列因素无关：

1.参数名称无关；

2.返回值类型无关；



### 数组

初始化数组：

动态(指定长度)：   数据类型[] 数组名称 = new 数据类型[数组长度];

元素自动初始化为0(整型)/0.0(浮点型)/'\u0000'(字符型)/false(布尔型)/null(引用类型  )；



静态(指定内容)：   数据类型[] 数组名称 = new 数据类型[] { 元素1, 元素2,};

静态省略格式：     数据类型[] 数组名称 = { 元素1, 元素2,};.





### 面向对象

“静态创建对象指的是在栈上创建对象,比如A a;它会在对象的作用域结束后自动销毁. 动态创建对象指的是在堆上创建对象,然后栈上的指针指向创建的对象.比如A *pa = new A();它需要程序员手动delete掉.如果不进行delete操作,只能等到程序结束后,由OS来回收掉.

#### 类

```java
public class Student {
 	// 成员变量  定义在方法外，类里面
    int age;
    String name;
    // 成员方法  成员方法不要写static关键字
    public void eat() {} //吃
    public void drink() {} //喝
    public void play() {} //玩
    public void sleep() {} //睡
}
```

通常情况下，一个类不能直接使用，需要根据类创建一个对象，才能使用；

1.导包

```java
import 包名称.类名称
对于和当前类属于同一个包的情况，可以省略；
只有java.lang包下的内容不用导包，其他的包都需要import语句
```

2.创建

```java
类名称 对象名 = new 类名称();
Student stu = new Student();
```

3.使用

使用成员变量： 对象名.成员变量

使用成员方法： 对象名.成员方法

## 第四天

### Scanner类

可以实现键盘输入数据到程序中；

```java
//导包
import java.util.Scanner;

public class Sca {
    public static void main(String[] args) {
        //创建
        //备注：System.in代表从键盘进行输入
        Scanner sc = new Scanner(System.in);
     	//使用
        int num = sc.nextInt(); //获取数字
        String str = sc.next(); //获取字符串 
    }

}
```

## 匿名对象

```java
public class Person {
   	String name;
 	public void Showname(){
        System.out.println(name);
    }
}

public class Main {
    public static void main(String[] args) {
        new Person().name = "邱";
        //Scanner 
        int num = new Scanner(System.in).nextInt();
        
        //匿名对象传参
        Niin(new Scanner(System.in));
        
        //返回匿名对象
        Scanner sc = niout();
        int num1 = sc.nextInt();
        System.out.println(num1);
    }
    
    public static void Niin(Scanner sc){
        int num = sc.nextInt();
        System.out.println(num);
    }
    
    public static Scanner Niout(){
        /*Scanner sc = new Scanner(System.in);
        return sc;*/
        return new Scanner(System.in);
    }
}
```

使用建议：如果确定有一个对象只需要使用唯一一次，就可以使用匿名对象；

注意事项：匿名对象只能使用唯一的一次，下次使用不得不再创建一个对象；

## Random类

```java
import java.util.Random
    
public class Ra {
    public static void main(String[] args){
    	Random r = new Random();
    	//获取一个随机的int型数字（范围为int的数据范围）
    	int num = r.nextInt();
        //获取一个随机的int型数字（范围为参数，左闭右开）
    	int num = r.nextInt(3); //[0,3)
        int num1 = r.nextInt(3); //[1,4) 
    }
}
```

## ArrayList类

ArrayList类集合不同于数组，数组长度不可变，ArrayList长度可变；

< E > 泛型 代表着装在集合中的所有元素都是同一类型；注意 只能是引用类型，不能是基本类型；

对于ArrayList集合来说，直接打印得到的不是地址值，而是内容；若内容为空，则得到空的中括号；

```java
public class demoArray {
    public static void main(String[] args) {
        //ArrayList
        //创建了一个ArrayList集合，集合名称为list，里面装的是String类型数据
        //备注：从JDK1.7+开始，右侧尖括号内部可空，但尖括号仍需要存在！
        ArrayList<String> list  =  new ArrayList<>();

        /*
        常用方法
        public boolean add(E  e); 向集合当中添加元素，参数的类型和泛型一致。返回值代表是否成功；

        public E get(int index);  从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素；

        public E remove(int index); 从集合当中删除元素，参数是索引编号，返回值就是被删除的元素；

        public int size();      获取集合的尺寸长度，返回值为集合中包含的元素个数；
        */

        //添加元素 add
        boolean success = list.add("qiu");
        System.out.println(list);
        list.add("wu");
        list.add("lu");
        System.out.println(list); //[qiu, wu, lu]

        //获取元素 get
        String name = list.get(1);
        System.out.println(name); //wu

        //删除元素 remove
        String whoremove = list.remove(1);
        System.out.println(whoremove);  //wu
        System.out.println(list);       //[qiu, lu]

        //集合长度 size
        int size = list.size();
        System.out.println("集合的长度是" + size);

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        
    }
}
```

如果希望向集合ArrayList当中存储基本类型数据，必须使用基本类型对于的包装类

```java
/*
基本类型      包装类（引用类型，包装类都位于Java.lang包下）
byte		Byte
short		Short
int			Integer
long 		Long
float		Float
double		Double
char		Character
boolean		Boolean
*/
public class demoArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        System.out.println(list); //[100, 200]
        int num = list.get(1);
        System.out.println("第一号元素是" + num); //第一号元素是200
    }
}
```

## 第五天

### String类

String类代表字符串；字符串是常量；

字符串的效果相当于是char[]字符数组，但底层原理是byte[]字节数组；

```java
//三种构造方法
public String()；				//创建一个空白字符串，不含有任何内容
    
    String str1 = new String();

public String(char[] Array);	//根据字符数组的内容，来创建对应的字符串

	char[] array = {'a','b','c'};
	String str2 = new String(array);

public String(byte[] array); 	//根据字节数组的内容，来创建对应的字符串

	byte[] array1 = {97,98,99};
	String str3 = new String(array1);

//一种直接创建
String str4 = "abc";			//字符串常量池(在堆中)：程序当中直接写上的双引号字符串，就在字符串常量池中；
String str5 = "abc";

//注意：
str4 == str2  					//返回值为false
str5 == str4					//返回值为true 地址值一样因为字符串为常量具有可共享的属性
    /*
    	对于基本类型来说；==是进行数值比较
    	对于引用类型来说；==是进行地址值的比较
    */
    
    
//常用方法

/*字符串内容比较
    public boolean equals(Object obj):参数可以是任何对象，只有参数是一个字符串且内容相同才会返回true
	任何对象都可以用object接收
	
	public boolean equalsIgnoreCase(String str); 忽略大小写进行比较
*/
    str4.equals(str2); -->true
    "abc".equals(str2); -->true		//推荐 “abc”.equals(str); 若str为null时,上一种方法会报错空指针异常
    
/*字符串获取方法
	public int length(); 				//获取字符串长度
	public String concat(String str);	//拼接字符串
	public char charAt(int index);		//获取指定索引位置的字符
	public int indexOf(String str);		//查找参数字符串在本字符串出现的首个索引位置，无则返回-1
*/
    
/*字符串截取方法
	public String substring(int index);			//截取从参数位置到最后的字符串
	public String substring(int begin,int end);	//截取[begin,end)范围的字符串
*/
    
/*字符串转换方法
	public char[] toCharArray();			//当前字符串拆分成字符数组
	public byte[] getBytes();				//当前字符串拆分成字节数组
	public String replace(CharSequence oldString,CharSequence newString);
	将所有出现的老字符串替换成新的字符串，返回替换之后的新字符串；
	CharSequence 可以接收字符串
*/

/*字符串截取方法
	public String[] split(String regex); 		//按照参数规则切割字符串			
*/
```

# 第六天

### static静态

一旦使用static关键字，那么这样的内容不再属于对象自己，而是属于类的，所以凡是本类的对象，都共享同一份； 

一旦使用static修饰成员方法，那么这就成为了静态方法。静态方法不属于对象，属于类；

如果没有static关键字，那么必须先创建对象，然后通过对象才能使用成员方法；

对于静态方法来说，可以通过对象名进行调用，也可以直接通过类名称来调用；

P.s 静态不能直接访问非静态；原因：在内存当中先有的静态内容，后有的非静态内容；

​      静态方法当中不使用this关键字；

```java
public class Student {

    private  int id;					
    private String name;
    private int age;
    static String Room;
    private  static int idCounter = 0;   //每当new一个新对象的时候计数器++

    public Student() {
        this.id = ++idCounter;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static void Staticmethod(){
        System.out.println("静态方法");
    }
    
    public void method(){
        System.out.println("对象方法");
    }
}

public class Main{
    public static void main(String[] args){
        //首先创建对象
        Student one = new Student()；
        //然后才能调用无static关键字的方法
        one.method();
        //静态方法：两者都正确，但推荐使用第二种方法；
        one.Staticmethod();			
        Student.Staticmethod();
    }
}
/*
静态代码块：
public class 类名称{
	static {
		//静态代码块内容
	}
}
特点：当第一次用到本类时，静态代码块执行唯一的一次；
静态内容总是优先于非静态，所以静态代码块比构造方法先执行；
典型用途：
用来一次性地对静态成员变量进行赋值；
*/

public class Person{
    static{
        System.out.println("静态代码块");
    }
}
```

## Arrays类

java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见操作；

```java
public static String toString(数组):将参数数组变成字符串(按照默认格式：[元素1，元素2，元素3])；

public static void sort(数组): 将参数数组升序排序（字符按字典序）；
如果是自定义的类型，那么这个自定义的类需要有Comparable或Comparator接口支持；
```

## Math类

java.util.Math是一个与数学相关的工具类，里面提供了大量静态方法，用来实现数学常见操作；

```java
public static double abs(double num):获取绝对值
public static double ceil(double num):向上取整
public static double floot(double num):向下取整
public static long round(double num):四舍五入
Math.PI Π的近似值
```

## 第七天

### 面向对象

三大特征：封装性，继承性，多态性；

继承是多态的前提；如果没有继承，就没有多态；

继承主要解决的问题就是：**共性抽取**

共性存放于父类，也叫基类，超类；

特殊的存放于子类，也叫派生类；

继承关系中的特点：

1.子类可以拥有父类的“内容”；

2.子类还可以拥有自己的专属内容；

```java
/*
	在继承的关系中，“子类就是一个父类”；也就是说，子类可以被当成父类看待；
	例如父类是员工，子类是讲师，那么“讲师就是一个员工”。关系：is-a；
	
	定义父类格式：
	public class 父类名称{
		//.....
	}
	
	定义子类格式:
	public class 子类名称 extends 父类名称{
		//.....	
	}
	
	在父子类的继承关系当中，如果成员变量重名，则创建子类对象时，访问有两种方式：
	1.直接通过子类对象访问成员变量
		(new的时候)等号左边是谁就优先用谁，没有则向上找；
	2.间接通过成员方法访问成员变量
		方法是哪类的就优先使用哪类的成员变量，无则向上找；
		
	局部变量：				直接写成员变量名
	本类的成员变量：		  this.成员变量名
	父类的成员变量：		  super.成员变量名
	
	在父子类的继承关系当中，创建子类对象，访问成员方法的规则：
		创建的对象是谁就优先用谁；无则向上找；
		
	方法的重写（Override）
	概念：在继承关系当中，方法名称一样，参数列表也一样；
	方法的覆盖重写特点：创建的是子类对象，则优先使用子类方法；
	注意：
	1.必须保证父子类之间的方法名称相同，参数列表也相同；
	@Override：写在方法前面用来检测是不是有效的覆盖重写；
	这个注解就算不写，只要满足要求，也是正确的方法覆盖重写；
	2.子类方法的返回值必须小于等于父类方法的返回值范围；
	object类是所有类的公共最高父类（祖宗类），java.lang.String就是Object的子类；
	3.子类方法的权限必须大于等于父类方法的权限修饰符；
	public > protected > (default) > private
	备：(default)不是关键字default，而是什么都不写，留空；
	
	设计原则：
	对于已经投入使用的类，尽量不要进行修改；
	推荐定义一个新的类，来重复利用其中的共性内容，并添加改动的新内容；
	
	继承关系中，父子类构造方法的访问特点：
	1.子类构造方法当中有个隐含的“super()”调用（先构造父类后构造子类）；每当new上一个子类，系统便会new上一个父类；
	2.可以通过super关键字来子类构造调用父类重载构造方法；
	3.super的父类构造调用，必须是子类构造方法的第一个语句，不能一个子类构造方法中调用多次super构造；
	4.子类必须调用父类构造方法，不写系统自动补充super()；写了则用指定的super调用方法；
	
	super关键字：
	1.在子类的成员方法中，访问父类的成员变量；
	2.在子类的成员方法中，访问父类的成员方法；
	3.在子类的构造方法中，访问父类的构造方法；
	
	this关键字：
	1.在本类的成员方法中，访问本类的成员变量；
	2.在本类的成员方法中，访问本类的另一个成员方法；
	3.在本类的构造方法中，访问本类的另一个构造方法；
	
	java语言是单继承的；
	一个类的直接父亲只能有唯一一个；
	java可以多级继承；
	class A{};
	class B extends A{};
	class c extends B{};
	一个子类只有一个直接父类，但一个父类可以有多个子类；
*/
```

## 第八天

### 抽象类

```java
/*
如果父类当中的方法不确定任何进行{}方法体的实现，那么这就应该是一个抽象方法；
抽象方法：就是加上abstract关键字，然后去掉大括号，直接分号结束；
抽象类：抽象方法所在的类，必须是抽象类；在class之前加上abstract关键字；

使用方法：
1.不能直接创建new抽象类对象；
2.必须要一个子类来继承抽象父类；
3.子类必须覆盖重写父类当中所有的抽象方法；
覆盖重写（实现）：子类去掉抽象方法的abstract关键字，然后补上方法体大括号；
4.创建子类对象进行使用；

抽象方法格式：
public abstract 返回值类型 方法名称(参数列表);


注意：一个抽象类不一定包含抽象方法；没有抽象方法的抽象类也不能直接new对象；子类也可以是抽象类；
*/
```



### 接口

接口就是一种公共的标准规范；

```java
/*
接口就是多个类的规范；
接口是一种引用类型，最重要的内容就是其中的：抽象方法；
定义格式：
public interface 接口名称{
	//接口内容
}

Java7 ：
接口中可以有：
1.常量
2.抽象方法
3.默认方法（Java8以上）
4.静态方法（Java8以上）
5.私有方法（Java9以上）

接口当中的抽象方法，修饰符必须是两个固定的关键字： public abstract（可以选择性省略）

接口使用步骤：
1.接口不能直接使用，必须有一个“实现类”来“实现”该接口；
格式：
public class 实现类名称 implements 接口名称 {
	//.....
}
2.接口的实现类必须覆盖重写（实现）接口中的所有的抽象方法；
去掉abstract关键字，加上方法体大括号；
3.创建实现类的对象，进行使用；

注意：
如果实现类并没有覆盖重写接口中的所有的抽象方法，那么那个实现类自己就必须是抽象类；

Java8开始支持默认方法；			备注接口当中的默认方法，可以解决接口升级问题；
格式：
public default 返回值类型 方法名称(参数列表){		//public 可省略
	//方法体
}
注意:
1.接口的默认方法，可以通过接口实现类对象，直接调用；
2.接口的默认方法，可以被接口实现类进行覆盖重写；

Java 8开始允许定义静态方法；
格式：
public static 返回值类型 方法名称(参数列表){
	//方法体
}
注意：不能通过接口实现类的对象来调用接口当中的静态方法；
正确用法：直接通过接口名称直接调用静态方法；

Java 9接口中允许定义私有方法；
1.普通私有方法，解决多个默认方法之间重复代码问题；
格式：
private 返回值类型 方法名称(参数列表){
	//方法体
}
2.静态私有方法，解决多个静态方法之间重复代码问题；
格式：
private static 返回值类型 方法名称(参数列表){
	//方法体
}

接口中可以定义“成员变量” 但是必须使用public static final 这三个关键字进行修饰
从效果上看，这其实是接口的【常量】；
格式：
public static final 数据类型 常量名称 = 数据值；
一旦使用final关键字进行修饰，说明不可变；
public static final 可以省略，但任然存在；
接口当中的常量，必须进行赋值，不能不赋值；
接口当中的常量的名称，使用完全大写的字母，用下划线进行分隔（推荐命名规则）

1.接口不能有静态代码块或者构造方法；
2.一个类的直接父类是唯一的，但是一个类可以同时实现多个接口；
格式：
public class 实现类名称 implements 接口1,接口2{
	//覆盖重写所有的抽象方法
}
3.如果实现类所实现的多个接口当中，存在重复的抽象方法，那么只需要覆盖重写一次就好；
4.如果实现类没有覆盖重写所有接口当中的所有抽象方法，那么实现类必须是一个抽象类；
5.如果实现类所实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写
6.一个类如果直接父类当中的方法，和接口当中的默认方法产生了冲突，优先使用父类当中的方法；
7.类与接口之间是多实现的，一个类可以实现多个接口；
8.接口与接口之间是多继承的；
8.1.多个父接口当中的抽象方法如果重复，没关系；
8.2.多个父接口当中的默认方法不能重复，需要在子接口中进行默认方法覆盖重写（default关键字不可省略）；
*/
```

## 第九天

### 多态

一个对象拥有多种形态，这也就是对象的多态

```java
/*
代码当中体现多态性，父类引用指向子类对象；
格式：
父类名称 对象名 = new 子类名称()；
或者
接口名称 对象名 = new 实现类名称();

成员方法:
口诀：编译看左边，运行看右边；
成员变量：
口诀：编译看左边，运行看左边；  

对象的向上转型，其实就是多态的写法；
格式：父类名称 对象名 = new 子类名称；
含义：右侧创建了一个子类对象，把他当成父类来看待使用；
注意事项：向上转型一定是安全的；从小范围转向大范围；

对象一旦向上转型为父类，那么就无法调用子类原本特有的内容；
解决方案：
对象的向下转型：其实是一个还原的动作：
格式：
子类名称 对象名 = (子类名称)父类对象；
含义：将父类对象，还原成为本来的子类对象；

如何才能知道一个父类引用对象，本来是什么子类？
格式：
对象 instanceof 类名称；
这将会得到一个Boolean值，也就是判断前面的对象是否能够成为后面类型的实例；

*/
```

## 第十天

### final关键字

```java
/*
final关键字代表最终，不可改变的
常见用法：
1.可以修饰一个类
2.可以用来修饰一个方法
3.修饰一个局部变量
4.修饰一个成员变量

当final用来修饰一个类的时候
格式:
public final class 类名称{
	//......
}
含义：当前这个类不能有任何子类；且其中的所有成员方法都无法进行覆盖重写；

当final用来修饰一个方法的时候，这个方法就是最终方法，不能被覆盖重写；
格式：
修饰符 final 返回值类型 方法名称(参数列表){
	//方法体
}
对于类，方法来说，abstract和final不能同时使用；

一旦用final修饰局部变量，就一次赋值，终身不变；
对于基本类型来说，变量当中的数据不可变；
对于引用类型来说，变量当中的地址值不变；

final修饰成员变量
1.由于成员变量具有默认值，一旦使用final修饰后必须手动赋值；
2.对于final的成员变量，要么直接赋值，要么通过构造方法赋值；
3.必须保证类当中所有重载的构造方法，都最终会对final的成员变量进行赋值；

*/
```

### 权限修饰符

```java
/*
Java 中有四种权限修饰符：
				public > protected > (default) > private
同一个类			yes		 yes		yes			yes
同一个包			yes      yes		yes			no
不同包子类          yes		yes		    no		    no
不同包非子类		   yes		no 		    no			no

注意：(default)并不是关键字default而是根本不写；
*/
```

 ## 第十一天

### Object类

java.lang.Object类是Java语言中的根类，即所有类的父类；

```java
/*
String toString(); 返回该对象的字符串表示；(可以获取对象的地址值)
但打印对象的地址值是没有意义的，需要覆盖重写toString方法；
直接打印对象名，其实就是调用对象的toString方法；

boolean equals(Object obj)； 指示其他某个对象是否与此对象"相等"；
Object类equals方法的源码:
	public boolean equals(Object obj){
		return (this == obj);
	}
	方法体：
	 == 比较运算符:
	 基本数据类型 比较值；
	 引用数据类型 比较两个对象的地址值;
所以我们应该覆盖重写equals方法，比较两个对象的属性值；
问题:
	隐含着一个多态；
	多态弊端：无法使用子类的特有内容；
	解决：使用向下转型；把Object类型强制转换为当前类型；
*/
```

### Objects类

```java
/*
jdk7:
public static boolean equals(Object a, Object b){
	retrun (a == b)||(a != null && a.equals(b));
}
	对象为空时，不能调用Object的equals方法，这容易抛出空指针异常，而Objects类中的equals方法就优化了这个问题；
*/  
```

## 第十一天

### 内部类

```java
/*
如果一个事物的内部包含着另一个事物，那么就是一个类的内部包含另一个类；
分类：
1.成员内部类
2.局部内部类(包括匿名内部类)

成员内部类：
格式：
修饰符 class 外部类名称{
	修饰符 class 内部类名称{
		//...
	}
	//...
}
注意：内用外，随意访问；外用内，一定需要借助内部类对象；
———————-----------------—————————————————————
使用成员内部类方法：
1.间接方式：在外部类的方法当中，使用内部类；然后main只是调用外部类方法；
2.直接方式：外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();
如果出现了重名现象： 外部类.this.外部类成员变量名；

局部内部类：定义于一个方法的内部；
“局部”：只有当前所属的方法才能使用它，出了这个方法外面就不可使用了；
定义格式:
修饰符 class 外部类名称{
	修饰符 返回值类型 外部类方法名称(参数列表){
		class 局部内部类名称{
			//...
		}
	}
}
如果希望访问所在方法的局部变量，那么这个局部变量必须是有效final的；
原因：
1.new出来的对象在堆内存中；
2.局部变量跟着方法在栈内存中；
3.方法运行完之后会立即出栈，局部变量消失；
4.但是new出来的对象会在堆中持续存在，直到垃圾回收消失； 

匿名内部类：
如果接口的实现类（或者是父类的子类）只需要使用唯一的一次
那么这种情况下就可以省略该类的定义，而改为使用【匿名内部类】
格式：
接口名称 对象名 = new 接口名称(){
	//覆盖重写所有的抽象方法；
};
P.s:匿名内部类是省略了【实现类/子类名称】，但匿名对象省略了【对象名】；
匿名内部类和匿名对象不是同一回事；

权限修饰符：
定义一个类的时候：
1.外部类：public / (default)
2.成员内部类： public / protected / (default) / private
3.局部内部类：什么都不能写； 不同于(default)
*/
```

##  第十二天 日期时间类

### Date类

```java
/*
java.util.Date:表示日期和时间的类；
类Date表示特定的瞬间，精确到毫秒;
时间原点（0毫秒）:1970.1.1 00:00:00(英国格林威治)

构造方法：
无参：
	Date();		获取当前的系统的日期和时间；
带参:
	Date(long date);	传递毫秒值，把毫秒转换为Date日期;
	
成员方法:
	long getTime()		返回自时间原点以来此Date对象表示的毫秒值；
*/
```

### DateFormat类(抽象类)

```java
/*
	日期/时间格式化子类的抽象类；
    作用：
    1.格式化（日期->文本）
    2.解析（文本->日期）
    
 成员方法：
 String format(Date date)		按照指定的模式，把Date日期格式化为符合模式的字符串；
 Date parse(String source)		把符合模式的字符串，解析为Date日期；
 
 
SimpleDateFormat类继承DateFormat类
构造方法：
	SimpleDateFormat(String pattern)	用给定的模式和默认语言环境日期格式构造SimpleDateFormat。
	参数：
		String patten ：传递指定的模式；
	模式：区分大小写
	y - 年						写对应的模式，会把模式替换成对应的日期和时间；
	M - 月	
	d - 日
	H - 时
	m - 分
	s - 秒
*/

//练习题
//计算出一个人已经出生了多少天？
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入出生日期: 格式 YYYY-MM-dd");
        String birth = new Scanner(System.in).next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDay = sdf.parse(birth);
        Date today = new Date();
        System.out.println("当前时间对应毫秒值：" + today.getTime());
        System.out.println("出生日期对应毫秒值：" + birthDay.getTime());
        long time = today.getTime()-birthDay.getTime();
        System.out.println("时间差为：" + time);
        long day = time/1000/60/60/24;
        System.out.println("相差天数为：" + day);
        long year = day/365;
        System.out.println("已经" + year + "岁啦！");
    }
}
```

