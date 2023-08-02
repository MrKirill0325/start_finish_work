package com.example.project.clipBoard;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class WorkWithClipBoard {

    public void copy(String str){
        StringSelection stringSelection = new StringSelection(str);
        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

}
