package src.manager;

import service.UserService;

public interface ServiceManager {
    UserService newUserService();
}

