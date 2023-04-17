package org.example.samples;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.samples.dto.ValueDTO;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;

@State(Scope.Benchmark)
public class SampleDTO extends  BenchMarkList {

    private static List<ValueDTO> list = new ArrayList<>();

    public SampleDTO() {
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Param({"1", "10", "100", "1000", "10000", "100000", "1000000"})
    public int listSize;

    @Setup(Level.Trial)
    public void setUp() {
        for (int i = 0; i < this.listSize; i++) {
            ValueDTO valueDTO = new ValueDTO()
                    .setValue(RandomStringUtils.randomAlphanumeric(i % 255))
                    .setValidite(RandomStringUtils.randomAlphanumeric(i % 255))
                    .setSource(RandomStringUtils.randomAlphanumeric(i % 255))
                    .setName(RandomStringUtils.randomAlphanumeric(i % 255))
                    .setNormal(i % 2 == 0 ? Boolean.TRUE : Boolean.FALSE)
                    .setCorrected(i % 4 == 0 ? Boolean.TRUE : Boolean.FALSE);
            list.add(valueDTO);
        }
    }

    @Override
    List<ValueDTO> getList() {
        return list;
    }
}