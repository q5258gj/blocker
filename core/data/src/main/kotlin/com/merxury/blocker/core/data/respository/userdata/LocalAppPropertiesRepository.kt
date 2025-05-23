/*
 * Copyright 2025 Blocker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.merxury.blocker.core.data.respository.userdata

import com.merxury.blocker.core.datastore.BlockerAppPropertiesDataStore
import com.merxury.blocker.core.model.preference.AppPropertiesData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalAppPropertiesRepository @Inject constructor(
    private val appPropertiesDataSource: BlockerAppPropertiesDataStore,
) : AppPropertiesRepository {
    override val appProperties: Flow<AppPropertiesData>
        get() = appPropertiesDataSource.appPropertiesData

    override suspend fun markComponentDatabaseInitialized() = appPropertiesDataSource.markComponentDatabaseInitialized()

    override suspend fun markGeneralRuleDatabaseInitialized() = appPropertiesDataSource.markGeneralRuleDatabaseInitialized()

    override suspend fun updateLastOpenedAppListHash(hash: String) = appPropertiesDataSource.updateLastOpenedAppListHash(hash)

    override suspend fun updateLastOpenedRuleHash(hash: String) = appPropertiesDataSource.updateLastOpenedRuleHash(hash)
}
