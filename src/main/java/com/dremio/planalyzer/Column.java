package com.dremio.planalyzer;

class Column {
    private String name;
    private Column source;
    private String expression;

    private String tbName;

    Column(String name, Column source) {
        this(name, source, null);
    }

    Column(String name, Column source, String expression) {
        this(name, source, expression, null);
    }


    Column(String name, Column source, String expression, String tbName) {
        if (name == null) throw new RuntimeException();
        this.name = name;
        this.source = source;
        this.expression = expression;
        this.tbName = tbName;
    }

    public Column root() {
        if (source == null) {
            return this;
        } else {
            return source.root();
        }
    }

    public String getName() {
        return name;
    }

    public String getName(boolean withTbName) {
        if (withTbName && tbName != null) {
            return tbName + "." + name;
        } else {
            return name;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
