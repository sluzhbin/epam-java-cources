package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GraphImpl implements Graph {

    private List<VertexImpl> vertexList;
    private Map<Integer, List<Integer>> graphMap = new TreeMap<>();
    private int countOfVertexes;

    /**
     * Constructor for a class.
     * Create new instance of Graph.
     *
     * @param countOfVertexes - number of vertices
     */
    public GraphImpl(int countOfVertexes) {
        graphMap = new TreeMap<>();
        this.countOfVertexes = countOfVertexes;
        this.vertexList = new ArrayList<>(countOfVertexes);
    }

    @Override
    public void createVertex(int id, int x, int y) {
        if (countOfVertexes == vertexList.size()) {
            throw new IllegalArgumentException();
        }
        VertexImpl vert = new VertexImpl(id, x, y);
        vertexList.add(vert);
        graphMap.put(id, new ArrayList<>());
    }

    @Override
    public void connectVertices(int fromId, int toId) {
        graphMap.get(fromId).add(toId);
    }

    public VertexImpl getVertexById(int id) {
        return vertexList.get(id);
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return graphMap;
    }
}
