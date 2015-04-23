## Hello Java
本节简要介绍一下java基本常识，内容参考Thinking in Java -- Everything Is an Object。   
#### 创建对象
Java是一门纯面向对象语言，编写Java程序其实就是创建对象，调用对象的方法。怎么创建对象呢，类都是用new关键字来创建对象，比如`Person me = new Person();`，这样就创建了一个Person对象，me称为变量名，可以随便命名，但是尽量取看得懂的名字，变量名是对对象的引用，当需要使用对象的时候，就通过变量名使用，比如刚这个Person累了想调用他的sleep方法让他休息休息，`me.sleep();`。   
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
- char，字符类型，表示一个unicode字符，如果你不知道unicode，那可以简单认为char就是用来存储字符的，一个char可以保存一个字母，或者一个数字，或者一个中文，如`char a = 'a';`，`char a = '啊';`
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
