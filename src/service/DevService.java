package service;

import domain.*;
import dao.*;

public class DevService {
    private final DevDao devDao;

    public DevService(DevDao devDao) {
        this.devDao = devDao;
    }

    public DevDomain salvar(DevDomain dev) {
        return devDao.save(dev);
    }

    public long totalDevs() {
        return devDao.count();
    }
}
