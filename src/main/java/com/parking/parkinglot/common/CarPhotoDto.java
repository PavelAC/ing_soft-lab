package com.parking.parkinglot.common;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.parking.parkinglot.entities.Car}
 */
public class CarPhotoDto {
    private  Long id;
    private  String filename;
    private  String fileType;
    private  byte[] filecContent;


    public CarPhotoDto(Long id, String filename, String fileType, byte[] filecContent) {
        this.filename = filename;
        this.fileType = fileType;
        this.filecContent = filecContent;
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getFilecContent() {
        return filecContent;
    }

    public Long getId() {
        return id;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CarPhotoDto entity = (CarPhotoDto) o;
//        return Objects.equals(this.filename, entity.filename) &&
//                Objects.equals(this.fileType, entity.fileType) &&
//                Objects.equals(this.filecContent, entity.filecContent) &&
//                Objects.equals(this.id, entity.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(filename, fileType, filecContent, id);
//    }
//
//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + "(" +
//                "filename = " + filename + ", " +
//                "fileType = " + fileType + ", " +
//                "filecContent = " + filecContent + ", " +
//                "id = " + id + ")";
//    }
}