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

class OFOxmConnTrackingIpv6SrcVer13 implements OFOxmConnTrackingIpv6Src {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmConnTrackingIpv6SrcVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int LENGTH = 20;

        private final static IPv6Address DEFAULT_VALUE = IPv6Address.NONE;

    // OF message fields
    private final IPv6Address value;
//
    // Immutable default instance
    final static OFOxmConnTrackingIpv6SrcVer13 DEFAULT = new OFOxmConnTrackingIpv6SrcVer13(
        DEFAULT_VALUE
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmConnTrackingIpv6SrcVer13(IPv6Address value) {
        if(value == null) {
            throw new NullPointerException("OFOxmConnTrackingIpv6SrcVer13: property value cannot be null");
        }
        this.value = value;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x1f410L;
    }

    @Override
    public IPv6Address getValue() {
        return value;
    }

    @Override
    public MatchField<IPv6Address> getMatchField() {
        return MatchField.CONN_TRACKING_IPV6_SRC;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    public OFOxm<IPv6Address> getCanonical() {
        // exact match OXM is always canonical
        return this;
    }

    @Override
    public IPv6Address getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFOxmConnTrackingIpv6Src.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmConnTrackingIpv6Src.Builder {
        final OFOxmConnTrackingIpv6SrcVer13 parentMessage;

        // OF message fields
        private boolean valueSet;
        private IPv6Address value;

        BuilderWithParent(OFOxmConnTrackingIpv6SrcVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x1f410L;
    }

    @Override
    public IPv6Address getValue() {
        return value;
    }

    @Override
    public OFOxmConnTrackingIpv6Src.Builder setValue(IPv6Address value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public MatchField<IPv6Address> getMatchField() {
        return MatchField.CONN_TRACKING_IPV6_SRC;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    @Override
    public OFOxm<IPv6Address> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.3");
    }

    @Override
    public IPv6Address getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFOxmConnTrackingIpv6Src build() {
                IPv6Address value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");

                //
                return new OFOxmConnTrackingIpv6SrcVer13(
                    value
                );
        }

    }

    static class Builder implements OFOxmConnTrackingIpv6Src.Builder {
        // OF message fields
        private boolean valueSet;
        private IPv6Address value;

    @Override
    public long getTypeLen() {
        return 0x1f410L;
    }

    @Override
    public IPv6Address getValue() {
        return value;
    }

    @Override
    public OFOxmConnTrackingIpv6Src.Builder setValue(IPv6Address value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public MatchField<IPv6Address> getMatchField() {
        return MatchField.CONN_TRACKING_IPV6_SRC;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    @Override
    public OFOxm<IPv6Address> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.3");
    }

    @Override
    public IPv6Address getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

//
        @Override
        public OFOxmConnTrackingIpv6Src build() {
            IPv6Address value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");


            return new OFOxmConnTrackingIpv6SrcVer13(
                    value
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmConnTrackingIpv6Src> {
        @Override
        public OFOxmConnTrackingIpv6Src readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x1f410L
            int typeLen = bb.readInt();
            if(typeLen != 0x1f410)
                throw new OFParseError("Wrong typeLen: Expected=0x1f410L(0x1f410L), got="+typeLen);
            IPv6Address value = IPv6Address.read16Bytes(bb);

            OFOxmConnTrackingIpv6SrcVer13 oxmConnTrackingIpv6SrcVer13 = new OFOxmConnTrackingIpv6SrcVer13(
                    value
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmConnTrackingIpv6SrcVer13);
            return oxmConnTrackingIpv6SrcVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmConnTrackingIpv6SrcVer13Funnel FUNNEL = new OFOxmConnTrackingIpv6SrcVer13Funnel();
    static class OFOxmConnTrackingIpv6SrcVer13Funnel implements Funnel<OFOxmConnTrackingIpv6SrcVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmConnTrackingIpv6SrcVer13 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x1f410L
            sink.putInt(0x1f410);
            message.value.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmConnTrackingIpv6SrcVer13> {
        @Override
        public void write(ByteBuf bb, OFOxmConnTrackingIpv6SrcVer13 message) {
            // fixed value property typeLen = 0x1f410L
            bb.writeInt(0x1f410);
            message.value.write16Bytes(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmConnTrackingIpv6SrcVer13(");
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
        OFOxmConnTrackingIpv6SrcVer13 other = (OFOxmConnTrackingIpv6SrcVer13) obj;

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
