package src.manager;

import repository.UserRepo;

public interface RepoManager {
    UserRepo newUserRepo();
}
