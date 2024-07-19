package com.ls.out.service;

import com.ls.out.domain.dao.InquiryDAO;
import com.ls.out.domain.model.Inquiry;
import com.ls.out.dto.AdminDTO;
import com.ls.out.dto.InquiryDTO;
import com.ls.out.dto.SendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("inquiryService")
public class InquiryServiceImpl implements InquiryService{

    private final InquiryDAO inquiryDAO;

    @Autowired
    public InquiryServiceImpl(InquiryDAO inquiryDAO) {
        this.inquiryDAO = inquiryDAO;
    }

    @Override
    public List<InquiryDTO> getAll() {
        List<Inquiry> inquiryList = inquiryDAO.getAll();
        return inquiryList.stream()
                .map(InquiryDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public InquiryDTO getDetail(Integer id) {
        Inquiry inquiry = inquiryDAO.findById(id);
        return InquiryDTO.toDTO(inquiry);
    }

    @Override
    public boolean updateInquiry(InquiryDTO inquiryDTO) {
        Inquiry inquiry = Inquiry.toEntity(inquiryDTO);
        return inquiryDAO.save(inquiry);
    }

    @Override
    public boolean sendInquiry(SendDTO sendDTO) {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9000")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        URI uri = UriComponentsBuilder.fromUriString("/document/api/creation")
                .queryParam("title", sendDTO.getTitle())
                .queryParam("content", sendDTO.getContent())
                .queryParam("category", sendDTO.getCategory())
                .queryParam("writerEmpId", sendDTO.getWriterEmpId())
                .build()
                .toUri();

        String result = webClient.post()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return Objects.equals(result, "Document created successfully");
    }

    @Override
    public boolean createInquiry(InquiryDTO inquiryDTO) {
        Inquiry inquiry = Inquiry.toEntity(inquiryDTO);
        return inquiryDAO.save(inquiry);
    }
}
