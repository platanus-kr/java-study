package org.platanus.webappboard.common;


import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.platanus.webappboard.app.dto.BoardFileDto;
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

    public List<BoardFileDto> parseFileInfomation() throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
            return null;

        }

        List<BoardFileDto> dtoFileList = new ArrayList<>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime currentTime = ZonedDateTime.now();
        String path = "images/" + currentTime.format(dateFormat);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        Iterator<String> filenameIterator = multipartHttpServletRequest.getFileNames();
        String replaceFileName, originalFileExtension, contentType;

        while (filenameIterator.hasNext()) {
            List<MultipartFile> fileList = multipartHttpServletRequest
                .getFiles(filenameIterator.next());
            for (MultipartFile multipartFile : fileList) {
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
                    BoardFileDto boardFile = new BoardFileDto();
                    boardFile.setBoardIdx(boardIdx);
                    boardFile.setFileSize(multipartFile.getSize());
                    boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
                    boardFile.setStoredFilePath(path + "/" + replaceFileName);
                    dtoFileList.add(boardFile);

                    file = new File(path + "/" + replaceFileName);
                    multipartFile.transferTo(file);
                }
            }
        }
        return dtoFileList;
    }

}