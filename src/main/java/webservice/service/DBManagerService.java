package webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import webservice.dao.DbClientInfoDao;
import webservice.domain.ClientInfo;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DBManagerService {

    private final DbClientInfoDao dbClientInfoDao;

    private static final Logger logger = LoggerFactory.getLogger(DBManagerService.class);

    @Autowired
    public DBManagerService(DbClientInfoDao dbClientInfoDao) {
        this.dbClientInfoDao = dbClientInfoDao;
    }

    public void saveClient(HttpServletRequest htr) {
        dbClientInfoDao.save(new ClientInfo(htr.getRemoteAddr(), LocalDateTime.now(), htr.getHeader("User-Agent")));
        logger.info("Saved 1 record");
    }

    public List<ClientInfo> getClients() {
        return dbClientInfoDao.findAll();
    }

    public List<ClientInfo> getByIp(String ip) {
        return dbClientInfoDao.findByIp(ip);
    }

    public void deleteByIp(String ip) {
        logger.info("Count of deleted record: {}", dbClientInfoDao.deleteByIp(ip));
    }

    public void updateByIp(String ip) {
        logger.info("Count of updated record: {}", dbClientInfoDao.updateByIp(ip));
    }
}
