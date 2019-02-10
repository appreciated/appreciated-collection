package com.github.appreciated.collection.code;

import com.github.appreciated.collection.demo.applayout.codeexample.YourAppLayoutRouterLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class CodeExampleFormatter {

    private List<String> classContent;

    public CodeExampleFormatter(String packagePath) {
        packagePath = packagePath.replaceAll("\\.", "/") + ".java";
        URL resource = getClass().getClassLoader().getResource(packagePath);
        if (resource != null) {
            try {
                InputStreamReader reader = new InputStreamReader(resource.openStream(), StandardCharsets.UTF_8);
                try (BufferedReader buffer = new BufferedReader(reader)) {
                    classContent = buffer.lines().collect(Collectors.toList());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            classContent = classContent.stream().filter(s -> s.length() > 0)
                    .filter(s -> !s.startsWith("import") && !s.startsWith("package"))
                    .collect(Collectors.toList());

            for (int i = 0; i < classContent.size(); i++) {
                String s = classContent.get(i);
                if (s.contains("/*RM")) {
                    classContent.set(i, removeRM(s));
                }
            }
        }
    }

    public String removeRM(String string) {
        if (string.indexOf("/*RM") >= 0 && string.indexOf("RM*/") >= 0) {
            return string.substring(0, string.indexOf("/*RM")) + string.substring(string.indexOf("RM*/") + "RM*/".length());
        }
        return string;
    }

    public static void main(String[] args) {
        System.out.println(new CodeExampleFormatter(YourAppLayoutRouterLayout.class.getName()).getCodeExample());
    }

    public String getCodeExample() {
        String file = "";
        if (classContent != null) {
            for (String s : classContent) {
                file += s + "\n";
            }
        }
        return file;
    }


}