package com.example.demo.services;

import com.example.demo.dto.PageDTO;
import com.example.demo.models.Page;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageService {

    private PageDTO pagesDTO (Page p) {
        return new PageDTO(
                        p.getId(), p.getTitulo(), p.getFrase(), p.getPersonagem(), p.getPoster());
    }

    @Autowired
    private Repository repository;

    public PageDTO randomData() {
        Page page = repository.searchRandom();

        return pagesDTO(page);
    }

}
