package com.hxs.dynamo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.hxs.dynamo.data.models.AnalyticEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *  This is really for dev only to test on a local dynamoDB. In prod, you'd want to have the table already setup, I would think?
 *
 *  Or we could externalize the setProvisionedThroughput params and go that way.
 *
 * @author HSteidel
 */
@Component
public class DynamoInit implements ApplicationListener<ContextRefreshedEvent> {


    private final AmazonDynamoDB amazonDynamoDB;

    @Autowired
    public DynamoInit(AmazonDynamoDB amazonDynamoDB) {
        this.amazonDynamoDB = amazonDynamoDB;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        CreateTableRequest tableRequest = new DynamoDBMapper(amazonDynamoDB)
                .generateCreateTableRequest(AnalyticEvent.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
    }
}
