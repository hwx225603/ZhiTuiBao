package com.xiaour.spring.boot.config;

import com.xiaour.spring.boot.model.ResultModel;

public class BaseController {
	
    public ResultModel ok(Object content) {
        return new ResultModel(ResultStatus.SUCCESS, content);
    }

    public ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    public ResultModel error(ResultStatus error) {
        return new ResultModel(error);
    }
    
}
