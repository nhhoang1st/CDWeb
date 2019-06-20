package com.leansecurity.main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloadFile {
	    
	    List<String> filesListInDir = new ArrayList<String>();

//	    public static void main(String[] args) {
//	        
////	        String zipDirName = "D:\\tum lum\\TestZip.zip";
//	    	String folder = "D:\\Workspace\\CDweb\\WebMonHoc\\src\\main\\webapp\\folderBaiTap\\BaiTapTuan1";
//	        String zipDirName = "D:\\Workspace\\CDweb\\WebMonHoc\\src\\main\\webapp\\folderBaiTap\\BaiTapTuan1.zip";
//	        
//	        
//	        DownloadFile zipFiles = new DownloadFile();
//	        zipFiles.zipDirectory(folder, zipDirName);
//	    }

	    public void zipDirectory(String folderPath, String zipDirName) {
	    	File dir = new File(folderPath);
	        try {
	            populateFilesList(dir);
	            
	            FileOutputStream fos = new FileOutputStream(zipDirName);
	            ZipOutputStream zos = new ZipOutputStream(fos);
	            for(String filePath : filesListInDir){
	                System.out.println("Zipping "+filePath);
	                //for ZipEntry we need to keep only relative file path, so we used substring on absolute path
	                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
	                zos.putNextEntry(ze);
	                //read the file and write to ZipOutputStream
	                FileInputStream fis = new FileInputStream(filePath);
	                byte[] buffer = new byte[1024];
	                int len;
	                while ((len = fis.read(buffer)) > 0) {
	                    zos.write(buffer, 0, len);
	                }
	                zos.closeEntry();
	                fis.close();
	            }
	            zos.close();
	            fos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void populateFilesList(File dir) throws IOException {
	        File[] files = dir.listFiles();
	        for(File file : files){
	            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
	            else populateFilesList(file);
	        }
	    }


	}

