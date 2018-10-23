// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver13;

import org.projectfloodlight.openflow.protocol.*;
import org.projectfloodlight.openflow.protocol.action.*;
import org.projectfloodlight.openflow.protocol.actionid.*;
import org.projectfloodlight.openflow.protocol.bsntlv.*;
import org.projectfloodlight.openflow.protocol.errormsg.*;
import org.projectfloodlight.openflow.protocol.meterband.*;
import org.projectfloodlight.openflow.protocol.instruction.*;
import org.projectfloodlight.openflow.protocol.instructionid.*;
import org.projectfloodlight.openflow.protocol.match.*;
import org.projectfloodlight.openflow.protocol.stat.*;
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.oxs.*;
import org.projectfloodlight.openflow.protocol.queueprop.*;
import org.projectfloodlight.openflow.types.*;
import org.projectfloodlight.openflow.util.*;
import org.projectfloodlight.openflow.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFOxmConnTrackingMarkVer13 implements OFOxmConnTrackingMark {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmConnTrackingMarkVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int LENGTH = 8;

        private final static U32 DEFAULT_VALUE = U32.ZERO;

    // OF message fields
    private final U32 value;
//
    // Immutable default instance
    final static OFOxmConnTrackingMarkVer13 DEFAULT = new OFOxmConnTrackingMarkVer13(
        DEFAULT_VALUE
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmConnTrackingMarkVer13(U32 value) {
        if(value == null) {
            throw new NullPointerException("OFOxmConnTrackingMarkVer13: property value cannot be null");
        }
        this.value = value;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x1d604L;
    }

    @Override
    public U32 getValue() {
        return value;
    }

    @Override
    public MatchField<U32> getMatchField() {
        return MatchField.CONN_TRACKING_MARK;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    public OFOxm<U32> getCanonical() {
        // exact match OXM is always canonical
        return this;
    }

    @Override
    public U32 getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFOxmConnTrackingMark.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmConnTrackingMark.Builder {
        final OFOxmConnTrackingMarkVer13 parentMessage;

        // OF message fields
        private boolean valueSet;
        private U32 value;

        BuilderWithParent(OFOxmConnTrackingMarkVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x1d604L;
    }

    @Override
    public U32 getValue() {
        return value;
    }

    @Override
    public OFOxmConnTrackingMark.Builder setValue(U32 value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public MatchField<U32> getMatchField() {
        return MatchField.CONN_TRACKING_MARK;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    @Override
    public OFOxm<U32> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.3");
    }

    @Override
    public U32 getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFOxmConnTrackingMark build() {
                U32 value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");

                //
                return new OFOxmConnTrackingMarkVer13(
                    value
                );
        }

    }

    static class Builder implements OFOxmConnTrackingMark.Builder {
        // OF message fields
        private boolean valueSet;
        private U32 value;

    @Override
    public long getTypeLen() {
        return 0x1d604L;
    }

    @Override
    public U32 getValue() {
        return value;
    }

    @Override
    public OFOxmConnTrackingMark.Builder setValue(U32 value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public MatchField<U32> getMatchField() {
        return MatchField.CONN_TRACKING_MARK;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    @Override
    public OFOxm<U32> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.3");
    }

    @Override
    public U32 getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

//
        @Override
        public OFOxmConnTrackingMark build() {
            U32 value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");


            return new OFOxmConnTrackingMarkVer13(
                    value
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmConnTrackingMark> {
        @Override
        public OFOxmConnTrackingMark readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x1d604L
            int typeLen = bb.readInt();
            if(typeLen != 0x1d604)
                throw new OFParseError("Wrong typeLen: Expected=0x1d604L(0x1d604L), got="+typeLen);
            U32 value = U32.of(bb.readInt());

            OFOxmConnTrackingMarkVer13 oxmConnTrackingMarkVer13 = new OFOxmConnTrackingMarkVer13(
                    value
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmConnTrackingMarkVer13);
            return oxmConnTrackingMarkVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmConnTrackingMarkVer13Funnel FUNNEL = new OFOxmConnTrackingMarkVer13Funnel();
    static class OFOxmConnTrackingMarkVer13Funnel implements Funnel<OFOxmConnTrackingMarkVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmConnTrackingMarkVer13 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x1d604L
            sink.putInt(0x1d604);
            message.value.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmConnTrackingMarkVer13> {
        @Override
        public void write(ByteBuf bb, OFOxmConnTrackingMarkVer13 message) {
            // fixed value property typeLen = 0x1d604L
            bb.writeInt(0x1d604);
            bb.writeInt(message.value.getRaw());


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmConnTrackingMarkVer13(");
        b.append("value=").append(value);
        b.append(")");
        return b.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OFOxmConnTrackingMarkVer13 other = (OFOxmConnTrackingMarkVer13) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

}
