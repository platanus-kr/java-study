package org.platanus;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("자소분리 프로그램");
        TextArea textArea = new TextArea("여기에 .txt 파일을 드래그앤드랍하세요.", 10, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);

        textArea.setEditable(false);
        frame.add(textArea);

        // Drag and Drop 설정
        textArea.setDropTarget(new DropTarget(textArea, new java.awt.dnd.DropTargetAdapter() {
            @Override
            public void drop(java.awt.dnd.DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    // 드래그앤드랍한 파일 정보 얻기
                    java.util.List<File> droppedFiles = (java.util.List<File>) evt.getTransferable()
                            .getTransferData(DataFlavor.javaFileListFlavor);

                    for (File file : droppedFiles) {
                        if (file.getName().endsWith(".txt")) {
                            processNormalization(file);
                            textArea.setText(file.getName() + " 처리 완료!\n(원래파일명)_output.txt로 저장됨.");
                        } else {
                            textArea.setText("지원되지 않는 파일 형식입니다. .txt 파일만 지원됩니다.");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }));

        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                e.getWindow().dispose();
            }
        });
    }

    private static void processNormalization(File file) {
        String outputFilePath = file.getAbsolutePath().replace(".txt", "_output.txt");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(Normalizer.normalize(line, Normalizer.Form.NFC));
                writer.newLine();
            }

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}