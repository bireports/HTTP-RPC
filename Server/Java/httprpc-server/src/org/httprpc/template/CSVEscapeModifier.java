/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.httprpc.template;

import java.util.Locale;

/**
 * CSV escape modifier.
 */
public class CSVEscapeModifier implements Modifier {
    @Override
    public Object apply(Object value, String argument, Locale locale) {
        StringBuilder resultBuilder = new StringBuilder();

        String string = value.toString();

        for (int i = 0, n = string.length(); i < n; i++) {
            char c = string.charAt(i);

            if (c == '"' || c == '\\') {
                resultBuilder.append("\\" + c);
            } else {
                resultBuilder.append(c);
            }
        }

        return resultBuilder.toString();
    }
}
