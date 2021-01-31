package dk.workkit.interfaces;

import dk.workkit.domain.User;

public interface Session {

    boolean isAuthorized();
    User getUser();

}
