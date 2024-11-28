* 유저 생성 API

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유저 추가|POST|/users|content-type : application/json|200 정상등록, 400 잘못된 요청|name : O, email : O

* 유저 추가 Request
```
{
    "name" : "junhyuk",
    "email" : "abc@Email.com"
}
```

* 유저 추가 성공 Response
```
"가입 완료하였습니다"
```

* 유저 추가 실패 Response
```
"입력을 완료하여주세요"
```

* 유저 전체 조회 API

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유저 전체 조회|GET|/users||200 정상등록, 400 잘못된 요청||

* 유저 전체 조회 Request
```

```

* 유저 전체 조회 Response
```
[
{
    "userId" " "1",
    "name" : "junhyuk",
    "email" : "abc@gmail.com"
},
{
    "userId" : "2",
    "name" : "test2",
    "email" : "def@gmail.com"
}
]
```

* 유저 전체 조회 실패 Response
```
"잘못된 요청입니다"
```
* 유저 단건 조회

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유저 단건 조회|GET|/users/{userId}||200 정상등록, 400 잘못된 요청, 404 찾을 수 없음||

* 유저 단건 조회 Request
```

```

* 유저 단건 조회 성공Respose
```
{
    "userId" : "1",
    "name" : "junhyuk",
    "email" : "abc@gmail.com"
}
```

* 유저 단건 조회 실패(400) Response
```
"잘못된 요청입니다"
```
* 유저 단건 조회 실패(404) Response
```
"요청하신 유저를 찾을 수 없습니다"
```

* 유저 삭제 API

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유저 삭제|DELETE|/users/{userId}||200 정상등록, 400 잘못된 요청, 404 찾을 수 없음||

*유저 삭제 Request
```

```

*유저 삭제 성공 Response

```
"삭제되었습니다"
```

*유저 삭제 실패(400) Response
```
"잘못된 요청입니다"
```

* 유저 삭제 실패(404) Reponse
```
"요청하신 유저를 찾을 수 없습니다"
```

-------



* 유통화폐 생성 API

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유통화폐 생성|POST|/currencies||200 정상등록, 400 잘못된 요청, 404 찾을 수 없음||

* 유통화폐 생성 Request
```
{
    "currencyName" : "dollar",
    "exchangeRate" : "1390",
    "symbol" : "$"
}
```

* 유통화폐 생성 Response
```
{
    "currencyId" : "1",
    "currencyName" : "dollar",
    "exchangeRate" : "1390",
    "symbol" : "$"
}
```

* 유통화폐 생성 실패(400) Request
```
유효하지 않은 요청입니다
```

* 유통화폐 생성 실패(404) Request
```
찾을 수 없는 currencyId입니다
```

* 유통화폐 전체 조회 API

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유통화폐 전체 조회|GET|/users||200 정상등록, 400 잘못된 요청||

* 유통화폐 전체 조회 Request
```

```

* 유통화폐 전체 조회 Response
```
[
{
    "currencyId" : "1",
    "currencyName" : "dollar",
    "exchangeRate" : "1390",
    "symbol" : "$"
},
{
    "currencyId" : "2",
    "currencyName" : "jpy",
    "exchangeRate" : "920",
    "symbol" : "円"
}
]
```

* 유통화폐 전체 조회 실패 Response
```
"잘못된 요청입니다"
```

* 유통화폐 단건 조회

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유저 단건 조회|GET|/users/{userId}||200 정상등록, 400 잘못된 요청, 404 찾을 수 없음||

* 유통화폐 단건 조회 Request
```

```

* 유통화폐 단건 조회 성공Respose
```
{
    "currencyId" : "1",
    "currencyName" : "dollar",
    "exchangeRate" : "1390",
    "symbol" : "$"

```

* 유통화폐 단건 조회 실패(400) Response
```
"잘못된 요청입니다"
```
* 유통화폐 단건 조회 실패(404) Response
```
"요청하신 유저를 찾을 수 없습니다"
```


--------
* erd

![image](https://github.com/user-attachments/assets/92f22f9c-3876-45f1-9aba-66b7f8739a33)

-------

SQL
```
create database Schedule_management;

create table users (
	user_id bigint not NULL auto_increment,
    user_name varchar(12) not null,
    email varchar(100) not null,
    created_date datetime DEFAULT CURRENT_TIMESTAMP,
    modified_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key(user_id)
	);


create table currency(
	currencyId bigint(30) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id bigint,
    currencyName varchar(100) not null,
    exchangeRate bigint not null,
    created_date datetime DEFAULT CURRENT_TIMESTAMP,
    modified_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key(calendar_id),
    foreign key (user_id) references users (user_id)
    );
    
    
   -- 데이터 추가(user)--
    INSERT INTO
		users (user_id, user_name, email, created_date, modified_date)
    VALUES
		(1, 'junhyuk', 'abc@gmail.com', now(), now());

   -- 데이터 추가(currency) --
     INSERT INTO
		currency (currencyId, currencyName, exchangeRate, created_date, modified_date)
    VALUES
		(1, 'dollar', '1390', now(), now());
        
	-- 데이터 조회(단건)--
    select user_id
    from users
    where user_id = 1;
    
    -- 데이터 조회(다건) --
    select *
    from users;
    
    -- 데이터 수정 --
    update users
    set user_name = 'kangjun';
    
    -- 데이터 삭제 --
    delete from user
    where user_name = 'kangjun';
```

