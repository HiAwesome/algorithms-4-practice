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

* 理解链表是学习各种算法和数据结构中最关键的第一步。 ——P074
