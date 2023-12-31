package com.nagesh.spring.mydiary.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagesh.spring.mydiary.UserBusiness.EntryBusinessInterFace;
import com.nagesh.spring.mydiary.UserBusiness.UserBusinessInterface;
import com.nagesh.spring.mydiary.entities.Entries;
import com.nagesh.spring.mydiary.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserBusinessInterface userBusinessInterface;
      @Autowired
      private EntryBusinessInterFace entryBusinessInterface;
	public UserBusinessInterface getUserBusinessInterface() {
		return userBusinessInterface;
	}
	public EntryBusinessInterFace getEntryBusinessInterface() {
		return entryBusinessInterface;
	}

	public void setEntryBusinessInterface(EntryBusinessInterFace entryBusinessInterface) {
		this.entryBusinessInterface = entryBusinessInterface;
	}
	@Autowired
   HttpSession session;
	public void setUserBusinessInterface(UserBusinessInterface userBusinessInterface) {
		this.userBusinessInterface = userBusinessInterface;
	}

	@RequestMapping("home")
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView("loginpage");
		return model;
	}

	@RequestMapping("register")
	public ModelAndView registerPage() {
		ModelAndView model = new ModelAndView("registrationpage");
		return model;
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView("registersuccess");
		userBusinessInterface.insertUsers(user);
		return model;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView("loginpage");
		User user1 = userBusinessInterface.findByUserName(user);
		if (user!=null && user1.getPaswwd().equals(user.getPaswwd())) {
			model.addObject("user", user1);
			model.setViewName("userhomepage");
			List<Entries>entries=null;
			session.setAttribute("user", user1);
			try {
				entries=entryBusinessInterface.findByUserId(user1.getUserId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addObject("entriesList",entries);
		}
		return model;
	}
	@RequestMapping("addentry")
	public ModelAndView addentry()
	{
		ModelAndView model=new ModelAndView("addentryform");
		
		return model;
	}
	@RequestMapping("saveentry")
	public ModelAndView saveentry(@ModelAttribute("entry") Entries entries)
	{
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.saveEntry(entries);
		List<Entries>entries1=null;
		User user =(User) session.getAttribute("user");
		try {
			entries1=entryBusinessInterface.findByUserId(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entriesList",entries1);
		return model;
	}
	@RequestMapping("viewentry1")
	public ModelAndView viewEntry(@RequestParam("id") int id) {
		ModelAndView model=new ModelAndView("viewentry");
		Entries entries=entryBusinessInterface.getViewdetails(id);
		model.addObject("entry",entries);
		return model;
	}
	@RequestMapping("updateentry")
	public ModelAndView updateEntryView(@RequestParam("id") int id) {
		ModelAndView model=new ModelAndView("updateEntry");
		Entries entries=entryBusinessInterface.getViewdetails(id);
		model.addObject("entry",entries);
		User user =(User) session.getAttribute("user");
		if(user==null) {
			model.setViewName("loginpage");
		}
		return model;
	}
	@RequestMapping("userhome")
	public ModelAndView backToHome() {
		ModelAndView model=new ModelAndView("userhomepage");
		List<Entries>entries1=null;
		User user =(User) session.getAttribute("user");
		try {
			entries1=entryBusinessInterface.findByUserId(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entriesList",entries1);
		return model;
	}
	@RequestMapping("processentryupdate")
	public ModelAndView updateEntryDet(@ModelAttribute("entry") Entries entries) {
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.entryDetUpdate(entries);
		List<Entries>entries1=null;
		User user =(User) session.getAttribute("user");
		try {
			entries1=entryBusinessInterface.findByUserId(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entriesList",entries1);
		return model;
	}
	@RequestMapping("deleteentry")
	public ModelAndView deleteEntry(@RequestParam("id") int id) {
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.deleteEntry(id);
		List<Entries>entries1=null;
		User user =(User) session.getAttribute("user");
		try {
			entries1=entryBusinessInterface.findByUserId(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entriesList",entries1);
		return model;
	}

	@RequestMapping("signout")
	public ModelAndView signOut() {
		ModelAndView model = new ModelAndView("loginpage");
		session.invalidate();
		return model;
	}
	

}
