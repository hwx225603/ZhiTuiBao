package com.xiaour.spring.boot.controller;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaour.spring.boot.config.BaseController;
import com.xiaour.spring.boot.config.ResultStatus;
import com.xiaour.spring.boot.entity.UserInfo;
import com.xiaour.spring.boot.model.ResultModel;
import com.xiaour.spring.boot.model.TokenModel;
import com.xiaour.spring.boot.service.TokenSerivce;
import com.xiaour.spring.boot.service.UserService;

/**
 * Created by huwei on 2017/4/19.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService UserService;
	@Autowired
	private TokenSerivce tokenSerice;
	
	/**
	    *     登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ResultModel login(@NotBlank(message="用户名不能为空") String username,@NotBlank(message="密码不能为空")String password) {

		UserInfo user = UserService.findByUsername(username);
		if (user == null || // 未注册
				!user.getPassWord().equals(password)) { // 密码错误
			// 提示用户名或密码错误
			return error(ResultStatus.USER_NOT_FOUND);
		}
		// 生成一个token，保存用户登录状态
		TokenModel model = tokenSerice.createToken(user.getId());
		return ok(model);
	}

	@RequestMapping(value="/reg",method = RequestMethod.POST)
	public ResultModel register(@NotBlank(message="手机号不能为空") String username,@NotBlank(message="验证码不能为空")String code) {
		
		return ok();
	}

}
