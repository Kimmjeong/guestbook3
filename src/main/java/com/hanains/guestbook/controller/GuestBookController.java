package com.hanains.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.guestbook.dao.GuestBookDao;
import com.hanains.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {

	@Autowired
	private GuestBookDao guestBookDao; // DAO에 @Repository 어노테이션을 추가해야 한다.
	
	@RequestMapping("/")
	public String index(Model model){
		
		List<GuestBookVo> list=guestBookDao.getList();
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST) // post 방식일 때에만
	public String add(@ModelAttribute GuestBookVo vo){ // Vo를 가져올 때: ModelAttribute
		
		guestBookDao.insert(vo);
		return "redirect:/"; // insert 시에는 Dao를 통해 DB에 추가하고 경로 '/'으로 간다. 
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") Long no, Model model){ // path에서 받아 올때 : PathVariable, 어트리뷰트 추가할 때 model로 씀
		
		model.addAttribute("no",no); // no를 deleteform으로 보낸다.
		
		return "/WEB-INF/views/deleteform.jsp"; // delete폼을 보여주기 위해 deleteform.jsp 파일로 가도록 한다.
	}
	
	@RequestMapping("/delete")
	public String delete(
			@RequestParam(value="no",required=true, defaultValue="") Long no,
			@RequestParam(value="password", required=true, defaultValue="") String password
			){ // delete로 form 전송할 때 no, password를 보내면 RequestParam으로 받는다.
		
		
		guestBookDao.delete(no, password);
		return "redirect:/"; // delete시에는 Dao를 통해 DB에서 삭제하고 경로 '/'으로 간다. 
	}
	
	
	
	
}
