<%@page import="java.io.Console"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      

 <%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	//위치, 경로, 사이즈 파일을 보낼때 알아두어야함 Context가 나오면 글로벌 모든 폴더와 파일에서 사용가능
	//서버 디폴트 경로
	String root = pageContext.getServletContext().getRealPath("/");
	System.out.println(root);	
	//저장되는 위치와 폴더
	String path = root + "pds" + File.separator + "saveData"; //파일의 위치를 정하고.
	//String path = "c:\\pds\\saveData"; 위 대신 이렇게 적어도 된다.
	//저장 공간이 될 폴더가 없으면 폴더 생성
	System.out.println(path);	
	
	File f = new File(path);
	
	if(!f.exists()){ //f 의 경로가 존재하지 않으면
		f.mkdirs(); //경로의 파일을 만들어라
	}
	//인코딩 타입
	String encType = "UTF-8";
	//최대 파일 크기 제한
	int maxFileSize = 10*1024*1024; //10메가바이트.
	try{
		//파일 업로드 - request파일을 path,maxFileSize,encType조건으로
		MultipartRequest mr =
			new MultipartRequest(request,path,maxFileSize,encType,
					new DefaultFileRenamePolicy()); //파일 업로드. 파일은 리퀘스트에 담겨서옴./경로/맥스사이즈
		String filename = mr.getOriginalFileName("upload");			
		/* out.print("제목: " + mr.getParameter("subject")+"<br/>"); //파일의 정보는 위의 mr에 들어가있다.
		out.print("서버에 저장된 파일 이름: " + 
			mr.getFilesystemName("upload") + "<br/>");
		out.print("업로드한 파일명: " +
			mr.getOriginalFileName("upload") + "<br/>");
		out.print("파일 타입: " + mr.getContentType("upload") + "<br/>"); 
		out.print("파일 크키: " + file.length() + "<br/>"); 
		*/
		//파일 객체 생성
		File file = mr.getFile("upload");
	}catch(Exception e){
		
	}
%>
<script>
	alert("첨부완료")
</script>

