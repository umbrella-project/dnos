// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver14;

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

class OFOxmConnTrackingIpv6DstMaskedVer14 implements OFOxmConnTrackingIpv6DstMasked {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmConnTrackingIpv6DstMaskedVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int LENGTH = 36;

        private final static IPv6Address DEFAULT_VALUE = IPv6Address.NONE;
        private final static IPv6Address DEFAULT_VALUE_MASK = IPv6Address.NONE;

    // OF message fields
    private final IPv6Address value;
    private final IPv6Address mask;
//
    // Immutable default instance
    final static OFOxmConnTrackingIpv6DstMaskedVer14 DEFAULT = new OFOxmConnTrackingIpv6DstMaskedVer14(
        DEFAULT_VALUE, DEFAULT_VALUE_MASK
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmConnTrackingIpv6DstMaskedVer14(IPv6Address value, IPv6Address mask) {
        if(value == null) {
            throw new NullPointerException("OFOxmConnTrackingIpv6DstMaskedVer14: property value cannot be null");
        }
        if(mask == null) {
            throw new NullPointerException("OFOxmConnTrackingIpv6DstMaskedVer14: property mask cannot be null");
        }
        this.value = value;
        this.mask = mask;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x1f720L;
    }

    @Override
    public IPv6Address getValue() {
        return value;
    }

    @Override
    public IPv6Address getMask() {
        return mask;
    }

    @Override
    public MatchField<IPv6Address> getMatchField() {
        return MatchField.CONN_TRACKING_IPV6_DST;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    public OFOxm<IPv6Address> getCanonical() {
        if (IPv6Address.NO_MASK.equals(mask)) {
            return new OFOxmConnTrackingIpv6DstVer14(value);
        } else if(IPv6Address.FULL_MASK.equals(mask)) {
            return null;
        } else {
            return this;
        }
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFOxmConnTrackingIpv6DstMasked.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmConnTrackingIpv6DstMasked.Builder {
        final OFOxmConnTrackingIpv6DstMaskedVer14 parentMessage;

        // OF message fields
        private boolean valueSet;
        private IPv6Address value;
        private boolean maskSet;
        private IPv6Address mask;

        BuilderWithParent(OFOxmConnTrackingIpv6DstMaskedVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x1f720L;
    }

    @Override
    public IPv6Address getValue() {
        return value;
    }

    @Override
    public OFOxmConnTrackingIpv6DstMasked.Builder setValue(IPv6Address value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public IPv6Address getMask() {
        return mask;
    }

    @Override
    public OFOxmConnTrackingIpv6DstMasked.Builder setMask(IPv6Address mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<IPv6Address> getMatchField() {
        return MatchField.CONN_TRACKING_IPV6_DST;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<IPv6Address> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.4");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFOxmConnTrackingIpv6DstMasked build() {
                IPv6Address value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");
                IPv6Address mask = this.maskSet ? this.mask : parentMessage.mask;
                if(mask == null)
                    throw new NullPointerException("Property mask must not be null");

                //
                return new OFOxmConnTrackingIpv6DstMaskedVer14(
                    value,
                    mask
                );
        }

    }

    static class Builder implements OFOxmConnTrackingIpv6DstMasked.Builder {
        // OF message fields
        private boolean valueSet;
        private IPv6Address value;
        private boolean maskSet;
        private IPv6Address mask;

    @Override
    public long getTypeLen() {
        return 0x1f720L;
    }

    @Override
    public IPv6Address getValue() {
        return value;
    }

    @Override
    public OFOxmConnTrackingIpv6DstMasked.Builder setValue(IPv6Address value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public IPv6Address getMask() {
        return mask;
    }

    @Override
    public OFOxmConnTrackingIpv6DstMasked.Builder setMask(IPv6Address mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<IPv6Address> getMatchField() {
        return MatchField.CONN_TRACKING_IPV6_DST;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<IPv6Address> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.4");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFOxmConnTrackingIpv6DstMasked build() {
            IPv6Address value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");
            IPv6Address mask = this.maskSet ? this.mask : DEFAULT_VALUE_MASK;
            if(mask == null)
                throw new NullPointerException("Property mask must not be null");


            return new OFOxmConnTrackingIpv6DstMaskedVer14(
                    value,
                    mask
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmConnTrackingIpv6DstMasked> {
        @Override
        public OFOxmConnTrackingIpv6DstMasked readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x1f720L
            int typeLen = bb.readInt();
            if(typeLen != 0x1f720)
                throw new OFParseError("Wrong typeLen: Expected=0x1f720L(0x1f720L), got="+typeLen);
            IPv6Address value = IPv6Address.read16Bytes(bb);
            IPv6Address mask = IPv6Address.read16Bytes(bb);

            OFOxmConnTrackingIpv6DstMaskedVer14 oxmConnTrackingIpv6DstMaskedVer14 = new OFOxmConnTrackingIpv6DstMaskedVer14(
                    value,
                      mask
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmConnTrackingIpv6DstMaskedVer14);
            return oxmConnTrackingIpv6DstMaskedVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmConnTrackingIpv6DstMaskedVer14Funnel FUNNEL = new OFOxmConnTrackingIpv6DstMaskedVer14Funnel();
    static class OFOxmConnTrackingIpv6DstMaskedVer14Funnel implements Funnel<OFOxmConnTrackingIpv6DstMaskedVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmConnTrackingIpv6DstMaskedVer14 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x1f720L
            sink.putInt(0x1f720);
            message.value.putTo(sink);
            message.mask.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmConnTrackingIpv6DstMaskedVer14> {
        @Override
        public void write(ByteBuf bb, OFOxmConnTrackingIpv6DstMaskedVer14 message) {
            // fixed value property typeLen = 0x1f720L
            bb.writeInt(0x1f720);
            message.value.write16Bytes(bb);
            message.mask.write16Bytes(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmConnTrackingIpv6DstMaskedVer14(");
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
        OFOxmConnTrackingIpv6DstMaskedVer14 other = (OFOxmConnTrackingIpv6DstMaskedVer14) obj;

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