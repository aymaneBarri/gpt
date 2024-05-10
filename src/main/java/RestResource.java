import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class RestResource {
	@GET
	@Produces("text/plain")
	public String getHello() {
		return "SALAM";
	}
	
	@GET
	@Path("/{name}")
	@Produces("text/plain")
	public String getHelloName(@PathParam("name") String name) {
		return "SALAM " + name;
	}
}