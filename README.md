## 설비 고장신고 게시판
![main](https://github.com/user-attachments/assets/04f9c152-c9a3-446e-bcf8-196be0ca3cfa)

- 배포 URL : http://equipreport.work:8080/ 

## 시연 영상
[![시연 영상][(https://img.youtube.com/vi/TksVHQmNdAo/maxresdefault.jpg)](https://www.youtube.com/watch?v=TksVHQmNdAo)](https://www.youtube.com/watch?v=x70LQrh7-l0)


<br>

## 프로젝트 소개

- mes 시스템의 설비 공정에서 고장이 났을시 신고할 수 있는 게시판과, 실시간으로 채팅 할 수 있는 기능을 추가해 긴급한 경우에 채팅을 할 수 있게 하였습니다.

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
</table>
</div>

<br>

## 1. 개발 환경
- Tool :Spring Tool Suite 4 
- 버전 및 이슈관리 : Github, SVN
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

### 5. 프로젝트 폴더 구조

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
