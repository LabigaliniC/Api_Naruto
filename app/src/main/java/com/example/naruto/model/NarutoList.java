package com.example.naruto.model;

import java.util.List;

public class NarutoList {
    private List<Naruto> results;

    public NarutoList(List<Naruto> results) {
        this.results = results;
    }

    public List<Naruto> getResults() {
        return results;
    }

    public void setResults(List<Naruto> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "NarutoList{" +
                "results=" + results +
                '}';
    }
}
