/*
 * Copyright (c) 2010-2018. Axon Framework
 *
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

package org.axonframework.commandhandling.distributed.commandfilter;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.distributed.CommandMessageFilter;

/**
 * Filter that negates the result of another matcher
 *
 * @author Allard Buijze
 * @since 4.0
 */
public class NegateCommandMessageFilter implements CommandMessageFilter {

    private final CommandMessageFilter filter;

    /**
     * Initialize a filter that negates results of the the given {@code filter}.
     *
     * @param filter The filter to negate
     */
    public NegateCommandMessageFilter(CommandMessageFilter filter) {
        this.filter = filter;
    }

    @Override
    public boolean matches(CommandMessage<?> commandMessage) {
        return !filter.matches(commandMessage);
    }
}