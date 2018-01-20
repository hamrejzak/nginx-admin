package com.jslsolucoes.nginx.admin.agent.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jslsolucoes.nginx.admin.agent.auth.AuthHandler;
import com.jslsolucoes.nginx.admin.agent.error.ErrorHandler;
import com.jslsolucoes.nginx.admin.agent.model.request.NginxCommandLineInterfaceRequest;
import com.jslsolucoes.nginx.admin.agent.model.response.NginxCommandLineInterfaceResponse;
import com.jslsolucoes.nginx.admin.agent.resource.impl.NginxCommandLineInterfaceResourceImpl;
import com.jslsolucoes.runtime.RuntimeResult;

@Path("commandLineInterface")
@ErrorHandler
@AuthHandler
@Produces(MediaType.APPLICATION_JSON)
public class NginxCommandLineInterfaceResource {

	@Inject
	private NginxCommandLineInterfaceResourceImpl nginxCommandLineInterfaceResourceImpl;

	@POST
	@Path("start")
	public void start(NginxCommandLineInterfaceRequest nginxCommandLineInterfaceRequest, @Suspended AsyncResponse asyncResponse) {
		RuntimeResult runtimeResult = nginxCommandLineInterfaceResourceImpl.start(nginxCommandLineInterfaceRequest.getBin(),
				nginxCommandLineInterfaceRequest.getHome());
		asyncResponse.resume(Response.ok(new NginxCommandLineInterfaceResponse(runtimeResult.getOutput(),
				runtimeResult.isSuccess())).build());
	}

	@POST
	@Path("killAll")
	public void killAll(NginxCommandLineInterfaceRequest nginxCommandLineInterfaceRequest, @Suspended AsyncResponse asyncResponse) {
		RuntimeResult runtimeResult = nginxCommandLineInterfaceResourceImpl.killAll();
		asyncResponse.resume(
				Response.ok(new NginxCommandLineInterfaceResponse(runtimeResult.getOutput(), runtimeResult.isSuccess())).build());
	}

	@POST
	@Path("stop")
	public void stop(NginxCommandLineInterfaceRequest nginxCommandLineInterfaceRequest, @Suspended AsyncResponse asyncResponse) {
		RuntimeResult runtimeResult = nginxCommandLineInterfaceResourceImpl.stop(nginxCommandLineInterfaceRequest.getBin(),
				nginxCommandLineInterfaceRequest.getHome());
		asyncResponse.resume(
				Response.ok(new NginxCommandLineInterfaceResponse(runtimeResult.getOutput(), runtimeResult.isSuccess())).build());
	}

	@POST
	@Path("status")
	public void status(NginxCommandLineInterfaceRequest nginxCommandLineInterfaceRequest, @Suspended AsyncResponse asyncResponse) {
		RuntimeResult runtimeResult = nginxCommandLineInterfaceResourceImpl.status();
		asyncResponse.resume(
				Response.ok(new NginxCommandLineInterfaceResponse(runtimeResult.getOutput(), runtimeResult.isSuccess())).build());
	}
	
	@POST
	@Path("testConfiguration")
	public void testConfiguration(NginxCommandLineInterfaceRequest nginxCommandLineInterfaceRequest, @Suspended AsyncResponse asyncResponse) {
		RuntimeResult runtimeResult = nginxCommandLineInterfaceResourceImpl.testConfiguration(nginxCommandLineInterfaceRequest.getBin(),
				nginxCommandLineInterfaceRequest.getHome());
		asyncResponse.resume(
				Response.ok(new NginxCommandLineInterfaceResponse(runtimeResult.getOutput(), runtimeResult.isSuccess())).build());
	}
	
	@POST
	@Path("version")
	public void version(NginxCommandLineInterfaceRequest nginxCommandLineInterfaceRequest, @Suspended AsyncResponse asyncResponse) {
		RuntimeResult runtimeResult = nginxCommandLineInterfaceResourceImpl.version(nginxCommandLineInterfaceRequest.getBin(),
				nginxCommandLineInterfaceRequest.getHome());
		asyncResponse.resume(
				Response.ok(new NginxCommandLineInterfaceResponse(runtimeResult.getOutput(), runtimeResult.isSuccess())).build());
	}
	
	@POST
	@Path("reload")
	public void reload(NginxCommandLineInterfaceRequest nginxCommandLineInterfaceRequest, @Suspended AsyncResponse asyncResponse) {
		RuntimeResult runtimeResult = nginxCommandLineInterfaceResourceImpl.reload(nginxCommandLineInterfaceRequest.getBin(),
				nginxCommandLineInterfaceRequest.getHome());
		asyncResponse.resume(
				Response.ok(new NginxCommandLineInterfaceResponse(runtimeResult.getOutput(), runtimeResult.isSuccess())).build());
	}
	
	@POST
	@Path("restart")
	public void restart(NginxCommandLineInterfaceRequest nginxCommandLineInterfaceRequest, @Suspended AsyncResponse asyncResponse) {
		RuntimeResult runtimeResult = nginxCommandLineInterfaceResourceImpl.restart(nginxCommandLineInterfaceRequest.getBin(),
				nginxCommandLineInterfaceRequest.getHome());
		asyncResponse.resume(
				Response.ok(new NginxCommandLineInterfaceResponse(runtimeResult.getOutput(), runtimeResult.isSuccess())).build());
	}

}