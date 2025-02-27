/*
 * Copyright DataStax, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright (C) 2021 ScyllaDB
 *
 * Modified by ScyllaDB
 */
package com.datastax.driver.core;

import com.datastax.driver.core.utils.ScyllaSkip;

@ScyllaSkip /* @IntegrationTestDisabledScyllaUnsupportedFunctionality */
@CCMConfig(options = {"-p ByteOrderedPartitioner", "--vnodes"})
public class OPPTokenVnodeIntegrationTest extends TokenIntegrationTest {

  public OPPTokenVnodeIntegrationTest() {
    super(DataType.blob(), true);
  }

  @Override
  protected Token.Factory tokenFactory() {
    return Token.OPPToken.FACTORY;
  }

  @Override
  public void beforeTestClass(Object testInstance) throws Exception {
    skipTestWithCassandraVersionOrHigher("4.0.0", "ByteOrderedPartitioner");
    super.beforeTestClass(testInstance);
  }
}
