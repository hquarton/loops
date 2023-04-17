package org.example.samples;

import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;

@State(Scope.Benchmark)
public class SampleString extends BenchMarkList{
    
    private static List<String> list = new ArrayList<>();

    public SampleString(){}
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Param({ "1", "10", "100", "1000", "10000", "100000", "1000000"})
    public int listSize;

    @Setup(Level.Trial)
    public void setUp() {
        for(int i=0; i < this.listSize; i++)
        {
            list.add(RandomStringUtils.randomAlphanumeric(i % 255));
        }
    }

    @Override
    List<String> getList() {
        return list;
    }
}
