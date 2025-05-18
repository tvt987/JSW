/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snethlios.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class XImage {
    
    public static final Image getApImage() {
        URL url = XImage.class.getResource("/icon/logo.jpg");
        return new ImageIcon(url).getImage();
    }
    public static final Image APP_ICON;

    static {
        String file = "/icon/logo.jpg";
        APP_ICON = new ImageIcon(XImage.class.getResource(file)).getImage();
    }

    public static void save(File src) {
        File dst = new File("Logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("Logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
