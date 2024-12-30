package com.elmarrakchy.tp1_bank_account_service.exceptions;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {
    protected GraphQLError resolveToSingleError(Throwable ex) {
        if (ex instanceof AccountNotFoundException) {
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage())
                    .errorType(ErrorType.NOT_FOUND)
                    .build();
        }
        // Handle other exceptions or fallbacks
        return GraphqlErrorBuilder.newError()
                .message("Internal server error")
                .errorType(ErrorType.INTERNAL_ERROR)
                .build();
    }
}