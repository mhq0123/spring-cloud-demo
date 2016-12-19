package com.mhq0123.demo.zuul.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mhq0123 on 2016/12/19.
 *
 * 继承ZuulFilter 实现自己定义的过滤器
 */
public class AccessTokenFilter extends ZuulFilter{

    private final static Logger logger = LoggerFactory.getLogger(AccessTokenFilter.class);

    /**
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过int值来定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。这里，我们直接返回true，所以该过滤器总是生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * 同时可以编辑返回信息
     * @return
     */
    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        logger.info(">>>>>>>>>>method:{},url:{}", httpServletRequest.getMethod(), httpServletRequest.getRequestURI());

        String accessToken = httpServletRequest.getParameter("accessToken");

        logger.info(">>>>>>>>>>accessToken:{}", accessToken);

        if(StringUtils.isEmpty(accessToken)) {
            logger.warn(">>>>>>>>>>access token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
        }

        return null;
    }
}
