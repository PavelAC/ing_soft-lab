package com.parking.parkinglot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class CarPhoto {
    private Long id;
    String filename;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFilecContent() {
        return filecContent;
    }

    public void setFilecContent(byte[] filecContent) {
        this.filecContent = filecContent;
    }
    @OneToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    String fileType;
    byte[] filecContent;
    Car car;

    public void setFileContent(byte[] fileContent) {
        this.filecContent = fileContent;
    }
}
