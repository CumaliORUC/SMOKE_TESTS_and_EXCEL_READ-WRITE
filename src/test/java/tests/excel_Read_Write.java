package tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.WorkbookDocumentImpl;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class excel_Read_Write {
    @Test
        public void excelRead() throws IOException {

            String excelPath="src/test/java/resources/ulkeler.xlsx";

                FileInputStream fileinput=new FileInputStream(excelPath);

                Workbook workBook = WorkbookFactory.create(fileinput);

                String bilgi=workBook.getSheet("Sayfa1").getRow(2).getCell(3).toString();

                System.out.println("row 3, cell 4 info==" +bilgi);

                //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

                String expexted_cell_info="Kabil";
                String actual_cell_info=cellinfos().toString();

                    Assert.assertEquals(actual_cell_info,expexted_cell_info);

                System.out.println(ConfigReader.getProperty("rowNumber")+".satır  "+ConfigReader.getProperty("cellNumber")+".sutun bilgisi===="+cellinfos());
                // Satir sayisini bulalim
                int rowNumber=workBook.getSheet("Sayfa1").getLastRowNum(); // it brings raw last index number
                    System.out.println("Sayfa 1 satır sayısı==  "+rowNumber);

                int rowLastNumber=workBook.getSheet("Sayfa1").getPhysicalNumberOfRows();
                    System.out.println("Sayfa1 last row number=="+rowLastNumber);

                //Put the datas into MAP; First column will be our keys and rest of the others will be our keys;
                String key="";
                String value="";

                HashMap<String,String> excelMAP=new HashMap<>();

                    for (int i=0; i<=workBook.getSheet("Sayfa1").getLastRowNum(); i++) {
                        key=workBook.getSheetAt(0).getRow(i).getCell(0).toString();
                        value=workBook.getSheetAt(0).getRow(i).getCell(1).toString()+","
                            +workBook.getSheetAt(0).getRow(i).getCell(2).toString()+","
                            +workBook.getSheetAt(0).getRow(i).getCell(3).toString();
                    excelMAP.put(key,value);
                    }

                    System.out.println("=============================HASMAP DATA===========================");
                    System.out.println(excelMAP);

                    //get Turkish capitals
                     System.out.println("=================TURKISH CAPİTALS=========================================");

                     for(int index=1; index<=workBook.getSheet("Sayfa1").getLastRowNum(); index++) {

                         System.out.println((index+1)+" th capital of Turkish is=="+workBook.getSheetAt(0).getRow(index).getCell(3).toString());
                                }

            fileinput.close();
        }

        public String  cellinfos () throws IOException {

            String pathExcelDocument="src/test/java/resources/ulkeler.xlsx";
            FileInputStream fileinput=new FileInputStream(pathExcelDocument);
            Workbook workbook=WorkbookFactory.create(fileinput);

                Cell cell=workbook.getSheet("Sayfa1")
                          .getRow(Integer.parseInt(ConfigReader.getProperty("rowNumber"))-1)
                          .getCell(Integer.parseInt(ConfigReader.getProperty("cellNumber"))-1);

                return cell.toString();
        }
    @Test
        public void writeExcel() throws IOException {
            String excelPath="src/test/java/resources/ulkeler.xlsx";
            FileInputStream fileInput=new FileInputStream(excelPath);
            Workbook workbook=WorkbookFactory.create(fileInput);

                workbook.getSheet("Sayfa1").getRow(1).createCell(7).setCellValue("Hello");
                workbook.getSheet("Sayfa1").getRow(2).createCell(7).setCellValue("These words");
                workbook.getSheet("Sayfa1").getRow(3).createCell(7).setCellValue("sent from");
                workbook.getSheet("Sayfa1").getRow(4).createCell(7).setCellValue("Selenium");

            FileOutputStream fileoutput=new FileOutputStream(excelPath);
                workbook.write(fileoutput);
            fileoutput.close();
            fileInput.close();

    }

}
