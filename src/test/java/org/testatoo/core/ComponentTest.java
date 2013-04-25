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
package org.testatoo.core;

import org.junit.Test;
import org.testatoo.core.component.*;
import org.testatoo.core.nature.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
public class ComponentTest {

    @Test
    public void component_implement_expected_nature() {
        String id = "myId";

        Button button = new Button(id);
        CheckBox checkBox = new CheckBox(id);
        Link link = new Link(id);
        Page page = new Page(id);
        Panel panel = new Panel(id);
        PasswordField passwordField = new PasswordField(id);
        Radio radio = new Radio(id);
        TextField textField = new TextField(id);
        DropDown dropDown = new DropDown(id);
        ComboBox comboBox = new ComboBox(id);

        // Checkable
        assertTrue(Checkable.class.isInstance(checkBox));
        assertTrue(Checkable.class.isInstance(radio));

        // LabelSupport
        assertTrue(LabelSupport.class.isInstance(checkBox));
        assertTrue(LabelSupport.class.isInstance(radio));
        assertTrue(LabelSupport.class.isInstance(textField));
        assertTrue(LabelSupport.class.isInstance(passwordField));
        assertTrue(LabelSupport.class.isInstance(dropDown));
        assertTrue(LabelSupport.class.isInstance(comboBox));

        // TextSupport
        assertTrue(TextSupport.class.isInstance(button));
        assertTrue(TextSupport.class.isInstance(link));

        // TitleSupport
        assertTrue(TitleSupport.class.isInstance(panel));
        assertTrue(TitleSupport.class.isInstance(page));

        // ValueSupport
        assertTrue(ValueSupport.class.isInstance(textField));
        assertTrue(ValueSupport.class.isInstance(passwordField));

        // ReferenceSupport
        assertTrue(ReferenceSupport.class.isInstance(link));
    }
}
