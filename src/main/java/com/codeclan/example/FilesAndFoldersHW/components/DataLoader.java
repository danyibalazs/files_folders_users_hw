package com.codeclan.example.FilesAndFoldersHW.components;

import com.codeclan.example.FilesAndFoldersHW.models.File;
import com.codeclan.example.FilesAndFoldersHW.models.Folder;
import com.codeclan.example.FilesAndFoldersHW.models.User;
import com.codeclan.example.FilesAndFoldersHW.repositories.FileRepository;
import com.codeclan.example.FilesAndFoldersHW.repositories.FolderRepository;
import com.codeclan.example.FilesAndFoldersHW.repositories.UserRepository;
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

    @Autowired
    UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        fileRepository.deleteAll();
        userRepository.deleteAll();
        folderRepository.deleteAll();

        User user1 = new User("Balazs");
        userRepository.save(user1);

        Folder pics = new Folder("pictures", user1);
        folderRepository.save(pics);

        Folder texts = new Folder("texts", user1);
        folderRepository.save(texts);

        File pic = new File("pic", "jpg", 50, pics );
        fileRepository.save(pic);

        File text = new File("text", "txt", 10, texts);
        fileRepository.save(text);

        pics.addFile(pic);
        folderRepository.save(pics);
        texts.addFile(text);
        folderRepository.save(texts);






    }
}
