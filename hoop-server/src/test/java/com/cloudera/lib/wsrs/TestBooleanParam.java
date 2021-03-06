/*
 * Copyright (c) 2011, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */
package com.cloudera.lib.wsrs;

import com.cloudera.circus.test.XTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBooleanParam extends XTest {

  @Test
  public void param() throws Exception {
    BooleanParam param = new BooleanParam("p", "true") {
    };
    Assert.assertEquals(param.getDomain(), "a boolean");
    Assert.assertEquals(param.value(), Boolean.TRUE);
    Assert.assertEquals(param.toString(), "true");
    param = new BooleanParam("p", "false") {
    };
    Assert.assertEquals(param.value(), Boolean.FALSE);
    param = new BooleanParam("p", null) {
    };
    Assert.assertEquals(param.value(), null);
    param = new BooleanParam("p", "") {
    };
    Assert.assertEquals(param.value(), null);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void invalid() throws Exception {
    new BooleanParam("p", "x") {
    };
  }

}
