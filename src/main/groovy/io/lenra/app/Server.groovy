package io.lenra.app

import io.lenra.api.AppRequest
import jakarta.inject.Inject
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import groovy.transform.CompileStatic

// @CompileStatic
@Path("/{path:.*}")
public class Server {
    @Inject
    private RequestHandler handler;

    @POST
    public Object post(AppRequest request) {
        def result = handler.handle(request);
        if (result instanceof RequestHandler.Resource) {
            def resource = (RequestHandler.Resource) result;
            return Response.ok().entity(resource.getData())
                .type(MediaType.valueOf(resource.getMimetype()))
                .build();
        }
        return result;
    }
}
