# Blog System

一个基于 **Spring Boot + MyBatis-Plus** 的博客系统项目，同时包含后端业务实现、MySQL 数据持久化、Linux 部署验证以及 Selenium / JMeter 测试实践。

该项目不仅完成博客业务功能，还进一步补充了 UI 自动化测试、接口/性能测试以及测试报告，用于展示从 **开发 → 部署 → 测试 → 问题排查** 的完整实践过程。

---

## Tech Stack

### Backend

- Java 17
- Spring Boot 3.x
- MyBatis-Plus
- MySQL
- Maven
- HTML / JavaScript

### Testing

- Selenium
- ChromeDriver
- WebDriverManager
- JMeter
- Postman
- Screenshot evidence / test report

### Deployment

- Linux
- Java `jar` deployment
- `curl` verification
- Application logs
- MySQL connection troubleshooting
- Port / runtime environment troubleshooting

---

## Main Features

博客系统后端项目目录：

```text
spring-blog-demo/
```

主启动类：

```text
com.bit.blog.SpringBlogDemoApplication
```

目前实现的主要功能包括：

- 用户登录
- 博客列表查询
- 博客详情查看
- 创建博客
- 编辑博客
- 删除博客
- 分页查询
- 条件查询
- 逻辑删除
- 基于登录用户控制博客编辑 / 删除权限

MyBatis-Plus 用于完成主要 CRUD、条件查询、分页以及逻辑删除等数据访问操作。

---

## Project Structure

项目由博客系统本体和测试工程组成。

```text
.
├── spring-blog-demo/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
│
└── blog-system-testing/
    ├── README.md
    ├── selenium-demo/
    ├── postman/
    ├── jmeter/
    ├── docs/
    └── evidence/
```

Selenium 测试代码主要位于：

```text
src/test/java/com/bit/selenium/
```

其中包含：

```text
RunTest.java
Utils.java
LoginPage.java
ListPage.java
EditPage.java
DetailPage.java
```

---

## Selenium UI Automation

Selenium 测试采用页面对象拆分方式，对登录和博客核心页面进行自动化操作。

主要测试内容包括：

- 登录页面检查
- 异常登录
- 正常登录
- 博客列表页面验证
- 创建博客
- 博客详情页面脚本
- 编辑博客脚本
- 删除博客脚本

其中，当前 `RunTest` 快照中已重点运行登录、博客列表和创建博客相关场景；详情、编辑、删除对应脚本已经实现，但部分调用在当前测试入口中处于注释状态。

### Page Objects

```text
LoginPage.java
    ↓
登录相关操作

ListPage.java
    ↓
博客列表相关操作

DetailPage.java
    ↓
博客详情相关操作

EditPage.java
    ↓
博客编辑相关操作
```

`Utils.java` 主要负责：

- WebDriver 初始化
- 显式等待
- Alert / 弹窗处理
- 页面截图
- 公共 Selenium 操作

---

## Selenium Test Flow

典型测试流程：

```text
Open Browser
    ↓
Login Page
    ↓
Invalid Login / Valid Login
    ↓
Blog List
    ↓
Create Blog
    ↓
Blog Detail
    ↓
Edit / Delete
```

自动化测试重点验证：

- 页面是否可以正常访问
- 登录业务是否正确
- 用户登录后是否能够进入博客列表
- 博客创建流程是否可以正常完成
- 页面跳转和关键元素是否符合预期

---

## JMeter Performance Testing

博客系统使用 JMeter 进行了并发性能测试。

测试线程组采用：

```text
jp@gc - Stepping Thread Group
```

### Test Configuration

```text
Maximum Threads: 20
Start Users Count: 5 users per stage
Start Users Period: 2 s
Ramp-Up: 5 s
Hold Load: 30 s
```

### Test Result

| Metric | Result |
|---|---:|
| Samples | 4420 |
| Error Rate | 0.00% |
| Average Response Time | 525 ms |
| P95 | 1471 ms |
| P99 | 2038 ms |
| Throughput | ~14.8 requests/s |

测试结果显示，在当前测试环境和压力模型下，请求均成功完成，没有出现请求错误。

> 以上数据来自项目测试环境，用于展示测试过程和性能表现，不代表生产环境最大承载能力。

---

## Performance Testing Focus

性能测试主要关注：

```text
Concurrent Users
    ↓
Request Execution
    ↓
Response Time
    ↓
P95 / P99
    ↓
Throughput
    ↓
Error Rate
```

重点指标包括：

- Average Response Time
- P95
- P99
- Throughput
- Error Rate

通过 JMeter 报告判断系统在并发访问下的稳定性和响应情况。

---

## Deployment

博客系统已经在 Linux 环境中进行部署和线上验证。

典型部署流程：

```text
Maven Build
    ↓
Generate JAR
    ↓
Upload to Linux
    ↓
java -jar
    ↓
Check Java Process
    ↓
Check Port
    ↓
curl Verification
    ↓
Check Application Logs
```

在部署过程中也进行了实际问题排查，包括：

- MySQL 数据库连接
- 数据库认证问题
- 应用端口检查
- Java 运行环境检查
- Spring Boot 日志分析
- Linux 下应用进程检查

---

## Build

进入后端项目：

```powershell
cd spring-blog-demo
```

Windows 下使用 Maven Wrapper：

```powershell
.\mvnw.cmd clean package
```

如果只需要构建应用并跳过测试：

```powershell
.\mvnw.cmd clean package -DskipTests
```

生成的 JAR 文件位于：

```text
target/
```

---

## Run

确保：

- Java 17 已安装
- MySQL 已启动
- 数据库配置正确

然后运行：

```powershell
java -jar target/<your-blog-jar>.jar
```

或者直接通过 IDE 启动：

```text
SpringBlogDemoApplication
```

---

## Database

项目使用 MySQL 保存：

- 用户信息
- 博客内容
- 博客状态
- 创建 / 修改相关业务数据

MyBatis-Plus 负责主要数据库操作。

主要数据访问能力包括：

```text
Insert
Select
Update
Logical Delete
Conditional Query
Pagination
```

---

## Testing Repository

测试工程结构：

```text
blog-system-testing/
├── selenium-demo/     # Selenium UI 自动化
├── postman/           # 接口测试相关内容
├── jmeter/            # JMeter 性能测试
├── docs/              # 测试说明 / 报告
└── evidence/          # 截图及测试证据
```

该结构用于将测试代码、测试脚本、测试结果和测试证据与业务代码分开管理。

---

## Testing Summary

整个博客系统的实践内容可以总结为：

```text
Blog System
│
├── Spring Boot Backend
│   ├── Login
│   ├── Blog CRUD
│   ├── Permission Control
│   └── MyBatis-Plus
│
├── MySQL
│
├── Linux Deployment
│   ├── java -jar
│   ├── curl
│   ├── Port Check
│   └── Log Troubleshooting
│
├── Selenium UI Automation
│   ├── Login
│   ├── Blog List
│   ├── Create Blog
│   ├── Detail
│   ├── Edit
│   └── Delete
│
└── JMeter Performance Testing
    ├── 20 Max Threads
    ├── 4420 Samples
    ├── 0.00% Error
    ├── Avg 525 ms
    ├── P95 1471 ms
    └── P99 2038 ms
```

项目重点展示了从 **Java Web 开发、数据库访问、Linux 部署，到 Selenium 自动化和 JMeter 性能测试** 的完整实践流程。

---

## Security

公开 GitHub 仓库时，请不要提交：

```text
Database Password
Mail Authorization Code
AccessKey / Secret
JWT Secret
Real Test Account Password
Private Key
.env
```

建议使用环境变量或本地私有配置文件保存敏感信息。

同时建议 `.gitignore` 排除：

```text
.idea/
target/
*.iml
*.log
.env
```

---


## Author

**Haoran Yang**
