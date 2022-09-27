package backend.boot.common.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class SuperService {
    // response code/msg
    protected String SUCCESS_CD = "success";
    protected String SUCCESS_MSG = "성공";

    protected String DEFAULT_ERROR_CD = "fail";
    protected String DEFAULT_ERROR_MSG = "실패";

    // db connection
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
}
