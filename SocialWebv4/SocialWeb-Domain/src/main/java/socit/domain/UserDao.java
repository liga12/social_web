package socit.domain;

public interface UserDao extends BaseDao<User, Integer> {

    User byUserArgument(String argument, String column);

    User byUserTwoArgument(String firstArgument, String firstColumn,
                           String secondArgument, String secondColumn);
}
