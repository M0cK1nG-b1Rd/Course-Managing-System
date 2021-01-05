# Course-Managing-System



Course-Managing-System为前后端分离开发的项目管理综合实训管理系统，前端使用Vue全家桶，组件库采用[Ant-Design-Vue](https://vuecomponent.github.io/ant-design-vue/docs/vue/introduce-cn/)和[Element-UI](https://element.eleme.cn/#/zh-CN/guide/design)。



本项目参考项目地址为https://github.com/wx7614140/FEBS-Vue-Fix，感谢鸟先生，FEBS项目组以及所有为这个项目作出贡献的群友们



文档里介绍的示例是在Windows10操作系统下完成的，后端编辑器使用IDEA，前端编辑器使用WebStorm和PhpStorm。

## 项目导入

为了方便，我直接在桌面上通过git bash克隆项目：

```
git clone https://github.com/M0cK1nG-b1Rd/Course-Managing-System.git
```



克隆后，桌面上多出一个Course-Managing-System文件夹：

![image-20210105111727098](.\images\image-20210105111727098.png)

backend为后端项目源码，frontend为前端项目源码，sql为数据库初始化脚本。

### JDK

因为项目用到了JDK 8的一些特性，所以JDK最低版本不能低于8。但某个库由于版本原因JDK版本也不宜太高

JDK 8官方下载地址：https://www.oracle.com/technetwork/java/javase/downloads。

### 安装Node.js

Node.js下载地址：http://nodejs.cn/download/，直接安装即可，安装后查看其版本：

![image-20210105093409190](.\images\image-20210105093409190.png)

Node.js集成了npm，所以安装好Node.js后npm就可以使用了：

![image-20210105093650630](.\images\image-20210105093650630.png)

### 安装yarn

在CMD中执行`npm install -g yarn`：

![image-20210105094110160](.\images\image-20210105094110160.png)

因为我之前已经安装过了，所以这里就相当于更新操作了。

### 安装Redis

项目缓存数据库使用的是Redis，所以在导入项目前需先安装Redis。

Redis Windows版本下载地址：https://github.com/MicrosoftArchive/redis/releases。直接下载zip版本解压到任意目录即可。

下载后，使用cmd命令切换到Redis根目录，然后运行`redis-server.exe`启动即可：

![image-20210105094307450](.\images\image-20210105094307450.png)

### 安装MySQL

项目数据库采用MySQL社区版，版本为8.0.x。

下载地址：https://dev.mysql.com/downloads/mysql/

### 导入SQL

使用Navicat新建一个数据库：

![image-20210105094852644](.\images\image-20210105094852644.png)

然后导入SQL脚本即可。

### 导入后端项目

IDEA选择backend：

![image-20210105095159297](.\images\image-20210105095159297.png)

导入项目后安装lombok插件（不懂lombok可以自行百度）：

![image-20210105095300537](.\images\image-20210105095300537.png)

安装完重启IDEA才能生效。

接着修改application.yml中的数据库和Redis配置，修改完后通过Spring Boot入口类FebsApplication启动即可：

![image-20210105095426330](.\images\image-20210105095426330.png)

接着开始导入前端项目。

### 导入前端项目

使用WebStorm打开frontend：

![image-20210105110632811](.\images\image-20210105110632811.png)

在终端输入`yarn install`命令安装依赖：

![image-20210105110841843](.\images\image-20210105110841843.png)

稍等片刻，坐与放宽。

依赖下载完毕后，输入yarn start启动前端项目：

![image-20210105111045811](.\images\image-20210105111045811.png)

浏览器访问[http://localhost:8081](http://localhost:8081/)：

![image-20210105111110223](.\images\image-20210105111110223.png)