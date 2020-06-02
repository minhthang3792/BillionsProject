/*
 * This file is generated by jOOQ.
 */
package vn.team.system.repository.model.routines;


import vn.team.system.repository.model.Personel;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Spthongkethanhtich extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = -1055650893;

    /**
     * The parameter <code>Personel.spThongKeThanhTich._StaffId</code>.
     */
    public static final Parameter<String> _STAFFID = Internal.createParameter("_StaffId", org.jooq.impl.SQLDataType.VARCHAR(10), false, false);

    /**
     * Create a new routine call instance
     */
    public Spthongkethanhtich() {
        super("spThongKeThanhTich", Personel.PERSONEL);

        addInParameter(_STAFFID);
    }

    /**
     * Set the <code>_StaffId</code> parameter IN value to the routine
     */
    public void set_Staffid(String value) {
        setValue(_STAFFID, value);
    }
}