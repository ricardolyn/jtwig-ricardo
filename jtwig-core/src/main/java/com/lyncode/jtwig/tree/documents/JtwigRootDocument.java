/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lyncode.jtwig.tree.documents;

import com.lyncode.jtwig.JtwigContext;
import com.lyncode.jtwig.exception.CompileException;
import com.lyncode.jtwig.exception.RenderException;
import com.lyncode.jtwig.parser.JtwigParser;
import com.lyncode.jtwig.tree.api.Content;
import com.lyncode.jtwig.tree.content.JtwigRootContent;
import com.lyncode.jtwig.tree.helper.RenderStream;
import com.lyncode.jtwig.tree.structural.Block;
import com.lyncode.jtwig.unit.resource.JtwigResource;

public class JtwigRootDocument implements JtwigDocument {
    private Content content;

    public JtwigRootDocument(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }

    @Override
    public void render(RenderStream outputStream, JtwigContext context) throws RenderException {
    }

    @Override
    public Content compile(JtwigParser parser, JtwigResource resource) throws CompileException {
        return new JtwigRootContent(content.compile(parser, resource));
    }

    @Override
    public boolean replace(Block expression) throws CompileException {
        return content.replace(expression);
    }
}
