package com.miracle.cloud.filter.routes;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import okhttp3.*;
import okhttp3.internal.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER;

public class MyRoutingFilter extends ZuulFilter {

    @Autowired
    private ProxyRequestHelper helper;

    @Override
    public String filterType() {

        return ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SIMPLE_HOST_ROUTING_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getRouteHost() != null && RequestContext.getCurrentContext().sendZuulResponse();
    }

    @Override
    public Object run() {



        OkHttpClient httpClient = new OkHttpClient.Builder()
                // customize
                .build();

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String method = request.getMethod();
        String uri = this.helper.buildZuulRequestURI(request);

        Headers.Builder builder = new Headers.Builder();
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            Enumeration<String> headers = request.getHeaders(name);

            while(headers.hasMoreElements()) {

                String header = headers.nextElement();
                builder.add(header);
            }
        }

        InputStream inputStream = null;
        try {
             inputStream = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


        RequestBody requestBody = null;
        if (inputStream != null && HttpMethod.permitsRequestBody(method)) {
            MediaType mediaType = null;
            if (builder.get("Content-Type") != null) {
                mediaType = MediaType.parse(builder.get("Content-Type"));
            }
            try {
                requestBody = RequestBody.create(mediaType, StreamUtils.copyToByteArray(inputStream));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Request.Builder requestBuilder = new Request.Builder()
                .headers(builder.build())
                .url(uri)
                .method(method, requestBody);

        Response response = null;
        try {
            response = httpClient.newCall(requestBuilder.build()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedMultiValueMap<String, String> responseHeaders = new LinkedMultiValueMap<>();

        for (Map.Entry<String, List<String>> entry : response.headers().toMultimap().entrySet()) {
            responseHeaders.put(entry.getKey(), entry.getValue());
        }

        try {
            this.helper.setResponse(response.code(), response.body().byteStream(),
                    responseHeaders);
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentContext.setRouteHost(null); // prevent SimpleHostRoutingFilter from running
        return null;
    }
}
