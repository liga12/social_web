package util;

import org.hibernate.Session;

public class SessionClass {

    static Session session = PoolManager.getSession();

    public static Session getSession() {
        if (session != null || session.isOpen()) {
            return session;
        } else {
            session = PoolManager.getSession();
            return session;
        }
    }
}
