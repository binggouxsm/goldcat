package com.eden.finance.goldcat.system.service;

import com.eden.finance.goldcat.system.entity.FileInfo;
import com.eden.finance.goldcat.system.mapper.FileInfoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 文件信息 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-04-14
 */
@Service
public class FileInfoService {

	@Autowired
	private FileInfoMapper fileInfoMapper;

	@Value("${system.file-path}")
	private String basePath;

	public FileInfo insertFileInfo(MultipartFile file) throws IOException {
		FileInfo fileInfo = new FileInfo();
		String fileId = UUID.randomUUID().toString().replaceAll("-","");
		fileInfo.setFileId(fileId);
		String filename = file.getOriginalFilename();
		String filetype= filename.substring(filename.lastIndexOf("."));
		String localpath =  File.separator+fileId+filetype;
		fileInfo.setName(filename);
		fileInfo.setAddress(localpath);

		file.transferTo(new File(basePath+localpath));
		fileInfoMapper.insert(fileInfo);
		return fileInfo;
	}

	public File getFile(String fileId){
		FileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);
		File file = new File(basePath+fileInfo.getAddress());
		if (file.exists())
			return file;
		return null;
	}
}


