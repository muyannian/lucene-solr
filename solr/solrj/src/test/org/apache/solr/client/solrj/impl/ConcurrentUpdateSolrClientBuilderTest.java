/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.solr.client.solrj.impl;

import org.apache.lucene.util.LuceneTestCase;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient.Builder;
import org.junit.Test;

/**
 * Unit tests for {@link Builder}.
 */
public class ConcurrentUpdateSolrClientBuilderTest extends LuceneTestCase {

  @Test(expected = IllegalArgumentException.class)
  public void testRejectsMissingBaseSolrUrl() {
    new Builder(null).build();
  }

  @Test
  public void testMissingQueueSize() {
    try (ConcurrentUpdateSolrClient client = new Builder("someurl").build()){
      // Do nothing as we just need to test that the only mandatory parameter for building the client
      // is the baseSolrUrl
    }
  }
}
