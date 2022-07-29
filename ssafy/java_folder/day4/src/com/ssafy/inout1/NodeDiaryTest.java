package com.ssafy.inout1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class NodeDiaryTest {
    public static void main(String[] args) throws IOException {
        NodeDiaryTest st = new NodeDiaryTest();
        st.writeDiary();
    }

    private void writeDiary() {
        File target = new File("C:" + File.separator + "Temp" + File.separator + "diary.txt");
        try (Scanner scanner = new Scanner(System.in);
                FileWriter writer = new FileWriter(target, true);
                FileReader reader = new FileReader(target);) {
        	
            System.out.println("일기를 작성합니다. 그만두려면 x를 입력하세요.");
            writer.write("\n오늘 날짜: - " + new Date() + "\n");
            String str = null;
            while (true) {
                str = scanner.nextLine();
                if (str.equals("x")) {
                    break;
                } else {
                    writer.write(str + "\n");
                }
            }
            writer.flush();// 버퍼의 내용을 출력하고 비움
            
            System.out.println("일기 저장 완료!!");
            
            char[] buffer = new char[10];
            int read = -1;
            while ((read = reader.read(buffer)) > 0) {
                System.out.print(String.valueOf(buffer, 0, read));
            }
            // END:
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
