package com.codeclan.example.FilesAndFoldersHW.components;

import com.codeclan.example.FilesAndFoldersHW.models.File;
import com.codeclan.example.FilesAndFoldersHW.models.Folder;
import com.codeclan.example.FilesAndFoldersHW.repositories.FileRepository;
import com.codeclan.example.FilesAndFoldersHW.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        fileRepository.deleteAll();
        folderRepository.deleteAll();

        File pic = new File("pic", "jpg", 50 );
        fileRepository.save(pic);

        File text = new File("text", "txt", 10);
        fileRepository.save(text);

        Folder pics = new Folder("pictures");
        folderRepository.save(pics);

        Folder texts = new Folder("texts");
        folderRepository.save(texts);
    }
}
