package com.discover.harmony.elastic.resource;

import com.discover.harmony.elastic.model.BusinessMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

//    @Autowired
//    BusinessMetadataRepository businessMetadataRepository;

//    @GetMapping(value = "/name/{text}")
//    public List<BusinessMetadata> searchName(@PathVariable final String text) {
//        return businessMetadataRepository.findByName(text);
//    }

//    @GetMapping(value = "/all")
//    public List<BusinessMetadata> searchAll() {
//        List<BusinessMetadata> businessMetadataList = new ArrayList<>();
//        Iterable<BusinessMetadata> businessMetadata = businessMetadataRepository.findAll();
//        businessMetadata.forEach(businessMetadataList::add);
//        return businessMetadataList;
//    }


}
