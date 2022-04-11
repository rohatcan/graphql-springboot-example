package com.rohat.productertask.exception;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handle(GraphQLException e){
        return new ThrowableGraphQLError(e);
    }

    @ExceptionHandler(TeamLimitExceededException.class)
    public ThrowableGraphQLError handle(TeamLimitExceededException e){
        return new ThrowableGraphQLError(e, "Team Limit Exceeded!");
    }
}
