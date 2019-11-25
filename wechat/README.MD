#项目简介
本项目采用MVP的架构模式，图片加载使用Glide，网络请求使用Retrofit+RxJava+OkHttp。目前项目分为两个module，分别为app和base。app为应用实现，base为抽取的一些基础实现可以提供给其他项目，实现快速开发。如果后续需要做组件化一些共用东西可下沉到base中，再将app中的module目录下拆分为单独的module工程。

#app module结构介绍
base：Activity、Fragment 等页面的基类

db：数据库

image：图片封装

model：实体类

module:业务模块

network:网络封装

utils:工具类

widgets:控件


#base module结构介绍
目前改module内容较少，需要根据实际情况进行完善

network:网络

utils：工具类

widgets：控件
