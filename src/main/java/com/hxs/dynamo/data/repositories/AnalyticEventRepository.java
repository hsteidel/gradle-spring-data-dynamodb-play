package com.hxs.dynamo.data.repositories;

import com.hxs.dynamo.data.models.AnalyticEvent;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author HSteidel
 */
@EnableScan
@EnableScanCount
public interface AnalyticEventRepository extends PagingAndSortingRepository<AnalyticEvent, String> {

    Page<AnalyticEvent> findAllByBrand(String brandName, Pageable pageable);

}
