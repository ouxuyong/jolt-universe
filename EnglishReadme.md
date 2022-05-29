# This is a jolt tutorial project   
**Jolt is a JSON-to-JSON conversion library written in Java, which can convert a json we input into a target json.**  

Jolt official website address [bazaarvoice/jolt](https://github.com/bazaarvoice/jolt).     

This project will continue to be updated to bring you more complete and better jolt usage tutorials. If you have any questions, or if you need to convert json, you can indicate input  and output  in issues, We can discuss and communicate together.  

If there is an error in the description in the text, please leave a message in time to point it out. If reproduced, please indicate the source.


# content
   1. [Online debugging tool](#demo)
   2. [getting Started](#getting_started)
   3. [Different modes and usage of jolt](#jolt_type)
   4. [Custom jolt implementation class](#customize)



##  <a name="demo"></a> Online debugging tool
Online debugging tool [jolt-demo](http://jolt-demo.appspot.com/).  

You can run json data and jolt expressions on it, this online tool is hosted on Google App Engine
![image](https://user-images.githubusercontent.com/57780019/168436337-7f7cc9f5-0a32-4103-88d0-b7283b9e40cb.png)


## <a name="getting_started"></a> getting started  
Getting Started Tutorial Documentation Address [gettingStarted](EnglishGettingStarted.md).
## <a name="jolt_type"></a> Different modes and usage of jolt
```
shift       : Copy input json to output json  
default     : Add default values to the output json tree  
remove      : Remove the specified key from the json tree  
sort        : Sort map key values alphabetically  
cardinality : Correct the cardinality of the input data. The urls element is usually a List, but if there is only one then it is a string  
modify-overwrite-beta: always write  
modify-default-beta: Write when the value corresponding to the key value is null  
modify-define-beta: Write when key value does not exist  

Customize the full path name of the Java class: implement the Transform or ContextualTransform interface, and select the SpecDriven interface
The above modes can be used in combination with each other, which will be explained in detail below.

```
The first five types above only convert the structure of json. If you need to operate on the data, you need to use related operations such as modify  

Below I will give you a detailed explanation of the usage of the above different modes and some examples.  
Detailed example of shift mode  [shift explain](src/test/resources/docs/shift/EnglishShift.md).  
Detailed example of default mode  [default explain](src/test/resources/docs/default/EnglishDefault.md).  
Detailed example of remove mode  [remove explain](src/test/resources/docs/remove/EnglishRemove.md).  
Detailed example of cardinality mode  [cardinality explain](src/test/resources/docs/cardinality/EnglishCardinality.md).  
Detailed example of modify mode [modify explain](src/test/resources/docs/modify/EnglishModify.md).  
Cases where different modes are used in combination [combine explain](src/test/resources/docs/combine/EnglishCombine.md).  

## <a name="customize"></a> Custom jolt implementation class  
We need to customize a JoltCustomizedModifier class, which implements the SpecDriven and ContextualTransform interfaces. There is a Map in the JoltCustomizedModifier class to store our custom code.
Here we also need to create a JoltCustomizedFunction class whose inner class is used to write our custom method.  

The following is a custom implementation class for the conversion problem I solved for a developer on the jolt official website,address of this question [Self containing object - Recursively replace a field name](https://github.com/bazaarvoice/jolt/issues/1114)。
He needs a way to recursively replace keys.  

Here is the custom implementation class I created for him[JoltCustomizedModifier](src/main/java/com/example/oxy/jolt/JoltCustomizedModifier.java) and [JoltCustomizedFunction](src/main/java/com/example/oxy/jolt/JoltCustomizedFunction.java)     
Here is the test demo [CustomizedTest](src/test/java/com/example/oxy/customized/CustomizedTest.java)
