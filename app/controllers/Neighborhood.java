package controllers;

import java.util.List;

import models.Borough;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.neighborhood.index;

import com.google.inject.Inject;

import dao.NeighborhoodDAO;

public class Neighborhood extends Controller {

	String[] colors = {"goldenrod","green", "orange", "darkblue", "darkred"};
	
	@Inject
	private NeighborhoodDAO neighborhoodDAO;

	@Transactional
    public Result index() {
    	List<Borough> boroughs = neighborhoodDAO.boroughList();
    	
    	for (Borough borough : boroughs) {
    		int colorIndex = boroughs.indexOf(borough);
    		borough.color = colors[colorIndex];
    	}

    	return ok(index.render(boroughs));          
    }
	
}
