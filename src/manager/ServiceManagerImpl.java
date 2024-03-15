package src.manager;

import service.UserService;
import service.UserServiceImpl;

public class ServiceManagerImpl implements ServiceManager {
    public RepoManager repo;

    public ServiceManagerImpl(RepoManager repo) {
        this.repo = repo;
    }

    @Override
    public UserService newUserService() {
        return new UserServiceImpl(null);
    }
}
