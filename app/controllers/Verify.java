package controllers;

import model.Person;
import play.data.validation.Max;
import play.data.validation.MaxSize;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import service.LoginService;
import util.ErrorNo;

import com.google.gson.Gson;

public class Verify extends BaseController {
	/**
	 * 登录接口
	 * @param loginId 登录的id。最小长度6，最大长度64
	 * @param pwdMd5 登录密码md5值
	 * @param loginType 登录id类型。0=学号；1=
	 */
	public static void login(
			@Required @MinSize(6) @MaxSize(64) String loginId, 
			@Required @MinSize(6) @MaxSize(64) String pwdMd5, 
			@Required @Min(0) @Max(3) Integer loginType) {
		System.out.println("loginId = " + loginId);
		System.out.println("pwdMd5 = " + pwdMd5);
		System.out.println("loginType = " + String.valueOf(loginType));
		checkParams();
		Person p = LoginService.newInstance(loginId, pwdMd5, loginType).checkUserGet();
		if(p!= null){
			renderJSON(onSuccess(p.getObj()));
		}else{
			renderJSON(onError(ErrorNo.VERIFY_USER_LOGIN, "用户名或密码错误"));
		}
    }
}
