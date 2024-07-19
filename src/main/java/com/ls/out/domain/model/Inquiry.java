package com.ls.out.domain.model;

import com.ls.out.dto.InquiryDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "inquiry")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generator")
    @SequenceGenerator(name = "my_sequence_generator", sequenceName = "my_sequence", allocationSize = 1)
    private Integer id;

    private String companyName;

    private String name;

    private String tel;

    private String email;

    private String message;

    private String manager;

    private boolean inquiryState;

    public static Inquiry toEntity(InquiryDTO inquiryDTO) {
        return Inquiry.builder()
                .id(inquiryDTO.getId())
                .name(inquiryDTO.getName())
                .tel(inquiryDTO.getTel())
                .companyName(inquiryDTO.getCompanyName())
                .message(inquiryDTO.getMessage())
                .manager(inquiryDTO.getManager())
                .email(inquiryDTO.getEmail())
                .inquiryState(inquiryDTO.isInquiryState())
                .build();
    }
}
