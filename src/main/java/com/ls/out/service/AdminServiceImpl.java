package com.ls.out.service;

import com.ls.out.domain.dao.AdminDAO;
import com.ls.out.domain.model.Admin;
import com.ls.out.dto.AdminDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private final AdminDAO adminDAO;

    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public boolean checkLogin(AdminDTO adminDTO) {
        Optional<Admin> admin = adminDAO.findById(adminDTO.getId());
        if(admin.isPresent()) {
            admin.get().getPw();
        }
        return admin.isPresent() && admin.get().getPw().equals(adminDTO.getPw());
    }
}
