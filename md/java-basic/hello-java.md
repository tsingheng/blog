## Hello Java
本节简要介绍一下java基本常识，内容参考Thinking in Java -- Everything Is an Object。   
#### 类
类是对现实世界的一种抽象描述，比如“人”，“汽车”，“工厂”，都可以定义成类，怎么定义类呢，用class关键字，上一篇HelloWorld中就出现过

```
//定义类“HelloWorld”
//HelloWorld
class HelloWorld{

}
```
```
//定义类“人”
class Person{

}
```
```
//定义类“汽车”
class Car{

}
```
Java本身内置了很多类，比如日期类，整数类，小数类可以直接用，上面说的人、汽车、工厂，都需要自己来定义
#### 属性
类拥有属性，比如人拥有属性：姓名、性别、年龄、身高、体重等等，汽车拥有属性：价格、排量、时速等等
#### 方法
类拥有方法，比如人拥有方法：跑步、睡觉、吃饭等等，汽车拥有方法：启动、刹车等等   
方法调用格式是“对象.方法名(参数);”，如`ming.run();`
HelloWorld类只有一个main方法，这个方法是Java中比较特殊的一个方法，是Java程序的入口，就是说程序是从这个地方开始执行的。

#### 对象
Java是一门纯面向对象语言，编写Java程序其实就是创建对象，调用对象的方法。什么叫对象，对象是类的实例，比如上面说的人是类，而张三、李四就是对象，汽车是类，实际看得见摸得着的车那是对象，怎么创建对象呢，用new关键字，格式为“new 类名();”，比如`new Person();`，这样就创建了一个Person对象.
#### 变量
变量是对对象的引用，好比人的名字，我们要叫某个人的时候不可能总是去把人家衣服拽一下，有名字就好了，我们直接喊名字，就是在叫这个人了。   
再举一个跟代码更接近的例子，高中数学解题的时候经常会有这样的步骤“设什么什么为x”，这句话里面“什么什么”就是实际对象，x就是变量名。还有很多时候做假设的“设a=3”，3是一个整数对象，a就是变量名，但是java里面不可以只写`a = new Integer(3);`，因为计算机没有改卷老师那么聪明，你必须告诉计算机这个变量是什么类型的，是整数啊，还是小数，还是个人，还是部车？，所以正确的写法是`Integer a = new Integer(3);`   
有几种特殊对象不需要使用new来创建，就是基本数据类型(primitive types)，Java有9种基本数据类型，下面介绍除了void之外的8种。   
下面是8种基本数据类型的长度对照表   
<table>
	<tr><th>基本数据类型	</th><th>长度	</th><th>最小值</th><th>最大值</th><th>包装类</th></tr>
	<tr><td>boolean	</td><td>-		</td><td>-           </td><td>-             </td><td>Boolean   </td></tr>
	<tr><td>char	</td><td>16位	</td><td>	         </td><td>              </td><td>Character </td></tr>
	<tr><td>byte	</td><td>8位	</td><td>-128        </td><td>+127          </td><td>Byte      </td></tr>
	<tr><td>short	</td><td>16位	</td><td>$$-2^{15}$$ </td><td>$$+2^{15}-1$$ </td><td>Short     </td></tr>
	<tr><td>int		</td><td>32位	</td><td>$$-2^{31}$$ </td><td>$$+2^{31}-1$$ </td><td>Integer   </td></tr>
	<tr><td>long	</td><td>64位	</td><td>$$-2^{63}$$ </td><td>$$+2^{63}-1$$ </td><td>Long      </td></tr>
	<tr><td>float	</td><td>32位	</td><td>IEEE754     </td><td>IEEE754       </td><td>Float     </td></tr>
	<tr><td>double	</td><td>64位	</td><td>IEEE754     </td><td>IEEE754       </td><td>Double    </td></tr>
</table>
这几种基本类型是代码中到处都要用的，表格里面的东西不用去背，等用起来自然就知道了。这里只简要介绍一下几种类型

- boolean，布尔类型，只有两种值，true和false，表示真和假，用来做判断的，如`boolean isAdult = true;`，`boolean isAdult = false;`
- char，字符类型，表示一个unicode字符，如果你不知道unicode，那可以简单认为char就是用来存储字符的，一个char可以保存一个字母，或者一个数字，或者一个中文，如`char a = 'a';`，`char a = '啊';`，char的值是用单引号表示的。
- byte，顾名思义就是字节，一个字节占8位，计算机基本常识了。
- short，短整型
- int，整型，最常用的整数类型了，`int x = 10;`
- long，长整型，int最大只能表示到2的63次方-1，再大的数字就需要用long来表示了，当然2的63次方-1以下的也能用long
- float，浮点型，上面几个都是表示整数，float是用来表示小数的，`float a = 0.4;`
- double，双精度浮点型，也是小数类型，表示范围和精度都要比float大   
##### 包装类
表格最后一列是各个类型对应的包装类，什么是包装类呢   

- 首先包装类是一个类，是用class定义的，有属性有方法，而基本数据类型是没有属性没有方法的，基本数据类型是数据的最小单元   
- 然后包装类可以为空，基本数据类型都有默认值，比如

```
int a;
Integer b;
```
这段代码的结果，a的值是0，b的值确实null，如果拿b去做什么运算，会报错的。   
前面创建对象最开始不是说类的对象要用new来创建吗，那要创建Integer的对象其实应该是`Integer a = new Integer(1);`，为什么可以`Integer a = 1;`呢，这是因为java对基本数据类型可以自动打包和解包，打包，就是会自动把1变成new Integer(1)，那什么是解包呢，`int a = new Integer(1);`，如果你这样写，是创建了一个包装类的对象，java就会自动解包成基本数据类型了。   
上面看到了基本数据类型可以用new也可以不用new，但是基本数据类型尽量不要用new。   
几种数据类型相互是可以转换的，转换规则这里就不提了，以后学习过程中用到了再慢慢学。   
另外再介绍一个比较重要的类，String类，是java内置的类，表示一串字符，值用双引号表示，如`String myName = "宋老师";`
#### 对象作用域
作用域就是有效范围的意思。首先对象要先创建才能使用，就好比你解数学题，不可能第一行先把方程写出来，完了才说a是什么b是什么。其次变量有效范围是大括号以内，举个例子

```
//大括号1
{
	int a = 1;
	//大括号1里面a开始生效
	//大括号1-1
	{
		int c = 2;
		//c只在大括号1-1里面生效，因为大括号1-1也在大括号1中，所以1-1中a也有效
	}
	//大括号1-1结束，后面c就超出c的作用域了，但是大括号1还没结束，所以a仍然有效
	int b = 3;
}
//大括号1结束，a跟b都失效了
//大括号2
{
	int d = 2;
}
```
#### 给类添加属性
明白几种基础数据类型以及变量定义方式了，下面试着给Person类添加几个属性，代码如下

```
class Person{

	//姓名
	String name;
	
	//年龄
	int age;
	
	//性别
	String gender;
	
	//身高
	double height;
	
	//体重
	double weight;
}
```
#### 再说方法
前面解释过什么是方法了，方法声明的格式为“返回类型 方法名(参数1，参数2，参数3...)”。   
参数是什么意思，打比方人有休息的方法，但是休息要休息多长时间呢，这个时间就是参数，先看下代码片段

```
public Person{
	void sleep(long time){
		System.out.println("太好了可以休息" + time + "秒了");
	}
}
Person a = new Person();
a.sleep(3600L);
```
方法可以不带参数，如果没有参数，方法名字后面的括号里面就什么都不要，如果有参数，参数之间用逗号隔开，每个参数要声明自己的参数类型，比如上面sleep方法只有一个参数就是休息时间，要求参数是long类型，那么调用sleep的时候只能传递long类型的数字，你不能说`a.sleep("1天");`，这样方法是识别不了的，上面我传的是3600L，后面为什么要加个大写的L呢，因为直接写3600默认是int类型的，后面加个大写的L就是long类型了，其实小写也可以，只是小写的l很容易被看错成数字1了。   
什么是返回值呢，返回值就是说这个方法运行完了返回什么结果，上面的例子是不反回结果的，不需要返回结果的就用void表示。然后举个有返回结果的例子，比如人是可以做数学加法的，那就有个做加法的方法，这个方法有两个参数，加数和被加数，假设加数和被加数都是整数，那么返回结果也是整数   
方法其实就是高中学过的函数，参数就是函数的自变量，返回值就是函数的因变量   
y = f(x)，就相当于方法`double f(double x);`   
如果是两个自变量y = f(a, b)，就相当于方法`double f(double a, double b);`

```
public Person{
	int operateAdd(int a, int b){
		int c = a + b;
		return c;
	}
}
Person a = new Person();
int sum = a.operateAdd(1, 2);
System.out.println("小明计算出来1+2=" + sum);
//小明计算出来1+2=3
```

下面实现一个完整的Person类   
首先新建文件Person.java内容如下

```
public class Person{
	//姓名
	private String name = "小明";
	
	//年龄
	private Integer age = 10;
	
	//自我介绍
	public void introduce(){
		System.out.println("你好，我叫" + name + ", 我今年" + age + "岁了");
	}
	
	//休息
	public void sleep(){
		System.out.println("太困了睡一会儿");
	}
	
	//长大,参数表示长大几岁
	public void growUp(int year){
		age = age + year;
		System.out.println("我长了" + year + "岁, 我现在" + age + "岁了");
	}
	
}
```
这个Person类有姓名(name)和年龄(age)两个属性，还有三个方法代码里面都有说明   
然后再新建文件PersonApp.java，跟Person.java保存在同一个目录，代码如下

```
public class PersonApp{
	public static void main(String[] args){
		//创建一个Person对象
		Person ming = new Person();
		
		//让ming自我介绍
		ming.introduce();
		
		//让ming休息一会儿
		ming.sleep();
		
		//ming长大两岁
		ming.growUp(2);
		
		//ming重新自我介绍
		ming.introduce();
	}
}
```
PersonApp这个类只有一个main方法，还记得吗，main方法是Java程序的入口，所以等会儿程序就是从这儿开始执行的，在main方法里面创建了一个Person对象，并调用了该对象的方法。  
然后编译代码，打开命令行窗口，cd到源代码所在目录，先执行`javac Person.java`，再执行`javac PersonApp.java`，两个文件就都编译好了。   
如果你完全照抄我上面的代码，然后编译爆出来一大堆看不懂的东西，截图如下
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/hello-java/B012E546-3079-47E3-B82A-CB1147799888.png)   
出现这个东西的原因是我上面代码里面有中文，保存的时候乱码了，如果你用的是我推荐的notepad++，那就再打开Person.java和PersonApp.java，选择菜单“格式-以ANSI格式编码”，然后发现刚才好好的文件中文都变得乱七八糟，就是乱码了，重新写一遍保存就好了，两个文件执行一样的操作，都保存好，重新编译应该就通过了。
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/hello-java/02257FAD-A16B-4CC4-963E-434027965B27.png)   
编译通过之后执行`java PersonApp`,就会看到下面的输出了
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/hello-java/5D481AE3-C663-4EEF-91AF-2C252C5798D1.png)   
很简单的例子哦，体会体会吧。