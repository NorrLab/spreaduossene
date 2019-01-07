package com.uossene.service.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uossene.dao.entity.UosUser;
import com.uossene.dao.exceptions.UosUserLoginException;
import com.uossene.service.interfaces.CommentService;
import com.uossene.service.interfaces.GenericService;
import com.uossene.service.interfaces.UosUserService;
import com.uossene.service.utils.LoginUtils;

@RestController
@RequestMapping(value="/user")
public class UosUserRestController extends GenericRestController<UosUser>{
	
	@Autowired
	private UosUserService uosUserService;
	
	@Autowired
	private CommentService commentService;
	@Override
	public GenericService<UosUser> getService() {
		return this.uosUserService;
	}

	public UosUserRestController() {
		super();
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public UosUser userLogin(@RequestBody LoginUtils payLoad) throws UosUserLoginException
	{	
		UosUser user=null;
		String exceptionMessage = uosUserService.checkEmailPassword(payLoad.getUserEmail(),payLoad.getUserPassword());
		if(!StringUtils.isEmpty(exceptionMessage))
			throw new UosUserLoginException(exceptionMessage);
		try {
			user= uosUserService.userLogin(payLoad.getUserEmail(),payLoad.getUserPassword());
		} catch (UosUserLoginException e) {
			e.printStackTrace();
		}
		
		if(user == null) 
			throw new UosUserLoginException("aucun utilisateur trouvé!!!"+payLoad);
		return user;
	}
	
	@RequestMapping(value="/register/",method = RequestMethod.POST)
	public UosUser register(@RequestBody UosUser user, @RequestBody String repeatedPassword) 
	{
		UosUser userInside = null;
		
		try {
			userInside= uosUserService.register(user, repeatedPassword);
		} catch (UosUserLoginException e) {
			e.printStackTrace();
		}
		return userInside;
	}

	@RequestMapping(value="/users/comments/", method = RequestMethod.GET)
	public List<UosUser> getAllUsersWithComment() throws UosUserLoginException {
		return uosUserService.getAllUsersWithComment();
	}
	

	@Transactional(propagation=Propagation.REQUIRED)
	@RequestMapping(value="/comment/{userId}", method = RequestMethod.POST)
	public List<UosUser> validateComment(@PathVariable Integer userId, @RequestBody String comment) {
		
		try {
			uosUserService.validateComment(userId, comment);
		} catch (UosUserLoginException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
