package com.hxs.dynamo.web;

import com.hxs.dynamo.data.models.AnalyticEvent;
import com.hxs.dynamo.data.repositories.AnalyticEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *   Sample controller to show basic wiring / functionality of DynamoDB repository
 *
 * @author HSteidel
 */
@RestController
@RequestMapping("/analytics")
public class AnalyticController {


    private final AnalyticEventRepository analyticEventRepository;

    @Autowired
    public AnalyticController(AnalyticEventRepository analyticEventRepository) {
        this.analyticEventRepository = analyticEventRepository;
    }

    @PostMapping()
    public AnalyticEvent postNewEvent(@Valid @RequestBody AnalyticEvent event){
        return analyticEventRepository.save(event);
    }

    @GetMapping()
    public Page<AnalyticEvent> getPage(Pageable pageable){
        return analyticEventRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public AnalyticEvent getEvent(@PathVariable String id){
        return analyticEventRepository.findById(id).orElse(null);
    }

    @GetMapping("/brands/{brandName}")
    public Page<AnalyticEvent> getPageByBrandName(@PathVariable String brandName, Pageable pageable){
        return analyticEventRepository.findAllByBrand(brandName, pageable);
    }

}
