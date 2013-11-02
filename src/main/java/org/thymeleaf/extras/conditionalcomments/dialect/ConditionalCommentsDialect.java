/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2013, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.extras.conditionalcomments.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.extras.conditionalcomments.dialect.processor.ConditionalCommentProcessor;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.processor.document.ProcessCommentNodesDocumentProcessor;



/**
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ConditionalCommentsDialect extends AbstractDialect {

    
    public ConditionalCommentsDialect() {
        super();
    }

    
    
    public String getPrefix() {
        // No attribute or tag processors, so we don't need a prefix at all and
        // we can return whichever value.
        return "condcom";
    }

    
    public boolean isLenient() {
        return false;
    }



    
    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new ConditionalCommentProcessor());
        // This processor is needed to enable the processing of Comment nodes
        processors.add(new ProcessCommentNodesDocumentProcessor());
        return processors;
    }

    
}
