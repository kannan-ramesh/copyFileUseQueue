package com.kannanrameshrk;

import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CopyFile {

	public static void main(String[] args) {
		File source = new File("E:/first/");
		File copySource = new File("E:/second/");
		
		copyFiles(source, copySource);
		
	}

	private static void copyFiles(File source, File copySource) {
		
		if(!source.exists() || !source.isDirectory()) {
			System.out.println("No folder or files this source");
		}
		
		if(!copySource.exists()) {
			boolean create = copySource.mkdirs();
			
			if(!create) {
				System.out.println("File failed to created");
				return;
			}
		}
		
		PriorityQueue<File> fileQ = new PriorityQueue<>((file1,file2)-> Long.compare(file1.length(), file2.length()));
		
		addFileQueue(source,fileQ);
		copyFileQ(fileQ, copySource);
	}

	private static void copyFileQ(PriorityQueue<File> fileQ, File copySource) {
		
	}

	private static void addFileQueue(File source, PriorityQueue<File> fileQ) {
		File[] files = source.listFiles();
		System.out.println(Arrays.toString(files));
		
		if(files != null) {
			for(File file:files) {
				if(file.isDirectory()) {
					addFileQueue(file, fileQ);
				}else {
					fileQ.add(file);
				}
			}
		}
		
	}

}
