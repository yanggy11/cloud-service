package com.yanggy.cloud.gateway;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * @author derrick.yang
 * @Date 1/22/19 1:31 PM
 */
public class Test {
    public static void main(String[] args) {
        SolrQuery query = new SolrQuery();
        query.setStart(0);
        query.setRows(2);

        query.setQuery("storeName:银盘烤肉");


//        SolrClient solrClient =

    }
}
