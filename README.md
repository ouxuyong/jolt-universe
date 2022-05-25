# 这是一个jolt 使用教程的项目  (This is a jolt tutorial project)  
**For the English version, please click [English document](EnglishReadme.md).**  

**Jolt是用Java编写的JSON到JSON转换库，可以将我们输入的一个json,转换成目标json.**    
jolt官网地址传送门  [bazaarvoice/jolt](https://github.com/bazaarvoice/jolt).  
 
本项目会持续更新，为大家带来更全、更好的jolt用法教程，如果大家有什么疑问，或者有什么需要转换json，可以在issues 中注明 input（输出），和Output（输出），
大家可以一起探讨交流。  
文中如有描述错误，请及时留言指出。如有转载，请标明出处。


# 目录
   1. [在线调试工具](#demo)
   2. [入门](#getting_started)
   3. [jolt的不同模式和用法](#jolt_type)



##  <a name="demo"></a> 在线调试工具
在线调试工具 [传送门地址](http://jolt-demo.appspot.com/).
你可以将json数据和jolt表达式在上面运行，由于这个在线工具是托管在 Google App Engine 上面的，国内的网络可能无法访问
![image](https://user-images.githubusercontent.com/57780019/168436337-7f7cc9f5-0a32-4103-88d0-b7283b9e40cb.png)


## <a name="getting_started"></a> 入门
入门教程传送门 [gettingStarted](gettingStarted.md).
## <a name="jolt_type"></a> jolt的不同模式和用法
```
shift       : 将输入json复制到输出json
default     : 为输出的json树中增加默认值
remove      : 从json树中去除指定的key
sort        : 按字母顺序排序映射键值
cardinality : 修正输入数据的基数。urls元素通常是一个List，但是如果只有一个，那么它就是一个字符串
modify-overwrite-beta:总是写
modify-default-beta:当键值对应的值是null时写入
modify-define-beta:当键值不存在时写入
自定义Java类全路径名称:实现Transform或ContextualTransform接口,可选择SpecDriven接口
上面的模式是可以互相结合使用的，下文会详细讲解
以上的说明借鉴了"Panda诚博客" 博客的内容，下面有给出博主的博客地址
```
上面的前5种类型都只对json的结构进行转换，如果需要对数据进行操作则需要用到modify等相关操作
这里也给大家推荐一下，同样分享jolt的博主 [Panda诚博客 传送门](https://zhangchengk.gitee.io/jolt/JsonJolt%E6%95%99%E7%A8%8B/#%E6%A6%82%E8%A7%88).
下面我会给大家详细说明以上不同模式的用法和一些样例。  
shift模式的详细例子 [shift explain](src/test/resources/docs/shift/shift.md).  
default 模式的详细例子 [default explain](src/test/resources/docs/default/default.md).  
remove 模式的详细例子 [remove explain](src/test/resources/docs/remove/remove.md).  
cardinality 模式的详细例子 [cardinality explain](src/test/resources/docs/cardinality/cardinality.md).  
modify 模式的详细例子[modify explain](src/test/resources/docs/modify/modify.md).  
不同模式结合使用的案例[combine explain](src/test/resources/docs/combine/combine.md).  
