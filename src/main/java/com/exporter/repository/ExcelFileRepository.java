package com.exporter.repository;

import com.exporter.model.ExcelFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Roman Voloboev
 */
public interface ExcelFileRepository extends JpaRepository<ExcelFile, Integer> {
}
