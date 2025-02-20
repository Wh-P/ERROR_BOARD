## 설비 고장신고 게시판
![main](https://github.com/user-attachments/assets/04f9c152-c9a3-446e-bcf8-196be0ca3cfa)

- ### 배포 URL : http://equipreport.work:8080/ 

## 시연 영상
[![시연 영상](https://img.youtube.com/vi/TksVHQmNdAo/maxresdefault.jpg)](https://www.youtube.com/watch?v=TksVHQmNdAo)

(이미지 클릭 시 시청 가능합니다)


<br>

## 프로젝트 소개

- ### MES 시스템의 설비 공정에서 공정 기계가 고장이 났을 경우, 신고할 수 있는 게시판과 실시간 채팅 기능을 통해 고장을 빠르게 해결할 수 있는 게시판 입니다.

<br>


## 팀원 구성

<div align="center">

<table  align="center">
  <tr>
    <th><img src="https://avatars.githubusercontent.com/u/162407926?v=4" width="150" height="150" "/></th>
  </tr>
  <tr>
    <td align="center"> 박우혁</td>
  </tr>
  <tr>
    <td align="center"> 게시글등록/수정/삭제/검색 , 이미지업로드 , 실시간 양방향 채팅(WEBSOCKET) </td>
  </tr>
</table>
</div>

<br>

## 1. 개발 환경
- Tool :Spring Tool Suite 4 
- 버전 및 이슈관리 : Github, SVN
- 배포: cloudflare, vpn
<br>

## 2. 채택한 개발 기술

<div align= "left">
    <div style="text-align: left;">
    <h2 style="border-bottom: 1px solid #21262d; color: #c9d1d9;"> 🛠️ Tech Stacks </h2> <br> 
    <div style="margin: ; text-align: left;" "text-align: left;"> <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white">
          <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white">
          <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white">
          <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white">
          <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">
          <br/><img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
          <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
         <h5>+JSP</h5>
    </div>
</div>
</div>

<br/>

## 3. 역할 분담

### 박우혁
- **기능**
    -게시판 CRUD, 파일 업로드,WEb Socket을 사용한 채팅기능

<br>

## 4. 개발 기간 및 작업 관리

### 개발 기간

- 전체 개발 기간 : 2025-02-01~2025-02-17
- 기획 : 2025-01-30 ~ 2025-01-31
- UI 구현 : 2025-02-03 ~ 2025-02-07
- 기능 구현 : 2025-02-08~ 2025-02-17

<br>

### 작업 관리

- GitHub 사용하여 파일 상태관리를 진행하였습니다.

<br>

## 5.구현화면/상세코드

### 5-1 메인화면(A01_BoardList.jsp)

#### ⓵ 상세화면

![Main](https://github.com/user-attachments/assets/9b055c07-9f94-41af-b151-d82645f5f40c)

Main 페이지 화면입니다 

### ⓶ 상세 설명

👉 검색기능

-제목,작성자를 입력시, `<form>` 형식을 통해 api 로 전송후, 이에 알맞은 데이터를 다시 받아 옵니다.

![Main_search](https://github.com/user-attachments/assets/d7eac07c-83bc-4cb0-a726-eeb0404bf1d2)

-이러한 검색을 통해 해당 리스트를 받아 옵니다.

![Main_list](https://github.com/user-attachments/assets/03effd88-716b-4dba-af9a-eb5630ac3012)

👉 페이징 처리 기능

##### 한번에, 여러 데이터를 보여주기 어렵기 때문에, 보여줄 데이터의 갯수 를 설정하고, 페이징 처리를 통해 데이터를 여러번 나뉘어 보여 줍니다.


![Main_paging](https://github.com/user-attachments/assets/15a9e0b7-09a7-4054-90b1-5d8c640948b3)


<br>

## 6.데이터설계


<br>

## 7. 프로젝트 폴더 구조

```
 📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┣ 📂com.web.mes021
 ┃ ┃ ┃ ┣ 📂a01_config
 ┃ ┃ ┃ ┃ ┣ 📜MessageConfig.java
 ┃ ┃ ┃ ┃ ┣ 📜MvcConfiguration.java
 ┃ ┃ ┃ ┃ ┣ 📜WebSocketConfig.java
 ┃ ┃ ┃ ┣ 📂a02_Board
 ┃ ┃ ┃ ┃ ┣ 📜A01_BoardController.java
 ┃ ┃ ┃ ┃ ┣ 📜A02_BoardService.java
 ┃ ┃ ┃ ┃ ┣ 📜A03_BoardDao.java
 ┃ ┃ ┃ ┣ 📂a03_ChatHandler
 ┃ ┃ ┃ ┃ ┣ 📜A09_ChattingController.java
 ┃ ┃ ┃ ┃ ┣ 📜A10_ChattingHandler.java
 ┃ ┣ 📂resources
 ┃ ┃ ┣ 📂 Static
 ┃ ┃ ┃ ┣ 📂Z01_Load
 ┃ ┃ ┣ 📂 templates
 ┃ ┃ ┃ ┣ 📂A00_Com
 ┃ ┃ ┣ 📜appilcation.properties
  ````````````(bootsrap Template 구성js,css 파일들.. )
 ┃ ┣ 📂webapp
 ┃ ┃ ┣ 📂 WEB-INF
 ┃ ┃ ┃ ┣ 📂a01_Board
 ┃ ┃ ┃ ┃ ┣ 📜A01_BoardList.jsp
 ┃ ┃ ┃ ┃ ┣ 📜A01_BoardInsert.jsp
 ┃ ┃ ┃ ┃ ┣ 📜A01_BoardDetail.jsp
 ┃ ┃ ┃ ┣ 📂a02_Mvc
 ┃ ┃ ┃ ┃ ┣ 📜a03_chatting.jsp
```

<br/>
