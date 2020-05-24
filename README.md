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

### 多个问题参量

我们过去的重点一直是使用仅需要一个参量的函数来衡量程序的性能，参量一般是命令行参数或是输入的规模。但是，多个参量也是可能的。典型的例子是需要构造一个数据结构并使用该数据结构进行一系列操作的算法。在这种应用程序中数据结构的大小和操作的次数都是问题的参量。我们已经见过一个这样的例子，即对使用二分查找的白名单问题的分析，其中白名单中有N个整数而输入中有M个整数，运行时间一般和MlogN成正比。

尽管需要注意的问题很多，对于每个程序员来说，对程序的运行时间的增长数量级的理解都是非常有价值的，而且我们这里所描述的方法也都十分强大并且应用范围广泛。Knuth证明了原则上我们只要正确并完整地使用了这些方法就能够对程序作出详细准确的预测。计算机系统一般都非常复杂，完整精确的分析最好留给专家们，但相同的方法也可以有效地近似估计出任何程序所需的运行时间。火箭科学家需要大致知道一枚试验火箭的着陆地点是在大海里还是在城市中；医学研究者需要知道一次药物测试是会杀死还是治愈实验对象；任何使用计算机程序的科学家或是工程师也应该能够预计它是会运行一秒钟还是一年。

### 展望

良好的性能是非常重要的。速度极慢的程序和不正确的程序一样无用，因此显然有必要在一开始就关注程序的运行成本，这能够让你大致估计出所要解决的问题的规模，而聪明的做法是时刻关注程序中的内循环代码的组成。

但在编程领域中，最常见的错误或许就是过于关注程序的性能。你的首要任务应该是写出清晰正确的代码。仅仅为了提高运行速度而修改程序的事最好留给专家们来做。事实上，这么做常常会降低生产效率，因为它会产生复杂而难以理解的代码。C.A.R.Hoare（快速排序的发明人，也是一位推动编写清晰而正确的代码的领军人物）曾将这种想法总结为：“不成熟的优化是所有罪恶之源。”Knuth为这句话加上了一个定语“在编程领域中（或者至少是大部分罪恶）”。另外，如果降低成本带来的效益并不明显，那么对运行时间的改进就不值得了。例如，如果一个程序所需的运行时间只是一瞬间而已，那么即使是将它的速度提高十倍也是无关紧要的。即使程序的运行需要好几分钟，实现并调试一个新算法所需要的时间也可能会大大超过直接运行一个稍微慢一点的算法——这种时候就应该让计算机代劳。更糟糕的情况是你可能花了大量的时间和心血去实现一个理论上能够改进程序的想法，但实际上什么也没发生。

在编程领域中，第二常见的错误或许是完全忽略了程序的性能。较快的算法一般都比暴力算法更复杂，所以很多人宁可使用较慢的算法也不愿应付复杂的代码。但是，几行优秀的代码有时能够给你带来巨大的收益。许多人在使用平方级别的暴力算法去解决问题的盲目等待中浪费了大量的时间，但实际上线性级别或是线性对数级别的算法能够在几分之一的时间内完成任务。当我们需要处理大规模问题时，通常，除了寻找更好的算法之外我们别无选择。

我们将使用本节所述的各种方法来评估算法对内存的使用，并在多个成本模型下对算法进行数学分析从而得到相应的近似函数，然后根据近似函数提出对算法所需的运行时间的增长数量级的猜想并通过实验验证它们。改进程序，使之更加清晰、高效和优雅应该是我们一贯的目标。如果你在开发一个程序的全过程中都能关注它的运行成本，那么你都会从该程序的每次执行中受益。

## 个人思考

### 实现算法的多进程版本

顺序执行的代码只能调度 CPU 的一个内核，所以占用 CPU 最多 100%, 但是实际上目前个人电脑和服务器多核已成标配。意味着即使进行非常复杂的计算，也无法占用 CPU 超过一个内核。在算法中设定线程数的两个限定：第一是能使用的 CPU 内核上限；第二是单个 CPU 执行一种算法子问题的合适容量大小。这两个条件均满足的话不再启动新的进程。达到解决算法问题使用多进程占用多个内核的目的。延伸阅读如下：
    
* [一文看懂Python多进程与多线程编程](https://zhuanlan.zhihu.com/p/46368084) ：Python多进程和多线程哪个快? 由于GIL的存在，很多人认为Python多进程编程更快，针对多核CPU，理论上来说也是采用多进程更能有效利用资源。网上很多人已做过比较，我直接告诉你结论吧。对CPU密集型代码(比如循环计算) - 多进程效率更高；对IO密集型代码(比如文件操作，网络爬虫) - 多线程效率更高。为什么是这样呢？其实也不难理解。对于IO密集型操作，大部分消耗时间其实是等待时间，在等待时间中CPU是不需要工作的，那你在此期间提供双CPU资源也是利用不上的，相反对于CPU密集型代码，2个CPU干活肯定比一个CPU快很多。那么为什么多线程会对IO密集型代码有用呢？这时因为python碰到等待会释放GIL供新的线程使用，实现了线程间的切换。

* [how to do multiprocessing in java, and what speed gains to expect?](https://stackoverflow.com/questions/8001966/how-to-do-multiprocessing-in-java-and-what-speed-gains-to-expect) ：No, in fact it would likely make it worse. If you were to switch from multithreading to multiprocessing, then you would effectively launch the JVM multiple times. Starting up a JVM is no simple effort. In fact, the way the JVM on your desktop machine starts is different from the way an enterprise company starts their JVM, just to reduce wait time for applets to launch for the typical end-user.

* [Processes and Threads](https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html) ：Threads are sometimes called lightweight processes. Both processes and threads provide an execution environment, but creating a new thread requires fewer resources than creating a new process. Threads exist within a process — every process has at least one. Threads share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication. Multithreaded execution is an essential feature of the Java platform. Every application has at least one thread — or several, if you count "system" threads that do things like memory management and signal handling.

