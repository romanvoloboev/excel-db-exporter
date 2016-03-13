package com.exporter.dto;

public class ExcelFileDTO {
    private Integer id;
    private String fileName;
    private Double fileSize;
    private String uploadDate;
    private Integer addedRecordsCount;
    private Integer ignoredRecordsCount;
    private String customer;

    public ExcelFileDTO() {
    }

    public ExcelFileDTO(Integer id, String fileName, Double fileSize, String uploadDate, Integer addedRecordsCount,
                        Integer ignoredRecordsCount, String customer) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.addedRecordsCount = addedRecordsCount;
        this.ignoredRecordsCount = ignoredRecordsCount;
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

    public Integer getAddedRecordsCount() {
        return addedRecordsCount;
    }

    public void setAddedRecordsCount(Integer addedRecordsCount) {
        this.addedRecordsCount = addedRecordsCount;
    }

    public Integer getIgnoredRecordsCount() {
        return ignoredRecordsCount;
    }

    public void setIgnoredRecordsCount(Integer ignoredRecordsCount) {
        this.ignoredRecordsCount = ignoredRecordsCount;
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
