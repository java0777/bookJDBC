package com.demo.book.jdbc.model.entity;

/**
 * 书籍目录
 */
public class BookCatalog {
    private Integer id; //目录主键
    private Integer bookId;//关联书籍编号
    private String catalogName;//章节名
    private String fileDir;//相关内容文件文件夹地址
    private String fileName;//相关内容文件名
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
