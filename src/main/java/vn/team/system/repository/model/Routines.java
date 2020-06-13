/*
 * This file is generated by jOOQ.
 */
package vn.team.system.repository.model;


import org.jooq.Configuration;

import vn.team.system.repository.model.routines.Spgettop10staff;
import vn.team.system.repository.model.routines.Spthongkethanhtich;
import vn.team.system.repository.model.routines.Spthongkethanhtichphongban;


/**
 * Convenience access to all stored procedures and functions in personel
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>personel.spGetTop10Staff</code>
     */
    public static void spgettop10staff(Configuration configuration) {
        Spgettop10staff p = new Spgettop10staff();

        p.execute(configuration);
    }

    /**
     * Call <code>personel.spThongKeThanhTich</code>
     */
    public static void spthongkethanhtich(Configuration configuration, String _Staffid) {
        Spthongkethanhtich p = new Spthongkethanhtich();
        p.set_Staffid(_Staffid);

        p.execute(configuration);
    }

    /**
     * Call <code>personel.spThongKeThanhTichPhongBan</code>
     */
    public static void spthongkethanhtichphongban(Configuration configuration) {
        Spthongkethanhtichphongban p = new Spthongkethanhtichphongban();

        p.execute(configuration);
    }
}
