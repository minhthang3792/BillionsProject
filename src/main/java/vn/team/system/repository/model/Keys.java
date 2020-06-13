/*
 * This file is generated by jOOQ.
 */
package vn.team.system.repository.model;


import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import vn.team.system.repository.model.tables.Depart;
import vn.team.system.repository.model.tables.Record;
import vn.team.system.repository.model.tables.Staff;
import vn.team.system.repository.model.tables.User;
import vn.team.system.repository.model.tables.records.DepartRecord;
import vn.team.system.repository.model.tables.records.RecordRecord;
import vn.team.system.repository.model.tables.records.StaffRecord;
import vn.team.system.repository.model.tables.records.UserRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>personel</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<RecordRecord, Integer> IDENTITY_RECORD = Identities0.IDENTITY_RECORD;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DepartRecord> KEY_DEPART_PRIMARY = UniqueKeys0.KEY_DEPART_PRIMARY;
    public static final UniqueKey<RecordRecord> KEY_RECORD_PRIMARY = UniqueKeys0.KEY_RECORD_PRIMARY;
    public static final UniqueKey<StaffRecord> KEY_STAFF_PRIMARY = UniqueKeys0.KEY_STAFF_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<RecordRecord, StaffRecord> RECORD_IBFK_1 = ForeignKeys0.RECORD_IBFK_1;
    public static final ForeignKey<StaffRecord, DepartRecord> STAFF_IBFK_1 = ForeignKeys0.STAFF_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<RecordRecord, Integer> IDENTITY_RECORD = Internal.createIdentity(Record.RECORD, Record.RECORD.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<DepartRecord> KEY_DEPART_PRIMARY = Internal.createUniqueKey(Depart.DEPART, "KEY_depart_PRIMARY", new TableField[] { Depart.DEPART.ID }, true);
        public static final UniqueKey<RecordRecord> KEY_RECORD_PRIMARY = Internal.createUniqueKey(Record.RECORD, "KEY_record_PRIMARY", new TableField[] { Record.RECORD.ID }, true);
        public static final UniqueKey<StaffRecord> KEY_STAFF_PRIMARY = Internal.createUniqueKey(Staff.STAFF, "KEY_staff_PRIMARY", new TableField[] { Staff.STAFF.ID }, true);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", new TableField[] { User.USER.USERNAME }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<RecordRecord, StaffRecord> RECORD_IBFK_1 = Internal.createForeignKey(Keys.KEY_STAFF_PRIMARY, Record.RECORD, "Record_ibfk_1", new TableField[] { Record.RECORD.STAFFID }, true);
        public static final ForeignKey<StaffRecord, DepartRecord> STAFF_IBFK_1 = Internal.createForeignKey(Keys.KEY_DEPART_PRIMARY, Staff.STAFF, "Staff_ibfk_1", new TableField[] { Staff.STAFF.DEPARTID }, true);
    }
}
