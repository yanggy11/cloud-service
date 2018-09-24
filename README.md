# spring cloud

### 配置中心参数加密

在Git仓库中存储配置信息都是明文，但在某些场景下，一些比较敏感的内容（如数据库账号与密码），不易以明文存储，应当加密存储。Config Server为配置内容的加密与解密提供了很好地支持。

#### 安装JCE

config server的加解密功能依赖于Java的Java Cryptography Extension（JCE）模块，故需要先安装JCE.

jdk8 JCE下载地址
```
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html 。
```

下载后解压jce文件夹，将文件拷贝到 java_home/jre/lib/security下即可。

