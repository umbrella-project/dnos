// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver12;

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

class OFOxmArpOpMaskedVer12 implements OFOxmArpOpMasked {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmArpOpMaskedVer12.class);
    // version: 1.2
    final static byte WIRE_VERSION = 3;
    final static int LENGTH = 8;

        private final static ArpOpcode DEFAULT_VALUE = ArpOpcode.NONE;
        private final static ArpOpcode DEFAULT_VALUE_MASK = ArpOpcode.NONE;

    // OF message fields
    private final ArpOpcode value;
    private final ArpOpcode mask;
//
    // Immutable default instance
    final static OFOxmArpOpMaskedVer12 DEFAULT = new OFOxmArpOpMaskedVer12(
        DEFAULT_VALUE, DEFAULT_VALUE_MASK
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmArpOpMaskedVer12(ArpOpcode value, ArpOpcode mask) {
        if(value == null) {
            throw new NullPointerException("OFOxmArpOpMaskedVer12: property value cannot be null");
        }
        if(mask == null) {
            throw new NullPointerException("OFOxmArpOpMaskedVer12: property mask cannot be null");
        }
        this.value = value;
        this.mask = mask;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x80002b04L;
    }

    @Override
    public ArpOpcode getValue() {
        return value;
    }

    @Override
    public ArpOpcode getMask() {
        return mask;
    }

    @Override
    public MatchField<ArpOpcode> getMatchField() {
        return MatchField.ARP_OP;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    public OFOxm<ArpOpcode> getCanonical() {
        if (ArpOpcode.NO_MASK.equals(mask)) {
            return new OFOxmArpOpVer12(value);
        } else if(ArpOpcode.FULL_MASK.equals(mask)) {
            return null;
        } else {
            return this;
        }
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



    public OFOxmArpOpMasked.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmArpOpMasked.Builder {
        final OFOxmArpOpMaskedVer12 parentMessage;

        // OF message fields
        private boolean valueSet;
        private ArpOpcode value;
        private boolean maskSet;
        private ArpOpcode mask;

        BuilderWithParent(OFOxmArpOpMaskedVer12 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x80002b04L;
    }

    @Override
    public ArpOpcode getValue() {
        return value;
    }

    @Override
    public OFOxmArpOpMasked.Builder setValue(ArpOpcode value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public ArpOpcode getMask() {
        return mask;
    }

    @Override
    public OFOxmArpOpMasked.Builder setMask(ArpOpcode mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<ArpOpcode> getMatchField() {
        return MatchField.ARP_OP;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<ArpOpcode> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



        @Override
        public OFOxmArpOpMasked build() {
                ArpOpcode value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");
                ArpOpcode mask = this.maskSet ? this.mask : parentMessage.mask;
                if(mask == null)
                    throw new NullPointerException("Property mask must not be null");

                //
                return new OFOxmArpOpMaskedVer12(
                    value,
                    mask
                );
        }

    }

    static class Builder implements OFOxmArpOpMasked.Builder {
        // OF message fields
        private boolean valueSet;
        private ArpOpcode value;
        private boolean maskSet;
        private ArpOpcode mask;

    @Override
    public long getTypeLen() {
        return 0x80002b04L;
    }

    @Override
    public ArpOpcode getValue() {
        return value;
    }

    @Override
    public OFOxmArpOpMasked.Builder setValue(ArpOpcode value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public ArpOpcode getMask() {
        return mask;
    }

    @Override
    public OFOxmArpOpMasked.Builder setMask(ArpOpcode mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<ArpOpcode> getMatchField() {
        return MatchField.ARP_OP;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<ArpOpcode> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }

//
        @Override
        public OFOxmArpOpMasked build() {
            ArpOpcode value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");
            ArpOpcode mask = this.maskSet ? this.mask : DEFAULT_VALUE_MASK;
            if(mask == null)
                throw new NullPointerException("Property mask must not be null");


            return new OFOxmArpOpMaskedVer12(
                    value,
                    mask
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmArpOpMasked> {
        @Override
        public OFOxmArpOpMasked readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x80002b04L
            int typeLen = bb.readInt();
            if(typeLen != (int) 0x80002b04)
                throw new OFParseError("Wrong typeLen: Expected=0x80002b04L(0x80002b04L), got="+typeLen);
            ArpOpcode value = ArpOpcode.read2Bytes(bb);
            ArpOpcode mask = ArpOpcode.read2Bytes(bb);

            OFOxmArpOpMaskedVer12 oxmArpOpMaskedVer12 = new OFOxmArpOpMaskedVer12(
                    value,
                      mask
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmArpOpMaskedVer12);
            return oxmArpOpMaskedVer12;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmArpOpMaskedVer12Funnel FUNNEL = new OFOxmArpOpMaskedVer12Funnel();
    static class OFOxmArpOpMaskedVer12Funnel implements Funnel<OFOxmArpOpMaskedVer12> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmArpOpMaskedVer12 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x80002b04L
            sink.putInt((int) 0x80002b04);
            message.value.putTo(sink);
            message.mask.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmArpOpMaskedVer12> {
        @Override
        public void write(ByteBuf bb, OFOxmArpOpMaskedVer12 message) {
            // fixed value property typeLen = 0x80002b04L
            bb.writeInt((int) 0x80002b04);
            message.value.write2Bytes(bb);
            message.mask.write2Bytes(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmArpOpMaskedVer12(");
        b.append("value=").append(value);
        b.append(", ");
        b.append("mask=").append(mask);
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
        OFOxmArpOpMaskedVer12 other = (OFOxmArpOpMaskedVer12) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (mask == null) {
            if (other.mask != null)
                return false;
        } else if (!mask.equals(other.mask))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((mask == null) ? 0 : mask.hashCode());
        return result;
    }

}