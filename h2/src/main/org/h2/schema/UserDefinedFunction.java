/*
 * Copyright 2004-2021 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (https://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.schema;

import org.h2.message.DbException;
import org.h2.table.Table;

/**
 * User-defined Java function or aggregate function.
 */
public abstract class UserDefinedFunction extends SchemaObject {

    String className;

    UserDefinedFunction(Schema newSchema, int id, String name, int traceModuleId) {
        super(newSchema, id, name, traceModuleId);
    }

    @Override
    public final String getCreateSQLForCopy(Table table, String quotedName) {
        throw DbException.getInternalError(toString());
    }

    @Override
    public final void checkRename() {
        throw DbException.getUnsupportedException("RENAME");
    }

    public final String getJavaClassName() {
        return className;
    }

}
