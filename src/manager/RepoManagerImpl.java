package src.manager;

import java.sql.Connection;

import repository.UserRepo;
import repository.UserRepoImpl; 

public class RepoManagerImpl implements RepoManager {
    private InfraManager infra;

    public RepoManagerImpl(InfraManager infra) {
        this.infra = infra;
    }

    @Override
    public UserRepo newUserRepo() {
        return new UserRepoImpl((Connection) infra);
    }
}
