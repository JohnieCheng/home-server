package com.johnie.homeserver.common.utils;

import com.johnie.homeserver.common.enums.ErrorCode;
import com.johnie.homeserver.common.enums.JsonResult;

public class ResultTool {
    public static JsonResult<String> success() {
        return new JsonResult<>(true, "");
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(true, data);
    }

    public static JsonResult<String> fail() {
        return new JsonResult<>(false, "");
    }

    public static JsonResult<String> fail(ErrorCode resultEnum) {
        return new JsonResult<>(false, resultEnum, "");
    }
}
