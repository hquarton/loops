package org.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;

public class LoopsMain {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    private static List<Integer> list = new ArrayList<>();
    static
    {
        for(int i=0; i < 100; i++)
        {
            list.add(i);
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingStream(Blackhole blackhole) {
        list.stream().forEach(blackhole::consume);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingIterator(Blackhole blackhole) {
        list.listIterator().forEachRemaining(blackhole::consume);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingForEachLoop(Blackhole blackhole) {
        for(Integer i : list)
        {
            blackhole.consume(i);
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingSimpleForLoop(Blackhole blackhole) {
        for(int i = 0; i < list.size() ; i++)
        {
            blackhole.consume(list.get(i));
        }
    }
}