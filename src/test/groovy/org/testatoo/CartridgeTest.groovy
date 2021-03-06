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
package org.testatoo

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.openqa.selenium.firefox.FirefoxDriver
import org.testatoo.core.Testatoo
import org.testatoo.core.component.Panel
import org.testatoo.core.component.input.TextField
import org.testatoo.core.evaluator.webdriver.WebDriverEvaluator
import org.testatoo.core.property.Size
import org.testatoo.core.property.Text
import org.testatoo.core.property.Title

import static org.testatoo.core.Testatoo.*
import static org.testatoo.core.property.Properties.label
import static org.testatoo.core.property.Properties.placeholder
import static org.testatoo.core.property.Properties.size
import static org.testatoo.core.property.Properties.text
import static org.testatoo.core.property.Properties.title
import static org.testatoo.core.property.Properties.value
import static org.testatoo.core.property.Properties.value
import static org.testatoo.core.state.States.getInvalid
import static org.testatoo.core.state.States.getSelected
import static org.testatoo.core.state.States.getValid

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@RunWith(JUnit4)
class CartridgeTest {

    @BeforeClass
    public static void setup() {
        Testatoo.evaluator = new WebDriverEvaluator(new FirefoxDriver())
        open 'http://localhost:8080/cartridge.html'
    }

    @AfterClass
    public static void tearDown() { evaluator.close() }

    @Test
    public void can_override_a_state_and_property_directly_on_component_definition() {
        CustomPanel custom_panel = $('#custom-panel') as CustomPanel

        custom_panel.should { have title('CustomPanel Title') }
        custom_panel.should { be selected }
        custom_panel.should { have text('TEXT') }
    }

    class CustomPanel extends Panel {
        CustomPanel() {
            support Title, { return 'CustomPanel Title' }
            support org.testatoo.core.state.Selected, { return true }
            support Size
            support Text, { return 'TEXT' }
        }
    }
}
