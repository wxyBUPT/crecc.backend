package com.crecc.sale.web.inventory;

import com.crecc.sale.web.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiyuanbupt on 2018/11/28.
 * 暂时不用处理本类的Exception
 */
@ControllerAdvice
public class InventoryExceptionHandler {
    @ExceptionHandler(value = InventoryException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, InventoryException e) throws Exception{
        //// TODO: 2018/11/30 没有设置返回码之类的问题, 即做不到状态码不要是200
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
