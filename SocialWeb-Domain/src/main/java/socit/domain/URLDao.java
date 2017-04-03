package socit.domain;

public interface URLDao extends BaseDao<URLMassage, Integer> {

    URLMassage byURLArgument(String argument, String column);
}
