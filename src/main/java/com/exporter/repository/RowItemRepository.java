package com.exporter.repository;

import com.exporter.model.RowItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowItemRepository extends JpaRepository<RowItem, Integer> {
}
