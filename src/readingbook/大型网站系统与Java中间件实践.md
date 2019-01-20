# 大型网站系统与Java中间件实践


## 1.分布式系统介绍

从单机到分布式,哪些组件需要调整?

## 2.大型网站及其架构演进过程

Session问题的解决方案:
* Session Sticky
* Session Replication
* Session集中存储
* Cookie-based

TODO: MySQL中的主从复制,以及如何应对数据不同步问题?


采用多种存储系统来满足系统的需求

数据库分库分表


## 3.构建Java中间件

Java的一些基础知识要有

## 4.服务框架 :+1:

实现一个服务框架要考虑哪些问题?

Java序列化的问题:跨语言;性能;序列化后的长度.

TODO 学习Dubbo


## 5.数据访问层

分布式事务:XA规范,2PC

CAP, BASE理论

TODO Paxos算法理解

UID

## 6.消息中间件



## 7.软负载中心与集中配置管理

软负载中心就是服务框架里面需要的服务注册中心

配置中心


## 8.其他要素

CDN

GFS

Storm

ES

发布系统

监控系统

多机房问题

