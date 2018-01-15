# EasyServiceAutomator

This jar file is designed to automate RESTful Web Services on the top of [HttpClient](https://hc.apache.org/httpcomponents-client-ga/).

MVN Dependency:
===============

```
<dependency>
	<groupId>com.github.sitangshupal.ServiceAutomator</groupId>
	<artifactId>easyServiceAutomator</artifactId>
	<version>1.0.0</version>
</dependency>
```

# Usage

* Add header to the request:

```
private ServiceRelated sr = new ServiceRelated();
sr. setHeader("header name", "header value");
for ex:
sr.setHeader("User-Agent", "Mozilla/5.0");
```

* Add Post Request Parameter:

```
sr. setParamList ("param name", "param value");
for ex:
sr.setParamList("user name", "your user name");
```

* To set Use System Properties:
```
sr. setUseSystemProperties();
```

* To set default cookie store:
```
sr. setDefaultCookieStore();
```

* Get the page content(Get Request):
```
sr. GetPageContent(“url of the get request”);
It will return the page content(String)
```

* Send post request:
```
sr. sendPost(“url of the post request”);
```

* Get the response code of the request:
```
sr.getResponseCode();
```


# For Get method

```
	private static ServiceRelated sr = new ServiceRelated();

	public void getMethodDemo(){

		String pageContent = sr.
				setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8").
				setHeader("Accept-Language", "en-US,en;q=0.9,und;q=0.8").
				setHeader("Host", "host name").
				setHeader("User-Agent", "Mozilla/5.0").
				setHeader("Connection", "keep-alive").
				GetPageContent("url");

		if(pageContent.contains("expected text")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}
```

# For Post method

```	
	public void postMethodDemo(){
	
		sr.
		setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8").
		setHeader("Accept-Language", "en-US,en;q=0.9,und;q=0.8").
		setHeader("Host", "host name").
		setHeader("User-Agent", "Mozilla/5.0").
		setHeader("Connection", "keep-alive").
		setParamList("param1", "param1 value").
		setParamList("param2", "param2 value").
		sendPost("url");

		System.out.println(sr.getResponseCode());
		
	}
```