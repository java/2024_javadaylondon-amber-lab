package org.paumard.hol.serialization.model;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

public class RangeLegacy implements Serializable {

    private final int begin;
    private final int end;

    public RangeLegacy(int begin, int end) {
//        if (begin > end) {
//            throw new IllegalArgumentException("Begin should be lesser than end");
//        }
        this.begin = begin;
        this.end = end;
    }

    public int begin() {
        return begin;
    }

    public int end() {
        return end;
    }

    @Serial
    private Object writeReplace() throws ObjectStreamException {
        return new RangeRecord(this.begin, this.end);
    }

    @Override
    public String toString() {
        return "RangeLegacy[" +
                "begin=" + begin +
                ", end=" + end +
                ']';
    }
}
