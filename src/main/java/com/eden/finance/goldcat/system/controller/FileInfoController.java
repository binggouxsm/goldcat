package com.eden.finance.goldcat.system.controller;


import com.eden.finance.goldcat.system.entity.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.system.service.FileInfoService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

/**
 * <p>
 * 文件信息 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/fileInfo")
public class FileInfoController {

	@Autowired
	private FileInfoService fileInfoService;



	@PostMapping("")
	public FileInfo uploadFile(MultipartFile file) throws IOException {
		return fileInfoService.insertFileInfo(file);
	}
}

