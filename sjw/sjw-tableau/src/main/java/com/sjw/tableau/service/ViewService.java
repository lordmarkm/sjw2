package com.sjw.tableau.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sjw.tableau.model.View;

@Transactional(readOnly = true)
public interface ViewService extends JpaRepository<View, Long> {

}