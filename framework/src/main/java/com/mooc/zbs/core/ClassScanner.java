package com.mooc.zbs.core;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author liyang on 2019/10/11
 */
public class ClassScanner {
    public static List<Class<?>> scanClasses(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>>classList=new ArrayList<>();
        String path=packageName.replace(".","/");
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources=classLoader.getResources(path);
        while (resources.hasMoreElements()){
            URL resource=resources.nextElement();
            if (resource.getProtocol().contains("jar")){
                JarURLConnection jarURLConnection=(JarURLConnection)resource.openConnection();
                String jarFilePath=jarURLConnection.getJarFile().getName();
                classList.addAll(grtClassesFromJar(jarFilePath,path));
            }else {
                //todo
            }
        }
        return classList;
    }
    private static List<Class<?>> grtClassesFromJar(String jarFilePath,String path) throws IOException, ClassNotFoundException {
        List<Class<?>> classes=new ArrayList<>();
        JarFile jarFile=new JarFile(jarFilePath);
        Enumeration<JarEntry> jarEntries=jarFile.entries();
        while (jarEntries.hasMoreElements()){
            JarEntry jarEntry=jarEntries.nextElement();
            String entryName=jarEntry.getName();// com/mooc/zbs/test/Test.class
            if (entryName.startsWith(path)&&entryName.endsWith(".class")) {
                String classFullName=entryName.replace("/",".").substring(0,entryName.length()-6);
                classes.add(Class.forName(classFullName));
            }

        }
        return classes;
    }
}
