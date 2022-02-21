package com.myspring.pro28.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	private static final String CURR_IMAGE_REPO_PATH="c:\\spring\\image_repo";
	
	@RequestMapping(value="/form")
	public String form() {  //���ε�â�� uploadForm.jsp�� ��ȯ
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map map=new HashMap();  //�Ű����� ������ ���� ������ ������ map�� ������
		Enumeration enu=multipartRequest.getParameterNames();
		
		while(enu.hasMoreElements()) { //�ϳ� �̻��� element�� �������� ���� true ��ȯ / ���۵� �Ű����� ���� key/value�� map�� ����
			String name=(String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			map.put(name, value);
		}
		
		List fileList =fileProcess(multipartRequest); 
		map.put("fileList",fileList); //������ ���ε��� �� ��ȯ�� ���� �̸��� ����� fileList�� �ٽ� map�� ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",map);
		mav.setViewName("result"); //map�� ���â���� ������
		return mav;		
}
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();  //÷�ε� ���� �̸��� ������
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName=mFile.getOriginalFilename(); //���� ���� �̸��� ������
			fileList.add(originalFileName); //���� �̸��� �ϳ��� fileList�� ����
			File file = new File(CURR_IMAGE_REPO_PATH +"\\" + fileName);
			if(mFile.getSize()!=0) { //÷�ε� ������ �ִ��� üũ
				if(!file.exists()) { //��ο� ������ ������
					if(file.getParentFile().mkdirs()) { //�� ��ο� �ش��ϴ� ���͸��� ���� �� ������ ����
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH +"\\"+originalFileName)); //�ӽ÷� ����� MultipartFile�� ���� ���Ϸ� ����
			}
		}
		return fileList; //÷�ε� ���� �̸��� ����� fileList�� ��ȯ
}
}
