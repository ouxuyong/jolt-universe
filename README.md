# 这是一个jolt 使用教程的项目
jolt传送门  [官网地址](https://github.com/bazaarvoice/jolt).

# 目录
   1. [在线调试工具](#demo)
   2. [入门](#getting_started)
   3. [jolt的不同模式和用法](#jolt_type)



##  <a name="demo"></a> 在线调试工具
在线调试工具 [传送门地址](http://jolt-demo.appspot.com/).
你可以将json数据和jolt表达式在上面运行，由于这个在线工具是托管在 Google App Engine 上面的，国内的网络可能无法访问

## <a name="getting_started"></a> 入门
入门教程传送门 [地址](gettingStarted.md).
## <a name="jolt_type"></a> jolt的不同模式和用法
```
shift       : 复制输入json到输出json
default     : 为json树增加默认值
remove      : 从json树中去除数据
sort        : 按字母顺序排序映射键值
cardinality : 修正输入数据的基数。urls元素通常是一个List，但是如果只有一个，那么它就是一个字符串
modify-overwrite-beta:总是写
modify-default-beta:当键值对应的值是null时写入
modify-define-beta:当键值不存在时写入
自定义Java类全路径名称:实现Transform或ContextualTransform接口,可选择SpecDriven接口

```
上面的前5种类型都只对json的结构进行转换，如果需要对数据进行操作则需要用到modify等相关操作
这里也给大家推荐一下，同样分享jolt的博主 [Panda诚博客 传送门](https://zhangchengk.gitee.io/jolt/JsonJolt%E6%95%99%E7%A8%8B/#%E6%A6%82%E8%A7%88).

