
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

class FindMatches {
  private String inputFile;
  private String matchingType;
  private int rowNum;
  private String[] header;
  private Integer emailCol2;
  private Integer emailCol;
  private Integer phoneCol2;
  private Integer phoneCol;
  private HashMap<String, Integer> ids;
  private Integer id;

  public FindMatches(String inputFile, String matchingType) {
    this.inputFile = inputFile;
    this.matchingType = matchingType.toLowerCase();
    this.rowNum = 0;
    this.header = null;
    this.emailCol2 = null;
    this.emailCol = null;
    this.phoneCol2 = null;
    this.phoneCol = null;
    this.ids = new HashMap<String, Integer>();
    this.id = 1;

    try {
      Scanner csvFileIn = new Scanner(new File(this.inputFile));
      while (csvFileIn.hasNextLine()) {
        String line = csvFileIn.nextLine();
        if (this.rowNum == 0) {
          this.header = line.split(",");
          this.rowNum++;
          continue;
        }
      }
      csvFileIn.close();
    } catch (FileNotFoundException e) {
      System.out.println("Input file not found.");
      e.printStackTrace();
    }

    for (int col = 0; col < this.header.length; col++) {
      if (this.header[col].toLowerCase().contains("email2")) {
        this.emailCol2 = col;
      }
      if (this.header[col].toLowerCase().contains("email1") || this.header[col].toLowerCase().contains("email")) {
        this.emailCol = col;
      }
      if (this.header[col].toLowerCase().contains("phone2")) {
        this.phoneCol2 = col;
      }
      if (this.header[col].toLowerCase().contains("phone1") || this.header[col].toLowerCase().contains("phone")) {
        this.phoneCol = col;
      }
    }
    this.writeCsv();
  }

  private void emailMatch(String[] row, Integer minId) {
    Integer rowId = null;
    if (minId!= null) {
      rowId = minId;
    } else {
      rowId = this.id;
    }
    if (this.emailCol2!= null) {
      if (row[this.emailCol2]!= null) {
        String email2 = row[this.emailCol2];
        this.addKeyToDict(email2, rowId);
        if (this.ids.get(email2)!= null) {
          rowId = this.ids.get(email2);
        }
      }
    }
    if (row[this.emailCol]!= null) {
      String email1 = row[this.emailCol];
      this.addKeyToDict(email1, rowId);
      rowId = this.ids.get(email1, this.id);
    }
    if (rowId == null) {
      rowId = this.id;
    }
  }

  private String formatPhone(String[] row, Integer column) {
    Pattern pattern = Pattern.compile("\\D+");
    Matcher matcher = pattern.matcher(row[column]);
    String formatPhoneCol = matcher.replaceAll("");
    if (formatPhoneCol.length() > 10) {
      formatPhoneCol = formatPhoneCol.substring(1);
    }
    return formatPhoneCol;
  }

  private void phoneMatch(String[] row, Integer minId) {
    Integer rowId = null;
    if (minId!= null) {
      rowId = minId;
    } else {
      rowId = this.id;
    }
    if (this.phoneCol2!= null) {
      if (row[this.phoneCol2]!= null) {
        String phone2 = this.formatPhone(row, this.phoneCol2);
        this.addKeyToDict(phone2, rowId);
        if (this.ids.get(phone2)!= null) {
          rowId = this.ids.get(phone2);
        }
      }
    }
    if (row[this.phoneCol]!= null) {
      String phone1 = this.formatPhone(row, this.phoneCol);