package com.example.sysbiblioteca.utils;

import java.nio.file.Paths;

public class PathFXML {

    public static String pathBase() {
        return Paths.get("C:\\Users\\felip\\Documents\\sys-biblioteca\\src\\main\\java\\com\\example\\sysbiblioteca\\view").toAbsolutePath().toString();
    }
}
