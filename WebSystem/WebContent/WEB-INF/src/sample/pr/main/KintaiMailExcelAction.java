package sample.pr.main;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class KintaiMailExcelAction {
    private static final String URL = "Configuration.properties";
    private static final String USER = "PRC006";
    private static final String PASSWORD = "PRC006";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        String sql = "SELECT * FROM kintaimail where ;";

        try {
            //データ取得用
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            //取得結果をリストへ
            List<String> records = new ArrayList<String>();
            List<Object> columns = new ArrayList<Object>();
            for (int i = 1; i <= 5; i++) {
                columns.add(rsmd.getColumnName(i));
            }
            records.add(columns);
            while (rs.next()) {
                List<Object> values = new ArrayList<Object>();
                values.add(rs.getInt("id"));
                values.add(rs.getString("name"));
                values.add(rs.getString("category"));
                values.add(rs.getDate("insert_date"));
                values.add(rs.getDate("update_date"));
                records.add(values);
            }

            //エクセルに出力するデータをセット
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            int rowNum = 0;
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadSheet = workbook.createSheet("test1");
            XSSFRow row = spreadSheet.createRow(rowNum++);
            for (Object record : records) {
                int cellNum = 0;
                XSSFCell cell = row.createCell(cellNum++);
                for (int i = 0; i < ((List)record).size(); i++) {
                    if (!((List)record).get(0).equals("id")) {
                        if (i == 4 || i == 5) {
                            if (((List)record).get(i) != null) {
                                ((List<String>)record).set(i, sdf.format(((List)record).get(i)));
                            } else {
                                ((List<String>)record).set(i, "NULL");
                            }
                        }
                    }
                    cell.setCellValue(((List)record).get(i).toString());
                    if (i != ((List)record).size() -1) cell = row.createCell(cellNum++);
                }
                row = spreadSheet.createRow(rowNum++);
            }

            //出力
            FileOutputStream output = null;
            try {
                output = new FileOutputStream(new File("C:/Users/kosuke_eizumi/Desktop/研修/勤怠連絡管理.xlsx"));
                workbook.write(output);
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (output != null) output.close();
                    if (workbook != null) workbook.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
        }
    }
}
