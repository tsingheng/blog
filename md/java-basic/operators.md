## Java运算符(Operators)

#### 使用Java运算符
运算符涉及一个或者多个参与运算的参数并且最终产生一个结果。加法和取正(+)、减法和取负(-)、乘法(*)、除法(/)、赋值(=)。加减乘除没什么可说的，如果你是刚接触计算机语言，可能不明白=的意义，高中数学解题经常用到这两种格式："令a = 1,......"和“若a = 1,......”，第一种是a本来没有值，然后让a的值为1，翻译成java就是`int a = 1;`，第二种情况属于判断，java里面判断是否相等需要使用两个等号，第二种翻译成java就是`a == 1`，这个表达式返回的结果是boolean类型，判断不相等使用“!=”，如“若a不等于1”等价于`a != 1`。   
除了"=","==","!="可以对任何对象使用，其他的运算符基本都只能对基本数据类型使用，比如你可以计算1+1，但是两个Person相加就不可以了，还有个特殊的是String对象是可以使用+的，表示把两个字符串连起来。   
#### 优先级(Precedence)
优先级其实就是算数预算顺序了，小学的知识了，乘法除法优先于加法减法，括号里面的先运算。写复杂运算语句的时候尽量用上括号(圆括号哦，不能使用中括号也不能使用花括号)，即使有些地方带不带括号执行顺序是一样的，但是代码毕竟是给人看的，有括号看起来更直观一些。   
下面是从Thinking in java上抄的一个例子

```
public class Precedence {
	public static void main (String[] args) {
		int x = 1;
		int y = 2;
		int z = 3;
		int a = x + y - 2/2 + z;
		int b = x + (y - 2)/(2 + z);
		System.out.println("a is " + a);
		System.out.println("b is " + b);
	}
}
```
小学的知识吧，不解释了，编译运行后输出结果应该是

```
a is 5
b is 1
```
#### 数学运算符
Java数学运算有加(+)、减(-)、除(/)、乘(*)、模(%)(模是除法取余数的，比如13%5，就是13除以5的余数，就是3)。其中有一点特殊的是整数除法，结果还是整数，而且是取结果的整数部分，而不是四舍五入，比方说5/2，结果不是2.5也不是3，是2。  
Java有一种运算和赋值的简写形式，比如

```
int a = 0;
int b = 1;
a = a + b;
```
第三行首先是执行加法，然后结果赋值给a，而a同时参与了加法运算，第三行可以简写为`a += b;`，其他几个运算符规则一样的。   
下面是Thinking in java上数学运算符用法的例子 

```
//演示Java数学操作符
import java.util.*;

public class MathOps {
	public static void main(String[] args){
		Random rand = new Random(47);
		int i;
		int j = rand.nextInt(100) + 1;//[1, 100]区间内随机的整数
		int k = rand.nextInt(100) + 1;//[1, 100]区间内随机的整数
		System.out.println("j is " + j);//打印出j的值
		System.out.println("k is " + k);//打印出k的值
		
		i = j + k;
		System.out.println("j + k is " + i);//打印j+k的结果
		
		i = j - k;
		System.out.println("j - k is " + i);
		
		i = k / j;
		System.out.println("k / j is " + i);
		
		i = k * j;
		System.out.println("k * j is " + i);
		
		i = k % j;
		System.out.println("k % j is " + i);
		
		j %= k;//这一行相当于j = j % k;
		System.out.println("j %= k is " + j);
		
		float u;
		float v = rand.nextFloat();
		float w = rand.nextFloat();
		System.out.println("v is " + v);
		System.out.println("w is " + w);
		
		u = v + w;
		System.out.println("v + w is " + u);
		
		u = v - w;
		System.out.println("v - w is " + u);
		
		u = v * w;
		System.out.println("v * w is " + u);
		
		u = v / w;
		System.out.println("v / w is " + u);
		
		u += v;//相当于u = u + v;
		System.out.println("u += v is " + u);
		
		u -= v;//相当于u = u - v;
		System.out.println("u -= v is " + u);
		
		u *= v;//相当于u = u * v;
		System.out.println("u *= v is " + u);
		
		u /= v;//相当于u = u / v;
		System.out.println("u /= v is " + u);
	}
}
```
上面代码先创建了一个Random对象，Random是java自带的一个类，可以生成随机的数字。首先生成了两个[1, 100]的随机整数j和k，然后打印出来j和k的值，然后用j和k进行加减乘除模操作并输出结果。然后生成两个随机的小数v和w，然后进行加减乘除。因为数字是随机生成的，所以每次执行结果都是不一样的。我这里执行结果截图如下
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/operators/C2EE73DC-51AB-4485-AB2B-FCA1EAE5260E.png)   
另外加号和减号还有另外一个作用，没错，可以做正负号，比如

```
int a = 1;
int b = -a; //b is -1
int x = a * -b;// 这样写虽然也是对的，但是利于阅读，用下面的方式更好。
int x = a * (-b);
```
#### 自增和自减
自增是两个连续的加号，并且有加号在变量前面和后面两种形式。自增会进行两个操作，一个是变量值加1，并且会返回变量的值，如果加号在变量前面，先给变量+1，再返回变量值，如果加号在变量后面，则先返回变量值，然后给变量+1。下面对比一下两种形式   

```
int a = 3;
int x = ++a;
//最后a的值是4,x的值也是4
```
等价于

```
int a = 3;
a = a + 1;
int x = a;
```
```
int a = 3;
int x = a++;
//最后a的值4,而x的值是3
```
等价于   

```
int a = 3;
int x = a;
a = a + 1;
```
自减跟自增是同样地道理，只不过执行的操作是减1   

```
public class AutoInc {
	public static void main(String[] args){
		int i = 1;
		System.out.println("i: " + i);
		System.out.println("++i: " + ++i);
		System.out.println("i++: " + i++);
		
		System.out.println("i: " + i);
		System.out.println("--i: " + --i);
		System.out.println("i--: " + i--);
		System.out.println("i: " + i);
	}
}
```
看看上面这个例子，预测输出结果会是多少，然后看下面的结果：   
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/operators/64D2825A-8DA7-4849-9344-690535B6329A.png)   

#### 关系运算符
开始提到的"=="和"!="就是关系预算符，分别用来对比两个对象相等和不相等，除此之外关系预算符还有大于(>)、小于(<)、大于等于(>=)、小于等于(<=)，看起来跟小学数学学过的没什么区别。关系预算法运算结果是boolean类型（true或者false）。另外上面说过"=="和"!="可以对任何对象使用，但是其他几个关系运算就不行了，大于等于显然是对数字做比较的。所以"=="或者"!="比较的机制和其他的就不太一样了。看一下下面这个例子：   

```
public class Equivalence{
	public static void main(String[] args){
		Integer x = new Integer(10);
		Integer y = new Integer(10);
		System.out.println("x==y is " + (x == y));
		System.out.println("x>=y is " + (x >= y));
		System.out.println("x<=y is " + (x <= y));
		
		Integer a = 10;
		Integer b = 10;
		System.out.println("a==b is " + (a == b));
		System.out.println("a>=b is " + (a >= b));
		System.out.println("a<=b is " + (a <= b));
	}
}
```
你肯定觉得六个输出都是true，很可惜结果并不是的
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/operators/C8185F70-6932-4D40-9281-C60664FFB977.png)   
可以看出来x和y比较是不相等的，这里因为x和y都是用new创建的对象，==是比较两个对象是否是同一个对象的，而不是比较数字大小的，前面说过了，除了数字其他对象也可以用==来作比较的。所以当你想对比值是不是相等的时候推荐使用对象的equals来比较，java任何对象都有equals方法，默认跟==是一样的效果，但是像Integer这样的类都已经重写了equals方法，这里先解释这么多，我个人觉得==和equals要等到java基本熟练了回头拔高阶段需要深入学习的。上面的代码改一下就可以达到想要的效果了：

```
public class Equivalence{
	public static void main(String[] args){
		Integer x = new Integer(10);
		Integer y = new Integer(10);
		System.out.println("x.equals(y) is " + x.equals(y));
		System.out.println("x>=y is " + (x >= y));
		System.out.println("x<=y is " + (x <= y));
		
		Integer a = 10;
		Integer b = 10;
		System.out.println("a==b is " + (a == b));
		System.out.println("a>=b is " + (a >= b));
		System.out.println("a<=b is " + (a <= b));
	}
}
```

#### 逻辑运算符
逻辑运算符是对boolean值来进行运算的，有且(&&)、或(||)、非(!)。

- && 两个条件都为true时才返回true，否则返回false。
- || 两个条件只要有一个为true，结果就为true，否则返回false。
- ! 其实就是取反，!true结果为false，!false结果为true。

```
import java.util.*;
public class LogicOp{
	public static void main(String[] args){
		Random rand = new Random();
		int i = rand.nextInt(100);
		int j = rand.nextInt(100);
		System.out.println("i=" + i);
		System.out.println("j=" + j);
		System.out.println("i>j is " + (i>j));
		System.out.println("i<j is " + (i<j));
		System.out.println("!(i>j) is " + !(i>j));
		System.out.println("!(i<j) is " + !(i<j));
		System.out.println("i>=j is " + (i>=j));
		System.out.println("i<=j is " + (i<=j));
		System.out.println("i==j is " + (i==j));
		System.out.println("i!=j is " + (i!=j));
		
		System.out.println("(i<10) && (j<10) is " + ((i<10) && (j<10)));//i和j都小于10才输出true
		System.out.println("(i<10) || (j<10) is " + ((i<10) || (j<10)));//i和j任意一个小于10就输出true
	}
}
```
运行结果为
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/operators/E55DEF1D-ACC0-4A0D-9CF7-54C1B0B073E0.png)