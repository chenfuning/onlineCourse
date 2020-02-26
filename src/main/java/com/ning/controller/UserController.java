package com.ning.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ning.pojo.User;
import com.ning.pojo.VO.UserVO;
import com.ning.pojo.BO.UserBO;
import com.ning.service.user.UserService;
import com.ning.utils.FastDFSClient;
import com.ning.utils.FileUtils;
import com.ning.utils.JSONResult;
import com.ning.utils.MD5Utils;

@RestController
@RequestMapping("u")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private FastDFSClient fastdfsClient;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello~~";
	}

	/**
	 * 手机客户端登录验证
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/kUserLogin")
	public JSONResult kUserLogin(@RequestBody User user) throws Exception{
		String username = user.getUsername();
		String password = user.getPassword();
		// 判断用户名和密码不为空
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return JSONResult.errorMsg("用户名或密码不能为空");
		}
		//判断用户名是否存在数据库，如果存在就登入，如果不存在就注册
		boolean usernameIsExist=userService.queryUsernameIsExist(username);
		User UserResult=null;
		if(usernameIsExist) {
			//登录
			UserResult=userService.queryUserForLogin(username,
					MD5Utils.getMD5Str(password));
			if(UserResult==null) {
				return JSONResult.errorMsg("用户名或密码不正确");
			}
			UserVO userVO=new UserVO();
			BeanUtils.copyProperties(UserResult, userVO);
			return JSONResult.ok(userVO);
		}else {
			//注册，返回表示跳转到注册页面
			return JSONResult.errorMsg("用户未注册");
		}
  }
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/kUserReg")
	public JSONResult kUserReg(@RequestBody User user)throws Exception {
		String username = user.getUsername();
		String password = user.getPassword();
		// 判断用户名和密码不为空
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return JSONResult.errorMsg("用户名或密码不能为空");
		}
		//判断用户名是否存在数据库，如果存在就登入，如果不存在就注册
		boolean usernameIsExist=userService.queryUsernameIsExist(username);
		User UserResult=null;
		if(usernameIsExist) {
			//跳转到登录
			return JSONResult.errorMsg("用户已存在");
		}else {
			// 注册
			user.setNickname(username);
			user.setPassword(MD5Utils.getMD5Str(password));
			UserResult=userService.saveUser(user);
			return JSONResult.ok("注册成功");
		}
	}
	/**
	 * 用户上传修改头像
	 * @return
	 */
	@PostMapping("/uploadFaceBase64")
	public JSONResult uploadFaceBase64(@RequestBody UserBO userBO)  throws Exception{
		//获取前端的base64 字符串，然后转化为文件对象在上传
				//userBO的FaceDate存图片字符串
				String base64Data =userBO.getFaceDate();
				//图片路径
				String userFacePath="E:\\z\\coursepic\\"+userBO.getUserId()+"userface64.png";
				//把字符串转成文件对象
				FileUtils.base64ToFile(userFacePath, base64Data);
				//把文件对象转成Multipart对象
				MultipartFile faceFileMultipartFile=FileUtils.fileToMultipart(userFacePath);
				//通过fastdfsClient上传，返回url(大图),记得关闭防火墙，如果不关闭就会把connect timer out的错误
				String url=fastdfsClient.uploadBase64(faceFileMultipartFile);
				System.out.println(url);
				//xxxxxxxxxxx.jpg
				//xxxxxxxxxxx_80x80.png
				//获取缩略图的url
				String thump="_80x80.";
				String arr[]=url.split("\\.");
				String thumpImgUrl= arr[0]+thump+arr[1];
				//更新数据库里的数据
				//更新用户头像
				User user=new User();
				user.setId(userBO.getUserId());
				user.setFaceImage(thumpImgUrl);
				user.setFaceImageBig(url);
				//返回一个完整的User，提供前端更新操作
				User UserResult=userService.updateUserInfo(user);
				//通过userVo给客户端
				UserVO userVO=new UserVO();
				BeanUtils.copyProperties(UserResult, userVO);
				return JSONResult.ok(userVO);
	}
	@PostMapping("/setNickname")
	public JSONResult setNickname(@RequestBody UserBO userBO) throws Exception{
		//更新用户
		User user=new User();
		user.setId(userBO.getUserId());
		user.setNickname(userBO.getNickname());
		//返回一个完整的User，提供前端更新操作
		User UserResult=userService.updateUserInfo(user);
		//通过userVo给客户端
		UserVO userVO=new UserVO();
		BeanUtils.copyProperties(UserResult, userVO);
		return JSONResult.ok(userVO);
	}
	
	
}
	

