package com.exporter.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file")
public class File {
    private Integer id;
    private String fileName;
    private Double fileSize;
    private Date date;
    private Integer addedRecordsCount;
    private Integer ignoredRecordsCount;
    private Customer customer;

    public File() {
    }

    public File(Integer id, String fileName, Double fileSize, Date date, Customer customer) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.date = date;
        this.customer = customer;
    }

    public File(String fileName, Double fileSize, Date date, Customer customer) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.date = date;
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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "added_records")
    public Integer getAddedRecordsCount() {
        return addedRecordsCount;
    }
    public void setAddedRecordsCount(Integer addedRecordsCount) {
        this.addedRecordsCount = addedRecordsCount;
    }

    @Column(name = "ignored_records")
    public Integer getIgnoredRecordsCount() {
        return ignoredRecordsCount;
    }
    public void setIgnoredRecordsCount(Integer ignoredRecordsCount) {
        this.ignoredRecordsCount = ignoredRecordsCount;
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
