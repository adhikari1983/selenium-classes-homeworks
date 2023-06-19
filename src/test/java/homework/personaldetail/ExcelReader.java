package homework.personaldetail;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    public static List<Map<String, String>> reader(String path, String excelSheet) {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = xssfWorkbook.getSheet("Sheet1");
            Row headerRow = sheet.getRow(0);

            int rows = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rows; i++) {
                Map<String, String> map = new LinkedHashMap<>();
                Row row = sheet.getRow(i);

                int columns = row.getPhysicalNumberOfCells();
                for (int j = 0; j < columns; j++) {
                    String key = headerRow.getCell(j).toString();
                    String value = row.getCell(j).toString();
                    map.put(key, value);
                }
                mapList.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapList;
    }

}
