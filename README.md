## wlt社区

##资料 
[Spring 文档](https://spring.io/guides)

[Spring Web](https://spring.io/guides/gs/serving-web-content/)

[码匠](https://space.bilibili.com/406041527/)

[BootStrap](https://www.bootcss.com/)

[GitHub OAuth Documents](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[Spring Connection to a Production Database](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-connect-to-production-database)

[Maven](https://mvnrepository.com/)

[springboot mybatis](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

##工具
[Git](https://git-scm.com/downloads)

[Visual Paragram]()

[flyway](https://flywaydb.org/getstarted/firststeps/maven)

##脚本

'''sql

create table USER
(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(100),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
);

'''

'''bash

mvn flyway:migrate

'''