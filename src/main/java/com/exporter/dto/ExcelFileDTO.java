package com.exporter.dto;

/**
 * @author Roman Voloboev
 */

public class ExcelFileDTO {
    private Integer id;
    private String fileName;
    private Double fileSize;
    private String uploadDate;
    private String customer;

    public ExcelFileDTO() {
    }

    public ExcelFileDTO(Integer id, String fileName, Double fileSize, String uploadDate, String customer) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ExcelFileDTO{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", uploadDate='" + uploadDate + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
