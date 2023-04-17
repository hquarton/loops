package org.example.samples;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Fork(value = 5, warmups = 5)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
abstract class BenchMarkList {

    abstract List<?> getList();


    @Benchmark
    public void usingStream(Blackhole blackhole) {
        this.getList().stream().forEach(blackhole::consume);
    }

    @Benchmark
    public void usingIterator(Blackhole blackhole) {
        this.getList().listIterator().forEachRemaining(blackhole::consume);
    }

    @Benchmark
    public void usingForEachLoop(Blackhole blackhole) {
        for (Object i : this.getList()) {
            blackhole.consume(i);
        }
    }

    @Benchmark
    public void usingSimpleForLoop(Blackhole blackhole) {
        for (int i = 0; i < this.getList().size(); i++) {
            blackhole.consume(this.getList().get(i));
        }
    }
}
