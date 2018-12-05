#XXL-CRAWLER 


## 核心概念

|概念   |说明|
| ---- | :---- |
|XxlCrawler|	爬虫对象，维护爬虫信息|
|PageVo    |	页面数据对象，一张Web页面可抽取一个或多个PageVo|
|PageLoader|	Wed页面加载器，负责加载页面数据，支持灵活的自定义和扩展|
|PageParser|	Wed页面解析器，绑定泛型PageVO后将会自动抽取页面数据对象，同时支持运行时调整请求参数信息；|

NonPageParser ： 非Web页面解析器，如JSON接口等，直接输出响应数据

## 爬虫对象：XxlCrawler
功能：爬虫对象，维护爬虫信息，可选属性如下。

|方法|	说明|
| ---- | :---- |
|setUrls       |	待爬的URL列表|
|setAllowSpread|	允许扩散爬取，将会以现有URL为起点扩散爬取整站|
|setWhiteUrlRegexs|	URL白名单正则，非空时进行URL白名单过滤页面|
|setIfPost	   | 请求方式：true=POST请求、false=GET请求|
|setUserAgent|	UserAgent|
|setParamMap|	请求参数|
|setCookieMap  |请求Cookie|
|setTimeoutMillis|	超时时间，毫秒|
|setPauseMillis|	停顿时间，爬虫线程处理完页面之后进行主动停顿，避免过于频繁被拦截；|
|setProxyMaker|	代理生成器，支持设置代理IP，同时支持调整代理池实现动态代理；|
|setThreadCount|	爬虫并发线程数|
|setPageParser|	页面解析器|
|setPageLoader|	页面加载器，默认提供 "JsoupPageParser" 和 "HtmlUnitPageLoader" 两种实现；|
|setRunData|	设置运行时数据模型，默认提供LocalRunData单机模型，支持扩展实现分布式模型；|
|start     |	运行爬虫，可通过入参控制同步或异步方式运行|
|stop      |	终止爬虫|
## 核心注解：PageSelect
功能：描述页面数据对象，通过该注解从页面抽取PageVo数据信息，可选属性如下。

|PageSelect|说明|
| ---- | :---- |
|cssQuery|	CSS选择器, 如 "#body"|

##  核心注解：PageFieldSelect
功能：描述页面数据对象的属性信息，通过该注解从页面抽取PageVo的属性信息，可选属性如下。
（支持基础数据类型 T ，包括 List）

|PageFieldSelect|	说明|
| ---- | :---- |
|cssQuery	|    CSS选择器, 如 "#title"|
|selectType	|    jquery 数据抽取方式，如 ".html()/.text()/.val()/.attr()"等|
|selectVal	|    jquery 数据抽取参数，SelectType=ATTR 时有效，如 ".attr("abs:src")"|
|datePattern|	 时间格式化，日期类型数据有效|
