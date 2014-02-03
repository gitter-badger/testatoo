/**
 * Copyright (C) 2008 Ovea <dev@ovea.com>
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
package org.testatoo.core.input

import org.testatoo.core.Testatoo
import org.testatoo.core.component.Component

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class Mouse {

    static void clickOn(Component c) { Testatoo.evaluator.mouse().click(c.id) }

    static void doubleClickOn(Component c) { Testatoo.evaluator.mouse().doubleClick(c.id) }

    static void rightClickOn(Component c) { Testatoo.evaluator.mouse().rightClick(c.id) }

    static void mouseOver(Component c) { Testatoo.evaluator.mouse().mouseOver(c.id) }

    static Dragger drag(Component c) {
        return new Dragger(c)
    }

    public static class Dragger {
        private Component from;

        public Dragger(Component from) {
            this.from = from;
        }

        public void on(Component to) {
            Testatoo.evaluator.mouse().dragAndDrop(from.id, to.id)
        }
    }

}
