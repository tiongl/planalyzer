package com.dremio.planalyzer;

import java.util.HashMap;
import java.util.Map;

class PrintOption {
    boolean showRowType = false;
    boolean showCost = false;
    boolean showEqList = false;

    boolean showCharacterSet = false;

    public boolean showEverything(){
        return true;
    }
}
