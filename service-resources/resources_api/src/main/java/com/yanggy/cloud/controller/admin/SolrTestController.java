package com.yanggy.cloud.controller.admin;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 12/14/18 11:16 AM
 */

@RestController
@RequestMapping("/solr/")
public class SolrTestController {
    @Autowired
    private SolrClient solrClient;

    @PostMapping(value = "getById/{id}")
    public Object getBySolrId(@PathVariable("id") String id) throws IOException, SolrServerException {
        Map<String,String> queryMap = new HashMap<>();


        queryMap.put("q","*.*");
        queryMap.put("fq","{!geofilt}");
        queryMap.put("pt","125.441005 42.172992");
        queryMap.put("sfield","location_p");
        queryMap.put("d", "50");
        queryMap.put("start", "0");
        queryMap.put("rows", "50");
        queryMap.put("sort","geodist() asc");
        queryMap.put("fl","*,_dist:geodist(),score");

        QueryResponse queryResponse = solrClient.query("geo_solr",new MapSolrParams(queryMap));


        return queryResponse.getResults();
    }
}
