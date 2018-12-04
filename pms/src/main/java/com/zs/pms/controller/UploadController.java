package com.zs.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//上传文件
@Controller //声明控制器
public class UploadController {
	/**
	 * 普通文件上传
	 * return 新文件名（目标文件）
	 * param 上传的文件 与input输入框的name相同
	 * */
	@RequestMapping("/upload/common.do")
	@ResponseBody
	public String uploadFile(MultipartFile file,HttpServletRequest req){
		//从请求中获取upload文件夹的物理路径，要传到哪里的位置
		String path=req.getRealPath("/upload");
		//创建新的文件名 目标文件
		
		/*
		 * uuid算法：根据网卡、时间、IP地址信息，自动生成绝不重复的32位码
		 * */
		//利用uuid算法，随机生成32位码，作为新的文件名（目标文件名）
		UUID uuid=UUID.randomUUID();
		//将随机生成的32位码与源文件名拼串，生成新的文件名，即目标文件名
		String destfilename=uuid.toString()+file.getOriginalFilename();
		//创建新文件的物理路径，新文件的物理路径\新文件名，separator是文件分隔符
		File destfile=new File(path+File.separator+destfilename);
		try {
			//SpringMVC将源文件拷贝到新文件中
			file.transferTo(destfile);
			//将新文件名返回到页面上
			return destfilename;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
		
	}
}
