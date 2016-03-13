package com.exporter.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file")
public class File {
    private Integer id;
    private String fileName;
    private Double fileSize;
    private Date uploadDate;
    private Integer totalRecords;
    private Integer modifiedRecords;
    private Customer customer;

    public File() {
    }

    public File(Integer id, String fileName, Double fileSize, Date uploadDate, Customer customer) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.customer = customer;
    }

    public File(String fileName, Double fileSize, Date uploadDate, Customer customer) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.customer = customer;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "file_seq")
    @GeneratedValue(generator = "sequence", strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "size", nullable = false)
    public Double getFileSize() {
        return fileSize;
    }
    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    @Column(name = "date", nullable = false)
    public Date getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Column(name = "total_records")
    public Integer getTotalRecords() {
        return totalRecords;
    }
    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Column(name = "modified_records")
    public Integer getModifiedRecords() {
        return modifiedRecords;
    }
    public void setModifiedRecords(Integer modifiedRecords) {
        this.modifiedRecords = modifiedRecords;
    }

    @ManyToOne
    @JoinColumn(name = "customer")
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
