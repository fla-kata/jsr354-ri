/**
 * Copyright (c) 2012, 2015, Credit Suisse (Anatole Tresch), Werner Keil and others by the @author tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.javamoney.moneta.internal.convert;

import static org.testng.Assert.assertNotNull;

import java.io.InputStream;
import java.time.Month;
import java.time.YearMonth;
import java.util.Map;

import org.testng.annotations.Test;

public class IMFRemoteSearchTest {

	@Test(expectedExceptions = NullPointerException.class)
	public void shouldReturnErrorWhenYearMonthIsNull(){
		IMFRemoteSearch.INSTANCE.getResources(null, null);
	}

	@Test
	public void shouldReturnStream(){
		Map<IMFHistoricalType, InputStream> resources = IMFRemoteSearch.INSTANCE.getResources(YearMonth.of(2015, Month.MAY), null);
		assertNotNull(resources.get(IMFHistoricalType.Currency_SDR));
		assertNotNull(resources.get(IMFHistoricalType.SDR_Currency));
	}

}
