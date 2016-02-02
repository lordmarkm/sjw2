package com.sjw.tableau.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sjw.tableau.model.Workbook;

@Transactional(readOnly = true)
public interface WorkbookService extends JpaRepository<Workbook, Long> {

}
