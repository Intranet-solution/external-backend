package com.ls.out.dto;

import com.ls.out.domain.model.Inquiry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDTO {
    private Integer id;
    private String companyName;
    private String name;
    private String tel;
    private String email;
    private String message;
    private String manager;
    private boolean inquiryState;

    public static InquiryDTO toDTO(Inquiry inquiry) {
        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setId(inquiry.getId());
        inquiryDTO.setCompanyName(inquiry.getCompanyName());
        inquiryDTO.setName(inquiry.getName());
        inquiryDTO.setTel(inquiry.getTel());
        inquiryDTO.setEmail(inquiry.getEmail());
        inquiryDTO.setMessage(inquiry.getMessage());
        inquiryDTO.setManager(inquiry.getManager());
        inquiryDTO.setInquiryState(inquiry.isInquiryState());
        return inquiryDTO;
    }
}
