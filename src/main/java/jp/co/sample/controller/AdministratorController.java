package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private AdministratorService administratorService;
	
	@ModelAttribute
	public InsertAdministratorForm setUplnsertAdministratorForm() {
		InsertAdministratorForm insertAdministratorForm= new InsertAdministratorForm();
		return insertAdministratorForm;
	}
	
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator =new Administrator();
		BeanUtils.copyProperties(form, administrator);
		administratorService.insert(administrator);
		return "redirect:/";
		//コントローラークラスまで返す。
	}
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		LoginForm loginForm=new LoginForm();
		return loginForm;
		//ログインする際のLoginFormがリクエストスコープに自動格納
	}
	
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
		//ログイン画面へ
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator administrator=administratorService.login(form.getMailAddress(), form.getPassword());
		
		if(administrator==null) {
			model.addAttribute("errormessage", "メールアドレスまたはパスワードが不正です。");
			return "administrator/login";
		}else {
			model.addAttribute("administratorName", administrator);
		}
		return "forward:/employee/showList";
	}

}
