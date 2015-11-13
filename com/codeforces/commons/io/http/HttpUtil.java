package com.codeforces.commons.io.http;

import com.codeforces.commons.io.http.HttpMethod;
import com.codeforces.commons.io.http.HttpRequest;
import com.codeforces.commons.io.http.HttpResponse;

public final class HttpUtil {
    public static HttpRequest newRequest(String var0, Object... var1) {
        return HttpRequest.create(var0, var1);
    }

    public static HttpResponse executePostRequestAndReturnResponse(int var0, String var1, Object... var2) {
        return newRequest(var1, var2).setTimeoutMillis(var0).setMethod(HttpMethod.POST).executeAndReturnResponse();
    }
}
