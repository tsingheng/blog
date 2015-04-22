## JDK
我们的电脑上一般是不能直接运行Java程序的，要想运行Java程序，需要安装Java运行环境，开发Java程序当然也离不了，JDK包含了Java运行环境，还有一些开发工具。   
JDK官方下载地址在<http://www.oracle.com/technetwork/java/javase/downloads/index.html>，但是这个下载速度有点儿慢，百度直接搜索JDK就会有百度软件中心的下载链接，但是只有Windows版和Mac版的，如果你是linux系统，可以从我的百度网盘下载，32位<http://pan.baidu.com/s/1i3vNbFJ>。
#### 安装
Windows和Mac安装都有可视化界面，就不说了，Linux环境只要把下载的压缩包解压到想要安装的目录就好了，既然你已经选择Linux了，相信解压什么的你都会的。
#### 环境变量
###### Windows
打开计算机属性->高级系统设置->环境变量  
1. 点击“系统变量”下面的“新建”按钮，弹出来的输入框“变量名”填“JAVA_HOME”，变量值填写JDK的安装目录，比如我的是D:\Program Files\Java\Jdk1.8_25，点击“确定”  
2. 然后再点击“新建”按钮，变量名填“CLASSPATH”，值写“.;%JAVA_HOME%\lib\tools\dt.jar;%JAVA_HOME%\lib\tools\tools.jar”，点击“确定”  
3. 然后在系统变量里面找到变量为"Path"那一行，在值的最后面加上“;%JAVA_HOME%\bin”，注意如果本来最后面已经有分号了，就不用再加分号   
窗口都保存掉，打开系统命令行窗口，输入java -version然后回车，如果看到下面输出的文字就表示安装成功

```
java version "1.8.0_25"
Java(TM) SE Runtime Environment (build 1.8.0_25-b17)
Java HotSpot(TM) 64-Bit Server VM (build 25.25-b02, mixed mode)
```
###### Linux
编辑~/.bashrc，文件末尾添加以下几行（不能完全照抄啊，第一行等号右边要填你JDK安装的路径）

```
JAVA_HOME=/usr/local/jdk1.8_25
CLASSPATH=.:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar
PATH=$PATH:$JAVA_HOME/bin
```
保存以后运行`source ~/.bashrc`，再运行`java -version`，如果看到下面输出的文字就表示安装成功

```
java version "1.8.0_25"
Java(TM) SE Runtime Environment (build 1.8.0_25-b17)
Java HotSpot(TM) 64-Bit Server VM (build 25.25-b02, mixed mode)
```
###### Mac
Mac系统装完之后好像环境变量就自动配好了，我是没配过，打开终端运行`java -version`，如果看到下面输出的文字就表示安装成功

```
java version "1.8.0_25"
Java(TM) SE Runtime Environment (build 1.8.0_25-b17)
Java HotSpot(TM) 64-Bit Server VM (build 25.25-b02, mixed mode)
```
#### 编辑器
写代码是要用编辑器的，我开始学得时候用的都是记事本儿，那东西太不好用了，推荐一款我现在常用的编辑器，Notepad++，有语法高亮，代码缩进也比记事本儿的好看多了，打开多个文件也方便。下载地址直接百度就有，免费的。
#### Hello World
几乎所有的编程语言都是从Hello World开始，装好JDK就趁热Hello World吧。   
打开Notepad++新建一个文件，选择“文件->另存为”，选择你要存放的目录，然后文件名填写“HelloWorld”，保存类型选择“Java source file (*.java)”然后点击保存，如下图   
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/install-jdk/BFFC23B2-8AAB-4B10-B94A-7E010CFDC656.png)
如果你用记事本儿或者其他编辑器，一定要确保保存文件后缀是.java，而不是默认的.txt，window文件后缀默认是隐藏的，点击资源管理器左上角“组织->文件夹和搜索选项->查看”，在下面找到“隐藏已知文件类型的拓展名”，把这个勾去掉，确定，再看你的文件是不是.java结尾的，如果不是，把后面的去掉。   
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/install-jdk/1D270751-1464-4BF4-B77B-27B5BD5873F3.png)   
编写下面的代码并保存

```
public class HelloWorld {
	public static void main (String[] args) {
		System.out.println("Hello World!");
	}
}
```
然后打开命令行窗口，cd到HelloWorld.java所在目录，然后执行`javac HelloWorld.java`，这一步控制台应该什么反应都没有，但是HelloWorld.java所在目录生成了一个HelloWord.class的文件，如果控制台报了什么错，那应该是你代码写错了，请根据错误信息仔细检查，然后再执行`java HelloWorld`，控制台就会输出一行“Hello World!”，下面是我的运行截图   
![](http://shangtech-blog.oss-cn-hangzhou.aliyuncs.com/java-basic/install-jdk/0E1D2FD6-B668-4CD7-9CF3-5FB3D0DA507F.png)   
#### 从Hello World学到什么
HelloWorld.java是程序源代码，源代码文件名跟代码中class后面的单词必须一模一样   
`public static void main(String[] args){}`是Java程序的入口，格式是固定死的，大括号里面的东西才是我们关心的，比如这个例子我们在大括号里只做了一件事，就是输出Hello World!，System.out.println()你可以暂时当做是固定写法，用来输出，括号里可以随便写，写什么就输出什么   
一行语句结束要在结尾加分号   
javac是编译命令，执行完后会把源代码编译成同名的.class文件
java就是运行命令了，比如`java HelloWorld`就是执行HelloWorld.class的main方法