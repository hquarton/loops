package org.example.samples;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
public class SampleInteger extends  BenchMarkList {

    private static List<Integer> list = new ArrayList<>();

    public SampleInteger() {}
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Param({ "1", "10", "100", "1000", "10000", "100000", "1000000"})
    public int listSize;

    @Setup(Level.Trial)
    public void setUp() {
        list = new Random()
                .ints()
                .limit(listSize)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    List<Integer> getList() {
        return list;
    }
}
