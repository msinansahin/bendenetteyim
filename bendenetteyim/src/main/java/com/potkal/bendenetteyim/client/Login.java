package com.potkal.bendenetteyim.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.potkal.bendenetteyim.client.service.LoginService;
import com.potkal.bendenetteyim.client.service.LoginServiceAsync;

public class Login extends Composite implements HasText {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	/*
	 * @UiTemplate is not mandatory but allows multiple XML templates to be used
	 * for the same widget. Default file loaded will be <class-name>.ui.xml
	 */
	@UiTemplate("Login.ui.xml")
	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	
	private final LoginServiceAsync loginService = GWT.create(LoginService.class);


	// @UiField(provided = true)
	// final LoginResources res;

	private List<LoginEventListener> listeners = new ArrayList<>();

	public Login() {
		// this.res = GWT.create(LoginResources.class);
		// res.style().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));

		// Add a handler to login request to the server
		MyHandler handler = new MyHandler();
		buttonSubmit.addClickHandler(handler);
	}

	public void addListener(LoginEventListener listener) {
		listeners.add(listener);
	}

	private void callListeners(boolean successful) {
		for (LoginEventListener loginEventListener : listeners) {
			if (successful) {
				loginEventListener.onSuccess();
			} else {
				loginEventListener.onFailure();
			}
		}
	}

	@UiField
	TextBox loginBox;

	@UiField
	TextBox passwordBox;

	@UiField
	Label completionLabel1;

	@UiField
	Label completionLabel2;
	
	@UiField
	Button buttonSubmit;

	private Boolean tooShort = false;

	/*
	 * Method name is not relevant, the binding is done according to the class
	 * of the parameter.
	 */
	//@UiHandler("buttonSubmit")
	void doClickSubmit(ClickEvent event) {
		if (!tooShort) {
			// Window.alert("Login Successful!");
			completionLabel1.setText("Login Successful!");
		} else {
			Window.alert("Login or Password is too short!");
		}
		callListeners(!tooShort);
	}

	@UiHandler("loginBox")
	void handleLoginChange(ValueChangeEvent<String> event) {
		if (event.getValue().length() < 6) {
			completionLabel1.setText("Login too short (Size must be > 6)");
			tooShort = true;
		} else {
			tooShort = false;
			completionLabel1.setText("");
		}
	}

	@UiHandler("passwordBox")
	void handlePasswordChange(ValueChangeEvent<String> event) {
		if (event.getValue().length() < 6) {
			tooShort = true;
			completionLabel2.setText("Password too short (Size must be > 6)");
		} else {
			tooShort = false;
			completionLabel2.setText("");
		}
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String arg0) {
		// TODO Auto-generated method stub

	}
	
	// Create a handler for the sendButton and nameField
	class MyHandler implements ClickHandler, KeyUpHandler {
		/**
		 * Fired when the user clicks on the sendButton.
		 */
		public void onClick(ClickEvent event) {
			sendLoginToServer();
		}

		/**
		 * Fired when the user types in the nameField.
		 */
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				sendLoginToServer();
			}
		}

		/**
		 * Send the name from the nameField to the server and wait for a
		 * response.
		 */
		private void sendLoginToServer() {
			// First, we validate the input.
//			errorLabel.setText("");
//			String textToServer = nameField.getText();
//			if (!FieldVerifier.isValidName(textToServer)) {
//				errorLabel.setText("Please enter at least four characters");
//				return;
//			}

			// Then, we send the input to the server.
			loginService.existsUser(loginBox.getValue(), passwordBox.getValue(), new AsyncCallback<Boolean>() {
				
				@Override
				public void onSuccess(Boolean result) {
					callListeners(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}


	public static interface LoginEventListener {
		void onSuccess();
		void onFailure();
	}

}
