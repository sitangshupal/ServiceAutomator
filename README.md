# EasyServiceAutomator

# MVN Dependency:
&lt;dependency&gt;
	&lt;groupId&gt;com.github.sitangshupal.ServiceAutomator&lt;/groupId&gt;
	&lt;artifactId&gt;easyServiceAutomator&lt;/artifactId&gt;
	&lt;version&gt;1.0.0&lt;/version&gt;
&lt;/dependency&gt;

# Usage

* Add header to the request:
`code(
private ServiceRelated sr = new ServiceRelated();
sr. setHeader("header name", "header value");
for ex:
sr.setHeader("User-Agent", "Mozilla/5.0");
)`

* Add Post Request Parameter:
sr. setParamList ("param name", "param value");
for ex:
sr.setParamList("user name", "your user name");

* To set Use System Properties:
sr. setUseSystemProperties();

* To set default cookie store:
sr. setDefaultCookieStore();

* Get the page content(Get Request):
sr. GetPageContent(“url of the get request”);
It will return the page content(String)

* Send post request:
sr. sendPost(“url of the post request”);

* Get the response code of the request:
sr.getResponseCode();


