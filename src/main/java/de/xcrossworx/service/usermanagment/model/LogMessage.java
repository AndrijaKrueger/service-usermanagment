package de.xcrossworx.service.usermanagment.model;

public class LogMessage {

    private String systemName;

    private LogType logType;

    private String logMethod;

    private String logMessage;

    private String logData;

    private String exMessage;

    private String exStacktrace;

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getExMessage() {
        return exMessage;
    }

    public void setExMessage(String exMessage) {
        this.exMessage = exMessage;
    }

    public String getExStacktrace() {
        return exStacktrace;
    }

    public void setExStacktrace(String exStacktrace) {
        this.exStacktrace = exStacktrace;
    }

    public LogMessage() {
    }

    public LogMessage(String systemName, LogType logType, String logMethod, String logMessage, String logData, String exMessage, String exStacktrace) {
        this.systemName = systemName;
        this.logType = logType;
        this.logMethod = logMethod;
        this.logMessage = logMessage;
        this.logData = logData;
        this.exMessage = exMessage;
        this.exStacktrace = exStacktrace;
    }
}
