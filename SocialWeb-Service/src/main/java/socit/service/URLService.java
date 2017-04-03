package socit.service;

import socit.domain.URLMassage;

public interface URLService extends BaseService<URLMassage, Integer> {

    URLMassage byURLArgument(String argument, String column);
}
