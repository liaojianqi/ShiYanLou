# fiora Web聊天室

##一、概述
---
Fiora是一款web聊天应用. 使用node.js, koa和react编写.
##二、功能
---
演示地址：[fiora](http://fiora.suisuijiang.com/)

1. 创建用户, *~~创建群组, 加入群组, 私聊,~~* 群聊

2. 文本, 图片, 代码, url等多种类型消息

3. 桌面通知, 声音提醒, 通知开关

4. 头像修改, 表情收藏*~~, 群组公告修改~~*

5. 消息长度限制, 消息发送频率限制

6. 简易的插件系统


##三、数据库设计：
---
- user
> `username` `password` `regTime` `head_url` 
**primary:** `username`

- image
> `id` `username` `url` 
**primary:** `id`  *increase*

- message
> `id` `send_user` `time` `content`
**primary:** `id` *increase*

###四、数据库操作：
- 用户登录
```
var res = "select password 
          from user 
          where username=input_username"
if(res == null) 用户名不存在
else if(res != _password) 密码错误
else 成功登录
```
- 用户注册
```
var res = "select password 
          from user 
          where username=input_username"
if(res == null) 用户名已存在
else{
    //head_url是头像的url
    "insert into user 
    (username,password,regTime,head_url) 
    values (_username,_password,new Date(),_head_url)"
```    
}


- 用户发送消息
```
//图片消息是不保存到数据库的，暂存在内存中
if(不是图片){
   "insert into message
    (send_user,time,content)
    values (_send_user,new Date(),_content)" 
}
```
- 用户换终端登录获取消息记录
```
//获取三小时的记录
var now = new Date();
"select *
 from message
 where send_user = _username and (now - time < 3*60*60)"
//如果要继续获取，每次上拉:
"now -= 3;"
```
- 用户点击收藏图片
```
"insert into image
(username,url)
values (_username,_url)"
```




