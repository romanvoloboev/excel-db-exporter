package com.exporter.repository;

import com.exporter.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Integer> {
    List<File> findAllByOrderByDateDesc();
}
