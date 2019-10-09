package com.huyg.autumn;

import android.content.Context;

import org.luaj.vm2.Globals;
import org.luaj.vm2.lib.ResourceFinder;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.InputStream;

/**
 * Created by huyg on 2019-10-09.
 */
public class LuaLoader implements ResourceFinder {


    private static Globals globals;

    public static LuaLoader getInstance() {
        return new LuaLoader();
    }

    public LuaLoader() {
        LuaLoader.globals = JsePlatform.standardGlobals();
        LuaLoader.globals.finder = this;
    }

    public Globals getGlobals() {
        return globals;
    }

    @Override
    public InputStream findResource(String filename) {
        try {
            return App.getInstance().getAssets().open(filename);
        } catch (java.io.IOException ioe) {
            return null;
        }
    }
}
