package org.kosta.udonmarket.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;
import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;
import org.kosta.udonmarket.model.MemberVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WritePostController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MemberVO memberVO = (MemberVO)session.getAttribute("mvo");
		String id = memberVO.getId();
	
		if(session != null || memberVO != null) {
			MarketBoardDAO.getInstance().posting(title, content, id);
		}
		MarketVO marketVO = MarketDAO.getInstance().findMarketInfo(id);
		ArrayList<MarketBoardVO> boardList = MarketBoardDAO.getInstance().findBoardList(id);
		
		request.setCharacterEncoding("UTF-8");
		String cp = request.getContextPath();
		String root = request.getServletContext().getRealPath("/");
		System.out.println(root);	
		String path = root + "pds" + File.separator + "saveData";
		System.out.println(path);	
		
		File f = new File(path);
		
		if(!f.exists()){ 
			f.mkdirs(); 
		}
		String encType = "UTF-8";
		int maxFileSize = 10*1024*1024; 
		
		try{
			MultipartRequest mr = new MultipartRequest(request,path,maxFileSize,encType,
						new DefaultFileRenamePolicy()); 
				mr.getFilesystemName("upload"); 
				mr.getOriginalFileName("upload");
			File file = mr.getFile("upload");
		
		}catch(Exception e){
			
		}
		request.setAttribute("boardList", boardList);
		request.setAttribute("marketVO", marketVO);
		request.setAttribute("url", "board/list.jsp");	
		return "layout.jsp";
	}
}
