package com.tca.listener;

import java.io.PrintWriter;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelListener;
import com.tca.util.ActionType;

public class MouseEventListener implements NativeMouseInputListener, NativeMouseWheelListener {
	//If any 
	private PrintWriter out;

	public MouseEventListener(PrintWriter out) {
		this.out = out;
	}
	
	public void startListening() {
		try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
            return;
        }

        GlobalScreen.addNativeMouseListener(new MouseEventListener(out));
        GlobalScreen.addNativeMouseMotionListener(new MouseEventListener(out));
        GlobalScreen.addNativeMouseWheelListener(new MouseEventListener(out));	
	}
	
	@Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        out.println( ActionType.MOUSE + ":" +  ActionType.CLICKED);
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        out.println( ActionType.MOUSE + ":" + ActionType.PRESSED);
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        out.println( ActionType.MOUSE + ":" + ActionType.RELEASED);
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {
        out.println(ActionType.MOUSE + ":" + ActionType.MOVED + ":" + e.getX() + ":" + e.getY());
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {
        out.println( ActionType.MOUSE + ":" + ActionType.DRAGGED + ":" + e.getX() + ":" + e.getY());
    }

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
    	//positive -> down
    	//negative -> up
        System.out.println( ActionType.MOUSE + ":" + ActionType.SCROLLED + ":" + e.getWheelRotation());
    }
}
