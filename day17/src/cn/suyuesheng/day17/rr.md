## EL表达式

	1. 概念：Expression Language 表达式语言
	2. 作用：替换和简化jsp页面中java代码的编写
	3. 语法：${表达式}
	4. 注意：
		* jsp默认支持el表达式的。如果要忽略el表达式
			1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
			2. \${表达式} ：忽略当前这个el表达式


	5. 使用：
		1. 运算：
			* 运算符：
				1. 算数运算符： + - * /(div) %(mod)
				2. 比较运算符： > < >= <= == !=
				3. 逻辑运算符： &&(and) ||(or) !(not)
				4. 空运算符： empty
					* 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
					* ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
					* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0
		2. 获取值
			1. el表达式只能从域对象中获取值
			2. 语法：
				1. ${域名称.键名}：从指定域中获取指定键的值
					* 域名称：
						1. pageScope		--> pageContext
						2. requestScope 	--> request
						3. sessionScope 	--> session
						4. applicationScope --> application（ServletContext）
					* 举例：在request域中存储了name=张三
					* 获取：${requestScope.name}
	
				2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。


​				
​				

				3. 获取对象、List集合、Map集合的值
					1. 对象：${域名称.键名.属性名}
						* 本质上会去调用对象的getter方法
	
					2. List集合：${域名称.键名[索引]}
	
					3. Map集合：
						* ${域名称.键名.key名称}
						* ${域名称.键名["key名称"]}


		3. 隐式对象：
			* el表达式中有11个隐式对象
			* pageContext：
				* 获取jsp其他八个内置对象
					* ${pageContext.request.contextPath}：动态获取虚拟目录


​	

## JSTL

	1. 概念：JavaServer Pages Tag Library  JSP标准标签库
		* 是由Apache组织提供的开源的免费的jsp标签		<标签>
	
	2. 作用：用于简化和替换jsp页面上的java代码		
	
	3. 使用步骤：
		1. 导入jstl相关jar包
		2. 引入标签库：taglib指令：  <%@ taglib %>
		3. 使用标签
	
	4. 常用的JSTL标签
		1. if:相当于java代码的if语句
			1. 属性：
	            * test 必须属性，接受boolean表达式
	                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
	                * 一般情况下，test属性值会结合el表达式一起使用
	   		 2. 注意：
	       		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
		2. choose:相当于java代码的switch语句
			1. 使用choose标签声明         			相当于switch声明
	        2. 使用when标签做判断         			相当于case
	        3. 使用otherwise标签做其他情况的声明    	相当于default
	
		3. foreach:相当于java代码的for语句
	
	5. 练习：
		* 需求：在request域中有一个存有User对象的List集合。需要使用jstl+el将list集合数据展示到jsp页面的表格table中

