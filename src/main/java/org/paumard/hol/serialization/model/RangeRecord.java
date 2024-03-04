package org.paumard.hol.serialization.model;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

public record RangeRecord(int begin, int end) implements Serializable {

    public RangeRecord {
//        if (begin > end) {
//            throw new IllegalArgumentException("Begin should be lesser than end");
//        }
    }

    @Serial
    private Object readResolve() throws ObjectStreamException {
        return new RangeLegacy(this.begin, this.end);
    }
}
