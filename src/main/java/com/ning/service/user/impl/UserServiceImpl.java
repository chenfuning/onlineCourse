package com.ning.service.user.impl;

import java.io.IOException;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ning.mapper.UserMapper;
import com.ning.pojo.User;
import com.ning.service.user.UserService;
import com.ning.utils.FileUtils;
import com.ning.utils.QRCodeUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private Sid sid;
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean queryUsernameIsExist(String username) {
		User user =new User();
		user.setUsername(username);
		User result=userMapper.selectOne(user);
		return result!=null?true:false;
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public User queryUserForLogin(String username, String password) {
		Example userExample=new Example(User.class);
		Criteria criteria=userExample.createCriteria();
		criteria.andEqualTo("username", username);
		criteria.andEqualTo("password", password);
		User result=userMapper.selectOneByExample(userExample);
		return result;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public User saveUser(User user) {
		String userId=sid.nextShort();
		user.setId(userId);
		user.setNickname(user.getUsername());
		user.setFaceImage("weishezhi");
		user.setFaceImageBig("weishezhi");
//		//为用户生成唯一的二维码
//	
//		String qrcodePath="E:\\z\\wxpic\\erweima\\"+userId+"qrcode.png";;
//		//ning_qecode:[username]
//		String content="ning_qecode"+user.getUsername();
//		QRCodeUtils.createQRCode(qrcodePath, content);
//		//把文件对象转成Multipart对象
//		MultipartFile qrcodeFileMultipartFile=FileUtils.fileToMultipart(qrcodePath);
//		//qrcodeurl在文件服务器上的地址
//		String qrcodeUrl="";
//		try {
//			qrcodeUrl=fastdfsClient.uploadQRCode(qrcodeFileMultipartFile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		user.setQrcode(qrcodeUrl);
		user.setQrcode("weishezhi");
		
		userMapper.insert(user);
		return user;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public User updateUserInfo(User user) {
		//不覆盖原有的方法
		userMapper.updateByPrimaryKeySelective(user);
		return queryUserById(user.getId());
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	private User queryUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

}
