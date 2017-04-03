package socit.service;

import socit.domain.User;

public interface UserService extends BaseService<User, Integer> {

    User byUserArgument(String argument, String column);

    User byUserTwoArgument(String firstArgument, String firstColumn,
                           String secondArgument, String secondColumn);
}
