package com.example.prueba_byte.Model;

public class Movie {
    private int id;
    private String type;
    private String name;
    private String ppu;
    private String batters;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPpu() {
        return ppu;
    }

    public String getBatters() {
        return batters;
    }

    public int getTitulo() {
        return 0;
    }

    public byte[] getPortada() {
        return new byte[0];
    }
}
