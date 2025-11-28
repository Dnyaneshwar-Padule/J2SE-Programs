package com.tca;

import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

	public static void main(String[] args) {
		
		// root
		Path path = Paths.get("/");
		
		try {
			
			FileStore fileStore = Files.getFileStore(path);
			
			System.out.println("Block Size  : " + fileStore.getBlockSize());
			System.out.println("Total Space : " + fileStore.getTotalSpace());
			System.out.println("Allocated   : " + (fileStore.getTotalSpace() - fileStore.getUnallocatedSpace() ));
			System.out.println("Unallocated : " + fileStore.getUnallocatedSpace() );
			System.out.println("Usable space: " + fileStore.getUsableSpace());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
