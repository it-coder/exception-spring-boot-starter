package com.github.lihang1991.entity;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

/**
 *  异常消息体
 * @author lih
 * @date 2019-04-20-10:52.
 */
public class ExceptionNotice {

    /**
     * 工程名
     */
    protected String project;


    /**
     * 异常的标识码
     */
    protected String uid;

    /**
     * 方法名
     */
    protected String methodName;

    /**
     * 方法参数信息
     */
    protected List<Object> parames;

    /**
     * 类路径
     */
    protected String classPath;

    /**
     * 异常信息
     */
    protected String exceptionMessage;

    /**
     * 异常追踪信息
     */
    protected List<String> traceInfo;

    public ExceptionNotice(Throwable ex, Object[] args, String projectName) {
        this.exceptionMessage = parseExceptionMessage(ex);
        this.parames = args == null ? null : Arrays.stream(args).collect(toList());
        this.project = projectName;
        List<StackTraceElement> list = Arrays.stream(ex.getStackTrace())
                .filter(x -> !x.getFileName().equals("<generated>")).collect(toList());
        if (list.size() > 0) {
            this.traceInfo = list.stream().map(x -> x.toString()).collect(toList());
            this.methodName = list.get(0).getMethodName();
            this.classPath = list.get(0).getClassName();
        }
    }


    private String parseExceptionMessage(Throwable exception) {
        String em = exception.toString();
        if (exception.getCause() != null)
            em = String.format("%s\r\n\tcaused by : %s", em, parseExceptionMessage(exception.getCause()));
        return em;
    }

    public String createText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("工程信息：").append(project).append("\r\n");
        stringBuilder.append("类路径：").append(classPath).append("\r\n");
        stringBuilder.append("方法名：").append(methodName).append("\r\n");
        if (parames != null && parames.size() > 0) {
            stringBuilder.append("参数信息：")
                    .append(String.join(",", parames.stream().map(x -> x.toString()).collect(toList()))).append("\r\n");
        }
        stringBuilder.append("异常信息：").append(exceptionMessage).append("\r\n");
        stringBuilder.append("异常追踪：").append("\r\n").append(String.join("\r\n", traceInfo)).append("\r\n");
        return stringBuilder.toString();

    }


    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Object> getParames() {
        return parames;
    }

    public void setParames(List<Object> parames) {
        this.parames = parames;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public List<String> getTraceInfo() {
        return traceInfo;
    }

    public void setTraceInfo(List<String> traceInfo) {
        this.traceInfo = traceInfo;
    }
}
