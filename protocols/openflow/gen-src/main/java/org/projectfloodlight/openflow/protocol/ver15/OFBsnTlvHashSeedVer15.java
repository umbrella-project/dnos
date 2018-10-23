// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver15;

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

class OFBsnTlvHashSeedVer15 implements OFBsnTlvHashSeed {
    private static final Logger logger = LoggerFactory.getLogger(OFBsnTlvHashSeedVer15.class);
    // version: 1.5
    final static byte WIRE_VERSION = 6;
    final static int LENGTH = 12;

        private final static long DEFAULT_SEED1 = 0x0L;
        private final static long DEFAULT_SEED2 = 0x0L;

    // OF message fields
    private final long seed1;
    private final long seed2;
//
    // Immutable default instance
    final static OFBsnTlvHashSeedVer15 DEFAULT = new OFBsnTlvHashSeedVer15(
        DEFAULT_SEED1, DEFAULT_SEED2
    );

    // package private constructor - used by readers, builders, and factory
    OFBsnTlvHashSeedVer15(long seed1, long seed2) {
        this.seed1 = seed1;
        this.seed2 = seed2;
    }

    // Accessors for OF message fields
    @Override
    public int getType() {
        return 0x64;
    }

    @Override
    public long getSeed1() {
        return seed1;
    }

    @Override
    public long getSeed2() {
        return seed2;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_15;
    }



    public OFBsnTlvHashSeed.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFBsnTlvHashSeed.Builder {
        final OFBsnTlvHashSeedVer15 parentMessage;

        // OF message fields
        private boolean seed1Set;
        private long seed1;
        private boolean seed2Set;
        private long seed2;

        BuilderWithParent(OFBsnTlvHashSeedVer15 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public int getType() {
        return 0x64;
    }

    @Override
    public long getSeed1() {
        return seed1;
    }

    @Override
    public OFBsnTlvHashSeed.Builder setSeed1(long seed1) {
        this.seed1 = seed1;
        this.seed1Set = true;
        return this;
    }
    @Override
    public long getSeed2() {
        return seed2;
    }

    @Override
    public OFBsnTlvHashSeed.Builder setSeed2(long seed2) {
        this.seed2 = seed2;
        this.seed2Set = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_15;
    }



        @Override
        public OFBsnTlvHashSeed build() {
                long seed1 = this.seed1Set ? this.seed1 : parentMessage.seed1;
                long seed2 = this.seed2Set ? this.seed2 : parentMessage.seed2;

                //
                return new OFBsnTlvHashSeedVer15(
                    seed1,
                    seed2
                );
        }

    }

    static class Builder implements OFBsnTlvHashSeed.Builder {
        // OF message fields
        private boolean seed1Set;
        private long seed1;
        private boolean seed2Set;
        private long seed2;

    @Override
    public int getType() {
        return 0x64;
    }

    @Override
    public long getSeed1() {
        return seed1;
    }

    @Override
    public OFBsnTlvHashSeed.Builder setSeed1(long seed1) {
        this.seed1 = seed1;
        this.seed1Set = true;
        return this;
    }
    @Override
    public long getSeed2() {
        return seed2;
    }

    @Override
    public OFBsnTlvHashSeed.Builder setSeed2(long seed2) {
        this.seed2 = seed2;
        this.seed2Set = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_15;
    }

//
        @Override
        public OFBsnTlvHashSeed build() {
            long seed1 = this.seed1Set ? this.seed1 : DEFAULT_SEED1;
            long seed2 = this.seed2Set ? this.seed2 : DEFAULT_SEED2;


            return new OFBsnTlvHashSeedVer15(
                    seed1,
                    seed2
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFBsnTlvHashSeed> {
        @Override
        public OFBsnTlvHashSeed readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 0x64
            short type = bb.readShort();
            if(type != (short) 0x64)
                throw new OFParseError("Wrong type: Expected=0x64(0x64), got="+type);
            int length = U16.f(bb.readShort());
            if(length != 12)
                throw new OFParseError("Wrong length: Expected=12(12), got="+length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            long seed1 = U32.f(bb.readInt());
            long seed2 = U32.f(bb.readInt());

            OFBsnTlvHashSeedVer15 bsnTlvHashSeedVer15 = new OFBsnTlvHashSeedVer15(
                    seed1,
                      seed2
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", bsnTlvHashSeedVer15);
            return bsnTlvHashSeedVer15;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFBsnTlvHashSeedVer15Funnel FUNNEL = new OFBsnTlvHashSeedVer15Funnel();
    static class OFBsnTlvHashSeedVer15Funnel implements Funnel<OFBsnTlvHashSeedVer15> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFBsnTlvHashSeedVer15 message, PrimitiveSink sink) {
            // fixed value property type = 0x64
            sink.putShort((short) 0x64);
            // fixed value property length = 12
            sink.putShort((short) 0xc);
            sink.putLong(message.seed1);
            sink.putLong(message.seed2);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFBsnTlvHashSeedVer15> {
        @Override
        public void write(ByteBuf bb, OFBsnTlvHashSeedVer15 message) {
            // fixed value property type = 0x64
            bb.writeShort((short) 0x64);
            // fixed value property length = 12
            bb.writeShort((short) 0xc);
            bb.writeInt(U32.t(message.seed1));
            bb.writeInt(U32.t(message.seed2));


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFBsnTlvHashSeedVer15(");
        b.append("seed1=").append(seed1);
        b.append(", ");
        b.append("seed2=").append(seed2);
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
        OFBsnTlvHashSeedVer15 other = (OFBsnTlvHashSeedVer15) obj;

        if( seed1 != other.seed1)
            return false;
        if( seed2 != other.seed2)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime *  (int) (seed1 ^ (seed1 >>> 32));
        result = prime *  (int) (seed2 ^ (seed2 >>> 32));
        return result;
    }

}
