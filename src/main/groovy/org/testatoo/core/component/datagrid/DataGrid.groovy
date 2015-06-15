/**
 * Copyright (C) 2014 Ovea (dev@ovea.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.testatoo.core.component.datagrid

import org.testatoo.core.Assert
import org.testatoo.core.component.Component
import org.testatoo.core.property.ColumnSize
import org.testatoo.core.property.Size

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@Assert("it.is('table')")
class DataGrid extends Component {

    DataGrid() {
        support Size, { it.eval("it.find('thead tr:last th').length") as int }
        support ColumnSize, { it.eval("it.find('tbody tr').length") as int }
    }

    List<Column> getColumns() {
        //TODO: davic check if it works
        find("'thead tr:last th'", Column)
    }

    List<Row> getRows() {
        this.evaluator.getMetaInfo("\$('#${id}').find('tbody tr')").collect { it as Row }
    }
}
