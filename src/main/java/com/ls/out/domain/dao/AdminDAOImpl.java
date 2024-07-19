package com.ls.out.domain.dao;

import com.ls.out.domain.model.Admin;
import com.ls.out.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

    private AdminRepository adminRepository;

    public AdminDAOImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Optional<Admin> findById(String id) {
        return adminRepository.findById(id);
    }
}
