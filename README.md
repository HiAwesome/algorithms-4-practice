# Algorithms 4 Practice

算法 4 的代码练习。

## 命令行调用

* main.jar 为项目根目录下一个软连接，指向项目打包带依赖的 jar。
* 为命令 java -cp main.jar 建立别名 jcmj.
* 每次添加新的类时需要重新打包，目前已配置快捷键 Control + Command + m 执行此命令。
* 在项目根目录下执行命令行 jcmj package_name.class_name parameter 进行测试。

## StdIn.isEMpty() 退出问题

参见 [how to make StdIn.isEmpty() return true?](https://stackoverflow.com/questions/43401347/how-to-make-stdin-isempty-return-true)。本级 Mac 测试在 Intellij IDEA 中直接运行类按 Command + D 即可终止输入；执行 Jar 包后在 iTerm2 里或者 IntelliJ IDEA 中的 Terminal 中按 Ctrl + D 即可终止输入。

## 书中引用

### 链表

* 理解链表是学习各种算法和数据结构中最关键的第一步。
* 链表的使用达到了我们的最优设计目标：
  1. 它可以处理任意类型的数据；
  2. 所需要的空间总是和集合的大小成正比；
  3. 操作所需的时间总是和集合的大小无关。
  
### 评估它解决大型问题的可行性

对于编写的每个程序，你都需要能够回答这个基本问题：“该程序能在可接受的时间内处理这些数据吗？”对于大量数据，要回答这个问题我们需要一个比乘以2更大的系数（比如10）来进行推断。无论是投资银行家处理每日的金融数据还是工程师对设计进行模拟测试，定期运行需要若干个小时才能完成的程序是很常见的。了解程序的运行时间的增长数量级能够为你提供精确的信息，从而理解你能够解决的问题规模的上限。理解诸如此类的问题，是研究性能的首要原因。没有这些知识，你将对一个程序所需的时间一无所知；而如果你有了它们，一张信封的背面就足够你计算出运行所需的时间并采取相应的行动。

## 个人思考

### 实现算法的多进程版本

顺序执行的代码只能调度 CPU 的一个内核，所以占用 CPU 最多 100%, 但是实际上目前个人电脑和服务器多核已成标配。意味着即使进行非常复杂的计算，也无法占用 CPU 超过一个内核。在算法中设定线程数的两个限定：第一是能使用的 CPU 内核上限；第二是单个 CPU 执行一种算法子问题的合适容量大小。这两个条件均满足的话不再启动新的进程。达到解决算法问题使用多进程占用多个内核的目的。延伸阅读如下：
    
* [一文看懂Python多进程与多线程编程](https://zhuanlan.zhihu.com/p/46368084) ：Python多进程和多线程哪个快? 由于GIL的存在，很多人认为Python多进程编程更快，针对多核CPU，理论上来说也是采用多进程更能有效利用资源。网上很多人已做过比较，我直接告诉你结论吧。对CPU密集型代码(比如循环计算) - 多进程效率更高；对IO密集型代码(比如文件操作，网络爬虫) - 多线程效率更高。为什么是这样呢？其实也不难理解。对于IO密集型操作，大部分消耗时间其实是等待时间，在等待时间中CPU是不需要工作的，那你在此期间提供双CPU资源也是利用不上的，相反对于CPU密集型代码，2个CPU干活肯定比一个CPU快很多。那么为什么多线程会对IO密集型代码有用呢？这时因为python碰到等待会释放GIL供新的线程使用，实现了线程间的切换。

* [how to do multiprocessing in java, and what speed gains to expect?](https://stackoverflow.com/questions/8001966/how-to-do-multiprocessing-in-java-and-what-speed-gains-to-expect) ：No, in fact it would likely make it worse. If you were to switch from multithreading to multiprocessing, then you would effectively launch the JVM multiple times. Starting up a JVM is no simple effort. In fact, the way the JVM on your desktop machine starts is different from the way an enterprise company starts their JVM, just to reduce wait time for applets to launch for the typical end-user.

* [Processes and Threads](https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html) ：Threads are sometimes called lightweight processes. Both processes and threads provide an execution environment, but creating a new thread requires fewer resources than creating a new process. Threads exist within a process — every process has at least one. Threads share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication. Multithreaded execution is an essential feature of the Java platform. Every application has at least one thread — or several, if you count "system" threads that do things like memory management and signal handling.

