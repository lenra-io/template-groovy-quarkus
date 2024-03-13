package io.lenra.app;

import java.util.List;
import java.util.Map;
import io.lenra.api.Exposer;
import io.lenra.api.Route;
import io.lenra.api.components.View;
import io.lenra.api.components.view.definitions.Find;
import io.lenra.app.annotation.AppManifest;

@AppManifest
public class Manifest extends io.lenra.api.Manifest {
	public Manifest() {
		json = new Exposer(
			routes: [
				new Route(
					path: "/counter/global",
					view: new View(
						name: "counter",
						find: new Find(
							coll: "counter",
							query: [user: "global"]
						)
					),
					roles: [
						"guest",
						"user"
					]
				),
				new Route(
					path: "/counter/me",
					view: new View(
						name: "counter",
						find: new Find(
							coll: "counter",
							query: [user: "@me"]
						)
					)
				)
			]
		);
	}
}
