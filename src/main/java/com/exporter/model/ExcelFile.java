package com.exporter.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Roman Voloboev
 */

@Entity
@Table(name = "file")
public class ExcelFile {
    private Integer id;
    private String fileName;
    private Double fileSize;
    private Date uploadDate;
    private Customer customer;
    private byte[] content;

    public ExcelFile() {
    }

    public ExcelFile(Integer id, String fileName, Double fileSize, Date uploadDate, Customer customer, byte[] content) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.customer = customer;
        this.content = content;
    }

    public ExcelFile(String fileName, Double fileSize, Date uploadDate, Customer customer, byte[] content) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.customer = customer;
        this.content = content;
    }

    public ExcelFile(String fileName, Double fileSize, Date uploadDate, Customer customer) {
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

    @ManyToOne
    @JoinColumn(name = "customer")
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "content", nullable = false)
    public byte[] getContent() {
        return content;
    }
    public void setContent(byte[] content) {
        this.content = content;
    }
}
