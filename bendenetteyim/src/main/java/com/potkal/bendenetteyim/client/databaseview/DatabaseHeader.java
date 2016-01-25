// Copyright 2014 Tina Steiger

// This file is part of GWT_AppNavigation.
// GWT_AppNavigation is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// GWT_AppNavigation is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with GWT_AppNavigation.  If not, see <http://www.gnu.org/licenses/>.

package com.potkal.bendenetteyim.client.databaseview;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;

/**
 * This class represents the header of the database view.
 * 
 * @author Tina Steiger
 */
public class DatabaseHeader extends Composite{
	
	/**The main panel of the header*/
	private FlowPanel headerPanel = new FlowPanel();
	
	/**The logo image*/
	private Image logo = new Image("resources/images/tigertech-logo.jpg");
	
	/**The headline below the logo*/
	private HTML secondoHeadline = new HTML("<h3>View to select a database</h3>");
	
	public DatabaseHeader(){
		
		logo.setWidth("300px");
		headerPanel.add(logo);
		headerPanel.add(secondoHeadline);		
	}

	/**Returns the main panel of the header
	 * 
	 * @return The main panel of the header
	 * */
	public FlowPanel getHeaderPanel() {
		return headerPanel;
	}
}
