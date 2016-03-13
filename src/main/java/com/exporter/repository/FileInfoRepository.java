package com.exporter.repository;

import com.exporter.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<File, Integer> {
}
