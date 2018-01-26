
本次作业内容在Solution.java文件中

运行步骤如下：
=============================================================================

- 请将参数输入文件(.txt)存放至与Solution.java相同的路径中

- 请打开terminal，并进入上述存有.txt文件及.java文件的路径

- 在terminal 中输入 javac Solution.java 进行编译，成功后将出现Solution.class文件

- 在terminal 中通过下列格式执行编译后文件：java Solution <file name> <signal index> ，其中file name(需包含拓展名)为程序将阅读的无人机回传信息, signal index 为所需查询的消息序号

- 程序将返回该序号所对应的输出信息

例如：

$ javac Solution.java

$ java Solution test.txt 4
Error: 4

$ java Solution test.txt 2
plane1 2 3 4 5

注：压缩文件中有供示范测试的输入文件test.txt
=============================================================================

作者：吉永杰
时间：2018年1月17日
邮箱：278099723@qq.com/ yj974@nyu.edu
电话：+86-15994704566/ +01-929-522-7887
