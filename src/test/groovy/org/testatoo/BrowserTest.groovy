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
import org.testatoo.core.component.Form
import org.testatoo.core.component.Link
import org.testatoo.core.evaluator.webdriver.WebDriverEvaluator

import static org.testatoo.core.Testatoo.*
import static org.testatoo.core.input.Mouse.*
import static org.testatoo.core.state.States.*

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@RunWith(JUnit4)
class BrowserTest {

    @BeforeClass
    public static void setup() {
        Testatoo.evaluator = new WebDriverEvaluator(new FirefoxDriver())
    }

    @AfterClass
    public static void tearDown() { evaluator.close() }

    @Test
    public void should_be_able_to_have_browser_properties_access() {
        open 'http://localhost:8080/components.html'

        assert browser.title == 'Testatoo Rocks'
        assert browser.pageSource.contains('<title>Testatoo Rocks</title>')
        assert browser.url == 'http://localhost:8080/components.html'

        browser.open('http://localhost:8080/keyboard.html')
        assert browser.url == 'http://localhost:8080/keyboard.html'
    }

    @Test
    public void should_be_able_to_navigate() {
        open 'http://localhost:8080/components.html'

        assert browser.url == 'http://localhost:8080/components.html'

        browser.navigate.to('http://localhost:8080/keyboard.html')
        assert browser.url == 'http://localhost:8080/keyboard.html'

        browser.navigate.back()
        assert browser.url == 'http://localhost:8080/components.html'

        browser.navigate.forward()
        assert browser.url == 'http://localhost:8080/keyboard.html'

        browser.navigate.refresh()
        assert browser.url == 'http://localhost:8080/keyboard.html'
    }

    @Test
    public void should_manage_windows() {
        open 'http://localhost:8080/components.html'

        assert browser.windows.size() == 1
        String main_window_id = browser.windows[0].id

        Link link = $('#link') as Link
        Form form = $('#form') as Form

        link.should { be available }
        form.should { be missing }

        click_on link

        assert browser.windows.size() == 2
        link.should { be available }
        form.should { be missing }

        browser.switchTo(browser.windows[1])
        link.should { be missing }
        form.should { be available }

        browser.windows[1].close()
        assert browser.windows.size() == 1
        assert browser.windows[0].id == main_window_id
    }
}
