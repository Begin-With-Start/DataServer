url:http://www.admin10000.com/document/6436.html　

Spring mvc 的常用注解：
  @Controller
　　负责注册一个bean 到spring 上下文中

　　@RequestMapping
　　注解为控制器指定可以处理哪些 URL 请求

　　@RequestBody
　　该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上 ,再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上

　　@ResponseBody
　　该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区

　　@ModelAttribute 　　　
　　在方法定义上使用 @ModelAttribute 注解：Spring MVC 在调用目标处理方法前，会先逐个调用在方法级上标注了@ModelAttribute 的方法
　　在方法的入参前使用 @ModelAttribute 注解：可以从隐含对象中获取隐含的模型数据中获取对象，再将请求参数 –绑定到对象中，再传入入参将方法入参对象添加到模型中 

　　@RequestParam　
　　在处理方法入参处使用 @RequestParam 可以把请求参 数传递给请求方法

　　@PathVariable
　　绑定 URL 占位符到入参

　　@ExceptionHandler
　　注解到方法上，出现异常时会执行该方法

　　@ControllerAdvice
　　使一个Contoller成为全局的异常处理类，类中用@ExceptionHandler方法注解的方法可以处理所有Controller发生的异常


接口列表：

获取设备的信息列表：
	http://localhost:8080/DataServer/machine/info
	{"os_name":"Windows 7","os_arch":"amd64","os_ip":"192.168.200.95","os_mac":"70-8B-CD-B8-BF-94","os_date":1488959393537,"os_cpus":4,"os_user_name":"xiaofei.he","os_user_dir":"D:\\pc_program\\myeclipsedata\\plugins\\com.genuitec.eclipse.easie.tomcat.myeclipse_8.4.200.me201001111827\\tomcat\\bin","os_user_home":"C:\\Users\\Administrator","java_version":"1.8.0_45","java_io_tmpdir":"F:\\myeclipse_workspace\\.metadata\\.me_tcat\\temp","sun_desktop":"windows","file_separator":"\\","path_separator":";","line_separator":"\r\n","server_context":null,"server_name":null,"server_port":null,"server_addr":null,"server_host":null,"server_protocol":null}

通过用户的id获取一下用户的信息：
	http://localhost:8080/DataServer/info/getPersonPhoto?userId=523216808
	{"code":"0","msg":"success","data":[{"image_url":"http://img.alicdn.com/imgextra/i3/523216808/TB11cm3GFXXXXa8XXXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i3/523216808/TB14gOWGFXXXXbhXFXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i2/523216808/TB1pAq0GFXXXXXXXpXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i4/523216808/TB1j7OVGFXXXXcxXFXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i3/523216808/TB1PXC1GFXXXXcKXXXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i1/523216808/TB1F85TGFXXXXbNXVXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i1/523216808/TB112QbGFXXXXbMXpXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i4/523216808/TB1VgIXGFXXXXX_XFXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i4/523216808/TB1UpAdGFXXXXXvXpXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i2/523216808/TB1zAv8GFXXXXccXVXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i2/523216808/TB17OgbGFXXXXbAXpXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i3/523216808/TB1wIf_GFXXXXXWXVXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i1/523216808/TB1r27fGFXXXXX_XXXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i3/523216808/TB1gCT.GFXXXXaWXFXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i1/523216808/TB1x9n_GFXXXXcxXFXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i3/523216808/TB1i1AXGFXXXXcQXpXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i2/523216808/TB1y6MdGFXXXXcvXXXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i1/523216808/TB1prIXGFXXXXX2XFXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i1/523216808/TB164UdGFXXXXaSXXXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i1/523216808/TB1_YD9GFXXXXa4XVXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"}]}

获取主页的信息：
	http://localhost:8080/DataServer/info/getMainPage
	{"code":"0","msg":"success","data":[{"image_url":"http://img.alicdn.com/imgextra/i2/523216808/TB17w1ZGFXXXXbbXpXXXXXXXXXX_!!523216808-0-tstar.jpg","user_id":"523216808"},{"image_url":"http://img.alicdn.com/imgextra/i1/539549300/TB1S54tIpXXXXa0XFXXXXXXXXXX_!!539549300-0-tstar.jpg","user_id":"539549300"},{"image_url":"http://img.alicdn.com/imgextra/i3/631300490/TB18otCLXXXXXbOaXXXXXXXXXXX_!!0-tstar.jpg","user_id":"631300490"},{"image_url":"http://img.alicdn.com/imgextra/i4/13008032069895178/T1MJE5FaXdXXXXXXXX_!!63153008-0-tstar.jpg","user_id":"63153008"},{"image_url":"http://img.alicdn.com/imgextra/i4/646858747/TB1y49uJVXXXXaQXpXXXXXXXXXX_!!646858747-0-tstar.jpg","user_id":"646858747"},{"image_url":"http://img.alicdn.com/imgextra/i1/687471686/TB1aIeELFXXXXcrapXXXXXXXXXX_!!0-tstar.jpg","user_id":"687471686"},{"image_url":"http://img.alicdn.com/imgextra/i3/717492986/TB1jybTLXXXXXcIaXXXXXXXXXXX_!!717492986-0-tstar.jpg","user_id":"717492986"},{"image_url":"http://img.alicdn.com/imgextra/i1/74386764/TB1tM0cGFXXXXXNXVXXXXXXXXXX_!!74386764-0-tstar.jpg","user_id":"74386764"},{"image_url":"http://img.alicdn.com/imgextra/i4/18272043535448294/T1iMGPFfViXXXXXXXX_!!76438272-0-tstar.jpg","user_id":"76438272"},{"image_url":"http://img.alicdn.com/imgextra/i2/91442126/TB1AWJAHpXXXXclXVXXXXXXXXXX_!!91442126-0-tstar.jpg","user_id":"91442126"},{"image_url":"http://img.alicdn.com/imgextra/i2/96614110/TB1urhoKXXXXXcIXXXXXXXXXXXX_!!0-tstar.jpg","user_id":"96614110"}]}


获取妹纸的首页信息
	http://localhost:8080/DataServer/meizhi/getMeizhiImage?page=1

通过id获取当前妹纸的全部照片
	http://localhost:8080/DataServer/meizhi/getMeizhiImageById?id=1

通过page获取video
	http://localhost:8080/DataServer/meizhi/getMeizhiVideo?page=0

=======
	
获取相册集的信息： (从零开始计数)
	http://localhost:8080/DataServer/meizhi/getMeizhiAlbum?page=0
	
通过id获取当前的用户的照片：
	http://localhost:8080/DataServer/meizhi/getMeizhiImageById?id=1
	










