/*
 * This file is generated by jOOQ.
 */
package vn.team.system.repository.model.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import vn.team.system.repository.model.Keys;
import vn.team.system.repository.model.Personel;
import vn.team.system.repository.model.tables.records.UserRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 1436846936;

    /**
     * The reference instance of <code>personel.user</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>personel.user.Username</code>.
     */
    public final TableField<UserRecord, String> USERNAME = createField(DSL.name("Username"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>personel.user.Password</code>.
     */
    public final TableField<UserRecord, String> PASSWORD = createField(DSL.name("Password"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>personel.user.Fullname</code>.
     */
    public final TableField<UserRecord, String> FULLNAME = createField(DSL.name("Fullname"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * Create a <code>personel.user</code> table reference
     */
    public User() {
        this(DSL.name("user"), null);
    }

    /**
     * Create an aliased <code>personel.user</code> table reference
     */
    public User(String alias) {
        this(DSL.name(alias), USER);
    }

    /**
     * Create an aliased <code>personel.user</code> table reference
     */
    public User(Name alias) {
        this(alias, USER);
    }

    private User(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> User(Table<O> child, ForeignKey<O, UserRecord> key) {
        super(child, key, USER);
    }

    @Override
    public Schema getSchema() {
        return Personel.PERSONEL;
    }

    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Keys.KEY_USER_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserRecord>> getKeys() {
        return Arrays.<UniqueKey<UserRecord>>asList(Keys.KEY_USER_PRIMARY);
    }

    @Override
    public User as(String alias) {
        return new User(DSL.name(alias), this);
    }

    @Override
    public User as(Name alias) {
        return new User(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name) {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Name name) {
        return new User(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
