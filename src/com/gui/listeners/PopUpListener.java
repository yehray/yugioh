package com.gui.listeners;

import com.gui.OverlapLayout;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpListener extends MouseAdapter{
    private OverlapLayout layout;
    public PopUpListener(OverlapLayout addedLayout){
        layout = addedLayout;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        layout.addLayoutComponent(c, OverlapLayout.POP_UP);
        c.getParent().invalidate();
        c.getParent().validate();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component c = e.getComponent();
        layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);
        c.getParent().invalidate();
        c.getParent().validate();
    }
}
