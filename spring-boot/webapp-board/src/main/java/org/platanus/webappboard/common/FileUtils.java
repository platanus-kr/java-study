package org.platanus.webappboard.common;


import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.platanus.webappboard.app.entity.BoardFileEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public class FileUtils {

    int boardIdx;
    MultipartHttpServletRequest multipartHttpServletRequest;

    public FileUtils(int boardIdx, MultipartHttpServletRequest multipartHttpServletRequest) {
        this.boardIdx = boardIdx;
        this.multipartHttpServletRequest = multipartHttpServletRequest;
    }

    public List<BoardFileEntity> parseFileInformation(
        MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
            return null;

        }

        List<BoardFileEntity> fileList = new ArrayList<>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime currentTime = ZonedDateTime.now();
        String path = "images/" + currentTime.format(dateFormat);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        Iterator<String> filenameIterator = multipartHttpServletRequest.getFileNames();
        String newFileName, replaceFileName, originalFileExtension, contentType;

        while (filenameIterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest
                .getFiles(filenameIterator.next());
            for (MultipartFile multipartFile : list) {
                if (!multipartFile.isEmpty()) {
                    contentType = multipartFile.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) {
                        break;
                    } else {
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";
                        } else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";
                        } else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";
                        } else {
                            break;
                        }
                    }
                    replaceFileName = System.nanoTime() + originalFileExtension;
                    newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                    BoardFileEntity boardFile = new BoardFileEntity();
                    boardFile.setFileSize(multipartFile.getSize());
                    boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
                    boardFile.setStoredFilePath(path + "/" + newFileName);
                    boardFile.setCreatorId("admin");
                    fileList.add(boardFile);

                    file = new File(path + "/" + newFileName);
                    multipartFile.transferTo(file);
                }
            }
        }
        return fileList;
    }

}