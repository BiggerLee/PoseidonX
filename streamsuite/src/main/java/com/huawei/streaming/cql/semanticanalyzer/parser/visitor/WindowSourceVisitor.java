/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.streaming.cql.semanticanalyzer.parser.visitor;

import org.antlr.v4.runtime.misc.NotNull;

import com.huawei.streaming.cql.semanticanalyzer.parser.CQLParser;
import com.huawei.streaming.cql.semanticanalyzer.parser.context.WindowSourceContext;

/**
 * windowsource遍历
 * 
 */
public class WindowSourceVisitor extends AbsCQLParserBaseVisitor<WindowSourceContext>
{
    private WindowSourceContext context = null;
    
    /**
     * <默认构造函数>
     */
    public WindowSourceVisitor()
    {
        context = new WindowSourceContext();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected WindowSourceContext defaultResult()
    {
        return context;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public WindowSourceContext visitRangeWindow(@NotNull CQLParser.RangeWindowContext ctx)
    {
        RangeWindowVisitor visitor = new RangeWindowVisitor();
        context.setRangeWindow(visitor.visit(ctx));
        return context;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public WindowSourceContext visitRowsWindow(@NotNull CQLParser.RowsWindowContext ctx)
    {
        RowsWindowVisitor visitor = new RowsWindowVisitor();
        context.setRowsWindow(visitor.visit(ctx));
        return context;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public WindowSourceContext visitRangeToday(@NotNull CQLParser.RangeTodayContext ctx)
    {
        RangeTodayVisitor visitor = new RangeTodayVisitor();
        context.setRangeToday(visitor.visit(ctx));
        return context;
    }
    
}