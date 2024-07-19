package com.ls.out.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendDTO {
    private String title;
    private String content;
    private String category;
    private Integer writerEmpId = 1;
}
