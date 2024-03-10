package tobeto.com.tobetobootcampproject.core.crosscuttingconcerns.logging.configuration.mongodb;

import tobeto.com.tobetobootcampproject.core.crosscuttingconcerns.logging.LogDetail;
import tobeto.com.tobetobootcampproject.core.crosscuttingconcerns.logging.LogParameter;
import tobeto.com.tobetobootcampproject.core.crosscuttingconcerns.logging.LoggerServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDBLogger extends LoggerServiceBase {

    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoDBLogger(MongoTemplate mongoTemplate){
        super(MongoDBLogger.class);
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void log(String methodName, List<LogParameter> logParameters, String userName) {
        LogDetail detail = new LogDetail();
        detail.setMethodName(methodName);
        detail.setUser(userName);
        detail.setParameters(logParameters);
        info(detail.toString());
        mongoTemplate.save(detail);
    }
}
