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

package org.httprpc;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Abstract base class for HTTP-RPC web services.
 */
public abstract class WebService {
    private Locale locale = null;
    private String userName = null;
    private Set<String> userRoles = null;

    /**
     * Returns the locale associated with the current request.
     *
     * @return
     * The locale associated with the current request.
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Sets the locale associated with the current request.
     *
     * @param locale
     * The locale associated with the current request.
     */
    protected void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Returns the user name associated with the current request.
     *
     * @return
     * The user name associated with the current request, or <tt>null</tt> if
     * the user has not been authenticated.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name associated with the current request.
     *
     * @param userName
     * The user name associated with the current request, or <tt>null</tt> if
     * the request has not been authenticated.
     */
    protected void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns the user's roles.
     *
     * @return
     * A set representing the roles the user belongs to.
     */
    public Set<String> getUserRoles() {
        return userRoles;
    }

    /**
     * Sets the user's roles.
     *
     * @param roles
     * A set representing the roles the user belongs to, or <tt>null</tt> if
     * the request has not been authenticated.
     */
    protected void setUserRoles(Set<String> roles) {
        this.userRoles = roles;
    }

    /**
     * Creates a map from a list of entries.
     *
     * @param <K> The type of the key.
     *
     * @param entries
     * The entries from which the map will be created.
     *
     * @return
     * A map containing the given entries.
     */
    @SafeVarargs
    public static <K> Map<K, ?> mapOf(Map.Entry<K, ?>... entries) {
        LinkedHashMap<K, Object> map = new LinkedHashMap<>();

        for (Map.Entry<K, ?> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }

        return map;
    }

    /**
     * Creates a map entry.
     *
     * @param <K> The type of the key.
     *
     * @param key
     * The entry's key.
     *
     * @param value
     * The entry's value.
     *
     * @return
     * The map entry.
     */
    public static <K> Map.Entry<K, ?> entry(K key, Object value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }
}
