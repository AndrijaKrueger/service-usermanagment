package de.xcrossworx.service.usermanagment.handler;

import de.xcrossworx.service.usermanagment.App.UserManagmentConfiguration;
import de.xcrossworx.service.usermanagment.model.LogMessage;
import de.xcrossworx.service.usermanagment.model.LogType;

public class LogHandler {

    public static void logMessage(String method, String message, String jsonData) {
        new Thread(new LogDataRunnable(new LogMessage(UserManagmentConfiguration.getServiceName(), LogType.INFO, method, message, jsonData, null, null))).start();
    }

    public static void logErrorMessage(String method, Exception ex) {
        StringBuilder builder = new StringBuilder();

        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            builder.append(stackTraceElement.toString()+ "\n");
        }

        new Thread(new LogDataRunnable(new LogMessage(UserManagmentConfiguration.getServiceName(), LogType.ERROR, method, null, null, ex.getMessage(), builder.toString()))).start();
    }
}
