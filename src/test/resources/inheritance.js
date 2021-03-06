/*
 * Copyright (C) 2013 Ovea (dev@ovea.com)
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
(function (w) {

  var cartridge = {
    name: 'inheritance',
    components: []
  };

  var $ = w.testatoo;

  $.registerCartridge(cartridge);

  cartridge.components.push({
    type: 'PrimaryButton',
    inherits: 'Button',
    match: function(el) { return el.is('button') && el.hasClass('btn-primary'); },
    text: function(el) {
      return el.text();
    }
  });

  cartridge.components.push({
    type: 'SuccessButton',
    inherits: 'Button',
    match: function(el) { return el.is('button') && el.hasClass('btn-success'); },
    text: function(el) {
      return el.text();
    }
  });

  cartridge.components.push({
    type: 'InfoButton',
    inherits: 'Button',
    match: function(el) { return el.is('button') && el.hasClass('btn-info'); },
    text: function(el) {
      return el.text();
    }
  });

  cartridge.components.push({
    type: 'WarningButton',
    inherits: 'Button',
    match: function(el) { return el.is('button') && el.hasClass('btn-warning'); },
    text: function(el) {
      return el.text();
    }
  });

  cartridge.components.push({
    type: 'DangerButton',
    inherits: 'Button',
    match: function(el) { return el.is('button') && el.hasClass('btn-danger'); },
    text: function(el) {
      return el.text();
    }
  });

}(window));
