package org.example.dataProviders;

import com.opencsv.exceptions.CsvValidationException;
import org.example.utils.CSVUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// class này chịu trách nhiệm chuyển đổi thành Object[]
public class DataProviders {
    @DataProvider(name = "csvLoginData")
    //Mỗi phần tử của iterator là 1 mảng Object[] chứa 3 giá trị (ví dụ: username, password, error message).
    public static Iterator<Object[]> loginData() {
//        //Hàm trả về List<String[]>: mỗi phần tử là 1 dòng dữ liệu,
//        // chia thành mảng String[] (3 cột tương ứng: username, password, message).
//        List<String[]> data = CSVUtils.readCSV("datatest/logindata.csv");
//        //Tạo 1 List mới để lưu dữ liệu dưới dạng Object[],
//        // vì TestNG yêu cầu Object[] cho mỗi test case.
//        List<Object[]> datatest = new ArrayList<>();
//        for (String[] row : data) {
//            datatest.add(new Object[]{row[0], row[1], row[2]});
//        }
//        return datatest.iterator();// trả về list data lưu dưới dạng iterator để TestNG sử dụng
        Iterator<Object[]> data = CSVUtils.readCSV("datatest/logindata.csv");
        return data;
    }

    @DataProvider(name = "csvInformation")
    public static Iterator<Object[]> informationData() {
        return CSVUtils.readCSV("datatest/information.csv");
    }

    @DataProvider(name = "csvInformation1")
    public static Iterator<Object[]> info() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"", "cdd", "12", "Error: First Name is required"});
        data.add(new Object[]{"nguyen", "ha", "123", ""});
//        data.add(new Object[]{"sdsd", "", "12", "Error: Last Name is required"});
//        data.add(new Object[]{"", "", "1w2", "Error: First Name is required"});
//        data.add(new Object[]{"ddw", "wdd", "", "Error: Postal Code is required"});
        return data.iterator();
    }

    @DataProvider(name = "csvInformation2")
    public static Iterator<Object[]> infodata() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"nguyen", "ha", "123", ""});
        return data.iterator();
    }
}
