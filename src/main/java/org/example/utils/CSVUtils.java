package org.example.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

//class này chịu trách nhiệm đọc file CSV
public class CSVUtils {
    // Object[] : mỗi dòng là 1 mảng
    public static Iterator<Object[]> readCSV(String pathInResources) {
        List<Object[]> testData = new ArrayList<>(); //tạo danh sách chứa các dòng dữ liệu
        //mở file CSV
        try (
                InputStream inputStream  = CSVUtils.class.getClassLoader().getResourceAsStream(pathInResources);// mở file csv
                InputStreamReader isr = new InputStreamReader(inputStream);//chuyển đổi byte sang dạng text
                CSVReader reader = new CSVReader(isr);// cho phép sử dụng reader.readNext để đọc từng dòng
                ) {
            String[] line; // khai báo mảng string của mỗi dòng
            boolean skipHeader = true; // bỏ qua dòng đầu tiên
            while ((line = reader.readNext()) != null) {// đọc dòng tiếp theo của csv và gán vào line
                if (skipHeader) { // đk continue
                    skipHeader = false;
                    continue; // bỏ qua điều kiện trong if
                }
               // testData.add(line);// add từng dòng vào list testData
                // ép kiểu String[] sang Object[]
                testData.add(Arrays.copyOf(line, line.length,Object[].class ));
                System.out.println(">>> CSV line: " + Arrays.toString(line));


            }
//
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        //csvReader.close();// đóng file
        //return testData;//trả về list<String>
        return testData.iterator();//trả về iterator để dùng cho TestNG
    }
}
