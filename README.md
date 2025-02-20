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
- 배포: Cloudflare, Vpn
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
        </div>
</div>
</div>

![jsp](https://github.com/user-attachments/assets/7a11dc15-87b6-42ba-8bb7-f8389102adce)

    
<br/>

## 3. 역할 분담

### 박우혁
- **기능**
    -게시판 CRUD, 파일 업로드,WEBSOCKET을 사용한 실시간 양방향 채팅기능

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

- Main 페이지 화면입니다 

### ⓶ 상세 설명

👉 검색기능

-  제목,작성자를 입력시, `<form>` 형식을 통해 api 로 전송후, 이에 알맞은 데이터를 다시 받아 옵니다.

![Main_search](https://github.com/user-attachments/assets/d7eac07c-83bc-4cb0-a726-eeb0404bf1d2)

- 이러한 검색을 통해 해당 리스트를 받아 옵니다.

![Main_list](https://github.com/user-attachments/assets/03effd88-716b-4dba-af9a-eb5630ac3012)

<br>

👉 페이징 처리 기능

- 한번에, 여러 데이터를 보여주기 어렵기 때문에, 보여줄 데이터의 갯수 를 설정하고, <br>페이징 처리를 통해 데이터를 여러번 나뉘어 보여 줍니다.

![Main_paging](https://github.com/user-attachments/assets/604e2ce2-4fcd-4555-8a8a-0e947b54d922)

<br>

### 5-2 게시글 등록(A01_BoardInsert.jsp)

#### ⓵ 상세화면

![Insert_main](https://github.com/user-attachments/assets/63a7736b-cc8a-407d-a312-9b350dab9734)

- 게시글 등록 화면 입니다.

### ⓶ 상세 설명

👉 게시글 등록 기능

#### A01_BoardList.jsp 페이지 에서 "등록" 버튼 클릭시, 해당 페이지로 이동합니다. 

- `<form>` 태그로 api 에 데이터를 전송하였습니다.

- 다중 업로드 기능을 구현하기 위해  `<form>` 태그에 enctype=multipart/form-data 를 <br> `<input>` 태그에 multiple="multiple" 라는 속성을 적용하였습니다. 

![BoardList_Main](https://github.com/user-attachments/assets/2a922328-eba7-4612-909e-2c37f753d0be)


- 저장할 정보를 작성 한뒤, "등록" 버튼을 누르면 서버로 전송이 되고, 리스트 돌아가기를 하면 A01_boardList.jsp 파일로 돌아갑니다.

![submit](https://github.com/user-attachments/assets/f4d7be19-25b1-4b24-82dc-92c96d6f213f)

### 5-3 게시글 상세(A01_BoardDetail.jsp)

#### ⓵ 상세화면

![DetailBoard](https://github.com/user-attachments/assets/45d086aa-94fe-41c2-984f-67f0896585f5)

### ⓶ 상세 설명

👉 게시글 수정/삭제 기능 

- 등록 후 A01_BoardList.jsp 파일로 돌아가서 다시 더블클릭을 하게 되면 "상세페이지" 로 들어가지게 됩니다.
  
![click_deatil](https://github.com/user-attachments/assets/6c7f531b-c094-442a-8415-197a1a35cf59)

-해당 페이지 에서 각 창을 "클릭" 시 해당 정보를 수정할 수 있으며 작성이 끝나면 "수정"버튼을 통해 서버로 전달되어집니다.

![update_detail](https://github.com/user-attachments/assets/0792a984-099b-4c0b-82ad-bb157e91ac7d)

- 삭제 기능 또한 마찬가지로, "삭제" 버튼 클릭시 해당되는 게시글의 번호를 찾아 해당 내용을 삭제 합니다.

![Delete_detail](https://github.com/user-attachments/assets/066b44a8-9053-4c9d-bfe5-0f57b89dbbbc)

<br>

👉 답글 기능

- 답글 기능은 해당 게시글에 상세 내용에 접속 후, 답글 버튼을 클릭 할 시 본 게시물의 내용과 함께 작성이 가능해집니다.

  ![go_reply](https://github.com/user-attachments/assets/522123a7-7c30-4ecb-90b8-647bd3633b16)

- 이후 다시한번 게시글에 대한 내용에 추가 내용을 덧붙인 뒤 "등록" 버튼을 클릭해 서버에 등록 해 줍니다.

  ![reply_main](https://github.com/user-attachments/assets/23f0cce5-c30b-4c0e-bdb2-8bd330fbae8e)

- 등록이 완료 되면 다시 A01_boardList 에서 확인이 가능 합니다. 다시한번 클릭 하여 해당 내용을 확인 합니다.
  
 ![relply_success_list](https://github.com/user-attachments/assets/e376b945-a376-4458-b7e1-4b6b0df293b0)

- 정상적으로 답글이 등록 된 것을 확인 할  수 있습니다.

![reply_main](https://github.com/user-attachments/assets/7c652529-bc9a-458a-a4e0-87aa6690fe2f)


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
