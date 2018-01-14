# EasyServiceAutomator

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

