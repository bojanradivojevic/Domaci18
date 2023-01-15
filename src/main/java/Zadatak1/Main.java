package Zadatak1;

import com.github.javafaker.Faker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("ImenaIPrezimena.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            for (int i = 0; i < 5; i++){
                XSSFRow row = sheet.getRow(i);
                XSSFCell cellIme = row.getCell(0);
                XSSFCell cellPrezime = row.getCell(1);
                String ime = cellIme.getStringCellValue();
                String prezime = cellPrezime.getStringCellValue();
                System.out.println(ime + " " + prezime);
            }
            for (int i = 5; i < 10; i++){
                Faker faker = new Faker();
                String ime = faker.name().firstName();
                String prezime = faker.name().lastName();
                XSSFRow row = sheet.createRow(i);
                XSSFCell cellIme = row.createCell(0);
                XSSFCell cellPrezime = row.createCell(1);
                cellIme.setCellValue(ime);
                cellPrezime.setCellValue(prezime);
                System.out.println(ime + " " + prezime);
            }

            FileOutputStream fileOutputStream = new FileOutputStream("ImenaIPrezimena.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
