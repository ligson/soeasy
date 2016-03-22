账户中心Http接口V1.1.3
============================================

[目录]

[1.注册接口](#t1)

[2.登录接口](#t2)

[3.通过token修改密码接口](#t3)

[4.通过手机验证码修改密码接口](#t4)

[5.通过token查询用户信息接口](#t5)

[6.通过token认证用户](#t6)

[7.通过token注销用户接口](#t7)

[8.通过修改用户信息接口](#t8)

[9.发送短信接口](#t9)

[10.验证码验证接口](#t10)

[附录]

[I.251测试环境地址](#f1)

[II.线上环境地址](#f2)

##<a name="t1">1.注册接口</a>

###1.1.请求地址
    
    /user/register

###1.2.请求参数

`password` : 密码

`email` : 邮箱

`mobile`: 手机号

`name`: 昵称

`registerIp`:  注册时ip

`portrait`: 用户头像

`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK

### 1.3. 返回参数

```json
{
    "success" : true,//是否登录成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "userId" : 11 //用户id(仅当success==true时有)
        
    }
}
 ```

    
##<a name="t2">2.登录接口</a>

###2.1.请求地址

    /user/login

###2.2.请求参数

`loginName`: 手机号或者邮箱

`loginNameTypeEnum`: MOBILE/EMAIL

`password`: 密码

`jpushid`: jpushid

`serviceId`: 服务id

`loginIp`: 登录时的ip

`userAgent`: 浏览器的agent

`referer`: http referer

`screenSize`: 屏幕尺寸WxH

`osType`: 操作系统类型(101:"WIN_98",102:"WIN_2000, ,103: "WIN_2003" ,104: "WIN_XP" ,105:"WIN_VISTA" ,106:"WIN_7" ,107:"WIN_8" ,108:"WIN_10" ,201:"MAC" ,301:"LINUX" ,401:"Android" ,501:"IOS")

`deviceId`: 设备id

`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK

###2.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        `token` : "XXXXXX",//加密过的token(仅当success==true时有)
           
        `accountId` : 11 //用户id(仅当success==true时有)
        
    }
}
 ```

##<a name="t3">3.通过token修改密码接口</a>

###3.1.请求地址

    /user/modify_password
    
###3.2.请求参数

`tokenId`: 解密后的tokenid

`oldPwd`: 旧密码md5

`newPwd`: 新密码md5

`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK

###3.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "success" : true,//是否成功(true/false)
        
    }
}
 ```
 
##<a name="t4">4.通过手机验证码修改密码接口</a>

###4.1.请求地址

    modify_password_by_valid_code
    
###4.2.请求参数

`accountId`:账户id

`mobile`:手机号

`newPwd`:新密码

`validCode`:验证码

`smsTypeEnum`:短信类型

`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK

###4.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "success" : true,//是否成功(true/false)
        
    }
}
 ```
 
##<a name="t5">5.通过token查询用户信息接口</a>

###5.1.请求地址

    /user/query_user_info

###5.2.请求参数

`tokenId`: 解密后的token

`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK

###5.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "accountId" : 111111,//账户 主键
    
        "name" : "ligson",//账户昵称
    
        "mobile" : "183832232833",//手机号
    
        "email" : "admin@admin.com",//邮箱
    
        "ctime" : "Thu Mar 17 2016 20:21:15 GMT+0800",//创建时间
    
        "source" : "IOS",//来源
    
        "status" : 1,//状态
    
        "sex" : 1,//性别
    
        "portrait" : "http:///xxxx.jpg",//头像
    
        "registerIp" : "193.32.3.4",//注册时ip
    
        "lastLoginIp" : "193.32.3.4",//最后登录ip
    
        "lastLoginDate" : "Thu Mar 17 2016 20:21:15 GMT+0800",//最后登录时间
    
        "mobileBindStatus" : 1,//手机绑定状
    
        "emailBindStatus" : 1,//邮箱绑定装填
    
        "lastLoginSource" : "IOS",//最后登录源
        
    }
}
 ```
    
##<a name="t6">6.通过token认证用户</a>
###6.1.请求地址

    auth_by_token
    
###6.2.请求参数

`tokenId`: 解密后的token

`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK

###6.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "isLogin" : true,//是否成功(true/false)
        
    }
}
 ```
 
##<a name="t7">7.通过token注销用户接口</a>
###7.1.请求地址

    /user/logout_token
    
###7.2.请求参数
    
`tokenId`: 解密后的token

`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK

###7.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "success" : true,//是否成功(true/false)
        
    }
}
 ```
 

##<a name="t8">8.通过修改用户信息接口</a>

###8.1.请求地址

    /user/modify_account_info

###8.2.请求参数

`accountId` :  账号ID

`status` : 状态

`email` : 邮箱

`mobile` : 手机号

`name` : 名称

`pwd` : 密码

`source` : 来源（PC/IOS/Android）

`sex` : 性别

`portrait` : 头像

`mobileBindStatus` : 手机绑定状态

`emailBindStatus` : 邮箱绑定状态

`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK


###8.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "success" : true,//是否成功(true/false)
        
    }
}
 ```
 
##<a name="t9">9.发送短信接口</a>

###9.1.请求地址

    /sms/send
    
###9.2.请求参数

`mobile`:手机号

`params`:排除验证码后的参数列表,以逗号分隔

`smsTypeEnum`: 短信类型
    
`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK


###9.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "success" : true,//是否成功(true/false)
        
    }
}
 ```
 
##<a name="t10">10.验证码验证接口</a>

###10.1.请求地址

    /sms/checkValidCode

###10.2.请求参数

`mobile`:手机号

`validCode`:验证码

`smsTypeEnum`: 短信类型
    
`version`: 接口版本

`appCode`: 请求应用名称,KLH\CARNATION\CLOUD

`sourceCode`: 请求平台代码,IOS\ANDROID\PC

`charset`: 接口编码,UTF-8/GBK

###10.3.返回参数

```json
{
    "success" : true,//是否成功(true/false)
    
    "errorCode" : "BIZ_023",//错误代码(仅当success==true时有)
    
    "errorMsg" : "手机号已存在",//错误信息(仅当success==true时有)
    
    "data" : {
    
        "success" : true,//是否成功(true/false)
        
    }
}
 ```

####<a name="f1">I.251测试环境地址</a>

    http://10.0.0.251:8180/user_web/