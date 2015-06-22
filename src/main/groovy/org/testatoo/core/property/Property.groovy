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
package org.testatoo.core.property

import org.testatoo.bundle.html5.components.Component

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class Property {

    PropertyEvaluator evaluator

    void evaluator(PropertyEvaluator p) { evaluator = p }

    void evaluator(Closure<?> c) { evaluator(c as PropertyEvaluator) }

    void number(String expr) { evaluator { Component c -> c.eval(expr) as BigDecimal } }

    void string(String expr) { evaluator { Component c -> c.eval(expr).trim() } }

    @Override
    String toString() { getClass().simpleName }

}
