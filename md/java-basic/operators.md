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