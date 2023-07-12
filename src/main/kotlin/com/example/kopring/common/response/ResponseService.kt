package com.example.kopring.common.response

import com.example.kopring.common.result.ListResult
import com.example.kopring.common.result.Result
import com.example.kopring.common.result.SingleResult
import org.springframework.stereotype.Service

@Service
class ResponseService {

    fun <T> getSingleResult(data: T): SingleResult<T> {
        return SingleResult(data)
    }

    fun <T> getListResult(data : List<T>) : ListResult<T> {
        return ListResult(data);
    }

    fun getSuccessResult() : Result {
        return Result();
    }

    fun getFailureResult(code : Int, message : String) : Result{
        return Result(code, message);
    }
}