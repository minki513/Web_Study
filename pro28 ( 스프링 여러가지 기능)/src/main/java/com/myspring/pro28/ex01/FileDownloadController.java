/*package com.myspring.pro28.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH ="c:\\spring\\image_repo"; //���� ���� ��ġ ����
	
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName,HttpServletResponse response)throws Exception{
		OutputStream out = response.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" +imageFileName;
		File file = new File(downFile); //�ٿ�ε��� ���� ��ü�� ����
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Contend-disposition", "attachment; fileName="+imageFileName); //����� ���� �̸��� ����
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024*8];
		while (true) { //���۸� �̿��� �ѹ��� 8Kbyte�� �������� ����
			int count = in.read(buffer);
			if(count ==-1)break;
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}
}*/
