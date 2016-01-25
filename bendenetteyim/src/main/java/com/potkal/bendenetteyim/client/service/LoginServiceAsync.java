package com.potkal.bendenetteyim.client.service;

import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>LoginService</code>.
 */
public interface LoginServiceAsync {
	Request existsUser(String username, String password, AsyncCallback<Boolean> callback);
}
