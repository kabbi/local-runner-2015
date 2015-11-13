package com.codeforces.commons.io.http;

import com.codeforces.commons.io.http.HttpRequest;
import com.codeforces.commons.text.StringUtil;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class HttpResponse {
    private final int code;
    private final byte[] bytes;
    private final Map headersByName;
    private final IOException ioException;

    HttpResponse(int var1, byte[] var2, Map var3, IOException var4) {
        if(var1 == -1 == (var4 == null)) {
            throw new IllegalArgumentException("Argument \'ioException\' should be set if and only if argument \'code\' is -1.");
        } else {
            this.code = var1;
            this.bytes = var2;
            this.headersByName = var3 != null && !var3.isEmpty()?HttpRequest.getDeepUnmodifiableMap(var3):null;
            this.ioException = var4;
        }
    }

    public int getCode() {
        return this.code;
    }

    public IOException getIoException() {
        return this.ioException;
    }

    public boolean hasIoException() {
        return this.ioException != null;
    }

    public String getUtf8String() {
        return this.bytes == null?null:new String(this.bytes, StandardCharsets.UTF_8);
    }

    public String toString() {
        return String.format("Response {code=%d, size=%s, s=\'%s\'}", new Object[]{Integer.valueOf(this.code), this.bytes == null?"null":Integer.toString(this.bytes.length), StringUtil.shrinkTo(this.getUtf8String(), 50)});
    }
}
