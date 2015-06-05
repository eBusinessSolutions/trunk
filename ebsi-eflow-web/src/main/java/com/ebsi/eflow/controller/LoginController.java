/**
 * 
 */
package com.ebsi.eflow.controller;

import java.net.InetAddress;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebsi.common.dtos.UserVO;
import com.ebsi.messaging.sendreceive.MessageSender;

/**
 * @author
 *
 */
@Controller
@RequestMapping(value="/login")
public class LoginController{
	
	@Autowired
	MessageSender messageSender;
	
	@RequestMapping(value = "/getLoginDetails")
	public String getLoginDetails() throws Exception{		
		messageSender.send("Logged in to the application!!!");
		UserVO userVO = new UserVO();
		userVO.setFirstName("senthil");
		userVO.setLastName("kumar");
		messageSender.send(userVO);
		return "login/loginPage";
	}
	
	
	@RequestMapping(value = "/getLoginUserRoleDetails", method = RequestMethod.GET)
	public ModelAndView applicationLoginUserDetails(
			Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView =  null;
		
		/* Client request details */
		
		System.out.println(request.getHeader("User-Agent"));					
		InetAddress ip;
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		
		 Locale locale = LocaleContextHolder.getLocale();
		 String  country = locale.getDisplayCountry();		           
         System.out.println(country);
		
		/* Client request details */

		/*	RestTemplate restTemplate = new RestTemplate();
			List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
			acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccept(acceptableMediaTypes);
			MenuDetailsVO menus = new MenuDetailsVO();
			menus.setEmployeeId(userVO.getEID());
			httpHeaders.set(ApplicationConstants.USER_ID, userVO.getEID());
			HttpEntity<MenuDetailsVO> httpEntity = new HttpEntity(menus,
					httpHeaders);
			System.out.println(ApplicationConstants.URL_SRV);
			session.setAttribute("userVo", userVO);
			ResponseEntity<MenuDetailsVO> result = restTemplate.exchange(
					ApplicationConstants.URL_SRV
							+ ApplicationConstants.GETLOGIN_USERDTL_SRV,
					HttpMethod.POST, httpEntity, MenuDetailsVO.class);
			MenuDetailsVO menuDetails = result.getBody();*/

		return modelAndView;
	}
}
