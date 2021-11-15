package sendgrid.implementation;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import sendgrid.proxies.Event;

public class ConfigurationMapper {

    private static ConfigurationMapper instance = null;
    private String eventHandlerMicroflowName;

    private ConfigurationMapper() {
    }

    public static ConfigurationMapper getInstance() {
        if (instance == null) {
            instance = new ConfigurationMapper();
        }
        return instance;
    }

    public void initialize(String eventHandlerMicroflowName) {
        this.eventHandlerMicroflowName = eventHandlerMicroflowName;

        // Validator throws MendixRuntimeException when validation fails
    }

    public IMendixObject processEvent(IContext context, Event event) throws CoreException {
        return Core.microflowCall(this.eventHandlerMicroflowName)
                .withParam("Event", event.getMendixObject())
                .execute(context);
    }

}