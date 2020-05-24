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

* 理解链表是学习各种算法和数据结构中最关键的第一步。
* 链表的使用达到了我们的最优设计目标：
  1. 它可以处理任意类型的数据；
  2. 所需要的空间总是和集合的大小成正比；
  3. 操作所需的时间总是和集合的大小无关。

## 个人思考

* 实现算法的多进程版本：顺序执行的代码只能调度 CPU 的一个内核，所以占用 CPU 最多 100%, 但是实际上目前个人电脑和服务器多核已成标配。意味着即使进行非常复杂的计算，也无法占用 CPU 超过一个内核。在算法中设定线程数的两个限定：第一是能使用的 CPU 内核上限；第二是单个 CPU 执行一种算法子问题的合适容量大小。这两个条件均满足的话不再启动新的进程。达到解决算法问题使用多进程占用多个内核的目的。


